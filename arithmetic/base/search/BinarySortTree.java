package base.search;
/*
 * 二叉排序树：又称二叉查找树。 是一颗空树，或满足下列条件的二叉树：
 * 1）若左子树不为空，咋左子树上所有节点均小于根节点的值；
 * 2）若右子树不为空，咋右子树上所有节点均大于根节点的值；
 * 3）左右子树也为二叉排序树
 */
public class BinarySortTree {
	private Node root;//根节点
	
	private class Node{
		int value;
		Node lChild;
		Node rChild;
		public Node(int value){
			this.value = value;
			this.lChild = null;
			this.rChild = null;
		}
	}
	//实例化一个空树
	public BinarySortTree(){
		root = null;
	}
	//建立二叉排序树的方法，根据上面的性质，传入当前结点，并传入该结点的值，最后通过循环来赋值
	void buildTree(Node node, int value){
		if(root==null){
			root = new Node(value);
		} else{
			if(value < node.value){
				//若当前结点没有左子树，就正好创建一个
				if(node.lChild==null){
					node.lChild = new Node(value);
				} else{
					//将当前结点的左结点作为当前结点传入本方法，直到创建一个左或右叶子结点
					buildTree(node.lChild, value);
				}
			} else{
				if(value > node.value){
					if(node.rChild==null){
						node.rChild = new Node(value);
					} else{
						buildTree(node.rChild, value);
					}
				}
			}
		}
	}
	
	//遍历方法，以中序为例，这里的输入应该是一个树的根节点，先判断根节点是否为空
	private void inOrder(Node node){
		if(node == null){
			return;
		}else{
			inOrder(node.lChild);
			System.out.print(node.value + " ");
			inOrder(node.rChild);
		}
	}
	
	//递归查找，这里可以返回一个结点，这里递归的出口就是node为空，因为栈中储存的各个左右子结点总有为null的时候
	private Node searchRec(Node node, int key){
		if(node == null){
			return null;
		} else if(node.value == key){
			return node;
		} else if(node.value < key){
			return search(node.rChild, key);
		} else{
			return search(node.lChild, key);
		}
	}
	//非递归查找
	private Node search(Node node, int key){
		while(node!=null){
			if(node.value == key){
				break;	//也可以用return node; 但是我想给方法一个统一的出口放在下面
			} else if(node.value <key){
				node = node.rChild;
			} else{
				node = node.lChild;
			}
		}
		return node;
	}
	
	//插入
	private boolean insert(Node node, int key){
		if(searchRec(node, key)==null){
			//递归法：和上面创建的时候一样
			if(root==null){
				root = new Node(key);
			} else{
				if(key < node.value){
					if(node.lChild==null){
						node.lChild = new Node(key);
					} else{
						buildTree(node.lChild, key);
					}
				} else{
					if(key > node.value){
						if(node.rChild==null){
							node.rChild = new Node(key);
						} else{
							buildTree(node.rChild, key);
						}
					}
				}
			}
			//非递归法：
			
			return true;
		}
		return false;
		
	}
	
	public static void main(String[] args) {
		int[] arr = {11,5,1,2,7,9,14,5,3,8};
		BinarySortTree bst = new BinarySortTree();
		for(int i=0; i<arr.length; i++){
			bst.buildTree(bst.root, arr[i]);
		}
		//遍历
		bst.inOrder(bst.root);
		System.out.println();
		System.out.println("--------------------");
		//查找
		System.out.println(bst.searchRec(bst.root, 7));
		System.out.println(bst.search(bst.root, 7));
	}

}
