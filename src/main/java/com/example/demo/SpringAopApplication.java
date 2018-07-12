package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.PropertyMapper.SourceOperator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class SpringAopApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringAopApplication.class, args);
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		CalculatorService cs = (CalculatorService)context.getBean("calculatorService");
		String param1 = "3";
		String param2 = "3";
		Object a = cs.add(param1, param2);
		System.out.println(String.format("The result of %s and %s is: ", param1, param2) + a);
		
		param1 = "3";
		param2 = "3";
		a = cs.add(param1, param2);
		
		System.out.println(String.format("The result of %s and %s is: ", param1, param2) + a);
	}
}
