package ca.gc.agr.mbb.hostpathogen.web.webapp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ca.gc.agr.mbb.hostpathogen.web.model.HostPathogen;
import ca.gc.agr.mbb.hostpathogen.web.service.HostPathogenManager;

/**
 * @author bilkhus
 */
@Controller
@RequestMapping("/hostpathogenform*")
public class HostPathogenFormController extends BaseFormController {
	
    private HostPathogenManager hostPathogenManager;
	
    @Autowired
    public void setHostPathogenManager(final HostPathogenManager hostPathogenManager){
    	this.hostPathogenManager = hostPathogenManager;
    }
    
	public HostPathogenManager getHostPathogenManager() {
		return hostPathogenManager;
	}    
	
    @ModelAttribute
    @RequestMapping(method = RequestMethod.GET)
    protected HostPathogen showForm(final HttpServletRequest request, final HttpServletResponse response) throws Exception {
    	final String hostPathogenId = request.getParameter("id");
        HostPathogen ref =getHostPathogenManager().getHostPathogen(hostPathogenId);
    	return ref;
    }

}