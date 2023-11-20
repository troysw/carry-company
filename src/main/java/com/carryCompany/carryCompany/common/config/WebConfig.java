package com.carryCompany.carryCompany.common.config;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.deser.std.StringDeserializer;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalTimeSerializer;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;


@Configuration
public class WebConfig implements WebMvcConfigurer {

  @Value("${jwt.response.header}")
  private String jwtHeader;

  @Override
  public void addCorsMappings(CorsRegistry registry) {
    registry.addMapping("/**")
        .allowedOrigins("*")
        .exposedHeaders(jwtHeader, "refresh-token")
        .allowedMethods("GET", "POST", "PUT", "PATCH", "DELETE")
        .allowCredentials(false);
  }

  /*
  @Bean  //기본 페이저블 객체 설정
  public PageableHandlerMethodArgumentResolverCustomizer customize() {
    Pageable unpaged = Pageable.unpaged();
    return p -> p.setFallbackPageable(unpaged);
  }
  */

  @Bean
  public Module stringDeserializerModule() {
    SimpleModule module = new SimpleModule();
    module.addDeserializer(String.class, new StdDeserializer<>(String.class) {
      @Override
      public String deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        String result = StringDeserializer.instance.deserialize(p, ctxt);
        if (StringUtils.isEmpty(result)) {
          return null;
        }
        return result;
      }
    });
    return module;
  }

  @Bean
  public Module javaTimeModule() {
    JavaTimeModule javaTimeModule = new JavaTimeModule();

    DateTimeFormatter serializLocalDateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    DateTimeFormatter deserializLocalDateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    DateTimeFormatter localDateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    DateTimeFormatter localTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

    javaTimeModule.addSerializer(LocalDateTime.class, new LocalDateTimeSerializer(serializLocalDateTimeFormatter));
    javaTimeModule.addSerializer(LocalDate.class, new LocalDateSerializer(localDateFormatter));
    javaTimeModule.addSerializer(LocalTime.class, new LocalTimeSerializer(localTimeFormatter));

    javaTimeModule.addDeserializer(LocalDateTime.class, new JsonDeserializer<>() {
      @Override
      public LocalDateTime deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
              throws IOException {
        if (StringUtils.isBlank(jsonParser.getValueAsString())) {
          return null;
        }
        return LocalDateTime.parse(jsonParser.getValueAsString(), deserializLocalDateTimeFormatter);
      }
    });

    javaTimeModule.addDeserializer(LocalDate.class, new JsonDeserializer<>() {
      @Override
      public LocalDate deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
              throws IOException {

        if (StringUtils.isBlank(jsonParser.getValueAsString())) {
          return null;
        }
        return LocalDate.parse(jsonParser.getValueAsString(), localDateFormatter);
      }
    });

    javaTimeModule.addDeserializer(LocalTime.class, new JsonDeserializer<>() {
      @Override
      public LocalTime deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
              throws IOException {

        if (StringUtils.isBlank(jsonParser.getValueAsString())) {
          return null;
        }
        return LocalTime.parse(jsonParser.getValueAsString(), localTimeFormatter);
      }
    });

    return javaTimeModule;
  }

  @Bean
  public BCryptPasswordEncoder bCryptPasswordEncoder() {
    return new BCryptPasswordEncoder();
  }
}
