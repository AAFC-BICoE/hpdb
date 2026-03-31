package ca.gc.agr.mbb.hostpathogen.web.webapp.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.displaytag.tags.TableTagParameters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ca.gc.agr.mbb.hostpathogen.web.Constants;
import ca.gc.agr.mbb.hostpathogen.web.dao.SearchException;
import ca.gc.agr.mbb.hostpathogen.web.model.HostPathogen;
import ca.gc.agr.mbb.hostpathogen.web.service.HostPathogenManager;


/**
 * Simple class to retrieve a list of hostPathogens from the database.
 * <p>
 * <a href="HostPathogenController.java.html"><i>View Source</i></a>
 * </p>
 *
 * @author bilkhus
 */
@Controller
@RequestMapping("/hostPathogens*")
public class HostPathogenController extends GenericController {
    
    /** The host pathogen manager. */
    private HostPathogenManager hostPathogenManager = null;
    
	/** The table id host pathogen list. */
	private String tableIdHostPathogenList = "hostPathogenList";
	
	/** The list columns regions. */
	String[] listColumnsHostPathogens = {
										//"id", 
									     "hostFamily", 
									     "hostGenus", 
									     "hostSpecies",
									     "hostSubSpecificTaxa",
									     "pathogenVirusNames",
									     "pathogenGenus", 
									     "pathogenSpecies",
									     "pathogenSubSpecificTaxa",
									     "reference.authors",
									     "locations.interpretation"
									     };

    /**
     * Sets the host pathogen manager.
     *
     * @param hostPathogenManager the new host pathogen manager
     */
    @Autowired
    public void setHostPathogenManager(HostPathogenManager hostPathogenManager) {
        this.hostPathogenManager = hostPathogenManager;
    }

    /**
     * Handle request.
     *
     * @param hostFamily the host family
     * @param hostGenus the host genus
     * @param hostSpecies the host species
     * @param hostSubSpecificTaxa the host sub specific taxa
     * @param pathogenGenus the pathogen genus
     * @param pathogenSpecies the pathogen species
     * @param pathogenSubSpecificTaxa the pathogen sub specific taxa
     * @param pathogenVirusNames the pathogen virus names
     * @param authors the authors
     * @param locationInterpretation the location interpretation
     * @param locationCountry the location country
     * @param request the request
     * @param response the response
     * @return the model and view
     * @throws Exception the exception
     */
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView handleRequest(@RequestParam(required = false, value = "hostFamily") String hostFamily,
    								  @RequestParam(required = false, value = "hostGenus") String hostGenus,
    								  @RequestParam(required = false, value = "hostSpecies") String hostSpecies,    		
    								  @RequestParam(required = false, value = "hostSubSpecificTaxa") String hostSubSpecificTaxa,
    								  @RequestParam(required = false, value = "pathogenGenus") String pathogenGenus,
    								  @RequestParam(required = false, value = "pathogenSpecies") String pathogenSpecies,    		
    								  @RequestParam(required = false, value = "pathogenSubSpecificTaxa") String pathogenSubSpecificTaxa,
    								  @RequestParam(required = false, value = "pathogenVirusNames") String pathogenVirusNames,	
    								  @RequestParam(required = false, value = "authors") String authors,
    								  @RequestParam(required = false, value = "locationInterpretation") String locationInterpretation,
    								  @RequestParam(required = false, value = "locationCountry") String locationCountry,
    								  @RequestParam(required = false, value = "pageSize") Integer pageSizeParam,
    								  HttpServletRequest request,
    								  HttpServletResponse response
    								  ) throws Exception {
        Model model = new ExtendedModelMap();
        
        Map<String, String> filters = createFilters(); 
        
        filters.put("hostFamily", hostFamily);
        filters.put("hostGenus", hostGenus);
        filters.put("hostSpecies", hostSpecies);
        filters.put("hostSubSpecificTaxa", hostSubSpecificTaxa);
        filters.put("pathogenGenus", pathogenGenus);
        filters.put("pathogenSpecies", pathogenSpecies);
        filters.put("pathogenSubSpecificTaxa", pathogenSubSpecificTaxa);
        filters.put("pathogenVirusNames", pathogenVirusNames);
        filters.put("reference.authors", authors);
        if(locationCountry==null){
        	//do nothing
        	//this is a work around for having two location filters in the search
        }
        else if (locationCountry.length()>1){
        	filters.put("locations.country", locationCountry);
        }
        if(locationInterpretation==null){
        	//do nothing
        	//this is a work around for having two location filters in the search
        }
        else if(locationInterpretation.length()>1){
        	filters.put("locations.interpretation", locationInterpretation);
        }
        
        pageSizeParam = (pageSizeParam!=null && pageSizeParam!=0) ? pageSizeParam : pageSize;
        
        int startingRecord = getStartingRecord(request, pageSizeParam, tableIdHostPathogenList);
        String sortColumn = getSortColumn(request, tableIdHostPathogenList, listColumnsHostPathogens, 0);
        boolean sortOrder = getSortOrder(request, tableIdHostPathogenList);
        boolean export = request.getParameter(TableTagParameters.PARAMETER_EXPORTING) != null;
        if(export){
        	partialListValue = false;
        	request.setAttribute("partialListValue", false);
        } else {
        	partialListValue = true;
        	request.setAttribute("partialListValue", true);
        }
        
       	List<HostPathogen> list = new ArrayList<HostPathogen>();
        try {
	    		request.setAttribute("resultSize", hostPathogenManager.getDataCount(filters));
        		list = hostPathogenManager.getFilteredPagedData(startingRecord, pageSizeParam, sortColumn, sortOrder, filters, export);
        		model.addAttribute(Constants.HOST_PATHOGEN_LIST, list);
            
        } catch (SearchException se) {
            model.addAttribute("searchError", se.getMessage());
            model.addAttribute(hostPathogenManager.getHostPathogens());
        }
        return new ModelAndView("hostPathogenList", model.asMap());
    }
    
}