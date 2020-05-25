package com.atguigu.test03;

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
