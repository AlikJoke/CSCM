package ru.project.cscm.base.rest;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

import ru.project.cscm.base.FilterRequestService;
import ru.project.cscm.base.RequestService;
import ru.project.cscm.base.rest.resources.Conversion;
import ru.project.cscm.model.Request;
import ru.project.cscm.rest.protos.RequestProto;

import com.google.common.collect.Collections2;

@RestController
public class RequestController extends ControllerWithExceptionHandler {

	private static final String PATH = "/requests";
	
	@Autowired
	private RequestService requestDao;
	
	@Autowired
	private FilterRequestService filterDao;
	
	@GetMapping(value = PATH)
	@ResponseStatus(HttpStatus.OK)
	public Collection<RequestProto> doGet() {
		return Collections2.transform(requestDao.getActualRequests(), Conversion.requestToProtoResource);
	}
	
	@GetMapping(value = PATH + "/{filterId}")
	@ResponseStatus(HttpStatus.OK)
	public Collection<RequestProto> doGet(@PathVariable("filterId") final Integer filterId) {
		return Collections2.transform(requestDao.getActualRequestsByFilter(filterId), 
				Conversion.requestToProtoResource);
	}
	
	@PostMapping(value = PATH)
	@ResponseStatus(HttpStatus.CREATED)
	public RequestProto doPost(@RequestBody RequestProto request) {
		final Request requestToSave = Conversion.requestProtoToRequest.apply(request);
		requestToSave.setFilter(filterDao.getFilter(request.getFilter().getId()));
		requestDao.save(requestToSave);
		return Conversion.requestToProtoResource.apply(requestDao.getRequest(request.getId()));
	}
	
	@RequestMapping(value = PATH + "/{id}", method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	public RequestProto doPut(@RequestBody RequestProto request, @PathVariable("id") final Integer requestId) {
		final Request req = Conversion.requestProtoToRequest.apply(request);
		final Request existingReq = requestDao.getRequest(requestId);
		if (existingReq == null) {
			throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
		}
		
		existingReq.setDescx(req.getDescx());
		existingReq.setFilter(filterDao.getFilter(req.getFilter().getId()));
		existingReq.setSended(req.isSended());
		requestDao.update(existingReq);
		return Conversion.requestToProtoResource.apply(req);
	}
	
	@RequestMapping(value = PATH + "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void doDelete(@PathVariable("id") final String requestId) {
		requestDao.remove(Integer.parseInt(requestId));
	}

	@RequestMapping(value = { PATH, PATH + "/{filterId}" }, method = RequestMethod.OPTIONS)
	@ResponseStatus(HttpStatus.OK)
	public void doOptions(final HttpServletRequest request, final HttpServletResponse response) {
		response.setHeader("Allow", "GET, POST, OPTIONS, PUT");
		if (request.getHeader("Origin") != null) {
			response.setHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS, PUT");
		}
	}
}
