package app.services;

import app.dtos.AccountDTO;
import app.dtos.CreateAccountDTO;
import app.entities.Account;
import app.mappers.AccountMapper;
import app.repositories.AccountRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
public class AccountServiceImpl implements AccountService {
    private AccountRepository accountRepository;
    private AccountMapper accountMapper;

    public AccountServiceImpl(AccountRepository accountRepository, AccountMapper accountMapper) {
        this.accountRepository = accountRepository;
        this.accountMapper = accountMapper;
    }

    @Override
    public AccountDTO addAccount(CreateAccountDTO createAccountDTO) {
        Account account = accountMapper.getAccountFromCreateAccountDTO(createAccountDTO);
        account.setId(UUID.randomUUID().toString());
        account.setCreatedAt(LocalDate.now());
        return accountMapper.getAccountDTOFromAccount(accountRepository.save(account));
    }

    @Override
    public List<AccountDTO> findAll() {
        return accountRepository.findAll().stream().map(
                (account) -> accountMapper.getAccountDTOFromAccount(account)
        ).toList();
    }

    @Override
    public AccountDTO accountById(String id) {
        Account account = accountRepository.findById(id).orElseThrow(
                () -> new RuntimeException("account not found")
        );

        return accountMapper.getAccountDTOFromAccount(account);
    }

    @Override
    public AccountDTO updateAccount(String id, CreateAccountDTO createAccountDTO) {
        Account account = accountRepository.findById(id).orElseThrow(
                () -> new RuntimeException("account not found")
        );

        if (createAccountDTO.getBalance() != null) account.setBalance(createAccountDTO.getBalance());
        if (createAccountDTO.getType() != null) account.setType(createAccountDTO.getType());
        if (createAccountDTO.getCurrency() != null) account.setCurrency(createAccountDTO.getCurrency());

        return accountMapper.getAccountDTOFromAccount(accountRepository.save(account));
    }

    @Override
    public void deleteAccount(String id){
        this.accountRepository.deleteById(id);
    }
}
