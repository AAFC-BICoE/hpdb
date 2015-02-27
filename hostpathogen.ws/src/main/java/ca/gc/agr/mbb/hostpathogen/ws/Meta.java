package ca.gc.agr.mbb.hostpathogen.ws;

import java.util.Calendar;

public class Meta {
	public String version;
	public String thisUrl;
	public String payloadType=null;
	public String timestamp = Calendar.getInstance().getTime().toString();
	public String errorString;
	public int status;
	public transient Long startMillis = System.currentTimeMillis();

}

