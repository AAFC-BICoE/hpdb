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
<div id="wb-body">	
<div id="wb-skip">		
<ul id="cn-tphp">			
<li id="wb-skip1">
<a href="#wb-cont">Skip to main content</a>
</li>			
<li id="wb-skip2">
<a href="#wb-nav">Skip to footer</a>
</li>		
</ul>	
</div>		<!-- PL-XSLT-ID:PREVIEW_MENU -->		
<div id="wb-head">		
<div id="wb-head-in">			
<header> 				<!-- HeaderStart -->				
<nav role="navigation">					
<div id="gcwu-gcnb">						
<h2>Government of Canada navigation bar</h2>						
<div id="gcwu-gcnb-in">							
<div id="gcwu-gcnb-fip">
<div id="gcwu-sig">
  <div id="gcwu-sig-in">
    <object data="http://www5.agr.gc.ca/res/wet-boew3.0.6/dist/theme-gcwu-fegc/images/sig-eng.svg" role="img" tabindex="-1" aria-label="Government of Canada" type="image/svg+xml">
      <img src="http://wet-boew.github.io/wet-boew-legacy/v3.1/dist/theme-gcwu-fegc/images/sig-eng.png" alt="Government of Canada" />
    </object>
  </div>
</div>															
<ul>									 
<li id="gcwu-gcnb1">
<a href="http://www.canada.ca/en/index.html" rel="external">Canada.ca</a>
</li>									 
<li id="gcwu-gcnb2">
<a href="http://www.servicecanada.gc.ca/eng/home.shtml" rel="external">Services</a>
</li>									 
<li id="gcwu-gcnb3">
<a href="http://www.canada.ca/en/gov/dept/index.html" rel="external">Departments</a>
</li>									 
<li id="gcwu-gcnb-lang">
<a href="/acp/fra/siti/rechercher" lang="fr">Fran&ccedil;ais</a>
</li>								 
</ul>							
</div>						
</div>					
</div>				
</nav>				
<div id="gcwu-bnr" role="banner">					
<div id="gcwu-bnr-in">
<div id="gcwu-wmms">
  <div id="gcwu-wmms-in">
    <object data="http://wet-boew.github.io/wet-boew-legacy/v3.1/dist/theme-gcwu-fegc/images/wmms.svg" role="img" tabindex="-1" aria-label="Symbol of the Government of Canada" type="image/svg+xml">
      <img src="http://wet-boew.github.io/wet-boew-legacy/v3.1/dist/theme-gcwu-fegc/images/wmms.png" alt="Symbol of the Government of Canada" />
    </object>
  </div>
