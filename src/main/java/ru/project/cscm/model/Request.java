package ru.project.cscm.model;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import ru.project.cscm.base.NotNullOrEmpty;

@Entity
@Table(name = "requests")
public class Request extends BaseIdentifiableObject<Integer> {

	@Column(name = "descx")
	@Lob
	private String descx;
	
	@ManyToOne(targetEntity = FilterRequest.class, fetch = FetchType.EAGER, optional = false, cascade = {
        CascadeType.PERSIST })
    @JoinColumn(name = "filter_type")
	private FilterRequest filter;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "request_date", nullable = false)
	private Date requestDate;
	
	@Column(name = "is_sended", nullable = false)
	private boolean isSended;
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public boolean isSended() {
		return isSended;
	}
	
	public void setSended(final boolean isSended) {
		this.isSended = isSended;
	}
	
	public Date getRequestDate() {
		return requestDate;
	}
	
	public void setRequestDate(final Date requestDate) {
		this.requestDate = requestDate;
	}
	
	public FilterRequest getFilter() {
		return filter;
	}
	
	public void setFilter(final FilterRequest filter) {
		this.filter = filter;
	}
	
	public String getDescx() {
		return descx;
	}
	
	public void setDescx(final String descx) {
		this.descx = descx;
	}
	
	public Request(@NotNullOrEmpty final Integer id, final FilterRequest filter, final String descx, 
			@NotNull final Calendar createdTime, @NotNull final Calendar modifiedTime) {
		super(id, createdTime, modifiedTime);
		this.filter = filter;
		this.descx = descx;
	}

	public Request(@NotNullOrEmpty final Integer id, @NotNullOrEmpty final FilterRequest filter, 
			final String descx, final Date requestDate, final boolean isSended) {
		super(id);
		this.filter = filter;
		this.descx = descx;
		this.requestDate = requestDate;
		this.isSended = isSended;
	}

	protected Request() {
		super();
	}
}
