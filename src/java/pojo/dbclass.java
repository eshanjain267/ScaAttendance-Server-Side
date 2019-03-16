package pojo;



import java.sql.Connection;
import java.sql.DriverManager;




/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Comp001
 */
public class dbclass 

{
    private static Connection con ;
     public static Connection getcon()
    {
        return con;
    }
         static 
    {
        try{
       Class.forName("com.mysql.jdbc.Driver");
       con = DriverManager.getConnection("jdbc:mysql://localhost:3306/scaoncloud","root","");
            System.out.println("coneccted"+con);
        }
        catch(Exception ex)
        {
            System.out.println(ex);
            ex.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        
   
        System.out.println("ok");
   
}
}
