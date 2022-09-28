package cn.dragon2.DateTime;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleDateFormatDemo {

	public static void main(String[] args) throws ParseException {
		Date date= new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(sdf.format(date));
		
		Date birth=sdf.parse("2020-01-01 13:00:00");
		System.out.println(sdf.format(birth));
	}
}
