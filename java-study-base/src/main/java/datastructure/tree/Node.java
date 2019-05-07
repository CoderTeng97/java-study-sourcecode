package datastructure.tree;

public class Node {
	Node leftChild;
	Object data;
	Node rightChild;
	
	public Node() {
		// TODO Auto-generated constructor stub
	}

	public Node(Node leftChild, Object data, Node rightChild) {
		super();
		this.leftChild = leftChild;
		this.data = data;
		this.rightChild = rightChild;
	}

	@Override
	public String toString() {
		return "Node [leftChild=" + leftChild + ", data=" + data
				+ ", rightChild=" + rightChild + "]";
	}
	
	
	
	
	
	
}
