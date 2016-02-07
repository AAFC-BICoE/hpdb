<%@ include file="/common/taglibs.jsp" %>

<head>
    <title><fmt:message key="pathogenList.title"/></title>
    <meta name="menu" content="Home"/>
</head>

<c:if test="${not empty searchError}">
    <div class="alert alert-danger alert-dismissable">
        <a href="#" data-dismiss="alert" class="close">&times;</a>
        <c:out value="${searchError}"/>
    </div>
</c:if>

<div class="col-sm-25">

    <h2><fmt:message key="pathogenList.heading"/></h2>

    <form method="get" action="${ctx}/pathogens" id="searchForm" class="form-inline">
		<table>
			<tr>
				<td>
					<input type="text" size="20" name="genus" id="genus"
					value="${param.genus}"	
					placeholder="<fmt:message key="search.genus"/>"
					class="form-control input-sm">
				</td>
				<td>
					<input type="text" size="20" name="species" id="species"
					value="${param.species}"
					placeholder="<fmt:message key="search.species"/>"
					class="form-control input-sm">
				</td>
				<td>
					<input type="text" size="20" name="subSpecificTaxa" id="subSpecificTaxa"
					value="${param.subSpecificTaxa}"
					placeholder="<fmt:message key="search.subSpecificTaxa"/>"
					class="form-control input-sm">
				</td>			
				<td>
					<input type="text" size="20" name="virusNames" id="virusNames"
					value="${param.virusNames}"
					placeholder="<fmt:message key="search.virusNames"/>"
					class="form-control input-sm">
				</td>								
				<td>
			        <button id="button.search" class="btn btn-default btn-sm" type="submit">
			            <i class="icon-search"></i> <fmt:message key="button.search"/>
			        </button>						
				</td>						
			</tr>
		</table>
    </form>

    <display:table name="pathogenList" cellspacing="0" cellpadding="0" requestURI="" size="resultSize"
    			   defaultsort="1" id="pathogenList" pagesize="25" partialList="${partialListValue}" sort="external"
                   class="table table-condensed table-striped table-hover" export="true">

		<display:column property="id" escapeXml="true" sortable="true" titleKey="ID" style="width: 3%"
						url="/pathogenform?from=list" paramId="id" paramProperty="id"/>                             
        <display:column property="genus" escapeXml="true" sortable="true" titleKey="pathogen.genus" style="width: 18%"
                        url="/pathogenform?from=list" paramId="id" paramProperty="id"/>
        <display:column property="species" escapeXml="true" sortable="true" titleKey="pathogen.species"  style="width: 23%"
                        url="/pathogenform?from=list" paramId="id" paramProperty="id"/>
        <display:column property="subSpecificTaxa" escapeXml="true" sortable="true" titleKey="pathogen.subSpecificTaxa"
                        url="/pathogenform?from=list" paramId="id" paramProperty="id"/>
		<display:column property="virusNames" escapeXml="true" sortable="true" titleKey="pathogen.virusNames"
                        url="/pathogenform?from=list" paramId="id" paramProperty="id"/>                        
		<display:column property="enName" escapeXml="true" sortable="true" titleKey="pathogen.enName"
                        url="/pathogenform?from=list" paramId="id" paramProperty="id"/>
		<display:column property="frName" escapeXml="true" sortable="true" titleKey="pathogen.frName"
                        url="/pathogenform?from=list" paramId="id" paramProperty="id"/>
		<display:column property="fungalState" escapeXml="true" sortable="true" titleKey="pathogen.fungalState"
                        url="/pathogenform?from=list" paramId="id" paramProperty="id"/>
		<display:column property="notes" escapeXml="true" sortable="true" titleKey="pathogen.notes" media="csv xml excel"/>

        <display:setProperty name="paging.banner.item_name"><fmt:message key="pathogenList.pathogen"/></display:setProperty>
        <display:setProperty name="paging.banner.items_name"><fmt:message key="pathogenList.pathogens"/></display:setProperty>

        <display:setProperty name="export.excel.filename" value="Pathogen List.xls"/>
        <display:setProperty name="export.csv.filename" value="Pathogen List.csv"/>
        <display:setProperty name="export.pdf.filename" value="Pathogen List.pdf"/>
    </display:table>
    
</div>