<%@ include file="/common/taglibs.jsp"%>

<c:url value="${pageContext.request.requestURL}" var="pageURL">
	<c:if test="${empty param['locale'] }">
		<c:param name="locale" value="${altlangCode}" />
	</c:if>
	<c:forEach items="${paramValues}" var="p">
		<c:choose>
			<c:when test="${p.key eq 'locale'}">
				<c:param name="locale" value="${altlangCode}" />
			</c:when>
			<c:otherwise>
				<c:forEach items="${p.value}" var="val">
					<c:param name="${p.key}" value="${val}" />
				</c:forEach>
			</c:otherwise>
		</c:choose>
	</c:forEach>
</c:url>

<menu:useMenuDisplayer name="Velocity" config="navbarMenu.vm" permissions="rolesAdapter">
<div class="collapse navbar-collapse" id="navbar">
<ul class="nav navbar-nav">
    <c:if test="${empty pageContext.request.remoteUser}">
        <li class="active">
            <a href="<c:url value="/hostPathogens?locale=${langCode}"/>"><fmt:message key="hostPathogenList.title"/></a>
        </li>    
        <li class="active">
            <a href="<c:url value="/hosts?locale=${langCode}"/>"><fmt:message key="hostList.title"/></a>
        </li>
        <li class="active">
            <a href="<c:url value="/pathogens?locale=${langCode}"/>"><fmt:message key="pathogenList.title"/></a>
        </li>
        <li id="switchLocale" class="active">
            <a href="${pageURL}"><fmt:message key="language.toggle"/></a>
        </li>        
<%--         <li class="active">
            <a href="<c:url value="/login"/>"><fmt:message key="login.title"/></a>
        </li>    --%>     
    </c:if>
	<menu:displayMenu name="Home"/>
	<menu:displayMenu name="HostPathogens"/>       
	<menu:displayMenu name="Hosts"/>        
	<menu:displayMenu name="Pathogens"/>
    <menu:displayMenu name="UserMenu"/>
    <menu:displayMenu name="AdminMenu"/>
    <menu:displayMenu name="Logout"/>
</ul>
</div>
</menu:useMenuDisplayer>
