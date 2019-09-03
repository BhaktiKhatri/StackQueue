package Stack_Queue;

import java.util.Arrays;
import java.util.Collections;
import java.util.NoSuchElementException;

public class ImplementCircularQueue {

	public int head = 0;
	public int tail = 0;
	public int numQueueElements = 0;
	public static final int SCALE_FACTOR = 2;
	public Integer[] enteries;
	
	public ImplementCircularQueue(int capacity) {
		enteries = new Integer[capacity];
	}
	
	public void enqueue(Integer x) {
		if(numQueueElements == enteries.length) {	//Need to resize queue
			//Makes the queue element appear consecutively
			Collections.rotate(Arrays.asList(enteries), -head);
			//Resets head and tail
			head = 0;
			tail = numQueueElements;
			enteries = Arrays.copyOf(enteries, numQueueElements * SCALE_FACTOR);
		}
		
		enteries[tail] = x;
		tail = (tail + 1) % enteries.length;
		++numQueueElements;
	}
	
	public Integer dequeue() {
		if(numQueueElements != 0) {
			--numQueueElements;
			Integer ret = enteries[head];
			head = (head + 1) % enteries.length;
			return ret;
		}
		throw new NoSuchElementException("Dequeue called on an empty queue");
	}
	
	public int size() {
		return numQueueElements;
	}
	
	public static void main(String[] args) {

	}

}
