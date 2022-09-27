package com.sunder.calm001.repo;

import com.sunder.calm001.entity.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepo  extends  CrudRepository<Customer, Long> {
}
