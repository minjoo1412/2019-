import java.util.*;

/**
 * Generic version of the MyQueue class.
 * @param <T> the type of the value being queued
 */

class MyQueue <T> {
	private T[] queue;	// array for queue elements
	private int front, // one counterclockwise from front
	            rear, 	// array position of rear element
				capacity;	// capacity of queue array

	/**
	 * Create an empty queue whose initial capacity is cap
	 */
	@SuppressWarnings("unchecked")
	MyQueue(int cap) {
		capacity = cap;
		queue = (T []) new Object [capacity];
		front = rear = 0;
	}

	/**
	 * If number of elements in the queue is 0, return true else return false
	 */
	boolean IsEmpty() {

// NEED TO1 IMPLEMENT, capacity is 7
	if(rear != front){
		return false;
	}
		return true;
	}

	/**
	 * Add x at rear of queue
	 */
	void Push (T x) throws Exception {

// NEED TO IMPLEMENT
		if(IsEmpty()){
			queue[rear] = x;
			rear++;
			return;
		}
		if((rear + 1) % capacity == front){
			throw new Exception ("Queue is Full");
			// if queue full, throw the following message
		}
		rear = (rear + 1) % capacity;
		if(rear == 0){
			queue[capacity -1] = x;
		}else{
		queue[rear-1] = x;
		}
	}

	/**
	 * Delete front element from queue
	 */
	T Pop() throws Exception {
		// if queue is empty, throw the following message
		if(IsEmpty()){
			throw new Exception("Queue is empty. Cannot delete.");
		}

		T tmp;

		tmp = queue[front];
		queue[front] = null;
		front = (front+1)%capacity;

// NEED TO IMPLEMENT
		return tmp;
	}

	public String toString() {
		String a = new String();

		a = "Queue : ";

		if(front < rear){
			for(int i = front; i < rear; i++){
				a = a + queue[i] + " ";
			}
		}else if(front > rear){
			for(int i = front; i < capacity; i++){
				a = a + queue[i] + " ";
			}
			for(int i = 0; i < rear; i++){
				a = a + queue[i] + " ";
			}
		}

		a = a + "\n";
		a = a + "rear=" + rear + ", front=" + front;

// NEED TO IMPLEMENT


		return a;
	}
}
