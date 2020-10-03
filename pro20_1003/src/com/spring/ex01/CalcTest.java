package com.spring.ex01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CalcTest {

	public static void main(String[] args) {
		
		// AOPTest.xml을 읽어 들여 빈을 생성합니다.
		ApplicationContext context=new ClassPathXmlApplicationContext("AOPTest.xml");
		
		// id가 proxyCal 인 빈에 접근합니다.
		Calculator cal=(Calculator) context.getBean("proxyCal");
	
		
		// 메서드 호출 전후에 어드바이스 빈이 적용 됩니다.
		cal.add(100, 20);
		System.out.println();
		cal.subtract(100, 20);
		System.out.println();
		cal.multiply(100, 20);
		System.out.println();
		cal.divide(100, 20);
		
	}

}
