package app.mappers;

import app.dtos.AccountDTO;
import app.dtos.CreateAccountDTO;
import app.entities.Account;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class AccountMapper {
    public AccountDTO getAccountDTOFromAccount(Account account){
        AccountDTO accountDTO = new AccountDTO();
        BeanUtils.copyProperties(account, accountDTO);
        System.out.println(accountDTO);
        return accountDTO;
    }

    public Account getAccountFromAccountDTO(AccountDTO accountDTO){
        Account account = new Account();
        BeanUtils.copyProperties(accountDTO, account);
        return account;
    }
    public CreateAccountDTO getCreateAccountDTOFromAccount(Account account){
        CreateAccountDTO createAccountDTO = new CreateAccountDTO();
        BeanUtils.copyProperties(account, createAccountDTO);
        return createAccountDTO;
    }

    public Account getAccountFromCreateAccountDTO(CreateAccountDTO createAccountDTO){
        Account account = new Account();
        System.out.println(account);
        System.out.println(createAccountDTO);
        BeanUtils.copyProperties(createAccountDTO, account);
        System.out.println(createAccountDTO);
        System.out.println(account);
        return account;
    }

}
