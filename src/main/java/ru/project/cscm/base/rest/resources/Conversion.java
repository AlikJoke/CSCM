package ru.project.cscm.base.rest.resources;

import java.util.Date;

import ru.project.cscm.base.utils.Base64Helper;
import ru.project.cscm.model.FilterRequest;
import ru.project.cscm.model.Request;
import ru.project.cscm.rest.protos.RequestFilterProto;
import ru.project.cscm.rest.protos.RequestProto;

import com.google.common.base.Function;

public abstract class Conversion {

	private Conversion() {
		throw new RuntimeException();
	}
	
	public static final Function<FilterRequest, FilterRequestResource> filterRequestToJsonResource = new Function<FilterRequest, FilterRequestResource>() {

		@Override
		public FilterRequestResource apply(FilterRequest input) {
			return input == null ? null : new FilterRequestResource(input);
		}
		
		
	};
	
	public static final Function<FilterRequest, RequestFilterProto> filterRequestToProtoResource = new Function<FilterRequest, RequestFilterProto>() {

		@Override
		public RequestFilterProto apply(FilterRequest input) {
			final RequestFilterProto filter;
			if (input != null) {
				filter = RequestFilterProto.newBuilder().setId(input.getId()).setFilterValue(Base64Helper.encodeToString(input.getFilter())).build();
			} else {
				filter = null;
			}
			
			return filter;
		}
	
	};
	
	public static final Function<Request, RequestResource> requestToJsonResource = new Function<Request, RequestResource>() {

		@Override
		public RequestResource apply(Request input) {
			return input == null ? null : new RequestResource(input);
		}

	};
	
	public static final Function<Request, RequestProto> requestToProtoResource = new Function<Request, RequestProto>() {

		@Override
		public RequestProto apply(Request input) {
			final RequestProto request;
			if (input != null) {
				request = RequestProto.newBuilder().setId(input.getId())
						.setFilter(filterRequestToProtoResource.apply(input.getFilter()))
						.setDescx(input.getDescx())
						.setIsSended(input.isSended())
						.setRequestDate(input.getRequestDate().getTime())
						.build();
			} else {
				request = null;
			}
			
			return request;
		}

	};
	
	public static final Function<RequestProto, Request> requestProtoToRequest = new Function<RequestProto, Request>() {

		@Override
		public Request apply(RequestProto input) {
			final String descx = Base64Helper.decodeFromString(input.getDescx());
			final Date requestDate = new Date(input.getRequestDate());
			final boolean isSended = input.getIsSended();
			return new Request(null, null, descx, requestDate, isSended);
		}
		
	};
}
