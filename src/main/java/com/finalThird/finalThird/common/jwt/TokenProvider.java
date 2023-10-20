package com.finalThird.finalThird.common.jwt;


import com.finalThird.finalThird.auth.controller.dto.Token;
import com.finalThird.finalThird.common.config.database.RedisRepository;
import com.finalThird.finalThird.common.exception.ApiException;
import com.finalThird.finalThird.common.exception.AuthException;
import com.finalThird.finalThird.common.exception.ErrorCode;
import com.finalThird.finalThird.customer.domain.Customer;
import com.finalThird.finalThird.customer.external.CustomerRepository;
import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.security.Key;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@Slf4j
@Component
@RequiredArgsConstructor
public class TokenProvider implements InitializingBean {

  private final RedisTemplate<String, String> redisTemplate;

  private final Logger logger = LoggerFactory.getLogger(TokenProvider.class);
  private static final String AUTHORITIES_KEY = "auth";

  @Value("${jwt.response.header}")
  private String accessHeader;

  @Value("${jwt.secret}")
  private String secret;
  private final long accessTokenTime = (1000L * 60 * 30); // 30분;
  private final long refreshTokenTime = (1000L * 60 * 60 * 24 * 7); // 1주;
  private Key key;
  private final RedisRepository redisRepository;
  private final CustomerRepository customerReader;


  // 빈이 생성되고 주입을 받은 후에 secret값을 Base64 Decode해서 key 변수에 할당하기 위해
  @Override
  public void afterPropertiesSet() {
    byte[] keyBytes = Decoders.BASE64.decode(secret);
    this.key = Keys.hmacShaKeyFor(keyBytes);
  }

  public String createAccessToken(Authentication authentication) {
    String authorities = authentication.getAuthorities().stream()
        .map(GrantedAuthority::getAuthority)
        .collect(Collectors.joining(","));

    // 토큰의 expire 시간을 설정
    long now = (new Date()).getTime();
    Date accessTime = new Date(now + this.accessTokenTime);

    String accessToken = Jwts.builder()
        .setSubject(authentication.getName())
        .claim(AUTHORITIES_KEY, authorities) // 정보 저장
        .signWith(key, SignatureAlgorithm.HS512) // 사용할 암호화 알고리즘과 , signature 에 들어갈 secret값 세팅
        .setExpiration(accessTime) // set Expire Time 해당 옵션 안넣으면 expire안함
        .compact();



    return accessToken;
  }

  public String createAccessToken(String userPk, HashMap<String, Object> claim) {
    return createToken(userPk, claim, accessTokenTime, secret);
  }

  public String createRefreshToken(String userPk) {
    return createToken(userPk, null, refreshTokenTime, secret);
  }


  private String createToken(String userPk, HashMap<String, Object> claim, Long expiration, String secret) {
    Claims claims = Jwts.claims().setSubject(userPk); // JWT payload 에 저장되는 정보단위
    if (claim != null) {
      claims.put("userInfo", claim);
    }
    Date now = new Date();
    return Jwts.builder()
        .setHeaderParam("typ", "JWT")
        .setClaims(claims) // 정보 저장
        .setIssuedAt(now) // 토큰 발행 시간 정보
        .setExpiration(new Date(now.getTime() + expiration)) // set Expire Time
        .signWith(SignatureAlgorithm.HS256, secret)  // 사용할 암호화 알고리즘과
        // signature 에 들어갈 secret값 세팅
        .compact();
  }


  public String createRefreshToken(Authentication authentication) {
    String authorities = authentication.getAuthorities().stream()
        .map(GrantedAuthority::getAuthority)
        .collect(Collectors.joining(","));

    // 토큰의 expire 시간을 설정
    long now = (new Date()).getTime();
    Date refreshTime = new Date(now + this.refreshTokenTime);

    String refreshToken = Jwts.builder()
        .setSubject(authentication.getName())
        .claim(AUTHORITIES_KEY, authorities) // 정보 저장
        .signWith(key, SignatureAlgorithm.HS512) // 사용할 암호화 알고리즘과 , signature 에 들어갈 secret값 세팅
        .setExpiration(refreshTime) // set Expire Time 해당 옵션 안넣으면 expire안함
        .compact();

    redisTemplate.opsForValue().set(
        authentication.getName(),
        refreshToken,
        this.refreshTokenTime,
        TimeUnit.MILLISECONDS
    );
    return refreshToken;
  }








  // 토큰으로 클레임을 만들고 이를 이용해 유저 객체를 만들어서 최종적으로 authentication 객체를 리턴
  public Authentication getAuthentication(String token) {
    Claims claims = Jwts
        .parserBuilder()
        .setSigningKey(key)
        .build()
        .parseClaimsJws(token)
        .getBody();

    Collection<? extends GrantedAuthority> authorities =
        Arrays.stream(claims.get(AUTHORITIES_KEY).toString().split(","))
            .map(SimpleGrantedAuthority::new)
            .collect(Collectors.toList());

    User principal = new User(claims.getSubject(), "", authorities);

    return new UsernamePasswordAuthenticationToken(principal, token, authorities);
  }


