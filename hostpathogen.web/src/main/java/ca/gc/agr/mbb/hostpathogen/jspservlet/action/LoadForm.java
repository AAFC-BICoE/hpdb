package ca.gc.agr.mbb.hostpathogen.jspservlet.action;

public class LoadForm {
	private static final long serialVersionUID=1L;
		
	private String load;

		public String execute() throws Exception {
		if (load != null){
			return "success";
		}else{
			return "notfound";
		}
	}
}
