package ca.gc.agr.mbb.hostpathogen.web.actions;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.ActionSupport;

public class ButtonAction extends ActionSupport {
	private static final long serialVersionUID=1L;
	private static final Logger logger = Logger.getLogger(ButtonAction.class);
	
	private String buttonName;
	public void setButtonName(String buttonName) {
		this.buttonName = buttonName;
	}
	public String execute() throws Exception {
		if ("Submit".equals(buttonName)) {
			doSubmit();
			return "submitResult";
		}
		if ("Reset".equals(buttonName)) {
			doReset();
			return "resetResult";
		}
		return super.execute();
	}
	private void doReset() {
		// TODO Auto-generated method stub
		
	}
	private void doSubmit() {
		// TODO Auto-generated method stub
		
	}
}
