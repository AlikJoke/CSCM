package ru.project.cscm.base;

import java.util.Collection;

import ru.project.cscm.model.FilterRequest;

public interface FilterRequestService {

	Collection<FilterRequest> getFilters();
	
	FilterRequest getFilter(Integer id);
}
