package ca.gc.agr.mbb.hostpathogen.hostpathogenlucenesearcher;

import java.util.Properties;
import java.util.List;

public class TooManyIdsException extends IllegalArgumentException{

    public TooManyIdsException(){
	super();
    }

    public TooManyIdsException(final String m){
	super(m);
    }

    public TooManyIdsException(final Throwable m){
	super(m);
    }


}


