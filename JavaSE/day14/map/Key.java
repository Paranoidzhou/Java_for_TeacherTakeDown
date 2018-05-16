package map;
/**
 * HashMap内部由数组保存键值对,存储元素时根据key的
 * hashcode值计算数组下标,并将键值对存入,获取时也
 * 根据该值计算下标直接找到该元素.所以HashMap根据
 * 这个方式避免了查找元素时对数组的遍历操作,所以其
 * 不受元素的多少而影响查询性能.
 * 
 * 由于Key的hashcode决定着键值对在HashMap中数组
 * 下标位置,而equals方法决定着Key是否重复.所以这
 * 两个方法要妥善重写,当遇到两个Key的hashcode值一
 * 样,但是equals比较不为true的情况时,会出现链表.
 * 链表会降低查询性能.应当尽量避免.
 * 
 * hashcode与equals方法是定义在Object中的,所有
 * 类都具有,java提供的类都妥善的重写了这两个方法.
 * 当我们定义的类需要重写equals或hashcode是必须
 * 遵循以下原则:
 * 1:成对重写,当我们需要重写一个类的equals方法时
 *   就应当连同重写hashcode方法.
 * 2:一致性,当两个对象equals比较为true时,hashcode
 *   值应当相等,反之虽然不是必须的,但是尽量保证当
 *   两个对象hashcode方法返回值相等时,equals方法
 *   比较为true.否则会在HashMap中出现链表!
 * 3:稳定性,当参与equals比较的属性没有发生变化的
 *   情况下,多次调用hashcode方法返回的数字不应当
 *   有变化.
 * @author adminitartor
 *
 */
public class Key {
	private int x;
	private int y;
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Key other = (Key) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}
	
	
}







