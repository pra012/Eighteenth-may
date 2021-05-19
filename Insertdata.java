import java.sql.*;

class A
{

public static void main(String... ar)
{
try
{

String query1 =  "INSERT INTO MyTable (ID, FirstName, LastName, Age)"
		 + "VALUES ('1', 'Tom', 'Hanks', '61 ')";

String query2 =  "INSERT INTO MyTable (ID, FirstName, LastName, Age)" 
		 + "VALUES ('2', 'Johnny', 'Depp', '54')";

String query3 =  "INSERT INTO MyTable (ID, FirstName, LastName, Age)" 
		 + "VALUES ('3', 'Leo', 'Dicaprio', '42')";

		 
			 
Class.forName("oracle.jdbc.driver.OracleDriver");


Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","scott", "tiger");
 
Statement stmt = con.createStatement();


int count = stmt.executeUpdate(query1);
System.out.println("Number of rows updated in database =  " + count);

count = stmt.executeUpdate(query2);
System.out.println("Number of rows updated in database = " + count);


count = stmt.executeUpdate(query3);
System.out.println("Number of rows updated in database = " + count);

}
catch(Exception e)
{
System.out.println(e);
}
