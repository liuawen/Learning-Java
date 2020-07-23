package homework;

/**
 * @author Liu Awen
 * @create 2018-05-11 13:26
 */
class Day05_Test02{
    public static void main(String[] args){
        //用两个String数组来表示 hua  dian
        String[] hua = {"黑桃","红桃","梅花","方片"};
        String[] dian = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};//一到13
        //遍历出来
        for(int i=0; i<hua.length; i++){
            for(int j=0; j<dian.length; j++){
                System.out.print(hua[i]+dian[j] + " ");
            }
            System.out.println();
        }
        //黑桃A 黑桃2 黑桃3 黑桃4 黑桃5 黑桃6 黑桃7 黑桃8 黑桃9 黑桃10 黑桃J 黑桃Q 黑桃K
        //红桃A 红桃2 红桃3 红桃4 红桃5 红桃6 红桃7 红桃8 红桃9 红桃10 红桃J 红桃Q 红桃K
        //梅花A 梅花2 梅花3 梅花4 梅花5 梅花6 梅花7 梅花8 梅花9 梅花10 梅花J 梅花Q 梅花K
        //方片A 方片2 方片3 方片4 方片5 方片6 方片7 方片8 方片9 方片10 方片J 方片Q 方片K
    }
}