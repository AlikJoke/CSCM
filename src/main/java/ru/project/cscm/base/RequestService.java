package ru.project.cscm.base;

import java.util.Collection;

import ru.project.cscm.model.Request;

public interface RequestService {

	Collection<Request> getRequests();
	
	Request getRequest(Integer id);
	
	void save(Request request);
	
	void update(Request request);
	
	void remove(Request request);
	
	void remove(Integer id);
	
	Collection<Request> getActualRequestsByFilter(Integer filterId);
	
	Collection<Request> getActualRequests();
}
