package cn.dragon2.Regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexDemo {

	public static void main(String[] args) {
		String numStr = "1234";

		//1234 is number.
		if (numStr.matches("^\\d+$")) {
			System.out.println(numStr + " is number.");
		} else {
			System.out.println(numStr + " is not number.");
		}

		/*
		a
		b
		c
		d
		e
		f:g
		 * */
		Pattern pSplit = Pattern.compile("[,.;|]");
		String forSplit = "a,b.c|d;e,f:g";
		String[] splited = pSplit.split(forSplit);
		for (String s : splited) {
			System.out.println(s);
		}

		Pattern agePattern = Pattern.compile("(\\d+[YMD])");
		String ageStr = "14Y3M7D";

		//14Y
		//3M
		//7D
		Matcher ageMatcher = agePattern.matcher(ageStr);		
		while (ageMatcher.find()) {
			System.out.println(ageMatcher.group(0));
		}
	}
}
