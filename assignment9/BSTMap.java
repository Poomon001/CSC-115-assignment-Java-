/**Poomrapee Chuthamsatid V00942601**/
/**30 March 2020**/
import java.util.*;

public class BSTMap<K extends Comparable<K>, V > implements  Map<K, V>  {
	BinarySearchTree<K,V> bst;
	
	public BSTMap () {
		bst = new BinarySearchTree<K,V>();
	}

	public boolean containsKey(K key) {
		BSTNode<K,V> root1 = bst.root;
		return containsKeyHelper(root1, key);
	}

	private boolean containsKeyHelper(BSTNode<K, V> root2, K key) {
	    
		//if there is no element in the root
		if(root2 == null) {
			
			//throw an exception
			return false;
		}else {
			
			//if the target key matches a key in the tree
			if (key.compareTo(root2.key) == 0) {
				return true;
			}//if
	
			//if a target key is less than root key
			if (key.compareTo(root2.key) < 0 ) {
				
				//go to left
				return containsKeyHelper(root2.left, key);
				
			//if a target key is more than root key
			} else { 
				
				//go to right
				return containsKeyHelper(root2.right, key);
			}//if
		}//else
		
	}//containsKeyHelper

	public V get (K key) throws KeyNotFoundException {
		return bst.find(key);
	}

	public List<Entry<K,V> >	entryList() {
		return bst.entryList();
	}

	public void put (K key, V value) {
		bst.insert(key, value);
	}

	public int size() {
		return bst.size();
	}

	public void clear() {
		bst.clear();
	}

}