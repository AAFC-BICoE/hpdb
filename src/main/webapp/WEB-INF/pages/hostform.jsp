<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="hostList.host"/></title>
    <meta name="menu" content="AdminMenu"/>
</head>

<div class="col-sm-10">
    <h2>Host Information</h2>

 	<table class="table-striped" cellpadding="5">
        <tr>
            <th>Host:</th>
            <td><h3><i><c:out value="${host.fullName}"/></i></h3></td>
        </tr>
        <tr>
            <th><br></th>
            <td><br></td>
        </tr>        
        <tr>
            <th>English Name:</th>
            <td><c:out value="${host.enName}"/></td>
        </tr>
        <tr>
            <th>French Name:</th>
            <td><c:out value="${host.frName}"/></td>
        </tr>          
        <tr>
            <th><br></th>
            <td><br></td>
        </tr>            
        <tr>
            <th>Cultivar:</th>
            <td><c:out value="${host.cultivar}"/></td>
        </tr>
        <tr>
            <th><br></th>
            <td><br></td>
        </tr>        
        <tr>
            <th>Notes:</th>
            <td><c:out value="${host.notes}"/></td>
        </tr>        
    </table>
    
    <br>
    <br>
    
    	<h2>Associated Pathogens</h2>
        <display:table name="pathogenList" cellspacing="0" cellpadding="0" requestURI="" size="resultSize"
    			   defaultsort="1" id="pathogenList" pagesize="25" partialList="false" sort="list"
                   class="table table-condensed table-striped table-hover" export="true">

		<display:column property="id" escapeXml="true" sortable="true" titleKey="ID" style="width: 3%"
						url="/pathogenform?locale=${langCode}&from=list" paramId="id" paramProperty="id" media="html"/>                             
        <display:column property="genus" escapeXml="true" sortable="true" titleKey="pathogen.genus" style="width: 18%"
                        url="/pathogenform?locale=${langCode}&from=list" paramId="id" paramProperty="id"/>
        <display:column property="species" escapeXml="true" sortable="true" titleKey="pathogen.species"  style="width: 23%"
                        url="/pathogenform?locale=${langCode}&from=list" paramId="id" paramProperty="id"/>
        <display:column property="subSpecificTaxa" escapeXml="true" sortable="true" titleKey="pathogen.subSpecificTaxa"
                        url="/pathogenform?locale=${langCode}&from=list" paramId="id" paramProperty="id"/>
		<display:column property="virusNames" escapeXml="true" sortable="true" titleKey="pathogen.virusNames"
                        url="/pathogenform?locale=${langCode}&from=list" paramId="id" paramProperty="id"/>                        
		<display:column property="enName" escapeXml="true" sortable="true" titleKey="pathogen.enName"
                        url="/pathogenform?locale=${langCode}&from=list" paramId="id" paramProperty="id"/>
		<display:column property="frName" escapeXml="true" sortable="true" titleKey="pathogen.frName"
                        url="/pathogenform?locale=${langCode}&from=list" paramId="id" paramProperty="id"/>
		<display:column property="fungalState" escapeXml="true" sortable="true" titleKey="pathogen.fungalState"
                        url="/pathogenform?locale=${langCode}&from=list" paramId="id" paramProperty="id"/>
		<display:column property="notes" escapeXml="true" sortable="true" titleKey="pathogen.notes" media="csv xml excel"/>

        <display:setProperty name="paging.banner.item_name"><fmt:message key="pathogenList.pathogen"/></display:setProperty>
        <display:setProperty name="paging.banner.items_name"><fmt:message key="pathogenList.pathogens"/></display:setProperty>

        <display:setProperty name="export.excel.filename" value="Pathogen List.xls"/>
        <display:setProperty name="export.csv.filename" value="Pathogen List.csv"/>
        <display:setProperty name="export.pdf.filename" value="Pathogen List.pdf"/>
    </display:table>
    
</div>