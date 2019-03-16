<%-- 
    Document   : login
    Created on : 12 Mar, 2019, 7:17:30 PM
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
        String number = obj.get("id").toString();
          String pwd = obj.get("pwd").toString();
          boolean rs = fetch.logindetails(number, pwd);
          obn.put("rs",rs);
 out.print(obn);
    }


catch(Exception ex)
{
    obn.put("rs"," ex");
  out.print(obn);

}

%>