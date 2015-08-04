<%@ page language="java" contentType="text/html; charset=UTF-8"  
 pageEncoding="UTF-8"%>  
<%@ taglib uri="/struts-tags" prefix="form"%>  
  
<html>  
<head>  
<title>Struts Form</title>  
</head>  
<body>  
 <center>  
  
  <h2>Registration Form</h2>  
    
   
  
  <form:form action="register">  
   <form:textfield name="firstName" label="First Name: " />  
   <form:textfield name="lastName" label="Last Name: " />  
   <form:textfield name="email" label="Email: " />  
   <form:textfield name="phone" label="Phone: " />  
   <form:submit />  
  </form:form>  
 </center>  
</body>  
</html>  