package ca.gc.agr.mbb.hostpathogen.ws;

public class ServiceDescriptor{
    public String description;
    volatile public String path;
    public String url=null;
    public boolean isWorking=false;

    public ServiceDescriptor(final String description, final String path, final boolean isWorking){
	this.description = description;
	this.path = path;
	this.isWorking=isWorking;
    }

}