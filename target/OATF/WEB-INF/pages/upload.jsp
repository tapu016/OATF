<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script type="text/javascript" src="resources/js/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="resources/js/jquery.dataTables.js"></script>
<link type="text/css" rel="stylesheet" href="resources/css/dataTables.jqueryui.css">
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
<head>
<title>File Uploading Form</title>
</head>
<body>
<div class="headerSection" id="header">
<table width="100%" border="0" cellpadding="1">
			<tr>
				<td align="left" width="20%"><img width="65%" height="50%"
					src="resources/image/cap.jpg" alt="Insert Logo Here"
					name="Insert_logo" id="Insert_logo"
					style="display: block;" />
				</td>
				<td align="center"
					style="font-size: 45px; font-family: Arial; font-weight: bolder; color: #000000">
					NetSuite Ask Me</td>
				<td align="right" width="20%"><img width="50%" height="25%"
					src="resources/image/adc_logo.jpg" alt="Insert Logo Here"
					name="Insert_logo" id="Insert_logo"
					style="display: block;" />
				</td></td>
			</tr>
		</table>
</div>
<h3 align="center">File Upload:</h3>
<br />
<%-- 		<form method="POST" enctype="multipart/form-data" action="/"> --%>
<form:form method="POST" action="upload" modelAttribute="projDtls">
		<div>
			<table align="center" width="100%" border="0" cellpadding="1">
					<tr>
						<td align="right" width="5%">Description</td>
						<td align="left" width="13%">
						<input style="width: 100%;font: 11px Arial;" id="desc" 
								placeholder="Enter Description Keyword" title="Enter Description Keyword" /></td>
								
								<td align="right" width="5%">Functional Gap</td>
						<td align="left" width="13%"><input
								style="width: 100%;font: 11px Arial;" id="Keyword"
								placeholder="Enter Description Keyword" title="Enter Description Keyword" /></td>
							</tr>	
							<tr>
						<td align="right" width="8%">Project Name :</td>
						<td align="left" width="14%"><form:select
								style="width: 100%;font: 11px Arial;" id="Project_Name" path="projectName">
								<form:option value="All" label=" " />
								<form:options items="${projDtls.projectNameMap}" />
							</form:select></td>
															<td align="right" width="5%">Technical Solution</td>
						<td align="left" width="13%"><input
								style="width: 100%;font: 11px Arial;" id="Keyword"
								placeholder="Enter Description Keyword" title="Enter Description Keyword" /></td>
							</tr>
							<tr>
						<td align="right" width="10%">Customization Type :</td>
						<td align="left" width="12%"><form:select
								style="width: 100%;font: 11px Arial;" id="Customization_Type"
								path="customizationType">
								<form:option value="All" label=" " />
								<form:options items="${projDtls.customizationTypeMap}" />
							</form:select></td>
							</tr>
							<tr>
						<td align="right" width="8%">Project Sector :</td>
						<td align="left" width="11%"><form:select
								style="width: 100%;font: 11px Arial;" id="Project_Sector" path="projectSector">
								<form:option value="All" label=" " />
								<form:options items="${projDtls.projectSectorMap}" />
							</form:select></td>
							</tr>
							<tr>
						<td align="right" width="8%">Module Name :</td>
						<td align="left" width="14%"><form:select
								style="width: 100%;font: 11px Arial;" id="Module_Name" path="moduleName">
								<form:option value="All" label=" " />
								<form:options items="${projDtls.moduleNameMap}" />
							</form:select></td>
							<td>File to upload:</td><td><input type="file" name="file" /></td>
						
					</tr>
					<tr><td><font size="1px">&nbsp;</font></td>
					<td align="center"  colspan="5"><input type="submit" value="Upload" />
					<input type="button" value="Return To Search" onclick="window.location='/OATF/welcome';" /></td>
					</tr>					
					<tr></tr><tr></tr>
				</table>
			
		</div>
				
				
			
		</form:form>
		    <div class="footerSection" id="footer">
    </div>
</body>
</html>