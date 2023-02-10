package cn.dragon2.IOSamples;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class InputUtil {

	static Scanner input = new Scanner(System.in);

	/**
	 * 
	 * @param prompt
	 * @return
	 */
	public static int getInt(String prompt) {
		System.out.println(prompt);

		boolean flag = true;
		int num = 0;
		while (!input.hasNextInt()) {
			input.next();//抛弃当前数据
			System.out.println(prompt);
		}
		return input.nextInt();

	}
}
