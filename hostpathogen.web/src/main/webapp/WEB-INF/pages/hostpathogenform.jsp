<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="display.title"/></title>
    <meta name="menu" content="AdminMenu"/>
</head>

<div class="col-sm-10">
    <h2>HostPathogen Information</h2>
    <p>Below is a list of attributes for Host Pathogen.</p>

    <table class="table-striped" cellpadding="5">
        <tr>
            <th>Host:</th>
            <td><a href="/hostform?host.id=${hostPathogen.host.id}"/><c:out value="${hostPathogen.host.fullName}"/></td>
        </tr>
        <tr>
            <th>Pathogen:</th>
            <td><a href="/pathogenform?host.id=${hostPathogen.pathogen.id}"/><c:out value="${hostPathogen.pathogen.fullTaxonName}"/></td>
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
            <th>Notes:</th>
            <td><c:out value="${hostPathogen.notes}"/></td>
        </tr>        
		<tr>
            <th>Reference Authors:</th>
            <td><a href="/referenceform?reference.id=${hostPathogen.reference.id}"/><c:out value="${hostPathogen.reference.authors}"/></td>
        </tr>        
    </table>
	</br>
    <h2>Host Information</h2>
	</br>
 	<table class="table-striped" cellpadding="5">
        <tr>
            <th>Host:</th>
            <td><a href="/hostform?host.id=${hostPathogen.host.id}"/><c:out value="${hostPathogen.host.fullName}"/></td>
        </tr>
        <tr>
            <th>Author:</th>
            <td><c:out value="${hostPathogen.host.author}"/></td>
        </tr>
        <tr>
            <th>Cultivar:</th>
            <td><c:out value="${hostPathogen.host.cultivar}"/></td>
        </tr>
    </table>
	</br>
    <h2>Pathogen Information</h2>
	</br>
 	<table class="table-striped" cellpadding="5">
        <tr>
            <th>Host:</th>
            <td><a href="/pathogenform?host.id=${hostPathogen.pathogen.id}"/><c:out value="${hostPathogen.pathogen.fullTaxonName}"/></td>
        </tr>
        <tr>
            <th>Author:</th>
            <td><c:out value="${hostPathogen.pathogen.author}"/></td>
        </tr>
    </table>
	</br>
    <h2>Reference Information</h2>
	</br>
 	<table class="table-striped" cellpadding="5">
        <tr>
            <th>Year:</th>
            <td><c:out value="${hostPathogen.reference.year}"/></td>
        </tr>
        <tr>
            <th>Authors:</th>
             <td><a href="/referenceform?reference.id=${hostPathogen.reference.id}"/><c:out value="${hostPathogen.reference.authors}"/></td>
        </tr>
        <tr>
            <th>Volume:</th>
            <td><c:out value="${hostPathogen.reference.volume}"/></td>
        </tr>
        <tr>
            <th>Chapter Article Title:</th>
            <td><c:out value="${hostPathogen.reference.chapterArticleTitle}"/></td>
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
