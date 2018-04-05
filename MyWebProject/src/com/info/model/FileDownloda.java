package com.info.model;

import java.io.File;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;


@Path("/download")
public class FileDownloda {

private static final String FILE_PATH="C:\\Users\\deevanshu.mahajan\\Desktop\\text.txt";
	
@GET
@Path("/textfile")
@Produces("text/plain")
public Response downloadTextFile(){
	
	File file= new File(FILE_PATH);
	 ResponseBuilder response = Response.ok((Object) file);
	 response.header("Content-Disposition","attachment; filename=\"javatpoint_file.txt\"");  
	 return response.build();
}
	
}
