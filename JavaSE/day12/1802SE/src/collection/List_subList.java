package collection;

import java.util.ArrayList;
import java.util.List;

/**
 * List subList(int s,int e)
 * 截取指定范围内的子集
 * @author adminitartor
 *
 */
public class List_subList {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		for(int i=0;i<10;i++){
			list.add(i);
		}
		System.out.println(list);
		//获取3-7
		List<Integer> subList = list.subList(3, 8);
		System.out.println(subList);
		
		//将子集元素扩大10倍
		for(int i=0;i<subList.size();i++){
			subList.set(i, subList.get(i)*10);
		}
		System.out.println(subList);
		/*
		 * 对子集元素操作就是对原集合对应元素的操作
		 */
		System.out.println(list);
		
		/*
		 * 删除list集合2-8
		 */
		System.out.println(list);
		list.subList(2, 9).clear();
		System.out.println(list);
	}
}








