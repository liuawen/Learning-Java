package cn.mldn.mldnboot.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import cn.mldn.mldnboot.vo.Dept;

@Mapper
public interface IDeptDAO {
	@Select("SELECT deptno,dname FROM dept")
	public List<Dept> findAll() ;				// 查询全部部门信息
}