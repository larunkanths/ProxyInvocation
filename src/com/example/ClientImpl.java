package com.example;

public class ClientImpl implements Client {

	public void login(String name) {
		System.out.println("Method Invocation: Welcome Back " + name);
	}

	public void logout(String name) {
		System.out.println("Method Invocation: Bye " + name);
	}
}
