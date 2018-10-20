package com.example.redis.springredis;

import com.example.redis.springredis.model.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootApplication
public class SpringRedisApplication {

    @Bean
    JedisConnectionFactory jedisConnectionFactory() {
        // Get the connection factory in build
        return new JedisConnectionFactory();
    }

    @Bean
    RedisTemplate<String, Student> redisTemplate() {
        RedisTemplate<String, Student> redisTemplate =
            new RedisTemplate<String, Student>();
        redisTemplate.setConnectionFactory(jedisConnectionFactory());
        return null;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringRedisApplication.class, args);
    }
}
