package cn.liuawen.homework;

import java.util.*;

/**
 * @author : Liu Awen Email:willowawen@gmail.com
 * @create : 2020-06-06
 * 作业:
 * 自己实现个 java.lang.Collection 接口的方法
 * （iterator、toArray(T[] a) 不去实现）
 */
public class Container implements Collection<Object> {
    //默认初始容量的常量
    private static final int DEFAULT_INITIAL_CAPACITY = 1 << 4;

    //表示容器最大容量
    private static final int MAXIMUM_CAPACITY = 1 << 30;

    //默认加载因子的常量
    private static final float DEFAULT_LOAD_FACTOR = 0.75f;

    // 表示容器内数组中某个位置尚未被使用的标志
    private static final Object UNUSED = new Object();

    //用来引用数组类型的引用变量
    private Object[] elements;

    //统计容器中的元素个数
    private int counter;
    // counter-1+1 counter 既表示当前容器中的元素个数也表示下次添加元素时的位置

    //用来表示扩容比例的变量加载因子
    private final float loadFactor;

    public Container(int initialCapacity, float loadFactor) {
        // 注意这里的 initialCapacity 的取值范围是 [ 0 , MAXIMUM_CAPACITY]
        if (initialCapacity < 0 || initialCapacity > MAXIMUM_CAPACITY) {
            // 创建异常实例 抛出异常实例
            throw new RuntimeException("初始容量必须是 [ 0 , " + MAXIMUM_CAPACITY + " ] 之间的正整数值");
        }

        //加载因子是 ( 0 , 1 ) 之间浮点数
        if (loadFactor <= 0 || loadFactor >= 1) {
            // 创建异常实例 ( 创建 RuntimeException 实例 )
            RuntimeException ex = new RuntimeException("加载因子必须是 ( 0 , 1 ) 之间的浮点数");
            throw ex; // 抛出异常实例，导致当前方法立即结束
        }

        // 使用默认初始容量创建数组实例
        this.elements = new Object[initialCapacity];
        // 保存用户指定的 加载因子
        this.loadFactor = loadFactor;
        // 将整个数组中的所有位置都标记为UNUSED 未使用的
        this.mark();
    }

    public Container() {
        //默认的
        this(DEFAULT_INITIAL_CAPACITY, DEFAULT_LOAD_FACTOR);
    }

    //将数组中的所有位置都标记为 UNUSED
    private void mark() {
        Arrays.fill(elements, UNUSED);
    }

    //确保数组容量足以容纳下一个元素
    private void ensureCapacity() {
        // 当达到某个条件时，就对容器进行扩容
        if (counter > elements.length * loadFactor) {
            // 将 原来的数组 的地址 暂存到 temp 变量中
            final Object[] temp = this.elements;
            // 扩容方式就是在原来基础上增长约 1.5 倍
            int newLength = temp.length * 3 / 2 + 1;
            // 创建新数组 ( 创建一个新的、更大的数组 ) 并将新数组地址赋值到 elements 变量
            this.elements = new Object[newLength];
            // 将原数组中的[ 0 , counter ) 之间的元素拷贝到新数组中
            System.arraycopy(temp, 0, elements, counter, newLength);
            // 后续就使用新数组 (放弃老数组) 了 ( 因为 elements 变量中存储了 新数组的地址 )
        }
    }

    //返回实际元素的个数

    @Override
    public int size() {
        return this.counter ;
    }

    //判断当前容器是否为空
    @Override
    public boolean isEmpty() {
        return counter == 0;
    }

    //清空容器
    @Override
    public void clear() {
        this.counter = 0;
        this.mark();
    }

    //添加元素
    @Override
    public boolean add(Object e) {
        // 确保容器内部的数组容量足以容纳新的数组容量
        ensureCapacity();
        // 将 element 添加到 elements 数组的 counter 处
        elements[counter] = e;
        // 对 counter 执行 自增操作 ( 增加 1 )
        counter++;
        // 自增之后的值既表示元素个数又表示下次添加元素时的存放位置
        return true;
    }

