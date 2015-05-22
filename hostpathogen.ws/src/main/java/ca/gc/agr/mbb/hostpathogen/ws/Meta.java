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
	
	public final String getVersion() {
		return version;
	}
	public final void setVersion(String version) {
		this.version = version;
	}
	public final String getThisUrl() {
		return thisUrl;
	}
	public final void setThisUrl(String thisUrl) {
		this.thisUrl = thisUrl;
	}
	public final String getPayloadType() {
		return payloadType;
	}
	public final void setPayloadType(String payloadType) {
		this.payloadType = payloadType;
	}
	public final String getTimestamp() {
		return timestamp;
	}
	public final void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	public final String getErrorString() {
		return errorString;
	}
	public final void setErrorString(String errorString) {
		this.errorString = errorString;
	}
	public final int getStatus() {
		return status;
	}
	public final void setStatus(int status) {
		this.status = status;
	}
	public final Long getStartMillis() {
		return startMillis;
	}
	public final void setStartMillis(Long startMillis) {
		this.startMillis = startMillis;
	}	

}

