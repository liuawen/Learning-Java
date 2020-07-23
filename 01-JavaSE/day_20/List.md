



# List

[TOC]

Collection是根接口，没有提供任何直接实现的。它有一些更具体的子接口，例如：List和Set。

List系列的集合：有序的、可重复的。

List系列的集合：

* ArrayList（动态数组）
* Vector（动态数组，向量类）
* LinkedList（双向链表、双端队列、栈..）
* Stack（栈）

# 1、List概述

List：是Collection的子接口。

List系列的集合：有序的、可重复的

有序的  数组的下标、链表   可以存在重复的元素

List系列的常用集合：ArrayList、Vector、LinkedList、Stack

List系列的集合：

* ArrayList（动态数组）
* Vector（动态数组，向量类）
* LinkedList（双向链表、双端队列、栈..） 双向链表 双端队列 栈
* Stack（栈）

# 2、List的API

 List接口比Collection接口多了一堆方法，和它相同的方法在集合框架-collection那里写了。

常用方法：

（1）boolean add(Object obj)：添加一个

向列表的尾部添加指定的元素

（2）boolean addAll（Collection c）：添加多个

添加指定 collection 中的所有元素到此列表的结尾，顺序是指定 collection 的迭代器返回这些元素的顺序

（3）void add(int index, Object element) ：在[index]位置添加一个元素，相当于插入

在列表的指定位置插入指定元素

（4）boolean addAll(int index, Collection c) ：在[index]位置添加多个元素

将指定 collection 中的所有元素都插入到列表中的指定位置

```java
@SuppressWarnings("all")
	@Test
	public void test1(){
		//这里左边用List多态引用的目的是为了关注List接口方法
		List list = new ArrayList();

		list.add("张三");
		list.add(0, "李四");
		System.out.println(list);// [李四, 张三]

		List list2 = new ArrayList();
		list2.add("小王吧");
		list2.add("你好吧");
		System.out.println(list2);//[小王吧, 你好吧]
		list2.addAll(1,list);
		System.out.println(list2);//[小王吧, 李四, 张三, 你好吧]
	}
```



（5）boolean remove(Object obj)：删除一个



（6）Object remove(int index)：删除指定位置的元素，并返回刚刚删除的元素

移除列表中指定位置的元素（可选操作）。将所有的后续元素向左移动（将其索引减 1）。返回从列表中移除的元素。 



（7）boolean removeAll(Collection c )： 删除多个

从列表中移除指定 collection 中包含的其所有元素（可选操作）。 

```java
@SuppressWarnings("all")
	@Test
	public void test2(){
		//这里左边用List多态引用的目的是为了关注List接口方法
		List list = new ArrayList();
		
		list.add("张三");
		list.add(0, "李四");
		
		list.remove(1);
		System.out.println(list);//[李四]

		String str = (String) list.remove(0);
		System.out.println(str);//李四
		System.out.println(list);//[]
		list.add("王五");
		System.out.println(list);//[王五]
		list.remove("王五");
		System.out.println(list);//[]

		list.add("小白");
		list.add("小菜");
		System.out.println(list);//[小白, 小菜]
		List list2 = new ArrayList();
		list2.add("小菜");
		list2.add("小白");
		System.out.println(list2);//[小菜, 小白]
		list.removeAll(list2);
		System.out.println(list);//[]
	}
```

注意remove(Object obj)  ？   remove(int index)

```java
	@SuppressWarnings("all")
	@Test
	public void test3(){
		//这里左边用List多态引用的目的是为了关注List接口方法
		List list = new ArrayList();
		
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		
		/*
		 * 这里remove(1)它，调用的是remove(int index)这个方法
		 * 为什么不是调用remove(Object obj)？因为1是基本数据类型，和int最匹配
		 */
//		list.remove(1);//删除的是[1]的对象
		list.remove(new Integer(1));//删除的是对象
		System.out.println(list);//[2, 3, 4]
		
		list.remove(1);
		System.out.println(list);//[2, 4]
	}
	
```



（8）boolean contains(Object c)：是否包含某个

如果列表包含指定的元素，则返回 true。

（9）boolean containsAll(Collection c)： 是否包含所有

如果列表包含指定 collection 的所有元素，则返回 true。

