package cn.mldn.mldnboot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.mldn.mldnboot.dao.IDeptDAO;
import cn.mldn.mldnboot.po.Dept;
import cn.mldn.mldnboot.service.IDeptService;
@Service
public class DeptServiceImpl implements IDeptService {
	@Autowired
	private IDeptDAO deptDAO ;
	@Override
	public List<Dept> list() {
		return this.deptDAO.findAll() ; 
	}

}
