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
<strong>About:</strong>
<br>
<br>
<p>
The Canadian Host-Pathogen Database is an index of published records of microorganisms, focused on fungi but also including bacteria, nematodes, viruses and phytoplasma that are either parasitic on living vascular plants in Canada or have been recorded as decaying plant parts that can be identified to host genus.
</p>
<p>
The foundations of the database were two published indices (Conners 1967, Ginns 1986) that were scanned and whose data were merged with the help of special funding by Environment Canada. Additional data covering another decade of literature was added in early versions by Drs. Michael Corlett and Philip Martin (unpublished). Subsequently, additional literature was surveyed with funding by Defence Research and Development Canada via the Chemical, Biological, Radiological-Nuclear (CRBN) Research and Technology Initiative (CRTI). The project is on going.
</p>
<p>
Limitations of coverage - the database was not intended to include most mycorrhizal fungi or lichenized fungi that are epiphytic, nor does it include fungi parasitic on other fungi, or fungi on bryophytes or algae. Conners' annotated index covered all of northern North America including Alaska and Greenland. His historical records were retained. Ginns' compendium only included fungi and did not cover Alaska or Greenland. Records of bacteria and other groups were added by Corlett & Martin for that period and an additional decade. For the 1967 publication Conners attempted to collate the anamorph and teleomorph names for biological species. In 1986, Ginns followed suit but many assigned fungal names had changed. Since then the field of mycology has been revolutionized by molecular phylogenetic re-analyses and it has been changing so fast that it is premature to fully align all names. Therefore, names of organisms may be recorded as reported in publications or synonymous names (dependent upon decade of recording). Use of the database should include searches under any applicable name. Historical records must be viewed with some skepticism when species have been subsequently shown to species complexes.
</p>
<p>
The database is further limited by the coverage of publications. Not all journals have been surveyed up to the current date and not all monographs or incidental publications are included. 
</p>
<p>
Conners, I.L. 1967. An annotated index of plant diseases in Canada and fungi recorded on plants in Alaska, Canada, and Greenland. Canada  Dept. Agri. Publ. 1251.
</p>
<p>
Ginns, J. H. 1986. Compendium of Plant Disease and Decay Fungi in Canada 1960-1980. Research Branch, Agriculture Canada. Publ. 1813. 
</p>
<br>
<p>
<strong>
Contact information: 
</strong>
<br>
<br>
General Collection Information: <a href="mailto:Scott.Redhead@canada.ca?Subject=Canadian%20Host-Pathogen%20Database:" target="_top">Scott A. Redhead</a>
<br>
Data Input and  Curation: <a href="mailto:Jennifer.Wilkinson@canada.ca?Subject=Canadian%20Host-Pathogen%20Database:" target="_top">Jennifer Wilkinson</a>
<br>
Web Development (Contact email): <a href="mailto:AAFC.BICE-CEIB.AAC@canada.ca?Subject=Canadian%20Host-Pathogen%20Database:" target="_top">Biological Informatics Centre of Excellence</a>
</p>
</body>
