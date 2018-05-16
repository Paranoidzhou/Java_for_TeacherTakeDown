package oo.day07;
//匿名内部类的演示
public class NstInnerClassDemo {
	public static void main(String[] args) {
		//1)创建了Coo的一个派生类，但是没有名字
		//2)为该派生类创建了一个对象，名为o1
		//3)大括号中的为派生类的类体
		Coo o1 = new Coo(){
			
		};
		
		//1)创建了Coo的一个派生类，但是没有名字
		//2)为该派生类创建了一个对象，名为o2
		//3)大括号中的为派生类的类体
		Coo o2 = new Coo(){
			
		};
		
		
		
		
		final int num = 5;
		Doo o3 = new Doo(){
			void show(){
				System.out.println("showshow");
				System.out.println(num); //1.7(含)以前的版本要求num必须是final的
			}
		};
		o3.show();
		
	}
}

abstract class Coo{
}

abstract class Doo{
	abstract void show();
}










