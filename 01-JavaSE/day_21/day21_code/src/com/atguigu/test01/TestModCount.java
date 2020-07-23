package com.atguigu.test01;

/*
 * modCount：记录当前集合被修改的次数
 * （1）添加
 * （2）删除
 * 这两个操作都会影响元素的个数。
 * 
 * 当我们使用迭代器或foreach遍历时，如果你在foreach遍历时，自动调用迭代器的迭代方法，
 * 此时在遍历过程中调用了集合的add,remove方法时，modCount就会改变，
 * 而迭代器记录的modCount是开始迭代之前的，如果两个不一致，就会报异常，
 * 说明有两个线路（线程）同时操作集合。这种操作有风险，为了保证结果的正确性，
 * 避免这样的情况发生，一旦发现modCount与expectedModCount不一致，立即保错。
 * 
 * 此类的 iterator 和 listIterator 方法返回的迭代器是快速失败的：
 * 在创建迭代器之后，除非通过迭代器自身的 remove 或 add 方法从结构上对列表进行修改，
 * 否则在任何时间以任何方式对列表进行修改，
 * 迭代器都会抛出 ConcurrentModificationException。
 * 因此，面对并发的修改，迭代器很快就会完全失败，
 * 而不是冒着在将来某个不确定时间发生任意不确定行为的风险。
 */
public class TestModCount {

}
