package org.zerock.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.Setter;

@Component // 스프링에게 해당 클래스가 스프링에서 관리해야하는 대상임을 표시하는 어노테이션
@Data
public class Restaurant {
	//Restaurant 객체는 Chef 객체를 필요함을 의미함
	@Setter(onMethod_ = @Autowired)
	private Chef chef;
	
	// @Setter : 자동으로 setChef()를 컴파일시 생성하도록 하는 어노테이션
	// onMethod 속성은 생성되는 setChef()에 @Autowired 어노테이션을 추가하도록 함
	// @Data 어노테이션을 사용함으로써 기본 함수들을 사용할 수 있음 ex)getChef(), equals, hashCode, toString, setChef(Chef)
}
