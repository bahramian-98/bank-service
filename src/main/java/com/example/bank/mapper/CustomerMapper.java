package com.example.bank.mapper;

import com.example.bank.mapper.core.BaseMapper;
import com.example.bank.model.Customer;
import com.example.bank.requestdto.CustomerRequestDTO;
import com.example.bank.responsedto.CustomerResponseDTO;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper implements BaseMapper<Customer, CustomerRequestDTO, CustomerResponseDTO> {

    @Override
    public Customer toEntity(CustomerRequestDTO customerRequestDTO) {
        Customer customer = new Customer();
        this.toEntity(customerRequestDTO, customer);
        return customer;
    }

    @Override
    public void toEntity(CustomerRequestDTO customerRequestDTO, Customer customer) {

        customer.setId(customerRequestDTO.getId());
        customer.setFirstName(customerRequestDTO.getFirstName());
        customer.setLastName(customerRequestDTO.getLastName());
        customer.setNationalCode(customerRequestDTO.getNationalCode());
        customer.setMobileNumber(customerRequestDTO.getMobileNumber());
        customer.setAddress(customerRequestDTO.getAddress());
    }

    @Override
    public CustomerResponseDTO toDTO(Customer customer) {

            CustomerResponseDTO customerResponseDTO = CustomerResponseDTO.builder().build();
            this.toDTO(customer, customerResponseDTO);
            return customerResponseDTO;
    }

    @Override
    public void toDTO(Customer customer, CustomerResponseDTO customerResponseDTO){

        customerResponseDTO.setId(customer.getId());
        customerResponseDTO.setFirstName(customer.getFirstName());
        customerResponseDTO.setLastName(customer.getLastName());
        customerResponseDTO.setNationalCode(customer.getNationalCode());
        customerResponseDTO.setMobileNumber(customer.getMobileNumber());
        customerResponseDTO.setAddress(customer.getAddress());

        setBaseField(customerResponseDTO, customer);
    }

    public Customer toLimitedEntity(Long id){
        if(id == null || id.equals(0l)){
            return null;
        }
        Customer customer = new Customer();
        customer.setId(id);
        return customer;
    }

    }
