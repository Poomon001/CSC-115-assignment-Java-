/**Poomrapee Chuthamsatid V00942601**/
/**30 March 2020**/
import java.util.*;

//
// An implementation of a binary search tree.
//
// This tree stores both keys and values associated with those keys.
//
// More information about binary search trees can be found here:
//
// http://en.wikipedia.org/wiki/Binary_search_tree
//
// Note: Wikipedia is using a different definition of
//       depth and height than we are using.  Be sure
//       to read the comments in this file for the
//	 	 height function.
//
class BinarySearchTree <K extends Comparable<K>, V>  {

	public static final int BST_PREORDER  = 1;
	public static final int BST_POSTORDER = 2;
	public static final int BST_INORDER   = 3;

	// These are package friendly for the TreeView class
	BSTNode<K,V>	root;
	int		count;


	public BinarySearchTree () {
		root = null;
		count = 0;
	}//constructor


	//
	// Purpose:
	//
	// Insert a new Key:Value Entry into the tree.  If the Key
	// already exists in the tree, update the value stored at
	// that node with the new value.
	//
	// Pre-Conditions:
	// 	the tree is a valid binary search tree
	//
	public void insert (K k, V v) {

		//create a new node containing the new value and key to insert
		BSTNode<K,V> newNode = new BSTNode(k, v);
		
		//if root is null
		if(root == null) {
			//create an initial node
			root = newNode;
			
			//size +1
			count++;
		}else {
			
			//set focusNode to be root
			BSTNode<K,V> focusNode = root;
			
			//declare parent
			BSTNode<K,V> parent;
			
			while(true) {
				//to check if the new node is less than its parent, then go left, but More go right. Otherwise, update value
				//when it less than its parent
				
				//set parent to focusNode
				parent = focusNode;
				
				if(k.compareTo(focusNode.key) < 0) {
					 focusNode = focusNode.left; 
				
					 //if there is empty space, then place focuseNode
					 if(focusNode == null) {
						 parent.left = newNode;
						 
						//size +1
						 count++;
						 
						 //exit
						 return;
					 }//if
					 
				//when it more than its parent	 
				}else if(k.compareTo(focusNode.key) > 0){
					 focusNode = focusNode.right;
					 
					//if there is empty space, then place focuseNode
					 if(focusNode == null) {
						 parent.right = newNode;
						 
						//size +1
						count++;
							
						 //exit
						 return;
					 }//if
					 
			    //when the key is same, update the value
				}else {
					parent.value = v;
					
					//exit
					return;
				}//else
			}//while	
		}//else
		

	}//insert

	//
	// Purpose:
	//
	// Return the value stored at key.  Throw a KeyNotFoundException
	// if the key isn't in the tree.
	//
	// Pre-conditions:
	//	the tree is a valid binary search tree
	//
	// Returns:
	//	the value stored at key
	//
	// Throws:
	//	KeyNotFoundException if key isn't in the tree
	//
	public V find (K key) throws KeyNotFoundException  {
		return find(root, key);
	}//find

	
	//the method to find value of a specific key
	private V find(BSTNode<K, V> root2, K key) throws KeyNotFoundException{
		
		//if there is no element in the root
		if(root2 == null) {
			
			//throw an exception
			throw new KeyNotFoundException();
		}else {
		
			//System.out.println("output this key: " + root2.key);
			//System.out.println("output target key: " + key);
			//System.out.println("________________________________");
			
			//if the target key matches a key in the tree
			if (key.compareTo(root2.key) == 0) {
				return root2.value;
			}//if
	
			//if a target key is less than root key
			if (key.compareTo(root2.key) < 0 ) {
				
				//go to left
				return find(root2.left, key);
				
			//if a target key is more than root key
			} else { 
				
				//go to right
				return find(root2.right, key);
			}//if
		}//else
	}//find


	private boolean isEmpty() {
		return (root == null);
	}//isEmpty
	//
	// Purpose:
	//
	// Return the number of nodes in the tree.
	//
	// Returns:
	//	the number of nodes in the tree.
	public int size() {
		return count;
	}//size

	//
	// Purpose:
	//	Remove all nodes from the tree.
	//
	public void clear() {
	this.root = null;
	this.count = 0;
	}//clear

	//
	// Purpose:
	//
	// Return the height of the tree.  We define height
	// as being the number of nodes on the path from the root
	// to the deepest node.
	//
	// This means that a tree with one node has height 1.
	//
	// Examples:
	//	See the assignment PDF and the test program for
	//	examples of height.
	//
	public int height() {
		//if root is not null, call helperHeight method
		if(root != null) {
			return helperHeight(root);
		}//if
		return 0;
	}//height

