package com.atguigu.entity;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 订单项
 * @author helen
 *
 */
public class OrderItem implements Serializable{

	private static final long serialVersionUID = 1L;
	
	
	private Integer id;
	
	/**
	 * 图书相关信息
	 */
	private String title;
	private String author;
	private Double price;
	private String imgPath;
	
	/**
	 * 购买时的商品数量
	 */
	private int count;
	
	/**
	 * 商品总金额
	 */
	private Double amount;
	
	/**
	 * 订单id
	 */
	private String orderId;

	public OrderItem() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	@Override
	public String toString() {
		return "OrderItem [id=" + id + ", title=" + title + ", author=" + author + ", price=" + price + ", imgPath="
				+ imgPath + ", count=" + count + ", amount=" + amount + ", orderId=" + orderId + "]";
	}
}
