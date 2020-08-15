练习二：hashCode和equals方法
二、请简述HashSet去除重复元素的原理。
	调用被添加元素的hashCode()，和HashSet中已有元素的hashCode比较是否相同
	如果不相同，直接存储
	如果相同，调用equals方法比较是否相同
	不相同，直接存储元素
	相同，认为是同一元素.不存储


练习三：数据结构
三、简述常见的数据结构中元素的存取特点。
	栈：stack，又称堆栈，对元素的存取特点是：先进后出。即，存进去的元素，要在后它后面的元素依次取出后，才能取出该元素。
	队列：queue，简称队，对元素的存取特点是：先进先出。即，存进去的元素，要在后它前面的元素依次取出后，才能取出该元素。
	数组:Array，是有序的元素序列，对元素的存取特点是：
1、查找元素快：通过索引，可以快速访问指定位置的元素
2、增删元素慢
（1）指定索引位置增加元素：需要创建一个新数组，将指定新元素存储在指定索			引位置，再把原数组元素根据索引，复制到新数组对应索引的位置。
（2）指定索引位置删除元素：需要创建一个新数组，把原数组元素根据索引，复			制到新数组对应索引的位置，原数组中指定索引位置元素不复制到新数组中。
	链表:linked list，对元素的存取有如下的特点：
1、多个结点之间，通过地址进行连接。例如，多个人手拉手，每个人使用自己的		右手拉住下个人的左手，依次类推，这样多个人就连在一起了。
2、查找元素慢：想查找某个元素，需要通过连接的节点，依次向后查找指定元素。
3、增删元素快：
增加元素：只需要修改连接下个元素的地址即可。
删除元素：只需要修改连接下个元素的地址即可。


练习六：HashSet存储自定义类型
六、定义人类，包含姓名和年龄属性。创建4个人存储到HashSet中，姓名和年龄相同的人看做同一人不存储。
Person类:
// 1.定义Person类.包好姓名年龄属性,重写hashCode()和equals()方法
public class Person {
    private String name;
    private int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;

        Person person = (Person) o;

        if (age != person.age) return false;
        return name != null ? name.equals(person.name) : person.name == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + age;
        return result;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
测试类
public class HashSetTest01 {
    public static void main(String[] args) {
        // 2.创建HashSet用于存储Person类型
        HashSet<Person> hashSet = new HashSet<Person>();

        // 3.添加多个Person到HashSet中
        hashSet.add(new Person("王昭君", 21));
        hashSet.add(new Person("西施", 21));
        hashSet.add(new Person("杨玉环", 20));
        hashSet.add(new Person("貂蝉", 19));
        hashSet.add(new Person("杨玉环", 20));
        hashSet.add(new Person("貂蝉", 19));

        // 4.遍历获取HashSet中的内容
        for (Person p : hashSet) {
            System.out.println(p);
        }
    }
}
