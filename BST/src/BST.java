import java.util.LinkedList;
import java.util.Queue;

public class BST<T extends Comparable<T>> {

	BSTNode<T> root;
	private BST <T>tree;
	Object [] array;
	boolean found; // used by remove

	// for traversals
	protected Queue<T> inOrderQueue; // queue of info
	protected Queue<T> preOrderQueue; // queue of info
	protected Queue<T> postOrderQueue; // queue of info

	public BST()
	// Creates an empty BST object.
	{
		root = null;
	}

	public int size()
	// Returns the number of elements in this BST.
	{
		return recSize(root);
	}
	private int recSize(BSTNode<T> tree)
	// Returns the number of elements in tree.
	{
	  if (tree == null)    
	    return 0;
	  else
	    return recSize(tree.getLeft()) + recSize(tree.getRight()) + 1;
	} 

	public void add (T element)
	// Adds element to this BST. The tree retains its BST property.
	{
	  root = recAdd(element, root);
	}
	private BSTNode<T> recAdd(T element, BSTNode<T> tree)
	// Adds element to tree; tree retains its BST property.
	{
	  if (tree == null)
	    // Addition place found
	    tree = new BSTNode<T>(element);
	  else if (element.compareTo(tree.getInfo()) <= 0)
	    tree.setLeft(recAdd(element, tree.getLeft()));     // Add in left subtree
	  else
	    tree.setRight(recAdd(element, tree.getRight()));   // Add in right subtree
	  return tree;
	} 
	
	public int reset(BSTOrder orderType)
	// Initializes current position for an iteration through this BST
	// in orderType order. Returns current number of nodes in the BST.
	{
	  int numNodes = size();
	  if (orderType == BSTOrder.INORDER)
	  {
	    inOrderQueue = new LinkedList<T>();
	    inOrder(root);
	  }
	  else
	  if (orderType == BSTOrder.PREORDER)
	  {
	    preOrderQueue = new LinkedList<T>();
	    preOrder(root);
	  }
	  if (orderType == BSTOrder.POSTORDER)
	  {
	    postOrderQueue = new LinkedList<T>();
	    postOrder(root);
	  }
	  return numNodes;
	} 

	private void inOrder(BSTNode<T> tree)
	// Initializes inOrderQueue with tree elements in inOrder order
	{
	  if (tree != null)
	  {
	    inOrder(tree.getLeft());
	    inOrderQueue.add(tree.getInfo());
	    inOrder(tree.getRight());
	  }
	}
	
	
	private void preOrder(BSTNode<T> tree)
	// Initializes inOrderQueue with tree elements in inOrder order
	{
	  if (tree != null)
	  {
		inOrderQueue.add(tree.getInfo());
	    inOrder(tree.getLeft());
	    inOrder(tree.getRight());
	  }
	}
	
	private void postOrder(BSTNode<T> tree)
	// Initializes inOrderQueue with tree elements in inOrder order
	{
	  if (tree != null)
	  {
	    inOrder(tree.getLeft());
	    inOrder(tree.getRight());
		inOrderQueue.add(tree.getInfo());
	  }
	}

	public Queue<T> getInOrderQueue() {
		return inOrderQueue;
	}

	public void setInOrderQueue(Queue<T> inOrderQueue) {
		this.inOrderQueue = inOrderQueue;
	}

	public Queue<T> getPreOrderQueue() {
		return preOrderQueue;
	}

	public void setPreOrderQueue(Queue<T> preOrderQueue) {
		this.preOrderQueue = preOrderQueue;
	}

	public Queue<T> getPostOrderQueue() {
		return postOrderQueue;
	}

	public void setPostOrderQueue(Queue<T> postOrderQueue) {
		this.postOrderQueue = postOrderQueue;
	}
	public T getNext (BSTOrder orderType)
	// Preconditions: the BST is not empty
//	                the BST has been reset for orderType
//	                the BST has not been modified since the most recent reset
//	                the end of orderType iteration has not been reached
	// Returns the element at the current position on this BST and advances 
	// the value of the current position based on the orderType set by reset. 
	{
	  if (orderType == BSTOrder.INORDER)
	    return inOrderQueue.remove();
	  else
	  if (orderType == BSTOrder.PREORDER)
	    return preOrderQueue.remove();
	  else
	  if (orderType == BSTOrder.POSTORDER)
	    return postOrderQueue.remove();
	  else return null;
	} 

	public void reBalancing() {
		int count = reset(BSTOrder.INORDER);
		array = new Object[count];
		System.out.println(count);
		for(int i=0; i<count; i++) {
			array[i] = getNext(BSTOrder.INORDER);
			System.out.println(array[i]);
		}
		tree = new BST<T>();
	//	for(int i=0; i<count; i++) {
			tree.InsertTree(0,count-1, array);
		//}
	}

	private void InsertTree(int low, int high, Object []a) {
		// TODO Auto-generated method stub
		
		for(int i=0; i<high; i++) {
			System.out.println(a[i]);
		}
		int mid;
		if (low==high) {
			tree.add((T)array[low]);
			System.out.println((T)array[low]);
		} else if((low+1)==high) {
			tree.add((T)array[low]);
			System.out.println((T)array[low]);
			tree.add((T)array[high]);
			System.out.println((T)array[high]);
		} else {
			mid = (low+high)/2;
			System.out.println(mid);
			tree.add((T)array[mid]);
			System.out.println((T)array[mid]);
			//tree.InsertTree(low, mid-1);
		//	tree.InsertTree(mid+1, high);
		}
	}
	

}
