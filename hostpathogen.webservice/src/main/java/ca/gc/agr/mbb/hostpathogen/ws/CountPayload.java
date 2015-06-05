package ca.gc.agr.mbb.hostpathogen.ws;

public class CountPayload implements Payload{
	public long total = 0;
	public CountPayload(){
	}


	public CountPayload(final long total){
		this.total = total;
	}
}