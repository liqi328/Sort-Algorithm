package search.test;

import search.BinarySortTree;

public class BinarySortTreeTest {
	public static void main(String[] args){
		int[] array = {23,12,43,2,87,54};  
		BinarySortTree bst = new BinarySortTree();
		for(int i = 0; i < array.length; ++i){
			bst.insertBST(array[i]);
		}
		
		bst.inOrderTraverse();
		
		if(null != bst.searchBST(89)){
			System.out.println("founded.");
		}else{
			System.out.println("Not founded.");
		}
		
		bst.deleteBST(23);
		bst.inOrderTraverse();
		
		bst.deleteBST(45);
	}
}
