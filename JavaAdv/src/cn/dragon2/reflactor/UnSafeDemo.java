package cn.dragon2.reflactor;

import java.lang.reflect.Field;

import sun.misc.Unsafe;

public class UnSafeDemo {
	public static void main(String[] args)
			throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException, InstantiationException {
		
		Field fTheUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
		fTheUnsafe.setAccessible(true);
		Unsafe unsafeObj = (Unsafe) fTheUnsafe.get(null);
		
		UnSafeDemo obj = (UnSafeDemo) unsafeObj.allocateInstance(UnSafeDemo.class);
		obj.show();
	}
	
	void show() {
		System.out.println("Show");
	}
}
