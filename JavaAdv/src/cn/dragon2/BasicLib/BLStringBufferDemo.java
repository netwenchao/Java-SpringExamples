package cn.dragon2.BasicLib;

public class BLStringBufferDemo {

	public static void main(String[] args) {
		String str="Hello";
		System.out.println(str);//Hello
		change(str);
		System.out.println(str);//Hello
		
		//允许改变,线程安全
		StringBuffer buf=new StringBuffer("Hello");
		System.out.println(buf);//Hello
		change(buf);
		System.out.println(buf);//Hello World!
		
		StringBuilder sb=new StringBuilder("Hello");
		System.out.println(sb);//Hello
		change(sb);
		System.out.println(sb);//Hello World!
		
		CharSequence cs;
	}
	
	static void change(String tmp) {
		tmp+="World!";
	}
	
	static void change(StringBuffer sb) {
		sb.append(" World!");
	}
	static void change(StringBuilder sb) {
		sb.append(" World!");
	}
}
