练习一:字节输出流写出字节数据
描述:利用字节输出流一次写一个字节的方式，向D盘的a.txt文件输出字符‘a’。
答案
操作步骤:
1.	创建字节输出流FileOutputStream对象并指定文件路径。
2.	调用字节输出流的write(int byte)方法写出数据
代码:
public class Test01_01 {
public static void main(String[] args) throws IOException {
		// 1.创建字节输出流FileOutputStream对象并指定文件路径。
		FileOutputStream fos = new FileOutputStream("d:/a.txt");
		// 2.调用字节输出流的write(int byte)方法写出数据
		fos.write(97);
		// 3.关闭流
		fos.close();
	}
}
练习二:字节输出流写出字节数组数据
描述:利用字节输出流一次写一个字节数组的方式向D盘的b.txt文件输出内容:"i love java"。
答案
操作步骤:
1.	创建字节输出流FileOutputStream对象并指定文件路径。
2.	调用字节输出流的write(byte[] buf)方法写出数据。
代码:
public class Test01_02 {
		public static void main(String[] args) throws IOException {
		// 1.创建字节输出流FileOutputStream对象并指定文件路径。
		FileOutputStream fos = new FileOutputStream("d:/b.txt");
		// 2.调用字节输出流的write(byte[] buf)方法写出数据。
		byte[] buf = "i love java".getBytes();
		fos.write(buf);
		// 3.关闭资源
		fos.close();
	}
}
练习三:文件的续写和换行输出
描述:在D盘下，有一c.txt 文件中内容为：HelloWorld 
在c.txt文件原内容基础上，添加五句 I love java，而且要实现一句一行操作(注：原文不可覆盖)。
利用字节输出流对象往C盘下c.txt文件输出5句：”i love java”

答案
操作步骤:
1.	利用两个参数的构造方法创建字节输出流对象，参数一指定文件路径，参数二指定为true
2.	调用字节输出流的write()方法写入数据，在每一行后面加上换行符:”\r\n”
代码:
public class Test01_03 {
	public static void main(String[] args) throws IOException{
		// 1.创建字节输出流FileOutputStream对象并指定文件路径,并追加方式
		FileOutputStream fos = new FileOutputStream("c:/c.txt",true);
		// 2.调用字节输出流的write方法写出数据
		// 2.1 要输出的字符串
		String content = "i love java \r\n";
		for (int i = 0; i< 5; i++) {
			fos.write(content.getBytes());
		}
		// 3.关闭流
		fos.close();
	}
}
练习四:字节输入流一次读取一个字节数据
描述:利用字节输入流读取D盘文件a.txt的内容，文件内容确定都为纯ASCII字符
,使用循环读取，一次读取一个字节，直到读取到文件末尾。将读取的字节输出到控制台
答案
操作步骤:
1.	创建字节输入流对象指定文件路径。
2.	调用read(byte b)方法循环读取文件中的数据
3.	直到读取到-1时结束读取
代码:
public class Test01_04 {
	public static void main(String[] args) throws IOException{
		// 创建字节输入流对象并关联文件
		FileInputStream fis = new FileInputStream("d:/a.txt");
		// 定义变量接收读取的字节
		int len = -1;
		// 循环从流中读取数据
		while((len = fis.read()) != -1) {
			System.out.print((char)len);
		}
		// 关闭流
		fis.close();
	}
}
练习五:字节输入流一次读取一个字节数组数据
描述:利用字节输入流读取D盘文件b.txt的内容，文件内容确定都为纯ASCII字符
,使用循环读取，一次读取一个字节数组，直到读取到文件末尾，将读取到的字节数组转换成字符串输出到控制台。
答案
操作步骤:
1.	创建字节输入流对象指定文件路径。
2.	定义一个字节数数组，用来存放读取的字节数
3.	调用read(byte[] buf)方法传入字节数组，循环读取文件中的数据
4.	直到读取到-1时结束读取
代码:
public class Test01_05 {
	public static void main(String[] args) throws IOException{
		// 创建字节输入流对象并关联文件
		FileInputStream fis = new FileInputStream("d:/b.txt");
		// 定义字节数组存放读取的字节数
		byte[] buffer = new byte[1024];
		// 定义变量接收读取的字节
		int len = -1;
		// 循环从流中读取数据
		while((len = fis.read(buffer)) != -1) {
			System.out.print(new String(buffer,0,len));
		}
		// 关闭流
		fis.close();
	}
}
练习六:字节流复制文件
描述:利用字节流将E盘下的a.png图片复制到D盘下(文件名保存一致)
要求：
一次读写一个字节的方式
答案
操作步骤:
1.	创建字节输入流对象关联文件路径：E盘下的a.png
2.	创建字节输出流对象关联文件路径：D盘下的a.png
3.	使用循环不断从字节输入流读取一个字节，每读取一个字节就利用输出流写出一个字节。
4.	关闭流，释放资源
代码:
public class Test01_06 {
	public static void main(String[] args) throws IOException {
		// 创建字节输入流对象并关联文件
		FileInputStream fis = new FileInputStream("e:/a.png");
		// 创建字节输出流对象并关联文件
		FileOutputStream fos = new FileOutputStream("d:/a.png");
		// 定义变量接收读取的字节数
		int len = -1;
		// 循环读取图片数据
		while((len = fis.read()) != -1) {
			// 每读取一个字节的数据就写出到目标文件中
			fos.write(len);
		}
		// 关闭流
		fis.close();
		fos.close();
	}
}
