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
import ca.gc.agr.mbb.hostpathogen.web.model.Host;
import ca.gc.agr.mbb.hostpathogen.web.service.HostManager;


/**
 * Simple class to retrieve a list of hosts from the database.
 * <p>
 * <a href="HostController.java.html"><i>View Source</i></a>
 * </p>
 *
 * @author bilkhus
 */
@Controller
@RequestMapping("/hosts*")
public class HostController extends GenericController {
    private HostManager hostManager = null;

    @Autowired
    public void setHostManager(HostManager hostManager) {
        this.hostManager = hostManager;
    }
    
	/** The table id hosts list. */
	private String tableIdHostList = "hostList";
	
	/** The list columns hosts. */
	String[] listColumnsHosts = {"id", 
							     "genus", 
							     "species",
							     "subSpecificTaxa",
							     "cultivar", 
							     "enName",
							     "frName"
							     };

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView handleRequest(@RequestParam(required = false, value = "genus") String genus,
			  						  @RequestParam(required = false, value = "species") String species,    		
			  						  @RequestParam(required = false, value = "subSpecificTaxa") String subSpecificTaxa,
    								  HttpServletRequest request,
    								  HttpServletResponse response
    								  ) throws Exception {
        Model model = new ExtendedModelMap();
        
        Map<String, String> filters = createFilters(); 
        
        filters.put("genus", genus);
        filters.put("species", species);
        filters.put("subSpecificTaxa", subSpecificTaxa);
        
        int startingRecord = getStartingRecord(request, pageSize, tableIdHostList);
        String sortColumn = getSortColumn(request, tableIdHostList, listColumnsHosts, 0);
        boolean sortOrder = getSortOrder(request, tableIdHostList);
        boolean export = request.getParameter(TableTagParameters.PARAMETER_EXPORTING) != null;
        if(export){
        	partialListValue = false;
        	request.setAttribute("partialListValue", false);
        } else {
        	partialListValue = true;
        	request.setAttribute("partialListValue", true);
        }
        
       	List<Host> list = new ArrayList<Host>();
        
        try {
    		request.setAttribute("resultSize", hostManager.getDataCount(filters));
    		list = hostManager.getFilteredPagedData(startingRecord, pageSize, sortColumn, sortOrder, filters, export);
    		model.addAttribute(Constants.HOST_LIST, list);
            
        } catch (SearchException se) {
            model.addAttribute("searchError", se.getMessage());
            model.addAttribute(hostManager.getHosts());
        }
        return new ModelAndView("hostList", model.asMap());
    }
    
}