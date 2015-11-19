package ca.gc.agr.mbb.hostpathogen.web.webapp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ca.gc.agr.mbb.hostpathogen.web.model.Host;
import ca.gc.agr.mbb.hostpathogen.web.service.HostManager;

/**
 * @author bilkhus
 */
@Controller
@RequestMapping("/hostform*")
public class HostFormController extends BaseFormController {
	
    private HostManager hostManager;
	
    @Autowired
    public void setHostManager(final HostManager hostManager){
    	this.hostManager = hostManager;
    }
    
	public HostManager getHostManager() {
		return hostManager;
	}    
	
    @ModelAttribute
    @RequestMapping(method = RequestMethod.GET)
    protected Host showForm(final HttpServletRequest request, final HttpServletResponse response) throws Exception {
    	final String hostId = request.getParameter("id");
        Host ref =getHostManager().getHost(hostId);
    	return ref;
    }

}