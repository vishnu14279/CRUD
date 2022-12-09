import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import org.sqlite.SQLiteDataSource;

public class connect {
	static SQLiteDataSource ds = null;
	
	public static void connection() {
        
Connection c=null;
try
{
	Class.forName("org.sqlite.JDBC");
	c=DriverManager.getConnection("jdbc:sqlite:C:\\\\sqlite\\\\jdbc-crud\\\\EMP_CRUD.db");
}catch(Exception e)
{
	System.out.println(e.getClass().getName()+":"+e.getMessage());
	System.exit(0);
}
System.out.println("opened database Successfully");
		
        try {
            ds = new SQLiteDataSource();
            String url = "jdbc:sqlite:C:\\sqlite\\jdbc-crud\\EMP_CRUD.db";
            ds.setUrl( "jdbc:sqlite:C:\\sqlite\\jdbc-crud\\EMP_CRUD.db");
            System.out.println("Inside Try");
        } catch ( Exception e ) {
        	 System.out.println("Inside catch");
            e.printStackTrace();
            System.exit(0);
            
        }
	}
    public static void main(String[] args) {
       Scanner s = new Scanner(System.in);
       System.out.println("choose a CRUD operation");
       System.out.println("1.Create");
       System.out.println("2.Read");
       System.out.println("3.Update");
       System.out.println("4.Delete");
       int choice = s.nextInt();
       switch(choice) {
       
      
       
       case 2:
    	connect d = new connect();
    	try {
			d.display();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	break;
       }
    }
    
    
    
    

public void display() throws Exception {
       // String query = "SELECT * FROM EMP_CRUD";
        
        try{
        	Connection c=null;
        	Statement stmt=null;
        	Class.forName("org.sqlite.JDBC");
        	c=DriverManager.getConnection("jdbc:sqlite:C:\\\\sqlite\\\\jdbc-crud\\\\EMP_CRUD.db");
        	c.setAutoCommit(false);
        	System.out.println("Opened successfully");
        	stmt=c.createStatement();
            
            String query = "SELECT * FROM EMP_CRUD";
              ResultSet rs = stmt.executeQuery(query);

              while ( rs.next() ) {
                  int EMPNO = rs.getInt( "EMPLOYEE_NUMBER" ); 
                  String ENAME = rs.getString( "EMPLOYEE_NAME" );
                  String SALARY = rs.getString("SALARY");

                  System.out.println( "Result: EMPNO = " + EMPNO +
                      ", ENAME = " + ENAME + ", SALARY = " + SALARY );
              }
              rs.close();
              stmt.close();
              c.close();
          } catch ( SQLException e ) {
              e.printStackTrace();
              System.exit( 0 );
          }
		
    }

}
    
    
    
    
    
    
    
    
    
    
    
