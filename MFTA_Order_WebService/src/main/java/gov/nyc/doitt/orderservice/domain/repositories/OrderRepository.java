package gov.nyc.doitt.orderservice.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import gov.nyc.doitt.orderservice.domain.OrderEntity;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {

}
