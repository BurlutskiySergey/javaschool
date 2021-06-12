package ru.burlutskiysergey.server.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "clients")
@NoArgsConstructor
@Getter
@Setter
public class Client {

    @Id
    @GeneratedValue
    private Long id;

    private int clientNum;
    private String firstName;
    private String middleName;
    private String lastName;
    private int age;

    @OneToMany(mappedBy = "client")
    private Set<Account> accounts;
}
