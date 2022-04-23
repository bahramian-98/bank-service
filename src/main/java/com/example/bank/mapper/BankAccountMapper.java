package com.example.bank.mapper;

import com.example.bank.mapper.core.BaseMapper;
import com.example.bank.model.bankaccount.BankAccount;
import com.example.bank.model.bankaccount.BankAccountRequestDTO;
import com.example.bank.model.bankaccount.BankAccountResponseDTO;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class BankAccountMapper implements BaseMapper<BankAccount, BankAccountRequestDTO, BankAccountResponseDTO> {

    private  final CustomerMapper customerMapper;

    public BankAccountMapper(@Lazy CustomerMapper customerMapper) {
        this.customerMapper = customerMapper;
    }

    @Override
    public BankAccount toEntity(BankAccountRequestDTO bankAccountRequestDTO) {
        BankAccount bankAccount = new BankAccount();
        this.toEntity(bankAccountRequestDTO, bankAccount);
        return bankAccount;
    }

    @Override
    public void toEntity(BankAccountRequestDTO bankAccountRequestDTO, BankAccount bankAccount){

        bankAccount.setId(bankAccountRequestDTO.getId());
        bankAccount.setAccountNumber(bankAccountRequestDTO.getAccountNumber());
        bankAccount.setAccountType(bankAccountRequestDTO.getAccountType());
        bankAccount.setCustomer(customerMapper.toLimitedEntity(bankAccountRequestDTO.getCustomerId()));

    }

    @Override
    public BankAccountResponseDTO toDTO(BankAccount bankAccount) {
        BankAccountResponseDTO bankAccountResponseDTO = BankAccountResponseDTO.builder().build();
        this.toDTO(bankAccount, bankAccountResponseDTO);
        return bankAccountResponseDTO;
    }

    @Override
    public void toDTO(BankAccount bankAccount, BankAccountResponseDTO bankAccountResponseDTO){

        bankAccountResponseDTO.setId(bankAccount.getId());
        bankAccountResponseDTO.setAccountNumber(bankAccount.getAccountNumber());
        bankAccountResponseDTO.setAccountType(toPersianName(bankAccount.getAccountType()));
        bankAccountResponseDTO.setCustomerResponseDTO(customerMapper.toDTO(bankAccount.getCustomer()));

        setBaseField(bankAccountResponseDTO, bankAccount);
    }


    public String toPersianName(BankAccount.AccountType accountType) {

        if(accountType == null){
            return null;
        }
        String persianName = null;
        switch (accountType){
            case DEPOSIT:
                persianName = "سپرده";
                break;
            case LOAN:
                persianName =  "قرض الحسنه";
                break;
        }
        return persianName == null ? accountType.toString() : persianName;
    }

}
