package io;

import java.io.Serializable;
import java.util.Arrays;

/**
 * 使用该类测试对象流的对象读写操作
 * 
 * 需要注意,若当前类的实例希望能被对象流读写,那么
 * 要求当前类必须实现java.io.Serializable接口
 * @author adminitartor
 *
 */
public class Person implements Serializable{
	private String name;
	private String gender;
	private int age;
	private String[] otherInfo;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String[] getOtherInfo() {
		return otherInfo;
	}
	public void setOtherInfo(String[] otherInfo) {
		this.otherInfo = otherInfo;
	}
	
	public String toString() {
		return name+","+age+","+gender+","+
	           Arrays.toString(otherInfo);
	}
	
}










