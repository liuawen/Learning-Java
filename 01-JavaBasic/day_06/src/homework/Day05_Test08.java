package homework;

/**
 * @author Liu Awen
 * @create 2018-05-11 19:52
 */
/*
根据标准答案【ADBCD】，每题2分共10分，求出每名学生最终得分。

* 四名同学答案分别为：
  * 小尚：【DCBAD】
  * 小硅：【ADBCD】
  * 小谷：【ADBCA】
  * 小好：【ABCDD】
* 每答对一题，得2分，输出四名同学的最终得分。
*/
class Day05_Test08{
    public static void main(String[] args){
        //标准答案：
        char[] answer = {'A','D','B','C','D'};

        //学生的答案
        char[] shang = {'D','C','B','A','D'};
        char[] gui = {'A','D','B','C','D'};
        char[] gu = {'A','D','B','C','A'};
        char[] hao = {'A','B','C','D','D'};

        //求出每名学生最终得分。
        int shangFen = 0;
        for(int i=0; i<shang.length; i++){
            if(shang[i] == answer[i]){
                shangFen +=2;
            }
        }
        System.out.println("小尚的分数：" + shangFen);

        //...
    }
}