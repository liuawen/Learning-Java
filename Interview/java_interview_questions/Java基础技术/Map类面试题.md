# **Map类面试题**

- ### 问：说说List,Set,Map三者的区别？

  **参考答案：**

  List(对付顺序的好帮手)：List接口存储一组不唯一（可以有多个元素引用相同的对象），有序的对象；</br>
  Set(注重独一无二的性质):不允许重复的集合。不会有多个元素引用相同的对象；</br>
  Map(用Key来搜索的专家):使用键值对存储。Map会维护与Key有关联的值。两个Key可以引用相同的对象，但Key不能重复，典型的Key是String类型，但也可以是任何对象。

  

  

  ### 问：poll()方法和remove()方法区别?

  **参考答案：**

  poll() 和 remove() 都是从队列中取出一个元素，但是 poll() 在获取元素失败的时候会返回空，但是 remove() 失败的时候会抛出异常。

  

  ### 问：为何Map接口不继承Collection接口？

  **参考答案：**

  尽管Map接口和它的实现也是集合框架的一部分，但Map不是集合，集合也不是Map。因此，Map继承Collection毫无意义，反之亦然。

  如果Map继承Collection接口，那么元素去哪儿？Map包含key-value对，它提供抽取key或value列表集合的方法，但是它不适合“一组对象”规范。

  

  ### 问：我们能否使用任何类作为Map的key？

  **参考答案：**

  我们可以使用任何类作为Map的key，然而在使用它们之前，需要考虑以下几点：

  （1）如果类重写了equals()方法，它也应该重写hashCode()方法。

  （2）类的所有实例需要遵循与equals()和hashCode()相关的规则。请参考之前提到的这些规则。

  （3）如果一个类没有使用equals()，你不应该在hashCode()中使用它。

  （4）用户自定义key类的最佳实践是使之为不可变的，这样，hashCode()值可以被缓存起来，拥有更好的性能。不可变的类也可以确保hashCode()和equals()在未来不会改变，这样就会解决与可变相关的问题了。

  比如，我有一个类MyKey，在HashMap中使用它。

  //传递给MyKey的name参数被用于equals()和hashCode()中 MyKey key = new MyKey('Pankaj'); //assume hashCode=1234 myHashMap.put(key, 'Value'); // 以下的代码会改变key的hashCode()和equals()值 key.setName('Amit'); //assume new hashCode=7890 //下面会返回null，因为HashMap会尝试查找存储同样索引的key，而key已被改变了，匹配失败，返回null myHashMap.get(new MyKey('Pankaj')); 那就是为何String和Integer被作为HashMap的key大量使用。

  

  ### 问：Map接口提供了哪些不同的集合视图？

  **参考答案：**

  Map接口提供三个集合视图：

  （1）Set keyset()：返回map中包含的所有key的一个Set视图。集合是受map支持的，map的变化会在集合中反映出来，反之亦然。当一个迭代器正在遍历一个集合时，若map被修改了（除迭代器自身的移除操作以外），迭代器的结果会变为未定义。集合支持通过Iterator的Remove、Set.remove、removeAll、retainAll和clear操作进行元素移除，从map中移除对应的映射。它不支持add和addAll操作。

  （2）Collection values()：返回一个map中包含的所有value的一个Collection视图。这个collection受map支持的，map的变化会在collection中反映出来，反之亦然。当一个迭代器正在遍历一个collection时，若map被修改了（除迭代器自身的移除操作以外），迭代器的结果会变为未定义。集合支持通过Iterator的Remove、Set.remove、removeAll、retainAll和clear操作进行元素移除，从map中移除对应的映射。它不支持add和addAll操作。

  （3）Set<Map.Entry<K,V>> entrySet()：返回一个map钟包含的所有映射的一个集合视图。这个集合受map支持的，map的变化会在collection中反映出来，反之亦然。当一个迭代器正在遍历一个集合时，若map被修改了（除迭代器自身的移除操作，以及对迭代器返回的entry进行setValue外），迭代器的结果会变为未定义。集合支持通过Iterator的Remove、Set.remove、removeAll、retainAll和clear操作进行元素移除，从map中移除对应的映射。它不支持add和addAll操作。

  

  ### 问：如何决定选用HashMap还是TreeMap？

  **参考答案：**

  对于在Map中插入、删除和定位元素这类操作，HashMap是最好的选择。然而，假如你需要对一个有序的key集合进行遍历，TreeMap是更好的选择。基于你的collection的大小，也许向HashMap中添加元素会更快，将map换为TreeMap进行有序key的遍历。

  

  ### 问：TreeMap和TreeSet在排序时如何比较元素？Collections工具类中的sort()方法如何比较元素？

  **参考答案：**

  TreeSet要求存放的对象所属的类必须实现Comparable接口，该接口提供了比较元素的compareTo()方法，当插入元素时会回调该方法比较元素的大小。TreeMap要求存放的键值对映射的键必须实现Comparable接口从而根据键对元素进行排序。Collections工具类的sort方法有两种重载的形式，第一种要求传入的待排序容器中存放的对象比较实现Comparable接口以实现元素的比较；第二种不强制性的要求容器中的元素必须可比较，但是要求传入第二个参数，参数是Comparator接口的子类型（需要重写compare方法实现元素的比较），相当于一个临时定义的排序规则，其实就是通过接口注入比较元素大小的算法，也是对回调模式的应用（Java中对函数式编程的支持）。

  

  ### 问：HashMap ,LinkedHashMap ,TreeMap,WeakHashMap,ConcurrentHashMap,IdentityHashMap的区别

  **参考答案：**

  - **HashMap**基于散列表来的实现，即使用hashCode()进行快速查询元素的位置，显著提高性能。插入和查询“键值对”的开销是固定的。可以通过设置容量和负载因子，以调整容器的性能。
  - **LinkedHashMap**, 类似于HashMap,但是迭代遍历它时，取得“键值对”的顺序是其**插入的次序**，只比HashMap慢一点。而在迭代访问时反而更快，**因为它使用链表维护内部次序**。
  - **TreeMap**, 是基于**红黑树**的实现。实现了SortedMap，SortedMap 可以确保键处于排序状态。所以查看“键”和“键值对”时，所有得到的结果都是经过排序的，次序由Comparable或Comparator决定。SortedMap拥有其他额外的功能，如：Comparator comparator()返回当前Map使用的Comparator或者null. T firstKey() 返回Map的第一个键，T lastKey() 返回最后一个键。SortedMap headMap(toKey),生成一个键小于toKey的Map子集。SortedMap tailMap(fromKey) 也是生成一个子集。TreeMap是唯一的带有subMap()方法的Map,它可以返回一个子树
  - **WeakHashMap**表示**弱键映射**，允许释放映射所指向的对象。这是为了解决某类特殊问题而设计的，如果映射之外没有引用指向某个“键”，则“键”可以被垃圾收集器回收。
  - **ConcurrentHashMap**一种线程安全的Map,它不涉及同步加锁。
  - **IdentityHashMap**使用==代替equals() 对“键”进行比较的散列映射。专为解决特殊问题而设计。

  

  ### 问：HashMap 和 HashSet区别是什么？

  **参考答案：**

  如果你看过 HashSet 源码的话就应该知道：HashSet 底层就是基于 HashMap 实现的。（HashSet 的源码非常非常少，因为除了`clone()`、`writeObject()`、`readObject()`是 HashSet 自己不得不实现之外，其他方法都是直接调用 HashMap 中的方法。

  | HashMap                          | HashSet                                                      |
  | -------------------------------- | ------------------------------------------------------------ |
  | 实现了Map接口                    | 实现Set接口                                                  |
  | 存储键值对                       | 仅存储对象                                                   |
  | 调用 `put（）`向map中添加元素    | 调用 `add（）`方法向Set中添加元素                            |
  | HashMap使用键（Key）计算Hashcode | HashSet使用成员对象来计算hashcode值，对于两个对象来说hashcode可能相同，所以equals()方法用来判断对象的相等性， |

  ###  

  ### 问：HashSet如何检查重复

  **参考答案：**

  当你把对象加入HashSet时，HashSet会先计算对象的hashcode值来判断对象加入的位置，同时也会与其他加入的对象的hashcode值作比较，如果没有相符的hashcode，HashSet会假设对象没有重复出现。但是如果发现有相同hashcode值的对象，这时会调用equals（）方法来检查hashcode相等的对象是否真的相同。如果两者相同，HashSet就不会让加入操作成功。

  

  ### 问：WeakHashMap与HashMap的区别是什么?

  **参考答案：**

  WeakHashMap 的工作与正常的 HashMap 类似，但是使用弱引用作为 key，意思就是当 key 对象没有任何引用时，key/value 将会被回收。
