package cn.dragon2.DateTime;

import java.util.Date;

public class DateDemo {

	public static void main(String[] args) {
		Date now=new Date();
		System.out.println(now);
		
		//Year-1900
		System.out.println("Year:"+(now.getYear()+1900));
		//0-11
		System.out.println("Month:"+(now.getMonth()+1));
		
		//1-31
		System.out.println("Date:"+now.getDate());
		
		System.out.println("Hour:"+now.getHours());
		
		System.out.println("Min:"+now.getMinutes());
		
		System.out.println("Sec:"+now.getSeconds());
		
		//mil Seconds after 1970-01-01
		System.out.println("Sec:"+now.getTime());
		
		//0(Sun)-6(Sat)
		System.out.println("Week:"+now.getDay());
		
		//in mins
		System.out.println("TimeZoneOffset:"+now.getTimezoneOffset());
		
	}
}
