package datastructure.linear.linearlist;



public interface List<E> {
	//返回线性表得大小
	int size();
	//判断线性表是否为空
	boolean isEmpty();
	//判断是否包含元素 e
	boolean contains(Object e);
	//返回元素e在线性表中的位置
	int indexOf(Object e);
	//添加一个元素
	boolean add(E e);
	//在下标为i的位置添加一个元素
	boolean add(int index,E e);
	//按下标查找元素
	Object get(int index);
	//移除一个下标为i的元素
	boolean remove(int index);
	//移除元素
	boolean remove(Object e);
	boolean replace(int index ,Object e);

}
