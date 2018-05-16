package lambda;
/**
 * lambda表达式
 * JDK8之后推出的特性.
 * 
 * lambda用于创建匿名内部类.
 * lambda表达式创建的匿名内部类所属的接口必须
 * 只能有一个抽象方法.否则不可以使用.
 * 
 * 语法规则
 * (方法参数...)->{
 * 	方法体
 * }
 * @author adminitartor
 *
 */
public class LambdaDemo1 {
	public static void main(String[] args) {
		Runnable runn = new Runnable(){
			public void run(){
				System.out.println("hello");
			}
		};
		
		Runnable runn1 = ()->{
			System.out.println("hello");
		};
		/*
		 * 当方法中只有一行代码,那么方法体的"{}"
		 * 都可以省略
		 */
		Runnable runn2 
			= ()->System.out.println("hello");
		
	}
}








