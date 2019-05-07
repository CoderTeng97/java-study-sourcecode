package datastructure.tree;


public class LinkedBinaryTree implements BinaryTree {

	Node root;

	public LinkedBinaryTree() {
		// TODO Auto-generated constructor stub
	}

	public LinkedBinaryTree(Node root) {
		this.root = root;
	}


	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return root == null ? true : false;
	}


	public int size() {
		// TODO Auto-generated method stub
		return this.size(root);
	}

	private int size(Node root){
		if(root == null ){
			return 0;
		}else{
			//左子树的节点数
			int nl = this.size(root.leftChild);
			//右子树的节点数
			int nr = this.size(root.rightChild);
			//取两者最大的节点数 + 1
			return nl +nr +1;
		}
	}


	public int getHeight() {
		// TODO Auto-generated method stub
		return this.getHeight(root);
	}

	private int getHeight(Node root){
		if(root == null ){
			return 0;
		}else{
			//左子树的高度
			int nl = this.getHeight(root.leftChild);
			//右子树的高度
			int nr = this.getHeight(root.rightChild);
			//取两者最大的高度 + 1
			return nl > nr ? nl+1 : nr +1;
		}
	}



	public Node findeKey(Object value) {
		// TODO Auto-generated method stub
		return null;
	}


	public void preOrderTraverse() {
		System.out.println("先序遍历");
		preOrderTraverse(root);
		System.out.println("\n");
	}

	private void preOrderTraverse(Node root) {
		// TODO Auto-generated method stub

		if (root != null) {
			// 先输出根节点
			System.out.print(root.data);
			// 再遍历左子树
			this.preOrderTraverse(root.leftChild);
			// 再遍历 右子树
			this.preOrderTraverse(root.rightChild);
		}

	}


	public void inOrderTraverse() {
		// TODO Auto-generated method stub
		System.out.println("中序遍历");
		inOrderTraverse(root);
		System.out.println("\n");
	}

	private void inOrderTraverse(Node root) {
		// TODO Auto-generated method stub

		if (root != null) {
			// 再遍历左子树
			this.inOrderTraverse(root.leftChild);
			// 先输出根节点
			System.out.print(root.data);
			// 再遍历 右子树
			this.inOrderTraverse(root.rightChild);
		}

	}

	public void postOrderTraverse() {
		// TODO Auto-generated method stub
		System.out.println("后序（根节点）遍历");
		postOrderTraverse(root);
		System.out.println("\n");
	}

	private void postOrderTraverse(Node root) {
		// TODO Auto-generated method stub

		if (root != null) {
			// 再遍历左子树
			this.postOrderTraverse(root.leftChild);
			// 再遍历 右子树
			this.postOrderTraverse(root.rightChild);
			// 先输出根节点
			System.out.print(root.data);

		}

	}


	public void preOrderByStack() {
		// TODO Auto-generated method stub

	}


	public void inOrderByStack() {
		// TODO Auto-generated method stub

	}


	public void postOrderByStack() {
		// TODO Auto-generated method stub

	}


	public void levelOrderByStack() {
		// TODO Auto-generated method stub

	}

}
