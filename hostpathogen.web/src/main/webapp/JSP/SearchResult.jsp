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
<li><a href="">Home</a></li>
<li><a href="">Host-Pathogen Database</a></li>
<li><a href="MainPage.jsp">Search Records</a></li>
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
<h1>Search Results: 
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
	<tr>
	<td><i>Abies balsamea</i></td>
	<td><i>Aspergillus</i> sp.</td>
	<td>Canada: NB [<a href="SearchResultDetails.jsp">1</a>], [<a href="">2</a>]  ON [<a href="">3</a>]  AB [<a href="">2</a>], [<a href="">57</a>]</td>
	</tr>
	<tr>
	<td><i>Acer</i></td>
	<td><i>Aspergillus fumigatus</i></td>
	<td><ul><li>Canada: NB[<a href="">1</a>], [<a href="">2</a>] ON [<a href="">3</a>];</li><li>USA: IL[<a href="">37</a>]  NY[<a href="">39</a>];</li><li>Virgin Islands</li></ul></td>
	</tr>
	<tr>
	<td><i>Aconitum</i></td>
	<td><i>Aspergillus</i> sp.</td>
	<td><ul><li>Canada: NB[<a href="">1</a>], [<a href="">2</a>] ON [<a href="">3</a>];</li><li>USA: IL[<a href="">37</a>]  NY[<a href="">39</a>];</li></ul></td>
	</tr>
	<tr>
	<td><i>Allium</i></td>
	<td><i>Aspergillus niger</i></td>
	<td>Canada: NB [<a href="">1</a>], [<a href="">2</a>]</td>
	</tr>
	<tr>
	<td><i>Allium cepa</i></td>
	<td><i>Aspergillus</i> sp.</td>
	<td>Canada: NB [<a href="">1</a>]</td>
	</tr>
	<tr>
	<td><i>Allium sativum</i></td>
	<td><i>Aspergillus</i> sp.</td>
	<td>Canada: NB [<a href="">1</a>], [<a href="">2</a>]</td>
	</tr>
	<tr>
	<td><i>Asparagus officinalis</i></td>
	<td><i>Aspergillus flavus</i></td>
	<td>Canada: NB [<a href="">1</a>]</td>
	</tr>
	<tr>
	<td><i>Avena chinesis</i></td>
	<td><i>Aspergillus</i> sp.</td>
	<td>Canada: NB [<a href="">1</a>], [<a href="">2</a>]</td>
	</tr>
	<tr>
	<td><i>Avena sativa</i></td>
	<td><i>Aspergillus flavus</i></td>
	<td><ul><li>Canada: NB[<a href="">1</a>], [<a href="">2</a>] ON [<a href="">3</a>];</li><li>USA: IL[<a href="">37</a>]  NY[<a href="">39</a>];</li><li>Virgin Islands</li></ul></td>
	</tr>
	<tr>
	<td><i>Betula</i></td>
	<td><i>Aspergillus fumigatus</i></td>
	<td>Canada: NB [<a href="">1</a>], [<a href="">2</a>]</td>
	</tr>
	<tr>
	<td><i>Brassica</i></td>
	<td><i>Aspergillus candidus</i></td>
	<td><ul><li>Canada: NB[<a href="">1</a>], [<a href="">2</a>] ON [<a href="">3</a>];</li><li>USA: IL[<a href="">37</a>]  NY[<a href="">39</a>];</li><li>Virgin Islands</li></ul></td>
	</tr>
	<tr>
	<td><i>Brassica campestris<i></td>
	<td><i>Aspergillus</i> sp.</td>
	<td>Canada: NB [<a href="">1</a>], [<a href="">2</a>]  ON [<a href="">3</a>]  AB [<a href="">2</a>], [<a href="">57</a>]</td>
	</tr>
	<tr>
	<td><i>Brassica napus</i></td>
	<td><i>Aspergillus</i> sp.</td>
	<td>USA: IL [<a href="">45</a>], [<a href="">46</a>]  NY [<a href="">849</a>]</td>
	</tr>
	<tr>
	<td><i>Camassia quamash</i></td>
	<td><i>Aspergillus</i> sp.</td>
	<td>Canada: NB [<a href="">1</a>], [<a href="">2</a>]</td>
	</tr>
	<tr>
	<td><i>Capsicum annuum</i></td>
	<td><i>Aspergillus</i> sp.</td>
	<td>Canada: NB [<a href="">1</a>], [<a href="">2</a>]  ON [<a href="">3</a>]  AB [<a href="">2</a>], [<a href="">57</a>]</td>
	</tr>
	<tr class="pair" onclick="popit('')">
	<td><i>Chamaecyparis</i></td>
	<td><i>Aspergillus</i> sp.</td>
	<td>Canada: NB [<a href="">1</a>], [<a href="">2</a>]  ON [<a href="">3</a>]  AB [<a href="">2</a>], [<a href="">57</a>]</td>
	</tr>
	<tr class="imp" onclick="popit('')">
	<td><i>Cicer arietinum</i></td>
	<td><i>Aspergillus</i> sp.</td>
	<td>Canada, NB; Canada, ON; Canada, AB</td>
	</tr>
	<tr class="pair" onclick="popit('')">
	<td><i>Cucumis sativus</i></td>
	<td><i>Aspergillus</i> sp.</td>
	<td>Canada, NB; Canada, ON; Canada, AB</td>
	</tr>
	<tr class="imp" onclick="popit('')">
	<td><i>Cucurbita</i></td>
	<td><i>Aspergillus</i> sp.</td>
	<td>Canada: NB [<a href="">1</a>], [<a href="">2</a>]  ON [<a href="">3</a>]  AB [<a href="">2</a>], [<a href="">57</a>]</td>
	</tr>
	<tr class="pair" onclick="popit('')">
	<td><i>Cucurbita maxima</i></td>
	<td><i>Aspergillus ochraceus</i></td>
	<td>Canada, NB; Canada, ON; Canada, AB</td>
	</tr>
	<tr class="imp" onclick="popit('')">
	<td><i>Echinacea</i></td>
	<td><i>Aspergillus</i> sp.</td>
	<td>Canada, NB; Canada, ON; Canada, AB</td>
	</tr>
	<tr class="pair" onclick="popit('')">
	<td><i>Fagopyrum sagittatum</i></td>
	<td><i>Aspergillus candidus</i></td>
	<td>Canada, NB; Canada, ON; Canada, AB</td>
	</tr>
	<tr class="imp" onclick="popit('')">
	<td><i>Fagus</i></td>
	<td><i>Aspergillus fumigatus</i></td>
	<td>Canada, NB; Canada, ON; Canada, AB</td>
	</tr>
	<tr class="pair" onclick="popit('')">
	<td><i>Fagus grandifolia</i></td>
	<td><i>Aspergillus niger</i></td>
	<td>Canada, NB; Canada, ON; Canada, AB</td>td>
	</tr>
	<tr class="imp" onclick="popit('')">
	<td><i>Fragaria</i></td>
	<td><i>Aspergillus</i> sp.</td>
	<td>Canada, NB; Canada, ON; Canada, AB</td>
	</tr>
	<tr class="pair" onclick="popit('')">
	<td><i>Fragaria x ananassa</i></td>
	<td><i>Aspergillus</i> sp.</td>
	<td>Canada: NB [<a href="">1</a>], [<a href="">2</a>]  ON [<a href="">3</a>]  AB [<a href="">2</a>], [<a href="">57</a>]</td>
	</tr>
	<tr class="imp" onclick="popit('')">
	<td><i>Glycine max</i></td>
	<td><i>Aspergillus</i> sp.</td>
	<td>Canada, NB; Canada, ON; Canada, AB</td>
	</tr>
	<tr class="pair" onclick="popit('')">
	<td><i>Helianthus annuus</i></td>
	<td><i>Aspergillus</i> sp.</td>
	<td>Canada, NB; Canada, ON; Canada, AB</td>
	</tr>
	<tr class="imp" onclick="popit('')">
	<td><i>Hordeum vulgare</i></td>
	<td><i>Aspergillus</i> sp.</td>
	<td>Canada, NB; Canada, ON; Canada, AB</td>
	</tr>
	<tr class="pair" onclick="popit('')">
	<td><i>Hyacinthus</i></td>
	<td><i>Aspergillus</i> sp.</td>
	<td>Canada, NB; Canada, ON; Canada, AB</td>
	</tr>
	<tr class="imp" onclick="popit('')">
	<td><i>Linum usitatissimum</i></td>
	<td><i>Aspergillus</i> sp.</td>
	<td>Canada, NB; Canada, ON; Canada, AB</td>
	</tr>
	<tr class="pair" onclick="popit('')">
	<td><i>Lycopersicon esculentum</i></td>
	<td><i>Aspergillus fumigatus</i></td>
	<td>Canada, NB; Canada, ON; Canada, AB</td>
	</tr>
	<tr class="imp" onclick="popit('')">
	<td><i>Lycopersicon esculentum var. commune</i></td>
	<td><i>Aspergillus ruber</i></td>
	<td>Canada, NB; Canada, ON; Canada, AB</td>
	</tr>
	<tr class="pair" onclick="popit('')">
	<td><i>Malus domestica</i></td>
	<td><i>Aspergillus</i> sp.</td>
	<td>Canada, NB; Canada, ON; Canada, AB</td>
	</tr>
	<tr class="imp" onclick="popit('')">
	<td><i>Malus pumila</i></td>
	<td><i>Aspergillus flavus</i></td>
	<td>Canada, NB; Canada, ON; Canada, AB</td>
	</tr>
	<tr class="pair" onclick="popit('')">
	<td><i>Medicago sativa</i></td>
	<td><i>Aspergillus</i> sp.</td>
	<td>Canada, NB; Canada, ON; Canada, AB</td>
	</tr>
	<tr class="imp" onclick="popit('')">
	<td><i>Nicotiana tabacum</i></td>
	<td><i>Aspergillus</i> sp.</td>
	<td>Canada, NB; Canada, ON; Canada, AB</td>
	</tr>
	<tr class="pair" onclick="popit('')">
	<td><i>Oryza sativa</i></td>
	<td><i>Aspergillus flavus</i></td>
	<td>Canada, NB; Canada, ON; Canada, AB</td>
	</tr>
	<tr class="imp" onclick="popit('')">
	<td><i>Panax quinquefolius</i></td>
	<td><i>Aspergillus</i> sp.</td>
	<td>Canada, NB; Canada, ON; Canada, AB</td>
	</tr>
	<tr class="pair" onclick="popit('')">
	<td><i>Phalaris canariensis</i></td>
	<td><i>Aspergillus</i> sp.</td>
	<td>Canada, NB; Canada, ON; Canada, AB</td>
	</tr>
	<tr class="imp" onclick="popit('')">
	<td><i>Picea</i></td>
	<td><i>Aspergillus</i> sp.</td>
	<td>Canada, NB; Canada, ON; Canada, AB</td>
	</tr>
	<tr class="pair"  onclick="popit('')">
	<td><i>Pinus</i></td>
	<td><i>Aspergillus</i> sp.</td>
	<td>Canada, NB; Canada, ON; Canada, AB</td>
	</tr>
	<tr class="imp" onclick="popit('')">
	<td><i>Pinus contorta var. latifolia</i></td>
	<td><i>Aspergillus</i> sp.</td>
	<td>Canada, NB; Canada, ON; Canada, AB</td>
	</tr>
	<tr class="pair" onclick="popit('')">
	<td><i>Pisum sativum</i></td>
	<td><i>Aspergillus</i> sp.</td>
	<td>Canada, NB; Canada, ON; Canada, AB</td>
	</tr>
	<tr class="imp" onclick="popit('')">
	<td><i>Populus</i></td>
	<td><i>Aspergillus</i> sp.</td>
	<td>Canada, NB; Canada, ON; Canada, AB</td>
	</tr>
	<tr class="pair" onclick="popit('')">
	<td><i>Populus trichocarpa</i></td>
	<td><i>Aspergillus</i> sp.</td>
	<td>Canada, NB; Canada, ON; Canada, AB</td>
	</tr>
	<tr class="imp" onclick="popit('')">
	<td><i>Prunus cerasus</i></td>
	<td><i>Aspergillus sydowi</i></td>
	<td>Canada, NB; Canada, ON; Canada, AB</td>
	</tr>
	<tr>
	<td><i>Rubus idaeus</i></td>
	<td><i>Aspergillus fumigatus</i></td>
	<td>Canada, NB; Canada, ON; Canada, AB</td>
	</tr>
	<tr>
	<td><i>Rubus melanolasius</i></td>
	<td><i>Aspergillus</i> sp.</td>
	<td>Canada, NB; Canada, ON; Canada, AB</td>

	</tr>
	<tr>
	<td><i>Setaria lutescens</i></td>
	<td><i>Aspergillus repens</i></td>
	<td>Canada, NB; Canada, ON; Canada, AB</td>
	</tr>
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