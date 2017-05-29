<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script type="text/javascript" src="resources/js/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="resources/js/jquery.dataTables.js"></script>
<link type="text/css" rel="stylesheet"
	href="resources/css/dataTables.jqueryui.css">
<!-- <link type="text/css" rel="stylesheet" href="/resources/css/home2.css"> -->
	<script>
	$(document).ready(function() {
		$('#result').dataTable({
			"scrollY" : 580,
			"scrollCollapse" : false,
			"sScrollX": true,
			"jQueryUI" : true,
			"bPaginate" : false,
			"bFilter" : false,
			"order": [[ 8, "desc" ]]
		});
	});
</script>
<body>
<!-- <div class="headerSection" id="header"> -->
<!-- <table width="100%" border="0" cellpadding="1"> -->
<!-- 			<tr> -->
<!-- 				<td align="left" width="20%"><img width="65%" height="50%" -->
<!-- 					src="/resources/image/cap.jpg" alt="Insert Logo Here" -->
<!-- 					name="Insert_logo" id="Insert_logo" -->
<!-- 					style="display: block;" /> -->
<!-- 				</td> -->
<!-- 				<td align="center" -->
<!-- 					style="font-size: 45px; font-family: Arial; font-weight: bolder; color: #000000"> -->
<!-- 					NetSuite Ask Me</td> -->
<!-- 				<td align="right" width="20%"><img width="50%" height="25%" -->
<!-- 					src="/resources/image/adc_logo.jpg" alt="Insert Logo Here" -->
<!-- 					name="Insert_logo" id="Insert_logo" -->
<!-- 					style="display: block;" /> -->
<!-- 				</td>				 -->
<!-- 			</tr> -->
<!-- 		</table> -->
<!-- 	</div> -->
   	 <form:form name="submitForm" method="POST">
        <div align="center">
             <table>
                <tr>
                    <td>User Name</td>
                    <td><input type="text" name="userName" /></td>
                </tr>
                <tr>
                    <td>Password</td>
                    <td><input type="password" name="password" /></td>
                </tr>
                <tr>
                    <td></td>
                    	<td>
                    		<input type="submit" value="Submit" />
                    	</td>
                	</tr>
            	</table>
            	<div style="color: red">${error}</div>
        	</div>
    	</form:form>   
    	
<!--     	<div class="footerSection" id="footer"> -->
<!--     	</div> -->
	</body>
</html>