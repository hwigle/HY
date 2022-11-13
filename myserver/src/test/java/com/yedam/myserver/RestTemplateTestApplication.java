package com.yedam.myserver;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.web.client.RestTemplate;

public class RestTemplateTestApplication {

	public static void main(String[] args) {
		String url = "http://apis.data.go.kr/1471000/FoodNtrIrdntInfoService1/getFoodNtrItdntList1?ServiceKey=oJonnVXeZPAvAAYFbUy03E9vN6uvbQDKxN5FSfTxsS4JOMqj6BzMZJBHG8Le5k/hhHoaIGjJMHQTL45zel3y6A==&numOfRows=3&pageNo=1&type=json";
		RestTemplate restTemplate = new RestTemplate();
		
		System.out.println(restTemplate);
		String res = restTemplate.getForObject(url, String.class);
		
		JSONParser parser = new JSONParser();
		try {
			Object obj = parser.parse(res);
			JSONObject jsonObj = (JSONObject) obj;
			System.out.println(jsonObj);
			//System.out.println(jsonObj.get("body"));
			
			JSONObject jsonObj2 = (JSONObject) jsonObj.get("body");
			System.out.println("jsonObj2 : "+jsonObj2);
			JSONArray jsonary = (JSONArray) jsonObj2.get("items"); 
			System.out.println("jsonary : "+jsonary);
//			System.out.println("objItems: "+objItems.get(0));
			for(int i = 0; i <jsonary.size(); i++) {
				temp = jsonary;
				System.out.println("데이터 : "+);
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		
//		try {
//			obj = (JSONObject) parser.parse(res);
//			System.out.println(obj);
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
		
//		JsonNode res = restTemplate.getForObject(url, JsonNode.class);
		//System.out.println(res.get("body").get("items").get(0).get("DESC_KOR"));
	}

}