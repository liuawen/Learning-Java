/**
 * @author Liu Awen
 * @create 2018-05-07 16:23
 */
class Test06_Exer3{
    public static void main(String[] args){
        int i = 1;
        int j = 2;
		/*
		第一步：++i
		(1)先自增,i=2
		(2)在取i的值“2”，放起来
		第二步：j
		(1)取j的值“2”，放起来
		第三步：++i
		(1)先自增，i=3
		(2)在取i的值"3"，放起来
		第四步：求乘积
		2 * 3 = 6，结果放起来
		第五步：求和
		2 + 6 = 8
		*/
        System.out.println(++i + j * ++i);
    }
}