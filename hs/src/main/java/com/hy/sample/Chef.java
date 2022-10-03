package com.hy.sample;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component // Component를 통해서 해당 객체는 스프링에서 관리해야하는 객체로 인식
@Data // Data를 통해서 해당 객체의 Getter/Setter/toString이 자동 형성
public class Chef {

}
