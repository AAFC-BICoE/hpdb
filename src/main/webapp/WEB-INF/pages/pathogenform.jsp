<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="pathogenList.pathogen"/></title>
    <meta name="menu" content="AdminMenu"/>
</head>

<div class="col-sm-10">
    <h2>Pathogen Information</h2>

 	<table class="table-striped" cellpadding="5">
        <tr>
            <th>Pathogen:</th>
            <td><h3><i><c:out value="${pathogen.fullTaxonName}"/></i></h3></td>
        </tr>
        <tr>
            <th>Virus MPLO Names:</th>
            <td><h3><c:out value="${pathogen.virusNames}"/></h3></td>
        </tr>         
        <tr>
            <th><br></th>
            <td><br></td>
        </tr>
        <tr>
            <th>English Name:</th>
            <td><c:out value="${pathogen.enName}"/></td>
        </tr>
        <tr>
            <th>English Disease Name:</th>
            <td><c:out value="${pathogen.enDiseaseName}"/></td>
        </tr>        
        <tr>
            <th><br></th>
            <td><br></td>
        </tr>          
        <tr>
            <th>French Name:</th>
            <td><c:out value="${pathogen.frName}"/></td>
        </tr> 
        <tr>
            <th>French Disease Name:</th>
            <td><c:out value="${pathogen.frDiseaseName}"/></td>
        </tr>   
        <tr>
            <th><br></th>
            <td><br></td>
        </tr>                    
		<tr>
            <th><br></th>
            <td><br></td>
        </tr>         
        <tr>
            <th>Fungal State:</th>
            <td><c:out value="${pathogen.fungalState}"/></td>
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
    
     <h2>Associated Hosts</h2>
     <display:table name="hostList" cellspacing="0" cellpadding="0" requestURI="" size="resultSize"
                  defaultsort="1" id="hostList" pagesize="25" partialList="false" sort="list"
                  class="table table-condensed table-striped table-hover" export="true">
                  
<%--	<display:column property="id" escapeXml="true" sortable="true" titleKey="ID" style="width: 3%"
						url="/hostform?locale=${langCode}&from=list" paramId="id" paramProperty="id" media="html"/>                --%>
	    <display:column property="genus" escapeXml="true" sortable="true" titleKey="host.genus" style="width: 18%"
	                    url="/hostform?locale=${langCode}&from=list" paramId="id" paramProperty="id"/>
	    <display:column property="species" escapeXml="true" sortable="true" titleKey="host.species"  style="width: 23%"
	                    url="/hostform?locale=${langCode}&from=list" paramId="id" paramProperty="id"/>
	    <display:column property="subSpecificTaxa" escapeXml="true" sortable="true" titleKey="host.subSpecificTaxa"
	                       url="/hostform?locale=${langCode}&from=list" paramId="id" paramProperty="id"/>
		<display:column property="cultivar" escapeXml="true" sortable="true" titleKey="host.cultivar"
	                       url="/hostform?locale=${langCode}&from=list" paramId="id" paramProperty="id"/>
		<display:column property="enName" escapeXml="true" sortable="true" titleKey="host.enName"
	                       url="/hostform?locale=${langCode}&from=list" paramId="id" paramProperty="id"/>
		<display:column property="frName" escapeXml="true" sortable="true" titleKey="host.frName"
	                       url="/hostform?locale=${langCode}&from=list" paramId="id" paramProperty="id"/>                                                                       
		<display:column property="notes" escapeXml="true" sortable="true" titleKey="host.notes" media="csv xml excel"/>

		<display:setProperty name="paging.banner.item_name"><fmt:message key="hostList.host"/></display:setProperty>
		<display:setProperty name="paging.banner.items_name"><fmt:message key="hostList.hosts"/></display:setProperty>
		
		<display:setProperty name="export.excel.filename" value="Host List.xls"/>
		<display:setProperty name="export.csv.filename" value="Host List.csv"/>
		<display:setProperty name="export.pdf.filename" value="Host List.pdf"/>
   </display:table>
    
</div>