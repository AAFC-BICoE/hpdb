package ca.gc.agr.mbb.hostpathogen.web.webapp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ca.gc.agr.mbb.hostpathogen.web.model.Pathogen;
import ca.gc.agr.mbb.hostpathogen.web.service.PathogenManager;

/**
 * @author bilkhus
 */
@Controller
@RequestMapping("/pathogenform*")
public class PathogenFormController extends BaseFormController {
	
    private PathogenManager pathogenManager;
	
    @Autowired
    public void setPathogenManager(final PathogenManager pathogenManager){
    	this.pathogenManager = pathogenManager;
    }
    
	public PathogenManager getPathogenManager() {
		return pathogenManager;
	}    
	
    @ModelAttribute
    @RequestMapping(method = RequestMethod.GET)
    protected Pathogen showForm(final HttpServletRequest request, final HttpServletResponse response) throws Exception {
    	final String pathogenId = request.getParameter("id");
        Pathogen ref =getPathogenManager().getPathogen(pathogenId);
    	return ref;
    }

}