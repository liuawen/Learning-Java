/**
 * @author Liu Awen
 * @create 2018-05-08 12:54
 */
/*
6、假设你想开发一个玩彩票的游戏，
程序随机地产生一个两位数的彩票，提示用户输入一个两位数，
然后按照下面的规则判定用户是否能赢。
1)如果用户输入的数匹配彩票的实际顺序，奖金10 000美元。
相等
2)如果用户输入的所有数字匹配彩票的所有数字，但顺序不一致，奖金 3 000美元。
我的个位=你的十位 && 我的十位=你的个位
3)如果用户输入的一个数字仅满足顺序情况下匹配彩票的一个数字，奖金1 000美元。
个 个 || 十 个
4)如果用户输入的一个数字仅满足非顺序情况下匹配彩票的一个数字，奖金500美元。
个 十 || 十 个
5)如果用户输入的数字没有匹配任何一个数字，则彩票作废。
提示：使用Math.random() 产生随机数
Math.random() 产生[0,1)范围的随机值
两位数的范围：[10,99]
Math.random() * 90：[0,90)
Math.random() * 90 + 10：[10,100) 即得到  [10,99]
使用(int)(Math.random() * 90  + 10)产生一个两位数的随机数。
*/
class Test12_Exer6{
    public static void main(String[] args){
        //1、随机地产生一个两位数的彩票
        int rand = (int)(Math.random() * 90  + 10);//[10,99]

        //2、提示用户输入一个两位数
        java.util.Scanner input = new java.util.Scanner(System.in);
        System.out.print("请输入两位数的彩票号码：");
        int num = input.nextInt();

        //3、处理数字
        int randShi = rand/10;
        int randGe = rand%10;
        int numShi = num/10;
        int numGe = num%10;

        //4、判断
		/*
		1)如果用户输入的数匹配彩票的实际顺序，奖金10 000美元。
		2)如果用户输入的所有数字匹配彩票的所有数字，但顺序不一致，奖金 3 000美元。
		3)如果用户输入的一个数字仅满足顺序情况下匹配彩票的一个数字，奖金1 000美元。
		4)如果用户输入的一个数字仅满足非顺序情况下匹配彩票的一个数字，奖金500美元。
		5)如果用户输入的数字没有匹配任何一个数字，则彩票作废。
		*/
        if(num == rand){
            System.out.println("奖金10 000美元");
        }else if(randShi == numGe && randGe == numShi){
            System.out.println("奖金3 000美元");
        }else if(randShi == numShi || randGe == numGe){
            System.out.println("奖金1 000美元");
        }else if(randShi == numGe || randGe == numShi){
            System.out.println("奖金500美元");
        }else{
            System.out.println("彩票作废");
        }

        System.out.println("本次号码：" + rand);
    }
}