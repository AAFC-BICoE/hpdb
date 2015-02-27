
package ca.gc.agr.mbb.hostpathogen.hostpathogenlucenesearcher;

import java.util.Properties;
import java.util.List;

public class IndexFailureException extends Exception{

    public IndexFailureException(){
	super();
    }

    public IndexFailureException(final String m){
	super(m);
    }

    public IndexFailureException(final Throwable t){
	super(t);
    }


}


