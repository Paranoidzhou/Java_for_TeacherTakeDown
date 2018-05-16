package demo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class SyncDemo {
	public static void main(String[] args) {
		File file = new File("demo.txt");
		T1 t1 = new T1(file);
		T2 t2 = new T2(file);
		t1.start();
		t2.start();
		System.out.println("OK");
	}
}
class T1 extends Thread{
	File file;
	public T1(File file) {
		this.file = file;
	}
	public void run() {
		print();
	}
	public void print(){
		synchronized(file){
			try {
				PrintWriter out=
						new PrintWriter(
						new OutputStreamWriter(
						new FileOutputStream(file, true)));
				System.out.println("T1 Start");
				out.println("Hello T1");
				out.flush();
				Thread.sleep(1000);
				out.println("T1 OK");
				out.close();
				System.out.println("T1 Ok");
			} catch (Exception e) {
				e.printStackTrace();
			}		
		}
	}
}
class T2 extends Thread{
	File file;
	public T2(File file) {
		this.file = file;
	}
	@Override
	public void run() {
		print();
	}
	public void print(){
		synchronized(file){
			try {
				PrintWriter out=
						new PrintWriter(
						new OutputStreamWriter(
						new FileOutputStream(file, true)));
				System.out.println("T2 Start");
				out.println("Hello T2");
				out.flush();
				Thread.sleep(1500);
				out.println("T2 OK");
				out.close();
				System.out.println("T2 OK");
			} catch (Exception e) {
				e.printStackTrace();
			}	
		}
	}
}



