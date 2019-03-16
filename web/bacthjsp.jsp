<%-- 
    Document   : bacthjsp
    Created on : 4 Mar, 2019, 4:05:46 PM
    Author     : Comp001
--%>


<%@page import="org.json.JSONArray"%>
<%@page import="org.json.JSONObject"%>
<%@page import="java.util.ArrayList"%>
<%@page import="pojo.fetch"%>
<%@page import="pojo.BatchPojo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
 
JSONArray arr =  new JSONArray();    

try
{
    ArrayList<BatchPojo> al = fetch.getbatchdetails();
    for(BatchPojo bp:al)
    {
    JSONObject obj = new JSONObject();
    obj.put("batchid",bp.getBatchcode());
    obj.put("course",bp.getCourse());
    obj.put("days",bp.getDays());
    obj.put("time",bp.getTime());
    obj.put("faculty",bp.getFaculty());
    arr.put(obj);
        
        
        
    }
    out.print(arr);
  
  
}
catch(Exception ex)
{
 arr.put(0,"ex");
  
    out.print(arr);
}

%>
