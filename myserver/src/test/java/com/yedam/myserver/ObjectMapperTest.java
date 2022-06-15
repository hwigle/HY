package com.yedam.myserver;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yedam.myserver.todo.vo.TodoVO;

public class ObjectMapperTest {
	@Test
	public void test2() throws MalformedURLException, IOException {
		ObjectMapper om = new ObjectMapper();
		String url = "http://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json?key=f5eef3421c602c6cb7ea224104795888&targetDt=20120101";
		JsonNode result = om.readTree(new URL(url));
		String nm = result.get("boxOfficeResult").get("dailyBoxOfficeList").get(0).get("movieNm").asText();
		System.out.println(nm);		
	}	
	@Test
	public void test1() throws JsonProcessingException {
		TodoVO vo = new TodoVO();
		vo.setContents("test");
		vo.setNo("1");
		
		ObjectMapper om = new ObjectMapper();
		String result = om.writeValueAsString(vo); //@ResponseBody : 자바객체 vo를 받아서 스트링(json)으로 바꿔줌
		System.out.println(result);// vo를 스트링으로
		
		TodoVO vo2 = om.readValue(result, TodoVO.class); //@RequestBody : 스트링(json)을 받아서 다시 자바객체로 바꿔서 담아줌
		//스트링을 vo로
		System.out.println("vo2");
	}
}
