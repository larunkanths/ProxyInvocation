package com.example.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

import com.example.proxy.handler.GreetRequestHandler;

@SuppressWarnings("unchecked")
public class ProxyContainer {

	public static <T> T createProxy(Class<T> clazz)
			throws ClassNotFoundException, InstantiationException,
			IllegalAccessException {
		InvocationHandler handler = createInvocationHandler(clazz);
		T t = (T) Proxy.newProxyInstance(clazz.getClassLoader(),
				new Class[] { clazz }, handler);
		return t;
	}

	private static <T> InvocationHandler createInvocationHandler(Class<T> clazz)
			throws ClassNotFoundException, InstantiationException,
			IllegalAccessException {
		Object impl = createImplementation(clazz);
		return new GreetRequestHandler<T>(clazz, impl);
	}

	private static <T> Object createImplementation(Class<T> stubIntf)
			throws ClassNotFoundException, InstantiationException,
			IllegalAccessException {
		Object obj = stubIntf.getClassLoader()
				.loadClass(stubIntf.getName() + "Impl").newInstance();
		return obj;
	}

}
