package cn.mldn.mldnboot.po;

import java.io.Serializable;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@SuppressWarnings("serial")
@Cacheable(true) 
@Entity
public class Dept implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 根据名称引用配置的主键生成器
	private Long deptno; // 字段的映射（属性名称=字段名称）
	private String dname;

	// setter、getter略
	public Dept() {
	}

	public Long getDeptno() {
		return this.deptno;
	}

	public void setDeptno(Long deptno) {
		this.deptno = deptno;
	}


	public String getDname() {
		return this.dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	
}