<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="hostPathogenList.hostPathogen"/></title>
    <meta name="menu" content="AdminMenu"/>
</head>

<div class="col-sm-10">
    <h2>Host-Pathogen Information</h2>

    <table class="table-striped" cellpadding="5">
        <tr>
            <th><fmt:message key="hostPathogen.host.fullName"/>:</th>
            <td><h3><i><a href="/hostform?id=${hostPathogen.host.id}"/><c:out value="${hostPathogen.host.fullName}"/></i></h3></td>
        </tr>
        <tr>
            <th><br></th>
            <td><br></td>
        </tr>            
        <tr>
            <th><fmt:message key="pathogenList.pathogen"/>:</th>
            <td><h3><i><a href="/pathogenform?id=${hostPathogen.pathogen.id}"/><c:out value="${hostPathogen.pathogen.fullTaxonName}"/></i>
            		   <a href="/pathogenform?id=${hostPathogen.pathogen.id}"/><c:out value="${hostPathogen.pathogen.virusNames}"/>
            </h3></td>
        </tr>
        <tr>
            <th><br></th>
            <td><br></td>
        </tr>            
        <tr>
            <th><fmt:message key="hostPathogen.plantPart"/>:</th>
            <td><c:out value="${hostPathogen.plantPart}"/></td>
        </tr>
        <tr>
            <th><fmt:message key="pathogen.fungalState"/>:</th>
            <td><c:out value="${hostPathogen.rustState}"/></td>
        </tr>        
        <tr>
            <th><fmt:message key="hostPathogen.symptom"/>:</th>
            <td><c:out value="${hostPathogen.symptom}"/></td>
        </tr>
        <tr>
            <th><br></th>
            <td><br></td>
        </tr>                         
        <tr>
            <th><fmt:message key="host.notes"/>:</th>
            <td><c:out value="${hostPathogen.notes}"/></td>
        </tr>        
    </table>
    <br>
    <h2>Location Information</h2>
	<br>
    <label class="control-label"><fmt:message key="hostPathogen.locations"/>:</label>
    <div class="readonly">
        <c:forEach var="location" items="${hostPathogen.locationList}" varStatus="status">
            <c:out value="${location.interpretation}"/>&nbsp;&nbsp;[<c:out value="${location.country}"/>]<c:if test="${!status.last}">&nbsp;,&nbsp;</c:if>
        </c:forEach>
    </div>
	<br>
    <h2>Reference Information</h2>
	<br>
 	<table class="table-striped" cellpadding="5">
        <tr>
            <th><fmt:message key="reference.year"/>:&nbsp;</th>
            <td><c:out value="${hostPathogen.reference.year}"/></td>
        </tr> 	
        <tr>
            <th><fmt:message key="reference.chapterArticleTitle"/>:&nbsp;</th>
            <td><c:out value="${hostPathogen.reference.chapterArticleTitle}"/></td>
        </tr> 	
        <tr>
            <th><fmt:message key="reference.authors"/>:&nbsp;</th>
             <td><c:out value="${hostPathogen.reference.authors}"/></td>
        </tr>        
        <tr>
            <th><fmt:message key="reference.volume"/>:&nbsp;</th>
            <td><c:out value="${hostPathogen.reference.volume}"/></td>
        </tr>
		<tr>
            <th><fmt:message key="reference.pages"/>:&nbsp;</th>
            <td><c:out value="${hostPathogen.reference.pages}"/></td>
        </tr>        
        <tr>
            <th><fmt:message key="reference.data_source"/>:&nbsp;</th>
            <td><c:out value="${hostPathogen.reference.data_source}"/></td>
        </tr>        
        <tr>
        	<th>Google Scholar Search:&nbsp;</th>
        	<td>
		        <a href="http://scholar.google.ca/scholar?hl=en&q=${hostPathogen.reference.chapterArticleTitle}&btnG=&as_sdt=1%2C5&as_sdtp=">click here</a>
           	</td>
        </tr>
    </table>
    
</div>
