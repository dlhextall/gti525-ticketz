<%@ page contentType="text/html; charset=iso-8859-1" language="java"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="org.json.simple.JSONArray"%>
<%@page import="ca.etsmtl.ticketz.dao.TicketzProvider"%>
<%
        String name = request.getParameter("name");
        JSONArray jsonArr = new JSONArray();
         
        JSONObject json=new JSONObject();
         
        json.put("name","image");
        json.put("value","abc101");
        jsonArr.add(json);
         
        json.put("name","snoop");
        json.put("value","bcd201");
        jsonArr.add(json);
         
        json.put("name","Rock");
        json.put("value","cde301");
        jsonArr.add(json);
         
        json.put("name","test");
        json.put("value","efg401");
        jsonArr.add(json);
         
        out.println(jsonArr);
%>