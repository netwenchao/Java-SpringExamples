package cn.dragon2.Tree;

import java.util.Arrays;

public class BTreeDemo {

	public static void main(String[] args) {
		BTree<Integer> score = new BTree<Integer>();
		score.add(0);
		score.add(10);
		score.add(4);
		score.add(9);
		score.add(1);
		
		System.out.println(Arrays.toString(score.toArray()));

	}

}
