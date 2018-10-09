package com.capgemini.orderapp.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "orderstable")
public class Order {

		@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", products=" + products + ", customerId=" + customerId + ", orderDate="
				+ orderDate + "]";
	}
		@Id
		private int orderId;
		private int products;
		private int customerId;
		@DateTimeFormat(pattern = "yyyy-MM-dd")
		private LocalDate orderDate;
		public Order() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Order(int orderId, int products, int customerId, LocalDate orderDate) {
			super();
			this.orderId = orderId;
			this.products = products;
			this.customerId = customerId;
			this.orderDate = orderDate;
		}
		public int getOrderId() {
			return orderId;
		}
		public void setOrderId(int orderId) {
			this.orderId = orderId;
		}
		public int getProducts() {
			return products;
		}
		public void setProducts(int products) {
			this.products = products;
		}
		public int getCustomerId() {
			return customerId;
		}
		public void setCustomerId(int customerId) {
			this.customerId = customerId;
		}
		public LocalDate getOrderDate() {
			return orderDate;
		}
		public void setOrderDate(LocalDate orderDate) {
			this.orderDate = orderDate;
		}
		
}
