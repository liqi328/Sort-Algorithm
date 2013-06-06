package search;


/**
 * 二叉排序树
 * 
 * @author Liqi
 *
 */
public class BinarySortTree {
	private BSTreeNode root = null;
	
	public BSTreeNode searchBST(int key){
		return searchBST(root, key);
	}
	
	public BSTreeNode searchBST(BSTreeNode cur, int key){
		if(cur == null || cur.data == key){
			return cur;
		}else if(cur.data > key){
			return searchBST(cur.lchild, key);
		}else{
			return searchBST(cur.rchild, key);
		}
	}
	
	public void insertBST(int key){
		BSTreeNode newNode = new BSTreeNode(key, null, null);
		if(root == null){
			root = newNode;
		}else{
			BSTreeNode p = root;
			BSTreeNode q = root;
			while(q != null){
				p = q;
				if(q.data < key){
					q = q.rchild;
				}else{
					q = q.lchild;
				}
			}
			if(p.data < key){
				p.rchild = newNode;
			}else{
				p.lchild = newNode;
			}
		}
	}
	
	private BSTreeNode parent(BSTreeNode child){
		BSTreeNode p = root;
		BSTreeNode q = null;
		while(p != null && p.data != child.data){
			q = p;
			if(p.data < child.data){
				p = p.rchild;
			}else{
				p = p.lchild;
			}
		}
		return q;
	}
	
	public void deleteBST(int key){
		BSTreeNode node = searchBST(key);
		if(node == null){
			System.out.println(key + " is not exist.");
			return;
		}
		delete(node);
	}
	
	private void delete(BSTreeNode deletedNode){
		if(deletedNode.lchild == null && deletedNode.rchild == null){
			BSTreeNode p = parent(deletedNode);
			if(p.lchild == deletedNode){
				p.lchild = null;
			}else{
				p.rchild = null;
			}
		}else if(deletedNode.lchild != null && deletedNode.rchild != null){
			BSTreeNode p = deletedNode, q = deletedNode.lchild;
			while(q.rchild != null){
				p = q;
				q = q.rchild;
			}
			deletedNode.data = q.data;
			if(p != deletedNode){
				p.rchild = q.lchild;
			}else{
				p.lchild = q.lchild;
			}
		}else{
			BSTreeNode p = parent(deletedNode);
			if(p.lchild == deletedNode){
				if(deletedNode.lchild != null){
					//左子树不为空
					p.lchild = deletedNode.lchild;
				}else{
					//右子树不为为空
					p.lchild = deletedNode.rchild;
				}
			}else{
				if(deletedNode.lchild != null){
					//左子树不为空
					p.rchild = deletedNode.lchild;
				}else{
					//右子树不为空
					p.rchild = deletedNode.rchild;
				}
			}
			
		}
	}
	
	public void inOrderTraverse(){
		inOrderTraverse(root);
		System.out.print("\n");
	}
	
	public void inOrderTraverse(BSTreeNode r){
		if(r != null){
			inOrderTraverse(r.lchild);
			System.out.print(r.data + "\t");
			inOrderTraverse(r.rchild);
		}
	}
	
	@Override
	public String toString(){
		StringBuffer sb = new StringBuffer();
		
		return sb.toString();
	}
}

class BSTreeNode{
	int data;
	BSTreeNode lchild;
	BSTreeNode rchild;
	
	public BSTreeNode(int data, BSTreeNode lchild, BSTreeNode rchild){
		this.data = data;
		this.lchild = lchild;
		this.rchild = rchild;
	}
}
