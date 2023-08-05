package com.sunbasedata.customerhub.service;

import com.sunbasedata.customerhub.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CustomerService {
    List<Customer> findAll();
    Customer save(Customer theCustomer);
    Customer findById(Integer id);
    Page<Customer> findById(Integer id, Pageable pageable);
    void delete(Integer id);
    Page<Customer> getAllCustomer(int page, int size, String sortBy, String sortOrder);

}
