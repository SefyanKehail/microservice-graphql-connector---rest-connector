package app.services;

import app.dtos.AccountDTO;
import app.dtos.CreateAccountDTO;
import app.entities.Account;

import java.util.List;

public interface AccountService {
    AccountDTO addAccount(CreateAccountDTO createAccountDTO);
    List<AccountDTO> findAll();
    AccountDTO accountById(String id);
    AccountDTO updateAccount(String id, CreateAccountDTO createAccountDTO);

    void deleteAccount(String id);
}
