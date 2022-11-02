package org.sid.BankAccountService.Service;

import org.sid.BankAccountService.DTO.BankAccountRequestDTO;
import org.sid.BankAccountService.DTO.BankAccountResponseDTO;
import org.sid.BankAccountService.Entities.BankAccount;
import org.sid.BankAccountService.Mapper.AccountMapper;
import org.sid.BankAccountService.Repositories.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.UUID;

@Service
@Transactional
public class AccountServiceImpl implements AccountService{

    @Autowired
    private BankAccountRepository bankAccountRepository;
    @Autowired
    private AccountMapper accountMapper;
    @Override
    public BankAccountResponseDTO addAccount(BankAccountRequestDTO bankAccountDTO){

        BankAccount bankAccount=BankAccount.builder()
                .id(UUID.randomUUID().toString())
                .createdAt(new Date())
                .balance(bankAccountDTO.getBalance())
                .type(bankAccountDTO.getType())
                .currency(bankAccountDTO.getCurrency())
                .build();

       BankAccount saveBankAccount= bankAccountRepository.save(bankAccount);
        BankAccountResponseDTO bankAccountResponseDTO = accountMapper.fromBankAccount(saveBankAccount);
        return bankAccountResponseDTO;
    }
         /* BankAccountResponseDTO bankAccountResponseDTO=BankAccountResponseDTO.builder()
               .id(saveBankAccount.getId())
               .balance(saveBankAccount.getBalance())
               .createdAt(saveBankAccount.getCreatedAt())
               .currency(saveBankAccount.getCurrency())
               .type(saveBankAccount.getType())
               .build();
       */
    @Override
         public BankAccountResponseDTO updateAccount(String id,BankAccountRequestDTO bankAccountDTO){

             BankAccount bankAccount=BankAccount.builder()
                     .id(id)
                     .createdAt(new Date())
                     .balance(bankAccountDTO.getBalance())
                     .type(bankAccountDTO.getType())
                     .currency(bankAccountDTO.getCurrency())
                     .build();

             BankAccount saveBankAccount= bankAccountRepository.save(bankAccount);
             BankAccountResponseDTO bankAccountResponseDTO = accountMapper.fromBankAccount(saveBankAccount);
             return bankAccountResponseDTO;
         }

}
