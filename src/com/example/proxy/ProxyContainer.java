package com.example.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

import com.example.client.ClientStub;
import com.example.proxy.handler.GreetRequestHandler;
import com.example.server.ClientStubImpl;

@SuppressWarnings("unchecked")
public class ProxyContainer {

	static Map<Class, Object> concreteObjectMap = new HashMap<>();
	static {
		concreteObjectMap.put(ClientStub.class, new ClientStubImpl());
	}

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
		Object impl = getImplObject(clazz);
		return new GreetRequestHandler<T>(clazz, impl);
	}

	private static <T> Object getImplObject(Class<T> stubIntf)
			throws ClassNotFoundException, InstantiationException,
			IllegalAccessException {
		Object obj = concreteObjectMap.get(stubIntf);
		return obj;
	}

}
