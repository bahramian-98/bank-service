package com.example.bank.service;

import com.example.bank.exception.BankException;
import com.example.bank.mapper.BankAccountMapper;
import com.example.bank.model.BankAccount;
import com.example.bank.repository.BankAccountRepository;
import com.example.bank.requestdto.BankAccountRequestDTO;
import com.example.bank.responsedto.BankAccountResponseDTO;
import com.example.bank.service.core.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BankAccountService extends BaseService<BankAccount, BankAccountRequestDTO, BankAccountResponseDTO> {

    private final BankAccountRepository bankAccountRepository;
    private final BankAccountMapper bankAccountMapper;
    private final CustomerService customerService;

    @Autowired
    BankAccountService(BankAccountRepository bankAccountRepository,
                       BankAccountMapper bankAccountMapper,
                       @Lazy CustomerService customerService) {

        super(bankAccountMapper, bankAccountRepository);
        this.bankAccountRepository = bankAccountRepository;
        this.bankAccountMapper = bankAccountMapper;

        this.customerService = customerService;
    }

    public BankAccount findByIdThrowable(Long id) {
        Optional op = findByIdNotDeleted(id);
        if (!op.isPresent()) {
            throw new BankException("حساب بانکی، یافت نشد!");
        }
        return (BankAccount) op.get();
    }

    public Optional<BankAccount> findByIdNotDeleted(Long id) {
        return bankAccountRepository.findByIdAndDeleted(id, 0L);
    }

    /**
     *   ثبت حساب بانکی برای مشتری
     */
    @Override
    public Long save(BankAccountRequestDTO bankAccountRequestDTO) {
        try{

            Long requestCustomerId = bankAccountRequestDTO.getCustomerId();
            customerService.findByIdThrowable(requestCustomerId);

            String accountNumber = bankAccountRequestDTO.getAccountNumber();
            BankAccount bankAccount = bankAccountRepository.findByAccountNumberAndDeleted(accountNumber, 0L);
            boolean isThereBankAccount = bankAccount != null;
            boolean checkBankAccount;
            Long id = bankAccountRequestDTO.getId();
            if(id == null || id.equals(0L)){
                checkBankAccount = isThereBankAccount;
            }else{
                checkBankAccount = isThereBankAccount && !(id.equals(requestCustomerId));
            }
            if(checkBankAccount){
                throw new BankException("این شماره حساب قبلا ثبت شده است!");
            }

            return super.save(bankAccountRequestDTO);

        }catch (BankException e){
            throw e;
        }catch (Exception e){
            throw new BankException("خطا در ثبت حساب بانکی!");
        }

    }

    public Page<BankAccountResponseDTO> findByCustomerId(Long customerId, Pageable pageable) {

        if(customerId == null || customerId.equals(0L)){
            throw new BankException("شناسه مشتری، مشخص نشده است!");
        }
        Page<BankAccount> bankAccounts = bankAccountRepository.findAllByCustomerIdAndDeleted(customerId, 0l, pageable);
        return bankAccountMapper.toDTO(bankAccounts);
    }
}
