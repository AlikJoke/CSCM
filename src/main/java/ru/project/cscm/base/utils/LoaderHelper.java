package ru.project.cscm.base.utils;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.springframework.util.StringUtils;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public abstract class LoaderHelper {

	private LoaderHelper() {
		super();
	}

	public static Document getXmlDocument(final InputStream is) {
		try {
			final DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			final DocumentBuilder builder = dbFactory.newDocumentBuilder();
			Document doc = builder.parse(is);
			doc.getDocumentElement().normalize();
			return doc;
		} catch (SAXException | IOException | ParserConfigurationException e) {
			throw new RuntimeException(e);
		}
	}
	
	public static InputStream getInputStream(final String path) {
		if (StringUtils.isEmpty(path)) {
			throw new RuntimeException("Path to file can't be null or empty!");
		}
		
		final InputStream is = LoaderHelper.class.getClassLoader().getResourceAsStream(path);
		if (is == null) {
			throw new RuntimeException("File isn't exists or can't be read!");
		}
		
		return is;		
	}
}
