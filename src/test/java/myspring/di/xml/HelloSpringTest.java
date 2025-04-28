package myspring.di.xml;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

import javax.annotation.Resource;

// SpringExtension 클래스는 ApplicationContext(컨테이너) 객체를 생성하는 역할을 함
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "classpath:hello-di.xml")
public class HelloSpringTest {
	@Autowired
	Hello hello; // getBean("hello")
	
	@Autowired
	Printer strPrinter; // bean의 id값을 넣어주자
	
	@Autowired // 타입을 기준으로 bean을 찾는 것  
	@Qualifier("strPrinter") // id이름과 다르게 객체를 선언하고 싶을 때
	Printer printer;
	
	@Resource(name = "hello") // 스프링 어노테이션이 아닌 자바쪽 어노테이션
	Hello helloBean;
	
	
	@Test
	void helloSpringBean() {
		assertEquals("Hello 스프링", hello.sayHello());
		hello.print();
		assertEquals("Hello 스프링", strPrinter.toString());
		
		System.out.println(strPrinter.getClass().getName());
		
		assertEquals("Hello 스프링", printer.toString());
		
		assertEquals("Hello 스프링", helloBean.sayHello());
		
		
	}
}
