package ca.gc.agr.mbb.hostpathogen.jspservlet.action;

import org.apache.log4j.Logger;

public class LoadForm {
	private static final long serialVersionUID=1L;
	private static final Logger logger = Logger.getLogger(LoadForm.class);
		
	private String load;

		public String execute() throws Exception {
		if (load != null){
			return "success";
		}else{
			return "notfound";
		}
	}
}
