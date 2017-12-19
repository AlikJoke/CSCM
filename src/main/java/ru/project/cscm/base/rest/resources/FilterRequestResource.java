package ru.project.cscm.base.rest.resources;

import ru.project.cscm.model.FilterRequest;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Function;

@JsonAutoDetect(fieldVisibility = Visibility.ANY)
public class FilterRequestResource {

	private final Integer id;
	private final String filterValue;

	public Integer getId() {
		return id;
	}

	public String getFilterValue() {
		return filterValue;
	}
	
	public FilterRequestResource(final FilterRequest filter) {
		this.id = filter.getId();
		this.filterValue = filter.getFilter();
	}

	@JsonCreator
	public FilterRequestResource(@JsonProperty("id") Integer id, @JsonProperty("filterValue") String filter) {
		super();
		this.id = id;
		this.filterValue = filter;
	}
	
	@JsonIgnore
	public static final Function<FilterRequest, FilterRequestResource> filterRequestToResource = new Function<FilterRequest, FilterRequestResource>() {

		@Override
		public FilterRequestResource apply(FilterRequest input) {
			return input == null ? null : new FilterRequestResource(input);
		}
		
		
	};

}
