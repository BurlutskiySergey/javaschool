package ru.burlutskiysergey.server.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.burlutskiysergey.server.entity.Card1;

@Repository
public interface CardCrudRepository extends CrudRepository<Card1, Long> {
}
