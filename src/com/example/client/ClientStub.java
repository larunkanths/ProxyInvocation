package com.example.client;

import com.example.annotations.GreetLoginBanner;
import com.example.annotations.GreetLogoutBanner;

public interface ClientStub {

	@GreetLoginBanner
	void login(String name);

	@GreetLogoutBanner
	void logout(String name);
}
