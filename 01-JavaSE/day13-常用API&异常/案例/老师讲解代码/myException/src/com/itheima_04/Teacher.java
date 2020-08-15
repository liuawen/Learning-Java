package com.itheima_04;

public class Teacher {

    public void checkScore(int score) throws ScoreException {
        if(score<0 || score>100) {
//            throw new ScoreException();
            throw new ScoreException("你给的分数有误，分数应该在0-100之间");
        } else {
            System.out.println("成绩正常");
        }
    }

}
