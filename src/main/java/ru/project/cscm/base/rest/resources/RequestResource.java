package ru.project.cscm.base.rest.resources;

import java.util.Date;

import ru.project.cscm.model.FilterRequest;
import ru.project.cscm.model.Request;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Function;

@JsonAutoDetect(fieldVisibility = Visibility.ANY)
public class RequestResource {

	private Integer id;
	private FilterRequestResource filter;
	private String descx;
	private Date requestDate;
	private boolean isSended;

	public Date getRequestDate() {
		return requestDate;
	}

	public void setRequestDate(Date requestDate) {
		this.requestDate = requestDate;
	}

	public boolean isSended() {
		return isSended;
	}

	public void setSended(boolean isSended) {
		this.isSended = isSended;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setFilter(FilterRequestResource filter) {
		this.filter = filter;
	}

	public void setDescx(String descx) {
		this.descx = descx;
	}

	public Integer getId() {
		return id;
	}

	public FilterRequestResource getFilter() {
		return filter;
	}
	
	public String getDescx() {
		return descx;
	}

	public RequestResource(final Request request) {
		this.id = request.getId();
		this.filter = FilterRequestResource.filterRequestToResource.apply(request.getFilter());
		this.descx = request.getDescx();
		this.requestDate = request.getRequestDate();
		this.isSended = request.isSended();
	}

	@JsonCreator
	public RequestResource(@JsonProperty("id") Integer id, @JsonProperty("filter") FilterRequestResource filter,
			@JsonProperty("descx") String descx, @JsonProperty("requestDate") Date requestDate, @JsonProperty("isSended") boolean isSended) {
		super();
		this.id = id;
		this.filter = filter;
		this.descx = descx;
		this.requestDate = requestDate;
		this.isSended = isSended;
	}

	@JsonIgnore
	public static final Function<Request, RequestResource> requestToResource = new Function<Request, RequestResource>() {

		@Override
		public RequestResource apply(Request input) {
			return input == null ? null : new RequestResource(input);
		}

	};
	
	@JsonIgnore
	public Request getRequestObject() {
		return new Request(getId(), new FilterRequest(getFilter().getId(), getFilter().getFilterValue()), 
				getDescx(), getRequestDate(), isSended());
	}
}
