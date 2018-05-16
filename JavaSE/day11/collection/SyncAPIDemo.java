package collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 线程安全的集合
 * 
 * 常用的集合实现类:ArrayList,LinkedList,HashSet
 * 它们都不是线程安全的,多线程情况下使用会出现并发
 * 安全问题.
 * 
 * Collections提供了将集合转换为线程安全的方法.
 * @author adminitartor
 *
 */
public class SyncAPIDemo {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("one");
		list.add("two");
		list.add("three");
		list.add("four");
		System.out.println(list);
		//将该集合转换为线程安全的
		list = Collections.synchronizedList(list);
		System.out.println(list);
		
		Set<String> set = new HashSet<String>(list);
		System.out.println(set);
		set = Collections.synchronizedSet(set);
		System.out.println(set);
		
		/*
		 * API手册中有说明,就算是一个线程安全的集合
		 * 也不和迭代器遍历做互斥,所以若并发操作时存在
		 * 有遍历操作时要自行维护他们之间的互斥关系
		 */
	}
}






