<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="home.title"/></title>
    <meta name="menu" content="Home"/>
</head>
<body class="home">

<h2><fmt:message key="home.heading"/></h2>
<p><fmt:message key="home.message"/></p>

<ul class="glassList">
    <li>
        <a href="<c:url value='/hostPathogens'/>"><fmt:message key="hostPathogenList.title"/></a>
    </li>
    <li>
        <a href="<c:url value='/hosts'/>"><fmt:message key="hostList.title"/></a>
    </li>
    <li>
        <a href="<c:url value='/pathogens'/>"><fmt:message key="pathogenList.title"/></a>
    </li>
 <%--    <li>
        <a href="<c:url value='/userform'/>"><fmt:message key="menu.user"/></a>
    </li>
    <li>
        <a href="<c:url value='/fileupload'/>"><fmt:message key="menu.selectFile"/></a>
    </li> --%>
</ul>

<br>
<strong><fmt:message key="home.jsp.about"/></strong>
<br>
<br>
<p>
<fmt:message key="home.jsp.about.p1"/>
</p>
<p>
<fmt:message key="home.jsp.about.p2"/>
</p>
<p>
<fmt:message key="home.jsp.about.p3"/>
</p>
<p>
<fmt:message key="home.jsp.about.p4"/> 
</p>
<p>
<fmt:message key="home.jsp.about.p5"/>
</p>
<p>
<fmt:message key="home.jsp.about.p6"/> 
</p>
<br>
<p>
<strong>
<fmt:message key="home.jsp.contactInformation"/>
</strong>
<br>
<br>
<fmt:message key="home.jsp.contact.generalCollection"/> <a href="mailto:Scott.Redhead@canada.ca?Subject=Canadian%20Host-Pathogen%20Database:" target="_top">Scott A. Redhead</a>
<br>
<fmt:message key="home.jsp.contact.dataInput"/> <a href="mailto:Jennifer.Wilkinson@canada.ca?Subject=Canadian%20Host-Pathogen%20Database:" target="_top">Jennifer Wilkinson</a>
<br>
<fmt:message key="home.jsp.contact.webDevelopment"/> <a href="mailto:AAFC.BICE-CEIB.AAC@canada.ca?Subject=Canadian%20Host-Pathogen%20Database:" target="_top">Biological Informatics Centre of Excellence</a>
</p>
</body>
