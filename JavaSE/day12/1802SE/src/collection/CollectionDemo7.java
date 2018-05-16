package collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * JDK1.5之后推出的一个特性:泛型
 * 泛型也称为参数化类型,他可以用于指定一个类中的
 * 属性类型,方法参数的类型以及返回值类型等.这样做
 * 的好处是将类型的定义权交给了调用者,而不再是提供
 * 者决定,提高了灵活性.
 * 泛型在集合中广泛被使用,用于指定集合中的元素类型.
 * 若不指定泛型,则默认为原型Object
 * 
 * 
 * @author adminitartor
 *
 */
public class CollectionDemo7 {
	public static void main(String[] args) {
		Collection<String> c = new ArrayList<String>();
		//编译后的class文件:
//		Collection c = new ArrayList();
		/*
		 * 当调用方法传入泛型约束的参数时,编译器
		 * 会检查实际参数是否符合该参数指定的泛型
		 * 类型,不符合编译不通过.
		 * 由于当前集合泛型指定为String,那么调用
		 * add方法时编译器会检查实际参数是否为String
		 * 不符合就编译失败.
		 */
		c.add("one");
		c.add("two");
		c.add("three");
		c.add("four");
		System.out.println(c);
		/*
		 * 使用新循环遍历时,接收每个集合元素时
		 * 也可以直接使用泛型的实际类型了.
		 */
		for(String s : c){
			System.out.println(s);
		}
		
		Iterator<String> it = c.iterator();
//		编译后的class文件的样子
//		Iterator it = c.iterator();		
		while(it.hasNext()){
			/*
			 * 当获取一个泛型类型的值时,编译器
			 * 会自动根据泛型指定的实际类型做
			 * 向下造型操作.
			 */
			String str = it.next();
//			编译后的class文件的样子
//			String str = (String)it.next();
			System.out.println(str);
		}
		
		
		
	}
}










