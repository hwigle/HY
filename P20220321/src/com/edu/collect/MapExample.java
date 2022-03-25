package com.edu.collect;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapExample {
	public static void main(String[] args) {
		// Map: {key:value}, {key1:value1}
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("전민욱", 80);
		map.put("김형민", 82);
		map.put("김영민", 85);
		map.put("김영민", 88);
		// 컬렉션: 여러값을 저장 => 여러요소 접근

		Integer val = map.get("김영민");
		System.out.println(val);

		Set<String> keySet = map.keySet(); // map컬렉션에 저장된 요소들의 키에 해당 값을 Set컬렉션으로 담아주는 효과
		Iterator<String> iter = keySet.iterator();

		while (iter.hasNext()) {
			String key = iter.next();
			Integer value = map.get(key);
			System.out.printf("key: %2s, value: %2d\n", key, value);
		}

		// 2) for( : ) 확장for
		for (String key : keySet) {
			Integer value = map.get(key);
		}
		System.out.println("\n=====end of prog=====");
	}

}
