package map;

import java.util.HashMap;
import java.util.Map;

public class MapDemo2 {
	public static void main(String[] args) {
		Map<String,Integer> map 
			= new HashMap<String,Integer>();
		map.put("语文", 99);
		map.put("数学", 98);
		map.put("英语", 97);
		map.put("物理", 96);
		map.put("化学", 99);
		System.out.println(map);
		/*
		 * 判断当前Map是否包含给定的key或value
		 */
		boolean ck = map.containsKey("化学");
		System.out.println("包含key:"+ck);
		
		boolean cv = map.containsValue(98);
		System.out.println("包含value:"+cv);
	}
}




