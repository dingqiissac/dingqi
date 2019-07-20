package com.atguigu.entity;

import java.util.Date;

public class OrderAndUser {
    private String id;
    private Date createTime;
    private Integer totalCount;
    private Double totalAmount;
    private int state;
    private Integer userId;
    private String name;
    private String email;
	@Override
	public String toString() {
		return "OrderAndUser [id=" + id + ", createTime=" + createTime + ", totalCount=" + totalCount + ", totalAmount="
				+ totalAmount + ", state=" + state + ", userId=" + userId + ", name=" + name + ", email=" + email + "]";
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
	public Integer getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Integer totalCount) {
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public OrderAndUser() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
}
