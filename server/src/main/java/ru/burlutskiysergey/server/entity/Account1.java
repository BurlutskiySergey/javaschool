package ru.burlutskiysergey.server.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.burlutskiysergey.common.Currency;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "accounts")
@NoArgsConstructor
@Getter
@Setter
public class Account1 {

    @Id
    @GeneratedValue
    private Long id;

    private String accountNum;
    private String currency;
    private BigDecimal balance;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client1 client_id;

    @OneToMany(mappedBy = "account_id")
    private Set<Card1> cards;


    public Currency getCurrency() {
        return Currency.getType(this.currency);
    }

//    public void setCurrency(Currency currency) {
//        this.currency = currency == null ? null : currency.getName();
//    }
}
