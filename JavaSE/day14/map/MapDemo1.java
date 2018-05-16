package map;

import java.util.HashMap;
import java.util.Map;

/**
 * java.util.Map接口
 * Map称为查找表,该数据结构体现的样子是一个"多行
 * 两列"的表格.左列称为key,右列称为value.
 * Map总是根据key查找对应的value.
 * 存储元素也要求以key-value成对存入.
 * 
 * 常用的实现类:java.util.HashMap 散列表 哈希表
 * HashMap是基于散列算法实现的Map,当今世界上最快的
 * 查询结构.
 * @author adminitartor
 *
 */
public class MapDemo1 {
	public static void main(String[] args) {
		Map<String,Integer> map 
			= new HashMap<String,Integer>();
		
		/*
		 * V put(K k,V v)
		 * 将给定的key-value对存入到Map中
		 * Map有一个要求,key不允许重复(key的equals
		 * 比较决定),若使用Map已有的key存入value,
		 * 则是替换value操作.那么put方法返回的就是
		 * 被替换的value,若没有替换则返回值null
		 */
		/*
		 * 对于value是包装类的情况,切记,不要直接
		 * 用基本类型接收返回值,因为会触发自动拆箱
		 * 特性:
		 * int n = map.put("语文", 99);
		 * 下面的代码编译后会改为:
		 * int n = map.put("语文", 99).intValue();
		 * 若key在Map中不存在,则返回值为null,若拆箱
		 * 会引发空指针异常.
		 */
		Integer n = map.put("语文", 99);
		System.out.println("n:"+n);
		map.put("数学", 98);
		map.put("英语", 97);
		map.put("物理", 96);
		map.put("化学", 99);
		
		System.out.println(map);
		n = map.put("语文", 66);
		System.out.println(map);
		System.out.println("n:"+n);
		
		
		int size = map.size();
		System.out.println("size:"+size);
		
		/*
		 * V get(K k)
		 * 根据给定的key获取对应的value,若给定的
		 * key不存在则返回值为null.
		 */
		//查看数学的成绩
		n = map.get("数学");
		System.out.println("数学:"+n);
		
		/*
		 * V remove(K k)
		 * 删除当前Map中给定的key所对应的这组键值对
		 * 返回值为该key所对应的value.若给定的key在
		 * Map中不存在,则返回值为null.
		 */
		n = map.remove("语文");
		System.out.println(map);
		System.out.println("被删除的value:"+n);
	}
}









