package gov.nyc.doitt.orderservice.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import gov.nyc.doitt.orderservice.domain.CustomerEntity;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {

}
