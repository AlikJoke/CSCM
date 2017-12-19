package ru.project.cscm.base;

import org.springframework.data.repository.CrudRepository;

import ru.project.cscm.model.Request;

public interface RequestRepository extends CrudRepository<Request, Integer> {

}
