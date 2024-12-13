package app.dtos;

import app.entities.Customer;
import app.enums.AccountType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class CreateAccountDTO {
    private Double balance;
    private String currency;
    private AccountType type;
    private Customer customer;
}
