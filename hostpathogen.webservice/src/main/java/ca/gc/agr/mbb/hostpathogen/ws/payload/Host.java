package ca.gc.agr.mbb.hostpathogen.ws.payload;

import ca.gc.agr.mbb.hostpathogen.ws.Payload;

public class Host extends BasePayload{
	public String family = null;
    public String genus = null;
    public String species = null;
    public String lastModified;

    public Host(final String id){
    	this(Long.parseLong(id));
    }
    public Host(final long id){
    	this();
    	this.id = id;
    }
    public Host(){
    	
    }
    public String toString(){
    	return id.toString();
    }
}