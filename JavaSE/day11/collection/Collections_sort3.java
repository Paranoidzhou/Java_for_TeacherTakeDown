package collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 
 * @author adminitartor
 *
 */
public class Collections_sort3 {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("苍老师");
		list.add("传奇");
		list.add("小泽老师");
		System.out.println(list);
		/*
		 * 除了有侵入性之外,该sort方法还有一个问题
		 * 就是若元素已经实现了Comparable接口并定义
		 * 了比较规则,但是该规则不满足我们实际排序需
		 * 求时也没有办法,比如String,该类也不允许我们
		 * 重写它的方法.
		 */
//		Collections.sort(list);
		/*
		 * 推荐的排序方式
		 * 当遇到排序自定义类型元素,或者集合元素
		 * 自身的比较规则不满足排序时都建议使用
		 * 下面的方式排序.
		 * 该sort方法要求额外传入一个比较器,并按照
		 * 比较器规则比较集合元素并进行排序.因此该
		 * 排序方法不要求集合元素实现Comparable接口
		 */
		Collections.sort(list, new Comparator<String>(){
			public int compare(String o1, String o2) {
				return o1.length()-o2.length();
			}
		});
		System.out.println(list);
	}
}









