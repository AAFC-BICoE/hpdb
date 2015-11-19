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
</div>
