package cn.tedu.shoot;
import java.util.Random;
/** 小蜜蜂 */
public class Bee {
	int width;
	int height;
	int x;
	int y;
	int xSpeed; //x坐标移动速度
	int ySpeed; //y坐标移动速度
	int awardType; //奖励类型(0或1)
	/** 构造方法 */
	Bee(){
		width = 60;
		height = 50;
		Random rand = new Random();
		x = rand.nextInt(400-this.width); //x:0到(400-小蜜蜂宽)之间的随机数
		y = -this.height; //y:负的小蜜蜂的高
		xSpeed = 1;
		ySpeed = 2;
		awardType = rand.nextInt(2); //0到1之间的随机数
	}
	
	/** 小蜜蜂移动 */
	void step(){
		System.out.println("小蜜蜂的x坐标移动了:"+xSpeed+"，y坐标移动了:"+ySpeed);
	}
}













