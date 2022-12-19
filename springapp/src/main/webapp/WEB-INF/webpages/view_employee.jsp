<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	
	<link href="<c:url value='/static/css/custom.css' />" rel="stylesheet"></link>
	<link href="<c:url value='/static/css/main.css' />" rel="stylesheet"></link>
		
		<style>
        body {
             background-color: lightblue;
             }
             
        h1 {
            color: navy;
            margin-left: 20px;
           }
           
  	    h2 {
		    text-align: left;
		    display: block;
		    font-size: 1em;
		    margin-top: 0.67em;
		    margin-bottom: 0.67em;
		    margin-left: 0;
		    margin-right: 0;
		    font-weight: bold;
		    color:navy;
           }
  
    </style>
</head>

<body>
   <h1  style="font-family:Chaparral Pro Light; align="center">EMPLOYEE DATA</h1>
   <table id="t02"  cellpadding="2">
   <tr>
      <th>
          <a  href="/springapp/enroll"><h2>Home Page: Enroll New Employee</h2></a>
      </th>

   </tr>
   </table>
   
<table >
    <tr>
    <th>Page No : 
 	<c:forEach var="count" items="${pageCount}"  varStatus="theCount"> 
	<a align="right" href="/springapp/view_employee/${theCount.count}">${theCount.count}</a>   
	</c:forEach>  
	</th>
   	</tr>

</table>
   
	<form:form  class="form-horizontal" >
	<table id="t01" border="2" width="70%" cellpadding="2">
	
	<tr><th style="color:black;">EMPLOYEE NUMBER</th><th style="color:black;">EMPLOYEE NAME</th>
	<th style="color:black;">SALARY</th><th colspan="2" scope="colgroup" style="color:black;">ACTIONS</th></th></tr>  

   	<c:forEach var="Employee" items="${list}"> 
   	<tr>  
   	<td>${Employee.EMPLOYEE_NUMBER}</td>  
   	<td>${Employee.EMPLOYEE_NAME}</td> 
   	<td>${Employee.SALARY}</td>    
   	<td><a href="/springapp/editemployee/${Employee.EMPLOYEE_NUMBER}">Edit</a></td>  
   	<td><a href="/springapp/deleteemployee/${Employee.EMPLOYEE_NUMBER}">Delete</a></td>  
   	</tr>  
   	</c:forEach> 
   	
   	</table>  
    <br/>
   	</form:form>
</body>
</html>
