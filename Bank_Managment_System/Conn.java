package Bank_Managment_System;
import java.sql.*;

public class Conn {

    Connection c ;
    Statement s;
    public Conn() {
        try{
            
            c = DriverManager.getConnection("jdbc:mysql:///bms", "root", "aradhya@0312");
            s = c.createStatement();
        
        } catch(Exception e ){
            System.out.println(e);
        }
    }
}
