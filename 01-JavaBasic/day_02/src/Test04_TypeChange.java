/**
 * @author Liu Awen
 * @create 2018-05-07 14:46
 */
/*
数据类型转换的特例：字符串类型
	所有类型与字符串“+”拼接，结果都是字符串
*/
class Test04_TypeChange{
    public static void main(String[] args){
        char c1 = '0';
        char c2 = '1';

		/*
		c1 + c2，按照求和运算，char + char结果是int
		""代表空字符串，
		当int的97与""进行 “+”拼接，结果还是97的字符串
		*/
        System.out.println(c1 + c2 + "");//97
        // '0' + '1' int + ""  48 + 49  97

		/*
		"" + c1，按照“拼接”运算，字符串 + char，结果是字符串，结果是"0"
		"0" + c2，按照“拼接”运算，字符串 + char，结果是字符串，结果是"01"
		*/
        System.out.println("" + c1 + c2 );//01

		/*
		c1 + ""，按照“拼接”运算，char + 字符串 ，结果是字符串，结果是"0"
		"0" + c2，按照“拼接”运算，字符串 + char，结果是字符串，结果是"01"
		*/
        System.out.println(c1 + "" + c2 );//01
    }
}
