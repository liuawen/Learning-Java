package cn.liuawen.exception;

/**
 * @author : Liu Awen Email:willowawen@gmail.com
 * @create :  2020-05-29
 */
/*
  2.定义学生类(Student)
 a)属性:name,score
 b)提供空参构造
 c)提供有参构造;
  i.使用setXxx方法给名称和score赋值
 d)提供setter和getter方法
  i.在setScore(int score)方法中
   1.首先判断,如果score为负数,就抛出NoScoreException,异常信息为:分数不能为负数:xxx.
   2.然后在给成员score赋值.
 */
public class Student {
    private String name;
    private int score;

    // 空参构造
    public Student() {
        super();
    }

    // c)提供有参构造;
// i.使用setXxx方法给名称和score赋值
    public Student(String name, int score) {
        setName(name);
        setScore(score);
    }
// d)提供setter和getter方法

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    // i.在setScore(int score)方法中
    public void setScore(int score) {
// 1.首先判断,如果score为负数,就抛出NoScoreException,异常信息为:分数不能为负数:xxx.
        if (score < 0) {
            throw new NoScoreException(":分数不能为负数:" + score);
        }
// 2.然后在给成员score赋值.
        this.score = score;
    }
}



