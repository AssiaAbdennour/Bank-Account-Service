package org.sid.BankAccountService.Web;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sid.BankAccountService.DTO.BankAccountRequestDTO;
import org.sid.BankAccountService.DTO.BankAccountResponseDTO;
import org.sid.BankAccountService.Entities.BankAccount;
import org.sid.BankAccountService.Entities.Customer;
import org.sid.BankAccountService.Repositories.BankAccountRepository;
import org.sid.BankAccountService.Repositories.CustomerRepository;
import org.sid.BankAccountService.Service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;


import java.util.List;

@Controller
public class BankAccountGraphQLController {
    @Autowired
    private BankAccountRepository bankAccountRepository;
    @Autowired
    private AccountService accountService;
    @Autowired
    private CustomerRepository customerRepository;
    @QueryMapping
    public List<BankAccount> accountsList(){
        return bankAccountRepository.findAll();
    }

    @QueryMapping
    public BankAccount bankAccountById(@Argument String id){
        return bankAccountRepository.findById(id)
                .orElseThrow(()->new RuntimeException(String.format("Account %s not found",id)));
    }
    @MutationMapping
    public BankAccountResponseDTO addAccount(@Argument BankAccountRequestDTO bankAccount){
        return accountService.addAccount(bankAccount);
    }
    @MutationMapping
    public BankAccountResponseDTO updateAccount(@Argument String id, @Argument BankAccountRequestDTO bankAccount){
        return accountService.updateAccount(id,bankAccount);
    }
    @MutationMapping
    public Boolean deleteAccount(@Argument String id){
        bankAccountRepository.deleteById(id);
        return true;
    }
    @QueryMapping
    public List<Customer>customers(){
      return customerRepository.findAll();
    }
}
   // record BankAccountDTO (Double balance,String type, String currency ){}
@Data @NoArgsConstructor @AllArgsConstructor
class BankAccountDTO{
    private Double balance;
    private String type;
    private String currency;
}



