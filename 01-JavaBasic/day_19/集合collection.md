collection集合介绍

Collection系列集合的遍历三种方式

# 第十二章 集合

## 12.1 概念

数据结构：存储数据的某种结构

（1）底层的物理结构

①数组：开辟连续的存储空间，每一个元素使用[下标]进行区别

②链式：不需要开辟连续的存储空间，但是需要“结点”来包装要存储的数据，结点包含两部分内容：

​	A、数据

​	B、记录其他结点的地址，例如：next，pre，left，right，parent等

（2）表现出来的逻辑结构：动态数组、单向链表、双向链表、队列、栈、二叉树、哈希表、图等

## 12.2 手动实现一些逻辑结构

1、动态数组

包含：

（1）内部使用一个数组，用来存储数据

（2）内部使用一个total，记录实际存储的元素的个数

```java
public class MyArrayList {
	//为什么使用Object，因为只是说这个容器是用来装对象的，但是不知道用来装什么对象。
	private Object[] data;
	private int total;
	
	public MyArrayList(){
		data = new Object[5];
	}
	
	//添加一个元素
	public void add(Object obj){
		//检查是否需要扩容
		checkCapacity();
		data[total++] = obj;
	}

	private void checkCapacity() {
		//如果data满了，就扩容为原来的2倍
		if(total >= data.length){
			data = Arrays.copyOf(data, data.length*2);
		}
	}
	
	//返回实际元素的个数
	public int size(){
		return total;
	}
	
	//返回数组的实际容量
	public int capacity(){
		return data.length;
	}
	
	//获取[index]位置的元素
	public Object get(int index){
		//校验index的合理性范围
		checkIndex(index);
		return data[index];
	}

	private void checkIndex(int index) {
		if(index<0 || index>=total){
			throw new RuntimeException(index+"对应位置的元素不存在");
//			throw new IndexOutOfBoundsException(index+"越界");
		}
	}
	
	//替换[index]位置的元素
	public void set(int index, Object value){
		//校验index的合理性范围
		checkIndex(index);
		
		data[index] = value;
	}
	
	//在[index]位置插入一个元素value
	public void insert(int index, Object value){
		/*
		 * (1)考虑下标的合理性
		 * (2)总长度是否够
		 * (3)[index]以及后面的元素往后移动，把[index]位置腾出来
		 * (4)data[index]=value  放入新元素
		 * (5)total++  有效元素的个数增加
		 */
		
		//(1)考虑下标的合理性：校验index的合理性范围
		checkIndex(index);
		
		//(2)总长度是否够：检查是否需要扩容
		checkCapacity();
		
		//(3)[index]以及后面的元素往后移动，把[index]位置腾出来
		/*
		 * 假设total = 5, data.length= 10, index= 1
		 * 有效元素的下标[0,4]
		 * 移动：[1]->[2],[2]->[3],[3]->[4],[4]->[5]
		 * 移动元素的个数：total-index
		 */
		System.arraycopy(data, index, data, index+1, total-index);
		
		//(4)data[index]=value  放入新元素
		data[index] = value;
		
		//(5)total++  有效元素的个数增加
		total++;
	}
	
	//返回所有实际存储的元素
	public Object[] getAll(){
		//返回total个
		return Arrays.copyOf(data, total);
	}
	
	//删除[index]位置的元素
	public void remove(int index){
		/*
		 * (1)校验index的合理性范围
		 * (2)移动元素，把[index+1]以及后面的元素往前移动
		 * (3)把data[total-1]=null  让垃圾回收器尽快回收
		 * (4)总元素个数减少 total--
		 */
		
		//(1)考虑下标的合理性：校验index的合理性范围
		checkIndex(index);
		
		//(2)移动元素，把[index+1]以及后面的元素往前移动
		/*
		 * 假设total=8, data.length=10, index = 3
		 * 有效元素的范围[0,7]
		 * 移动：[4]->[3],[5]->[4],[6]->[5],[7]->[6]
		 * 移动了4个：total-index-1
		 */
		System.arraycopy(data, index+1, data, index, total-index-1);
		
		//(3)把data[total-1]=null  让垃圾回收器尽快回收
		data[total-1] = null;
		
//		(4)总元素个数减少 total--
		total--;
	}
	
	//查询某个元素的下标
	public int indexOf(Object obj){
		if(obj == null){
			for (int i = 0; i < total; i++) {
				if(data[i] == null){//等价于 if(data[i] == obj)
					return i;
				}
			}
		}else{
			for (int i = 0; i < data.length; i++) {
				if(obj.equals(data[i])){
					return i;
				}
			}
		}
		return -1;
	}
	
	//删除数组中的某个元素
	//如果有重复的，只删除第一个
	public void remove(Object obj){
		/*
		 * (1)先查询obj的[index]
		 * (2)如果存在，就调用remove(index)删除就可以
		 */
		
		//(1)先查询obj的[index]
		int index = indexOf(obj);
		
		if(index != -1){
			remove(index);
		}
		//不存在，可以什么也不做
		//不存在，也可以抛异常
		//throw new RuntimeException(obj + "不存在");
	}
	
	public void set(Object old, Object value){
		/*
		 * (1)查询old的[index]
		 * (2)如果存在，就调用set(index, value)
		 */
		
//		(1)查询old的[index]
		int index = indexOf(old);
		if(index!=-1){
			set(index, value);
		}
		
		//不存在，可以什么也不做
	}
}
```



2、单向链表

包含：

（1）包含一个Node类型的成员变量first：用来记录第一个结点的地址

如果这个链表是空的，还没有任何结点，那么first是null。

最后一个结点的特征：就是它的next是null

（2）内部使用一个total，记录实际存储的元素的个数

（3）使用了一个内部类Node

```java
private class Node{
    Object data;
    Node next;
}
```

