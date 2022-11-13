package org.zerock.sample;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;
//현재 코드가 스프링을 실행하는 역할을 할 것이라는 의미
@RunWith(SpringJUnit4ClassRunner.class) 
// 저장된 클래스나 문자열을 이용해서 필요한 객체들을 스프링 내에 객체로 등록하게 됨
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
// Lombok을 이용해서 로그를 기록하는 Logger를 변수로 생성
@Log4j
public class SampleTests {

	@Setter(onMethod_ = { @Autowired }) //Autowired : 해당 인스턴스 변수가 스프링으로부터 자동으로 주입해달라는 의미
	private Restaurant restaurant;

	@Test
	public void testExist() {
		assertNotNull(restaurant); // 변수가 null이 아니어야만 테스트 가능

		log.info(restaurant);
		log.info("----------------");
		log.info(restaurant.getChef());
	}
}
