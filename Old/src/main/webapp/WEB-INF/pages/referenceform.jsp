<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="display.title"/></title>
    <meta name="menu" content="AdminMenu"/>
</head>

<div class="col-sm-10">
    <h2>Reference Information</h2>

    <table class="table-striped" cellpadding="5">
        <tr>
            <th>Year:</th>
            <td><c:out value="${reference.year}"/></td>
        </tr>
        <tr>
            <th>Chapter Article Title:</th>
            <td><c:out value="${reference.chapterArticleTitle}"/></td>
        </tr>        
        <tr>
            <th>Authors:</th>
            <td><c:out value="${reference.authors}"/></td>
        </tr>
        <tr>
            <th>Volume:</th>
            <td><c:out value="${reference.volume}"/></td>
        </tr>
		<tr>
            <th>Pages:</th>
            <td><c:out value="${reference.pages}"/></td>
        </tr>   
        <tr>
            <th>Data Source:</th>
            <td><c:out value="${reference.data_source}"/></td>
        </tr>        
    </table>
</div>
