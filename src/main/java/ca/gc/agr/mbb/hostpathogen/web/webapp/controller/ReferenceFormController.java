package ca.gc.agr.mbb.hostpathogen.web.webapp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ca.gc.agr.mbb.hostpathogen.web.model.Reference;
import ca.gc.agr.mbb.hostpathogen.web.service.ReferenceManager;

/**
 * @author bilkhus
 */
@Controller
@RequestMapping("/referenceform*")
public class ReferenceFormController extends BaseFormController {
	
    private ReferenceManager referenceManager;
	
    @Autowired
    public void setReferenceManager(final ReferenceManager referenceManager){
    	this.referenceManager = referenceManager;
    }
    
	public ReferenceManager getReferenceManager() {
		return referenceManager;
	}    
	
    @ModelAttribute
    @RequestMapping(method = RequestMethod.GET)
    protected Reference showForm(final HttpServletRequest request, final HttpServletResponse response) throws Exception {
    	final String referenceId = request.getParameter("reference.id");
        Reference ref =getReferenceManager().getReference(referenceId);
    	return ref;
    }

}