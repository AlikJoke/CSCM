package ru.project.cscm.base;

import org.springframework.data.repository.CrudRepository;

import ru.project.cscm.model.CscmUser;

/**
 * Интерфейс-репозиторий для операций с сущностью {@link CscmUser}.
 * 
 * @author Alimurad A. Ramazanov
 * @since 11.11.2017
 *
 */
public interface UserRepository extends CrudRepository<CscmUser, String> {

}
