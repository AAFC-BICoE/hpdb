package ca.gc.agr.mbb.hostpathogen.ws;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import java.util.logging.*;

public class GsonWrapper {
    static Gson gson = null;
    private final Logger logger=Logger.getLogger(this.getClass().getPackage().getName());
    static{
	if(gson == null){
	    gson = new Gson();
	}
    }

    public String toJson(Envelope e){
	try{
	    String json = gson.toJson(e);
	    e.getMeta().ellapsedMillis = System.currentTimeMillis() - e.getMeta().startMillis;
	    return json;
	}catch(JsonSyntaxException ex){
	    logger.log(Level.SEVERE, "gson error", ex);
	    ex.printStackTrace();
	    
	}
	return null;
    }

    public Object fromJson(String s, Class toClass){
	logger.log(Level.INFO, "fromGson: to class " + toClass.getName() + " from json: " + s);
	try{
	    logger.log(Level.INFO, "fromGson: trying");
	    Object toObject = gson.fromJson(s, toClass);
	    //logger.log(Level.INFO, "fromGson: success: " + toObject);;
	    return toObject;
	}catch(JsonSyntaxException e){
	    logger.log(Level.SEVERE, "gson error", e);
	    e.printStackTrace();
	}catch(Throwable t){
	    t.printStackTrace();
	}
	return null;
    }
}
