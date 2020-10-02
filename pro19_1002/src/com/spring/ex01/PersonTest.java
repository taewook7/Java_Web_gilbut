package com.spring.ex01;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

public class PersonTest {

	public static void main(String[] args) {
		BeanFactory factory = new XmlBeanFactory(new FileSystemResource("person.xml"));
		// 실행시 person.xml 을 읽어 들여 빈을 생성합니다.
		
		PersonService person=(PersonService) factory.getBean("personService");
		// id가 personService인 빈을 가져옵니다. 
		
		person.sayHello();  
		//생성된 bean 을 이용해서 name 값ㅇ르 출력합니다. 
		
	}

}
