package company.nowcode.spring1;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 如果一个单词通过循环右移获得的单词，我们称这些单词都为一种循环单词。
 * 例如：picture 和 turepic 就是属于同一种循环单词。 现在给出n个单词，需要统计这个n个单词中有多少种循环单词。
 * Created by Dell on 2017-09-23.
 */
public class rotateWord
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();sc.nextLine();
        String[] words = new String[num];
        ArrayList<String> list=new ArrayList<String>();
        for (int i = 0; i < num; i++) {
            words[i] = sc.nextLine();
            boolean flag=false;
            for(int j=0;j<list.size();j++){
                if(list.get(j).length()==words[i].length()&&(list.get(j)+list.get(j)).contains(words[i])){
                    flag=true;
                    break;
                }
            }
            if(!flag) {
                list.add(words[i]);
            }
        }
        System.out.println(list.size());
    }
}
