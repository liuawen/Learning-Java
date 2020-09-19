package nowCoderClass1.section1;

/**
 对于一个字符串，请设计一个算法，只在字符串的单词间做逆序调整，也就是说，字符串由一些由空格分隔的部分组成，你需要将这些部分逆序。

 给定一个原字符串A和他的长度，请返回逆序后的字符串。
 测试样例：

 "dog loves pig",13
 返回："pig loves dog"
 * Created by Dell on 2017-05-07.
 */
public class Reverse {
    public String reverseSentence(String A, int n) {
        // write code here
        char[] a=A.toCharArray();
        //整体逆序
        reverse(a,0,n-1);
        //局部逆序
        int begin=0;
        for(int i=0;i<n;i++){
            if(a[i]==' '){
                reverse(a,begin,i-1);
                begin=i+1;
            }
        }
        reverse(a,begin,n-1);
        return String.valueOf(a);
    }
    /**
     * 先写一个方法，给定开始和结束，实现逆序
     */
    private void reverse(char[] A,int begin,int end){
//        1,3
        while(begin<end){
            swap(A,begin++,end--);
        }
        System.out.println(String.valueOf(A));
    }






    private void swap(char[] A, int i, int j) {
        char temp=A[j];
        A[j]=A[i];
        A[i]=temp;
    }




}
