package com.springapp.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import com.springapp.model.EmployeeCrud;
import com.springapp.Dao.EmployeeDao;

@Controller

public class EmployeeController {
	
	 @Autowired
	private EmployeeDao employeeDao;
	
	/***
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value ="/enroll",method = RequestMethod.GET)
	public String newRegistration(ModelMap model) {
		EmployeeCrud employee = new EmployeeCrud();
		model.addAttribute("employee", employee);
		return "enroll";
	}
	
	/***
	 * 
	 * @param employee
	 * @param result
	 * @param model
	 * @param redirectAttributes
	 * @return
	 */
	@RequestMapping(value ="/save",method = RequestMethod.POST)
	public String saveRegistration(@Valid EmployeeCrud employee,
	BindingResult result, ModelMap model,RedirectAttributes redirectAttributes) {

		if (result.hasErrors()) {
			return "enroll"; 
		}
		employeeDao.save(employee);		
		return "redirect:/view_employee/1";
	}
	
	/***
	 * 
	 * @return
	 */
	@RequestMapping("/view_employee")  
    public ModelAndView view_employee(){  
        List<EmployeeCrud> list=employeeDao.getAllemployees();
        return new ModelAndView("view_employee","list",list);  
    } 
	
	/***
	 * 
	 * @param pageid
	 * @return
	 */
	@RequestMapping(value="/view_employee/{pageid}")  
    public ModelAndView edit(@PathVariable int pageid){  
        int total=2;  
        if(pageid==1){}  
        else{  
            pageid=(pageid-1)*total+1;  
        }  
        List<EmployeeCrud> list=employeeDao.getemployeesByPage(pageid,total);    
        return new ModelAndView("view_employee","list",list);  
    }
	
	/***
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	 @RequestMapping(value="/editemployee/{id}")  
	    public String edit(@PathVariable int id,ModelMap model){  
	       EmployeeCrud employee=employeeDao.getemployeeById(id);  
	       model.addAttribute("employee", employee);
			return "editemployee";
	        
	        
	    } 
	 
	 /***
	  * 
	  * @param emp
	  * @return
	  */
	 @RequestMapping(value="/editsave",method = RequestMethod.POST)  
	    public ModelAndView editsave(@ModelAttribute("employee") EmployeeCrud emp){  
	    	System.out.println("EMPLOYEE_NUMBER is"+emp.getEMPLOYEE_NUMBER());
	    	employeeDao.update(emp);  
	        return new ModelAndView("redirect:/view_employee/1");  
	    }  
	 
	/***
	 *  
	 * @param id
	 * @return
	 */
	    @RequestMapping(value="/deleteemployee/{id}",method = RequestMethod.GET)  
	    public ModelAndView delete(@PathVariable int id){  
	    	employeeDao.delete(id);  
	        return new ModelAndView("redirect:/view_employee/1");  
	    }  
	    
	  
	
	
	/***
	 * 
	 * @return
	 */
	 @ModelAttribute("pageCount")
		public List<String> initializePageCount() {
		    int total=2;  
			List<String> pageCount = new ArrayList<String>();
			int count=employeeDao.count(); 
			int result=((count/total)+ (count%total));
			for(int k=0;k<result;k++) {
				pageCount.add(new Integer(k).toString());
			}
			
			return pageCount;
		}

}