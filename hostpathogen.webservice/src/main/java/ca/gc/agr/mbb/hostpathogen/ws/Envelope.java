package ca.gc.agr.mbb.hostpathogen.ws;

import javax.ws.rs.core.UriInfo;

import ca.gc.agr.mbb.hostpathogen.nouns.Author;
import ca.gc.agr.mbb.hostpathogen.nouns.Host;
import ca.gc.agr.mbb.hostpathogen.nouns.HostPathogen;
import ca.gc.agr.mbb.hostpathogen.nouns.Location;
import ca.gc.agr.mbb.hostpathogen.nouns.Pathogen;
import ca.gc.agr.mbb.hostpathogen.nouns.Reference;

public class Envelope{
    private Meta meta;

    // payloads
    public Host host;
    public Location location;
    public HostPathogen hostpathogen;
    public Pathogen pathogen;
    public Author author;
    public Reference reference;
    
    public PagingPayload pagingPayload;
    public CountPayload countPayload;
    public DebugPayload debugPayload;

    public Envelope(){
	meta = new Meta();
    }

    public Envelope(final UriInfo uriInfo, final Payload payload){
	this();
	meta.thisUrl = uriInfo.getAbsolutePath().toString();
	setPayload(payload);
    }

    public Meta getMeta(){
	return meta;
    }

    public void setPayload(final Payload payload){
	System.err.println("Setting payload: " + payload);
	if(payload instanceof Host){
	    host = (Host)payload;
	}else{ 
		if(payload instanceof HostPathogen){
			hostpathogen = (HostPathogen)payload;
		}else {
			if(payload instanceof Pathogen){
				pathogen = (Pathogen)payload;
			}else{
				if(payload instanceof Location){
					location = (Location)payload;
				}else{
					if(payload instanceof Reference){
						reference = (Reference)payload;				
					}else{
						if(payload instanceof Author){
							author = (Author)payload;
						}else{
							if(payload instanceof PagingPayload){
								pagingPayload = (PagingPayload)payload;
							}else{ // SPECIALS
								if(payload instanceof CountPayload){
									countPayload = (CountPayload)payload;
								}else{
									if(payload instanceof DebugPayload){
										debugPayload = (DebugPayload)payload;
									}else{
										throw new NullPointerException("Unknown payload type: not known by Envelope");
									}
								}
							}
						}
					}
				}
			}
		}
	}}
}