```java
public class SingleLinkedList {
	//这里不需要数组，不需要其他的复杂的结构，我只要记录单向链表的“头”结点
	private Node first;//first中记录的是第一个结点的地址
	private int total;//这里我记录total是为了后面处理的方便，例如：当用户获取链表有效元素的个数时，不用现数，而是直接返回total等
	
	/*
	 * 内部类，因为这种Node结点的类型，在别的地方没有用，只在单向链表中，用于存储和表示它的结点关系。
	 * 因为我这里涉及为内部类型。
	 */
	private class Node{
		Object data;//因为数据可以是任意类型的对象，所以设计为Object
		Node next;//因为next中记录的下一个结点的地址，因此类型是结点类型
		//这里data,next没有私有化，是希望在外部类中可以不需要get/set，而是直接“结点对象.data","结点对象.next"使用
		Node(Object data, Node next){
			this.data = data;
			this.next = next;
		}
	}
	
	public void add(Object obj){
		/*
		 * (1)把obj的数据，包装成一个Node类型结点对象
		 * (2)把新结点“链接”当前链表的最后
		 * ①当前新结点是第一个结点
		 * 如何判断是否是第一个   if(first==null)说明暂时还没有第一个
		 * ②先找到目前的最后一个，把新结点链接到它的next中
		 * 如何判断是否是最后一个   if(某个结点.next == null)说明这个结点是最后一个
		 */
//		(1)把obj的数据，包装成一个Node类型结点对象
		//这里新结点的next赋值为null，表示新结点是最后一个结点
		Node newNode = new Node(obj, null);
		
		//①当前新结点是第一个结点
		if(first == null){
			//说明newNode是第一个
			first = newNode;
		}else{
			//②先找到目前的最后一个，把新结点链接到它的next中
			Node node = first;
			while(node.next != null){
				node = node.next;
			}
			//退出循环时node指向最后一个结点
			
			//把新结点链接到它的next中
			node.next = newNode;
		}
		
		total++;
	}
	
	public int size(){
		return total;
	}
	
	public Object[] getAll(){
		//(1)创建一个数组，长度为total
		Object[] all = new Object[total];
		
		//(2)把单向链表的每一个结点中的data，拿过来放到all数组中
		Node node = first;
		for (int i = 0; i < total; i++) {
//			all[i] = 结点.data;
			all[i] = node.data;
			//然后node指向下一个
			node = node.next;
		}
		
		//(3)返回数组
		return all;
	}
	
	public void remove(Object obj){
		if(obj == null){
			//(1)先考虑是否是第一个
			if(first!=null){//链表非空
				
				//要删除的结点正好是第一个结点
				if(first.data == null){
					//让第一个结点指向它的下一个
					first = first.next;
					total--;
					return;
				}
				
				//要删除的不是第一个结点
				Node node = first.next;//第二个结点
				Node last = first;
				while(node.next!=null){//这里不包括最后一个，因为node.next==null，不进入循环，而node.next==null是最后一个
					if(node.data == null){
						last.next = node.next;
						total--;
						return;
					}
					last = node;
					node = node.next;
				}
				
				//单独判断最后一个是否是要删除的结点
				if(node.data == null){
					//要删除的是最后一个结点
					last.next = null;
					total--;
					return;
				}
			}
		}else{
			//(1)先考虑是否是第一个
			if(first!=null){//链表非空
				
				//要删除的结点正好是第一个结点
				if(obj.equals(first.data)){
					//让第一个结点指向它的下一个
					first = first.next;
					total--;
					return;
				}
				
				//要删除的不是第一个结点
				Node node = first.next;//第二个结点
				Node last = first;
				while(node.next!=null){//这里不包括最后一个，因为node.next==null，不进入循环，而node.next==null是最后一个
					if(obj.equals(node.data)){
						last.next = node.next;
						total--;
						return;
					}
					last = node;
					node = node.next;
				}
				
				//单独判断最后一个是否是要删除的结点
				if(obj.equals(node.data)){
					//要删除的是最后一个结点
					last.next = null;
					total--;
					return;
				}
			}
		}
	}

	public int indexOf(Object obj){
		if(obj == null){
			Node node = first;
			for (int i = 0; i < total; i++) {
				if(node.data == null){
					return i;
				}
				node = node.next;
			}
		}else{
			Node node = first;
			for (int i = 0; i < total; i++) {
				if(obj.equals(node.data)){
					return i;
				}
				node = node.next;
			}
		}
		return -1;
	}
}

```



## 12.3  Collection

因为集合的类型很多，那么我们把它们称为集合框架。

集合框架分为两个家族：Collection（一组对象）和Map（一组映射关系、一组键值对）

Collection  Map

一组对象   一组映射关系 一组键值对

Colleciton Map



### 12.3.1 Collection

Collection是代表一种对象的集合。它是Collection系列的根接口。

它们虽然：有些可能是有序的，有些可能是无序的，有些可能可以重复的，有些不能重复的，但是它们有共同的操作规范，因此这些操作的规范就抽象为了Collection接口。

常用方法：

（1）boolean add(Object obj)：添加一个

（2）boolean addAll（Collection c）：添加多个

（3）boolean remove(Object obj)：删除一个

（4）boolean removeAll(Collection c )： 删除多个

（5）boolean contains(Object c)：是否包含某个

（6）boolean containsAll(Collection c)： 是否包含所有

（7）boolean isEmpty()：是否为空

（8）int size()：获取元素个数

（9）void clear()：清空集合

（10）Object[] toArray()：获取所有元素

（11）Iterator iterator()： 获取遍历当前集合的迭代器对象

（12）retainAll(Collection c)：求当前集合与c集合的交集

### 12.3.2  Collection系列的集合的遍历

1、明确使用Iterator迭代器

```java
Collection c = ....;

Iterator iter = c.iterator();
while(iter.hashNext()){
    Object obj = iter.next();
    //...
}
```

Iterator 接口的方法：

（1）boolean hasNext()

（2）Object next()

（3）void remove()

2、foreach

```
Collection c = ....;

for(Object  obj :  c){
    //...
}
```

什么样的集合（容器）能够使用foreach遍历？

（1）数组：

（2）实现了java.lang.Iterable接口

这个接口有一个抽象方法：Iterator iterator()

Iterator也是一个接口，它的实现类，通常在集合（容器）类中用内部类实现。并在iterator()的方法中创建它的对象。

```java
public class MyArrayList implements Iterable{
	//为什么使用Object，因为只是说这个容器是用来装对象的，但是不知道用来装什么对象。
	private Object[] data;
	private int total;
	
	//其他代码省略....

	@Override
	public Iterator iterator() {
		return new MyItr();
	}
	
	private class MyItr implements Iterator{
		private int cursor;//游标

		@Override
		public boolean hasNext() {
			return cursor!=total;
		}

		@Override
		public Object next() {
			return data[cursor++];
		}
	}
}
```



思考：如果遍历数组，什么情况下选用foreach，什么情况下选用for循环？

当如果你的操作中涉及到[下标]操作时，用for最好。

当你只是查看元素的内容，那么选foreach更简洁一些。



思考：如果遍历Collection系列集合，什么情况下选用foreach，是否能选用for循环？

首先考虑使用foreach，如果该集合也有索引信息的话，也可以通过for来操作，如果没有下标的信息，就不要用for。即，如果该集合的物理结构是数组的，那么可以用for，如果物理结构是链式，那么使用下标操作效率很低。



思考：如果遍历Collection系列集合，什么情况下选用foreach，什么情况下使用Iterator？

如果只是查看集合的元素，使用foreach，代码会更简洁。

但是如果要涉及到在遍历集合的同时根据某种条件要删除元素等操作，那么选用Iterator。

## 12.4 List

### 12.4.1 List概述

List：是Collection的子接口。

List系列的集合：有序的、可重复的

List系列的常用集合：ArrayList、Vector、LinkedList、Stack

Stack

ArrayList

Vector

Stack

### 12.4.2 List的API

常用方法：

（1）boolean add(Object obj)：添加一个

（2）boolean addAll（Collection c）：添加多个

（3）void add(int index, Object obj)：添加一个，指定位置添加