```java
 @SuppressWarnings("all")
    @Test
    public void test9() {
        //这里左边用List多态引用的目的是为了关注List接口方法
        List list = new ArrayList();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        System.out.println(list.contains(1));//true

		List list2 = new ArrayList();

		list2.add(1);
		list2.add(2);
		list2.add(3);
		list2.add(4);
		list2.add(5);

		System.out.println(list.containsAll(list2));//true
		list2.remove(1);
		System.out.println(list2);//[1, 3, 4, 5]
		System.out.println(list.containsAll(list2));//true
		list.remove(new Integer(1));
		System.out.println(list);//[2, 3, 4, 5]
		System.out.println(list.containsAll(list2));//false

    }
```



（10）boolean isEmpty()：是否为空

（11）int size()：获取元素个数

（12）void clear()：清空集合

```java
 @SuppressWarnings("all")
    @Test
    public void test9() {
        //这里左边用List多态引用的目的是为了关注List接口方法
        List list = new ArrayList();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        System.out.println(list.contains(1));//true

		List list2 = new ArrayList();

		list2.add(1);
		list2.add(2);
		list2.add(3);
		list2.add(4);
		list2.add(5);

		System.out.println(list.containsAll(list2));//true
		list2.remove(1);
		System.out.println(list2);//[1, 3, 4, 5]
		System.out.println(list.containsAll(list2));//true
		list.remove(new Integer(1));
		System.out.println(list);//[2, 3, 4, 5]
		System.out.println(list.containsAll(list2));//false

    }
```



（13）Object[] toArray()：获取所有元素



（14）Iterator iterator()： 获取遍历当前集合的迭代器对象

（15）retainAll(Collection c)：求当前集合与c集合的交集

（16）ListIterator listIterator()：获取遍历当前集合的迭代器对象，这个迭代器可以往前、往后遍历

（17）ListIterator listIterator(int index)：从[index]位置开始，往前或往后遍历

ListIterator listIterator() ：获取一种迭代器

ListIterator是Iterator的子接口，它比Iterator增加了：从后往前遍历的方法，增加了遍历的同时添加和修改。

```java
   @SuppressWarnings("all")
    @Test
    public void test7() {
        //这里左边用List多态引用的目的是为了关注List接口方法
        List list = new ArrayList();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

//		ListIterator listIterator = list.listIterator();//默认游标在开头
        ListIterator listIterator = list.listIterator(list.size());//把游标指定到后面去
        while (listIterator.hasPrevious()) {
            Object obj = listIterator.previous();
            System.out.println(obj);
        }
        //Result
		//5
		//4
		//3
		//2
		//1
    }
    
```



```java
 @SuppressWarnings("all")
    @Test
    public void test8() {
        //这里左边用List多态引用的目的是为了关注List接口方法
        List list = new ArrayList();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        ListIterator listIterator = list.listIterator(3);//把游标指定到任意位置
        while (listIterator.hasPrevious()) {
            Object obj = listIterator.previous();
            System.out.println(obj);
        }
        //Result
		//3
		//2
		//1
    }

```



（18）Object get(int index)：返回index位置的元素

Object get(int index) ：获取，返回[index]位置的元素

Object set(int index, Object element) ：替换[index]位置的元素为element

（19）List  subList(int start, int end)：截取[start,end)部分的子列表

（20）int indexOf(Object o)  ：在当前集合中查找o这个元素的下标，如果没有返回-1，如果有多个就返回找到的第一个的下标

（21） int lastIndexOf(Object o) ：在当前集合中查找o这个元素的下标，如果没有返回-1，如果有多个就返回找到的最后一个的下标



```java
   @SuppressWarnings("all")
    @Test
    public void test11() {
        //这里左边用List多态引用的目的是为了关注List接口方法
        List list = new ArrayList();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        System.out.println(list);//[1, 2, 3, 4, 5]
        Object obj = list.get(1);
        System.out.println(obj);//2
        list.set(0, 10);
        System.out.println(list);//[10, 2, 3, 4, 5]
        List list2 = list.subList(1, 3);
        System.out.println(list2);//[2, 3]
		
        list.add(2);
        System.out.println(list);//[10, 2, 3, 4, 5, 2]
        int index1 = list.indexOf(2);
        System.out.println(index1);//1
        int index2 = list.lastIndexOf(2);
        System.out.println(index2);//5
    }
```



# 3、 ListIterator 接口

Iterator 接口的方法：

