package com.atguigu.test07;

/*
 * Set的底层实现是什么？
 * 1、HashSet  ： HashMap
 * 2、TreeSet  : TreeMap
 * 3、LinkedHashSet： LinkedHashMap
 * 
 * Set添加元素时用add(元素)，而Map添加元素put(key,value)。
 * 发现添加到Set中的元素，是作为底层的Map的key，那么value它们选用了一个Object类型的常量对象PRESENT。
 * 所有的HashSet共用同一个PRESENT对象。
 * 所有的TreeSet共用同一个PRESENT对象。
 * 所有的LinkedHashSet共用同一个PRESENT对象。
 * 
 */
public class TestSetSource {

}
