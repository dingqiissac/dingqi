package com.atguigu.entity;

public class CartItem {
	private Book book;
	private int quantity;
	private Double price;
	private Double totalAmount;
	
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Double getPrice() {
		return this.book.getPrice();
	}
	/*public void setPrice(Double price) {
		this.price = price;
	}*/
	public Double getTotalAmount() {
		return this.book.getPrice()*this.quantity;
	}
	/*public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}*/
	@Override
	public String toString() {
		return "CartItem [book=" + book + ", quantity=" + quantity + ", price=" + price + ", totalAmount=" + totalAmount
				+ "]";
	}
	public CartItem() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
