package gov.nyc.doitt.orderservice.domain.primarykeys;

import java.io.Serializable;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class OrderItemPK implements Serializable {
	@Column(name="order_id")
	private long orderId;
	@Column(name="item_id")
	private long itemId;
	
	
	
	public OrderItemPK() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public OrderItemPK(long orderId, long itemId) {
		super();
		orderId = orderId;
		itemId = itemId;
	}

	@Access(AccessType.PROPERTY)
	public long getOrderId() {
		return orderId;
	}


	@Access(AccessType.PROPERTY)
	public long getItemId() {
		return itemId;
	}
	
	



	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}



	public void setItemId(long itemId) {
		this.itemId = itemId;
	}



	public boolean equals(Object object) {
        if (object instanceof OrderItemPK) {
            OrderItemPK pk = (OrderItemPK)object;
            return orderId == pk.orderId && itemId == pk.itemId;
        } else {
            return false;
        }
    }
	
}