（4）void addAll(int index, Collection c）：添加多个

（5）boolean remove(Object obj)：删除一个

（6）Object remove(int index)：删除指定位置的元素，并返回刚刚删除的元素

（7）boolean removeAll(Collection c )： 删除多个

（8）boolean contains(Object c)：是否包含某个

（9）boolean containsAll(Collection c)： 是否包含所有

（10）boolean isEmpty()：是否为空

（11）int size()：获取元素个数

（12）void clear()：清空集合

（13）Object[] toArray()：获取所有元素

（14）Iterator iterator()： 获取遍历当前集合的迭代器对象

（15）retainAll(Collection c)：求当前集合与c集合的交集

（16）ListIterator listIterator()：获取遍历当前集合的迭代器对象，这个迭代器可以往前、往后遍历

（17）ListIterator listIterator(int index)：从[index]位置开始，往前或往后遍历

（18）Object get(int index)：返回index位置的元素

（19）List  subList(int start, int end)：截取[start,end)部分的子列表



### 12.4.3 ListIterator 接口

Iterator 接口的方法：

（1）boolean hasNext()

（2）Object next()

（3）void remove()

ListIterator 是 Iterator子接口：增加了如下方法

（4）void add(Object obj)

（5）void set(Object obj)

（6）boolean hasPrevious()

（7）Object previous()

（8）int nextIndex()

（9）int previousIndex()



### 12.4.4 List的实现类们的区别

ArrayList、Vector、LinkedList、Stack

（1）ArrayList、Vector：都是动态数组

Vector是最早版本的动态数组，线程安全的，默认扩容机制是2倍，支持旧版的迭代器Enumeration

ArrayList是后增的动态数组，线程不安全的，默认扩容机制是1.5倍

Vector

ArrayList 动态数组 

（2）动态数组与LinkedList的区别

动态数组：底层物理结构是数组

​	优点：根据[下标]访问的速度很快

​	缺点：需要开辟连续的存储空间，而且需要扩容，移动元素等操作

LinkedList：底层物理结构是双向链表

​	优点：在增加、删除元素时，不需要移动元素，只需要修改前后元素的引用关系

​	缺点：我们查找元素时，只能从first或last开始查找

（3）Stack：栈

是Vector的子类。比Vector多了几个方法，能够表现出“先进后出或后进先出”的特点。

①Object peek()：访问栈顶元素

②Object pop()：弹出栈顶元素

③push()：把元素压入栈顶

（4）LinkedList可以作为很多种数据结构使用

单链表：只关注next就可以

队列：先进先出，找对应的方法

双端队列(JDK1.6加入)：两头都可以进出，找对应的方法

栈：先进后出，找对应的方法

建议：虽然LinkedList是支持对索引进行操作，因为它实现List接口的所有方法，但是我们不太建议调用类似这样的方法，因为效率比较低。



### 12.4.5 源码分析

#### （1）Vector

```java
    public Vector() {
        this(10);//指定初始容量initialCapacity为10
    }
	public Vector(int initialCapacity) {
        this(initialCapacity, 0);//指定capacityIncrement增量为0
    }
    public Vector(int initialCapacity, int capacityIncrement增量为0) {
        super();
        //判断了形参初始容量initialCapacity的合法性
        if (initialCapacity < 0)
            throw new IllegalArgumentException("Illegal Capacity: "+
                                               initialCapacity);
        //创建了一个Object[]类型的数组
        this.elementData = new Object[initialCapacity];//默认是10
        //增量，默认是0，如果是0，后面就按照2倍增加，如果不是0，后面就按照你指定的增量进行增量
        this.capacityIncrement = capacityIncrement;
    }
```

```java
//synchronized意味着线程安全的   
	public synchronized boolean add(E e) {
        modCount++;
    	//看是否需要扩容
        ensureCapacityHelper(elementCount + 1);
    	//把新的元素存入[elementCount]，存入后，elementCount元素的个数增1
        elementData[elementCount++] = e;
        return true;
    }

    private void ensureCapacityHelper(int minCapacity) {
        // overflow-conscious code
        //看是否超过了当前数组的容量
        if (minCapacity - elementData.length > 0)
            grow(minCapacity);//扩容
    }
    private void grow(int minCapacity) {
        // overflow-conscious code
        int oldCapacity = elementData.length;//获取目前数组的长度
        //如果capacityIncrement增量是0，新容量 = oldCapacity的2倍
        //如果capacityIncrement增量是不是0，新容量 = oldCapacity + capacityIncrement增量;
        int newCapacity = oldCapacity + ((capacityIncrement > 0) ?
                                         capacityIncrement : oldCapacity);
        
        //如果按照上面计算的新容量还不够，就按照你指定的需要的最小容量来扩容minCapacity
        if (newCapacity - minCapacity < 0)
            newCapacity = minCapacity;
        
        //如果新容量超过了最大数组限制，那么单独处理
        if (newCapacity - MAX_ARRAY_SIZE > 0)
            newCapacity = hugeCapacity(minCapacity);
        
        //把旧数组中的数据复制到新数组中，新数组的长度为newCapacity
        elementData = Arrays.copyOf(elementData, newCapacity);
    }
```

```java
    public boolean remove(Object o) {
        return removeElement(o);
    }
    public synchronized boolean removeElement(Object obj) {
        modCount++;
        //查找obj在当前Vector中的下标
        int i = indexOf(obj);
        //如果i>=0，说明存在，删除[i]位置的元素
        if (i >= 0) {
            removeElementAt(i);
            return true;
        }
        return false;
    }
    public int indexOf(Object o) {
        return indexOf(o, 0);
    }
    public synchronized int indexOf(Object o, int index) {
        if (o == null) {//要查找的元素是null值
            for (int i = index ; i < elementCount ; i++)
                if (elementData[i]==null)//如果是null值，用==null判断
                    return i;
        } else {//要查找的元素是非null值
            for (int i = index ; i < elementCount ; i++)
                if (o.equals(elementData[i]))//如果是非null值，用equals判断
                    return i;
        }
        return -1;
    }
    public synchronized void removeElementAt(int index) {
        modCount++;
        //判断下标的合法性
        if (index >= elementCount) {
            throw new ArrayIndexOutOfBoundsException(index + " >= " +
                                                     elementCount);
        }
        else if (index < 0) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        
        //j是要移动的元素的个数
        int j = elementCount - index - 1;
        //如果需要移动元素，就调用System.arraycopy进行移动
        if (j > 0) {
            //把index+1位置以及后面的元素往前移动
            //index+1的位置的元素移动到index位置，依次类推
            //一共移动j个
            System.arraycopy(elementData, index + 1, elementData, index, j);
        }
        //元素的总个数减少
        elementCount--;
        //将elementData[elementCount]这个位置置空，用来添加新元素，位置的元素等着被GC回收
        elementData[elementCount] = null; /* to let gc do its work */
    }
```

#### （2）ArrayList源码分析

JDK1.6：

```java
    public ArrayList() {
		this(10);//指定初始容量为10
    }
    public ArrayList(int initialCapacity) {
		super();
        //检查初始容量的合法性
        if (initialCapacity < 0)
            throw new IllegalArgumentException("Illegal Capacity: "+
                                               initialCapacity);
        //数组初始化为长度为initialCapacity的数组
		this.elementData = new Object[initialCapacity];
    }
```

JDK1.7

```java
    private static final int DEFAULT_CAPACITY = 10;//默认初始容量10
	private static final Object[] EMPTY_ELEMENTDATA = {};
	public ArrayList() {
        super();
        this.elementData = EMPTY_ELEMENTDATA;//数组初始化为一个空数组
    }
    public boolean add(E e) {
        //查看当前数组是否够多存一个元素
        ensureCapacityInternal(size + 1);  // Increments modCount!!
        elementData[size++] = e;
        return true;
    }
    private void ensureCapacityInternal(int minCapacity) {
        if (elementData == EMPTY_ELEMENTDATA) {//如果当前数组还是空数组
            //minCapacity按照 默认初始容量和minCapacity中的的最大值处理
            minCapacity = Math.max(DEFAULT_CAPACITY, minCapacity);
        }
		//看是否需要扩容处理
        ensureExplicitCapacity(minCapacity);
    }
	//...
```

JDK1.8

```java
private static final int DEFAULT_CAPACITY = 10;
private static final Object[] EMPTY_ELEMENTDATA = {};
private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};

    public ArrayList() {
        this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;//初始化为空数组
    }
    public boolean add(E e) {
        //查看当前数组是否够多存一个元素
        ensureCapacityInternal(size + 1);  // Increments modCount!!
        
        //存入新元素到[size]位置，然后size自增1
        elementData[size++] = e;
        return true;
    }
    private void ensureCapacityInternal(int minCapacity) {
        //如果当前数组还是空数组
        if (elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA) {
            //那么minCapacity取DEFAULT_CAPACITY与minCapacity的最大值
            minCapacity = Math.max(DEFAULT_CAPACITY, minCapacity);
        }
		//查看是否需要扩容
        ensureExplicitCapacity(minCapacity);
    }
    private void ensureExplicitCapacity(int minCapacity) {
        modCount++;//修改次数加1

        // 如果需要的最小容量  比  当前数组的长度  大，即当前数组不够存，就扩容
        if (minCapacity - elementData.length > 0)
            grow(minCapacity);
    }
    private void grow(int minCapacity) {
        // overflow-conscious code
        int oldCapacity = elementData.length;//当前数组容量
        int newCapacity = oldCapacity + (oldCapacity >> 1);//新数组容量是旧数组容量的1.5倍
        //看旧数组的1.5倍是否够
        if (newCapacity - minCapacity < 0)
            newCapacity = minCapacity;
        //看旧数组的1.5倍是否超过最大数组限制
        if (newCapacity - MAX_ARRAY_SIZE > 0)
            newCapacity = hugeCapacity(minCapacity);
        
        //复制一个新数组
        elementData = Arrays.copyOf(elementData, newCapacity);
    }
```

```java
    public boolean remove(Object o) {
        //先找到o在当前ArrayList的数组中的下标
        //分o是否为空两种情况讨论
        if (o == null) {
            for (int index = 0; index < size; index++)
                if (elementData[index] == null) {//null值用==比较
                    fastRemove(index);
                    return true;
                }
        } else {
            for (int index = 0; index < size; index++)
                if (o.equals(elementData[index])) {//非null值用equals比较
                    fastRemove(index);
                    return true;
                }
        }
        return false;
    }
    private void fastRemove(int index) {
        modCount++;//修改次数加1
        //需要移动的元素个数
        int numMoved = size - index - 1;
        
        //如果需要移动元素，就用System.arraycopy移动元素
        if (numMoved > 0)
            System.arraycopy(elementData, index+1, elementData, index,
                             numMoved);
        
        //将elementData[size-1]位置置空，让GC回收空间，元素个数减少
        elementData[--size] = null; // clear to let GC do its work
    }
```

```java
    public E remove(int index) {
        rangeCheck(index);//检验index是否合法

        modCount++;//修改次数加1
        
        //取出[index]位置的元素，[index]位置的元素就是要被删除的元素，用于最后返回被删除的元素
        E oldValue = elementData(index);
        
		//需要移动的元素个数
        int numMoved = size - index - 1;
        
        //如果需要移动元素，就用System.arraycopy移动元素
        if (numMoved > 0)
            System.arraycopy(elementData, index+1, elementData, index,
                             numMoved);
        //将elementData[size-1]位置置空，让GC回收空间，元素个数减少
        elementData[--size] = null; // clear to let GC do its work

        return oldValue;
    }
```

```java
    public E set(int index, E element) {
        rangeCheck(index);//检验index是否合法

        //取出[index]位置的元素，[index]位置的元素就是要被替换的元素，用于最后返回被替换的元素
        E oldValue = elementData(index);
        //用element替换[index]位置的元素
        elementData[index] = element;
        return oldValue;
    }
    public E get(int index) {
        rangeCheck(index);//检验index是否合法

        return elementData(index);//返回[index]位置的元素
    }
```

```java
    public int indexOf(Object o) {
        //分为o是否为空两种情况
        if (o == null) {
            //从前往后找
            for (int i = 0; i < size; i++)
                if (elementData[i]==null)
                    return i;
        } else {
            for (int i = 0; i < size; i++)
                if (o.equals(elementData[i]))
                    return i;
        }
        return -1;
    }
    public int lastIndexOf(Object o) {
         //分为o是否为空两种情况
        if (o == null) {
            //从后往前找
            for (int i = size-1; i >= 0; i--)
                if (elementData[i]==null)
                    return i;
        } else {
            for (int i = size-1; i >= 0; i--)
                if (o.equals(elementData[i]))
                    return i;
        }
        return -1;
    }
```

#### （3）LinkedList源码分析

```java
int size = 0;
Node<E> first;//记录第一个结点的位置
Node<E> last;//记录最后一个结点的位置

    private static class Node<E> {
        E item;//元素数据
        Node<E> next;//下一个结点
        Node<E> prev;//前一个结点

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }
```

```java
    public boolean add(E e) {
        linkLast(e);//默认把新元素链接到链表尾部
        return true;
    }
    void linkLast(E e) {
        final Node<E> l = last;//用l 记录原来的最后一个结点
        
        //创建新结点
        final Node<E> newNode = new Node<>(l, e, null);
        //现在的新结点是最后一个结点了
        last = newNode;
        
        //如果l==null，说明原来的链表是空的
        if (l == null)
            //那么新结点同时也是第一个结点
            first = newNode;
        else
            //否则把新结点链接到原来的最后一个结点的next中
            l.next = newNode;
        //元素个数增加
        size++;
        //修改次数增加
        modCount++;
    }
```

```java
    public boolean remove(Object o) {
        //分o是否为空两种情况
        if (o == null) {
            //找到o对应的结点x
            for (Node<E> x = first; x != null; x = x.next) {
                if (x.item == null) {
                    unlink(x);//删除x结点
                    return true;
                }
            }
        } else {
            //找到o对应的结点x
            for (Node<E> x = first; x != null; x = x.next) {
                if (o.equals(x.item)) {
                    unlink(x);//删除x结点
                    return true;
                }
            }
        }
        return false;
    }
    E unlink(Node<E> x) {//x是要被删除的结点
        // assert x != null;
        final E element = x.item;//被删除结点的数据
        final Node<E> next = x.next;//被删除结点的下一个结点
        final Node<E> prev = x.prev;//被删除结点的上一个结点

        //如果被删除结点的前面没有结点，说明被删除结点是第一个结点
        if (prev == null) {
            //那么被删除结点的下一个结点变为第一个结点
            first = next;
        } else {//被删除结点不是第一个结点
            //被删除结点的上一个结点的next指向被删除结点的下一个结点
            prev.next = next;
            //断开被删除结点与上一个结点的链接
            x.prev = null;//使得GC回收
        }

        //如果被删除结点的后面没有结点，说明被删除结点是最后一个结点
        if (next == null) {
            //那么被删除结点的上一个结点变为最后一个结点
            last = prev;
        } else {//被删除结点不是最后一个结点
            //被删除结点的下一个结点的prev执行被删除结点的上一个结点
            next.prev = prev;
            //断开被删除结点与下一个结点的连接
            x.next = null;//使得GC回收
        }
		//把被删除结点的数据也置空，使得GC回收
        x.item = null;
        //元素个数减少
        size--;
        //修改次数增加
        modCount++;
        //返回被删除结点的数据
        return element;
    }
```



## 12.5 Set

### 12.5.1 Set概述

Set系列的集合：不可重复的

Set系列的集合，有有序的也有无序的。HashSet无序的，TreeSet按照元素的大小顺序遍历，LinkedHashSet按照元素的添加顺序遍历。

List、Set 概述 

### 12.5.2 实现类的特点

（1）HashSet：

​	底层是HashMap实现。添加到HashSet的元素是作为HashMap的key，value是一个Object类型的常量对象PRESENT。

​	依赖于元素的hashCode()和equals()保证元素的不可重复，存储位置和hashCode()值有关，根据hashCode()来算出它在底层table数组中的[index]

（2）TreeSet

​	底层是TreeMap实现。添加到TreeSet的元素是作为TreeMap的key，value是一个Object类型的常量对象PRESENT。

​	依赖于元素的大小，要么是java.lang.Comparable接口compareTo(Object obj)，要么是java.util.Comparator接口的compare(Object o1, Object o2)来比较元素的大小。认为大小相等的两个元素就是重复元素。

（3）LinkedHashSet

​	底层是LinkedHashMap。添加到LinkedHashSet的元素是作为LinkedHashMap的key，value是一个Object类型的常量对象PRESENT。

​	LinkedHashSet是HashSet的子类，比父类多维护了元素的添加顺序。

​	当且仅当，你既想要元素不可重复，又要保证元素的添加顺序时，再使用它。

​	

## 12.6 Map

### 12.6.1 Map概述

用来存储键值对，映射关系的集合。所有的Map的key都不能重复。

键值对、映射关系的类型：Entry类型

```
Entry接口是Map接口的内部接口。所有的Map的键值对的类型都实现了这个接口。
HashMap中的映射关系，是有一个内部类来实现Entry的接口，JDK1.7是一个叫做Entry的内部类实现Entry接口。
JDK1.8是一个叫做Node的内部类实现Entry接口。
TreeMap中的映射关系，是有一个内部类Entry来实现Entry的接口
```

Map概述

用来存储键值对 映射关系的集合



### 12.6.2 API

（1）put(Object key, Object value)：添加一对映射关系

（2）putAll(Map m)：添加多对映射关系

（3）clear()：清空map

（4）remove(Object key)：根据key删除一对

（5）int size()：获取有效元素的对数

（6）containsKey(Object key)：是否包含某个key

（7）containsValue(Object value)：是否包含某个value

（8）Object  get(Object key)：根据key获取value

（9）遍历相关的几个方法

Collection  values()：获取所有的value进行遍历

Set keySet()：获取所有key进行遍历

Set entrySet()：获取所有映射关系进行遍历

### 12.6.3 Map的实现类们的区别

（1）HashMap：

​	依据key的hashCode()和equals()来保证key是否重复。

​	key如果重复，新的value会替换旧的value。

​	hashCode()决定了映射关系在table数组中的存储的位置，index = hash(key.hashCode()) & table.length-1 

​	HashMap的底层实现：JDK1.7是数组+链表；JDK1.8是数组+链表/红黑树

（2）TreeMap

​	依据key的大小来保证key是否重复。key如果重复，新的value会替换旧的value。

​	key的大小依赖于，java.lang.Comparable或java.util.Comparator。

（3）LinkedHashMap

​	依据key的hashCode()和equals()来保证key是否重复。key如果重复，新的value会替换旧的value。

​	LinkedHashMap是HashMap的子类，比HashMap多了添加顺序

### 12.6.4 HashMap源码分析

#### JDK1.6源码：

```java
    public HashMap() {
        //this.loadFactor加载因子，影响扩容的频率
        //DEFAULT_LOAD_FACTOR：默认加载因子0.75
        this.loadFactor = DEFAULT_LOAD_FACTOR;
        //threshold阈值 = 容量 * 加载因子
        //threshold阈值，当size达到threhold时，考虑扩容
        //扩容需要两个条件同时满足：（1）size >= threhold （2）table[index]！=null，即新映射关系要存入的位置非空
        threshold = (int)(DEFAULT_INITIAL_CAPACITY * DEFAULT_LOAD_FACTOR);
        //table是数组，
        //DEFAULT_INITIAL_CAPACITY：默认是16
        table = new Entry[DEFAULT_INITIAL_CAPACITY];
        init();
    }
```

#### JDK1.7源码：

你对工作地点有什么要求？都可以去吗？

你有了解设计模式吗？

你有应用过设计模式吗？

你能解释单例模式和工厂模式以及具体的应用吗？

你能给我讲讲Java虚拟机吗？

能说说数据库的优化？

开发工具的熟练度？IDEA、VsCode

前端JS、Vue的熟练程度？

Java的基本数据类型和引用类型？

你了解集合吗？讲讲集合Colleciton，Map？ArrayList和LinkedList的区别？

讲讲Map？ HashMap底层实现？List、Map说一个线程安全、线程不安全？

能接受加班的吗？

你有什么问题问我？



```java
    public HashMap() {
    	//DEFAULT_INITIAL_CAPACITY：默认初始容量16
    	//DEFAULT_LOAD_FACTOR：默认加载因子0.75
        this(DEFAULT_INITIAL_CAPACITY, DEFAULT_LOAD_FACTOR);
    }
    public HashMap(int initialCapacity, float loadFactor) {
        //校验initialCapacity合法性
        if (initialCapacity < 0)
            throw new IllegalArgumentException("Illegal initial capacity: " +
        //校验initialCapacity合法性                                       initialCapacity);
        if (initialCapacity > MAXIMUM_CAPACITY)
            initialCapacity = MAXIMUM_CAPACITY;
        //校验loadFactor合法性
        if (loadFactor <= 0 || Float.isNaN(loadFactor))
            throw new IllegalArgumentException("Illegal load factor: " +
                                               loadFactor);
		//加载因子，初始化为0.75
        this.loadFactor = loadFactor;
        // threshold 初始为初始容量                                  
        threshold = initialCapacity;
        init();
    }
```

```java
public V put(K key, V value) {
        //如果table数组是空的，那么先创建数组
        if (table == EMPTY_TABLE) {
            //threshold一开始是初始容量的值
            inflateTable(threshold);
        }
        //如果key是null，单独处理
        if (key == null)
            return putForNullKey(value);
        
        //对key的hashCode进行干扰，算出一个hash值
        int hash = hash(key);
        
        //计算新的映射关系应该存到table[i]位置，
        //i = hash & table.length-1，可以保证i在[0,table.length-1]范围内
        int i = indexFor(hash, table.length);
        
        //检查table[i]下面有没有key与我新的映射关系的key重复，如果重复替换value
        for (Entry<K,V> e = table[i]; e != null; e = e.next) {
            Object k;
            if (e.hash == hash && ((k = e.key) == key || key.equals(k))) {
                V oldValue = e.value;
                e.value = value;
                e.recordAccess(this);
                return oldValue;
            }
        }

        modCount++;
        //添加新的映射关系
        addEntry(hash, key, value, i);
        return null;
    }
    private void inflateTable(int toSize) {
        // Find a power of 2 >= toSize
        int capacity = roundUpToPowerOf2(toSize);//容量是等于toSize值的最接近的2的n次方
		//计算阈值 = 容量 * 加载因子
        threshold = (int) Math.min(capacity * loadFactor, MAXIMUM_CAPACITY + 1);
        //创建Entry[]数组，长度为capacity
        table = new Entry[capacity];
        initHashSeedAsNeeded(capacity);
    }
	//如果key是null，直接存入[0]的位置
    private V putForNullKey(V value) {
        //判断是否有重复的key，如果有重复的，就替换value
        for (Entry<K,V> e = table[0]; e != null; e = e.next) {
            if (e.key == null) {
                V oldValue = e.value;
                e.value = value;
                e.recordAccess(this);
                return oldValue;
            }
        }
        modCount++;
        //把新的映射关系存入[0]的位置，而且key的hash值用0表示
        addEntry(0, null, value, 0);
        return null;
    }
    void addEntry(int hash, K key, V value, int bucketIndex) {
        //判断是否需要库容
        //扩容：（1）size达到阈值（2）table[i]正好非空
        if ((size >= threshold) && (null != table[bucketIndex])) {
            //table扩容为原来的2倍，并且扩容后，会重新调整所有映射关系的存储位置
            resize(2 * table.length);
            //新的映射关系的hash和index也会重新计算
            hash = (null != key) ? hash(key) : 0;
            bucketIndex = indexFor(hash, table.length);
        }
		//存入table中
        createEntry(hash, key, value, bucketIndex);
    }
    void createEntry(int hash, K key, V value, int bucketIndex) {
        Entry<K,V> e = table[bucketIndex];
        //原来table[i]下面的映射关系作为新的映射关系next
        table[bucketIndex] = new Entry<>(hash, key, value, e);
        size++;//个数增加
    }
```

1、put(key,value)

（1）当第一次添加映射关系时，数组初始化为一个长度为**16**的**HashMap$Entry**的数组，这个HashMap$Entry类型是实现了java.util.**Map.Entry**接口

（2）特殊考虑：如果key为null，index直接是[0]

（3）在计算index之前，会对key的hashCode()值，做一个hash(key)再次哈希的运算，这样可以使得Entry对象更加散列的存储到table中

（4）计算index = table.length-1 & hash;

（5）如果table[index]下面，已经有映射关系的key与我要添加的新的映射关系的key相同了，会用新的value替换旧的value。

（6）如果没有相同的，会把新的映射关系添加到链表的头，原来table[index]下面的Entry对象连接到新的映射关系的next中。

（7）添加之前先判断if(size >= threshold  &&  table[index]!=null)如果该条件为true，会扩容

​	if(size >= threshold  &&  table[index]!=null){

​		①会扩容

​		②会重新计算key的hash

​		③会重新计算index

​	}

2、get(key)

（1）计算key的hash值，用这个方法hash(key)

（2）找index = table.length-1 & hash;

（3）如果table[index]不为空，那么就挨个比较哪个Entry的key与它相同，就返回它的value

3、remove(key)

（1）计算key的hash值，用这个方法hash(key)

（2）找index = table.length-1 & hash;

（3）如果table[index]不为空，那么就挨个比较哪个Entry的key与它相同，就删除它，把它前面的Entry的next的值修改为被删除Entry的next

#### JDK1.8源码

```java
几个常量和变量：
（1）DEFAULT_INITIAL_CAPACITY：默认的初始容量 16
（2）MAXIMUM_CAPACITY：最大容量  1 << 30
（3）DEFAULT_LOAD_FACTOR：默认加载因子 0.75
（4）TREEIFY_THRESHOLD：默认树化阈值8，当链表的长度达到这个值后，要考虑树化
（5）UNTREEIFY_THRESHOLD：默认反树化阈值6，当树中的结点的个数达到这个阈值后，要考虑变为链表
（6）MIN_TREEIFY_CAPACITY：最小树化容量64
		当单个的链表的结点个数达到8，并且table的长度达到64，才会树化。
		当单个的链表的结点个数达到8，但是table的长度未达到64，会先扩容
（7）Node<K,V>[] table：数组
（8）size：记录有效映射关系的对数，也是Entry对象的个数
（9）int threshold：阈值，当size达到阈值时，考虑扩容
（10）double loadFactor：加载因子，影响扩容的频率
```

```java
    public HashMap() {
        this.loadFactor = DEFAULT_LOAD_FACTOR; 
        // all other fields defaulted，其他字段都是默认值
    }
```

```java
    public V put(K key, V value) {
        return putVal(hash(key), key, value, false, true);
    }
	//目的：干扰hashCode值
    static final int hash(Object key) {
        int h;
		//如果key是null，hash是0
		//如果key非null，用key的hashCode值 与 key的hashCode值高16进行异或
		//		即就是用key的hashCode值高16位与低16位进行了异或的干扰运算
		
		/*
		index = hash & table.length-1
		如果用key的原始的hashCode值  与 table.length-1 进行按位与，那么基本上高16没机会用上。
		这样就会增加冲突的概率，为了降低冲突的概率，把高16位加入到hash信息中。
		*/
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }
    final V putVal(int hash, K key, V value, boolean onlyIfAbsent, boolean evict) {
        Node<K,V>[] tab; //数组
		Node<K,V> p; //一个结点
		int n, i;//n是数组的长度   i是下标
		
		//tab和table等价
		//如果table是空的
        if ((tab = table) == null || (n = tab.length) == 0){
            n = (tab = resize()).length;
            /*
			tab = resize();
			n = tab.length;*/
			/*
			如果table是空的，resize()完成了①创建了一个长度为16的数组②threshold = 12
			n = 16
			*/
        }
		//i = (n - 1) & hash ，下标 = 数组长度-1 & hash
		//p = tab[i] 第1个结点
		//if(p==null) 条件满足的话说明 table[i]还没有元素
		if ((p = tab[i = (n - 1) & hash]) == null){
			//把新的映射关系直接放入table[i]
            tab[i] = newNode(hash, key, value, null);
			//newNode（）方法就创建了一个Node类型的新结点，新结点的next是null
        }else {
            Node<K,V> e; 
			K k;
			//p是table[i]中第一个结点
			//if(table[i]的第一个结点与新的映射关系的key重复)
            if (p.hash == hash &&
                ((k = p.key) == key || (key != null && key.equals(k)))){
                e = p;//用e记录这个table[i]的第一个结点
			}else if (p instanceof TreeNode){//如果table[i]第一个结点是一个树结点
                //单独处理树结点
                //如果树结点中，有key重复的，就返回那个重复的结点用e接收，即e!=null
                //如果树结点中，没有key重复的，就把新结点放到树中，并且返回null，即e=null
				e = ((TreeNode<K,V>)p).putTreeVal(this, tab, hash, key, value);
            }else {
				//table[i]的第一个结点不是树结点，也与新的映射关系的key不重复
				//binCount记录了table[i]下面的结点的个数
                for (int binCount = 0; ; ++binCount) {
					//如果p的下一个结点是空的，说明当前的p是最后一个结点
                    if ((e = p.next) == null) {
						//把新的结点连接到table[i]的最后
                        p.next = newNode(hash, key, value, null);
						
						//如果binCount>=8-1，达到7个时
                        if (binCount >= TREEIFY_THRESHOLD - 1){ // -1 for 1st
                            //要么扩容，要么树化
							treeifyBin(tab, hash);
						}
                        break;
                    }
					//如果key重复了，就跳出for循环，此时e结点记录的就是那个key重复的结点
            if (e.hash == hash &&((k = e.key) == key || (key != null && key.equals(k)))){
                        break;
					}
                    p = e;//下一次循环，e=p.next，就类似于e=e.next，往链表下移动
                }
            }
			//如果这个e不是null，说明有key重复，就考虑替换原来的value
            if (e != null) { // existing mapping for key
                V oldValue = e.value;
                if (!onlyIfAbsent || oldValue == null){
                    e.value = value;
				}
                afterNodeAccess(e);//什么也没干
                return oldValue;
            }
        }
        ++modCount;
		
		//元素个数增加
		//size达到阈值
        if (++size > threshold){
            resize();//一旦扩容，重新调整所有映射关系的位置
		}
        afterNodeInsertion(evict);//什么也没干
        return null;
    }	
	
   final Node<K,V>[] resize() {
        Node<K,V>[] oldTab = table;//oldTab原来的table
		//oldCap：原来数组的长度
        int oldCap = (oldTab == null) ? 0 : oldTab.length;
		
		//oldThr：原来的阈值
        int oldThr = threshold;//最开始threshold是0
		
		//newCap，新容量
		//newThr：新阈值
        int newCap, newThr = 0;
        if (oldCap > 0) {//说明原来不是空数组
            if (oldCap >= MAXIMUM_CAPACITY) {//是否达到数组最大限制
                threshold = Integer.MAX_VALUE;
                return oldTab;
            }else if ((newCap = oldCap << 1) < MAXIMUM_CAPACITY &&
                     oldCap >= DEFAULT_INITIAL_CAPACITY){
				//newCap = 旧的容量*2 ，新容量<最大数组容量限制
				//新容量：32,64，...
				//oldCap >= 初始容量16
				//新阈值重新算 = 24，48 ....
                newThr = oldThr << 1; // double threshold
			}
        }else if (oldThr > 0){ // initial capacity was placed in threshold
            newCap = oldThr;
        }else {               // zero initial threshold signifies using defaults
            newCap = DEFAULT_INITIAL_CAPACITY;//新容量是默认初始化容量16
			//新阈值= 默认的加载因子 * 默认的初始化容量 = 0.75*16 = 12
            newThr = (int)(DEFAULT_LOAD_FACTOR * DEFAULT_INITIAL_CAPACITY);
        }
        if (newThr == 0) {
            float ft = (float)newCap * loadFactor;
            newThr = (newCap < MAXIMUM_CAPACITY && ft < (float)MAXIMUM_CAPACITY ?
                      (int)ft : Integer.MAX_VALUE);
        }
        threshold = newThr;//阈值赋值为新阈值12，24.。。。
		
		//创建了一个新数组，长度为newCap，16，32,64.。。
        @SuppressWarnings({"rawtypes","unchecked"})
            Node<K,V>[] newTab = (Node<K,V>[])new Node[newCap];
        table = newTab;
		
		
        if (oldTab != null) {//原来不是空数组
			//把原来的table中映射关系，倒腾到新的table中
            for (int j = 0; j < oldCap; ++j) {
                Node<K,V> e;
                if ((e = oldTab[j]) != null) {//e是table下面的结点
                    oldTab[j] = null;//把旧的table[j]位置清空
                    if (e.next == null)//如果是最后一个结点
                        newTab[e.hash & (newCap - 1)] = e;//重新计算e的在新table中的存储位置，然后放入
                    else if (e instanceof TreeNode)//如果e是树结点
						//把原来的树拆解，放到新的table
                        ((TreeNode<K,V>)e).split(this, newTab, j, oldCap);
                    else { // preserve order
                        Node<K,V> loHead = null, loTail = null;
                        Node<K,V> hiHead = null, hiTail = null;
                        Node<K,V> next;
						/*
						把原来table[i]下面的整个链表，重新挪到了新的table中
						*/
                        do {
                            next = e.next;
                            if ((e.hash & oldCap) == 0) {
                                if (loTail == null)
                                    loHead = e;
                                else
                                    loTail.next = e;
                                loTail = e;
                            }
                            else {
                                if (hiTail == null)
                                    hiHead = e;
                                else
                                    hiTail.next = e;
                                hiTail = e;
                            }
                        } while ((e = next) != null);
                        if (loTail != null) {
                            loTail.next = null;
                            newTab[j] = loHead;
                        }
                        if (hiTail != null) {
                            hiTail.next = null;
                            newTab[j + oldCap] = hiHead;
                        }
                    }
                }
            }
        }
        return newTab;
    }	
	
    Node<K,V> newNode(int hash, K key, V value, Node<K,V> next) {
		//创建一个新结点
	   return new Node<>(hash, key, value, next);
    }

    final void treeifyBin(Node<K,V>[] tab, int hash) {
        int n, index; 
		Node<K,V> e;
		//MIN_TREEIFY_CAPACITY：最小树化容量64
		//如果table是空的，或者  table的长度没有达到64
        if (tab == null || (n = tab.length) < MIN_TREEIFY_CAPACITY)
            resize();//先扩容
        else if ((e = tab[index = (n - 1) & hash]) != null) {
			//用e记录table[index]的结点的地址
            TreeNode<K,V> hd = null, tl = null;
			/*
			do...while，把table[index]链表的Node结点变为TreeNode类型的结点
			*/
            do {
                TreeNode<K,V> p = replacementTreeNode(e, null);
                if (tl == null)
                    hd = p;//hd记录根结点
                else {
                    p.prev = tl;
                    tl.next = p;
                }
                tl = p;
            } while ((e = e.next) != null);
			
            //如果table[index]下面不是空
            if ((tab[index] = hd) != null)
                hd.treeify(tab);//将table[index]下面的链表进行树化
        }
    }	
```

1、添加过程

（1）当第一次添加映射关系时，数组初始化为一个长度为**16**的**HashMap$Node**的数组，这个HashMap$Node类型是实现了java.util.**Map.Entry**接口

（2）在计算index之前，会对key的hashCode()值，做一个hash(key)再次哈希的运算，这样可以使得Entry对象更加散列的存储到table中

> JDK1.8关于hash(key)方法的实现比JDK1.7要简洁。 key.hashCode() ^ key.Code()>>>16;

（3）计算index = table.length-1 & hash;

（4）如果table[index]下面，已经有映射关系的key与我要添加的新的映射关系的key相同了，会用新的value替换旧的value。

（5）如果没有相同的，

①table[index]链表的长度没有达到8个，会把新的映射关系添加到链表的尾

②table[index]链表的长度达到8个，但是table.length没有达到64，会先对table进行扩容，然后再添加

③table[index]链表的长度达到8个，并且table.length达到64，会先把该分支进行树化，结点的类型变为TreeNode，然后把链表转为一棵红黑树

④table[index]本来就已经是红黑树了，那么直接连接到树中，可能还会考虑考虑左旋右旋以保证树的平衡问题

（6）添加完成后判断if(size > threshold ){

​		①会扩容

​		②会重新计算key的hash

​		③会重新计算index

​	}



2、remove(key)

（1）计算key的hash值，用这个方法hash(key)

（2）找index = table.length-1 & hash;

（3）如果table[index]不为空，那么就挨个比较哪个Entry的key与它相同，就删除它，把它前面的Entry的next的值修改为被删除Entry的next

（4）如果table[index]下面原来是红黑树，结点删除后，个数小于等于6，会把红黑树变为链表

### 12.6.5 关于HashMap的面试问题

1、HashMap的底层实现

> 答：JDK1.7是数组+链表，JDK1.8是数组+链表/红黑树

2、HashMap的数组的元素类型

> 答：java.util.Map$Entry接口类型。
>
> JDK1.7的HashMap中有内部类Entry实现Entry接口
>
> JDK1.8的HashMap中有内部类Node和TreeNode类型实现Entry接口

3、为什么要使用数组？

>  答：因为数组的访问的效率高

4、为什么数组还需要链表？或问如何解决hash或[index]冲突问题？

>  答：为了解决hash和[index]冲突问题
>
>  （1）两个不相同的key的hashCode值本身可能相同
>
>  （2）两个hashCode不相同的key，通过hash(key)以及 hash & table.length-1运算得到的[index]可能相同
>
>  那么意味着table[index]下可能需要存储多个Entry的映射关系对象，所以需要链表

5、HashMap的数组的初始化长度

> 答：默认的初始容量值是16

6、HashMap的映射关系的存储索引index如何计算

> 答：hash & table.length-1

7、为什么要使用hashCode()? 空间换时间

> 答：因为hashCode()是一个整数值，可以用来直接计算index，效率比较高，用数组这种结构虽然会浪费一些空间，但是可以提高查询效率。

8、hash()函数的作用是什么

>  答：在计算index之前，会对key的hashCode()值，做一个hash(key)再次哈希的运算，这样可以使得Entry对象更加散列的存储到table中
>
>  JDK1.8关于hash(key)方法的实现比JDK1.7要简洁。 key.hashCode() ^ key.Code()>>>16; 因为这样可以使得hashCode的高16位信息也能参与到运算中来

9、HashMap的数组长度为什么一定要是2的幂次方

> 答：因为2的n次方-1的二进制值是前面都0，后面几位都是1，这样的话，与hash进行&运算的结果就能保证在[0,table.length-1]范围内，而且是均匀的。

10、HashMap 为什么使用 &按位与运算代替%模运算？

> 答：因为&效率高

11、HashMap的数组什么时候扩容？

> 答：JDK1.7版：当要添加新Entry对象时发现（1）size达到threshold（2）table[index]!=null时，两个条件同时满足会扩容
>
> JDK1.8版：当要添加新Entry对象时发现（1）size达到threshold（2）当table[index]下的结点个数达到8个但是table.length又没有达到64。两种情况满足其一都会导致数组扩容
>
> 而且数组一旦扩容，不管哪个版本，都会导致所有映射关系重新调整存储位置。

12、如何计算扩容阈值(临界值)？

> 答：threshold = capacity * loadfactor

13、loadFactor为什么是0.75，如果是1或者0.1呢有什么不同？

> 答：1的话，会导致某个table[index]下面的结点个数可能很长
>
> 0.1的话，会导致数组扩容的频率太高

14、JDK1.8的HashMap什么时候树化？

> 答：当table[index]下的结点个数达到8个但是table.length已经达到64

15、JDK1.8的HashMap什么时候反树化？

> 答：当table[index]下的树结点个数少于6个

16、JDK1.8的HashMap为什么要树化？

> 答：因为当table[index]下的结点个数超过8个后，查询效率就低下了，修改为红黑树的话，可以提高查询效率

17、JDK1.8的HashMap为什么要反树化？

> 答：因为因为当table[index]下树的结点个数少于6个后，使用红黑树反而过于复杂了，此时使用链表既简洁又效率也不错

18、作为HashMap的key类型重写equals和hashCode方法有什么要求

​	（1）equals与hashCode一起重写

​	（2）重写equals()方法，但是有一些注意事项；

* 自反性：x.equals(x)必须返回true。
  对称性：x.equals(y)与y.equals(x)的返回值必须相等。
  传递性：x.equals(y)为true，y.equals(z)也为true，那么x.equals(z)必须为true。
  一致性：如果对象x和y在equals()中使用的信息都没有改变，那么x.equals(y)值始终不变。
  非null：x不是null，y为null，则x.equals(y)必须为false。

​	（3）重写hashCode（）的注意事项

* 如果equals返回true的两个对象，那么hashCode值一定相同，并且只要参与equals判断属性没有修改，hashCode值也不能修改；
  如果equals返回false的两个对象，那么hashCode值可以相同也可以不同；
  如果hashCode值不同的，equals一定要返回false；
  hashCode不宜过简单，太简单会导致冲突严重，hashCode也不宜过于复杂，会导致性能低下；

19、为什么大部分 hashcode 方法使用 31？

>  答：因为31是一个不大不小的素数

20、请问已经存储到HashMap中的key的对象属性是否可以修改？为什么？

> 答：如果该属性参与hashCode的计算，那么不要修改。因为一旦修改hashCode()已经不是原来的值。
> 而存储到HashMap中时，key的hashCode()-->hash()-->hash已经确定了，不会重新计算。用新的hashCode值再查询get(key)/删除remove(key)时，算的hash值与原来不一样就不找不到原来的映射关系了。

21、所以为什么，我们实际开发中，key的类型一般用String和Integer

> 答：因为他们不可变。

22、为什么HashMap中的Node或Entry类型的hash变量与key变量加final声明？

>  答：因为不希望你修改hash和key值

23、为什么HashMap中的Node或Entry类型要单独存储hash？

>  答：为了在添加、删除、查找过程中，比较hash效率更高，不用每次重新计算key的hash值

24、请问已经存储到HashMap中的value的对象属性是否可以修改？为什么？

> 答：可以。因为我们存储、删除等都是根据key，和value无关。

25、如果key是null是如何存储的？

> 答：会存在table[0]中

## 12.7 集合框架图

![1560348912361](imgs/1560348912361.png)