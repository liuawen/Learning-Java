package com.atguigu.test06;

import java.util.List;

import com.atguigu.test06.bean.Employee;

public class EmployeeDAOImpl extends BasicDAOImpl<Employee> implements EmployeeDAO{

	@Override
	public void addEmployee(Employee emp) {
		String sql = "INSERT INTO t_employee VALUES(NULL,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		//eid,ename,tel,gender,salary,commission_pct,birthday,hiredate,job_id,email,`mid`,address,native_place,did
		try{
			update(sql, emp.getEname(),
					emp.getTel(),
					emp.getGender(),
					emp.getSalary(),
					emp.getCommission_pct(),
					emp.getBirthday(),
					emp.getHiredate(),
					emp.getJobId(),
					emp.getEmail(),
					emp.getMid(),
					emp.getAddress(),
					emp.getNativePlace(),
					emp.getDid());
		}catch(Exception  e){
			throw new RuntimeException(e);
		}
	}

	@Override
	public void updateEmployee(Employee emp) {
		String sql = "UPDATE t_employee SET ename = ?,tel=?,gender=?,salary=?,commission_pct=?,birthday=?,hiredate=?,job_id=?,email=?,`mid`=?,address=?,native_place=?,did=? WHERE eid=?";
		try{
			update(sql, emp.getEname(),
					emp.getTel(),
					emp.getGender(),
					emp.getSalary(),
					emp.getCommission_pct(),
					emp.getBirthday(),
					emp.getHiredate(),
					emp.getJobId(),
					emp.getEmail(),
					emp.getMid(),
					emp.getAddress(),
					emp.getNativePlace(),
					emp.getDid(),
					emp.getEid());
		}catch(Exception  e){
			throw new RuntimeException(e);
		}
	}

	@Override
	public void deleteEmployeeByEid(int eid) {
		String sql = "DELETE FROM t_employee WHERE eid=?";
		try{
			update(sql, eid);
		}catch(Exception  e){
			throw new RuntimeException(e);
		}
	}

	@Override
	public Employee getByEid(int eid) {
		String sql = "SELECT eid,ename,tel,gender,salary,commission_pct,birthday,hiredate,job_id as jobId,email,`mid`,address,native_place as nativePlace,did FROM t_employee WHERE eid=?";
		Employee emp = null;
		try{
			emp = getBean(sql, eid);
		}catch(Exception  e){
			throw new RuntimeException(e);
		}
		return emp;
	}

	@Override
	public List<Employee> getAll() {
		String sql = "SELECT eid,ename,tel,gender,salary,commission_pct,birthday,hiredate,job_id,email,`mid`,address,native_place,did FROM t_employee";
		List<Employee> list = null;
		try{
			list = getBeanList(sql);
		}catch(Exception  e){
			throw new RuntimeException(e);
		}
		return list;
	}

}
