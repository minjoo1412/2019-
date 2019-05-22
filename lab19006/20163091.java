import java.util.*;

/**
 */

class ArrayTree  {
	int[] tree; // tree

	int largestNum;	// the largest node number in the binary tree
	int capacity;	// size of the tree tree


	ArrayTree(int theCapacity) { // ArrayTree constructor.
		capacity = theCapacity;
		tree = new int[capacity];	// tree[0] is not used
		largestNum = 0;
	}

	public String toString() { // Show all the element in sequence
		String str = new String();
		str = "Tree : - ";

		// print all the nodes in the tree
		for(int i = 1; i <= largestNum; i++)
			str += tree[i] + "  ";
		return str;
	}

	void  Init(int[] es, int n) {
		// initialize the tree by using the input
		largestNum = n;
		for(int i = 1; i <= n; i++)
			tree[i] = es[i];
	}

	void  PreOrder(int node) {
		if(node > largestNum)
			return;

		//	NEED TO IMPLEMENT
		if(tree[node] != 0){
				System.out.print(tree[node] + " ");
		}
		PreOrder(2*node);
		PreOrder((2*node)+1);
	}

	void  InOrder(int node) {
		if(node > largestNum)
			return;
		//	NEED TO IMPLEMENT
		InOrder(2*node);
		if(tree[node] != 0){
			System.out.print(tree[node] + " ");
		}
		InOrder((2*node) + 1);
	}

	void  PostOrder(int node) {
		if(node > largestNum)
			return;

		//	NEED TO IMPLEMENT
		PostOrder(2*node);
		PostOrder((2*node)+1);
		if(tree[node] != 0){
			System.out.print(tree[node] + " ");
		}
	}
}
