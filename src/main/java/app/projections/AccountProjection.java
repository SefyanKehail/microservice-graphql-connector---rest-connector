package app.projections;

import app.entities.Account;
import app.enums.AccountType;
import org.springframework.data.rest.core.config.Projection;

@Projection(types = Account.class, name = "p_id_type")
public interface AccountProjection {
    public String getId();
    public AccountType getType();
}
