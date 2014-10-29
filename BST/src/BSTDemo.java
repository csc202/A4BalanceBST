
public class BSTDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] list = {10,7,5,1,15,12,18};
		BST <Integer> aBst = new BST<Integer>();
		for (int n:list) {
			aBst.add(n);
		}
		//aBst.reset(BSTOrder.INORDER);
		//int middle = aBst.size();
		
		
		
		
		//System.out.println(aBst.getInOrderQueue());
		aBst.reBalancing();
///		System.out.println(aBst.getInOrderQueue());

	}
	
	

}
