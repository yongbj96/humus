package bj.practice.humus.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class dateController {
	@PostMapping("/postOneData")
	public String postOneData(HttpServletRequest request) throws IOException {
		JSONObject jobj = new JSONObject();
		jobj.put("index", request.getParameter("index"));
		jobj.put("name", request.getParameter("name"));
		jobj.put("date", (String) request.getParameter("date"));
		jobj.put("status", request.getParameter("status"));

		JSONArray jarr = new JSONArray();
		jarr.add(jobj);

		URL obj = null;
	    obj = new URL("http://localhost:8080/postHash"); // API URL

	    HttpURLConnection con = (HttpURLConnection)obj.openConnection();
	    con.setRequestMethod("POST"); // GET, POST
	    con.setRequestProperty("Content-type", "application/json; charset=UTF-8");
	    con.setDoOutput(true);
	    // DATA
	    OutputStreamWriter wr= new OutputStreamWriter(con.getOutputStream());
	    wr.write(jarr.toString());
	    wr.flush();
	    // API 호출
	    BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
	    String line;
	    StringBuffer sb = new StringBuffer();
	    while((line = in.readLine()) != null){
	        sb.append(line);
	    }
	    in.close();
	    con.disconnect();
	    String text = sb.toString();
	    ObjectMapper mapper = new ObjectMapper();
	    Map<String, Object> map = mapper.readValue(text, Map.class);
	    System.out.println(map);

		return "index";
	}
}