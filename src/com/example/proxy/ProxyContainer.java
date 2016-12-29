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
		Class<T> stubIntf = getStubClass(clazz);
		Object impl = getImplObject(stubIntf);
		return new GreetRequestHandler<T>(stubIntf, impl);
	}

	private static <T> Class<T> getStubClass(Class<T> clazz)
			throws ClassNotFoundException {
		Class<T> intf = (Class<T>) Class.forName(clazz.getName());
		return (Class<T>) intf;
	}

	private static <T> Object getImplObject(Class<T> stubIntf)
			throws ClassNotFoundException, InstantiationException,
			IllegalAccessException {
		Object obj = concreteObjectMap.get(stubIntf);
		return obj;
	}

}
