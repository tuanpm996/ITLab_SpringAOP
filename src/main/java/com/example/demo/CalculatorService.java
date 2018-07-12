package com.example.demo;

public class CalculatorService {
	public Object add(String a, String b) {
		try {
			int result = (Integer.valueOf(a) + Integer.parseInt(b));
			return result;
		} catch (Exception e) {
			return 0;
		}		
	}
}
