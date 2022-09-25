package cn.dragon2.globalization;

import java.text.MessageFormat;
import java.util.ResourceBundle;

public class MessageFormatDemo {

	public static void main(String[] args) {
		ResourceBundle res=ResourceBundle.getBundle("cn.dragon2.Resources.UI");
		//欢迎 Dragon!
		System.out.println(MessageFormat.format(res.getString("formatMsg"),"Dragon"));
	}
}
