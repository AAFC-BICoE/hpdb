package ca.gc.agr.mbb.hostpathogen.ws;

public class  DebugPayload implements Payload{
    boolean debug;
    String debugUrl;

    public DebugPayload(final boolean debug){
	this.debug = debug;
    }
}