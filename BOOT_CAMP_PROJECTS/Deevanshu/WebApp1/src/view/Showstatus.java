package view;
import Deevanhu.*;

import java.awt.event.ItemEvent;
import java.io.IOException;

import java.io.PrintWriter;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.*;
import javax.naming.*;

import Deevanhu.itemClass;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Servlet implementation class ShowStatus
 */
public class Showstatus extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Showstatus() {
		super();
		// TODO Auto-generated constructor stub
	}
	  
	    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
		{
		doPost(request, response);
	
		
	}


	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException 
			{
	

}

}