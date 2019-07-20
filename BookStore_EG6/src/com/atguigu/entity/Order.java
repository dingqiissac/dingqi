package com.atguigu.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 订单
 * @author helen
 *
 */
public class Order implements Serializable{

	private static final long serialVersionUID = 1L;

	/**
	 * 订单id
	 */
	private String id;
	
	/**
	 * 订单生成时间
	 */
	private Date createTime;
	
	/**
	 * 商品总数量
	 */
	private int totalCount;
	
	/**
	 * 商品总价格
	 */
	private Double totalAmount;
	
	/**
	 * 订单状态
	 */
	private int state;
	
	/**
	 * 订单所属用户的id
	 */
	private Integer userId;

	public Order() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public Double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", createTime=" + createTime + ", totalCount=" + totalCount + ", totalAmount="
				+ totalAmount + ", state=" + state + ", userId=" + userId + "]";
	}
}
