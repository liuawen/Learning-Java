package com.atguigu.test01;

import java.util.HashMap;

import org.junit.Test;

/*
 * JDK1.8的HashMap的底层实现：数组+链表/红黑树
 * 
 * 几个常量和变量：
 * （1）DEFAULT_INITIAL_CAPACITY：默认的初始容量 16
 * （2）MAXIMUM_CAPACITY：最大容量  1 << 30
 * （3）DEFAULT_LOAD_FACTOR：默认加载因子 0.75
 * （4）TREEIFY_THRESHOLD：默认树化阈值8，当链表的长度达到这个值后，要考虑树化
 * （5）UNTREEIFY_THRESHOLD：默认反树化阈值6，当树中的结点的个数达到这个阈值后，要考虑变为链表
 * （6）MIN_TREEIFY_CAPACITY：最小树化容量64
 * 			当单个的链表的结点个数达到8，并且table的长度达到64，才会树化。
 * 			当单个的链表的结点个数达到8，但是table的长度未达到64，会先扩容
 * （7）Node<K,V>[] table：数组
 * （8）size：记录有效映射关系的对数，也是Entry对象的个数
 * （9）int threshold：阈值，当size达到阈值时，考虑扩容
 * （10）double loadFactor：加载因子，影响扩容的频率
 * 
 * 1、new HashMap()
 *  public HashMap() {
 *  	//加载因子赋值为0.75
        this.loadFactor = DEFAULT_LOAD_FACTOR; // all other fields defaulted 其他字段都是默认值
        //threshold是0
        //table=null
        //size = 0
    }
 *
 * 2、put(key,value)
 * （1）如果第一次添加时
 * 把table初始化为长度为16的数组，threshold = 12
 * （2）如果不是第一次添加
 * ①会考虑是否key有重复，那么就替换value
 * ②如果table[i]下面不是树，统计table[i]的结点的个数，添加之前达到7个，考虑树化
 * 		当单个的链表的结点个数添加之前达到7，并且table的长度达到64，才会树化。
 * 		当单个的链表的结点个数添加之前达到7，table的长度未达到64，先扩容。
 * ③table[i]下面已经是树，单独处理，直接把新的映射关系连接到树的叶子结点
 * ④添加后，size达到threshold，还要扩容
 * 一旦扩容，就会调整所有映射关系的位置
 * 
 */
@SuppressWarnings("all")
public class TestHashMap {
	@Test
	public void test02(){
		HashMap map = new HashMap();
		
		for (int i = 0; i < 15; i++) {
			//这里的key，选用自定义的类型MyKey类型对象
			//选择自定义的类型，是为了控制hashCode值
			map.put(new MyKey(i), "xx");
		}
	}
	
	@Test
	public void test01(){
		HashMap map = new HashMap();
		//添加了15对映射关系
		for (int i = 0; i < 15; i++) {
			//这里选择Integer作为key
			//Integer对象的hashCode
			map.put(i, "xx");
		}
	}
}
class MyKey{
	private int id;

	public MyKey(int id) {
		super();
		this.id = id;
	}

	@Override
	public int hashCode() {
/*		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;*/
		return 1;//所有MyKey的对象的hashCode的值都相同，会存入同一个table[1]中
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MyKey other = (MyKey) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
}