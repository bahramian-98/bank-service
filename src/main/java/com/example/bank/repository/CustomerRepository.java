package com.example.bank.repository;

import com.example.bank.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {

    Page<Customer> findAllByNationalCodeAndDeleted(String nationalCode, Long deleted, Pageable Pageable);
    Optional<Customer> findByNationalCodeAndDeleted(String nationalCode, Long deleted);
    Optional<Customer> findByIdAndDeleted(Long id, long deleted);
}
