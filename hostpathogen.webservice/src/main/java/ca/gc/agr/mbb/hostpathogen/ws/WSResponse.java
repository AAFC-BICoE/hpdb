package ca.gc.agr.mbb.hostpathogen.ws;

import ca.gc.agr.mbb.hostpathogen.nouns.Author;
import ca.gc.agr.mbb.hostpathogen.nouns.Host;
import ca.gc.agr.mbb.hostpathogen.nouns.Location;
import ca.gc.agr.mbb.hostpathogen.nouns.Pathogen;
import ca.gc.agr.mbb.hostpathogen.nouns.Reference;
import ca.gc.agr.mbb.hostpathogen.nouns.HostPathogen;

public class WSResponse {
	private Meta meta;
	private Host host;
	private Pathogen pathogen;
	private HostPathogen hostpathogen;
	private Author author;
	private Reference reference;
	private Location location;
	
	public final Meta getMeta() {
		return meta;
	}
	public final void setMeta(Meta meta) {
		this.meta = meta;
	}
	public final Host getHost() {
		return host;
	}
	public final void setHost(Host host) {
		this.host = host;
	}
	public final Pathogen getPathogen() {
		return pathogen;
	}
	public final void setPathogen(Pathogen pathogen) {
		this.pathogen = pathogen;
	}
	public final HostPathogen getHostpathogen() {
		return hostpathogen;
	}
	public final void setHostpathogen(HostPathogen hostpathogen) {
		this.hostpathogen = hostpathogen;
	}
	public final Author getAuthor() {
		return author;
	}
	public final void setAuthor(Author author) {
		this.author = author;
	}
	public final Reference getReference() {
		return reference;
	}
	public final void setReference(Reference reference) {
		this.reference = reference;
	}
	public final Location getLocation() {
		return location;
	}
	public final void setLocation(Location location) {
		this.location = location;
	}
}
