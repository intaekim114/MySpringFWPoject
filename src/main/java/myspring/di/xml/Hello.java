package myspring.di.xml;

import java.util.List;

public class Hello {
	String name;
	Printer printer;
	List<String> names;

	public Hello() {
		System.out.println(this.getClass().getName() + " 기본생성자 호출됨!");
	}

	public Hello(String name, Printer printer) {
		System.out.println(this.getClass().getName() + " 오버로딩 생성자 호출됨!");
		this.name = name;
		this.printer = printer;
	}

	public List<String> getNames() {
		return this.names;
	}

	public void setNames(List<String> list) {
		System.out.println("setNames() 메서드 호출됨");
		this.names = list;
	}

	public void setName(String name) {
		System.out.println("setName() 메서드 호출됨" + name);
		this.name = name; // "스프링" 값이 잘 넘어갔나 확인하기 위해서 name 값을 확인
	}

	public void setPrinter(Printer printer) {
		System.out.println("setPrinter() 메서드 호출됨 " + printer.getClass().getName());
		this.printer = printer;
	}

	public String sayHello() {
		return "Hello " + name; // Hello 스프링   -> 기대되어지는 결과값
	}

	public void print() {
		// print에 ctrl+클릭 => open implementation(어떻게 구현되었는지) 클릭 string printer
		this.printer.print(sayHello());
	}

}
