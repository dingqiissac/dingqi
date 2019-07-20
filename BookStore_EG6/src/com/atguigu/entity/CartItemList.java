package com.atguigu.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.druid.sql.dialect.mysql.visitor.transform.FromSubqueryResolver;

public class CartItemList {
	private Map<Integer,CartItem> m = new LinkedHashMap<>();
	private int countNumber;
	private Double allAmount;
	public CartItemList() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Map<Integer, CartItem> getM() {
		return m;
	}
	public void setM(Map<Integer, CartItem> m) {
		this.m = m;
	}
	public int getCountNumber() {
		Collection<CartItem> values = this.m.values();
		ArrayList<CartItem> l = new ArrayList<>(values);
		int count = 0;
		for (CartItem cartItem : l) {
			count+=cartItem.getQuantity();
		}
		return count;
	}
	/*public void setCountNumber(int countNumber) {
		
		this.countNumber = countNumber;
	}*/
	public Double getAllAmount() {
		Collection<CartItem> values = this.m.values();
		ArrayList<CartItem> l = new ArrayList<>(values);
		Double price = 0.0;
		for (CartItem cartItem : l) {
			price+=cartItem.getTotalAmount();
		}
		return price;
	}
	/*public void setAllAmount(Double allAmount) {
		this.allAmount = allAmount;
	}*/
	
	public List<CartItem> getList(){
		
	return new ArrayList<CartItem>(this.m.values());
		
	}
	@Override
	public String toString() {
		return "CartItemList [m=" + m + ", countNumber=" + countNumber + ", allAmount=" + allAmount + "]";
	}
	
	
}
