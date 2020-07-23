/**
 * @author Liu Awen Email:willowawen@gmail.com
 * @create 2020-05-17
 */
/*
1、声明一个图形工具类，声明一个方法，可以打印n行某字符的等腰三角形
*/
/*
class Test11_Exer3{
    public static void main(String[] args){
        //1、创建GraphicTools对象
        GraphicTools tools = new GraphicTools();

        //2、调用方法
        tools.printEqualSideTriangle(6,'*');
    }
}
class GraphicTools{
    //声明一个方法，可以打印n行某字符的等腰三角形
	*/
/*
					*
				*	*	*
			*	*	*	*	*
		*	*	*	*	*	*	*
	*	*	*	*	*	*	*	*	*
*	*	*	*	*	*	*	*	*	*	*
例如6行，
第1个左边是5个空格，1个*   5 = 6-1  1 = 2*1-1
第2个左边是4个空格，3个*
第3个左边是3个空格，5个*
第4个左边是2个空格，7个*
第5个左边是1个空格，9个*
第6个左边是0个空格，11个*	0 = 6-6  11 = 2*6-1

*//*

    void printEqualSideTriangle(int n, char x){
        for(int i=1; i<=n; i++){
            //先打印空格：空格数= n-i个
            for(int j=1; j<=n-i; j++){
                System.out.print(" ");
            }

            //打印x符号：x符号的数量 = 2*i-1
            for(int k = 1; k<=2*i-1; k++){
                System.out.print(x);
            }

            //换行
            System.out.println();
        }
    }
}*/
