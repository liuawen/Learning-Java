package homework;


/**
 * @author Liu Awen Email:willowawen@gmail.com
 * @create 2020-05-18
 * 根据中国现行法律，合法的结婚条件为:
 * <p>
 * - 男女双方均为未婚
 * - 男方必须年满**22**周岁，女方必须年满**20**周岁
 * - 结婚的双方必须是男女异性 ( 现行中国法律不支持同性结婚 )
 * <p>
 * - 如果可以结婚，则提示 自己 可以 和 某某 结婚
 * - 如果不满足结婚条件，则提示不能结婚的原因
 */
public class Person {
    private String name;
    private char gender;
    private int age;
    private boolean married;

    public void marry(Person another) {
        // 在这里填空，判断自己 ( this ) 跟 另外一个人( another )结婚

        //男女双方均为未婚才能结婚
        if (this.married == true || another.married == true) {
            System.out.println("已婚的不能再结婚哦");
        }
        //男方必须年满**22**周岁，女方必须年满**20**周岁
        if ((this.gender == '男' && this.age < 22) || (another.gender == '男' && another.age < 22)) {
            System.out.println("男的年龄不能小于22岁");
            return;
        }
        if ((this.gender == '女' && this.age < 20) || (another.gender == '女' && another.age < 20)) {
            System.out.println("女的年龄不能小于20岁");
            return;
        }
        //结婚的双方必须是男女异性
        if (this.gender == another.gender) {
            System.out.println("同性不能结婚");
            return;
        }
        //可以结婚，提示自己可以和某某结婚
        System.out.println(this.name + "可以和" + another.name + "结婚了");
    }

    public static void main(String[] args) {
        Person my = new Person();
        my.name = "菜草";
        my.gender = '男';
        my.age = 22;
        my.married = false;

        Person another = new Person();
        another.name = "菜花";
        another.gender = '女';
        another.age = 20;
        another.married = false;

        my.marry(another);
    }
}
