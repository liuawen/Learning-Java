# List与Set类面试题

### 问：数组(Array)和列表(ArrayList)的差别是什么?

**参考答案：**

Array可以容纳基本类型和对象，而ArrayList只能容纳对象；

Array 是静态的，一旦创建就无法更改它的大小，ArrayList 是Java集合框架类的一员,可以称它为一个动态数组。

###  

### 问：ArrayList和Vector有何异同点？

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


