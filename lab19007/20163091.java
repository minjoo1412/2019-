// Lab 007	: Disjoint Sets
// Name :
// Student ID :

import java.util.*;


class DisjointSets {
	int numofelements;  // the total number of elements in all the disjoint sets
	private int[] parent; // maintains the parent pointer of each element in the disjoint sets
	private int[] weight; // maintains the weight of each set


	DisjointSets() {
		// DisjointSets constructor.
	}

	public String toString() { // Show all the element in sequence
		String str = new String();
	    // Show the array elements in parent[]

		str = "parent[] = - ";
		for(int i = 1; i <= numofelements; i++)
			str += parent[i] + " ";
		return str;
	}

	void InitSet(int n) {
		// parent = 0, weight = 0
		numofelements = n;
		parent = new int[n+1];
		weight = new int[n+1];

		for(int i = 1; i<=n; i++){
			parent[i] = 0;
			weight[i] = 1;
		}
		// Initialize the array parent[] and weight[]

	}

	boolean Union(int i, int j) {
	// Union the set that contains i and the set that contains j
	// the set that has larger weight is the new root of the unioned set
	// when the weights are the same, choose the root of smaller value

		// first find the root of i and j
		if(SimpleFind(i) == SimpleFind(j)){
			return false;
		}

		int uni = SimpleFind(i);
		int unj = SimpleFind(j);

		if(weight[uni] > weight[unj]){
			parent[unj] = uni;
			weight[uni] += weight[unj];
			weight[unj] = 0;
		}else if(weight[uni] < weight[unj]){
			parent[uni] = unj;
			weight[unj] += weight[uni];
			weight[uni] = 0;
		}else{
			if(uni > unj){
				parent[unj] = uni;
				weight[uni] += weight[unj];
				weight[unj] = 0;
			}else{
				parent[uni] = unj;
				weight[unj] += weight[uni];
				weight[uni] = 0;
			}
		}



		return true;
	}

	int SimpleFind(int i) {
	// return the root node that contains the element i


		int root = i;

		while(parent[root] != 0){
			root = parent[root];
		}


		return root;
	}
}
