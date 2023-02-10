package cn.dragon2.reflactor;

import java.lang.reflect.InvocationTargetException;

interface IMessage {
	void send(String message);
}

class NetMessage implements IMessage {

	@Override
	public void send(String message) {
		System.out.println("Net Message:" + message);
	}
}

class SmSMessage implements IMessage {

	@Override
	public void send(String message) {
		System.out.println("SmS Message:" + message);
	}
}

class MessageFactory {
	private MessageFactory() {
	}

	public static IMessage create(String className)
			throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException,
			NoSuchMethodException, SecurityException, ClassNotFoundException {
		return (IMessage) Class.forName(className).getDeclaredConstructor().newInstance();
	}
}

class Factory{
	@SuppressWarnings("unchecked")
	public static <T> T create(String className,Class<T> clazz)
			throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException,
			NoSuchMethodException, SecurityException, ClassNotFoundException {
		return (T) Class.forName(className).getDeclaredConstructor().newInstance();
	}
}

public class SampleFactoryDemo {
	public static void main(String[] args)
			throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException,
			NoSuchMethodException, SecurityException, ClassNotFoundException {
		IMessage net = MessageFactory.create("cn.dragon2.reflactor.NetMessage");
		net.send("Test");

		IMessage sms = MessageFactory.create("cn.dragon2.reflactor.SmSMessage");
		sms.send("Test");

	}
}
