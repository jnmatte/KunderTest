package com.test;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import data.model.wordData;


@Path("word")
public class word {
	@POST
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public Response wordToUpperCase(wordData data){
		try{
			String rData = data.getData();
			if(rData.length()==4){
				data.setData(rData.toUpperCase());
				data.setCode("00");
				data.setDescription("OK");
				return Response.status(200).entity(data).build();
			}
			data.setCode("400");
			data.setDescription("BAD REQUEST: check input length");
			return Response.status(400).entity(data).build();
		}catch(Exception e){
			data.setDescription("INTERNAL ERROR: "+e.getMessage());
			data.setCode("500");
			return Response.status(500).entity(data).build();
		}
	}
}