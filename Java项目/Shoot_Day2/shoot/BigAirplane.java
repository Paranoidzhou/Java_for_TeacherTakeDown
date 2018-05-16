package cn.tedu.shoot;
import java.util.Random;
/** 大敌机 */
public class BigAirplane {
	int width;
	int height;
	int x;
	int y;
	int speed; //移动速度
	/** 构造方法 */
	BigAirplane(){
		width = 69;
		height = 99;
		Random rand = new Random();
		x = rand.nextInt(400-this.width); //x:0到(400-大敌机宽)之间的随机数
		y = -this.height; //y:负的大敌机的高
		speed = 2;
	}
	
	/** 大敌机移动 */
	void step(){
		System.out.println("大敌机的y坐标移动了:"+speed);
	}
}














