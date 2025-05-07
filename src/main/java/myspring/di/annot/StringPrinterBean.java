package myspring.di.annot;

import org.springframework.stereotype.Component;

@Component("stringPrinter")
public class StringPrinterBean implements PrinterBean {
	private StringBuffer buffer = new StringBuffer();
	
	public StringPrinterBean() {
		System.out.println(this.getClass().getName() + " 기본생성자 호출됨!");
	}

	// String buffer에 문자열 쌓기
	public void print(String message) {
		this.buffer.append(message);
	}

	// beffer에 쌓인 문자열 반환
	public String toString() {
		return this.buffer.toString();
	}
}
