package ru.project.cscm.base;

import java.util.Collection;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import ru.project.cscm.model.FilterRequest;

import com.google.common.collect.ImmutableList;

@Service
@Repository
public class FilterRequestServiceImpl implements FilterRequestService {

	@Autowired
	private FilterRequestRepository repository;
	
	@Autowired
	@Qualifier("filterLoader")
	private Loader<FilterRequest> loader;

	@Override
	public Collection<FilterRequest> getFilters() {
		return ImmutableList.<FilterRequest> copyOf(repository.findAll());
	}
	
	@Override
	public FilterRequest getFilter(final Integer id) {
		return repository.findOne(id);
	}
	
	@PostConstruct
	private void init() {
		final Collection<FilterRequest> filters = loader.load();
		for (FilterRequest filter : filters) {
			if (repository.findOne(filter.getId()) == null) {
				repository.save(filter);
			}
		}
	}

}