（1）boolean hasNext()

以正向遍历列表时，如果列表迭代器有多个元素，则返回 `true`

（2）Object next()

返回列表中的下一个元素。

E next()

（3）void remove()

ListIterator 是 Iterator子接口：增加了如下方法

从列表中移除由 `next` 或 `previous` 返回的最后一个元素（可选操作）。

（4）void add(Object obj) 遍历的同时，添加元素

将指定的元素插入列表

（5）void set(Object obj)  遍历的同时，替换元素

用指定元素替换 `next` 或 `previous` 返回的最后一个元素（可选操作）。

（6）boolean hasPrevious()  是否前面还有元素

 如果以逆向遍历列表，列表迭代器有多个元素，则返回 `true`。

（7）Object previous() 获取前面的元素

E previous()

返回列表中的前一个元素。

（8）int nextIndex() 返回下一个元素的索引

 返回对 `next` 的后续调用所返回元素的索引。

（9）int previousIndex() 返回前一个元素的索引 

 返回对 `previous` 的后续调用所返回元素的索引。

说明：虽然List系列的集合都是可以通过索引/下标进行操作的，但是像LinkedList这类的集合，其实不建议使用和索引相关的方法进行操作。因为它们的底层的物理结构不是数组，如果通过索引操作呢，会需要从头或尾遍历找到对应的索引，效率不高。

LinkedList：底层物理结构是双向链表   遍历查找对应的索引  效率不高的



# 4 、List的实现类们的区别

ArrayList、Vector、LinkedList、Stack

ArrayList动态数组  Vector 动态数组 向量类 LinkedList双向链表 Stack

## 一、List接口的实现类们：

一、List接口的实现类们：

1、Vector：动态数组

物理结构：数组

2、ArrayList：动态数组

物理结构：数组

3、Stack：栈，它是Vector的子类

物理结构：数组

4、LinkedList：双向链表

物理结构：链表

## 二、Vector和ArrayList的区别？（同时也是面试题）

二、Vector和ArrayList的区别？（同时也是面试题）

Vector：最早版本的动态数组（旧版），线程安全的（有线程同步的），不够后扩容为原来的2倍，初始容量：10，

Vector支持的遍历集合的方式有：（1）foreach（2）Iterator（3）支持旧版的Enumeration迭代器

ArrayList：相对Vector来说新一点（新版），线程不安全的（没有线程同步的），不够后扩容为原来的1.5倍，初始容量：10，

ArrayList支持的遍历集合的方式有：（1）foreach（2）Iterator

2倍：造成空间浪费的可能性比较大

1.5倍：造成扩容的次数增大



Vector和ArrayList的使用时，为了比较空间浪费，和扩容次数太多，如果能够预估大概的元素个数，那么可以用

ArrayList(int initialCapacity)和Vector(int initialCapacity)直接初始化为一定容量的数组。





StringBuffer和StringBuilder类似



## 三、Stack：栈

三、Stack：栈

先进后出（FILO）或后进先出（LIFO：Last in first out）

Stack是Vector的子类，比Vector多了几个方法，它的后进先出的特征，就是通过调用这几个方法实现的。

(1)Object peek() ：访问当前栈顶元素，但是不拿走栈顶元素

```java
	@Test
	public void test1(){
		Stack s = new Stack();
		s.add("1");
		s.add("2");
		s.add("3");
		s.add("4");
		
		System.out.println(s.peek());//4
		System.out.println(s.peek());//4
		System.out.println(s.peek());//4
	}
```

peek （计算机）读取数据 

(2)Object pop()：弹出栈顶元素

```java
@Test
	public void test2(){
		Stack s = new Stack();
		s.add("1");
		s.add("2");
		s.add("3");
		s.add("4");
		
		System.out.println(s.pop());//4
		System.out.println(s.pop());//3
		System.out.println(s.pop());//2
		System.out.println(s.pop());//1
//		System.out.println(s.pop());//java.util.EmptyStackException
	}
	
```



```java
	@Test
	public void test5(){
		LinkedList list = new LinkedList();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		
		System.out.println(list.poll());//1
		System.out.println(list.poll());//2
		System.out.println(list.poll());//3
		System.out.println(list.poll());//4
	}
```



(3)Object push(Object item) ：把元素压入栈顶，等价于add(item)

这里为了更形象化，单独设计了一个push。

