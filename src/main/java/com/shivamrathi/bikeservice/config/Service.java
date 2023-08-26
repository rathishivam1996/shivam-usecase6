package com.shivamrathi.bikeservice.config;

public class Service {
	public static void main(String[] args) {
		
		try {
			Foo foo = new Foo();
			String result = foo.run();
			if (result.equals("foo")) {
				throw new IllegalArgumentException();
			}
		} catch (IllegalArgumentException e) {
			System.out.println(e);
		}
	}
}
