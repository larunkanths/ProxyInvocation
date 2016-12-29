package com.example.proxy.handler;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import com.example.annotations.GreetLoginBanner;
import com.example.annotations.GreetLogoutBanner;

public class GreetRequestHandler<T> extends AbstractRequestHandler<T> {

	public GreetRequestHandler(Object impl) {
		super(impl);
	}

	@Override
	protected void preProcess(Object proxy, Method method, Object[] args) {
		System.out.println("Inside preProcess...");
		Annotation[] annotations = method.getAnnotations();
		for (Annotation annotation : annotations) {
			if (annotation instanceof GreetLoginBanner) {
				System.out.println("Hey!!!");
				break;
			}
		}
		System.out.println("Exiting preProcess...");
	}

	@Override
	protected void postProcess(Object proxy, Method method, Object[] args) {
		System.out.println("Inside postProcess...");
		Annotation[] annotations = method.getAnnotations();
		for (Annotation annotation : annotations) {
			if (annotation instanceof GreetLogoutBanner) {
				System.out.println("Miss You!!!");
				break;
			}
		}
		System.out.println("Exiting postProcess...");
	}

}
