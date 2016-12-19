package gov.nyc.doitt.orderservice.domain;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import gov.nyc.doitt.orderservice.domain.primarykeys.OrderItemPK;

import javax.persistence.PrimaryKeyJoinColumn;


@Entity
@Table(name="order_items")
//@IdClass(OrderItemPK.class)
public class OrderItemEntity {
	/*
	@Id
	@Column(name="order_id")
	private long orderId;
	
	@Column(name="item_id")
	private long itemId;
	*/
	@EmbeddedId
	OrderItemPK key;
	
	@MapsId("orderId")
	@ManyToOne
	@JoinColumn(name="order_id", referencedColumnName="id")
	private OrderEntity order;
	
	@MapsId("itemId")
	@ManyToOne
	@JoinColumn(name="item_id", referencedColumnName="id")
	private ItemEntity item;
	
	@Column(name="quantity")
	private int quantity;
	
	
	
	public OrderItemEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public OrderItemEntity(OrderItemPK key, OrderEntity order, ItemEntity item, int quantity) {
		super();
		this.key = key;
		this.order = order;
		this.item = item;
		this.quantity = quantity;
	}



	/*
	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public long getItemId() {
		return itemId;
	}

	public void setItemId(long itemId) {
		this.itemId = itemId;
	}
	*/
	public OrderEntity getOrder() {
		return order;
	}

	public void setOrder(OrderEntity order) {
		this.order = order;
	}

	public ItemEntity getItem() {
		return item;
	}

	public void setItem(ItemEntity item) {
		this.item = item;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
}
