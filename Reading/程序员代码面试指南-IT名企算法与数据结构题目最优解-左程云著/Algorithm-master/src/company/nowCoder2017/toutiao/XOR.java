package company.nowCoder2017.toutiao;

import java.util.Scanner;

/**
 * 给定整数m以及n各数字A1,A2,..An，将数列A中所有元素两两异或，共能得到n(n-1)/2个结果，
 * 请求出这些结果中大于m的有多少个。
 * Created by Dell on 2017-09-10.
 */
public class XOR {
    //建立的是二进制0-10^5的字典表，最多16位
    public static class TrieTree{
        TrieTree[] next=new TrieTree[2];
        int count=1;//统计当前节点有多少个
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int n=sc.nextInt();
            int m=sc.nextInt();
            int[] a=new int[n];
            for (int i=0;i<n;i++){
                a[i]=sc.nextInt();
            }
            System.out.println(solve(a,m));
        }
    }
    public static long solve(int[] a,int m){
        TrieTree tree=buildTrieTree(a);
        long result=0;
        for(int i=0;i<a.length;i++){
            result+=queryTrieTree(tree,a[i],m,15);
        }
        return result/2;
    }

    /**
     *
     * @param trieTree
     * @param a 当前的数
     * @param m 异或之后大于m的
     * @param index 每个位置
     * @return
     */
    private static long queryTrieTree(TrieTree trieTree,int a,int m,int index){
        if(trieTree==null)
            return 0;
        TrieTree current=trieTree;
        for(int i=index;i>=0;i--){
            int aDigit=(a>>i)&1;//取出a的当前位
            int mDigit=(m>>i)&1;//取出m的当前位
            if(aDigit==1&&mDigit==1){
                if(current.next[0]==null)
                    return 0;
                current=current.next[0];
            }else if(aDigit==0&&mDigit==1){
                if(current.next[1]==null)
                    return 0;
                current=current.next[1];
            }else if(aDigit==1&&mDigit==0){
                long p=queryTrieTree(current.next[1],a,m,i-1);//p是大于m的，递归计算下一层的
                long q=current.next[0]==null?0:current.next[1].count;//q
                    return p+q;
            }else if(aDigit==0&&mDigit==0){
                long p=queryTrieTree(current.next[0],a,m,i-1);
                long q=current.next[1]==null?0:current.next[1].count;
                return p+q;
            }
        }
        return 0;
    }
    public static TrieTree buildTrieTree(int[] a){
        TrieTree trieTree=new TrieTree();
        for(int i=0;i<a.length;i++){
            TrieTree current=new TrieTree();
            for(int j=15;j>=0;j--){
                int digit=(a[i]>>j)&1;
                if(current.next[digit]==null){
                    current.next[digit]=new TrieTree();
                }else{
                    current.next[digit].count++;
                }
                current=current.next[digit];
            }
        }
        return trieTree;
    }
}
