package com.example.server;

import com.example.client.ClientStub;

public class ClientStubImpl implements ClientStub {

	public void login(String name) {
		System.out.println("Method Invocation: Welcome Back " + name);
	}

	public void logout(String name) {
		System.out.println("Method Invocation: Bye " + name);
	}
}
