package ca.gc.agr.mbb.hostpathogen.ws;

import java.io.Serializable;
import java.util.ArrayList;

public interface EntityServiceInterface {
	public long getCount();
	public ArrayList<?> getAll();
	public Serializable getById(long id);

}
