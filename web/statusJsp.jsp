<%-- 
    Document   : statusJsp
    Created on : 28 Feb, 2019, 3:10:43 PM
    Author     : Comp001
--%>

<%@page import="java.sql.SQLException"%>
<%@page import="pojo.fetch"%>
<%@page import="org.json.JSONObject"%>
<%@page import="java.io.InputStreamReader"%>
<%@page import="java.io.BufferedReader"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    
 
       BufferedReader buff = new BufferedReader(new InputStreamReader(request.getInputStream()));
    String jsonstr="" ;
    if(buff!=null)
    {
        
        jsonstr = buff.readLine();
    }
    
      JSONObject obj ;
  
     JSONObject obn = new JSONObject();
    try
    {
        obj = new JSONObject(jsonstr);
        String batch_id = obj.get("batchcode").toString();
          String student_id = obj.get("contact").toString();
           String Date = obj.getString("date").toString();
            boolean ans = fetch.getRegisterDetail(batch_id,student_id);
            
            if(ans==false)
            {
                obn.put("RS","f");
            }
            else
            {
                 obn.put("RS","p");  
                 try
                 {
                     obn.put("name", fetch.getName(student_id));
                  boolean chck = fetch.setAttendance(batch_id, student_id, Date);
                  obn.put("ATTSTS","done");
                 }
                 catch(SQLException ex)
                 {
                  obn.put("ATTSTS","ALdone");
                 
                 }
                 int []arr = fetch.FeeDetails(batch_id, student_id);
                 if(arr[0]==0)
                 {
                     obn.put("FS","COM");
                     
                 }
                 else
                 {
                     obn.put("FS","INCOM");
                     obn.put("FD", arr[0]+"");
                 }
                 obn.put("FP", arr[1]+"");
                 
                 
                  
            }
            
            out.println(obn);
    }
    catch(Throwable th)
    {
        obn.put("RS", "error");
       th.printStackTrace();
    }
%>
