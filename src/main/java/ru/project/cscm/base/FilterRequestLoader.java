package ru.project.cscm.base;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import ru.project.cscm.base.utils.LoaderHelper;
import ru.project.cscm.model.FilterRequest;

@Component("filterLoader")
public class FilterRequestLoader implements Loader<FilterRequest> {

	private static final String FILTER_TAG = "filter";
	private static final String ID_ATTRIBUTE = "id";

	private final Collection<FilterRequest> filters;

	private FilterRequestLoader() {
		this.filters = new ArrayList<>();
	}

	@Override
	public Collection<FilterRequest> load() {
		if (filters.isEmpty()) {
			final Collection<FilterRequest> filters = new ArrayList<>();
			final Document doc = LoaderHelper.getXmlDocument(LoaderHelper.getInputStream("data/filters.xml"));
			final NodeList nodes = doc.getElementsByTagName(FILTER_TAG);
			for (int index = 0; index < nodes.getLength(); index++) {
				final Node node = nodes.item(index);
				final Integer id = Integer.parseInt(node.getAttributes().getNamedItem(ID_ATTRIBUTE).getTextContent());
				final String filter = node.getTextContent();
				filters.add(new FilterRequest(id, filter));
			}

			this.filters.addAll(filters);
		}
		return filters;
	}

}
