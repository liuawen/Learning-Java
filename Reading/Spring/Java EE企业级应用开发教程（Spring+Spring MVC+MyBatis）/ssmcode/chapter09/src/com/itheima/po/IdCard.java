package com.itheima.po;
/**
 * 证件持久化类
 */
public class IdCard {
	private Integer id;
	private String code;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	@Override
	public String toString() {
		return "IdCard [id=" + id + ", code=" + code + "]";
	}
}
