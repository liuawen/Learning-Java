package nowCoderClass1.section13;

/**
 * Created by Dell on 2017-06-05.
 */
public class HorseRace {
    public int winMost(int[] oppo, int[] horses, int n) {
       sort(oppo);
       sort(horses);
       int j=horses.length-1, num=0;
       //从后开始就是让每一匹马找到它恰好能战胜的马
       for(int i=oppo.length-1;i>=0;i--){
           if(oppo[i]<horses[j]){//比的过
                num++;
                j--;
           }
       }
       return num;
    }

    private void sort(int[] a){
        for(int i=0; i<a.length; i++){
            int min = i;
            for(int j=i; j<a.length; j++){
                if(a[j]<a[min]){
                    min = j;
                }
            }
            exch(a,min,i);
        }
    }

    private void exch(int[] a, int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
