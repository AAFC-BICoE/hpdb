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
            <th>Virus MPLO Names:</th>
            <td><c:out value="${pathogen.virusNames}"/></td>
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
</div>
