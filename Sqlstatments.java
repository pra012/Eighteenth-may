import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
public class BatchExecuteStatement
{
      
      public static final String DBURL = "jdbc:oracle:thin:@localhost:1521:XE";
      public static final String DBUSER = "local";
      public static final String DBPASS = "test";

      public static void main(String[] args)throws Exception
      {
          Class.forName ("oracle.jdbc.driver.OracleDriver");
          
          Connection con = DriverManager.getConnection (DBURL, DBUSER, DBPASS);
         
          con.setAutoCommit(false);
         
          Statement st=con.createStatement();
          st.addBatch("insert into emp values (101,'jay','jay@gmail.com', 'Pune', 1)");
          st.addBatch("insert into emp values(102,'satyam','satya@gmail.com', 'Mumbai', 1)");
          st.addBatch("insert into emp values(103,'Shivam', 'shiv@gmail.com', 'Noida', 2)");
          st.addBatch("insert into emp values(104,'sandy', 'sandy@gmail.com', 'Delhi', 2)");
       
          int count[]=st.executeBatch();
          con.commit();
      
          for(int i=0;i <= count.length; i++)
          {
               if(count[i]!=0)
               {
                    con.rollback();
                    break;
               }
          }
     }
}
