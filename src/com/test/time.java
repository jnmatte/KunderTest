 
package com.test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


import data.model.timeData;


@Path("time")
public class time {
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public Response getTime(@QueryParam("value") String input) {
		timeData td = new timeData();
		try{
			//Recibir hora en formato YYYY-MM-DDThh:mm:ss
			DateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
			sdf1.setTimeZone(TimeZone.getTimeZone("Chile/Continental"));
			Date date = new Date();
			date = sdf1.parse(input);
			//return Response.status(200).entity(td).build();
			System.out.println("En Chile: "+sdf1.format(date));
			//Convertir hora a UTC en formato YYYY-MM-DDThh:mm:ss.sTZD
			DateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSZ");
			sdf2.setTimeZone(TimeZone.getTimeZone("UTC"));
			System.out.println("En UTC: "+sdf2.format(date));
			td.setCode("00");
			td.setData(sdf2.format(date));
			td.setDescription("OK");
			return Response.status(200).entity(td).build();
		}catch(Exception e){
			System.out.println(e.getClass().getName());
			if(e.getClass().getName()=="java.text.ParseException"){
				td.setDescription("BAD REQUEST: check time format");
				td.setCode("400");
				return Response.status(400).entity(td).build();
			}
			td.setCode("500");
			td.setDescription("INTERNAL ERROR: "+e.getMessage());
			return Response.status(500).entity(td).build();
		}
	}

}