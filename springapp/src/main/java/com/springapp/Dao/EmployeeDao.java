package com.springapp.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import com.springapp.model.EmployeeCrud;


public class EmployeeDao  {
	
	
	JdbcTemplate template;  
	 /***
	  *  
	  * @param template
	  */
	public void setTemplate(JdbcTemplate template) {  
	    this.template = template;  
	}  
	
	/***
	 * 
	 * @param p
	 */
	public void save(EmployeeCrud p) {
		
		String sql="INSERT INTO EMP_CRUD (EMPLOYEE_NUMBER, EMPLOYEE_NAME, SALARY) VALUES('"+p.getEMPLOYEE_NUMBER()+"','"+p.getEMPLOYEE_NAME()+"','"+p.getSALARY()+"')";
		System.out.println(sql);
	     template.update(sql);  
	}
	
	/***
	 * 
	 * @return
	 */
	public List<EmployeeCrud> getAllemployees() {
		
		return template.query("select * from EMP_CRUD",new ResultSetExtractor<List<EmployeeCrud>>(){  
		    
		     public List<EmployeeCrud> extractData(ResultSet rs) throws SQLException,  
		            DataAccessException {  
		      
		        List<EmployeeCrud> list=new ArrayList<EmployeeCrud>();  
		        while(rs.next()){  
		        	EmployeeCrud e=new EmployeeCrud();  
		        	e.setEMPLOYEE_NUMBER(rs.getInt(1));  
			        e.setEMPLOYEE_NAME(rs.getString(2));  
			        e.setSALARY(rs.getInt(3));  
			      
		        list.add(e);  
		        }  
		        return list;  
		        }  
		    });  
		  
		  }
	/***
	 * 
	 * @param pageid
	 * @param total
	 * @return
	 */
	public List<EmployeeCrud> getemployeesByPage(int pageid, int total) {
		// TODO Auto-generated method stub
		 String sql="select * from EMP_CRUD limit "+(pageid-1)+","+total;  
		 return template.query(sql,new ResultSetExtractor<List<EmployeeCrud>>(){  
		    
		     public List<EmployeeCrud> extractData(ResultSet rs) throws SQLException,  
		            DataAccessException {  
		      
		        List<EmployeeCrud> list=new ArrayList<EmployeeCrud>();  
		        
		        while(rs.next()){  
		        	EmployeeCrud e=new EmployeeCrud();  
		        e.setEMPLOYEE_NUMBER(rs.getInt(1));  
		        e.setEMPLOYEE_NAME(rs.getString(2));  
		        e.setSALARY(rs.getInt(3));  
		       
		        list.add(e);  
		        }  
		        return list;  
		        }  
		    });  
		  }
	
	/***
	 * 
	 * @param id
	 * @return
	 */
	public EmployeeCrud getemployeeById(int id) {
		
				 return template.query("select * from EMP_CRUD where EMPLOYEE_NUMBER="+id,new ResultSetExtractor<EmployeeCrud>(){  
					    
				     public EmployeeCrud extractData(ResultSet rs) throws SQLException,  
				            DataAccessException {  
				      
				    	 EmployeeCrud e=new EmployeeCrud();  
				        while(rs.next()){  
				        	e.setEMPLOYEE_NUMBER(rs.getInt(1));  
					        e.setEMPLOYEE_NAME(rs.getString(2));  
					        e.setSALARY(rs.getInt(3));  
					  
				        }  
				        return e;  
				        }  
				    });  
			}


    /***
     * 
     * @return
     */
     public int count() {
		String sql="select count(*) from EMP_CRUD";
		int count = template.queryForObject(sql,Integer.class);
		return count;
		  }


    /***
     * 
     * @param p
     */
	public void update(EmployeeCrud p) {
		String sql="update EMP_CRUD set EMPLOYEE_NAME='"+p.getEMPLOYEE_NAME()+"',SALARY='"+p.getSALARY()+"' where EMPLOYEE_NUMBER="+p.getEMPLOYEE_NUMBER()+"";
		System.out.println(sql);
       template.update(sql);  
	}


    /***
     * 
     * @param id
     */
	public void delete(int id) {
		String sql="delete from EMP_CRUD where EMPLOYEE_NUMBER="+id+"";  
	    template.update(sql);  
		
	}

}