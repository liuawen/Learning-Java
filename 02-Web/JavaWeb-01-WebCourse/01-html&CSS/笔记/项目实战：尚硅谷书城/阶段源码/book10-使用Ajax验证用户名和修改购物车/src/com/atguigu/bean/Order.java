package com.atguigu.bean;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 订单模型
 * 
 * @author wzg
 *
 */
public class Order {
	// 订单号
	private String orderId;
	// 订单生成的时间
	private Date createTime;
	// 订单的总价
	private BigDecimal totalMoney;
	// 0-未发货、1-等待用户签收、2-用户已签收
	private int status;
	// 用户编号
	private int userId;

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Order(String orderId, Date createTime, BigDecimal totalMoney, int status, int userId) {
		super();
		this.orderId = orderId;
		this.createTime = createTime;
		this.totalMoney = totalMoney;
		this.status = status;
		this.userId = userId;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public BigDecimal getTotalMoney() {
		return totalMoney;
	}

	public void setTotalMoney(BigDecimal totalMoney) {
		this.totalMoney = totalMoney;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", createTime=" + createTime + ", totalMoney="
				+ totalMoney + ", status=" + status + ", userId=" + userId + "]";
	}

}
