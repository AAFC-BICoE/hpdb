<%@ include file="/common/taglibs.jsp" %>

<head>
    <title><fmt:message key="hostPathogenList.title"/></title>
    <meta name="menu" content="Home"/>
</head>

<c:if test="${not empty searchError}">
    <div class="alert alert-danger alert-dismissable">
        <a href="#" data-dismiss="alert" class="close">&times;</a>
        <c:out value="${searchError}"/>
    </div>
</c:if>

<div class="col-sm-25">

	<h2><fmt:message key="hostPathogenList.heading"/></h2>

    <form method="get" action="${ctx}/hostPathogens" id="searchForm" class="form-inline">
        	<table>
					<tr>
						<td>
							<input type="text" size="20" name="hostFamily" id="hostFamily"
							value="${param.hostFamily}"	
							placeholder="<fmt:message key="search.hostFamily"/>"
							class="form-control input-sm">
						</td>					
						<td>
							<input type="text" size="20" name="hostGenus" id="hostGenus"
							value="${param.hostGenus}"	
							placeholder="<fmt:message key="search.hostGenus"/>"
							class="form-control input-sm">
						</td>
						<td>
							<input type="text" size="20" name="hostSpecies" id="hostSpecies"
							value="${param.hostSpecies}"
							placeholder="<fmt:message key="search.hostSpecies"/>"
							class="form-control input-sm">
						</td>
						<td>
							<input type="text" size="20" name="hostSubSpecificTaxa" id="hostSubSpecificTaxa"
							value="${param.hostSubSpecificTaxa}"
							placeholder="<fmt:message key="search.hostSubSpecificTaxa"/>"
							class="form-control input-sm">
						</td>						
						<td>
					        <button id="button.search" class="btn btn-default btn-sm" type="submit">
					            <i class="icon-search"></i> <fmt:message key="button.search"/>
					        </button>						
						</td>		
						<td>
							&nbsp;&nbsp;&nbsp;
						</td>			
						<td>
					         Use % as a Wildcard				
						</td>											
					</tr>
					<tr>
						<td>
							<input type="text" size="20" name="pathogenGenus" id="pathogenGenus"
							value="${param.pathogenGenus}"	
							placeholder="<fmt:message key="search.pathogenGenus"/>"
							class="form-control input-sm">
						</td>
						<td>
							<input type="text" size="20" name="pathogenSpecies" id="pathogenSpecies"
							value="${param.pathogenSpecies}"
							placeholder="<fmt:message key="search.pathogenSpecies"/>"
							class="form-control input-sm">
						</td>
						<td>
							<input type="text" size="20" name="pathogenSubSpecificTaxa" id="pathogenSubSpecificTaxa"
							value="${param.pathogenSubSpecificTaxa}"
							placeholder="<fmt:message key="search.pathogenSubSpecificTaxa"/>"
							class="form-control input-sm">
						</td>	
						<td>
							<input type="text" size="20" name="pathogenVirusNames" id="pathogenVirusNames"
							value="${param.pathogenVirusNames}"	
							placeholder="<fmt:message key="search.pathogenVirusNames"/>"
							class="form-control input-sm">
						</td>												
					</tr>
				</table>

    </form>

    <display:table name="hostPathogenList" cellspacing="0" cellpadding="0" requestURI="" size="resultSize"
                   defaultsort="1" id="hostPathogenList" pagesize="25" partialList="${partialListValue}" sort="external"
                   class="table table-condensed table-striped table-hover" export="true">

		<display:column property="id" escapeXml="true" sortable="true" titleKey="hostPathogen.id" style="width: 3%"
						href="/hostpathogenform?from=list" paramId="id" paramProperty="id"/>                    
		<display:column property="hostFamily" escapeXml="true" sortable="true" titleKey="hostPathogen.hostFamily"
						href="/hostpathogenform?from=list" paramId="id" paramProperty="id"/>   
		<display:column property="hostGenus" escapeXml="true" sortable="true" titleKey="hostPathogen.hostGenus" style="width: 10%"
						href="/hostpathogenform?from=list" paramId="id" paramProperty="id"/>   
		<display:column property="hostSpecies" escapeXml="true" sortable="true" titleKey="hostPathogen.hostSpecies" style="width: 10%"
						href="/hostpathogenform?from=list" paramId="id" paramProperty="id"/>   
		<display:column property="hostSubSpecificTaxa" escapeXml="true" sortable="true" titleKey="hostPathogen.hostSubSpecificTaxa"
						href="/hostpathogenform?from=list" paramId="id" paramProperty="id"/>      
		<display:column property="pathogenGenus" escapeXml="true" sortable="true" titleKey="hostPathogen.pathogenGenus" style="width: 10%"
						href="/hostpathogenform?from=list" paramId="id" paramProperty="id"/>   
		<display:column property="pathogenSpecies" escapeXml="true" sortable="true" titleKey="hostPathogen.pathogenSpecies" style="width: 10%"
						href="/hostpathogenform?from=list" paramId="id" paramProperty="id"/>   
		<display:column property="pathogenSubSpecificTaxa" escapeXml="true" sortable="true" titleKey="hostPathogen.pathogenSubSpecificTaxa"
						href="/hostpathogenform?from=list" paramId="id" paramProperty="id"/>     
		<display:column property="pathogenVirusNames" escapeXml="true" sortable="true" titleKey="hostPathogen.pathogenVirusNames"
						href="/hostpathogenform?from=list" paramId="id" paramProperty="id"/>   		
        <display:column property="reference.authors" escapeXml="true" sortable="true" titleKey="hostPathogen.authors" style="width: 12%"
						href="/hostpathogenform?from=list" paramId="id" paramProperty="id"/>   
		<display:column escapeXml="true" sortable="false" titleKey="hostPathogen.locations"> 
				<c:forEach var="location" items="${hostPathogenList.locationList}" varStatus="status">
					<c:out value=" ${location.interpretation}"/>[<c:out value="${location.country}] "/><c:if test="${!status.last}">,</c:if>  
				</c:forEach>
		</display:column>
		<display:column property="notes" escapeXml="true" sortable="true" titleKey="hostPathogen.notes" media="csv xml excel"/>		
        <display:setProperty name="paging.banner.item_name"><fmt:message key="hostPathogenList.hostPathogen"/></display:setProperty>
        <display:setProperty name="paging.banner.items_name"><fmt:message key="hostPathogenList.hostPathogens"/></display:setProperty>

        <display:setProperty name="export.excel.filename" value="HostPathogen List.xls"/>
        <display:setProperty name="export.csv.filename" value="HostPathogen List.csv"/>
        <display:setProperty name="export.pdf.filename" value="HostPathogen List.pdf"/>
    </display:table>
    
</div>