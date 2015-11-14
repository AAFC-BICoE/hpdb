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
    <div id="search" class="text-right">
        <span class="col-sm-9">
            <input type="text" size="20" name="q" id="query" value="${param.q}"
                   placeholder="<fmt:message key="search.enterTerms"/>" class="form-control input-sm">
        </span>
        <button id="button.search" class="btn btn-default btn-sm" type="submit">
            <i class="icon-search"></i> <fmt:message key="button.search"/>
        </button>
    </div>
    </form>

    <display:table name="hostPathogenList" cellspacing="0" cellpadding="0" requestURI=""
                   defaultsort="1" id="hostPathogens" pagesize="25" class="table table-condensed table-striped table-hover" export="true">
        <display:column property="host.genus" escapeXml="true" sortable="true" titleKey="hostPathogen.host.genus" style="width: 20%"
                        url="/hostPathogenform?from=list" paramId="id" paramProperty="id"/>
        <display:column property="host.species" escapeXml="true" sortable="true" titleKey="hostPathogen.host.species" style="width: 20%"/>
        <display:column property="pathogen.genus" escapeXml="true" sortable="true" titleKey="hostPathogen.pathogen.genus" style="width: 20%"/>
        <display:column property="pathogen.species" escapeXml="true" sortable="true" titleKey="hostPathogen.pathogen.species" style="width: 20%"/>
        <display:column property="plantPart" escapeXml="true" sortable="true" titleKey="hostPathogen.plantPart"/>          
		<display:column property="symptom" escapeXml="true" sortable="true" titleKey="hostPathogen.symptom"/>
		<display:column property="notes" escapeXml="true" sortable="true" titleKey="hostPathogen.notes" media="csv xml excel"/>

        <display:setProperty name="paging.banner.item_name"><fmt:message key="hostPathogenList.hostPathogen"/></display:setProperty>
        <display:setProperty name="paging.banner.items_name"><fmt:message key="hostPathogenList.hostPathogens"/></display:setProperty>

        <display:setProperty name="export.excel.filename" value="HostPathogen List.xls"/>
        <display:setProperty name="export.csv.filename" value="HostPathogen List.csv"/>
        <display:setProperty name="export.pdf.filename" value="HostPathogen List.pdf"/>
    </display:table>
</div>