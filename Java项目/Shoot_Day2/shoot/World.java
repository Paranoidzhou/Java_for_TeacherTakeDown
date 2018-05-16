package cn.tedu.shoot;
/** 整个世界 */
public class World {
	Sky sky;
	Hero hero;
	Airplane a1;
	Airplane a2;
	BigAirplane ba1;
	BigAirplane ba2;
	Bee b1;
	Bee b2;
	Bullet bt1;
	Bullet bt2;
	
	void action(){ //测试代码
		sky = new Sky();
		hero = new Hero();
		a1 = new Airplane();
		a2 = new Airplane();
		ba1 = new BigAirplane();
		ba2 = new BigAirplane();
		b1 = new Bee();
		b2 = new Bee();
		bt1 = new Bullet(100,200);
		bt2 = new Bullet(50,80);
		
		System.out.println("英雄机的宽:"+hero.width+"，英雄机的高:"+hero.height+"，英雄机的x:"+hero.x+"，英雄机的y:"+hero.y+"，英雄机的命:"+hero.life+"，英雄机的火力值:"+hero.doubleFire);
		System.out.println("小敌机a1的x:"+a1.x+"，小敌机a1的y:"+a1.y);
		System.out.println("小敌机a2的x:"+a2.x+"，小敌机a2的y:"+a2.y);
		
	}
	
	public static void main(String[] args) {
		World world = new World();
		world.action();
	}
}






















