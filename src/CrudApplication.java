import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import java.sql.PreparedStatement;
public class CrudApplication {
	
	private static final String DATABASE_URL = "jdbc:sqlite:C:\\sqlite\\SQLite_crud\\SQLite_crud";

public static void main(String[] args) throws SQLException {
       Scanner scan = new Scanner(System.in);
       boolean repeat = false;
      do {
       System.out.println("choose a CRUD operation");
       System.out.println("1.Insert");
       System.out.println("2.Read");
       System.out.println("3.Update");
       System.out.println("4.Delete");
    
       int choice = scan.nextInt();
       
       CrudApplication crudApplication = new CrudApplication();
       
       Connection dbConnection = DriverManager.getConnection(DATABASE_URL);
       dbConnection.setAutoCommit(false);
       
       switch(choice) {
       
       case 1:
    	  try { 
    		   System.out.println("Enter Employee_Number");
		   	   int empno = scan.nextInt();
		   	   System.out.println("Enter Employee_Name");
		   	   String ename = scan.next();
		   	   System.out.println("Enter Salary");
		   	   int sal = scan.nextInt();
		
		   	   crudApplication.insert(empno, ename, sal, dbConnection);
  			
  		} catch (Exception exception) {
  			exception.printStackTrace();
  		}
      	break;
       
       case 2:
    	try {
    		crudApplication.display(dbConnection);
		} catch (Exception exception) {
			exception.printStackTrace();
		}
    	break;
    	
       case 3:
    	   try {
    	   System.out.println("Enter Employee_Number which you like to update");
    	   int empno = scan.nextInt();
    	   System.out.println("Enter Employee_Name");
    	   String ename = scan.next();
    	   System.out.println("Enter Salary");
    	   int sal = scan.nextInt();
    	   crudApplication.update(empno, ename, sal, dbConnection );

   		} catch (Exception exception) {
   			exception.printStackTrace();
   		}
      	 
       	break;
       	
       case 4:
    	   try {
    	   System.out.println("Enter Employee_Number");
    	   int empno = scan.nextInt();
    	   crudApplication.delete(empno, dbConnection);

   		} catch (Exception exception) {
   			exception.printStackTrace();
   		}
      	 
       	break;
       }
       System.out.println();
       System.out.println("press y for previous menu, press any key to terminate");
       char input = scan.next().charAt(0);
      
      if(input=='y' || input =='Y') {
    	  repeat = true;
      }
      else
    	  repeat = false;
      System.out.println("Thanks for using our application");
      dbConnection.close();
      }
      while(repeat);
      scan.close();
     
    }
     
/***
 * 
 * @param dbConnection
 * @throws Exception
 */
public void display(Connection dbConnection) throws Exception {

	Statement stmt=dbConnection.createStatement();
    
    String query = "SELECT * FROM EMP_CRUD";
    ResultSet resultset = stmt.executeQuery(query);

      while ( resultset.next() ) {
          int EMPNO = resultset.getInt( "EMPLOYEE_NUMBER" ); 
          String ENAME = resultset.getString( "EMPLOYEE_NAME" );
          String SALARY = resultset.getString("SALARY");

          System.out.println( "Result: EMPNO = " + EMPNO +
              ", ENAME = " + ENAME + ", SALARY = " + SALARY );
      }
      resultset.close();
      stmt.close();
}

/***
 * 
 * @param empno
 * @param ename
 * @param sal
 * @param dbConnection
 * @throws Exception
 */
public  void insert(int empno, String ename, int sal, Connection dbConnection)throws Exception
{
    Statement stmt = dbConnection.createStatement();
    String sql = "INSERT INTO EMP_CRUD (EMPLOYEE_NUMBER, EMPLOYEE_NAME, SALARY) VALUES(?,?,?)"; 
   
    PreparedStatement pstmt = dbConnection.prepareStatement(sql);
    
    pstmt.setInt(1, empno); 
    pstmt.setString(2, ename);
    pstmt.setInt(3, sal);
  
    pstmt.executeUpdate();
    stmt.close();
    dbConnection.commit();
   
  System.out.println("Records created successfully");

}

/***
 * 
 * @param empno
 * @param ename
 * @param sal
 * @param dbConnection
 * @throws Exception
 */
public void update(int empno, String ename, int sal, Connection dbConnection )throws Exception
{	
    dbConnection.setAutoCommit(false);

    Statement stmt = dbConnection.createStatement();
    String sql = "UPDATE EMP_CRUD set SALARY = ? ,"
    		+"EMPLOYEE_NAME = ?"
    		+"where EMPLOYEE_NUMBER= ? ";

    PreparedStatement pstmt = dbConnection.prepareStatement(sql);
   
    pstmt.setInt(1, sal); 
    pstmt.setString(2, ename);
    pstmt.setInt(3, empno);
  
    pstmt.executeUpdate();
    

    dbConnection.commit();
    stmt.close();
 
  	System.out.println("updated sucessfully");
}

/***
 * 
 * @param empno
 * @param dbConnection
 * @throws Exception
 */
public void delete(int empno, Connection dbConnection)throws Exception
{
    Statement stmt = dbConnection.createStatement();
    String sql = "DELETE FROM EMP_CRUD WHERE EMPLOYEE_NUMBER = ?";
 

    PreparedStatement pstmt = dbConnection.prepareStatement(sql);
   
   
    pstmt.setInt(1, empno);
  
    pstmt.executeUpdate();
    

    dbConnection.commit();
    stmt.close();
  	System.out.println("deleted sucessfully");
}

}
    
    
    
    
    
    
    
    
    
    
    
