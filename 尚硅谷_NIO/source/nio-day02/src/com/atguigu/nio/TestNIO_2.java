package com.atguigu.nio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.DosFileAttributeView;

import org.junit.Test;

public class TestNIO_2 {
	
	
	//自动资源管理：自动关闭实现 AutoCloseable 接口的资源
	@Test
	public void test8(){
		try(FileChannel inChannel = FileChannel.open(Paths.get("1.jpg"), StandardOpenOption.READ);
				FileChannel outChannel = FileChannel.open(Paths.get("2.jpg"), StandardOpenOption.WRITE, StandardOpenOption.CREATE)){
			
			ByteBuffer buf = ByteBuffer.allocate(1024);
			inChannel.read(buf);
			
		}catch(IOException e){
			
		}
	}
	
	/*
		Files常用方法：用于操作内容
			SeekableByteChannel newByteChannel(Path path, OpenOption…how) : 获取与指定文件的连接，how 指定打开方式。
			DirectoryStream newDirectoryStream(Path path) : 打开 path 指定的目录
			InputStream newInputStream(Path path, OpenOption…how):获取 InputStream 对象
			OutputStream newOutputStream(Path path, OpenOption…how) : 获取 OutputStream 对象
	 */
	@Test
	public void test7() throws IOException{
		SeekableByteChannel newByteChannel = Files.newByteChannel(Paths.get("1.jpg"), StandardOpenOption.READ);
		
		DirectoryStream<Path> newDirectoryStream = Files.newDirectoryStream(Paths.get("e:/"));
		
		for (Path path : newDirectoryStream) {
			System.out.println(path);
		}
	}
	
	/*
		Files常用方法：用于判断
			boolean exists(Path path, LinkOption … opts) : 判断文件是否存在
			boolean isDirectory(Path path, LinkOption … opts) : 判断是否是目录
			boolean isExecutable(Path path) : 判断是否是可执行文件
			boolean isHidden(Path path) : 判断是否是隐藏文件
			boolean isReadable(Path path) : 判断文件是否可读
			boolean isWritable(Path path) : 判断文件是否可写
			boolean notExists(Path path, LinkOption … opts) : 判断文件是否不存在
			public static <A extends BasicFileAttributes> A readAttributes(Path path,Class<A> type,LinkOption... options) : 获取与 path 指定的文件相关联的属性。
	 */
	@Test
	public void test6() throws IOException{
		Path path = Paths.get("e:/nio/hello7.txt");
//		System.out.println(Files.exists(path, LinkOption.NOFOLLOW_LINKS));
		
		BasicFileAttributes readAttributes = Files.readAttributes(path, BasicFileAttributes.class, LinkOption.NOFOLLOW_LINKS);
		System.out.println(readAttributes.creationTime());
		System.out.println(readAttributes.lastModifiedTime());
		
		DosFileAttributeView fileAttributeView = Files.getFileAttributeView(path, DosFileAttributeView.class, LinkOption.NOFOLLOW_LINKS);
		
		fileAttributeView.setHidden(false);
	}
	
	/*
		Files常用方法：
			Path copy(Path src, Path dest, CopyOption … how) : 文件的复制
			Path createDirectory(Path path, FileAttribute<?> … attr) : 创建一个目录
			Path createFile(Path path, FileAttribute<?> … arr) : 创建一个文件
			void delete(Path path) : 删除一个文件
			Path move(Path src, Path dest, CopyOption…how) : 将 src 移动到 dest 位置
			long size(Path path) : 返回 path 指定文件的大小
	 */
	@Test
	public void test5() throws IOException{
		Path path1 = Paths.get("e:/nio/hello2.txt");
		Path path2 = Paths.get("e:/nio/hello7.txt");
		
		System.out.println(Files.size(path2));
		
//		Files.move(path1, path2, StandardCopyOption.ATOMIC_MOVE);
	}
	
	@Test
	public void test4() throws IOException{
		Path dir = Paths.get("e:/nio/nio2");
//		Files.createDirectory(dir);
		
		Path file = Paths.get("e:/nio/nio2/hello3.txt");
//		Files.createFile(file);
		
		Files.deleteIfExists(file);
	}
	
	@Test
	public void test3() throws IOException{
		Path path1 = Paths.get("e:/nio/hello.txt");
		Path path2 = Paths.get("e:/nio/hello2.txt");
		
		Files.copy(path1, path2, StandardCopyOption.REPLACE_EXISTING);
	}
	
	/*
		Paths 提供的 get() 方法用来获取 Path 对象：
			Path get(String first, String … more) : 用于将多个字符串串连成路径。
		Path 常用方法：
			boolean endsWith(String path) : 判断是否以 path 路径结束
			boolean startsWith(String path) : 判断是否以 path 路径开始
			boolean isAbsolute() : 判断是否是绝对路径
			Path getFileName() : 返回与调用 Path 对象关联的文件名
			Path getName(int idx) : 返回的指定索引位置 idx 的路径名称
			int getNameCount() : 返回Path 根目录后面元素的数量
			Path getParent() ：返回Path对象包含整个路径，不包含 Path 对象指定的文件路径
			Path getRoot() ：返回调用 Path 对象的根路径
			Path resolve(Path p) :将相对路径解析为绝对路径
			Path toAbsolutePath() : 作为绝对路径返回调用 Path 对象
			String toString() ： 返回调用 Path 对象的字符串表示形式
	 */
	@Test
	public void test2(){
		Path path = Paths.get("e:/nio/hello.txt");
		
		System.out.println(path.getParent());
		System.out.println(path.getRoot());
		
//		Path newPath = path.resolve("e:/hello.txt");
//		System.out.println(newPath);
		
		Path path2 = Paths.get("1.jpg");
		Path newPath = path2.toAbsolutePath();
		System.out.println(newPath);
		
		System.out.println(path.toString());
	}
	
	@Test
	public void test1(){
		Path path = Paths.get("e:/", "nio/hello.txt");
		
		System.out.println(path.endsWith("hello.txt"));
		System.out.println(path.startsWith("e:/"));
		
		System.out.println(path.isAbsolute());
		System.out.println(path.getFileName());
		
		for (int i = 0; i < path.getNameCount(); i++) {
			System.out.println(path.getName(i));
		}
	}
}
