练习一：List接口的特点
一、请简述List接口的特点。
	它是一个元素存取有序的集合。例如，存元素的顺序是11、22、33。那么集合中，元素的存储就是按照11、22、33的顺序完成的）。
	它是一个带有索引的集合，通过索引就可以精确的操作集合中的元素（与数组的索引是一个道理）。
	集合中可以有重复的元素，通过元素的equals方法，来比较是否为重复的元素。


练习二：LinkedList方法的使用
二、根据要求练习LinkedList方法：
（1）基本方法：add, set, get, remove, clear, size等方法；
（2）特有方法：addFirst, addLast, getFirst, getLast, removeFirst, removeLast, push, pop, clear等方法。
（1）基本方法：
public class LinkedListTest01 {
    public static void main(String[] args) {
        // 1.创建LinkedList
        LinkedList<String> arr = new LinkedList<String>();

        // 2.使用add方法添加元素
        arr.add("西门吹雪");
        arr.add("西门吹雪");
        arr.add("西门吹雪");
        arr.add("西门吹风");
        arr.add("西门吹水");

        // 3.使用add方法在指定索引添加元素
        arr.add(2, "西门吹雨");

        // 4.使用set方法修改指定位置索引
        arr.set(0, "东门");

        for (String str : arr) {
            System.out.println(str);
        }
        System.out.println("--------------");
        // 5.使用get方法获取指定索引的元素
        System.out.println(arr.get(1));

        // 6.使用size方法获取集合大小
        System.out.println(arr.size());

        // 7.使用remove方法删除指定索引的元素
        arr.remove(3);

        // 8.使用clear清空集合中的元素
        arr.clear();
        System.out.println(arr);
    }
}
（2）特有方法
public class LinkedListTest02 {
    public static void main(String[] args) {
        // 1.创建LinkedList
        LinkedList<String> linked = new LinkedList<String>();

        // 2.使用add方法添加元素
        linked.add("周杰伦");
        linked.add("周星驰");
        linked.add("周华健");
        linked.add("周润发");

        // 3.使用addFirst添加元素到集合最前面
        linked.addFirst("周传雄");

        // 4.使用addLast添加元素到集合最后面
        linked.addLast("周渝民");

        System.out.println(linked);

        // 5.使用getFirst获取集合第一个元素
        System.out.println(linked.getFirst());

        // 6.使用getLast获取集合最后一个元素
        System.out.println(linked.getLast());

        // 7.使用removeLast删除集合第一个元素
        String first = linked.removeFirst();
        System.out.println(first);

        // 8.使用removeLast删除集合最后一个元素
        String last = linked.removeLast();
        System.out.println(last);
        System.out.println(linked);


        // 9.使用pop弹出第一个元素
        String p = linked.pop();
        System.out.println(p);

        // 10.使用push在集合开头插入元素
        linked.push("周立波");
        System.out.println(linked);

        // 11.使用clear清空集合
        linked.clear();
        System.out.println(linked);
    }
}
练习三：List集合元素替换
三、向list集合添加姓名{张三,李四,王五,二丫,钱六,孙七},将二丫替换为王小丫。
public class ListTest01 {
    public static void main(String[] args) {
        //1.创建List集合对象
        List<String> list = new ArrayList<>();
        //2.存入数据
        list.add("张三");
        list.add("李四");
        list.add("王五");
        list.add("二丫");
        list.add("钱六");
        list.add("孙七");
        //3.遍历集合，找到"二丫",便将其替换为"王小丫"
        //利用普通for循环遍历List集合
        for(int i = 0;i<list.size();i++) {
            //获取当前元素
            String thisName = list.get(i);
            //如果当前元素是"二丫"
            if("二丫".equals(thisName)) {
                //将其改为"王小丫"
                list.set(i, "王小丫");
            }
        }
        System.out.println(list);
    }
}


四、给定以下代码，请定义方法listTest()统计集合中指定元素出现的次数，如"a": 2,"b": 2,"c" :1, "xxx":0。
		Collection<String> list = new ArrayList<>();
			list.add("a");
			list.add("a");
			list.add("b");
			list.add("b");
			list.add("c");
			System.out.println("a:"+listTest(list, "a"));	
			System.out.println("b:"+listTest(list, "b"));	
			System.out.println("c:"+listTest(list, "c"));
			System.out.println("xxx:"+listTest(list, "xxx"));		
public class CollectionTest01{
    public static void main(String[] args) {
        Collection<String> list = new ArrayList<>();
        list.add("a");
        list.add("a");
        list.add("b");
        list.add("b");
        list.add("c");
        System.out.println("a:"+listTest(list, "a"));
        System.out.println("b:"+listTest(list, "b"));
        System.out.println("c:"+listTest(list, "c"));
        System.out.println("xxx:"+listTest(list, "xxx"));
    }

    //定义方法统计集合中指定元素出现的次数
    public static int listTest(Collection<String> list,String s){
        //定义计数器，初始化为0
        int count = 0;
        //增强for遍历集合
        for (String string : list) {
            //判断传入方法的字符与遍历集合的是否一致
            if (s.equals(string)) {
                //如果一致，加1
                count++;
            }
        }
        return count;
    }
}
练习五：Collection集合数组转集合
五、定义一个方法，要求此方法把int数组转成存有相同元素的集合(集合里面的元素是Integer)，并返回。()
public class CollectionTest02 {
    public static void main(String[] args) {
        //定义int数组
        int[] arr = {1,2,3,4,5};
        ArrayList<Integer> list = listTest(arr);
        System.out.println(list);
    }

    public static ArrayList<Integer> listTest(int[] arr) {
        //定义集合
        ArrayList<Integer> list = new ArrayList<Integer>();
        //遍历数组，把元素依次添加到集合当中
        for (int a : arr) {
            list.add(a);
        }
        return list;
    }
}