	//A method that count and compare the height of left and right subtree
	private int helperHeight(BSTNode<K,V> root2) {
		/*
		//to store left height
		int leftHeight = 0;
		
		//to store right height
		int rightHeight = 0;
		
		//if left subtree is not null, recursively recall this method
		if(root.left != null) {
			
			//set root to its left child
			root = root.left;
			
			//recall this method and store result to leftHight
			leftHeight = helperHeight();
		}//if
		
		//if right subtree is not null, recursively recall this method
		if(root.right != null) {
			
			//set root to its right child
			root = root.right;
			
			//recall this method and store result to leftHight
			rightHeight = helperHeight();
		}//if
		
		
		return 1 + Math.max(leftHeight, rightHeight);
		*/
		
		//when root is empty, return 0
		if(root2 == null) {
			return 0;
		}else {
			//to store left height
			int leftHeight = helperHeight(root2.left);
			
			//to store right height
			int rightHeight = helperHeight(root2.right);
			
			//return height of the tree
			return 1 + Math.max(leftHeight, rightHeight);
		}
	}//helperHeight


	//
	// Purpose:
	//
	// Return a list of all the key/value Entrys stored in the tree
	// The list will be constructed by performing a level-order
	// traversal of the tree.
    //
    // A level order traversal of a tree cannot be done without the help
    //  of a secondary data structure
    //
    // It is commonly implemented using a queue of nodes as the secondary
    //  data structure.
    //  You will still be adding the "visited" elements to l as you do in the other
    //  traversal methods but you will create an additional q to hold nodes still to visit
    //
    //  From wikipedia (they call it breadth-first), the algorithm for level order is:
    //
    //    levelorder()
    //        q = empty queue
    //        q.enqueue(root)
    //        while not q.empty do
    //            node := q.dequeue()
    //            visit(node)
    //            if node.left != null then
    //                  q.enqueue(node.left)
    //            if node.right != null then
    //                  q.enqueue(node.right)
    //
    // Note that you can use the Java LinkedList as a Queue
    //  and then use only the removeFirst() and addLast() methods on q
    //
	public List<Entry<K,V> >	entryList() {
		List<Entry<K,V> > l = new LinkedList<Entry<K,V> >();
		
		//      q = empty queue
		List<BSTNode<K,V>> queue = new LinkedList<BSTNode<K,V>>();
		BSTNode<K,V> node;
		
		//q.enqueue(root)
		queue.add(root);	
		
		//while not q.empty do
		while(!queue.isEmpty()) {
			
			//node := q.dequeue()
			node = queue.get(0);
			queue.remove(0);
			
			//visit(node)
			l.add(new Entry<K,V>(node.key, node.value));
			
			//if node.left != null then  
			if(node.left != null) { 
				
				//q.enqueue(node.left)
				queue.add(node.left);
			}//if
			
			// if node.right != null then
			if(node.right != null) { 
				
				//q.enqueue(node.right)
				queue.add(node.right);
			}//if
		}//while
		return l;
	}

	//
	// Purpose:
	//
	// Return a list of all the key/value Entrys stored in the tree
	// The list will be constructed by performing a traversal
	// specified by the parameter which.
	//
	// If which is:
	//	BST_PREORDER	perform a pre-order traversal
	//	BST_POSTORDER	perform a post-order traversal
	//	BST_INORDER	perform an in-order traversal
	//
	public List<Entry<K,V> > entryList (int which) {
		List<Entry<K,V> > l = new LinkedList<Entry<K,V>>();
		BSTNode<K,V> n = root;
		
		//determine the cases
		switch(which) {
		case 1:
			preOrder(n, l);
			break;
		case 2:
			postOrder(n, l);
			break;
		case 3:
			inOrder(n, l);
		}//switch
		return l;
	}

	private void inOrder(BSTNode<K, V> n, List<Entry<K, V>> l) {
		if(n != null) {
			//add the root element (first root)
			inOrder(n.left, l);
			l.add(new Entry<K,V>(n.key, n.value));
			
			inOrder(n.right, l);
		}else {
			return;
		}
	}//inOrder


	private void postOrder(BSTNode<K, V> n, List<Entry<K, V>> l) {
		if(n != null) {
			//add the root element (first root)
			postOrder(n.left, l);
			
			postOrder(n.right, l);
			
			l.add(new Entry<K,V>(n.key, n.value));
		}else {
			return;
		}
	}//postOrder


	private void preOrder(BSTNode<K,V> n, List <Entry<K,V> > l) {
		if(n != null) {
			l.add(new Entry<K,V>(n.key, n.value));
			
			//add the root element (first root)
			preOrder(n.left, l);
			
			preOrder(n.right, l);
		}else {
			return;
		}

	}//preOrder
	
	// Your instructor had the following private methods in their solution:
	// private void doInOrder (BSTNode<K,V> n, List <Entry<K,V> > l);
	// private void doPreOrder (BSTNode<K,V> n, List <Entry<K,V> > l);
	// private void doPostOrder (BSTNode<K,V> n, List <Entry<K,V> > l);
	// private int doHeight (BSTNode<K,V> t)
}