package xml;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * 解析XML
 * @author adminitartor
 *
 */
public class ParseXmlDemo {
	public static void main(String[] args) {
		/*
		 * 将emplist.xml文件中保存的员工信息解析
		 * 出来,以若干Emp实例形式存入List集合.
		 * 程序中的数据不应在程序中写死,否则一旦
		 * 数据有修改,就要修改源程序.
		 */
		List<Emp> list = new ArrayList<Emp>();
		
		try {
			/*
			 * 使用DOM4J解析XML的大致步骤:
			 * 1:创建SAXReader
			 * 2:使用SAXReader读取xml文档并得到
			 *   对应的Document对象
			 * 3:通过Document获取根元素
			 * 4:从根元素中按照文档结构逐级获取
			 *   子元素,已达到遍历XML文档数据的目的
			 *   
			 * 若想使用dom4j首先必须下载dom4j.jar
			 * 并导入到项目环境中(maven要配置好)    
			 */
			//1 
			SAXReader reader = new SAXReader();
			
			//2
			Document doc = reader.read(new File("emplist.xml"));
//			reader.read(new FileInputStream("emplist.xml"));
			
			/*
			 * 3
			 * Element的每一个实例用于表示xml文档中
			 * 的一个元素(一对标签).
			 * 其提供了很多获取其表示的元素相关信息
			 * 的方法:
			 * 
			 * String getName()
			 * 获取当前元素的名字(标签的名字)
			 * 
			 * String getText()
			 * 获取当前元素中间的文本(开始和结束标签
			 * 中间的文本信息)
			 * 
			 * String elementText(String name)
			 * 获取当前元素中指定名字的子元素中间的文本
			 * 例如:
			 * String str = e.elementText("name");
			 * 等同于
			 * String str = e.element("name").getText();
			 * 
			 * Element element(String name)
			 * 获取当前元素中指定名字的子元素
			 * 
			 * List elements()
			 * 获取当前元素中所有子元素
			 * 
			 * List elements(String name)
			 * 获取当前元素中所有的指定名字的同名子元素
			 * 
			 * Attribute attribute(String name)
			 * 获取当前元素中指定名字的属性
			 * 
			 */
			Element root = doc.getRootElement();
//			System.out.println(root.getName());
			
			/*
			 * 获取根标签下所有<emp>标签
			 */
			List<Element> empList = root.elements("emp");
			/*
			 * 将每个<emp>标签表示的员工信息解析
			 * 出来以Emp实例形式存入list集合
			 */
			for(Element empEle : empList){
				//获取员工名字
				//1获取<name>标签
				Element nameEle = empEle.element("name");
				//2获取中间的文本数据
				String name = nameEle.getText();
				
				int age = Integer.parseInt(
					empEle.element("age").getText()	
				);
				
				String gender = empEle.elementText("gender");
				int salary = Integer.parseInt(
					empEle.elementText("salary")	
				);
				
				//获取id
//				Attribute att = empEle.attribute("id");
//				int id = Integer.parseInt(
//					att.getValue()
//				);				
				int id = Integer.parseInt(
					empEle.attributeValue("id")
				);
				Emp emp = new Emp(id,name,age,gender,salary);
				list.add(emp);
			}
			
			System.out.println("解析完毕!");
			for(Emp e : list){
				System.out.println(e);
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}








