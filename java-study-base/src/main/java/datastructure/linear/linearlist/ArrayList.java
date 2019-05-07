package datastructure.linear.linearlist;


/**
 *
 * @author Teng
 *
 *         顺序表的实现 ArrayList 底层模拟
 *
 * @param <E>
 */
public class ArrayList<E> implements List<E> {
	// 数组中元素的个数
	private int size;
	// 数组
	private Object[] elementData;

	private static final int DEFAULTCAPACITY = 4;

	public ArrayList() {
		// TODO Auto-generated constructor stub
		this(DEFAULTCAPACITY);
	}

	public ArrayList(int capacity) {
		// TODO Auto-generated constructor stub
		elementData = new Object[capacity];
	}


	public int size() {
		// TODO Auto-generated method stub
		return size;
	}



	public boolean isEmpty() {
		// TODO Auto-generated method stub
		if (size == 0) {
			return true;
		}
		return false;
	}


	public boolean contains(Object e) {
		// TODO Auto-generated method stub
		if(find(e) == -1){
			return false;
		}
		return true;
	}


	public int indexOf(Object e) {
		// TODO Auto-generated method stub
		return find(e);
	}


	public boolean add(E e) {
		// TODO Auto-generated method stub
		return add(size,e);
	}


	public boolean add(int index, E e) {
		rangeCheck(index);
		// TODO Auto-generated method stub
		if (size == elementData.length) {
			// expand array capacity 50%
			group();
		}
		for (int i = size; i > index ; i--) {
			elementData[i] = elementData[i-1];
		}
		elementData[index] = e;
		size++;
		return true;
	}
	//FIXME
	public boolean remove(int index) {
		// TODO Auto-generated method stub
		rangeCheck(index);
		for(int i=index ; i< size - 1; i++){
			elementData[i]=elementData[i+1];
		}
		elementData[size] = null;
		size--;
		return true;
	}


	public boolean remove(Object e) {
		// TODO Auto-generated method stub
		int index = find(e);
		if(index == -1){
			throw new RuntimeException("元素未找到异常");
		}
		return this.remove(index);
	}


	public boolean replace(int index, Object e) {
		// TODO Auto-generated method stub
		rangeCheck(index);
		elementData[index] = e;
		return false;
	}

	@Override
	public String toString() {
		if(elementData.length == 0){
			return null;
		}
		StringBuilder stringBuilder = new StringBuilder("[");
		for(int i=0;i<size;i++){
			if(i == size -1){
				stringBuilder.append(elementData[i]);
			}else{
				stringBuilder.append(elementData[i] +",");
			}
		}
		stringBuilder.append("]");
		return stringBuilder.toString();

	}

	/**
	 * 扩展数组容量（默认容量50%）
	 */
	private void group() {
		Object[] newElementData = new Object[elementData.length
				+ DEFAULTCAPACITY / 2];
		for (int i = 0; i < elementData.length; i++) {
			newElementData[i] = elementData[i];
		}
		elementData = newElementData;
	}

	/**
	 * 在数组中查找元素
	 * @param e
	 * @return
	 */
	private int  find(Object e){
		if(null == e){
			for (int i = 0; i < elementData.length; i++) {
				if(elementData[i] == null){
					return i;
				}
			}
		}
		//可以使用其他排序算法优化，此处顺序查找
		for (int i = 0; i < elementData.length; i++) {
			if(e.equals(elementData[i])){
				return i;
			}
		}
		return -1;
	}


	public Object get(int index) {
		// TODO Auto-generated method stub
		rangeCheck(index);
		return elementData[index];
	}

	private void rangeCheck(int index){
		if(index < 0 || index > size){
			throw new RuntimeException("下标越界异常 " + index);
		}
	}
}
