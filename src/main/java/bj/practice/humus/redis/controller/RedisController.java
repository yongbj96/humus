package bj.practice.humus.redis.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedisController {

	@Autowired
	private RedisTemplate<String, String> redis;

	@PostMapping("/postString")
	public ResponseEntity<?> postString(String key, String value) {
		ValueOperations<String, String> str = redis.opsForValue();
		str.set(key, value);

		return new ResponseEntity<>(HttpStatus.OK);
	}

	@ResponseBody
	@PostMapping("/postHash")
	public Map<String, Object> postHash(@RequestBody Object obj) {
		HashMap<String, Object> resultMap = new HashMap<>();

		try {
			List<HashMap<String, Object>> list = (List<HashMap<String, Object>>) obj;
			System.out.println("postHash::list" + list);

			for (HashMap<String, Object> map : list) {
				String index = (String) map.get("index");
				map.remove("index");

				HashOperations<String, String, Object> hash = redis.opsForHash();
				hash.putAll(index, map);
			}

		} catch (ClassCastException e_list) {

			try {
				HashMap<String, Object> map = (HashMap<String, Object>) obj;
				System.out.println("postHash::map" + map);

				String index = (String) map.get("index");
				map.remove("index");

				HashOperations<String, String, Object> hash = redis.opsForHash();
				hash.putAll(index, map);

			} catch (Exception e_map) {
				resultMap.put("resultCode", 415);
				resultMap.put("status", HttpStatus.UNSUPPORTED_MEDIA_TYPE);
				resultMap.put("message", "JSONArray 혹은 JSONObject만 허용됩니다.");
				return resultMap;
			}

		} catch (Exception e_list) {
			System.out.println(e_list);
		}

		resultMap.put("resultCode", 200);
		resultMap.put("status", HttpStatus.OK);
		return resultMap;
	}

	@ResponseBody
	@GetMapping("/getHashList")
	public Map<String, Object> getHash() {
		HashMap<String, Object> resultMap = new HashMap<>();
		System.out.println("getHashList::");
		
		
		resultMap.put("resultCode", 200);
		return resultMap;
	}

	@ResponseBody
	@PostMapping("/getHash")
	public Map<String, Object> getHash(@RequestBody HashMap<String, Object> map) {
		HashMap<String, Object> resultMap = new HashMap<>();

		String index = (String) map.get("index");
		System.out.println("getHash::" + index);

		HashOperations<String, String, Object> hash = redis.opsForHash();

		resultMap.put("data", hash.entries(index));
		resultMap.put("resultCode", 200);
		resultMap.put("index", index);
		return resultMap;
	}
}