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
import ru.project.cscm.base.rest.resources.Conversion;
import ru.project.cscm.rest.protos.RequestFilterProto;

import com.google.common.collect.Collections2;

@RestController
public class FilterRequestController extends ControllerWithExceptionHandler {

	private static final String PATH = "/filters";
	
	@Autowired
	private FilterRequestService filterService;
	
	@GetMapping(value = PATH)
	@ResponseStatus(HttpStatus.OK)
	public Collection<RequestFilterProto> doGet() {
		return Collections2.transform(filterService.getFilters(), Conversion.filterRequestToProtoResource);
	}
	
	@GetMapping(value = PATH + "/{id}")
	@ResponseStatus(HttpStatus.OK)
	public RequestFilterProto doGet(@PathVariable("id") final String id) {
		return Conversion.filterRequestToProtoResource.apply(filterService.getFilter(Integer.valueOf(id)));
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
