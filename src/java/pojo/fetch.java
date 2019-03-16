/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Comp001
 */
public class fetch {
     
    
            
    public static ArrayList<BatchPojo> getbatchdetails() throws Exception
    {
        Connection con = dbclass.getcon();
        String qry = "select batch_details.batch_id,batch_details.days,batch_details.time,course_details.course_name,employee_details.emp_name from batch_details,course_details,employee_details where batch_details.faculty_id = employee_details.emp_id and batch_details.course_id=course_details.course_id";

        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(qry);
        ArrayList<BatchPojo> al = new ArrayList<>();
    
        while(rs.next())
        {
            BatchPojo bp = new BatchPojo();
        bp.setBatchcode(rs.getString(1));
        bp.setDays(rs.getString(2));
           bp.setTime(rs.getString(3));
        bp.setCourse(rs.getString(4));
     
        bp.setFaculty(rs.getString(5));
                   al.add(bp);
        }
        
        
        return al ;
    }
    public static boolean getRegisterDetail(String batch_id,String student_id) throws Exception
    {
        Connection con = dbclass.getcon();
        String qry = "SELECT * FROM  student_registration where batch_id=? and student_id =?";
        PreparedStatement ps = con.prepareStatement(qry);
        ps.setString(1,batch_id);
        ps.setString(2,student_id);
        ResultSet rs = ps.executeQuery();
        
        return rs.next();
       
    }
      public static boolean setAttendance(String batch_id,String student_id,String date) throws SQLException
    {
        Connection con = dbclass.getcon();                      
        Date d =  new Date();
        SimpleDateFormat smp = new SimpleDateFormat("yy-MM-dd");
         date =  smp.format(d);
        
        String qry = "Insert into attendance_details values(?,?,?)";
        PreparedStatement ps = con.prepareStatement(qry);
        ps.setString(2,batch_id.trim());
        ps.setString(1,student_id.trim());
        ps.setString(3,date.trim());
      
        int x = ps.executeUpdate();
        
        return (x==0);
       
    }
      
      public static int[] FeeDetails(String batch_id,String student_id) throws SQLException
      {
         Connection con = dbclass.getcon(); 
   String qry1 = "select sum(gross_amount) from student_transaction where batch_id = ? and student_id= ? ";
      PreparedStatement ps = con.prepareStatement(qry1);
 ps.setString(1,batch_id);
        ps.setString(2,student_id);
        int amt =0,fee=0;
        ResultSet rs = ps.executeQuery();
        if(rs.next())
        {
           amt=rs.getInt(1);
        }
        String qry2 = "select course_fee from course_details where course_id =(select course_id from batch_details where batch_id= ?)";
           PreparedStatement ps1= con.prepareStatement(qry2);
           ps1.setString(1,batch_id);
           ResultSet rs2 = ps1.executeQuery();
           while(rs2.next())
           {
              fee = rs2.getInt(1);
               
           }
          
           int net = fee - amt ;
           int []arr = new int[2];
             arr[0]=net ;
             arr[1]=amt ;
           
          return arr ;
      }
    public static String getName(String student_id) throws SQLException
    {
        String name ="";
         Connection con = dbclass.getcon(); 
   String qry1 = "select student_name from student_details where student_contact_no=? ";
      PreparedStatement ps = con.prepareStatement(qry1);
  ps.setString(1,student_id);
       
        ResultSet rs = ps.executeQuery();
        if(rs.next())
        {
           name = rs.getString(1);
        }
        
        
        return name;
    }
    
    public static boolean logindetails(String number, String pswrd) throws SQLException
    {
          
         Connection con = dbclass.getcon(); 
   String qry1 = "select * from employee_details where emp_phone_no =? AND password =?";
      PreparedStatement ps = con.prepareStatement(qry1);
  ps.setString(1,number);
  ps.setString(2, pswrd);
       
        ResultSet rs = ps.executeQuery();
       return rs.next();
    }
    
}
