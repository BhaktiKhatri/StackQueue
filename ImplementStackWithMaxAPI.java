package Stack_Queue;

import java.util.ArrayDeque;
import java.util.Deque;

class MaxWithCount {
	public Integer max;
	public Integer count;
	
	public MaxWithCount(Integer max, Integer count) {
		this.max = max;
		this.count = count;
	}
}

public class ImplementStackWithMaxAPI {

	public Deque<Integer> element = new ArrayDeque<>();
	public Deque<MaxWithCount> cachedMaxWithCount = new ArrayDeque<>();
	
	public boolean empty() {
		return element.isEmpty();
	}
	
	public Integer max() {
		if(empty()) {
			throw new IllegalStateException("max(): empty stack");
		}
		return cachedMaxWithCount.peekFirst().max;
	}
	
	public Integer pop() {
		if(empty()) {
			throw new IllegalStateException("pop(): empty stack");
		}
		
		Integer popElement = element.removeFirst();
		if(popElement.equals(cachedMaxWithCount.peekFirst().max)) {
			cachedMaxWithCount.peekFirst().count = cachedMaxWithCount.peekFirst().count - 1;
			if(cachedMaxWithCount.peekFirst().count.equals(0)) {
				cachedMaxWithCount.removeFirst();
			}
		}
		return popElement;
	}
	
	public void push(Integer x) {
		element.addFirst(x);
		
		if(!cachedMaxWithCount.isEmpty()) {
			if(Integer.compare(x, cachedMaxWithCount.peekFirst().max) == 0) {
				cachedMaxWithCount.peekFirst().count = cachedMaxWithCount.peekFirst().count + 1;
			}
			else if(Integer.compare(x, cachedMaxWithCount.peekFirst().max) > 0) {
				cachedMaxWithCount.addFirst(new MaxWithCount(x, 1));
			}
		}
		else {
			cachedMaxWithCount.addFirst(new MaxWithCount(x, 1));
		}
	}
	
	public static void main(String[] args) {

	}

}
