package com.example;

import com.example.annotations.GreetLoginBanner;
import com.example.annotations.GreetLogoutBanner;

public interface Client {

	@GreetLoginBanner
	void login(String name);

	@GreetLogoutBanner
	void logout(String name);
}
