package nowCoderClass1.section9;

/**
 * A(A也是他的编号)是一个孤傲的人，在一个n个人(其中编号依次为1到n)的队列中，
 * 他于其中的标号为b和标号c的人都有矛盾，所以他不会和他们站在相邻的位置。
 * 现在问你满足A的要求的对列有多少种？
 */
public class LonelyA {
    public int getWays(int n, int A, int b, int c) {
        // write code here
        int count=0;
        if(n==3)
            return 0;
        //至少4个人
        //先计算A站在开头或结尾的情况
        count+=2*(n-3)*muti(n-2);//2是开头和结尾一样，（n-3）是站在A旁边的人有多少种可能性。muti是剩下的人全排列
        //再计算A站在中间的情况
        if(n>4){
            //思路是A选定一个中间位置，再选两个人站在其旁边，其余的全排列
            count+=(n-2)*(2*muti(n-3)/(muti(n-3-2)*2))*muti(n-3);
        }
        return count;
    }
    /**
     * 需要递归求积
     */
    public int muti(int num){
        if(num==1){
            return 1;
        }
        return num*muti(num-1);
    }
}