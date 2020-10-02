package com.spring.ex01;

public class PersonServiceImpl implements PersonService {
	private String name;
	private int age;
	
	


	public void setName(String name) {  // <value> 태그의 값을 setter 를 이용해 설정합니다.
		this.name = name;
	}



@Override
public void sayHello() {
	System.out.println(" 이름: "+name);
	System.out.println("나이: " +age);
}
}
