package ca.gc.agr.mbb.hostpathogen.jspservlet.action;

public class LoadForm {

	public String execute() throws Exception {
		if (work()){
			return "success";
		}else{
			return "error";
		}
	}
}
