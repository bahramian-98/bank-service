package com.example.bank.repository;

import com.example.bank.model.bankaccount.BankAccount;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BankAccountRepository extends JpaRepository<BankAccount,Long> {

    BankAccount findByAccountNumberAndDeleted(String accountNumber, Long deleted);

    Optional<BankAccount> findByIdAndDeleted(Long id, long deleted);

    Page<BankAccount> findAllByCustomerIdAndDeleted(Long customerId, long deleted, Pageable pageable);
}
