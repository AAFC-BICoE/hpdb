package ca.gc.agr.mbb.hostpathogen.jspservlet.action;

public interface Action {
	   public static final String SUCCESS = "success";
	   public static final String NONE = "none";
	   public static final String ERROR = "error";
	   public static final String NOTFOUND = "notfound";
	   public static final String UNAUTHORIZED = "unauthorized";
	   public static final String BADREQUEST= "badrequest";
	   public String execute() throws Exception;
	}