练习一:相对路径和绝对路径的使用
描述:创建两个文件对象，分别使用相对路径和绝对路径创建。
答案
操作步骤:
绝对路径创建文件对象：使用File类一个参数的构造方法。
相对路径创建文件对象：使用File类两个参数的构造方法。
代码:
public class Test01_01 {
public static void main(String[] args) {
// 创建文件对象：绝对路径
		File f1 = new File("d:/aaa/a.txt");
		// 创建文件对象：相对路径
		File f2 = new File("a.txt");
	}
}
练习二:检查文件是否存在,文件的创建
描述:检查D盘下是否存在文件a.txt,如果不存在则创建该文件。
答案
操作步骤:
1.	使用绝对路径创建对象关联到D盘的a.txt。
2.	通过文件对象方法判断文件是否存在。
3.	不存在则调用创建文件的方法创建文件。
代码:
public class Test01_02 {
	public static void main(String[] args) throws IOException{
		// 创建文件对象：绝对路径
		File f = new File("d:/a.txt");
		// 如果文件不存在，则创建文件
		if(!f.exists()) {
			f.createNewFile();
		}
	}
}

练习三:单级文件夹的创建
描述:在D盘下创建一个名为bbb的文件夹。
答案
操作步骤:
1.	创建文件对象指定路径为d:/bbb
2.	调用文件对象创建文件夹的方法
代码:
public class Test01_03 {
	public static void main(String[] args) {
		// 创建文件对象
		File f = new File("d:/bbb");
		// 创建单级文件夹
		f.mkdir();
	}
}

练习四:多级文件夹的创建
描述:在D盘下创建一个名为ccc的文件夹，要求如下：
1.ccc文件夹中要求包含bbb子文件夹
2.bbb子文件夹要求包含aaa文件夹
答案:
操作步骤:
1.	创建文件对象关联路径：d:/ccc/bbb/aaa
2.	调用文件对象创建多级文件夹的方法
代码:
public class Test01_04 {
	public static void main(String[] args) {
		// 创建文件对象
		File f = new File("d:/ccc/bbb/aaa");
		// 创建多级文件夹
		f.mkdirs();
	}
}
练习五:删除文件和文件夹
描述:
将D盘下a.txt文件删除
将D盘下aaa文件夹删除,要求文件夹aaa是一个空文件夹。
答案:
操作步骤:
1.	创建文件对象关联路径：d:/a.txt
2.	调用文件对象删除文件的方法
3.	创建文件对象关联路径：d:/aaa
4.	调用文件对象删除文件夹的方法
代码:
public class Test01_05 {
	public static void main(String[] args) {
		// 创建文件对象
		File f = new File("d:/a.txt");
		// 删除文件
		f.delete();
		
		// 创建文件夹对象
		File dir = new File("d:/aaa");
		// 删除文件夹
		dir.delete();
	}
}
练习六:获取文件信息:文件名,文件大小,文件的绝对路径,文件的父路径
描述:
获取D盘aaa文件夹中b.txt文件的文件名，文件大小，文件的绝对路径和父路径等信息，并将信息输出在控制台。
答案:
操作步骤:
1.	在D盘aaa文件夹中创建一个b.txt文件并输入数据
2.	创建文件对象关联路径：d:/aaa/b.txt
3.	调用文件对象的相关方法获得信息并输出。可以通过API帮助文档查询方法。
代码:
public class Test01_06 {
	public static void main(String[] args) {
		// 创建文件对象
		File f = new File("d:/aaa/b.txt");
		// 获得文件名
		String filename = f.getName();
		// 获得文件大小
		longfilesize = f.length();
		// 获得文件的绝对路径
		String path = f.getAbsolutePath();
		// 获得父文件夹路径，返回字符串
		String parentPath = f.getParent();
		// 获得父文件夹路径，返回文件对象
		File parentFile = f.getParentFile();
		// 输出信息
		System.out.println("文件名：" + filename);
		System.out.println("文件大小：" + filesize);
		System.out.println("文件路径：" + path);
		System.out.println("文件父路径：" + parentPath);
		System.out.println("文件父路径：" + parentFile);
	}
}

练习七:文件夹或文件的判断
描述:
1.判断File对象是否是文件,是文件则输出：xxx是一个文件，否则输出：xxx不是一个文件。
2.判断File对象是否是文件夹,是文件夹则输出：xxx是一个文件夹，否则输出：xxx不是一个文件夹。(xxx是文件名或文件夹名)
答案:
操作步骤:
1.	创建两个文件对象分别关联到不同的文件，比如：d:/a.txt，d:/aaa
2.	调用文件对象的判断是否是文件或是否是文件夹的方法
3.	获得文件名，根据判断结果输出信息。
代码:
public class Test01_07 {
	public static void main(String[] args) {
		// 创建文件对象
		File f1 = new File("d:/b.txt");
		// 判断是否是一个文件
		if(f1.isFile()) {
			System.out.println(f1.getName()+"是一个文件");
		}  else {
			System.out.println(f1.getName()+"不是一个文件");
		}
		// 创建文件对象
		File f2 = new File("d:/aaaa");
		// 判断是否是一个文件夹
		if(f2.isDirectory()) {
			System.out.println(f2.getName()+"是一个文件夹");
		}  else {
			System.out.println(f2.getName()+"不是一个文件夹");
		}
	}
}
