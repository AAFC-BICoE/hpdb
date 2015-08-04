
<%@ page import="java.io.*,java.util.*" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<body>
<section name="HPDB">
<h2>Host-Pathogen DataBase</h2>
<s:url var="url" action="eng">
<s:param name="request_locale">eng</s:param>
</s:url>
<s:a href="%{url}">English </s:a> |

<s:url var="url" action="fra">
<s:param name="request_locale">fra</s:param>
</s:url>
<s:a href="%{url}">Français </s:a>
<p> Host-Pathogen DataBase includes a collection database that provide detailed information on relationship, interaction and disease between an host (Plants) and a pathogen (fungal, viral or nematodes) from publish scientist paper, books or journal across North America.</p>
</section>
</body>
</html>

<!--%  
 response.sendRedirect("eng");  
%> -->