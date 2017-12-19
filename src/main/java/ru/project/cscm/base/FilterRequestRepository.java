package ru.project.cscm.base;

import org.springframework.data.repository.CrudRepository;

import ru.project.cscm.model.FilterRequest;

public interface FilterRequestRepository extends CrudRepository<FilterRequest, Integer> {

}
