/**
 * @author Liu Awen
 * @create 2020-05-15 19:31
 */
/*
数组的维度：
	一维数组、二维数组、三维数组...

二维数组：
	有行有列的表格，二维表

1、如何声明一个二维数组？
语法格式：
	元素的数据类型[][] 数组名;

2、如何初始化二维数组？
初始化：
（1）确定行数
（2）确定每一行的列数
（3）确定元素的值


回忆：
	一维数组初始化（1）确定长度，元素的个数（2）确定元素的值

（1）静态初始化
	二维数组名 = new 元素的数据类型[][]{{第一行的值列表},{第二行的值列表},...{第n行的值列表}};
（2）动态初始化

3、如何表示二维数组的行数？
二维数组名.length

4、如何表示一行
此时把二维数组看成一个一维数组，把一行看成一个元素
一行：二维数组名[行下标]
行下标的范围：[0,二维数组总行数-1]

5、如何表示每一行的列数？即每一行元素的个数
二维数组的一行，其实又是一个一维数组
二维数组名[行下标].length

6、如何表示某行某列的一个元素呢？
二维数组名[行下标][列下标]

列下标的范围：[0, 该行的列数-1]

7、遍历二维数组
for(int i=0; i<行数; i++){
	for(int j=0; j<该行的列数; j++){
		System.out.print(二维数组名[i][j] + " ");
	}
	System.out.println();
}

for(int i=0; i<二维数组名.length; i++){
	for(int j=0; j<二维数组名[i].length; j++){
		System.out.print(二维数组名[i][j] + " ");
	}
	System.out.println();
}

*/
class Test05_ManyDimensionalArray{
    public static void main(String[] args){
        //存储多个组的学员的成绩，每一个组单独一行存储
		/*
		//1、声明一个二维数组
		int[][] scores;

		//2、静态初始化
		scores = new int[][]{
			{67,89,45},
			{90,99,88,100},
			{34,56,12,67}
		};
		*/
        //如果把声明和静态初始化一起完成，可以简化
        int[][] scores = {
                {67,89,45},
                {90,99,88,100},
                {34,56,12,67}
        };

        System.out.println("行数：" + scores.length);

        //3、遍历
        for(int i=0; i<scores.length; i++){//行数
            //scores[i]代表一行，看成一个整体
            for(int j=0; j<scores[i].length; j++){
                System.out.print(scores[i][j]+" ");
            }
            System.out.println();
        }
    }
}