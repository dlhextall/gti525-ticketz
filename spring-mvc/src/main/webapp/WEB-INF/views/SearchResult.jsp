<%@ page contentType="text/html; charset=iso-8859-1" language="java"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="org.json.simple.JSONArray"%>
<%@page import="java.util.ArrayList"%>
<%@page import="ca.etsmtl.ticketz.model.Show"%>
<%@page import="ca.etsmtl.ticketz.dao.TicketzProvider"%>
<%
		ArrayList<Show> spectacles = (ArrayList<Show>) request.getAttribute("spectacles");
		JSONArray arr = new JSONArray() ;   
        
        for (Show spectacle : spectacles ){
        	JSONObject obj1 = new JSONObject();
            obj1.put("name", spectacle.getName());
            arr.add(obj1);         	
        }      
         
        out.println(arr);
        

%>