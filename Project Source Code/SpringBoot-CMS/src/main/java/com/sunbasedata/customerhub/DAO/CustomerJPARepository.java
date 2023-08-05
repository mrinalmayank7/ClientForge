package com.sunbasedata.customerhub.DAO;

import com.sunbasedata.customerhub.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CustomerJPARepository extends JpaRepository <Customer,Integer>{
    Page<Customer> findAllBy(Pageable pageable);
    Page<Customer> findById(int id, Pageable pageable);

}
