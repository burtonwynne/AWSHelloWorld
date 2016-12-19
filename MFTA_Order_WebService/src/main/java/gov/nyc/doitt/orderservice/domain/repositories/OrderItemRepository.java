package gov.nyc.doitt.orderservice.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import gov.nyc.doitt.orderservice.domain.OrderItemEntity;

public interface OrderItemRepository extends JpaRepository<OrderItemEntity, Long> {

}
