package ca.gc.agr.mbb.hostpathogen.ws.ws;

import java.util.List;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.xml.bind.annotation.XmlRootElement;

import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.Gson;

import ca.gc.agr.mbb.hostpathogen.nouns.Location;
import ca.gc.agr.mbb.hostpathogen.ws.Nouns;
import ca.gc.agr.mbb.hostpathogen.ws.WSConstants;


@Path(Nouns.LOCATIONS)
@XmlRootElement
//=============Default GET all Location ID
public class LocationWS implements Nouns, WSConstants{	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response GetLocationInit(
			@Context UriInfo uri,
			@DefaultValue(DEFAULT_PAGING_OFFSET_STRING) @QueryParam(PAGING_OFFSET_PARAMETER) Integer offset, 
			@DefaultValue(DEFAULT_PAGING_LIMIT_STRING) @QueryParam(PAGING_LIMIT_PARAMETER) Integer limit) throws JSONException {

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("offset", offset); 
		jsonObject.put("limit", limit);

		String result = "\n GET Location offset and limit: \n" + jsonObject;
		System.out.println(result);
		if (limit - offset > DEFAULT_PAGING_LIMIT){
			System.out.println("Your request exceded the limit of 50!");
			return Response.status(400).build();   
		}else{
			return Response.status(200).entity(result).build();
		}
	}
	//===========GET Location by Id==============//
	@Path(WSConstants.ID_VALID)
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response GetLocationId(@PathParam(ID) final String ID_VALID) throws JSONException {
		System.out.println("GetLocationId");
		System.out.println("id=[" + ID_VALID + "]");

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("Location ID", ID_VALID); 
		String result = "\n GET Location ID: \n" + jsonObject;
		System.out.println(result);
		return Response.status(200).entity(result).build();
	}

	//===========GET Location by Bad Id==============//
	@Path(WSConstants.ID_INVALID)
	@GET
	@Produces("application/json")
	public Response GetLocationNOTId(@PathParam(ID) String ID_INVALID) throws JSONException {
		System.out.println("GetLocationNOTId");
		System.out.println("id=[" + ID_INVALID + "]");

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("Location Bad ID", ID_INVALID); 

		System.out.println("\n GET Not Location ID: \n" + jsonObject);
		return Response.status(400).build();
	}
}