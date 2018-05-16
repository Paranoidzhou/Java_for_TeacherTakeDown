package collection;

import java.util.ArrayList;
import java.util.List;

/**
 * java.util.List 线性表
 * List的特点:可重复集,并且有序.可以通过下标操作
 * 元素
 * 常用实现类:
 * ArrayList:内部由数组实现,查询快,增删慢
 * LinkedList:内部由链表实现,查询慢,增删快(首位
 *            增删效率最优)
 * 对于性能不是极端苛刻情况下,通常使用ArrayList
 * 
 * @author adminitartor
 *
 */
public class List_get_set {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("one");
		list.add("two");
		list.add("three");
		list.add("four");
		System.out.println(list);		
		/*
		 * E get(int index)
		 * 获取指定位置对应的元素
		 */
		//String str = arr[1];
		String str = list.get(1);
		System.out.println(str);
		
		//传统for循环可以遍历List集合
		for(int i=0;i<list.size();i++){
			str = list.get(i);
			System.out.println(str);
		}
		
		/*
		 * E set(int index,E e)
		 * 将指定元素设置到指定位置,返回值为原
		 * 位置对应的元素.所以是替换元素操作.
		 */
		//[one,2,three,four]
		String old = list.set(1, "2");
		System.out.println(list);
		System.out.println("old:"+old);
	}
}








