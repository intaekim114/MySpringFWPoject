package myspring.di.xml;

//Assertions에 포함된 모든 static method를 import 한다.
// static import
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloJunitTest {
	ApplicationContext context;
	
	@BeforeEach // Test케이스 전에 사전에 설정해줘야하는 부분 있을 때 사용
	void container() { // 따로 호출 안하더라도 junit이 불러줌
		// 1. Container 객체 생성				container 역할
		context = new GenericXmlApplicationContext("classpath:hello-di.xml"); // XML 파일을 알려줘야 알아서 객체 생성을 함
		
	}
	
	@Test
	void helloBean() {
																//classpath하는 이유 xml파일이 show navigator로 보면 target.classes 폴더에 들어있음 
		// 2. Container 객체가 생성한 Spring Bean 요청하기
		Hello helloById = (Hello)context.getBean("hello"); // container는 hello-di.xml "hello"는 bean의 ID
		Hello helloByType = context.getBean("hello", Hello.class);
		// singleton 인지 확인하기 위해서 getBean 두번 요청
		
		// Spring Bean의 주소 비교 (Container가 개발자를 대신해서 생성해준 객체, 관리해준 객체) 검증하기 위해서 사용
		System.out.println(helloById == helloByType);
		assertSame(helloById, helloByType); // junit에서 제공하는 Assertions라는 클래스의 함수를 사용
		
		// 프레임워크가 생성한 객체의 name 값을 비교
		// <property name="name" value="스프링"/> 이 설정 테스트
		assertEquals("Hello 스프링", helloById.sayHello()); // (기대 되어지는 값, 호출 함수?
		
		// hello-di에 있는 this.printer에 printer 값이 잘 들어갔나 확인 하기 위해 this.printer 구문을 사용하는 함수를 호출해 보는 것
		// <property name="printer" ref="strPrinter"/> 이 설정 테스트
		helloById.print();
		
		// Container 객체가 생성한 StringPrinter 스프링 빈을 요청하기
		Printer printer = context.getBean("strPrinter", Printer.class);
		assertEquals("Hello 스프링", printer.toString());
		
		// 계속 getBean을 사용해야 하는 것에 번거로움을 느낌
		// JUnit 확장해서 더 편하게 한게 Spring Test
	}
}
