package mi;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Stack;

/**
 * Created by Dell on 2017-06-23.
 */
public class Git {
//    /**
//     * 返回git树上两点的最近分割点
//     *
//     * @param matrix 接邻矩阵，表示git树，matrix[i][j] == '1' 当且仅当git树中第i个和第j个节点有连接，节点0为git树的跟节点
//     * @param indexA 节点A的index
//     * @param indexB 节点B的index
//     * @return 整型
//     */
    public int getSplitNode(String[] matrix, int indexA, int indexB) {
        if(indexA==indexB)
            return indexA;
        if(indexA==0||indexB==0)
            return 0;
        //按照深度优先遍历，获得所有的path，然后寻找最后一个公共的节点
        //要有一个visited标识哪个访问过，哪个没访问过
        int n=matrix.length;
        int[] a=null;
        int[] b=null;
        boolean aflag=false,bflag=false;
        int[] visited=new int[n];//0为没访问过，1为访问过
        Stack<Integer> stack=new Stack<Integer>();
//        ArrayList<Integer> list=new ArrayList<Integer>();
        stack.add(0);
//        list.add(0);
        visited[0]=1;

        while((!isAllVisited(visited))&&(!stack.isEmpty())){
            if(aflag&&bflag)
                break;
            for(int i=0;i<n;i++) {//此处好像有死循环，pop的位置可能需要调整
                if(aflag&&bflag)
                    break;
                if(matrix[stack.peek()].charAt(i)=='1'&&visited[i]==0){
                    stack.add(i);
                    if(i==indexA){
                        a=new int[stack.size()];
                        int num=0;
                        Iterator<Integer> iterator=stack.iterator();
                        while(iterator.hasNext()){
                            a[num++]=iterator.next();
                        }
                        aflag=true;
                    }
                    if(i==indexB){
                        b=new int[stack.size()];
                        int num=0;
                        Iterator<Integer> iterator=stack.iterator();
                        while(iterator.hasNext()){
                            b[num++]=iterator.next();
                        }
                        bflag=true;
                    }
                    visited[i]=1;
                    i=-1;
                }
            }
            stack.pop();
        }
        System.out.println("a");
        Arrays.stream(a).forEach(i->System.out.print(i));
        System.out.println("b");
        Arrays.stream(b).forEach(i->System.out.print(i));
        int count=0;
        while(count<a.length&&count<b.length&&a[count]==b[count]){
            count++;
        }
        return a[count-1];
//        return list;
    }
//    public ArrayList<Integer> DepthIterator(String[] matrix){
//        //按照深度优先遍历，获得所有的path，然后寻找最后一个公共的节点
//        //要有一个visited标识哪个访问过，哪个没访问过
//        int n=matrix.length;
//        int[] visited=new int[n];//0为没访问过，1为访问过
//        Stack<Integer> stack=new Stack<Integer>();
//        ArrayList<Integer> list=new ArrayList<Integer>();
//        stack.add(0);
//        list.add(0);
//        visited[0]=1;
//        int num=0;
//        while((!isAllVisited(visited))&&(!stack.isEmpty())){
//            for(int i=0;i<n;i++) {//此处好像有死循环，pop的位置可能需要调整
//                if(matrix[stack.peek()].charAt(i)=='1'&&visited[i]==0){
//                    stack.add(i);
//                    list.add(i);
//                    visited[i]=1;
//                    i=-1;
//                }
//            }
//            stack.pop();
//        }
//        return list;
//    }

    private boolean isAllVisited(int[] visited) {
        for(int i=0;i<visited.length;i++){
            if(i==0){
                return false;
            }
        }
        return true;
    }
}
