package cn.dragon2.Regex;

public class RegexStringDemo {

	public static void main(String[] args) {
		String str="an1mf2anf313nb..2,.123";//非字母或数字
		
		System.out.println("仅保留字母:"+str.replaceAll("[^a-z]+",""));
		System.out.println("按照数字拆分:"+String.join("  ",str.split("\\d")));

	}
}
