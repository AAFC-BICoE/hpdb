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
import ca.gc.agr.mbb.hostpathogen.web.model.Pathogen;
import ca.gc.agr.mbb.hostpathogen.web.service.PathogenManager;


/**
 * Simple class to retrieve a list of pathogens from the database.
 * <p>
 * <a href="PathogenController.java.html"><i>View Source</i></a>
 * </p>
 *
 * @author bilkhus
 */
@Controller
@RequestMapping("/pathogens*")
public class PathogenController extends GenericController {
    private PathogenManager pathogenManager = null;
    
    @Autowired
    public void setPathogenManager(PathogenManager pathogenManager) {
        this.pathogenManager = pathogenManager;
    }
    
	/** The table id pathogen list. */
	private String tableIdPathogenList = "pathogenList";
	
	/** The list columns pathogen. */
	String[] listColumnsPathogens = {"id", 
								     "genus", 
								     "species",
								     "subSpecificTaxa",
								     "virusNames",
								     "enName",
								     "frName",
								     "fungalState"
								     };

    /**
     * Handle request.
     *
     * @param genus the genus
     * @param species the species
     * @param subSpecificTaxa the sub specific taxa
     * @param virusNames the virus names
     * @param request the request
     * @param response the response
     * @return the model and view
     * @throws Exception the exception
     */
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView handleRequest(@RequestParam(required = false, value = "genus") String genus,
									  @RequestParam(required = false, value = "species") String species,    		
									  @RequestParam(required = false, value = "subSpecificTaxa") String subSpecificTaxa,
									  @RequestParam(required = false, value = "virusNames") String virusNames,
									  HttpServletRequest request,
									  HttpServletResponse response
									  ) throws Exception {
        Model model = new ExtendedModelMap();
        
        Map<String, String> filters = createFilters(); 
        
        filters.put("genus", genus);
        filters.put("species", species);
        filters.put("subSpecificTaxa", subSpecificTaxa);
        filters.put("virusNames", virusNames);
        
        int startingRecord = getStartingRecord(request, pageSize, tableIdPathogenList);
        String sortColumn = getSortColumn(request, tableIdPathogenList, listColumnsPathogens, 0);
        boolean sortOrder = getSortOrder(request, tableIdPathogenList);
        boolean export = request.getParameter(TableTagParameters.PARAMETER_EXPORTING) != null;
        if(export){
        	partialListValue = false;
        	request.setAttribute("partialListValue", false);
        } else {
        	partialListValue = true;
        	request.setAttribute("partialListValue", true);
        }
        
       	List<Pathogen> list = new ArrayList<Pathogen>();
        
        try {
    		request.setAttribute("resultSize", pathogenManager.getDataCount(filters));
    		list = pathogenManager.getFilteredPagedData(startingRecord, pageSize, sortColumn, sortOrder, filters, export);
    		model.addAttribute(Constants.PATHOGEN_LIST, list);
    		
        } catch (SearchException se) {
            model.addAttribute("searchError", se.getMessage());
            model.addAttribute(pathogenManager.getPathogens());
        }
        return new ModelAndView("pathogenList", model.asMap());
    }
    
}