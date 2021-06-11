package ru.burlutskiysergey.server.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.burlutskiysergey.server.entity.Client1;

@Repository
public interface ClientCrudRepository extends CrudRepository<Client1, Long> {
}