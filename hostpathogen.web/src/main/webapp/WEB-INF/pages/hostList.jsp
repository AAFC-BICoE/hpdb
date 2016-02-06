<%@ include file="/common/taglibs.jsp" %>

<head>
    <title><fmt:message key="hostList.title"/></title>
    <meta name="menu" content="Home"/>
</head>

<c:if test="${not empty searchError}">
    <div class="alert alert-danger alert-dismissable">
        <a href="#" data-dismiss="alert" class="close">&times;</a>
        <c:out value="${searchError}"/>
    </div>
</c:if>

<div class="col-sm-25">
    <h2><fmt:message key="hostList.heading"/></h2>

    <form method="get" action="${ctx}/hosts" id="searchForm" class="form-inline">
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

    <display:table name="hostList" cellspacing="0" cellpadding="0" requestURI=""
                   defaultsort="1" id="hosts" pagesize="25" sort="list"
                   class="table table-condensed table-striped table-hover" export="true">
                   
		<display:column property="id" escapeXml="true" sortable="true" titleKey="ID" style="width: 3%"
						url="/hostform?from=list" paramId="id" paramProperty="id"/>                   
        <display:column property="genus" escapeXml="true" sortable="true" titleKey="host.genus" style="width: 18%"
                        url="/hostform?from=list" paramId="id" paramProperty="id"/>
        <display:column property="species" escapeXml="true" sortable="true" titleKey="host.species"  style="width: 23%"
                        url="/hostform?from=list" paramId="id" paramProperty="id"/>
        <display:column property="subSpecificTaxa" escapeXml="true" sortable="true" titleKey="host.subSpecificTaxa"
                        url="/hostform?from=list" paramId="id" paramProperty="id"/>
		<display:column property="cultivar" escapeXml="true" sortable="true" titleKey="host.cultivar"
                        url="/hostform?from=list" paramId="id" paramProperty="id"/>
		<display:column property="enName" escapeXml="true" sortable="true" titleKey="host.enName"
                        url="/hostform?from=list" paramId="id" paramProperty="id"/>
		<display:column property="frName" escapeXml="true" sortable="true" titleKey="host.frName"
                        url="/hostform?from=list" paramId="id" paramProperty="id"/>                                                                       
		<display:column property="notes" escapeXml="true" sortable="true" titleKey="host.notes" media="csv xml excel"/>

        <display:setProperty name="paging.banner.item_name"><fmt:message key="hostList.host"/></display:setProperty>
        <display:setProperty name="paging.banner.items_name"><fmt:message key="hostList.hosts"/></display:setProperty>

        <display:setProperty name="export.excel.filename" value="Host List.xls"/>
        <display:setProperty name="export.csv.filename" value="Host List.csv"/>
        <display:setProperty name="export.pdf.filename" value="Host List.pdf"/>
    </display:table>
</div>
