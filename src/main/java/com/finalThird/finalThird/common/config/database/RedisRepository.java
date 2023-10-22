package com.finalThird.finalThird.common.config.database;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.concurrent.TimeUnit;

@Repository
@RequiredArgsConstructor
public class RedisRepository {
  private final RedisTemplate<String, String> redisTemplate;

  public void setValue(String key, String value, Long timeout, TimeUnit unit) {
    redisTemplate.opsForValue().set(key, value, timeout, unit);
  }

  public String getValue(String key) {
    return redisTemplate.opsForValue().get(key);
  }

  public void delValue(String key) {
    redisTemplate.delete(key);
  }
}
