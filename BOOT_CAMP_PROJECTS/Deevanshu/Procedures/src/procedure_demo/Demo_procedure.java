package procedure_demo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.*;


public class Demo_procedure {

    
        public static void main(String args[])
            {
            try
                {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/xe","hr","hr");
               
               /*  CREATE OR REPLACE PROCEDURE MYPROC(ID varchar2)
			IS BEGIN DELETE FROM JOBS WHERE JOB_ID=ID;
END MYPROC;
*/
                CallableStatement cs2 = con.prepareCall("{call MYPROC(?)}");
             
                cs2.setString(1,"Infogain");
              
               int i= cs2.executeUpdate();
               if (i>0)
            	   
            	   System.out.println(i + " Rows deleted");
               
               else
            	   System.out.println("Check your Query");
               
            }
            catch(Exception e)
                {
                e.printStackTrace();
            }
        }
   }