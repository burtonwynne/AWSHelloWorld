package gov.nyc.doitt.orderservice.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="customers")
public class OrderEntity {
	private enum ORDER_STATUS{
		open, in_transit, hold, shipped, delivered;
	};
	
	@Id
	@GeneratedValue
	private long id;
	
	@Enumerated(EnumType.STRING)
	@Column(name="status")
	private ORDER_STATUS status;
	
	@Column(name="created_date")
	private Date createDate;
	
	@Column(name="last_updated")
	private Date lastModified;
	
	@ManyToOne
	@JoinColumn(name="cust_id", nullable=false)
	private CustomerEntity customer;
	
	@OneToMany
	@JoinColumn(name="order_id", referencedColumnName="id")
	protected List<OrderItemEntity> orderItems;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public ORDER_STATUS getStatus() {
		return status;
	}

	public void setStatus(ORDER_STATUS status) {
		this.status = status;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getLastModified() {
		return lastModified;
	}

	public void setLastModified(Date lastModified) {
		this.lastModified = lastModified;
	}

	public CustomerEntity getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerEntity customer) {
		this.customer = customer;
	}

	public List<OrderItemEntity> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItemEntity> orderItems) {
		this.orderItems = orderItems;
	}
}
