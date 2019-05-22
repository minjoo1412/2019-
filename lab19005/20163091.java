import java.util.*;

/**
 * Generic version of the SortedList class.
 */

class SortedList <T extends Comparable<T> > {

	class SortedListNode <U extends Comparable<U> >{
	    U data; // storage for data
		SortedListNode<U> link;    // link to the next node
	};

	private SortedListNode<T> first; // pointer to the dummy header node
	private SortedListNode<T> av; // pointer to the available list

	public SortedList() {
		av = null;
		first = null;
	}

	void Init(T data) { // SortedList constructor. Create a dummy first node
		first = GetNode();
		first.data = data;
		first.link = first;
	}


	void Clear() {
		if(av != null){
			SortedListNode<T> k = first.link;
			SortedListNode<T> l = av;
			while(k.link != first){
				k = k.link;
			}

			k.link = null;

			while(l.link != null){
				l = l.link;
			}

			l.link = first;
		}else{
			if(first.link == first){
				av = null;
				return;
			}
			//av value up
			av = first;
			SortedListNode<T> j = first.link;
			while(j.link != first){
				j = j.link;
			}
			j.link = null;
		}
	}

	SortedListNode<T> GetNode() {
		SortedListNode<T> x = null;
		if(av == null){
			x = new SortedListNode<T>();
			x.data = null;
			x.link = x;
		}else{
			if(av.link == null){
				av.link = av;
				x = av;
				av = null;
			}else{
				x = av;
				av = av.link;
				x.link = x;
			}
		}
		return x;
	}


	void  Insert(T e) {
		SortedListNode<T> x = GetNode();
		x.data = e;

		SortedListNode<T> p = first;

		if(p.link == p){
			p.link = x;
			x.link = p;
			return;
		}

		SortedListNode<T> sort = p.link;
		SortedListNode<T> tmp = p;

		while((sort.data).compareTo(e) < 0){

			if(sort.link == null){//this is last elemental
				sort.link = x;
				x.link = first;
				return;
			}
			tmp = sort;
			sort = sort.link;
		}

		x.link = sort;
		tmp.link = x;
		return;
	}


	public String toString() {
		String str = "";

		if(first == null) return "";
		SortedListNode<T> p = first.link;

		str += "List : ";
		// traverse all the nodes
		while (p != first) {
			str += p.data + "  ";
			p = p.link;
		}
		str += "\n";

		p = av;
		// show the count of av list
		int cnt = 0;
		while (p != null) {
			cnt++;
			p = p.link;
		}
		str +=  "Av : " + cnt;

		return str;
	}
};
