package cn.dragon2.Tree;

public class BTree<T extends Comparable<T>> {
	private class Node {
		private Comparable<T> data;// Comparable,可比较大小
		private Node parent;// 父节点
		private Node left;// 左节点
		private Node right;// 右节点

		public Node(Comparable<T> data) {
			this.data = data;
		}

		@SuppressWarnings("unchecked")
		public void addNode(Node newNode) {
			if (newNode.data.compareTo((T) data) <= 0) {
				if (this.left == null) {
					this.left = newNode;
					newNode.parent = this;
				} else {
					this.left.addNode(newNode);
				}
			} else {
				if (this.right == null) {
					this.right = newNode;
					newNode.parent = this;
				} else {
					this.right.addNode(newNode);
				}
			}
		}

		/**
		 * 
		 * @param val
		 * @return
		 */
		public Node getNode(Comparable<T> val) {
			int pos = this.data.compareTo((T) val);
			if (pos == 0) {
				return this;
			}

			if (pos > 0 && this.left != null) {
				return this.left.getNode(val);
			}

			if (pos < 0 && this.right != null) {
				return this.right.getNode(val);
			}
			return null;
		}

		/**
		 * 实现数据的获取处理，按照中序遍历的形式完成
		 */
		public void toArrayNode() {
			if (this.left != null) {
				this.left.toArrayNode();
			}

			BTree.this.dataArray[BTree.this.foot++] = data;

			if (this.right != null) {
				this.right.toArrayNode();
			}
		}
	}

	private Node root;// 保存的是根节点
	private int count = 0;// 节点数
	private Object[] dataArray = null;
	private int foot = 0;

	/**
	 * 进行数据保存
	 * 
	 * @param data
	 * @exception NullPointerException 保存的数据不能为null
	 */
	public void add(Comparable<T> data) {
		if (data == null) {
			throw new NullPointerException("保存的数据不能为null.");
		}

		Node newNode = new Node(data);
		if (this.root == null) {
			this.root = newNode;
		} else {
			this.root.addNode(newNode);
		}
		this.count++;
	}

	public void remove(Comparable<T> data) {
		Node node = this.root.getNode(data);
		if (node == null) {
			return;
		}

		// 没有任何子节点
		if (node.left == null && node.right == null) {
			node.parent = null;// 断开父节点
		}

		// 仅有左节点
		if (node.left != null && node.right == null) {
			node.left.parent = node.parent;// 子节点设置父节点
		}

		// 仅有右节点
		if (node.left == null && node.right != null) {
			node.right.parent = node.parent;// 子节点设置父节点
		}

		// 有左右节点，找到右侧子树最左节点替换为当前节点
		Node moveNode = node.right;
		while (moveNode.left != null) {
			moveNode = moveNode.left;
		}

		moveNode.parent.left = null;//断开待移动节点父节点左节点
		moveNode.parent = node.parent;
		moveNode.left = node.left;
		moveNode.right = node.right;

	}

	public Object[] toArray() {
		if (this.count == 0)
			return null;
		this.foot = 0;
		this.dataArray = new Object[this.count];
		this.root.toArrayNode();
		return this.dataArray;
	}

}
