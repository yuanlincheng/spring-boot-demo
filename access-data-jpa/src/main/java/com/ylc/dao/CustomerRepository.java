package com.ylc.dao;

import com.ylc.model.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @author: tree
 * @version: 1.0
 * date: 2017/12/27 22:13
 * @description: xxx
 * own: Aratek
 */
public interface CustomerRepository extends CrudRepository<Customer,Long> {
    List<Customer> findByLastName(String lastName);
}
