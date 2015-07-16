package ca.gc.agr.mbb.hostpathogen.ws;

import java.util.Calendar;

import ca.gc.agr.mbb.hostpathogen.ws.WSConstants;
import ca.gc.agr.mbb.hostpathogen.ws.Main;

public class Meta {
	public String version;
	public Long ellapsedMillis;
	public String thisUrl;
	public String debugToggleUrl = Main.BASE_URI + WSConstants.BASEPATH + WSConstants.DEBUG_PATH;;
	public boolean debug = BaseWS.ALL_DEBUG;
	public String payloadType=null;
	public String mode="mock"; // real/mock
	public String timestamp = Calendar.getInstance().getTime().toString();
	public String errorString;
	public int status;

	public transient Long startMillis = System.currentTimeMillis();
	
}

