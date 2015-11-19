package ca.gc.agr.mbb.hostpathogen.web.webapp.controller;

import java.util.ArrayList;
import java.util.List;

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
public class HostPathogenController {
    private HostPathogenManager hostPathogenManager = null;

    @Autowired
    public void setHostPathogenManager(HostPathogenManager hostPathogenManager) {
        this.hostPathogenManager = hostPathogenManager;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView handleRequest(@RequestParam(required = false, value = "q") String query) throws Exception {
        Model model = new ExtendedModelMap();
        List<HostPathogen> list = new ArrayList<HostPathogen>();
        try {
        	if(query==null || query.length()==0){ //return empty list if search string is empty
        		model.addAttribute(Constants.HOST_PATHOGEN_LIST, list);
        	} else {
        		model.addAttribute(Constants.HOST_PATHOGEN_LIST, hostPathogenManager.search(query));
        	}
            
        } catch (SearchException se) {
            model.addAttribute("searchError", se.getMessage());
            model.addAttribute(hostPathogenManager.getHostPathogens());
        }
        return new ModelAndView("hostPathogenList", model.asMap());
    }
}
