package cn.dragon2.reflactor;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;
import java.util.ArrayList;

import sun.misc.Unsafe;

class MethodInfoDemoPson {
	private String name;
	private int age;
	//public String F;

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Name:" + name + " Age:" + age;
	}
}

public class MethodInfoDemo {
	public static void main(String[] args) throws NoSuchMethodException, SecurityException {
		Class<? extends MethodInfoDemoPson> cls = MethodInfoDemoPson.class;

		Field[] fields = cls.getDeclaredFields();
		for (Field f : fields) {
			System.out.println(f);
		}

		System.out.println("***********************************");
		// 本类方法
		Method[] ms = cls.getDeclaredMethods();
		for (Method m : ms) {
			System.out.print(Modifier.toString(m.getModifiers()) + " ");
			System.out.print(m.getReturnType().getName() + " ");
			System.out.print(m.getName() + "(");
			Parameter[] ps = m.getParameters();
			for (Parameter p : ps) {
				System.out.print(p.getType().getName() + " " + p.getName() + ",");
			}
			System.out.println(")");
			Class<?>[] eTs = m.getExceptionTypes();

			for (Class<?> e : eTs) {
				System.out.println(e);
			}
		}
	}
}
