package bj.practice.humous.redis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedisController {
	
	@Autowired
	private RedisTemplate<String, String> redis;
	
	@PostMapping("/add")
	public ResponseEntity<?> addKeyValue(String key, String value) {
		ValueOperations<String, String> vop = redis.opsForValue();
		vop.set(key, value);
		
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
}