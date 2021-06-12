package ru.burlutskiysergey.server.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.burlutskiysergey.server.entity.Account;

@Repository
public interface AccountCrudRepository extends CrudRepository<Account, Long> {
}
