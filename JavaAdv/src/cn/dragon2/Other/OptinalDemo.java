package cn.dragon2.Other;

import java.util.Optional;

public class OptinalDemo {

	public static void main(String[] args) {
		Integer l = null;
		Integer r = 3;
		System.out.println("Null+3=" + sum(Optional.ofNullable(l), Optional.ofNullable(r)));
	}

	public static int sum(Optional<Integer> l, Optional<Integer> r) {
		// 是否有值
		System.out.println("l.hasValue:" + l.isPresent());
		System.out.println("r.hasValue:" + r.isPresent());

		return l.orElse(0) + r.orElse(0);
	}
}