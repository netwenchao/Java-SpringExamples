package cn.dragon2.BasicLib;

import java.util.Base64;
import java.util.Base64.Encoder;

public class Base64EncodeDemo {

	public static void main(String[] args) {
		Encoder coder = Base64.getEncoder();
		String message = "This is test message.";

		String encodeMessage = new String(coder.encode(message.getBytes()));
		System.out.println(message);
		System.out.println("Encoded=" + encodeMessage);

		System.out.println("Decoded="+new String(Base64.getDecoder().decode(encodeMessage)));
	}
}
