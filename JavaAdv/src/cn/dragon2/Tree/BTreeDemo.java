package cn.dragon2.Tree;

import java.util.Arrays;

public class BTreeDemo {

	public static void main(String[] args) {
		BTree<Character> score = new BTree<Character>();
		score.add('H');
		score.add('C');
		score.add('B');
		score.add('D');
		score.add('A');
		score.add('E');
		score.add('S');
		score.add('Z');

		System.out.println(Arrays.toString(score.toArray()));

	}

}
