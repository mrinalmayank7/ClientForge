package com.sunbasedata.customerhub.service;

import com.sunbasedata.customerhub.DAO.CustomerJPARepository;
import com.sunbasedata.customerhub.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImplementation implements CustomerService {
    private CustomerJPARepository customerJPAR;
    public CustomerServiceImplementation(CustomerJPARepository customerJPAR) {
        this.customerJPAR = customerJPAR;
    }

    @Override
    public List<Customer> findAll() {
        return customerJPAR.findAll();
    }
    @Override
    public Page<Customer> getAllCustomer(int page, int size, String sortBy, String sortOrder) {
        Sort.Direction direction = Sort.Direction.ASC;
        if ("desc".equalsIgnoreCase(sortOrder)) {
            direction = Sort.Direction.DESC;
        }
        if ("asc".equalsIgnoreCase(sortOrder)) {
            direction = Sort.Direction.ASC;
        }
        Sort sort = Sort.by(direction, sortBy);
        Pageable pageable = PageRequest.of(page, size, sort);
        return customerJPAR.findAllBy(pageable);
    }

    @Override
    public Customer save(Customer theCustomer) {
        return customerJPAR.save(theCustomer);
    }

    @Override
    public Customer findById(Integer id) {
        Optional<Customer> result = customerJPAR.findById(id);
        Customer theCustomer = null;
        if(result.isPresent()){
            theCustomer  = result.get();
        }
        else{
            throw new RuntimeException("CUSTOMER NOT FOUND");
        }
        return theCustomer;
    }
    @Override
    public Page<Customer>findById(Integer id, Pageable pageable) {
        return customerJPAR.findById(id, pageable);
    }

    @Override
    public void delete(Integer id) {
        customerJPAR.deleteById(id);
    }

}
