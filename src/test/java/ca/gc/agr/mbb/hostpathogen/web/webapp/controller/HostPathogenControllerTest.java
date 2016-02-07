package ca.gc.agr.mbb.hostpathogen.web.webapp.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import ca.gc.agr.mbb.hostpathogen.web.Constants;

public class HostPathogenControllerTest extends BaseControllerTestCase {
    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private HostPathogenController controller;

    private MockMvc mockMvc;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public void testHandleRequest() throws Exception {
        mockMvc.perform(get("/hostPathogens"))
            .andExpect(status().isOk())
            .andExpect(model().attributeExists(Constants.HOST_PATHOGEN_LIST))
            .andExpect(view().name("hostPathogenList"));
    }

//    @Test
//    public void testSearch() throws Exception {
//        // reindex before searching
//        HostPathogenManager hostPathogenManager = (HostPathogenManager) applicationContext.getBean("hostPathogenManager");
//        hostPathogenManager.reindex();
//
//        Map<String,Object> model = mockMvc.perform((get("/hostPathogens")).param("q", "admin"))
//            .andExpect(status().isOk())
//            .andExpect(model().attributeExists(Constants.HOST_LIST))
//            .andExpect(view().name("hostPathogenList"))
//            .andReturn()
//            .getModelAndView()
//            .getModel();
//
//        List results = (List) model.get(Constants.HOST_LIST);
//        assertNotNull(results);
//        assertTrue(results.size() >= 1);
//    }
}
