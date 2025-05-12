package myspring.di.xml.config;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import myspring.di.xml.ConsolePrinter;
import myspring.di.xml.Hello;
import myspring.di.xml.Printer;
import myspring.di.xml.StringPrinter;

@Configuration
@PropertySource(value = "classpath:values.properties")
public class HelloConfig {
	@Autowired // 이거 안쓰면 null (Environment 인터페이스를 가져와 구현한 객체를 env에 주입시켜줌)
	private Environment env;
	
	@Bean
	public Printer stringPrinter() {
		return new StringPrinter();
	}
	
	@Bean
	public Printer consolePrinter() {
		return new ConsolePrinter();
	}
	
	@Bean
	public Hello hello() {
		Hello hello = new Hello(); // alt + shift + l (왼쪽에 타입 주기)
//		hello.setName("스프링");
		hello.setName(env.getProperty("myName1")); // myName1 = 스프링 (value.properties)
		hello.setPrinter(stringPrinter());
		hello.setNames(namesList());
		return hello;
	}
	
	@Bean
	public List<String> namesList() {
		String names = env.getProperty("names.list.of.strings");
		return Arrays.asList(names.split(","));
//		return Arrays.asList("Java", "Spring", "Kotlin");
		
	}
}
