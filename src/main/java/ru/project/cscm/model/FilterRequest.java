package ru.project.cscm.model;

import java.util.Calendar;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import ru.project.cscm.base.NotNullOrEmpty;

@Entity
@Table(name = "filter_requests")
public class FilterRequest extends BaseIdentifiableObject<Integer> {

	@Column(name = "filter")
	private String filter;
	
	@OneToMany(targetEntity = Request.class, mappedBy = "filter")
    private Set<Request> requests;

	public String getFilter() {
		return filter;
	}
	
	public void setFilter(final String filter) {
		this.filter = filter;
	}
	
	public Set<Request> getRequests() {
		return requests;
	}

	protected FilterRequest() {
		super();
	}
	
	public FilterRequest(@NotNullOrEmpty final Integer id, @NotNullOrEmpty final String filter, 
			@NotNull final Calendar createdTime, @NotNull final Calendar modifiedTime) {
		super(id, createdTime, modifiedTime);
		this.filter = filter;
	}

	public FilterRequest(@NotNullOrEmpty final Integer id, @NotNullOrEmpty final String filter) {
		super(id);
		this.filter = filter;
	}
}
