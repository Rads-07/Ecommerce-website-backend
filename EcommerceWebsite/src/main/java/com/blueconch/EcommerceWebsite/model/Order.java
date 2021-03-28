package com.blueconch.EcommerceWebsite.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="orders")
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="order_id")
	private int orderId;
	
	@Column(name="order_no")
	private int orderNo;
	
	@Column(name="user_id")
	private int userId;
	
	@Column(name="discount_id", nullable=true)
	private Integer discountId;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="order_date", insertable=false)
	private Date orderDate;
	
	@Column(name="shipping_date")
	private Date shippingDate;
	
	@Column(name="stage_of_order")
	private String stageOfOrder;
	
	@Column(name="total_amount")
	private String totalAmount;
	
	@Column(name="is_delivered")
	private boolean isDelivered;

	public Order() {
	}

	public Order(int orderId, int orderNo, int userId, Integer discountId, Date orderDate, Date shippingDate,
			String stageOfOrder, String totalAmount, boolean isDelivered) {
		super();
		this.orderId = orderId;
		this.orderNo = orderNo;
		this.userId = userId;
		this.discountId = discountId;
		this.orderDate = orderDate;
		this.shippingDate = shippingDate;
		this.stageOfOrder = stageOfOrder;
		this.totalAmount = totalAmount;
		this.isDelivered = isDelivered;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public Integer getDiscountId() {
		return discountId;
	}

	public void setDiscountId(Integer discountId) {
		this.discountId = discountId;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public Date getShippingDate() {
		return shippingDate;
	}

	public void setShippingDate(Date shippingDate) {
		this.shippingDate = shippingDate;
	}

	public String getStageOfOrder() {
		return stageOfOrder;
	}

	public void setStageOfOrder(String stageOfOrder) {
		this.stageOfOrder = stageOfOrder;
	}

	public String getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(String totalAmount) {
		this.totalAmount = totalAmount;
	}

	public boolean isDelivered() {
		return isDelivered;
	}

	public void setDelivered(boolean isDelivered) {
		this.isDelivered = isDelivered;
	}

}
