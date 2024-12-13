package app;

import app.entities.Account;
import app.entities.Customer;
import app.enums.AccountType;
import app.repositories.AccountRepository;
import app.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.Random;
import java.util.UUID;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@SpringBootApplication
public class EbankMicroserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(EbankMicroserviceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(AccountRepository accountRepository, CustomerRepository customerRepository) {
        return args -> {
            Random random = new Random();

            Stream.of("John", "Karim", "Hamza","Imane", "Salma").forEach(
                    (name) -> {
                        Customer customer = Customer.builder()
                                .name(name).build();

                        customerRepository.save(customer);


                        IntStream.range(0, 10)
                                .forEach(a -> {
                                    Account account = (new Account());

                                    account.setId(UUID.randomUUID().toString());
                                    account.setBalance(random.nextDouble() * 10000);
                                    account.setCreatedAt(LocalDate.now());
                                    account.setCurrency("MAD");
                                    account.setType(
                                            random.nextDouble() > 0.5 ? AccountType.CURRENT_ACCOUNT : AccountType.SAVING_ACCOUNT);
                                    account.setCustomer(customer);
                                    accountRepository.save(account);
                                });
                    }
            );



        };
    }
}
