package app.web;

import app.dtos.AccountDTO;
import app.dtos.CreateAccountDTO;
import app.entities.Account;
import app.repositories.AccountRepository;
import app.services.AccountService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AccountRestController {

    private AccountRepository accountRepository;
    private AccountService accountService;

    public AccountRestController(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @GetMapping("/accounts")
    public List<Account> getAll() {
        return accountRepository.findAll();
    }

    @GetMapping("/accounts/{id}")
    public Account getById(@PathVariable String id) {
        return accountRepository.findById(id).orElseThrow(
                () -> new RuntimeException("no bank account found with this id")
        );
    }

    @PostMapping("/accounts")
    public AccountDTO create(@RequestBody CreateAccountDTO createAccountDTO) {
        return accountService.addAccount(createAccountDTO);
    }

    @PatchMapping("/accounts/{id}")
    public Account update(@PathVariable String id, @RequestBody Account bankAccount) {
        Account account = accountRepository.findById(id).orElseThrow(
                () -> new RuntimeException("no bank account with this id")
        );

        if (bankAccount.getBalance() != null) account.setBalance(bankAccount.getBalance());
        if (bankAccount.getType() != null) account.setType(bankAccount.getType());
        if (bankAccount.getCreatedAt() != null) account.setCreatedAt(bankAccount.getCreatedAt());
        if (bankAccount.getCurrency() != null) account.setCurrency(bankAccount.getCurrency());

        return accountRepository.save(account);
    }

    @DeleteMapping("/accounts/{id}")
    public void delete(@PathVariable String id) {
        accountRepository.deleteById(id);
    }
}
