package lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LambdaDemo2 {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("范传奇");
		list.add("克晶");
		list.add("李美丽同学");
		list.add("小泽老师");
		//按照字符多少排序
		Collections.sort(list,new Comparator<String>(){
			public int compare(String o1, String o2) {
				return o1.length()-o2.length();
			}	
		});
		System.out.println(list);
		/*
		 * 参数无需指定类型(指定也可以),编译器会结合上下文
		 * 判定参数类型.
		 * 若方法需要返回值,而方法只有一行代码时,在忽略{}
		 * 的同时,return关键字也要忽略.
		 */
		Collections.sort(
			list,(o1,o2)->o1.length()-o2.length()
		);
	}
}





