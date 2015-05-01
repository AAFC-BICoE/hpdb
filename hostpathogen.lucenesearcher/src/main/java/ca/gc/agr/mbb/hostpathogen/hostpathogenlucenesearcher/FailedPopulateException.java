package ca.gc.agr.mbb.hostpathogen.hostpathogenlucenesearcher;

import java.util.Properties;
import java.util.List;

public class FailedPopulateException extends IllegalArgumentException{

    public FailedPopulateException(){
	super();
    }

    public FailedPopulateException(final String m){
	super(m);
    }

    public FailedPopulateException(final Throwable m){
	super(m);
    }

    public FailedPopulateException(final String s, final Throwable m){
	super(s,m);
    }


}