```java
@Test
	public void test3(){
		Stack s = new Stack();
		s.push("1");//push比add可读性更好，功能是一样的
		s.push("2");
		s.push("3");
		s.push("4");
		
		System.out.println(s.pop());//4
		System.out.println(s.pop());//3
		System.out.println(s.pop());//2
		System.out.println(s.pop());//1
	}
```

先进后出

```java
	
	@Test
	public void test4(){
		//用ArrayList，实现后进先出的效果
		ArrayList list = new ArrayList();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		
		System.out.println(list.remove(list.size()-1));//4
		System.out.println(list.remove(list.size()-1));//3
		System.out.println(list.remove(list.size()-1));//2
		System.out.println(list.remove(list.size()-1));//1
	}
```



## 四、LinkedList：双向链表

四、LinkedList：双向链表（双向链表、队列、栈、双端队列、单向链表等各种数据结构的效果）

内部有一个结点的类型：

```java
class Node{

Object data;

Node previous;

Node next;

}
```



```java
class LinkedList{

Node first;//记录第一个结点的地址

Node last;//记录最后一个结点的地址

}
```

空链表：if(first == null && last ==null)

有一个结点：  first == last

第一个结点：  first.previous = null

最后一个结点：last.next == null



LinkedList可以被当做双向链表、栈、队列、双端队列等数据结构使用。

如何体现双向链表？方法

(1)E getFirst() 

(2)E getLast() 

(3)boolean offerFirst(E e) ：添加的第一个

(4)boolean offerLast(E e)  :添加到最后一个

(5)int indexOf(Object o)  ：从first开始找

(6)int lastIndexOf(Object o) ：从last开始找

(7) E get(int index)  

先判断index是靠前还是靠后



如何体现栈？

E peek() 

E pop() 

void push(E e) 



如何体现队列？实现了Queue接口

队列：先进先出（FIFO）

抛出异常      	返回特殊值 
插入 add(e)     offer(e) 
移除 remove()   poll() 
检查 element()  peek() 

offer(e) 将指定的元素插入此队列 

poll() 获取并移除此队列的头，如果此队列为空，则返回 null。 

peek()获取但不移除此队列的头；如果此队列为空，则返回 null。 

如何体现双端队列？JDK1.6才支持，实现了Deque（double ended queue（双端队列）的缩写）

下表总结了上述 12 种方法： 

 第一个元素（头部）		 			最后一个元素（尾部） 
 抛出异常 			特殊值 			抛出异常          特殊值 
插入 addFirst(e) offerFirst(e) addLast(e) offerLast(e) 
移除 removeFirst() pollFirst() removeLast() pollLast() 
检查 getFirst() peekFirst()    getLast() peekLast() 

## 五、小结

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



# 5、 源码分析

## （1）Vector

```java
@Test
	public void test1(){
		Vector v = new Vector();
		
		v.add("1");
		v.add(0, "2");//[0]
		
		v.remove(1);
		
		v.remove("1");
		
		int index = v.indexOf("1");
	}
```



 Vector源码跟踪：

（1）new Vector()：初始化长度为10的数组，默认增量是0

（2）add(E e)：

默认扩容为原来的2倍

如果你手动指定了capacityIncrement的值，那么可以按照你指定增量进行扩容。

（3）add(index,e)：

①考虑扩容

②移动元素

③添加元素

④元素个数增加

（4）remove(index)：

①计算要移动元素的个数

②如果需要移动，调用System.arraycopy方法进行移动

③elementData[--elementCount] = null;

（5）remove(Object obj)

①查找obj的下标

②如果不是-1就调用remove(index)进行删除

（6）indexOf(Object obj)

对obj分情况讨论：（1）是null（2）不是null

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

## （2）ArrayList源码分析

ArrayList动态数组：源码跟踪

(1)new ArrayList()：

JDK1.8版本：发现内部初始化为了一个长度为0的空数组  DEFAULTCAPACITY_EMPTY_ELEMENTDATA

JDK1.7版本：也是初始化为长度为0的空数组  EMPTY_ELEMENTDATA;	

JDK1.6版本：初始化为长度为10的数组

为什么要初始化为空数组呢？

因为开发中，很多时候创建了ArrayList的对象，但是没有装元素，这个时候的话，如果初始化为10的数组，就浪费空间了。

