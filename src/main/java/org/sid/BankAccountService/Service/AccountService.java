package org.sid.BankAccountService.Service;

import org.sid.BankAccountService.DTO.BankAccountRequestDTO;
import org.sid.BankAccountService.DTO.BankAccountResponseDTO;
import org.sid.BankAccountService.Entities.BankAccount;

public interface AccountService {
   BankAccountResponseDTO addAccount(BankAccountRequestDTO bankAccountDTO);


}
