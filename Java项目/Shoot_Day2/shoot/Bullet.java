package cn.tedu.shoot;
/** 子弹 */
public class Bullet {
	int width;
	int height;
	int x;
	int y;
	int speed; //移动速度
	/** 构造方法 */
	Bullet(int x,int y){
		width = 8;
		height = 14;
		this.x = x;
		this.y = y;
		speed = 3;
	}
	
	/** 子弹移动 */
	void step(){
		System.out.println("子弹的y坐标移动了:"+speed);
	}
}










