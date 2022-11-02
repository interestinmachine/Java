package com.example.springbootDataRedis;

import com.example.springbootDataRedis.redis.config.Model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;

@SpringBootTest
class SpringbootDataRedisApplicationTests {

	@Resource
	private RedisTemplate<String, Object> redisTemplate;

	@Test
	void testSpring() {
		// 插入一条 string 类型数据
		redisTemplate.opsForValue().set("name","王五");

		// 读取一条 string 类型数据
		Object name = redisTemplate.opsForValue().get("name");
		System.out.println("name = " + name);
	}

	@Test
	void testSaveUser() {
		// 写入数据
		redisTemplate.opsForValue().set("user:100",new User("张三",18));
		// 获取数据
		User o = (User)redisTemplate.opsForValue().get("user:100");
		System.out.println("o = " + o);
	}
}
