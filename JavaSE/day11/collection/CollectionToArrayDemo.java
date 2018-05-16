package collection;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 集合转换为数组
 * Collection提供了一个方法:toArray,可以将当前
 * 集合转换为一个数组
 * @author adminitartor
 *
 */
public class CollectionToArrayDemo {
	public static void main(String[] args) {
		Collection<String> c = new ArrayList<String>();
		c.add("one");
		c.add("two");
		c.add("three");
		c.add("four");
		System.out.println(c);
		
//		Object[] arr = c.toArray();
		
		String[] arr = c.toArray(new String[c.size()]);
		System.out.println("len:"+arr.length);
		for(String str : arr){
			System.out.println(str);
		}
		
	}
}









