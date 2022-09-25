package cn.dragon2.globalization;

import java.util.Locale;

public class GlobalizationDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Locale zhCN = new Locale("zh", "CN");
		// zh_CN
		System.out.println(zhCN);

		//Current locale
		Locale cur = Locale.getDefault();
		System.out.println("Default:" + cur);
		
		// zh_CN
		Locale ch = Locale.CHINA;
		System.out.println("China:" + cur);
	}

}