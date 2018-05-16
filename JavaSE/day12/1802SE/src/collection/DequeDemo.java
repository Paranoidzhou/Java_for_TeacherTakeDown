package collection;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 双端队列
 * java.util.Deque接口,它继承自java.util.Queue
 * 
 * 双端队列的特点是两端都可以进出队
 * @author adminitartor
 *
 */
public class DequeDemo {
	public static void main(String[] args) {
		Deque<String> deque 
			= new LinkedList<String>();
		
		deque.offer("one");
		deque.offer("two");
		System.out.println(deque);
		//从队首方向入队
		deque.offerFirst("three");
		System.out.println(deque);
		//从队尾方向入队
		deque.offerLast("four");
		System.out.println(deque);
		
		//获取元素
		String str = deque.poll();
		System.out.println(str);
		System.out.println(deque);
		
		str = deque.pollFirst();
		System.out.println(str);
		System.out.println(deque);
		
		str = deque.pollLast();
		System.out.println(str);
		System.out.println(deque);
		
	}
}








