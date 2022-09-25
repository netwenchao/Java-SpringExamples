package cn.dragon2.globalization;

import java.util.Locale;
import java.util.ResourceBundle;

public class ResourceBundleDemo {

	public static void main(String[] args) {
		String baseName = "cn.dragon2.Resources.UI";
		String key = "info";
		//使用本机语言UI_zh_CN
		ResourceBundle res = ResourceBundle.getBundle(baseName);
		String info = res.getString(key);
		System.out.println(info);

		//UI_en
		Locale en = Locale.ENGLISH;
		ResourceBundle resEn = ResourceBundle.getBundle(baseName, en);
		System.out.println(resEn.getString(key));
	}
}
