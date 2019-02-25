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
    		<input type="hidden" name="locale" value="${langCode}">
        	<table>
					<tr>
						<td>
							<input type="text" size="18" name="hostFamily" id="hostFamily"
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
							<input type="text" size="21" name="hostSubSpecificTaxa" id="hostSubSpecificTaxa"
							value="${param.hostSubSpecificTaxa}"
							placeholder="<fmt:message key="search.hostSubSpecificTaxa"/>"
							class="form-control input-sm">
						</td>
						<td>
							<input type="text" size="15" name="authors" id="authors"
							value="${param.authors}"	
							placeholder="<fmt:message key="search.authors"/>"
							class="form-control input-sm">
						</td>
						<td>
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					        <button id="button.search" class="btn btn-default btn-sm" type="submit">
					            <i class="icon-search"></i> <fmt:message key="button.search"/>
					        </button>
						</td>
						<td>
							Use % as a Wildcard				
						</td>
					</tr>
					<tr>
						<td>
							<input type="text" size="18" name="pathogenVirusNames" id="pathogenVirusNames"
							value="${param.pathogenVirusNames}"	
							placeholder="<fmt:message key="search.pathogenVirusNames"/>"
							class="form-control input-sm">
						</td>	
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
							<input type="text" size="21" name="pathogenSubSpecificTaxa" id="pathogenSubSpecificTaxa"
							value="${param.pathogenSubSpecificTaxa}"
							placeholder="<fmt:message key="search.pathogenSubSpecificTaxa"/>"
							class="form-control input-sm">
						</td>	
						<td>
							<input type="text" size="15" name="locationCountry" id="locationCountry"
							value="${param.locationCountry}"	
							placeholder="<fmt:message key="search.locationCountry"/>"
							class="form-control input-sm">
						</td>	
						<td>
							<input type="text" size="16" name="locationInterpretation" id="locationInterpretation"
							value="${param.locationInterpretation}"	
							placeholder="<fmt:message key="search.locationInterpretation"/>"
							class="form-control input-sm">
						</td>
					</tr>
				</table>
				<table>
					<tr>
						<td>
							<label for="pageSize"><fmt:message key="search.pageSize"/></label>
							<br/>
							<input type="number" size="16" name="pageSize" id="pageSize" min="1"
							value="${param.pageSize}"	
							placeholder="25"
							class="form-control input-sm">
						</td>
					</tr>
				</table>

    </form>
    <br>

    <display:table name="hostPathogenList" cellspacing="0" cellpadding="0" requestURI="" size="resultSize"
                   defaultsort="1" id="hostPathogenList" pagesize="${param.pageSize>0 ? param.pageSize : 25}" 
                   partialList="${partialListValue}" sort="external"
                   class="table table-condensed table-striped table-hover" export="true">

		<display:column property="id" escapeXml="true" sortable="true" titleKey="hostPathogen.id" style="width: 3%"
						href="/hostpathogenform?from=list" paramId="id" paramProperty="id" media="html"/>                    
		<display:column property="hostFamily" escapeXml="true" sortable="true" titleKey="hostPathogen.hostFamily"
						href="/hostpathogenform?from=list" paramId="id" paramProperty="id"/>   
		<display:column property="hostGenus" escapeXml="true" sortable="true" titleKey="hostPathogen.hostGenus" style="width: 10%"
						href="/hostpathogenform?from=list" paramId="id" paramProperty="id"/>   
		<display:column property="hostSpecies" escapeXml="true" sortable="true" titleKey="hostPathogen.hostSpecies" style="width: 10%"
						href="/hostpathogenform?from=list" paramId="id" paramProperty="id"/>   
		<display:column property="hostSubSpecificTaxa" escapeXml="true" sortable="true" titleKey="hostPathogen.hostSubSpecificTaxa" style="width: 10%"
						href="/hostpathogenform?from=list" paramId="id" paramProperty="id"/>      
		<display:column property="pathogenVirusNames" escapeXml="true" sortable="true" titleKey="hostPathogen.pathogenVirusNames"
						href="/hostpathogenform?from=list" paramId="id" paramProperty="id"/>
		<display:column property="pathogenGenus" escapeXml="true" sortable="true" titleKey="hostPathogen.pathogenGenus" style="width: 10%"
						href="/hostpathogenform?from=list" paramId="id" paramProperty="id"/>   
		<display:column property="pathogenSpecies" escapeXml="true" sortable="true" titleKey="hostPathogen.pathogenSpecies" style="width: 10%"
						href="/hostpathogenform?from=list" paramId="id" paramProperty="id"/>   
		<display:column property="pathogenSubSpecificTaxa" escapeXml="true" sortable="true" titleKey="hostPathogen.pathogenSubSpecificTaxa" style="width: 10%"
						href="/hostpathogenform?from=list" paramId="id" paramProperty="id"/>   
		<display:column property="reference.year" escapeXml="true" sortable="true" titleKey="hostPathogen.year" media="csv xml excel"/>   
		<display:column property="reference.chapterArticleTitle" escapeXml="true" sortable="true" titleKey="hostPathogen.chapterArticleTitle" media="csv xml excel"/>   											  
		<display:column property="reference.authors" escapeXml="true" sortable="true" titleKey="hostPathogen.authors" style="width: 12%"
						href="/hostpathogenform?from=list" paramId="id" paramProperty="id"/>   
		<display:column property="reference.volume" escapeXml="true" sortable="true" titleKey="hostPathogen.volume" media="csv xml excel"/>   
		<display:column property="reference.pages" escapeXml="true" sortable="true" titleKey="hostPathogen.pages" media="csv xml excel"/>   
		<display:column property="reference.data_source" escapeXml="true" sortable="true" titleKey="hostPathogen.data_source" media="csv xml excel"/>   						
		<display:column escapeXml="true" sortable="false" titleKey="hostPathogen.locations"> 
				<c:forEach var="location" items="${hostPathogenList.locationList}" varStatus="status">
					<c:out value=" ${location.interpretation}"/> [<c:out value="${location.country}] "/><c:if test="${!status.last}">,</c:if>  
				</c:forEach>
		</display:column>
		<display:column property="notes" escapeXml="true" sortable="true" titleKey="hostPathogen.notes" media="csv xml excel"/>		
        <display:setProperty name="paging.banner.item_name"><fmt:message key="hostPathogenList.hostPathogen"/></display:setProperty>
        <display:setProperty name="paging.banner.items_name"><fmt:message key="hostPathogenList.hostPathogens"/></display:setProperty>

		<display:setProperty name="export.csv.include_header" value="true"/>
        <display:setProperty name="export.excel.filename" value="HostPathogen List.xls"/>
        <display:setProperty name="export.csv.filename" value="HostPathogen List.csv"/>
        <display:setProperty name="export.pdf.filename" value="HostPathogen List.pdf"/>
    </display:table>
    
</div>