</div>		
<div id="gcwu-title">							
<p id="gcwu-title-in">
<a href="">Host-Pathogen Database</a>
</p>						
</div>			            								
</div>				
</div>				
<nav role="navigation">					
<div id="gcwu-psnb">						
<h2>
<span>Site </span>menu</h2>						
<div id="gcwu-psnb-in">							
<div class="wet-boew-menubar mb-mega">								
<div>									
<ul class="mb-menu" data-ajax-replace="/eng/megamenu.inc?deliveryDestination=cbif">									
<li>
<section>
<h3>
<a href="http://www.agr.gc.ca/eng/programs-and-services/?id=1362675650980" target="_self">Programs and Services</a>
</h3>
<div class="mb-sm">
<div class="span-2">
<ul>
<li>
<a href="http://www.agr.gc.ca/eng/programs-and-services/agpal-program-and-service-finder/?id=1364218497997" target="_self">AgPal - Program and Service Finder</a>
</li>
<li>
<a href="http://www.agr.gc.ca/eng/programs-and-servicesWET-BOEW table filter
/list-of-programs-and-services/?id=1362151577626" target="_self">List of Programs and Services</a>
</li>
</ul>
</div>
<div class="clear"></div>
<div class="mb-main-link">
<a href="http://www.agr.gc.ca/eng/programs-and-services/?id=1362675650980" target="_self">Programs and Services &ndash; Main page</a>
</div>
</div>
</section>
</li>
<li>
<section>
<h3>
<a href="http://www.agr.gc.ca/eng/industry-markets-and-trade/?id=1360881916382" target="_self">Industry, Markets and Trade</a>
</h3>
<div class="mb-sm">
<div class="span-2">
<ul>
<li>
<a href="http://www.agr.gc.ca/eng/industry-markets-and-trade/statistics-and-market-information/?id=1361289956531" target="_self">Statistics and Market Information</a>
</li>
<li>
<a href="http://www.agr.gc.ca/eng/industry-markets-and-trade/market-access/?id=1373384342105" target="_self">Market Access</a>
</li>
<li>
<a href="http://www.agr.gc.ca/eng/industry-markets-and-trade/trade-events/?id=1410072148325" target="_self">Trade Events</a>
</li>
<li>
<a href="http://www.marquecanadabrand.agr.gc.ca/intro/index-eng.htm " target="_self">Branding (Canada Brand)</a>
</li>
<li>
<a href="http://www.agr.gc.ca/eng/industry-markets-and-trade/canadian-food-eatcanadian/?id=1392216500650" target="_self">Canadian Food (eatCanadian)</a>
</li>
<li>
<a href="http://www.agr.gc.ca/eng/industry-markets-and-trade/exporting-importing-and-buying-assistance/?id=1410072148276" target="_self">Exporting, Importing and Buying Assistance</a>
</li>
<li>
<a href="http://www.agr.gc.ca/eng/industry-markets-and-trade/food-regulations/?id=1361289832568" target="_self">Food Regulations</a>
</li>
<li>
<a href="http://www.agr.gc.ca/eng/industry-markets-and-trade/traceability/?id=1382971713721" target="_self">Traceability</a>
</li>
<li>
<a href="http://www.agr.gc.ca/eng/industry-markets-and-trade/agri-food-trade-policy/?id=1383918945146" target="_self">Agri-Food Trade Policy</a>
</li>
<li>
<a href="http://www.agr.gc.ca/eng/industry-markets-and-trade/value-chain-roundtables/?id=1385758087741" target="_self">Value Chain Roundtables</a>
</li>
</ul>
</div>
<div class="clear"></div>
<div class="mb-main-link">
<a href="http://www.agr.gc.ca/eng/industry-markets-and-trade/?id=1360881916382" target="_self">Industry, Markets and Trade &ndash; Main page</a>
</div>
</div>
</section>
</li>
<li>
<section>
<h3>
<a href="http://www.agr.gc.ca/eng/science-and-innovation/?id=1360882179814" target="_self">Science and Innovation</a>
</h3>
<div class="mb-sm">
<div class="span-2">
<ul>
<li>
<a href="http://www.agr.gc.ca/eng/science-and-innovation/research-centres/?id=1181591790641" target="_self">Research Centres</a>
</li>
<li>
<a href="http://www.agr.gc.ca/eng/science-and-innovation/scientific-staff-and-expertise/?id=1181931122989" target="_self">Scientific Staff and Expertise</a>
</li>
<li>
<a href="http://www.agr.gc.ca/eng/science-and-innovation/research-projects/?id=1208366237788" target="_self">Research Projects</a>
</li>
<li>
<a href="http://www.agr.gc.ca/eng/science-and-innovation/agricultural-practices/?id=1360876327795" target="_self">Agricultural Practices</a>
</li>
<li>
<a href="http://www.agr.gc.ca/eng/science-and-innovation/science-publications-and-resources/?id=1196363731573" target="_self">Science Publications and Resources</a>
</li>
<li>
<a href="http://www.agr.gc.ca/eng/science-and-innovation/technology-transfer-and-licensing/?id=1196968351190" target="_self">Technology Transfer and Licensing</a>
</li>
<li>
<a href="http://www.agr.gc.ca/eng/science-and-innovation/international-scientific-cooperation/?id=1180125607102" target="_self">International  Scientific Cooperation</a>
</li>
</ul>
</div>
<div class="clear"></div>
<div class="mb-main-link">
<a href="http://www.agr.gc.ca/eng/science-and-innovation/?id=1360882179814" target="_self">Science and Innovation &ndash; Main page</a>
</div>
</div>
</section>
</li>
<li>
<section>
<h3>
<a href="http://www.agr.gc.ca/eng/help/?id=1364493798980" target="_self">Help</a>
</h3>
<div class="mb-sm">
<div class="span-2">
<ul>
<li>
<a href="http://www.agr.gc.ca/eng/help/site-map/?id=1370269370649" target="_self">Site Map</a>
</li>
<li>
<a href="http://www.agr.gc.ca/eng/help/a-to-z-subject-index/?id=1204931113132" target="_self">A to Z Subject Index</a>
</li>
<li>
<a href="http://www.agr.gc.ca/eng/help/help-with-alternative-formats-and-plug-ins/?id=1168622342753" target="_self">Help with Alternative Formats and Plug-ins</a>
</li>
</ul>
</div>
<div class="clear"></div>
<div class="mb-main-link">
<a href="http://www.agr.gc.ca/eng/help/?id=1364493798980" target="_self">Help &ndash; Main page</a>
</div>
</div>
</section>
</li>																			
</ul>								
</div>							
</div>						
</div>					
</div>										
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
<footer>				
<h2 id="wb-nav">Footer</h2>				<!-- FooterStart -->				
<nav role="navigation">
<div id="gcwu-sft">
<h3>Site footer</h3>
<div id="gcwu-sft-in">
<div id="gcwu-tctr">
<ul>
<li class="gcwu-tc">
<a href="http://www-tmp.cbif.gc.ca/eng/?id=1370403266258" rel="license">Terms and Conditions</a>
</li>
<li class="gcwu-tr">
<a href="http://www.tbs-sct.gc.ca/pd-dp/gr-rg/index-eng.asp">Transparency</a>
</li>
</ul>
</div>
<div class="clear"></div>
<section>
<div class="span-2">
<h4 class="gcwu-col-head">
<a href="">About Us</a>
</h4>
<ul></ul>
</div>
</section>
<section>
<div class="span-2">
<h4 class="gcwu-col-head">
<a href="">Contact Us</a>
</h4>
<ul></ul>
</div>
</section>
</div>
</div>
</nav>				
<nav role="navigation">					
<div id="gcwu-gcft">						
<h3>Government of Canada footer</h3>						
<div id="gcwu-gcft-in">							
<div id="gcwu-gcft-fip">								
<ul>									
<li>
<a href="http://healthycanadians.gc.ca/index-eng.php" rel="external"><span>Health</span></a>
</li>									
<li>
<a href="http://www.travel.gc.ca/index-eng.asp" rel="external"><span>Travel</span></a>
</li>									
<li>
<a href="http://www.servicecanada.gc.ca/eng/home.shtml" rel="external"><span>Service Canada</span></a>
</li>									
<li>
<a href="http://www.jobbank.gc.ca/intro-eng.aspx" rel="external"><span>Jobs</span></a>
</li>									
<li>
<a href="http://actionplan.gc.ca/en" rel="external"><span>Economy</span></a>
</li>									
<li id="gcwu-gcft-ca">
<div>
<a href="http://www.canada.ca/en/index.html">Canada.ca</a>
</div>
</li>								
</ul>							
</div>						
</div>					
</div>				
</nav>				<!-- FooterEnd --> 			
</footer>		
</div>	
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