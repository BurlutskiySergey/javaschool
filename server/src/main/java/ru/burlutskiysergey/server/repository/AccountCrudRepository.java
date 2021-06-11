package ru.burlutskiysergey.server.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.burlutskiysergey.server.entity.Account1;

@Repository
public interface AccountCrudRepository extends CrudRepository<Account1, Long> {
}