(2)add(Object e）

JDK1.8 第一次添加元素，扩容为长度为10的数组
JDK1.8  如果不够了，再扩容为1.5倍



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

## （3）Stack：栈   源码分析

```java
/*
 * Stack：栈   源码分析
 * 
 * （1）peek
 * 返回size-1位置的元素
 * （2）pop
 * ①先peek()返回栈顶元素
 * ②删除size-1位置的元素
 * （3）push：等价于add
 * 把元素添加到[size++]位置
 */
public class TestStack {
	public static void main(String[] args) {
		Stack s  = new Stack();
		s.push(1);
		s.peek();
		s.pop();
	}
}

```



## （4）LinkedList源码分析

```java
import java.util.LinkedList;

/*
 * LinkedList：源码分析
 * (1)new LinkedList()：什么也没干，没有创建结点
 * (2)add(e)
 *     void linkLast(E e) {
        final Node<E> l = last;
		
		//新结点的pre是刚刚的最后一个结点
		//新结点的下一个结点是null，没有
        final Node<E> newNode = new Node<>(l, e, null);
		
		//新结点成为了最后一个结点
        last = newNode;
		
		//如果之前的最后一个结点是null，表示刚才链表是空的
        if (l == null)
			//新结点同时也是第一个结点
            first = newNode;
        else
			//如果刚才不是空的，原来的最后一个结点的next指向新结点
            l.next = newNode;
        size++;//元素个数增加
        modCount++;
    }
 *
 * （3）删除
E unlink(Node<E> x) {
		//x是要被删除的结点
        final E element = x.item;//被删除的结点的数据
        final Node<E> next = x.next;//被删除结点的下一个结点
        final Node<E> prev = x.prev;//被删除结点的上一个结点

        if (prev == null) {//说明被删除结点是第一个结点
            first = next;//被删除结点的下一个结点称为了第一个结点
        } else {//被删除结点不是第一个结点
            prev.next = next;//被删除结点的上一个结点的next指向被删除结点的下一个结点
            x.prev = null;//把被删除结点与上一个结点断开
        }

        if (next == null) {//被删除结点是最后一个结点
            last = prev;//被删除结点的上一个结点成为了最后一个结点
        } else {//被删除结点不是最后一个结点
            next.prev = prev;//被删除结点的下一个结点的prev指向被删除结点的上一个结点
            x.next = null;//把被删除结点与下一个结点断开
        }

        x.item = null;//把被删除结点的数据清空
		/*
		x.prev = null;
		x.next = null;
		x.next = null;
		x彻底称为垃圾
		*  /
        size--;//元素个数减少
        modCount++;
        return element;
    }
 */
public class TestLinkedList {
	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		
		list.add("xx");
		list.remove("xx");
	}
}

```





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

# 6、List与Set类面试题

### 问：数组(Array)和列表(ArrayList)的差别是什么?

**参考答案：**

Array可以容纳基本类型和对象，而ArrayList只能容纳对象；

Array 是静态的，一旦创建就无法更改它的大小，ArrayList 是Java集合框架类的一员,可以称它为一个动态数组。

Array可以容纳基本类型和对象，而ArrayList只能容纳对象。

Array是静态的，一旦创建就无法更改它的大小，ArrayList是Java集合框架类的一员，可以称它为一个动态数组。

动态数组可以扩容的

### 问：ArrayList和Vector有何异同点？

回答先相同点再不同点。

**参考答案：**

- 相同点：

（1）两者都是基于索引的，内部由一个数组支持。

（2）两者维护插入的顺序，我们可以根据插入顺序来获取元素。

（3）ArrayList和Vector的迭代器实现都是fail-fast的。

（4）ArrayList和Vector两者允许null值，也可以使用索引值对元素进行随机访问。

- 不同点：

（1）Vector是同步的，而ArrayList不是。然而，如果你寻求在迭代的时候对列表进行改变，你应该使用CopyOnWriteArrayList。

（2）ArrayList比Vector快，它因为有同步，不会过载。

（3）ArrayList更加通用，因为我们可以使用Collections工具类轻易地获取同步列表和只读列表。

### 问：EnumSet是什么？

**参考答案：**

java.util.EnumSet是使用枚举类型的集合实现。当集合创建时，枚举集合中的所有元素必须来自单个指定的枚举类型，可以是显示的或隐示的。EnumSet是不同步的，不允许值为null的元素。

### 问：Java集合类中的Iterator和ListIterator的区别？

**参考答案：**

1. iterator()方法在set和list接口中都有定义，但是ListIterator()仅存在于list接口中（或实现类中）；
2. ListIterator有add()方法，可以向List中添加对象，而Iterator不能；
3. ListIterator和Iterator都有hasNext()和next()方法，可以实现顺序向后遍历，但是ListIterator有hasPrevious()和previous()方法，可以实现逆向（顺序向前）遍历。Iterator就不可以；
4. ListIterator可以定位当前的索引位置，nextIndex()和previousIndex()可以实现。Iterator没有此功能；
5. 都可实现删除对象，但是ListIterator可以实现对象的修改，set()方法可以实现。Iierator仅能遍历，不能修改；



## 一、List 知识结构及面试题目分析

JDK 中 List 和 Set 的重要类图如下，考察的题目也大多围绕着图中的类进行：

![图片描述](C:/Users/x1c/Pictures/数据结构与算法/4.png)

 List/Set 同 Map 一样是很常用的集合类，面试考察的重点在细节和深度，以及与工程实践的结合。



## 二、典型面试例题及思路分析

**问题 1：“ArrayList 和 LinkedList 的的相同点和不同点分别是什么？”**

**参考答案：**

- 相同点：ArrayList 和 LinkedList 都是 List 接口的实现类，因此都具有 List 的特点，即存取有序，可重复；而且都不是线程安全的。
- 不同点：ArrayList 基于数组实现，LinkedList 基于双向链表实现。

**点评：**

 这是一个典型的考察集合异同点的面试题。同类面试题还有很多，比如说

- 数组 (Array) 和列表 (ArrayList) 的差别是什么？
- ArrayList 和 Vector 的差别是什么？
- …

 这类题目考察的仍然是基础，同时还有候选人的知识深度。就参考答案而言，不同点部分抓住了二者最大的不同，即内部数据结构的差异，而相同点部分则从三个方面进行了展开：

- 1.“都是 List 接口的实现类”，体现侯选人对 JDK 源码是比较熟悉的；
- 2.“因此都具有 List 的特点，即存取有序，可重复”，是在 1 的基础上对 List 的具体阐述；
- 3.“都不是线程安全的”，体现的是线程安全方面的考虑。

 第 2 点和第 3 点单独拎出来进行说明，是因为其对应的正是另两类关于 List 的高频题，详情分别参见本章节的问题 2 和问题 3，先不展开。这里基于不同点还可以继续追问：

- “既然 ArrayList 和 LinkedList 的内部数据结构不一样，那分别适用于什么场景呢？”

 不同的内部数据结构适应于不同的应用场景，这点无庸置疑。

 ArrayList 基于数组存储数据，因此查询元素时可以直接按照数据下标进行索引，而插入元素时，通常涉及到数据元素的复制和移动，所以查询数据快而插入数据慢；

 LinkedList 基于双向链表存储数据，因此查询元素时需要前向或后向遍历，而插入数据时只需要修改本元素的前后项即可，所以查询数据慢而插入数据快。

 所以，ArrayList 适合查询多（读多）的场景，LinkedList 适合插入多（写多）的场景。

**问题 2："List、Set、Map 之间的区别是什么？"**

**参考答案：**

- List 是有序集合，可以有重复元素；
- Set 集合不能包括重复元素，实现类中 LinkedHashSet 按照插入顺序排序，SortedSet 可排序，HashSet 无序；
- Map 存放键值对 (key-value pairs) 映射，映射关系可以是一对一或多对一，key 无序且唯一，value 可重复。实现类中 LinkedHashMap 按照插入顺序排序，SortedMap 可排序，HashMap 无序。

**点评：**

 本题属于自由发挥题，主要考察候选人两方面的能力：一是要真正熟悉对应的知识点，二是要有较强的总结和表述能力。如果自己心里明白但表述不清楚，于面试官而言也等同于你不明白。比如说基于参考答案之外，候选人也可以针对这些集合的异同添加自己的理解。

 回到题目本身，首先，List 与 Set 具有相似性，都继承共同的 Collection 接口，也都是单列元素的集合。List 的内部是数组，所以不断在数组后面追加元素即可，这是它为什么有序的原因；而 Set 里面不允许有重复的元素，这里的重复是指两个相等 (注意不是相同) 的对象 ，即 equals () 返回 true。如果 Set 集合 s 中有 A 元素，现在再向 s 集合插入 B 元素，此时 B 元素如果与 A 元素相等，则 B 元素存储不进去（add 方法返回 false）。

 其次，Map 与 List 和 Set 不同，它是双列的集合，值得注意的是并不继承 Collection。

**问题 3："ArrayList 和 LinkedList 都不是线程安全的，那有线程安全的 List 类吗？"**

**参考答案**：

 线程安全 List 类有 Vector 和 CopyOnWriteList。

- Vector 是通过在其几乎所有方法前加 synchronized 关键字来保证线程安全性；
- CopyOnWriteList 则是通过数组复制的方法来保证线程安全的。

**点评：**

 Vector 和 Collections.synchronizedList (new ArrayList ()) 类似，都是通过 synchronized 来保证集合的安全性。只不过 Vector 的 synchronized 关键字加在方法外面（图 1），Collections.synchronizedList (new ArrayList ()) 的 synchronized 关键字加在方法里面（图 2）。

![图片描述](C:/Users/x1c/Pictures/数据结构与算法/5.png)
​ *图 1 Vector 中的方法*

![图片描述](C:/Users/x1c/Pictures/数据结构与算法/6.png)
​ *图 2 Collections.synchronizedList 中的方法*

 CopyOnWriteList 是通过缩小锁有范围和数组复制来实现线程安全，看读（add 方法）、写（get 方法）部分的源码：

```java
/**
* 添加元素
**/
public boolean add(E e) {
  // 1、加锁
 final ReentrantLock lock = this.lock;
 lock.lock();
 try {
     // 2、获取原数组及长度
     Object[] elements = getArray();
     int len = elements.length;
     // 3、复制到新数组
     Object[] newElements = Arrays.copyOf(elements, len + 1);
     // 4、添加元素到新数组
     newElements[len] = e;
     setArray(newElements);
     return true;
 } finally {
     // 5、释放锁
     lock.unlock();
 }
}

/**
* 读取元素
**/
public E get(int index) {
 return get(getArray(), index);
}

final Object[] getArray() {
//CopyOnWriteList的成员属性，通过private transient volatile来修饰
return array;
}
```

 可以看到写的时候加锁了而读的时候没有加锁。这是因为 CopyOnWriteList 在读的时候读的原数组，而原数组通过 volatile 修饰保证了可见性。这在迭代器上表现得更加明显。

```java
/**重写List的迭代器实现*/
public Iterator<E> iterator() {
 return new COWIterator<E>(getArray(), 0);
}
... ...

private COWIterator(Object[] elements, int initialCursor) {
 //COWIterator的构造方法，cursor和snapshot是迭代器的成员属性
 cursor = initialCursor;
 snapshot = elements;
}

/**
* 迭代器中hasNext()和next()方法都是基于snapshot数组，而snapshot是传递进来的array原数组
*/
public boolean hasNext() {
return cursor < snapshot.length;
}

@SuppressWarnings("unchecked")
public E next() {
if (! hasNext())
 throw new NoSuchElementException();
return (E) snapshot[cursor++];
}
```



## 三、总结

 总体而言，List/Set 类的面试题的特点和 Map 类有点类似（深度上可能不及 Map 类），都是属于基础知识的部分，这类试题的答题要点在于：

- 基础知识的回答要表达清晰，知识准确。
- 厚积薄发，平常多问问为什么，注意学习源码。
- 面试技巧：回答时可以结合着源码、或者自己的工程实践展开，向面试官传递出自己热爱技术、勤于思考的形象。



## 四、扩展阅读及思考题



### 4.1 扩展阅读

- [阿里巴巴 Java 开发手册](https://developer.aliyun.com/special/tech-java)
- [扩展面试题目_List 与 Set 类面试题](https://github.com/jiehao2019/imooc_java_interview_questions/blob/master/Java基础技术/List与Set类面试题.md)



### 4.2 思考题

- 既然 HashSet 是无序的，那么遍历 HashSet 时又是按照什么顺序输出的？

# 7、参考资料

记录 - [搞定Java核心技术](https://www.bilibili.com/video/BV1R5411t7Ze)
[高薪之路--Java面试题精选集](https://www.imooc.com/read/67)
从Hello到goodbye