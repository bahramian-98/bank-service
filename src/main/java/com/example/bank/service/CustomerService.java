package com.example.bank.service;

import com.example.bank.exception.BankException;
import com.example.bank.mapper.CustomerMapper;
import com.example.bank.model.Customer;
import com.example.bank.repository.CustomerRepository;
import com.example.bank.requestdto.CustomerRequestDTO;
import com.example.bank.responsedto.CustomerResponseDTO;
import com.example.bank.service.core.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class CustomerService extends BaseService<Customer, CustomerRequestDTO, CustomerResponseDTO> {

    private final CustomerRepository customerRepository;
    private final BankAccountService bankAccountService;
    private final CustomerMapper customerMapper;

    @Autowired
    public CustomerService(CustomerRepository customerRepository,
                           @Lazy BankAccountService bankAccountService,
                           CustomerMapper customerMapper) {

        super(customerMapper, customerRepository);
        this.customerRepository = customerRepository;
        this.bankAccountService = bankAccountService;
        this.customerMapper = customerMapper;
    }


    /**
     *  ثبت مشتری
     */
    @Override
    @Transactional
    public Long save(CustomerRequestDTO customerRequestDTO) {
        try{

            Customer customer = findByNationalCodeAndDeleted(customerRequestDTO.getNationalCode(),0l);
            boolean isThereCustomer = customer != null;
            boolean checkNationalCode;
            Long id = customerRequestDTO.getId();
            if(id == null || id.equals(0l)){
                checkNationalCode = isThereCustomer;
            }else{
                checkNationalCode = isThereCustomer && !(customer.getId().equals(id));
            }
            if (checkNationalCode) {
                throw new BankException("مشتری با این کد ملی، قبلا ثبت شده است!");
            }

            return super.save(customerRequestDTO);

        }catch (BankException e){
            throw e;
        }catch (Exception e){
            throw new BankException("خطا در ثبت مشتری!");
        }

    }

    private Customer findByNationalCodeAndDeleted(String nationalCode, long deleted) {

        Optional<Customer> op = customerRepository.findByNationalCodeAndDeleted(nationalCode, deleted);
        if(!op.isPresent()){
            return  null;
        }
        return op.get();

    }

    public Page<CustomerResponseDTO> findByNationalCode(String nationalCode, Pageable pageable) {

        if(nationalCode.isEmpty()){
            throw new BankException("کد ملی، مشخص نشده است!");
        }
        Page<Customer> customers = customerRepository.findAllByNationalCodeAndDeleted(nationalCode, 0l, pageable);
        return customerMapper.toDTO(customers);

    }

    public Customer findByIdThrowable(Long id) {
        Optional op = findByIdNotDeleted(id);
        if (!op.isPresent()) {
            throw new BankException("مشتری با این شناسه، یافت نشد!");
        }
        return (Customer) op.get();
    }

    public Optional<Customer> findByIdNotDeleted(Long id) {
        return customerRepository.findByIdAndDeleted(id, 0L);
    }
}
