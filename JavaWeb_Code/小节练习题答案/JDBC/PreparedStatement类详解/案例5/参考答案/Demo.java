package com.itheima.test;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class Demo {
	/*
	 1.在数据库创建部门表和员工表，包含字段如下：
	部门表包含字段有：部门编号，部门名称(唯一且不能为空)
	员工表包含字段有：员工编号，员工姓名(唯一且不能为空)，员工性别，员工职位，员工工资，入职日期。部门编号(外键)
	
	2.先添加多个部门数据，再添加多条员工数据
	
	3.编写方法接收一个员工编号和工资两个参数，方法内将指定编号的员工工资修改为新的工资。
	4.编写方法查询指定职位所有员工的信息，返回List<Employee>集合。
	5.编写方法查询指定姓名的员工信息，返回Employee对象。
	6.编写方法根据员工姓名删除指定的员工信息。
	7.编写方法查询所有姓张员工的工资并输出在控制台，输出格式如下：
		张三=10000
		张飞=20000
		…………………
	8.编写方法接收一个工资参数，方法内查询工资大于等于传入的工资的员工，返回符合条件所有员工信息List<Employee>集合。
	9.编写方法查询指定部门的所有员工信息，返回List<Employee>集合
	*/
	
	public static void main(String[] args)  throws Exception{
		// 创建表
		// createTable();
		
		// 添加部门数据
		// addDept();
		
		// 添加员工数据
		// addEmployees();
		
		// 修改id=2的员工工资为16000
		// updateSalary(2, 16000);
		
		// 获得所有员工信息
		/* List<Employee> employees = findAllEmployee();
		for (Employee employee : employees) {
			System.out.println(employee);
		} */
		
		/*
		Employee e = findEmployeeByName("林青");
		System.out.println(e);
		*/
		
		// 删除name为林青霞的员工
		// System.out.println(deleteByName("林青霞"));
		
		// 7.编写方法查询所有姓张员工的工资并输出在控制台
		// querySalarys();
		
		// 8.查询工资大于10000的员工
		/*List<Employee> employees = findEmployeeBySalary(20000);
		for (Employee employee : employees) {
			System.out.println(employee);
		}*/
		
		// 9.编写方法查询指定部门的所有员工信息，返回List<Employee>集合
		List<Employee> employees = findEmployeeByDeptName("产品部");
		for (Employee employee : employees) {
			System.out.println(employee);
		}
	}
	
	// 9.编写方法查询指定部门的所有员工信息，返回List<Employee>集合
	public static List<Employee> findEmployeeByDeptName(String deptName) {
		String sql = "select * from employee where deptid in("
				+ "select id from dept where dept_name = ?"
				+ ");";
		//1.得到连接对象
		Connection conn = JdbcUtil.getConnection();
		//2. 创建PreparedStatement
		PreparedStatement ps  = null;
		ResultSet rs = null;
		List<Employee> employees = new ArrayList<>();
		try {
			//2. 创建PreparedStatement
			ps = conn.prepareStatement(sql);
			//3.设置参数并运行
		    ps.setString(1, deptName);
			rs = ps.executeQuery();
			while(rs.next()) {
				// 创建员工对象
				Employee e = new Employee(rs.getInt("id"), rs.getString("name"), rs.getString("gender"), 
						rs.getString("post"), rs.getDouble("salary"), rs.getDate("edate"), 
						rs.getInt("deptid"));
				// 添加到集合中
				employees.add(e);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			JdbcUtil.close(conn, ps, rs);
		}
		return employees;
	}
	
	// 8.编写方法接收一个工资参数，方法内查询工资大于等于传入的工资的员工，
	// 返回符合条件所有员工信息List<Employee>集合。
	public static List<Employee> findEmployeeBySalary(double salary) {
		String sql = "select * from employee where salary >= ?";
		//1.得到连接对象
		Connection conn = JdbcUtil.getConnection();
		//2. 创建PreparedStatement
		PreparedStatement ps  = null;
		ResultSet rs = null;
		List<Employee> employees = new ArrayList<>();
		try {
			//2. 创建PreparedStatement
			ps = conn.prepareStatement(sql);
			//3.设置参数并运行
			ps.setDouble(1, salary);
			rs = ps.executeQuery();
			while(rs.next()) {
				// 创建员工对象
				Employee e = new Employee(rs.getInt("id"), rs.getString("name"), rs.getString("gender"), 
						rs.getString("post"), rs.getDouble("salary"), rs.getDate("edate"), 
						rs.getInt("deptid"));
				// 添加到集合中
				employees.add(e);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			JdbcUtil.close(conn, ps, rs);
		}
		return employees;
	}
	
	// 7.编写方法查询所有姓张员工的工资并输出在控制台，输出格式如下：
	public static void  querySalarys() {
		String sql = "select salary,name from employee where name like'张%' ";
		//1.得到连接对象
		Connection conn = JdbcUtil.getConnection();
		PreparedStatement ps  = null;
		ResultSet rs = null;
		try {
			//2. 创建PreparedStatement
			ps = conn.prepareStatement(sql);
			//3. 执行查询操作
			rs = ps.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getString("name") + "=" + rs.getDouble("salary"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, ps,rs);
		}
	}
	
	// 6.编写方法根据员工姓名删除指定的员工信息。
	public static boolean deleteByName(String name){
		String sql = "delete from employee where name = ?";
		//1.得到连接对象
		Connection conn = JdbcUtil.getConnection();
		PreparedStatement ps  = null;
		try {
			//2. 创建PreparedStatement
			ps = conn.prepareStatement(sql);
			//3.设置参数并运行
			ps.setString(1, name);
			int row = ps.executeUpdate();
			return row == 1;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, ps);
		}
		return false;
	}
	
	// 5.编写方法查询指定姓名的员工信息，返回Employee对象。
	public static Employee findEmployeeByName(String name){
		String sql = "select * from employee where name = ?";
		//1.得到连接对象
		Connection conn = JdbcUtil.getConnection();
		PreparedStatement ps  = null;
		ResultSet rs = null;
		try {
			//2. 创建PreparedStatement
			ps = conn.prepareStatement(sql);
			//3.设置参数并运行
			ps.setString(1, name);
			rs = ps.executeQuery();
			rs.next();
			// 创建员工对象
			Employee e = new Employee(rs.getInt("id"), rs.getString("name"), rs.getString("gender"), 
					rs.getString("post"), rs.getDouble("salary"), rs.getDate("edate"), 
					rs.getInt("deptid"));
			return e;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, ps, rs);
		}
		return null;
	}
	
	// 4.编写方法查询指定职位所有员工的信息，返回List<Employee>集合。
	public static List<Employee> findAllEmployee() {
		String sql = "select * from employee";
		//1.得到连接对象
		Connection conn = JdbcUtil.getConnection();
		//2. 创建PreparedStatement
		PreparedStatement ps  = null;
		ResultSet rs = null;
		List<Employee> employees = new ArrayList<>();
		try {
			ps = conn.prepareStatement(sql);
			//3. 因为没有参数，所以直接运行
			rs = ps.executeQuery();
			while(rs.next()) {
				// 创建员工对象
				Employee e = new Employee(rs.getInt("id"), rs.getString("name"), rs.getString("gender"), 
						rs.getString("post"), rs.getDouble("salary"), rs.getDate("edate"), 
						rs.getInt("deptid"));
				// 添加到集合中
				employees.add(e);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			JdbcUtil.close(conn, ps, rs);
		}
		return employees;
	}
	
	// 3.编写方法接收一个员工编号和工资两个参数，方法内将指定编号的员工工资修改为新的工资。
	public static void updateSalary(int id,double salary)  throws Exception {
		// 获得连接对象
		Connection conn = JdbcUtil.getConnection();
		// Sql语句
		String sql = "update employee set salary = ? where id = ?;";
		// 获得PreparedStatement对象
		PreparedStatement ps = conn.prepareStatement(sql);
		// 设置参数
		ps.setDouble(1, salary);
		ps.setInt(2, id);
		// 执行SQL语句
		int row = ps.executeUpdate();
		System.out.println(row);
		// 关闭资源
		JdbcUtil.close(conn, ps);
	}
	
	// 添加多条员工数据
	public static void addEmployees() throws Exception{
		// 获得连接对象
		Connection conn = JdbcUtil.getConnection();
		// SQL语句
		String sql = "insert into employee(name,gender,post,salary,edate,deptid) "
				+ "values('张三','男','Java研发工程师',9000,'2016-10-10',1),"
				+ "('林青霞','女','销售经理',15000,'2015-06-15',2),"
				+ "('李四','男','产品经理',10000,'2014-12-11',3),"
				+ "('张三丰','男','Android研发工程师',8000,'2017-05-26',1);";
		// 获得PreparedStatement对象
		PreparedStatement ps = conn.prepareStatement(sql);
		// 执行SQL语句
		int row = ps.executeUpdate();
		System.out.println(row);
		// 关闭资源
		JdbcUtil.close(conn, ps);
	}
		
		
	// 添加多个部门数据
	public static void addDept() throws Exception{
		// 获得连接对象
		Connection conn = JdbcUtil.getConnection();
		// SQL语句
		String sql = "insert into dept(dept_name) values('研发部'),('销售部'),('产品部');";
		// 获得PreparedStatement对象
		PreparedStatement ps = conn.prepareStatement(sql);
		// 执行SQL语句
		int row = ps.executeUpdate();
		System.out.println(row);
		// 关闭资源
		JdbcUtil.close(conn, ps);
	}
	
	/*
	 *  1.在数据库创建部门表和员工表，包含字段如下：
	部门表包含字段有：部门编号，部门名称(唯一且不能为空)
	员工表包含字段有：员工编号，员工姓名(唯一且不能为空)，员工性别，员工职位，员工工资，入职日期。部门编号(外键)
	 */
	public static void createTable() throws Exception{
		// 创建部门表Sql
		String sql01 = "create table dept(id int primary key auto_increment,"
				+ "dept_name varchar(20) unique not null);";
		// 创建员工表Sql
		String sql02 = "create table employee(id int primary key auto_increment,"
				+ "name varchar(20) unique not null,"
				+ "gender varchar(2),"
				+ "post varchar(20),"
				+ "salary double,"
				+ "edate date,"
				+ "deptid int,"
				+ "constraint foreign key (deptid) references dept(id))";
		
		// 获得连接对象
		Connection conn = JdbcUtil.getConnection();
		// 获得PreparedStatement对象
		Statement ps = conn.createStatement();
		// 批处理：可以同时执行多条sql
		ps.addBatch(sql01);
		ps.addBatch(sql02);
		// 创建部门表和员工表
		int[] row = ps.executeBatch();
		System.out.println(row.length);
		
		// 关闭资源
		JdbcUtil.close(conn, ps);
	}
}
