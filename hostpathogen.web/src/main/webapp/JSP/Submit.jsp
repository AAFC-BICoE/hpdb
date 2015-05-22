<!DOCTYPE html>
<%@ page import="java.io.*,java.util.*"%>
<%@ page session="false"%>
<body>
	<!--Body-->
	<center>
		<h1>Host-Pathogen Search View By Server</h1>

		<p>Gat timestamp date and hours:<%=(new java.util.Date()).toLocaleString()%></p>
	</center>

	<h1>Testing HTTP Request</h1>

	<table width="100%" border="1" align="center">
		<tr bgcolor="#949494">
			<th>Header Name</th>
			<th>Header Value(s)</th>
		</tr>
		<%
			Enumeration headerNames = request.getHeaderNames();
			while (headerNames.hasMoreElements()) {
				String paramName = (String) headerNames.nextElement();
				out.print("<tr><td>" + paramName + "</td>\n");
				String paramValue = request.getHeader(paramName);
				out.println("<td> " + paramValue + "</td></tr>\n");
			}
		%>
	</table>


	<h1>Testing GET Data FORM</h1>
	<ul>
		<%-- Import the dsp tag library to access Oracle ATG Web Commerce
     functionality. Import tag libraries for the output format you
     will send to REST clients. --%>

		<li><p>
				<b>Pathogen Genus:</b>
				<%=request.getParameter("pgenus")%>
			</p></li>
		<li><p>
				<b>Pathogen Species:</b>
				<%=request.getParameter("pspecies")%>
			</p></li>
		<li><p>
				<b>Virus MPLO:</b>
				<%=request.getParameter("pvirus")%>
			</p></li>
		<li><p>
				<b>Pathogen Synonyms:</b>
				<%=request.getParameter("pathogenSynonym")%>
			</p></li>

		<li><p>
				<b>Host Genus:</b>
				<%=request.getParameter("hfamily")%>
			</p></li>
		<li><p>
				<b>Host Family:</b>
				<%=request.getParameter("hgenus")%>
			</p></li>
		<li><p>
				<b>Host Species:</b>
				<%=request.getParameter("hspecies")%>
			</p></li>
		<li><p>
				<b>Host Synonym:</b>
				<%=request.getParameter("hostSynonym")%>
			</p></li>
		<li><p>
				<b>Country:</b>
				<%=request.getParameter("country")%>
			</p></li>
		<li><p>
				<b>Province/State/Territory:</b>
				<%=request.getParameter("provstate")%>
			</p></li>
	</ul>


	<!-- ScriptsStart -->
	<script
		src="http://www5.agr.gc.ca/res/wet-boew3.0.6/dist/theme-gcwu-fegc/js/theme-min.js"></script>
	<script
		src="http://www5.agr.gc.ca/res/wet-boew3.0.6/dist/js/settings.js"></script>
	<script
		src="http://www5.agr.gc.ca/res/wet-boew3.0.6/dist/js/pe-ap-min.js"></script>
		<!-- ScriptsEnd -->
</body>
</html>

