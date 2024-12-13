package app.entities;

import app.enums.AccountType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@NoArgsConstructor @AllArgsConstructor @Builder @Data
public class Account {
    @Id
    private String id;
    private LocalDate createdAt;
    @Column(precision = 2)
    private Double balance;
    private String currency;
    @Enumerated(EnumType.STRING)
    private AccountType type;
    @ManyToOne
    private Customer customer;


    @Override
    public String toString() {
        return "Account{" +
                "id='" + id + '\'' +
                ", createdAt=" + createdAt +
                ", balance=" + balance +
                ", currency='" + currency + '\'' +
                ", type=" + type +
                '}';
    }
}
