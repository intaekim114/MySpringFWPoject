package myspring.di.xml;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

//Assertions에 포함된 모든 static method를 import 한다.
import static org.junit.jupiter.api.Assertions.*; // static import

public class HelloJunitTest {
	
	@Test
	void helloBean() {
		// 1. Container 객체 생성				container 역할
		ApplicationContext context = new GenericXmlApplicationContext("classpath:hello-di.xml"); // XML 파일을 알려줘야 알아서 객체 생성을 함
																//classpath하는 이유 xml파일이 show navigator로 보면 target.classes 폴더에 들어있음 
		// 2. Container 객체가 생성한 Spring Bean 요청하기
		Hello helloById = (Hello)context.getBean("hello"); // container는 hello-di.xml "hello"는 bean의 ID
		Hello helloByType = context.getBean("hello", Hello.class);
		// singleton 인지 확인하기 위해서 getBean 두번 요청
		
		// Spring Bean의 주소 비교 (Container가 개발자를 대신해서 생성해준 객체, 관리해준 객체) 검증하기 위해서 사용
		System.out.println(helloById == helloByType);
		assertSame(helloById, helloByType); // junit에서 제공하는 Assertions라는 클래스의 함수를 사용
		
		// 프레임워크가 생성한 객체의 name 값을 비교
		assertEquals("Hello 스프링", helloById.sayHello()); // (기대 되어지는 값, 호출 함수?
		
		// hello-di에 있는 this.printer에 printer 값이 잘 들어갔나 확인 하기 위해 this.printer 구문을 사용하는 함수를 호출해 보는 것
		helloById.print();
		
		// Container 객체가 생성한 StringPrinter 스프링 빈을 요청하기
		context.getBean("strPrinter", Printer.class);
	}
}
