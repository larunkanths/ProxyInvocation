package com.example.proxy.handler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public abstract class AbstractRequestHandler<T> implements InvocationHandler {

	protected Object impl;

	public AbstractRequestHandler(Object impl) {
		this.impl = impl;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		preProcess(proxy, method, args);
		Object returnObj = invokeMethod(method, args);
		postProcess(proxy, method, args);
		return returnObj;
	}

	protected Object invokeMethod(Method method, Object[] args)
			throws IllegalAccessException, IllegalArgumentException,
			InvocationTargetException {
		return method.invoke(impl, args);
	}

	protected abstract void preProcess(Object proxy, Method method,
			Object[] args);

	protected abstract void postProcess(Object proxy, Method method,
			Object[] args);

}
