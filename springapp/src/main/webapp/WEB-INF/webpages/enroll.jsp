<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>

<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	
	<title>Employee Enrollment Form</title>
	
	<link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
	<link href="<c:url value='/static/css/custom.css' />" rel="stylesheet"></link>
	<link href="<c:url value='/static/css/main.css' />" rel="stylesheet"></link>
	
   <style>
        box
	    position:fiexd;
		width:50%;
		margin-left: 20px;
		margin-top: 20px;
		margin-bottom: 20px;
		padding: 20px;
		background-color: #E8E1E1;
		border: 1px solid #ddd;
		border-radius: 4px;
   </style>
</head>

<body>

 	<div class="form-container">
 	
 	<h1 style="color:navy;">Employee Enrollment Form</h1>
 	
	<form:form method="POST" modelAttribute="employee"  class="form-horizontal" action="save">
	    <div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="EMPLOYEE_NUMBER">EMPLOYEE NUMBER</label>
				<div class="col-md-7">
					<form:input type="text" path="EMPLOYEE_NUMBER" id="EMPLOYEE_NUMBER" class="form-control input-sm"/>
					<div class="has-error">
						<form:errors path="EMPLOYEE_NUMBER" class="help-inline"/>
					</div>
				</div>
			</div>
		</div>
	    
        
		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="EMPLOYEE_NAME">EMPLOYEE_NAME</label>
				<div class="col-md-7">
					<form:input type="text" path="EMPLOYEE_NAME" id="EMPLOYEE_NAME" class="form-control input-sm"/>
					<div class="has-error">
						<form:errors path="EMPLOYEE_NAME" class="help-inline"/>
					</div>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="SALARY">SALARY</label>
				<div class="col-md-7">
					<form:input type="text" path="SALARY" id="SALARY" class="form-control input-sm"/>
					<div class="has-error">
						<form:errors path="SALARY" class="help-inline"/>
					</div>
				</div>
			</div>
		</div>


		<div class="row">
			<div class="form-actions floatRight">
				<input type="submit" value="Register" class="btn btn-primary btn-sm">
			</div>
		</div>
		
	</form:form>
	</div>
</body>
</html>