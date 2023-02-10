package cn.dragon2.reflactor;

import java.lang.reflect.InvocationTargetException;

class NIPerson {
	public NIPerson() {
		System.out.println(this.getClass().getName() + ".Constructor");
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "This is a person";
	}
}

public class NewInstanceDemo {
	public static void main(String[] args)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, IllegalArgumentException,
			InvocationTargetException, NoSuchMethodException, SecurityException {
		// 仅能调用无参构造
		Object o = Class.forName("cn.dragon2.reflactor.NIPerson").newInstance();
		System.out.println(o);

		//
		Object o2 = Class.forName("cn.dragon2.reflactor.NIPerson").getDeclaredConstructor().newInstance();
		System.out.println(o2);
	}
}
