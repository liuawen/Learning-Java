package company.ali;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ArrayList<Integer> _ids = new ArrayList<Integer>();
        ArrayList<Integer> _parents = new ArrayList<Integer>();
        ArrayList<Integer> _costs = new ArrayList<Integer>();

        Scanner in = new Scanner(System.in);
        String line = in.nextLine();

        while(line != null && !line.isEmpty()) {
            System.out.println("输入   ，"+line);
            if(line.trim().equals("0")) break;
            String []values = line.trim().split(" ");
            if(values.length != 3) {
                break;
            }
            _ids.add(Integer.parseInt(values[0]));
            _parents.add(Integer.parseInt(values[1]));
            _costs.add(Integer.parseInt(values[2]));
            line = in.nextLine();
        }
        int res = resolve(_ids, _parents, _costs);
        System.out.println(String.valueOf(res));
    }

    // write your code here
    public static int resolve(ArrayList<Integer> ids, ArrayList<Integer> parents, ArrayList<Integer> costs) {
        Map<Integer,Integer> map=new HashMap<Integer,Integer>();
        for(int index=0;index<ids.size();index++){
            if(parents.get(index)==0){//根节点
                map.put(ids.get(index),costs.get(index));//放入的是开销
            }else{//有父节点
                boolean flag=true;
                int current=index;
                ArrayList<Integer> array=new ArrayList<Integer>();//存放的是下标
                while(flag){
                    //父节点是否保存在map中
                    if(map.containsKey(parents.get(current))){
                        map.put(ids.get(current),map.get(parents.get(current))+costs.get(current));
                        flag=false;
                    }else{//没有，
                        //一层层递归，直到全部填入
                        array.add(current);
                        current=ids.indexOf(parents.get(current));//查找器父节点的index
                        //查看其父节点是否在map中
                        if(parents.get(current)==0){//表示current是根节点
                            map.put(ids.get(current),costs.get(current));
                            flag=false;
                        }
                    }
                }
                //取出一个，将其加入
                for(int i=array.size()-1;i>0;i--) {
                    map.put(ids.get(i), map.get(parents.get(i)) + costs.get(i));
                }
            }
        }
        int max=0;
        for(Map.Entry<Integer,Integer> entry:map.entrySet() ){
            max=entry.getValue()>max?entry.getValue():max;
        }
        return max;
    }
}
