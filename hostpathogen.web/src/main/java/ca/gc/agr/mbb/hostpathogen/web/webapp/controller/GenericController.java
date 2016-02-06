package ca.gc.agr.mbb.hostpathogen.web.webapp.controller;

import java.util.LinkedHashMap;
import java.util.Map;

public class GenericController {
	
	protected int pageSize = 25;

	/**
	 * Subclasses should extend this method by calling super.reset and adding any filters to it.
	 * Filters are name,value pairs where the name evaluates to a property of the BaseObject 
	 * sub-type contained in the list.
	 */
	protected Map<String, String> createFilters() {
		return new LinkedHashMap<String,String>();
		
//		if (genus != null) {
//			logger.info("Adding genus to filter");
//			filters.put("genus", genus);
//		} 
	}
	
	private String sortColumn = "id";

	public String getSortColumn() {
		return sortColumn;
	}
	
}
