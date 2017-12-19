package ru.project.cscm.base;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import ru.project.cscm.model.Request;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;

@Service
@Repository
public class RequestServiceImpl implements RequestService {

	@Autowired
	private RequestRepository repository;

	@Override
	public Collection<Request> getRequests() {
		return ImmutableList.<Request> copyOf(repository.findAll());
	}

	@Override
	public Request getRequest(Integer id) {
		return repository.findOne(id);
	}

	@Override
	public void save(Request request) {
		request.setId(Lists.newLinkedList(repository.findAll()).getLast().getId() + 1);
		repository.save(request);
	}

	@Override
	public void update(Request request) {
		repository.save(request);
	}

	@Override
	public void remove(Request request) {
		repository.delete(request);
	}

	@Override
	public void remove(Integer id) {
		repository.delete(id);
	}
}
