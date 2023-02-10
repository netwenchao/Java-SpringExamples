package cn.dragon2.reflactor;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

interface IMessageService {
	void send();
}

interface IChannelService {
	void connect();
}

interface ISubService{
	void test();
}

class ClsBaseService implements IMessageService, IChannelService {

	@Override
	public void connect() {
		System.out.println("connect...");
	}

	@Override
	public void send() {
		System.out.println("send...");
	}
}

class ClsSubServie extends ClsBaseService implements ISubService {

	private String name;
	private int age;

	public ClsSubServie() {
	}

	public ClsSubServie(String n) {
		this.name = n;
	}

	public ClsSubServie(String n, int a) {
		this.name = n;
		this.age = a;
	}

	public void test() {
		System.out.println("test");
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Name:"+name+" Age:"+age;
	}
}

public class ClassInfoDemo {
	public static void main(String[] args) throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		ClsSubServie sub = new ClsSubServie();

		Class<? extends ClsSubServie> cOfSub = sub.getClass();

		System.out.println("******************Package****************");
		// 获取包信息
		Package p = cOfSub.getPackage();

		System.out.println(p.getName());

		System.out.println("******************Superclass****************");
		// 获取父类信息
		Class<?> sup = cOfSub.getSuperclass();
		System.out.println(sup.getName());


		System.out.println("******************Interfaces****************");
		Class<?>[] interfaces = cOfSub.getInterfaces();
		for (Class<?> c : interfaces) {
			System.out.println("Interface:" + c.getName());
		}

		System.out.println("******************Methods****************");
		
		// 获取方法
		Method[] ms = cOfSub.getMethods();
		for (Method m : ms) {
			System.out.println(m);
		}

		System.out.println("******************Fields****************");
		// 获取属性
		Field[] fields = cOfSub.getFields();

		for (Field f : fields) {
			System.out.println(f);
		}

		System.out.println("******************Constructor****************");
		// 获取构造函数
		Constructor<?>[] cons = cOfSub.getConstructors();
		for (Constructor<?> c : cons) {
			System.out.println(c);
		}

		System.out.println("******************Constructor newInstance****************");
		Constructor<?> c =cOfSub.getConstructor(String.class,int.class);
		ClsSubServie subC=(ClsSubServie) c.newInstance("XiaoQiang",3);
		System.out.println(subC);
	}
}
