package cn.dragon2.reflactor;

import java.util.Date;

public class GetClass {
	public static void main(String[] args) {
		Date t = new Date();
		
		//实例.getClass()
		Class<? extends Date> cls=t.getClass();
		System.out.println(cls.getName());
		System.out.println(cls);
		
		//类名称.Class		
		Class<?> cls2=Date.class;
		
		//Class.forName
		try {
			Class<?> cls3=Class.forName("java.util.Date");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
