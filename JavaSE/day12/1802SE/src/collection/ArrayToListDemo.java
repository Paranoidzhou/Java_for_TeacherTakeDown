package collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 数组转换为集合
 * 通过集合的工具类Arrays的静态方法asList可以将
 * 一个数组转换为List集合.
 * @author adminitartor
 *
 */
public class ArrayToListDemo {
	public static void main(String[] args) {
		String[] array = {"one","two","three","four"};
		
		List<String> list = Arrays.asList(array);
		System.out.println("size:"+list.size());
		for(String str : list){
			System.out.println(str);
		}
		
		list.set(0, "1");
		System.out.println("list:"+list);
		//对集合元素操作就是对数组元素操作
		System.out.println("array:"+Arrays.toString(array));
		/*
		 * 由于添加元素会导致数组扩容,那就不能表示
		 * 原数组,所以这样的操作在数组转换的集合中
		 * 是不支持的!调用add,remove会抛出异常
		 */
//		list.add("five");
	
		//若想对集合增删元素,需复制一个集合
		List<String> list1 
			= new ArrayList<String>(list);
		
		System.out.println("list1:"+list1);
		list1.add("five");
		System.out.println("list1:"+list1);
	}
}







