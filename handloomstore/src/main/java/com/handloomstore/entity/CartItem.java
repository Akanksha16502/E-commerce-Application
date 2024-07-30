package com.handloomstore.entity;



import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class CartItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private int quantity;

	@Column(name = "mrp_price", nullable = false)
	private double mrpPrice;

	
	
	// Mappings
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id")
	@JsonBackReference
	//@JsonIgnoreProperties
	private User user;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "product_id")
	//@JsonBackReference
	private Product product;

	
	 //Getters and Setters
	public int getId() {
		return id;
	}

	public CartItem(int id, int quantity, double mrpPrice, User user, Product product) {
		super();
		this.id = id;
		this.quantity = quantity;
		this.mrpPrice = mrpPrice;
		this.user = user;
		this.product = product;
	}
//
//	@Override
//	public String toString() {
//		return "CartItem [id=" + id + ", quantity=" + quantity + ", mrpPrice=" + mrpPrice + ", user=" + user
//				+ ", product=" + product + "]";
//	}

	public void setId(int id) {
		this.id = id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getMrpPrice() {
		return mrpPrice;
	}

	public void setMrpPrice(double mrpPrice) {
		this.mrpPrice = mrpPrice;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public CartItem() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
   
	

	
}
