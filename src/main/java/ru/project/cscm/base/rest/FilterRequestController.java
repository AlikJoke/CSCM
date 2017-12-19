package ru.project.cscm.base.rest;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import ru.project.cscm.base.FilterRequestService;
import ru.project.cscm.base.rest.resources.FilterRequestResource;

import com.google.common.collect.Collections2;

@RestController
public class FilterRequestController extends ControllerWithExceptionHandler {

	private static final String PATH = "/filters";
	
	@Autowired
	private FilterRequestService filterService;
	
	@GetMapping(value = PATH)
	@ResponseStatus(HttpStatus.OK)
	public Collection<FilterRequestResource> doGet() {
		return Collections2.transform(filterService.getFilters(), FilterRequestResource.filterRequestToResource);
	}
	
	@GetMapping(value = PATH + "/{id}")
	@ResponseStatus(HttpStatus.OK)
	public FilterRequestResource doGet(@PathVariable("id") final String id) {
		return FilterRequestResource.filterRequestToResource.apply(filterService.getFilter(Integer.valueOf(id)));
	}

	@RequestMapping(value = { PATH, PATH + "/{id}" }, method = RequestMethod.OPTIONS)
	@ResponseStatus(HttpStatus.OK)
	public void doOptions(final HttpServletRequest request, final HttpServletResponse response) {
		response.setHeader("Allow", "GET, OPTIONS");
		if (request.getHeader("Origin") != null) {
			response.setHeader("Access-Control-Allow-Methods", "GET, OPTIONS");
		}
	}
}
