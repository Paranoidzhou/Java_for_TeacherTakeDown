package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程池
 * 线程池主要完成两个工作:
 * 1:管理线程数量
 *   由于每个线程有会占用一定的内存,线程数量过多
 *   会导致内存占用大,还有一个问题就是CPU过度切换,
 *   导致程序出现"卡顿".
 * 2:重用线程  
 * @author adminitartor
 *
 */
public class ThreadPoolDemo {
	public static void main(String[] args) {
		ExecutorService threadPool
			= Executors.newFixedThreadPool(2);
		
		for(int i=0;i<5;i++){
			Runnable runn = new Runnable(){
				public void run(){
					Thread t = Thread.currentThread();
					System.out.println(
						t.getName()+":正在运行任务...");
					try {
						Thread.sleep(5000);
					} catch (InterruptedException e) {
						System.out.println(
							"线程被中断!");
					}
					System.out.println(
						t.getName()+":运行任务完毕...");
				}
			};
			//将任务指派给线程池
			threadPool.execute(runn);
			System.out.println("将任务指派给了线程池");
		}// for end
		/*
		 * shutdown与shutdownNow都是停止线程池
		 * shutdown方法调用后,线程池不再接受新任务,会将
		 * 已有任务全部执行后停止.
		 * 
		 * shutdownNow调用后,线程池会调用所有线程的中断
		 * 方法后立即停止.
		 */
		threadPool.shutdownNow();
		System.out.println("线程池停了!");
		
		
	}
}









