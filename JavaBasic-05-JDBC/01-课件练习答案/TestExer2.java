package jdbc.atguigu.exer;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Scanner;

import jdbc.atguigu.connection.JDBCUtils;

import org.junit.Test;

public class TestExer2 {

	// 3.删除（法二）：较好！
	@Test
	public void testDelete1() {
		Scanner s = new Scanner(System.in);
		System.out.println("请输入学生的考号：");
		String examCard = s.next();
		String sql = "delete from examstudent where examcard = ?";

		boolean b = delete(sql,examCard);
		if (b) {
			System.out.println("删除成功！");
		} else {
			System.out.println("查无此人");
		}
	}

	// 3.删除（法一）
	@Test
	public void testDelete() throws Exception {
		Scanner s = new Scanner(System.in);
		System.out.println("请输入学生的考号：");
		String examCard = s.next();
		String sql = "delete from examstudent where examcard = ?";

		String sql1 = "select Type type,IDCard IDCard,ExamCard examCard,Location location,StudentName studentName,Grade grade from examstudent"
				+ " where examCard = ?";

		Student student = getInstance(Student.class,sql1,examCard);
		if (student != null) {
			update(sql,examCard);
			System.out.println("删除成功");
		} else {
			System.out.println("查无此人");
		}

	}

	// 2.查询（身份证号、准考证号）
	@Test
	public void testQuery() throws Exception {
		System.out.println("请选择您要输入的类型：\na:准考证号\nb:身份证号:");
		Scanner s = new Scanner(System.in);
		String type = s.next();

		if (type.equalsIgnoreCase("a")) {
			System.out.println("请输入准考证号：");
			String examCard = s.next();
			String sql = "select Type type,IDCard IDCard,ExamCard examCard,Location location,StudentName studentName,Grade grade from examstudent"
					+ " where examCard = ?";

			Student s1 = getInstance(Student.class,sql,examCard);

			if (s1 != null) {
				System.out.println(s1);
			} else {
				System.out.println("查无此人");
			}

		} else if (type.equalsIgnoreCase("b")) {
			System.out.println("请输入身份证号：");
			String IDCard = s.next();
			String sql = "select Type type,IDCard IDCard,ExamCard examCard,Location location,StudentName studentName,Grade grade from examstudent where IDCard = ?";

			Student s1 = getInstance(Student.class,sql,IDCard);

			if (s1 != null) {
				System.out.println(s1);
			} else {
				System.out.println("查无此人");
			}
		} else {
			System.out.println("您输入的信息有误！请重新进入");
		}
	}

	// 1.向表中插入数据
	@Test
	public void testInsert() {
		Scanner s = new Scanner(System.in);
		System.out.println("type:");
		int type = s.nextInt();
		System.out.println("IDCard:");
		String idCard = s.next();
		System.out.println("examCard:");
		String examCard = s.next();
		System.out.println("StudentName:");
		String studentName = s.next();
		System.out.println("Location:");
		String location = s.next();
		System.out.println("Grade:");
		int grade = s.nextInt();

		String sql = "insert into examstudent(type,idcard,examcard,studentname,location,grade)"
				+ "values(?,?,?,?,?,?)";

		update(sql,type,idCard,examCard,studentName,location,grade);
		System.out.println("录入成功！");

	}
	//通用的查询
	public <T> T getInstance(Class<T> clazz,String sql,Object ... args) throws Exception{
		Connection conn = JDBCUtils.getConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		for(int i = 0;i < args.length;i++){
			ps.setObject(i + 1, args[i]);
		}
		
		ResultSet rs = ps.executeQuery();
		ResultSetMetaData rsmd = rs.getMetaData();
		int columnCount = rsmd.getColumnCount();
		if(rs.next()){
			T t = clazz.newInstance();
			for(int i = 0;i < columnCount;i++){
				Object columnVal = rs.getObject(i + 1);
				String columnLabel = rsmd.getColumnLabel(i + 1);
				
				Field field = clazz.getDeclaredField(columnLabel);
				field.setAccessible(true);
				field.set(t, columnVal);
				
			}
			return t;
		}
		
		JDBCUtils.close(rs, ps, conn);
		
		return null;
	}

	// 通用的增删改操作
	public static void update(String sql, Object... args) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = JDBCUtils.getConnection();
			ps = conn.prepareStatement(sql);
			for (int i = 0; i < args.length; i++) {
				ps.setObject(i + 1, args[i]);
			}
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			JDBCUtils.close(null, ps, conn);
		}

	}

	// 删除操作，返回是否有数据被删除
	public static boolean delete(String sql, Object... args) {
		// 1.获取数据库的连接
		Connection conn = null;
		// 2.获取一个PreparedStatement的对象
		PreparedStatement ps = null;
		try {
			conn = JDBCUtils.getConnection();
			ps = conn.prepareStatement(sql);
			for (int i = 0; i < args.length; i++) {
				ps.setObject(i + 1, args[i]);
			}
			// 3.通过PreparedStatement的对象执行sql语句
			int i = ps.executeUpdate();
			if (i > 0) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 4.关闭操作
			JDBCUtils.close(null, ps, conn);
		}
		return false;
	}
}
