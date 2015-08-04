<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page import="java.io.*,java.util.*"%>
<%@ page import = "java.util.Map" %>

<!DOCTYPE html>
<!--[if IE 7]><html lang="en" class="no-js ie7"><![endif]-->
<!--[if IE 8]><html lang="en" class="no-js ie8"><![endif]-->
<!--[if gt IE 8]><!-->
<html lang="en">
<!--<![endif]-->
<head>
<meta charset="utf-8" />
<!-- Web Experience Toolkit (WET) / Boîte à outils de l'expérience Web (BOEW)
wet-boew.github.io/wet-boew/License-en.html / wet-boew.github.io/wet-boew/Licence-fr.html -->

<title>Search Records</title>
<link href="http://www5.agr.gc.ca/res/wet-boew3.0.6/dist/theme-gcwu-fegc/images/favicon.ico" rel="shortcut icon"/>
<meta content="" name="dcterms.issued" title="W3CDTF"/>
<meta content="" name="dcterms.modified" title="W3CDTF"/>
<meta content="" name="dcterms.format" title="gcformat"/>
<meta content="Search Records" name="dcterms.title"/>
<meta content="ecosystems;geomatics;biological diversity" name="dcterms.subject" title="gccore"/>
<meta content="" name="dcterms.description"/>
<meta content="eng" name="dcterms.language" title="ISO639-2"/>
<meta content="" name="keywords"/>
<meta content="" name="dcterms.audience" title="gcaudience"/>
<meta content="educational material" name="dcterms.type" title="gctype"/>
<meta content="Government of Canada;Agriculture and Agri-Food Canada" name="dcterms.creator"/>
<meta content="" name="dcterms.spatial" title="gcregions">

<!--[if lte IE 8]>
<script src="http://wet-boew.github.io/wet-boew-legacy/v3.1/dist/js/jquery-ie.min.js"></script>
<link rel="shortcut icon" href="http://wet-boew.github.io/wet-boew-legacy/v3.1/dist/theme-gcwu-fegc/images/favicon.ico" />
<script src="http://wet-boew.github.io/wet-boew-legacy/v3.1/dist/js/polyfills/html5shiv-min.js"></script>
<link rel="stylesheet" href="http://wet-boew.github.io/wet-boew-legacy/v3.1/dist/grids/css/util-ie-min.css" />
<link rel="stylesheet" href="http://wet-boew.github.io/wet-boew-legacy/v3.1/dist/js/css/pe-ap-ie-min.css" />
<link rel="stylesheet" href="http://wet-boew.github.io/wet-boew-legacy/v3.1/dist/theme-gcwu-fegc/css/theme-ie-min.css" />
<![endif]-->

<!--[if gt IE 8]><!-->
<script src="http://wet-boew.github.io/wet-boew-legacy/v3.1/dist/js/jquery.min.js"></script>
<script src="http://wet-boew.github.io/wet-boew-legacy/v3.1/dist/js/settings.js"></script>
<script src="http://wet-boew.github.io/wet-boew-legacy/v3.1/dist/js/pe-ap-min.js"></script>
<link rel="icon" type="image/x-icon" href="http://wet-boew.github.io/wet-boew-legacy/v3.1/dist/theme-gcwu-fegc/images/favicon.ico" />
<link rel="stylesheet" href="http://wet-boew.github.io/wet-boew-legacy/v3.1/dist/grids/css/util-min.css" />
<link rel="stylesheet" href="http://wet-boew.github.io/wet-boew-legacy/v3.1/dist/js/css/pe-ap-min.css" />
<link rel="stylesheet" href="http://wet-boew.github.io/wet-boew-legacy/v3.1/dist/theme-gcwu-fegc/css/theme-min.css" />
<!--<![endif]-->

<noscript><link rel="stylesheet" href="http://wet-boew.github.io/wet-boew-legacy/v3.1/dist/theme-gcwu-fegc/css/theme-ns-min.css" /></noscript>

