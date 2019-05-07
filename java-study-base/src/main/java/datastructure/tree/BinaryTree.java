package datastructure.tree;

/**
 * 二叉树
 * @author Teng
 *
 */
public interface BinaryTree {
	//是否为空数
	boolean isEmpty();
	//数节点数量
	int size();
	//树的高度或层次
	int getHeight();
	//查询指定值的节点
	Node findeKey(Object value);
	//先序遍历递归操作
	void preOrderTraverse();
	//中序遍历递归操作
	void inOrderTraverse();
	//后续遍历递归操作
	void postOrderTraverse();
	//遍历 非递归操作
	void preOrderByStack();
	void inOrderByStack();
	void postOrderByStack();

	//层次遍历
	void levelOrderByStack();



}