package com.hy.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.Setter;

@Component // @Component는 스프링에게 해당 클래스가 스프링에서 관리해야 하는 대상임을 표시하는 어노테이션
@Data
public class Restaurant {
	// @Autowired는 스프링 내부에서 자신이 특정한 객체에 의존적이므로 자신에게 해당 타입의 빈을 주입해주라는 표시
	// setter 메서드의 생성 시 메서드에 추가할 어노테이션을 지정, 해당 어노테이션에서는 @Autowired가 추가
	@Setter(onMethod_ = @Autowired) // Chef 클래스 자동 주입
	private Chef chef;
}
