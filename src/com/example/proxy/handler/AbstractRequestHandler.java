package com.example.proxy.handler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public abstract class AbstractRequestHandler<T> implements InvocationHandler {

	private Object impl;

	public AbstractRequestHandler(Object impl) {
		this.impl = impl;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		preProcess(method);
		Object returnObj = method.invoke(impl, args);
		postProcess(method);
		return returnObj;
	}

	protected abstract void preProcess(Method method);

	protected abstract void postProcess(Method method);

}
