package collection;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 泛型是编译器认可,而非虚拟机.
 * 泛型不指定,原型就是Object.
 * 泛型只是用来让编译器辅助做了一些事情
 * 1:设置泛型类型值时,编译器辅助检查数据类型是否匹配
 * 2:获取泛型类型值时,编译器会添加向下造型语句.
 * @author adminitartor
 *
 */
public class CollectionDemo8 {
	public static void main(String[] args) {
		Collection<Integer> c1 = new ArrayList<Integer>();
		c1.add(1);
		c1.add(2);
		c1.add(3);
		for(Integer i : c1){
			System.out.println(i);
		}		
		//不指定泛型则默认为原型Object
		Collection c2 = c1;
		c2.add("four");		
		//遍历时会出现类造型异常
		for(Integer i : c1){
			System.out.println(i);
		}
	}
}










