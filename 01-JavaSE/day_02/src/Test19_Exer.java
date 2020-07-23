/**
 * @author Liu Awen
 * @create 2018-05-07 22:29
 */
//2、定义三个int类型的变量，x,y,z，随意赋值整数值，求最大值
class Test19_Exer{
    public static void main(String[] args){
        int x = 23;
        int y = 34;
        int z = 49;

        //int max = x>=y ? x : y;//运行完这句max中存的是x与y中的最大值
        //max = max >=z ? max : z;//用新的max与z比较

        int max = (x>=y ? x : y) >= z ? (x>=y ? x : y) : z;
        System.out.println("max = " + max);

        //还不如两行的
//        int min = (x<=y ? x:y) <= z ? (x<=y ? x:y) : z;
//        System.out.println("min:" + min);
        int min = x<=y ? x:y;//行完这句min中存的是x与y中的最小值
        min = min<=z ? min :z;////用新的min与z比较
        System.out.println("min:" + min);
    }
}
