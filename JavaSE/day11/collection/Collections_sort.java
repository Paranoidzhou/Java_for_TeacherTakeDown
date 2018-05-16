package collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * 排序集合
 * 排序集合可以使用集合的工具类:
 * java.util.Collections
 * 
 * 其定义了很多静态方法,用于操作集合.其中sort方法
 * 是对List集合进行自然排序(从小到大)
 * 
 * @author adminitartor
 *
 */
public class Collections_sort {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		Random random = new Random();
		for(int i=0;i<10;i++){
			list.add(random.nextInt(100));
		}
		System.out.println(list);		
		Collections.sort(list);	
		System.out.println(list);
	}
}












