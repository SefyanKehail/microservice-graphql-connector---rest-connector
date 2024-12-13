package app.web;

import app.dtos.AccountDTO;
import app.dtos.CreateAccountDTO;
import app.entities.Customer;
import app.repositories.CustomerRepository;
import app.services.AccountService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class AccountGraphQLController {
    private AccountService accountService;
    private CustomerRepository customerRepository;

    public AccountGraphQLController(
            AccountService accountService,
            CustomerRepository customerRepository
    ) {
        this.accountService = accountService;
        this.customerRepository = customerRepository;
    }

    @QueryMapping
    public List<AccountDTO> accounts() {
        return accountService.findAll();
    }

    @QueryMapping
    public List<Customer> customers() {
        return customerRepository.findAll();
    }


    @QueryMapping
    public AccountDTO accountById(@Argument String id) {
        return accountService.accountById(id);
    }

    @MutationMapping
    public AccountDTO addAccount(@Argument CreateAccountDTO createAccountDTO) {
        return accountService.addAccount(createAccountDTO);
    }

    @MutationMapping
    public AccountDTO updateAccount(@Argument String id, @Argument CreateAccountDTO createAccountDTO) {
        return accountService.updateAccount(id, createAccountDTO);
    }

    @MutationMapping
    public void deleteAccount(@Argument String id, @Argument CreateAccountDTO createAccountDTO) {
        accountService.deleteAccount(id);
    }
}
