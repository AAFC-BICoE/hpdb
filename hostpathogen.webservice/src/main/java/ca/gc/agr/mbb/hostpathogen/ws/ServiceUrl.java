package ca.gc.agr.mbb.hostpathogen.ws;

public class ServiceUrl{
    String urlPath;
    String debugFullUrl;

    public ServiceUrl(final String baseUrl, final String urlPath){
	this.urlPath = urlPath;
	if(BaseWS.ALL_DEBUG){
	    StringBuilder sb = new StringBuilder(baseUrl);
	    if(!baseUrl.endsWith("/")){
		sb.append("/");
	    }
	    sb.append(urlPath);
	    this.debugFullUrl = sb.toString();
	}
    }

}