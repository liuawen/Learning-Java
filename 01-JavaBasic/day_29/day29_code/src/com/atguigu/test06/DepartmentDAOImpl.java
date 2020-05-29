package com.atguigu.test06;

import java.sql.SQLException;
import java.util.List;

import com.atguigu.test06.bean.Department;

public class DepartmentDAOImpl extends BasicDAOImpl<Department> implements DepartmentDAO{

	@Override
	public void addDepartment(Department dept) {
		String sql = "INSERT INTO `t_department` VALUES(NULL,?,?)";
		try {
			update(sql, dept.getDname(), dept.getDescription());
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void updateDepartment(Department dept) {
		String sql = "UPDATE t_department SET dname=?,description=? WHERE did = ?";
		try {
			update(sql, dept.getDname(), dept.getDescription(), dept.getDid());
		} catch (Exception e){
			throw new RuntimeException(e);
		}
	}

	@Override
	public void deleteDepartmentByDid(int did) {
		String sql = "DELETE FROM t_department WHERE did = ?";
		try {
			update(sql, did);
		} catch (Exception e){
			throw new RuntimeException(e);
		}
	}

	@Override
	public Department getById(int did) {
		String sql = "SELECT did,dname,description FROM t_department WHERE did = ?";
		Department t = null;
		try {
			t = getBean(sql, did);
		} catch (Exception e){
			throw new RuntimeException(e);
		}
		return t;
	}

	@Override
	public List<Department> getAll() {
		String sql = "SELECT did,dname,description FROM t_department";
		List<Department> list = null;
		try{
			list = getBeanList(sql);
		} catch (Exception e){
			throw new RuntimeException(e);
		}
		return list;
	}

}
