package org.sid.BankAccountService.Web;

import org.sid.BankAccountService.DTO.BankAccountRequestDTO;
import org.sid.BankAccountService.DTO.BankAccountResponseDTO;
import org.sid.BankAccountService.Entities.BankAccount;
import org.sid.BankAccountService.Mapper.AccountMapper;
import org.sid.BankAccountService.Repositories.BankAccountRepository;
import org.sid.BankAccountService.Service.AccountService;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class AccountRestController {
    private BankAccountRepository bankAccountRepository;
    private AccountService accountService;
    private AccountMapper accountMapper;

     public AccountRestController(BankAccountRepository bankAccountRepository, AccountService accountService, AccountMapper accountMapper){
         this.bankAccountRepository=bankAccountRepository;
         this.accountService=accountService;
         this.accountMapper=accountMapper;

     }
     //Consulter avec la liste des comptes
     @GetMapping("/bankAccounts")
     public List<BankAccount>bankAccounts(){
       return bankAccountRepository.findAll();
     }
    @GetMapping("/bankAccounts/{id}")
    public BankAccount bankAccount(@PathVariable String id){
        return bankAccountRepository.findById(id)
                .orElseThrow(()->new RuntimeException(String.format("Account %s not found",id)));

    }
    @PostMapping("/bankAccounts")
    public BankAccountResponseDTO save(@RequestBody BankAccountRequestDTO requestDTO){
        return accountService.addAccount(requestDTO);
    }
    @PutMapping("/bankAccounts{id}")
    public BankAccount update(@PathVariable String id,@RequestBody BankAccount bankAccount){
         BankAccount account=bankAccountRepository.findById(id).orElseThrow();
         if (bankAccount.getBalance()!=null) account.setBalance(bankAccount.getBalance());
         if (bankAccount.getCreatedAt()!=null) account.setCreatedAt(new Date());
         if (bankAccount.getType()!=null) account.setType(bankAccount.getType());
         if (bankAccount.getCurrency()!=null) account.setCurrency(bankAccount.getCurrency());
        return bankAccountRepository.save(account);
    }
    @DeleteMapping("/bankAccounts/{id}")
    public void deleteAccount(@PathVariable String id){
         bankAccountRepository.deleteById(id);
    }
}
