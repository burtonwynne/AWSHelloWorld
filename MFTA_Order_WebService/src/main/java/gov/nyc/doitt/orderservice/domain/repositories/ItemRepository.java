package gov.nyc.doitt.orderservice.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import gov.nyc.doitt.orderservice.domain.ItemEntity;

public interface ItemRepository extends JpaRepository<ItemEntity, Long> {

}
