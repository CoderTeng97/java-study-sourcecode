package datastructure.linear.linearlist;


public class SingleLinkedList<E> implements List<E>{

	private  int size;
	private Node head;
	public SingleLinkedList() {
		// TODO Auto-generated constructor stub
		head = new Node();
	}


	public int size() {
		// TODO Auto-generated method stub
		return size;
	}



	public boolean isEmpty() {
		// TODO Auto-generated method stub
		if(head.next == null){
			return true;
		}
		return false;
	}


	public boolean contains(Object e) {
		// TODO Auto-generated method stub
		return false;
	}


	public int indexOf(Object e) {
		// TODO Auto-generated method stub
		return 0;
	}


	public boolean add(E e) {
		// TODO Auto-generated method stub
		return add(size,e);
	}


	public boolean add(int index, E e) {
		// TODO Auto-generated method stub
		//判断下标是否越界
		rangeCheck(index);
		//找到下标对应节点元素

		Node node = head;
		for(int i = 0; i< index ;i++){
			node = node.next;
		}
		//创建新的节点
		Node newNode = new Node();
		newNode.data = e;
		//对应一个后驱节点
		newNode.next = node.next;
		//对应一个前驱节点
		node.next = newNode;
		size++;
		return true;
	}


	public Object get(int index) {
		// TODO Auto-generated method stub
		Node node = head.next;
		for(int i = 0; i< index ;i++){
			node = node.next;
		}
		return node.data;
	}


	public boolean remove(int index) {
		// TODO Auto-generated method stub
		return false;
	}


	public boolean remove(Object e) {
		// TODO Auto-generated method stub
		return false;
	}


	public boolean replace(int index, Object e) {
		// TODO Auto-generated method stub
		return false;
	}

	private void rangeCheck(int index){
		if(index < 0 || index > size){
			throw new RuntimeException("下标越界异常 " + index);
		}
	}


	@Override
	public String toString() {
		Node node = head.next;
		if(head.next == null){
			return null;
		}
		StringBuilder stringBuilder = new StringBuilder("[");
		for(int i=0;i<size;i++){
			if(i == size -1){
				stringBuilder.append(node.data);
			}else{
				stringBuilder.append(node.data +",");
			}
			node = node.next;
		}
		stringBuilder.append("]");
		return stringBuilder.toString();

	}

}
