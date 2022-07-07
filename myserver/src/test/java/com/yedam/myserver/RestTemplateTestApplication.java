package com.yedam.myserver;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.databind.JsonNode;

public class RestTemplateTestApplication {

	public static void main(String[] args) {
		String url = "http://apis.data.go.kr/1471000/FoodNtrIrdntInfoService1/getFoodNtrItdntList1?ServiceKey=oJonnVXeZPAvAAYFbUy03E9vN6uvbQDKxN5FSfTxsS4JOMqj6BzMZJBHG8Le5k/hhHoaIGjJMHQTL45zel3y6A==&numOfRows=3&pageNo=1&type=json";
		RestTemplate restTemplate = new RestTemplate();
		JsonNode res = restTemplate.getForObject(url, JsonNode.class);
		System.out.println(res.get("body").get("items").get(0).get("DESC_KOR"));
	}

}