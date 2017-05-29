<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<script type="text/javascript" src="resources/js/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="resources/js/jquery.dataTables.js"></script>
<link type="text/css" rel="stylesheet"
	href="resources/css/dataTables.jqueryui.css">
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

<script type="text/javascript">
	function backButton()
	{
		window.location='welcome';
	}
	function highlightSearch() 
	{
    	var text = document.getElementById("Keyword").value;
    	if(text)
    	{
    	var query = new RegExp("(\\b" + text + "\\b)", "gim");
    	var e = document.getElementById("tbod").innerHTML;
    	var enew = e.replace(/(<span>|<\/span>)/igm, "");
    	document.getElementById("tbod").innerHTML = enew;
    	var newe = enew.replace(query, "<span>$1</span>");
    	document.getElementById("tbod").innerHTML = newe;
    	}
}

</script>

<style type="text/css">
html, body 
{
  overflow-x: hidden;
}

.highlight
{
	background-color:yellow;
}

#tbod span
{
	background-color:yellow;
}
</style>

<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<title>NetSuite Ask Me</title>

</head>
<body>
<!-- 	<div class="headerSection" id="header"> -->
<!-- 		<table width="100%" border="0" cellpadding="1"> -->
<!-- 			<tr> -->
<!-- 				<td align="left" width="20%"><img width="65%" height="50%" -->
<!-- 					src="resources/image/cap.jpg" alt="Insert Logo Here" -->
<!-- 					name="Insert_logo" id="Insert_logo" -->
<!-- 					style="display: block;" /> -->
<!-- 				</td> -->
<!-- 				<td align="center" -->
<!-- 					style="font-size: 45px; font-family: Arial; font-weight: bolder; color: #000000"> -->
<!-- 					NetSuite Ask Me</td> -->
<!-- 				<td align="right" width="20%"><img width="50%" height="25%" -->
<!-- 					src="resources/image/adc_logo.jpg" alt="Insert Logo Here" -->
<!-- 					name="Insert_logo" id="Insert_logo" -->
<!-- 					style="display: block;" /> -->
<!-- 				</td> -->
<!-- 			</tr> -->
<!-- 		</table> -->
<!-- 	</div> -->
			
	<form:form method="POST" action="search" modelAttribute="projDtls">
	<center>
		<div class="container" id="Containr">
			<h4 align="center" style="color:red;"><c:out value="${errMsg}"/></h4>
			<div class="searchSection" style="background-color:#FFF;font: 11px Arial;">
				<table width="100%" border="0" cellpadding="1">
					<tr>
						<td align="right" width="5%">Keyword :</td>
						<td align="left" width="13%"><form:input
								style="width: 100%;font: 11px Arial;" path="description" id="Keyword"
								placeholder="Enter Description Keyword" title="Enter Description Keyword" /></td>
								
						<td align="right" width="8%">Project Name :</td>
						<td align="left" width="14%"><form:select
								style="width: 100%;font: 11px Arial;" id="Project_Name" path="projectName">
								<form:option value="All" label=" " />
								<form:options items="${projDtls.projectNameMap}" />
							</form:select></td>
							
						<td align="right" width="10%">Customization Type :</td>
						<td align="left" width="12%"><form:select
								style="width: 100%;font: 11px Arial;" id="Customization_Type"
								path="customizationType">
								<form:option value="All" label=" " />
								<form:options items="${projDtls.customizationTypeMap}" />
							</form:select></td>
							
						<td align="right" width="8%">Project Sector :</td>
						<td align="left" width="11%"><form:select
								style="width: 100%;font: 11px Arial;" id="Project_Sector" path="projectSector">
								<form:option value="All" label=" " />
								<form:options items="${projDtls.projectSectorMap}" />
							</form:select></td>
							
						<td align="right" width="8%">Module Name :</td>
						<td align="left" width="14%"><form:select
								style="width: 100%;font: 11px Arial;" id="Module_Name" path="moduleName">
								<form:option value="All" label=" " />
								<form:options items="${projDtls.moduleNameMap}" />
							</form:select></td>
						
					</tr>
					<tr><td><font size="1px">&nbsp;</font></td>
					</tr>
					<tr>
						<td align="right" width="10%" colspan="5" style="width: 550px; "> <input name="button" type="button" class="header" id="button" align="right"
							value="Reset"  onClick="backButton();"/> </td>
						<td align="left" width="10%" colspan="5"><input name="Search" type="submit" value="Search" style="font-family: Arial; font-size: 12px; padding: 2px 5px 2px 5px; text-decoration: none;"/></td>
						<td align="left" width="30%" colspan="5" style="width: 550px; ">
						<!--   <a href="http://www.google.com/"> -->
						 <input name="button" type="button" class="header" id="button" align="right" value="Add Project" onclick="window.location='/OATF/login';"/>
						<!--  </a> -->
						</td>
					</tr>
					<tr></tr><tr></tr>
				</table>
			</div>
			<div class="resultTable" style="height: 655px; border: 1px solid; background-color:#DCEEFC;">
				<table id="result" style="border-collapse: collapse;">
					<thead id="resultHeader">
						<tr bgcolor="#006699">
							<th><font color="white" FACE="Arial"><u> Project Name</u></font></th>
							<th><font color="white" FACE="Arial"><u> Project Sector</u></font></th>
							<th><font color="white" FACE="Arial"><u> Customization ID</u></font></th>
							<th><font color="white" FACE="Arial"><u> Description</u></font></th>
							<th><font color="white" FACE="Arial"><u> Module Name</u></font></th>
							<th><font color="white" FACE="Arial"><u> Customization Type</u></font></th>
							<th><font color="white" FACE="Arial"><u> Complexity</u></font></th>
					   <!-- <th><font color="white" FACE="Arial"><u> Planned Effort</u></font></th>
							<th><font color="white" FACE="Arial"><u> Actual Effort</font></u></th>
							<th><font color="white" FACE="Arial"><u> Percent Reuse</font></u></th> -->
							<th><font color="white" FACE="Arial"><u> Functional Gap</u></font></th>
							<th><font color="white" FACE="Arial"><u> Technical Solution</u></font></th>
							<th><font color="white" FACE="Arial"><u> Code and Document zip</u></font></th>
						</tr>
					</thead>
					<c:out value="${projDtls.projectInfo[i].fileSize}" />
					<c:out value="" />
					<tbody id="tbod" >
						<c:if test="${not empty projDtls.projectInfo && null!=projDtls.projectInfo}">													
							<c:forEach var="i" begin="0" end="${fn:length(projDtls.projectInfo)-1}">
								<tr>
									<td bgcolor="#E5EEF2"><font FACE="Arial"><c:out value="${projDtls.projectInfo[i].projectName}1" /></font></td>
									<td bgcolor="#E5EEF2"><font FACE="Arial"><c:out value="${projDtls.projectInfo[i].projectSector}" /></font></td>
									<td bgcolor="#E5EEF2"><font FACE="Arial"><c:out value="${projDtls.projectInfo[i].customizationId}" /></font></td>
									<td bgcolor="#E5EEF2"><font FACE="Arial"><c:out value="${projDtls.projectInfo[i].description}" /></font></td>
									<td bgcolor="#E5EEF2"><font FACE="Arial"><c:out value="${projDtls.projectInfo[i].moduleName}" /></font></td>
									<td bgcolor="#E5EEF2"><font FACE="Arial"><c:out value="${projDtls.projectInfo[i].customizationType}" /></font></td>
									<td bgcolor="#E5EEF2"><font FACE="Arial"><c:out value="${projDtls.projectInfo[i].complexity}" /></font></td>
							   <%-- <td bgcolor="#E5EEF2"><font FACE="Arial"><c:out value="${projDtls.projectInfo[i].plannedEffort}" /></font></td>
									<td bgcolor="#E5EEF2"><font FACE="Arial"><c:out value="${projDtls.projectInfo[i].actualEffort}" /></font></td>
									<td bgcolor="#E5EEF2"><font FACE="Arial"><c:out value="${projDtls.projectInfo[i].percentReuse}" /></font></td> --%>
									<td bgcolor="#E5EEF2"><font FACE="Arial"><c:out value="${projDtls.projectInfo[i].functionalGap}" /></font></td>
									<td bgcolor="#E5EEF2"><font FACE="Arial"><c:out value="${projDtls.projectInfo[i].technicalSoln}" /></font></td>
									<td bgcolor="#E5EEF2"><font FACE="Arial">
									    <c:if test="${projDtls.projectInfo[i].fileSize > 0}">
											<a href="/OATF/downloadFile?filePath=${projDtls.projectInfo[i].customizationId}">Download File</a>
										</c:if> 
										<c:if test="${projDtls.projectInfo[i].fileSize == 0}">
										Please contact  OATF (<a href="mailto:appsoneoracleidpfactory.in@capgemini.com">IN, Appsone Oracle IDP Factory</a>) to get details.
									   </c:if>
									</font></td>
								</tr>
							</c:forEach>
							
						</c:if>
					</tbody>
				</table>
				<script type="text/javascript"> highlightSearch(); </script>
			</div>
		</div>
	</center>
	</form:form>
<!-- 	    <div class="footerSection" id="footer"> -->
<!-- 	    	<div align="right"> -->
<!-- 	<font size="1" face="Arial" color=black> -->
<!-- 		Best viewed in resolution 1280*1024 on Chrome. -->
<!-- 	</font></div> -->
<!--     </div> -->

</body>
</html>