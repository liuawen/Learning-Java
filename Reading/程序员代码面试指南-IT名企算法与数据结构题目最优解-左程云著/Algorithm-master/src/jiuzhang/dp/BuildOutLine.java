package jiuzhang.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by Dell on 2017-08-20.
 */
public class BuildOutLine {
    public ArrayList<ArrayList<Integer>> buildingOutline(int[][] buildings) {
        Arrays.sort(buildings, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        ArrayList<ArrayList<Integer>> res=new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> cur=new ArrayList<>();
        cur.add(buildings[0][0]);cur.add(buildings[0][1]);cur.add(buildings[0][2]);
        res.add(cur);
        for(int i=1;i<buildings.length;i++){
            cur=res.get(i-1);
            if(buildings[i][0]<cur.get(1)){//新的楼和旧的楼有重叠
                if(buildings[i][2]>cur.get(2)){//后面的高遮挡矮的
                    cur.set(1,buildings[i][0]);
                    ArrayList<Integer> build=new ArrayList<>();
                    cur.add(buildings[i][0]);cur.add(buildings[i][1]);cur.add(buildings[i][2]);
                    res.add(build);
                }else{//新的矮，将新的露出来的加入list
                    if(buildings[i][1]>cur.get(1)){
                        ArrayList<Integer> build=new ArrayList<>();
                        cur.add(cur.get(1));cur.add(buildings[i][1]);cur.add(buildings[i][2]);
                        res.add(build);
                    }
                }
            }else{//新的楼和旧的楼没有重叠
                ArrayList<Integer> build=new ArrayList<>();
                cur.add(buildings[i][0]);cur.add(buildings[i][1]);cur.add(buildings[i][2]);
                res.add(build);
            }
        }
        return res;
    }
}
