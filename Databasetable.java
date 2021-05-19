import java.sql.*;
public class CreateDBTable
{
     Connection con;
     CreateDBTable()
     {
          try
          {
               Class.forName("oracle.jdbc.driver.OracleDriver");
               
               con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","local","test");
               
               PreparedStatement ps=con.prepareStatement("create table Student(stdId int primary key,studName VARCHAR(30) not null )");
              
               int count=ps.executeUpdate();
               
               System.out.println(count);
               System.out.println("Table created successfully!!");
          }
          catch (Exception e)
          {
               e.printStackTrace();
          }
     }
     public static void main(String s[])
     {
          new CreateDBTable();
     }
}
