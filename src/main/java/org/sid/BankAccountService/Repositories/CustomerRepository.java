package org.sid.BankAccountService.Repositories;

import org.sid.BankAccountService.Entities.BankAccount;
import org.sid.BankAccountService.Entities.Customer;
import org.sid.BankAccountService.Enums.AccountType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource
public interface CustomerRepository extends JpaRepository<Customer,Long> {

}
