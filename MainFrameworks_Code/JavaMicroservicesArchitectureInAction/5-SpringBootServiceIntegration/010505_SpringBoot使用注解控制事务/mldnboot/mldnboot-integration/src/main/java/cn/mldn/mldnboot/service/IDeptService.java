package cn.mldn.mldnboot.service;

import java.util.List;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.mldn.mldnboot.po.Dept;

public interface IDeptService {
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<Dept> list();
}
