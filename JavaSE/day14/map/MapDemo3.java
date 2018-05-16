package map;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * Map的遍历
 * Map有三种遍历方式:
 * 1:遍历所有的key
 * 2:遍历所有的key-value对
 * 3:遍历所有的value(相对不常用)
 * 
 * 
 * @author adminitartor
 *
 */
public class MapDemo3 {
	public static void main(String[] args) {
		Map<String,Integer> map 
//			= new HashMap<String,Integer>();
			//可以有序的遍历元素
			= new LinkedHashMap<String,Integer>();
		map.put("语文", 99);
		map.put("数学", 98);
		map.put("英语", 97);
		map.put("物理", 96);
		map.put("化学", 99);
		System.out.println(map);
		
		/*
		 * 遍历所有的key
		 * Set keySet()
		 * 将当前Map中所有的key存入一个集合后返回
		 * 遍历这个set集合等于遍历了所有的key
		 */
		Set<String> keySet = map.keySet();
		for(String key : keySet){
			System.out.println("key:"+key);
		}
		
		/*
		 * 遍历每一组键值对
		 * 在Map接口中定义了一个内部接口
		 * java.util.Map.Entry
		 * Entry的每一个实例用于表示当前Map中的
		 * 一组键值对,其提供了两个常用方法:
		 * K getKey():获取key值
		 * V getValue():获取value值
		 * 不同的Map实现类都实现了Entry,并用实现类
		 * 的每个实例表示一个具体的键值对.
		 * 
		 * Set<Entry> entrySet()
		 * 该方法会将Map中所有键值对存入一个集合
		 * 后返回.
		 * 
		 */
		Set<Entry<String,Integer>> entrySet 
							= map.entrySet();		
		for(Entry<String,Integer> e : entrySet){
			String key = e.getKey();
			Integer value = e.getValue();
			System.out.println(key+":"+value);
		}
		
		/*
		 * 遍历所有的value
		 * Collection values()
		 * 将当前Map中所有的value以一个集合的形式
		 * 返回.
		 */
		Collection<Integer> values = map.values();
		for(Integer value : values){
			System.out.println(value);
		}
	}
}









