<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="hostPathogenList.hostPathogen"/></title>
    <meta name="menu" content="AdminMenu"/>
</head>

<div class="col-sm-10">
    <h2>HostPathogen Information</h2>

    <table class="table-striped" cellpadding="5">
        <tr>
            <th>Host:</th>
            <td><h3><i><a href="/hostform?id=${hostPathogen.host.id}"/><c:out value="${hostPathogen.host.fullName}"/></i></h3></td>
        </tr>
        <tr>
            <th><br></th>
            <td><br></td>
        </tr>            
        <tr>
            <th>Pathogen:</th>
            <td><h3><i><a href="/pathogenform?id=${hostPathogen.pathogen.id}"/><c:out value="${hostPathogen.pathogen.fullTaxonName}"/></i>
            		   <a href="/pathogenform?id=${hostPathogen.pathogen.id}"/><c:out value="${hostPathogen.pathogen.virusNames}"/>
            </h3></td>
        </tr>
        <tr>
            <th><br></th>
            <td><br></td>
        </tr>            
        <tr>
            <th>Plant Part:</th>
            <td><c:out value="${hostPathogen.plantPart}"/></td>
        </tr>
        <tr>
            <th>Fungal State:</th>
            <td><c:out value="${hostPathogen.rustState}"/></td>
        </tr>        
        <tr>
            <th>Symptom:</th>
            <td><c:out value="${hostPathogen.symptom}"/></td>
        </tr>
        <tr>
            <th><br></th>
            <td><br></td>
        </tr>                         
        <tr>
            <th>Notes:</th>
            <td><c:out value="${hostPathogen.notes}"/></td>
        </tr>        
    </table>
    </br>
    <h2>Location Information</h2>
	</br>
    <label class="control-label"><fmt:message key="hostPathogen.locations"/>:</label>
    <div class="readonly">
        <c:forEach var="location" items="${hostPathogen.locationList}" varStatus="status">
            <c:out value="${location.interpretation}"/>&nbsp;&nbsp;[<c:out value="${location.country}"/>]<c:if test="${!status.last}">&nbsp;,&nbsp;</c:if>
        </c:forEach>
    </div>
	</br>
    <h2>Reference Information</h2>
	</br>
 	<table class="table-striped" cellpadding="5">
        <tr>
            <th>Year:</th>
            <td><c:out value="${hostPathogen.reference.year}"/></td>
        </tr> 	
        <tr>
            <th>Chapter Article Title:</th>
            <td><c:out value="${hostPathogen.reference.chapterArticleTitle}"/></td>
        </tr> 	
        <tr>
            <th>Authors:</th>
             <td><c:out value="${hostPathogen.reference.authors}"/></td>
        </tr>        
        <tr>
            <th>Volume:</th>
            <td><c:out value="${hostPathogen.reference.volume}"/></td>
        </tr>
		<tr>
            <th>Pages:</th>
            <td><c:out value="${hostPathogen.reference.pages}"/></td>
        </tr>        
        <tr>
            <th>Data Source:</th>
            <td><c:out value="${hostPathogen.reference.data_source}"/></td>
        </tr>        
    </table>
    
</div>
