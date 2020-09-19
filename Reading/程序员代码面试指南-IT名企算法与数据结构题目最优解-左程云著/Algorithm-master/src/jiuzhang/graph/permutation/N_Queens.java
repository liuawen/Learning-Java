package jiuzhang.graph.permutation;

import java.util.ArrayList;

/**
 * Created by Dell on 2017-08-28.
 */
public class N_Queens {
    ArrayList<ArrayList<String>> solveNQueens(int n) {
        ArrayList<ArrayList<String>> lists=new ArrayList<ArrayList<String>>();
        if(n<=0){
            return lists;
        }
        ArrayList<Integer> cols=new ArrayList<Integer>();
        search(lists,cols,n);
        return lists;
    }
    void search(ArrayList<ArrayList<String>> result,ArrayList<Integer> cols,int n){
        if(cols.size()==n){
            result.add(drawQueen(cols));
            return;
        }
        for(int col=0;col<n;col++){
            if(isVaild(cols,col)){
                cols.add(col);
                search(result,cols,n);
                cols.remove(cols.size()-1);
            }
        }
    }

    /**
     * 皇后问题有效的条件是，斜对角线上不能有皇后，不能只判断上一行
     * @param cols
     * @param col
     * @return
     */
    private boolean isVaild(ArrayList<Integer> cols, int col) {
        if(cols.size()==0){
            return true;
        }
        for(int i=0;i<cols.size();i++){//遍历cols中的元素
            if(cols.get(i)==col){
                return false;
            }
            if(cols.get(i)==(col+cols.size()-i)||cols.get(i)==(col-cols.size()+i)){
                return false;
            }
        }
        return true;
    }

    private ArrayList<String> drawQueen(ArrayList<Integer> cols) {
        ArrayList<String> res=new ArrayList<String>();
        for(int i=0;i<cols.size();i++){
            String row="";
            for(int j=0;j<cols.size();j++){
                if(cols.get(i)==j){
                    row+="Q";
                }else{
                    row+=".";
                }
            }
            res.add(row);
        }
        return res;
    }
}
