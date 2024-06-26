/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package studentinformationsystem1;
  import java.sql.*;
/**
 *
 * @author Hp
 */
public class DBHandler {
    String db="jdbc:mysql://localhost:3306/?user=root/elit_students";
    String username="root";
    String password="Rahul@123456";
    
    
    Connection conn;
    Statement st;
    
    
    
    boolean connection()
    {
         boolean success=false;
        try{
           
            conn=DriverManager.getConnection(db,username,password);
            
            success= true;
        }catch(Exception e){
            
        }
        return success;
    }
    
    
    
    boolean closeConnection()
    {
     boolean success=false;
     try{
         st.close();
         conn.close();
         success=true;
     }catch(Exception e){
         
     }
     return success;
    }
    
    
    
    boolean runSql(boolean update,String sql)
    {
     boolean success=false;
     try{
          st=conn.createStatement();
         if(update)
         {
            
             st.executeUpdate(sql);
             
         }
         else{
           
             st.executeQuery(sql);
         }
         success=true;
     }catch(SQLException e)
     {
         
     }
     return success;
    }
}
