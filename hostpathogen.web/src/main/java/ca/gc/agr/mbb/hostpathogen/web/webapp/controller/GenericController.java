package ca.gc.agr.mbb.hostpathogen.web.webapp.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.displaytag.tags.TableTagParameters;
import org.displaytag.util.ParamEncoder;

/**
 * The Class GenericController.
 */
public class GenericController {
	
	/** The Constant DEFAULT_NO_SORT. */
	public static final int DEFAULT_NO_SORT = -1;
	
	/**
	 * A constant for sorting a column in a JSP in ascending order.
	 * look at #getSortOrder(String, String)
	 */
	public static final String SORT_ASCENDING = "1";
	
	/**
	 * A constant for sorting a column in a JSP in descending order.
	 * look at #getSortOrder(String, String)
	 */
	public static final String SORT_DESCENDING = "2";

	
	/** The page size. */
	protected int pageSize = 25;
	
	/** The partial list value. */
	protected boolean partialListValue = true;
	
	/**
	 * Checks if is partial list value.
	 *
	 * @return the partialListValue
	 */
	public boolean isPartialListValue() {
		return partialListValue;
	}

	/**
	 * Sets the partial list value.
	 *
	 * @param partialListValue the partialListValue to set
	 */
	public void setPartialListValue(boolean partialListValue) {
		this.partialListValue = partialListValue;
	}

	/**
	 * Subclasses should extend this method by calling super.reset and adding any filters to it.
	 * Filters are name,value pairs where the name evaluates to a property of the BaseObject 
	 * sub-type contained in the list.
	 *
	 * @return the map
	 */
	protected Map<String, String> createFilters() {
		return new LinkedHashMap<String,String>();
		
//		if (genus != null) {
//			logger.info("Adding genus to filter");
//			filters.put("genus", genus);
//		} 
	}
	
	/**
	 * * Gets the starting record number.  
	 *
	 * @param request the request
	 * @param pageSize the page size
	 * @param tableId the table id
	 * @return  The starting record number
	 */
	protected int getStartingRecord(HttpServletRequest request, int pageSize, String tableId) {
		String pageNumber = request.getParameter((new ParamEncoder(tableId).encodeParameterName(TableTagParameters.PARAMETER_PAGE)));
		int startingRecord = pageNumber != null ? (Integer.parseInt(pageNumber) - 1) * pageSize : 0;
		return startingRecord;
	}

	/**
	 * Gets default sort order .
	 *
	 * @param request the request
	 * @param tableId the table id
	 * @return Sort order encoded in web request or default of {@link #SORT_ASCENDING}
	 */
	protected boolean getSortOrder(HttpServletRequest request, String tableId) {
		return getSortOrder(request, tableId, SORT_ASCENDING);
	}
	
	/**
	 * Gets sortOrder and sets to be the defaultOrder if sortOrder is null.  
	 *
	 * @param request the request
	 * @param tableId the table id
	 * @param defaultOrder the default order
	 * @return  Sort order encoded in web request or used specified defaultOrder
	 */
	protected boolean getSortOrder(HttpServletRequest request, String tableId, String defaultOrder) {
		String sortOrder = request.getParameter(new ParamEncoder(tableId).encodeParameterName(TableTagParameters.PARAMETER_ORDER));

		if (sortOrder == null) sortOrder = defaultOrder;
		
		if(sortOrder.equals("1")){
			return true;
		} else if (sortOrder.equals("2")){
			return false;
		} else {
			return true;
		}
	}
	
	/**
	 * * Gets the column to sort on default column if column is null.  
	 *
	 * @param request the request
	 * @param tableId the table id
	 * @param listColumns the list columns
	 * @param defaultColumn the default column
	 * @return  The sortColumn encoded in the request or else defaultColumn if no sort column available
	 */
	protected String getSortColumn(HttpServletRequest request, String tableId, String[] listColumns, int defaultColumn) {
		String sortColumn = request.getParameter(new ParamEncoder(tableId).encodeParameterName(TableTagParameters.PARAMETER_SORT));
		
		if(sortColumn == null && defaultColumn == DEFAULT_NO_SORT) {
			return null;
		}
		
		// map numeric column to entity property/database column
		if (sortColumn == null) 
			sortColumn = listColumns[defaultColumn];
		else 
			sortColumn = listColumns[Integer.parseInt(sortColumn)];
		return sortColumn;
	}
	
}