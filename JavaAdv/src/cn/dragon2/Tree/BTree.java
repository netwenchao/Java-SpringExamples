package cn.dragon2.Tree;

public class BTree<T extends Comparable<T>> {
	private class Node {
		private Comparable<T> data;// Comparable,可比较大小
		private Node parent;// 父节点
		private Node left;// 左节点
		private Node right;// 右节点

		public Node(Comparable<T> d) {
			this.data = d;
		}

		/**
		 * 添加节点
		 * 
		 * @param parentNode
		 * @param node
		 */
		public void addNode(Node node) {
			if (data.compareTo((T) node.data) <= 0) {
				if (left == null) {
					left = node;
					node.parent = this;
				} else {
					left.addNode(node);
				}
			} else {
				if (right == null) {
					right = node;
					node.parent = this;
				} else {
					right.addNode(node);
				}
			}
		}

		public void toArray() {
			if (this.left != null) {
				this.left.toArray();
			}

			BTree.this.dataArr[BTree.this.index++] = this.data;

			if (this.right != null) {
				this.right.toArray();
			}
		}
	}

	private Node root;
	private int count;
	private Object[] dataArr;
	private int index;

	/**
	 * 添加数据
	 * 
	 * @param data 要保存的数据
	 * @exception NullPointerException 保存数据为空时抛出异常
	 */
	public void add(Comparable<T> data) {
		if (data == null) {
			throw new NullPointerException("data can't be null.");
		}

		var node = new Node(data);
		if (this.root == null) {
			this.root = node;
		} else {
			this.root.addNode(node);
		}
		this.count++;
	}

	public Object[] toArray() {
		if (this.count == 0)
			return null;
		this.dataArr = new Object[this.count];
		this.root.toArray();
		return this.dataArr;
	}

}
