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
 * <p/>
 * <p>
 * <a href="HostPathogenController.java.html"><i>View Source</i></a>
 * </p>
 *
 * @author bilkhus
 */
@Controller
@RequestMapping("/hostPathogens*")
public class HostPathogenController extends GenericController {
    private HostPathogenManager hostPathogenManager = null;

    @Autowired
    public void setHostPathogenManager(HostPathogenManager hostPathogenManager) {
        this.hostPathogenManager = hostPathogenManager;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView handleRequest(@RequestParam(required = false, value = "q") String query,
    								  @RequestParam(required = false, value = "genus") String genus,
    								  @RequestParam(required = false, value = "species") String species,    		
    								  HttpServletRequest request,
    								  HttpServletResponse response
    								  ) throws Exception {
        Model model = new ExtendedModelMap();
        
        boolean export = request.getParameter(TableTagParameters.PARAMETER_EXPORTING) != null;
        Map<String, String> filters = createFilters(); 
        
        filters.put("hostGenus", genus);
        filters.put("hostSpecies", species);
        boolean ascending = true;
        int startRow = 0;
        
        List<HostPathogen> list = new ArrayList<HostPathogen>();
        try {
/*        	if(query==null || query.length()==0){ //return empty list if search string is empty
        		model.addAttribute(Constants.HOST_PATHOGEN_LIST, list);
        	} else {*/
        		int count = hostPathogenManager.getDataCount(filters);
        		
        		list = hostPathogenManager.getFilteredPagedData(0, pageSize, getSortColumn(), ascending, filters, export);
        		model.addAttribute(Constants.HOST_PATHOGEN_LIST, list);
//        		model.addAttribute(Constants.HOST_PATHOGEN_LIST, hostPathogenManager.search(query));
//        	}
        		
//        		+    		HttpServletRequest request,
//        		+            HttpServletResponse response) throws Exception {
//        		         Model model = new ExtendedModelMap();
//        		-        List<HostPathogen> list = new ArrayList<HostPathogen>();
//        		+        boolean export = request.getParameter(TableTagParameters.PARAMETER_EXPORTING) != null;
        		
            
        } catch (SearchException se) {
            model.addAttribute("searchError", se.getMessage());
            model.addAttribute(hostPathogenManager.getHostPathogens());
        }
        return new ModelAndView("hostPathogenList", model.asMap());
    }
}
