package xml;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

/**
 * 写出XML文档
 * @author adminitartor
 *
 */
public class WriteXmlDemo {
	public static void main(String[] args) {
		List<Emp> list = new ArrayList<Emp>();
		list.add(new Emp(1,"张三",22,"男",5000));
		list.add(new Emp(2,"李四",23,"女",6000));
		list.add(new Emp(3,"王五",24,"男",7000));
		list.add(new Emp(4,"赵六",25,"女",8000));
		list.add(new Emp(5,"钱七",26,"男",9000));
		System.out.println(list);
		try {
			/*
			 * 写出XML的大致步骤
			 * 1:创建一个Document对象表示一个空白文档
			 * 2:向Document中添加根元素
			 * 3:从根元素开始按照要生成的文档结构逐级
			 *   添加子元素及信息
			 * 4:创建XmlWriter
			 * 5:将Document通过XmlWriter写出以生成
			 *   XML文档  
			 */
			//1
			Document doc = DocumentHelper.createDocument();
			/*
			 * 2
			 * Document提供了添加根元素的方法:
			 * Element addElement(String name)
			 * 向当前文档中添加给定名字的根元素,并以Element
			 * 实例的形式返回,以便于继续向根元素追加信息.
			 * 需要注意,该方法只能调用一次,因为一个文档只能
			 * 有一个根元素.
			 */
			Element root = doc.addElement("list");
			/*
			 *	将每个员工信息以<emp>标签形式存入到
			 *  根元素中 
			 *  
			 *  Element提供了追加相关信息的方法:
			 *  
			 *  Element addElement(String name)
			 *  向当前元素中追加子元素并将其返回,以便继续
			 *  对其追加
			 *  
			 *  Element addText(String text)
			 *  向当前元素的开始与结束标签之间添加文本,返回
			 *  的仍然是当前元素,以便对当前元素继续做其他
			 *  追加操作.
			 *  
			 *  Element addAttribute(String name,String value)
			 *  向当前元素中追加指定名字与对应值的属性,返回值
			 *  仍然是当前元素.
			 */
			for(Emp e : list){
				//向根元素中追加子元素<emp>
				Element empEle = root.addElement("emp");
				//向<emp>中追加子元素<name>
				Element nameEle = empEle.addElement("name");
				//向<name>标签中间添加文本
				nameEle.addText(e.getName());
				
				Element ageEle = empEle.addElement("age");
				ageEle.addText(String.valueOf(e.getAge()));
				
				Element genderEle = empEle.addElement("gender");
				genderEle.addText(e.getGender());
				
				Element salaryEle = empEle.addElement("salary");
				salaryEle.addText(String.valueOf(e.getSalary()));
				
				//向<emp>中追加id属性
				empEle.addAttribute("id", String.valueOf(e.getId()));		
			}
			//org.dom4j.io.XMLWriter
			XMLWriter writer = new XMLWriter(
				new FileOutputStream("myemp.xml"),
				OutputFormat.createPrettyPrint()
			);
			
			writer.write(doc);
			System.out.println("写出完毕!");
			
			//应在finally中关闭
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}