  // 토큰의 유효성 검증을 수행
  public boolean validateToken(String token) {
    try {
      Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
      return true;
    } catch (io.jsonwebtoken.security.SecurityException | MalformedJwtException e) {

      logger.info("잘못된 JWT 서명입니다.");
    } catch (ExpiredJwtException e) {

      logger.info("만료된 JWT 토큰입니다.");
    } catch (UnsupportedJwtException e) {

      logger.info("지원되지 않는 JWT 토큰입니다.");
    } catch (IllegalArgumentException e) {

      logger.info("JWT 토큰이 잘못되었습니다.");
    }
    return false;
  }

  public void tokenAuthentication(HttpServletResponse response, String accessToken, String refreshToken) {
    if (accessToken == null && refreshToken == null) {
      return;
    }

    if (refreshToken == null) {
      accessTokenHandling(accessToken);
    } else {
      refreshTokenHandlingResponse(response, accessToken, refreshToken);
    }
  }

  private void accessTokenHandling(String accessToken) {
    if (!validateToken(accessToken)) {
      throw new AuthException(ErrorCode.INVALID_ACCESS_TOKEN);
    }

    if (SecurityContextHolder.getContext().getAuthentication() == null) {
      Authentication authentication = getAccessAuthentication(accessToken);
      SecurityContextHolder.getContext().setAuthentication(authentication);
    }

  }
  public Authentication getAccessAuthentication(String token) {
    Claims claims = Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody();
    String id = claims.getSubject();
    Customer user = customerReader.findByCustomerEmail(id).orElseThrow(() -> new ApiException(ErrorCode.USER_NOT_FOUND));

    Collection<? extends GrantedAuthority> authorities;

      authorities = Arrays.stream(user.getAuthorities().toString().split(","))
          .map(SimpleGrantedAuthority::new)
          .collect(Collectors.toList());

    return new UsernamePasswordAuthenticationToken(user, token, authorities);
  }

  private void refreshTokenHandlingResponse(HttpServletResponse response, String accessToken, String refreshToken) {

    String accessJws = refreshTokenHandling(accessToken, refreshToken);

    if (response == null) {
      return;
    }

    String header = response.getHeader(accessHeader);
    if (header == null || "".equals(header)) {
      response.addHeader(accessHeader, accessJws);
    }
  }

  private String refreshTokenHandling(String accessToken, String refreshToken) {
    if (!validateToken(refreshToken)) {
      throw new AuthException(ErrorCode.EXPIRED_REFRESH_TOKEN);
    }

    if (accessToken == null) {
      throw new AuthException(ErrorCode.INVALID_ACCESS_TOKEN);
    }

    if (!validateToken(accessToken)) {
      throw new AuthException(ErrorCode.EXPIRED_REFRESH_TOKEN);
    }

    String accessTokenDecode = decode(accessToken);
    org.json.simple.parser.JSONParser parser = new JSONParser();
    JSONObject object;
    try {
      object = (JSONObject) parser.parse(accessTokenDecode);
    } catch (ParseException e) {
      log.error("accessToken parsing error", e);
      throw new AuthException(ErrorCode.RUNTIME_EXCEPTION_TOKEN);
    }

    String id = object.get("customerEmail").toString();
    Optional<String> refreshTokenInDB = selectRefreshToken(id);

    if (refreshTokenInDB.isEmpty() || !refreshTokenInDB.get().equals(refreshToken)) {
      throw new AuthException(ErrorCode.INVALID_REFRESH_TOKEN);
    }

    Customer user = customerReader.findByCustomerEmail(id).orElseThrow(() -> new ApiException(ErrorCode.USER_NOT_FOUND));

    HashMap<String, Object> claim = new HashMap<>();

    claim.put("customerEmail", user.getCustomerEmail());
    claim.put("role", user.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.joining(",")));

    String accessJws = createAccessToken(id, claim);
    Authentication authentication = getAccessAuthentication(accessJws);
    SecurityContextHolder.getContext().setAuthentication(authentication);

    return accessJws;
  }

  public String decode(String token) {
    String[] splitToken = token.split("\\.");
    Base64.Decoder decoder = Base64.getDecoder();
    byte[] decodedBytes = decoder.decode(splitToken[1]);

    String decodedString = null;
    try {
      decodedString = new String(decodedBytes, "UTF-8");
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    }
    return decodedString;
  }

  public Optional<String> selectRefreshToken(String userId) {
    return Optional.ofNullable(redisRepository.getValue(redisRepository.getValue(userId)));
  }



}