<!-- CustomScriptsCSSStart -->
<link href="http://www5.agr.gc.ca/res/cbif-scib3.0.6/css/theme.css" rel="stylesheet">
<link href="http://www5.agr.gc.ca/res/cbif-scib3.0.6/css/util.css" rel="stylesheet">
<link href="styles/visibility.css" rel="stylesheet">
<!--[if lte IE 8]>
<link rel="stylesheet" href="http://www5.agr.gc.ca/res/cbif-scib3.0.6css/theme-ie.css" />
<link rel="stylesheet" href="http://www5.agr.gc.ca/res/cbif-scib3.0.6/css/util-ie.css" />
<![endif]-->
<!-- CustomScriptsCSSEnd -->
</head>
<body>									
<div id="gcwu-bc">						
<h2>Breadcrumb trail</h2>						
<div id="gcwu-bc-in">							
<ol>
<li><a href="http://www.cbif.gc.ca/eng/home/?id=1370403266262">Home</a></li>
<li><a href="../index.jsp">Host-Pathogen Database</a></li>
<li><a href=<s:url action='index'/>">Search Records</a></li>
<li><a href="SearchResult.jsp">Search Results</a></li>
</ol>						
</div>					
</div>						
</nav>				<!-- HeaderEnd --> 		
</header>		
</div>	
</div>	
<div id="wb-core">		
<div class="equalize" id="wb-core-in">			
<div id="wb-main" role="main">				
<div id="wb-main-in">
<div id="wb-cont"></div>
 
<!--Body Start-->

<div>
<h1>Search Results: <s:property value="hostBean"/>
</h1>
</div>

<h3>synonym:  Note this will not display if the checkbox for synonym isn't ckecked!</h3>
 <div class="HostContainer">
  <div class="span-8">
    <table class="wet-boew-tables wet-boew-zebra table-accent" data-wet-boew='{"aaSorting": [[0, "asc"]]}' >
	<thead>
	<tr>
	<th style="width:30%">Host</th>
	<th style="width:30%">Pathogen</th>
	<th style="width:40%">Location [citaionID]</th>	
	</tr>
	</thead>
	<tbody>
	<s:iterator value="">
	<tr>
	<td><i><s:property value="hostgenus" value="hostspecies"/></i></td>
	<td><i><s:property value="pathogengenus" value="pathogenspecies"/></i></td>
	<td><s:property value="country: provstata"/></td>
	</tr>
	</s:iterator>
	</tbody>
   </table>
</div>
<div class="clear"></div>

<div style="margin-left:10px; padding:0">         
   <a href="CVSLink"><span class="export csv">Export CSV</a>
</div>

<!-- END for the Body-->
</div>			
</div>
<div class="versionF" style="float:right; margin-right:10px; padding:0">
 <span class="left">Host-Pathogen Database Version 1 |</span>
 <span class="right">&copy; 2014-2015 <a href="http://www.agr.gc.ca/">Agriculture & AgriFood Canada</a></span>
</div>						
</div>	
</div>	
<div id="wb-foot">		
<div id="wb-foot-in">			
</div>
</div>
<!-- ScriptsStart --> 
<script src="http://wet-boew.github.io/wet-boew-legacy/v3.1/dist/js/settings.js"></script>
<!--[if lte IE 8]>
<script src="http://wet-boew.github.io/wet-boew-legacy/v3.1/dist/theme-wet-boew/js/theme-ie-min.js"></script>
<script src="http://wet-boew.github.io/wet-boew-legacy/v3.1/dist/js/pe-ap-ie-min.js"></script>
<![endif]-->
<!--[if gt IE 8]><!-->
<script src="http://wet-boew.github.io/wet-boew-legacy/v3.1/dist/theme-wet-boew/js/theme-min.js"></script>
<script src="http://wet-boew.github.io/wet-boew-legacy/v3.1/dist/js/pe-ap-min.js"></script>
<!--<![endif]-->
<!-- ScriptsEnd -->

<!-- CustomScriptsStart -->

<!-- CustomScriptsEnd -->

</body>
</html>
