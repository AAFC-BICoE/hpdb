package ca.gc.agr.mbb.hostpathogen.web.webapp.controller;

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
import ca.gc.agr.mbb.hostpathogen.web.service.PathogenManager;


/**
 * Simple class to retrieve a list of pathogens from the database.
 * <p/>
 * <p>
 * <a href="PathogenController.java.html"><i>View Source</i></a>
 * </p>
 *
 * @author bilkhus
 */
@Controller
@RequestMapping("/pathogens*")
public class PathogenController {
    private PathogenManager pathogenManager = null;

    @Autowired
    public void setPathogenManager(PathogenManager pathogenManager) {
        this.pathogenManager = pathogenManager;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView handleRequest(@RequestParam(required = false, value = "q") String query) throws Exception {
        Model model = new ExtendedModelMap();
        try {
            model.addAttribute(Constants.PATHOGEN_LIST, pathogenManager.search(query));
        } catch (SearchException se) {
            model.addAttribute("searchError", se.getMessage());
            model.addAttribute(pathogenManager.getPathogens());
        }
        return new ModelAndView("pathogenList", model.asMap());
    }
}