    /**
     * 寻找指定元素在容器中的首次出现的位置并返回其索引
     *
     * @param o 被寻找的元素
     * @return 返回被寻找元素在容器中的位置(索引)
     */
    public int indexOf(Object o) {
        for (int i = 0; i < counter; i++) {
            // 从数组中获取下标i处的元素
            Object e = elements[i];
            if (Objects.equals(e, o)) {
                // 当找到指定元素时就返回相应的索引
                return i;
            }
        }
        // 如果未找到相应的元素则返回 -1
        return -1;
    }

    //寻找指定元素在容器中的最后一次出现的位置并返回其索引
    public int lastIndexOf(Object o) {
        for (int i = counter - 1; i >= 0; i--) {
            // 从数组中获取下标i处的元素
            Object e = elements[i];
            if (e == o || (e != null && e.equals(o))) {
                return i;  // 当找到指定元素时就返回相应的索引
            }
        }
        return -1; // 如果未找到相应的元素则返回 -1
    }

    //当被检查对象在容器中存在时就返回 true ，否则返回 false
    @Override
    public boolean contains(Object o) {
        return this.indexOf(o) != -1;
    }

    //返回一个包含了容器内部有效元素组成的数组
    @Override
    public Object[] toArray() {
        // 将 elements 数组中的 [ 0 , counter ) 之间的元素复制到新数组
        return Arrays.copyOf(elements, counter);
    }

    //从容器中删除指定的元素
    @Override
    public boolean remove(Object o) {
        int index = this.indexOf(o);
        if (index != -1) {
            // 统计需要拷贝的元素个数
            int n = counter - 1 - index;
            // 将 elements 的 [ index + 1 , counter ) 之间的元素 拷贝 到 elements 的 [ index , counter - 1 ) 之间
            System.arraycopy(elements, index + 1, elements, index, n);
            // 将 原本的 counter - 1 处的元素 重置为 UNUSED
            elements[counter - 1] = UNUSED;
            // 因为删除了一个元素，所以 counter 需要减去 1
            counter--;
            // 成功删除后返回 true
            return true;
        }
        // 如果未对容器造成任何影响则返回 false
        return false;
    }


    // 为了在 toString 方法中连接字符串而创建的 StringBuilder 实例
    private final StringBuilder builder = new StringBuilder();

    @Override
    public String toString() {
        builder.append("[");
        if (counter > 0) {
            for (int i = 0; i < counter; i++) {
                // 将每个元素的字符串形式追加到 builder 末尾
                builder.append(elements[i]);
                builder.append(i < counter - 1 ? "," : "");
            }
        }
        builder.append("]");
        String s = builder.toString();
        // 将 builder 的 length 设置为 零 是为了下次使用 builder 时，从缓冲区的 第一个位置开始存放字符
        builder.setLength(0); // 功能上类似于容器的 clear 方法
        return s;
    }

    //当被检查对象在容器中存在时就返回 true ，否则返回 false
    //可以有重复的
    @Override
    public boolean containsAll(Collection<?> c) {
        for (int i = 0; i < counter; i++) {
            // 从数组中获取下标i处的元素
            Object e = elements[i];
            //完全相等
            if (Objects.equals(e, c)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean addAll(Collection<?> c) {
        boolean modified = false;
        for (Object e : c)
            if (add(e))
                modified = true;
        return modified;

       /* Object[] a = c.toArray();
        int numNew = a.length;
        counter+=numNew;
        // 确保容器内部的数组容量足以容纳新的数组容量
        ensureCapacity();
        System.arraycopy(a, 0, elements, counter-numNew, numNew);

        return true;*/
    }

    //删除的是交集  集合都有的
    @Override
    public boolean removeAll(Collection<?> c) {
        Object[] objects = c.toArray();
        for (int i = 0; i < objects.length; i++) {
            int index = this.indexOf(objects[i]);
            if (index != -1) {
                remove(elements[index]);
            }
        }
        return false;

    }

    //取交集
    @Override
    public boolean retainAll(Collection<?> c) {
        if (c == null) {
            //集合与空集去交集  空集
            clear();
            return true;
            //throw new NullPointerException();
        }
        Object[] o1 = c.toArray();
        Object[] o2 = new Object[counter];
        int i = 0;
        int j = 0;
        for (; i < counter; i++)
            if (this.contains(o1[i]) == true)
                o2[j++] = o1[i];
        this.elements= o2;
        this.counter = j;
        return true;
    }


    //没实现
    @Override
    public Iterator<Object> iterator() {
        return null;
    }

    //没实现
    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }


}