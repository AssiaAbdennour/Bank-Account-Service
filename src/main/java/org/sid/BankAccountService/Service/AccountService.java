package org.sid.BankAccountService.Service;

import org.sid.BankAccountService.DTO.BankAccountRequestDTO;
import org.sid.BankAccountService.DTO.BankAccountResponseDTO;
import org.sid.BankAccountService.Entities.BankAccount;

public interface AccountService {
   BankAccountResponseDTO addAccount(BankAccountRequestDTO bankAccountDTO);


   /* BankAccountResponseDTO bankAccountResponseDTO=BankAccountResponseDTO.builder()
            .id(saveBankAccount.getId())
            .balance(saveBankAccount.getBalance())
            .createdAt(saveBankAccount.getCreatedAt())
            .currency(saveBankAccount.getCurrency())
            .type(saveBankAccount.getType())
            .build();
    */
   BankAccountResponseDTO updateAccount(String id, BankAccountRequestDTO bankAccountDTO);
}
