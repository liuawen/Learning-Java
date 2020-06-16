package cn.mldn.mldnboot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.mldn.mldnboot.dao.IDeptDAO;
import cn.mldn.mldnboot.service.IDeptService;
import cn.mldn.mldnboot.vo.Dept;
@Service
public class DeptServiceImpl implements IDeptService {
	@Autowired
	private IDeptDAO deptDAO ;
	@Override
	public List<Dept> list() {
		return this.deptDAO.findAll() ; 
	}

}
