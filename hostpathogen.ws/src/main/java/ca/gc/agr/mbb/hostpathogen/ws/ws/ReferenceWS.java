package ca.gc.agr.mbb.hostpathogen.ws.ws;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.xml.bind.annotation.XmlRootElement;

import org.json.JSONException;
import org.json.JSONObject;

import ca.gc.agr.mbb.hostpathogen.ws.Nouns;
import ca.gc.agr.mbb.hostpathogen.ws.WSConstants;


@Path(Nouns.REFERENCES)
@XmlRootElement
public class ReferenceWS implements Nouns, WSConstants{	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response GetReferenceInit(
			@DefaultValue(DEFAULT_PAGING_OFFSET_STRING) @QueryParam(PAGING_OFFSET_PARAMETER) Integer offset, 
			@DefaultValue(DEFAULT_PAGING_LIMIT_STRING) @QueryParam(PAGING_LIMIT_PARAMETER) Integer limit) throws JSONException {

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("offset", offset); 
		jsonObject.put("limit", limit);

		String result = "\n GET Reference offset and limit: \n" + jsonObject;
		System.out.println(result);
		if (limit - offset > DEFAULT_PAGING_LIMIT){
			System.out.println("Your request exceded the limit of 50!");
			return Response.status(400).build();  
		}else{
			return Response.status(200).entity(result).build();
		}
	}

	//===========GET Reference Id==============//
	@Path(WSConstants.ID_VALID)
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response GetReferenceId(@PathParam(ID) String ID_VALID) throws JSONException {
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("Reference ID", ID_VALID); 

		String result = "\n GET Reference ID: \n" + jsonObject;
		System.out.println(result);
		return Response.status(200).entity(result).build();
	}   

	//===========GET Reference Bad Id==============//
	@Path(WSConstants.ID_INVALID)
	@GET
	@Produces("application/json")
	public Response GetReferenceNOTId(@PathParam(ID) String ID_INVALID) throws JSONException {

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("notId", ID_INVALID); 

		System.out.println("\n GET Not Reference ID: \n" + jsonObject);
		return Response.status(400).build();
	}
}