package com.example.proxy.handler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public abstract class AbstractRequestHandler<T> implements InvocationHandler {

	private Object impl;
	private Class<T> intf;

	public AbstractRequestHandler(Class<T> intf, Object impl) {
		this.intf = intf;
		this.impl = impl;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		String methodName = method.getName();
		Class[] classes = createClassArray(args);
		Method stubMethod = getStubMethodName(methodName, classes);
		preProcess(stubMethod);
		Object returnObj = stubMethod.invoke(impl, args);
		postProcess(stubMethod);
		return returnObj;
	}

	protected abstract void preProcess(Method method);

	protected abstract void postProcess(Method method);

	private Class[] createClassArray(Object[] args) {
		Class[] classes = new Class[args.length];
		for (int i = 0; i < args.length; i++) {
			classes[i] = args[i].getClass();
		}
		return classes;
	}

	private Method getStubMethodName(String name, Class[] classes)
			throws NoSuchMethodException, SecurityException,
			ClassNotFoundException {
		Method m = intf.getMethod(name, classes);
		return m;
	}

}
