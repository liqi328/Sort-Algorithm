package search;

public class BuildTree {

	public class Node{
		public Node lchild;
		public Node rchild;
		public char value;
	}
	
	public void rebuild(String preOrderStr, String inOrderStr, int len, Node root){
		if(preOrderStr == null || inOrderStr == null){
			return;
		}
		
		Node tmp = new Node();
		
	}
}
