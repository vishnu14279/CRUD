import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import org.sqlite.SQLiteDataSource;
import java.sql.PreparedStatement;
public class connect {
	static SQLiteDataSource ds = null;
	
public static void connection() {
        	
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
       Scanner scan = new Scanner(System.in);
       boolean repeat = false;
      do {
       System.out.println("choose a CRUD operation");
       System.out.println("1.create");
       System.out.println("2.Read");
       System.out.println("3.Update");
       System.out.println("4.Delete");
    
       int choice = scan.nextInt();
       switch(choice) {
       
       case 1:
    	  connect create = new connect();
    	  try { System.out.println("enter empno");
   	   int empno = scan.nextInt();
   	   System.out.println("enter ename");
   	   String ename = scan.next();
   	   System.out.println("enter sal");
   	   int sal = scan.nextInt();
   	   
  			create.insert(empno, ename, sal);
  			
  		} catch (Exception exception) {
  			// TODO Auto-generated catch block
  			exception.printStackTrace();
  		}
      	break;
       
       case 2:
    	connect read = new connect();
    	try {
			read.display();
		} catch (Exception exception) {
			// TODO Auto-generated catch block
			exception.printStackTrace();
		}
    	break;
    	
       case 3:
    	   connect update = new connect();
    	   try {
    	   System.out.println("enter empno");
    	   int empno = scan.nextInt();
    	   System.out.println("enter ename");
    	   String ename = scan.next();
    	   System.out.println("enter sal");
    	   int sal = scan.nextInt();
      	  //try {
      		update.update(empno,ename,sal);

   		} catch (Exception exception) {
   			// TODO Auto-generated catch block
   			exception.printStackTrace();
   		}
      	 
       	break;
       	
       case 4:
    	   connect delete = new connect();
    	   try {
    	   System.out.println("enter empno");
    	   int empno = scan.nextInt();
    	   
      		delete.delete(empno);

   		} catch (Exception exception) {
   			// TODO Auto-generated catch block
   			exception.printStackTrace();
   		}
      	 
       	break;
       }
       System.out.println();
       System.out.println("press y to repeat,press any key to terminate");
       char Char = scan.next().charAt(0);
      
      if(Char=='y') {
    	  repeat = true;
      }
      else
    	  repeat = false;
      }
      while(repeat);
      scan.close();
       

    }
    
    

public void display() throws Exception {
      
        
        try{
        	Connection connect=null;
        	Statement stmt=null;
        	Class.forName("org.sqlite.JDBC");
        	connect=DriverManager.getConnection("jdbc:sqlite:C:\\\\sqlite\\\\jdbc-crud\\\\EMP_CRUD.db");
        	connect.setAutoCommit(false);
        	System.out.println("Opened successfully");
        	stmt=connect.createStatement();
            
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
              connect.close();
          } catch ( SQLException exception ) {
              exception.printStackTrace();
              System.exit( 0 );
          }
		
    }


public  void insert(int empno, String ename, int sal)throws Exception
{

    Connection connect = null;
      Statement stmt = null;
      try {
        Class.forName("org.sqlite.JDBC");
        connect = DriverManager.getConnection("jdbc:sqlite:C:\\\\\\\\sqlite\\\\\\\\jdbc-crud\\\\\\\\EMP_CRUD.db");
        connect.setAutoCommit(false);
        System.out.println("Opened database successfully");

        stmt = connect.createStatement();
        String sql = "INSERT INTO EMP_CRUD (EMPLOYEE_NUMBER, EMPLOYEE_NAME, SALARY) VALUES(?,?,?)"; 
       
        PreparedStatement pstmt = connect.prepareStatement(sql);
        
        pstmt.setInt(1, empno); 
        pstmt.setString(2, ename);
        pstmt.setInt(3, sal);
      
        pstmt.executeUpdate();
        stmt.close();
        connect.commit();
        connect.close();
      } catch ( Exception e ) {
        System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        System.exit(0);
      }
      System.out.println("Records created successfully");
	
}


public void update(int empno, String ename, int sal )throws Exception
{
	Connection connect = null;
	Statement stmt = null;
  try {
    Class.forName("org.sqlite.JDBC");
    connect = DriverManager.getConnection("jdbc:sqlite:C:\\\\\\\\\\\\\\\\sqlite\\\\\\\\\\\\\\\\jdbc-crud\\\\\\\\\\\\\\\\EMP_CRUD.db");
    connect.setAutoCommit(false);
    System.out.println("Opened database successfully");

    stmt = connect.createStatement();
    String sql = "UPDATE EMP_CRUD set SALARY = ? ,"
    		+"EMPLOYEE_NAME = ?"
    		+"where EMPLOYEE_NUMBER= ? ";
 

    PreparedStatement pstmt = connect.prepareStatement(sql);
   
    pstmt.setInt(1, sal); 
    pstmt.setString(2, ename);
    pstmt.setInt(3, empno);
  
    pstmt.executeUpdate();
    

    connect.commit();
    stmt.close();
    connect.close();
  } catch ( Exception e ) {       
    System.err.println( e.getClass().getName() + ": " + e.getMessage() );
    System.exit(0);
  }
  	System.out.println("updated sucessfully");
}

public void delete(int empno)throws Exception
{
	Connection connect = null;
	Statement stmt = null;
  try {
    Class.forName("org.sqlite.JDBC");
    connect = DriverManager.getConnection("jdbc:sqlite:C:\\\\\\\\\\\\\\\\sqlite\\\\\\\\\\\\\\\\jdbc-crud\\\\\\\\\\\\\\\\EMP_CRUD.db");
    connect.setAutoCommit(false);
    System.out.println("Opened database successfully");

    stmt = connect.createStatement();
    String sql = "DELETE FROM EMP_CRUD WHERE EMPLOYEE_NUMBER = ?";
 

    PreparedStatement pstmt = connect.prepareStatement(sql);
   
   
    pstmt.setInt(1, empno);
  
    pstmt.executeUpdate();
    

    connect.commit();
    stmt.close();
    connect.close();
  } catch ( Exception e ) {       
    System.err.println( e.getClass().getName() + ": " + e.getMessage() );
    System.exit(0);
  }
  	System.out.println("deleted sucessfully");
}


}
    
    
    
    
    
    
    
    
    
    
    
