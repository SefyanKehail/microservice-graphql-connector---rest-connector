package app.dtos;

import app.entities.Customer;
import app.enums.AccountType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor @NoArgsConstructor @Builder
public class AccountDTO {
    private String id;
    private LocalDate createdAt;
    private Double balance;
    private String currency;
    private AccountType type;
    private Customer customer;

    @Override
    public String toString() {
        return "AccountDTO{" +
                "id='" + id + '\'' +
                ", createdAt=" + createdAt +
                ", balance=" + balance +
                ", currency='" + currency + '\'' +
                ", type=" + type +
                '}';
    }
}

