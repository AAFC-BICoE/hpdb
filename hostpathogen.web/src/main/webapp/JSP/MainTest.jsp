<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Register</title>
</head>
<body>
<div id="gcwu-bc">
<h2>Breadcrumb trail</h2>
<div id="gcwu-bc-in">
<ol>
<li><a href="http://www.cbif.gc.ca/eng/home/?id=1370403266262">Home</a></li>
<li><a href="../index.jsp">Host-Pathogen Database</a></li>
<li><a href="MainTest.jsp">Search Records</a></li>
</ol>
</div>
</div>
<div id="wb-core">
<div class="equalize" id="wb-core-in">
<div id="wb-main" role="main">
<div id="wb-main-in">
<div id="wb-cont"></div>
						
						<!--Body Start-->
						<div class="container">
							<h1>Search Records</h1>

							<s:form id="searchHostForm" action="Submit.jsp" method="GET">

								<details class="span-8" open="open">
									<summary class="module-info module-simplify" style="margin-right: 15px">
										<b>Host Search</b>
									</summary>
									<div style="width: 100%; margin-top: 20px" class="form-inline">
										<label class="col-sm-2 control-label">Family: </label> 
											<input id="hostFamily" type="text" name="hfamily" size="18" style="width: 20%" /> 
										<label class="col-sm-2 control-label">Genus: </label> 
											<input id="hostGenus" type="text" name="hgenus" size="18" style="width: 20%" /> 
										<label class="col-sm-2 control-label">Species: </label> 
											<input id="hostSpecies" type="text" name="hspecies" size="18" style="width: 20%" /> 
										<label class="checkbox-inline">Synonyms 
											<input type="checkbox" id="hostSynonym" name="hostSynonym" value="true" style="margin-left: 15px; margin-right: 5px; margin-top: 10px" />
										</label>
									</div>
								</details>

								<div class="clear" id="cl2"></div>

								<details class="span-8" open="open">
									<!--Search Pathogen-->
									<summary class="module-info module-simplify" style="margin-right: 15px">
										<b>Pathogen Search</b>
									</summary>
									<div class="form-inline" id="pathsearch" style="margin-top: 20px">
											<input id="toggle1" type="radio" name="pathogen" class="chkbox fungaldisplay" checked="checked" /> 
										<label for="toggle1">&#160;&#160;Fungus/Bacteria/Nematode</label> 
											<input id="toggle2" type="radio" name="pathogen" class="chkbox viraldisplay" /> 
										<label for="toggle2">&#160;&#160;Virus/MPLO</label>
										<div id="fungaldisplay" class="box">
											<label class="col-sm-2 control-label">Genus: </label> 
												<input id="pathogenGenus" type="text" name="pgenus" /> 
											<label class="col-sm-2 control-label">Species: </label> 
												<input id="pathogenSpecies" type="text" name="pspecies" /> 
											<label class="checkbox-inline">Synonyms</label> 
												<input type="checkbox" id="pathogenSynonym" name="pathogenSynonym" value="true" style="margin-left: 15px; margin-right: 5px; margin-top: 10px" />
										</div>
										<div id="viraldisplay" class="box">
											<label class="col-sm-2 control-label">Virus/MPLO Name: </label>
												<input id="pathogenVirus" type="text" name="pvirus" />
										</div>
									</div>
								</details>

								<div class="clear" id="cl2"></div>

								<details class="span-8" open="open">
									<!--Search Location-->
									<summary class="module-info module-simplify" style="margin-right: 15px">
										<b>Location Search</b>
									</summary>
									<div class="form-inline mrgn-tp-md" style="margin-top: 20px">
										<span class="mrgn-tp-md"> 
										<label class="col-sm-2 control-label wb-inv" for="form-select-md">Country: </label> 
											<select id="country" name="country" class="form-control mrgn-bttm-md">
												<option label="" value=""></option>
												<option label="Canada" value="Canada">Canada</option>
												<option label="USA" value="USA">USA</option>
												<option label="Puerto Rico" value="Puerto Rico">Puerto
													Rico</option>
												<option label="Virgin Islands" value="Virgin Islands">Virgin
													Islands</option>
												<option label="Cuba" value="Cuba">Cuba</option>
												<option label="Ecuador" value="Ecuador">Ecuador</option>
												<option label="Guatemala" value="Guatemala">Guatemala</option>
												<option label="Grenada" value="Grenada">Grenada</option>
												<option label="Haiti" value="Haiti">Haiti</option>
												<option label="Martinique" value="Martinique">Martinique</option>
												<option label="Republic of Panama"
													value="Republic of Panama">Republic of Panama</option>
												<option label="Trinidad" value="Trinidad">Trinidad</option>
												<option label="Saint-Pierre and Miquelon"
													value="Saint-Pierre and Miquelon">Saint-Pierre and
													Miquelon</option>
												<option label="North America" value="North America">North
													America</option>
												<option label="Jamaica" value="Jamaica">Jamaica</option>
												<option label="Experimental Conditions"
													value="Experimental Conditions">Experimental
													Conditions</option>
												<option label="Greenland" value="Greenland">Greenland</option>
												<option label="Mexico" value="Mexico">Mexico</option>
										</select>
										</span> 
										<span> 
										<label class="col-sm-2 control-label" for="form-select-md" class="wb-inv">Province/State: </label>
											<select id="provStateTerritory" name="provstate" class="form-control mrgn-bttm-md">
												<option label="" value=""></option>
												<option label="AB" value="AB">AB</option>
												<option label="BC" value="BC">BC</option>
												<option label="MB" value="MB">MB</option>
												<option label="NB" value="NB">NB</option>
												<option label="NF" value="NF">NF</option>
												<option label="NT" value="NT">NT</option>
												<option label="NS" value="NS">NS</option>
												<option label="NU" value="NU">NU</option>
												<option label="ON" value="ON">ON</option>
												<option label="PE" value="PE">PE</option>
												<option label="SK" value="SK">SK</option>
												<option label="QC" value="QC">QC</option>
												<option label="AL" value="AL">AL</option>
												<option label="AK" value="AK">AK</option>
												<option label="AZ" value="AZ">AZ</option>
												<option label="AR" value="AR">AR</option>
												<option label="CA" value="CA">CA</option>
												<option label="CO" value="CO">CO</option>
												<option label="CT" value="CT">CT</option>
												<option label="DE" value="DE">DE</option>
												<option label="DC" value="DC">DC</option>
												<option label="FL" value="FL">FL</option>
												<option label="GA" value="GA">GA</option>
												<option label="HI" value="HI">HI</option>
												<option label="ID" value="ID">ID</option>
												<option label="IL" value="IL">IL</option>
												<option label="IN" value="IN">IN</option>
												<option label="IA" value="IA">IA</option>
												<option label="KS" value="KS">KS</option>
												<option label="KY" value="KY">KY</option>
												<option label="LA" value="LA">LA</option>
												<option label="ME" value="ME">ME</option>
												<option label="MD" value="MD">MD</option>
												<option label="MA" value="MA">MA</option>
												<option label="MI" value="MI">MI</option>
												<option label="MN" value="MN">MN</option>
												<option label="MS" value="MS">MS</option>
												<option label="MO" value="MO">MO</option>
												<option label="MT" value="MT">MT</option>
												<option label="NE" value="NE">NE</option>
												<option label="NV" value="NV">NV</option>
												<option label="NH" value="NH">NH</option>
												<option label="NJ" value="NJ">NJ</option>
												<option label="NM" value="NM">NM</option>
												<option label="NY" value="NY">NY</option>
												<option label="NC" value="NC">NC</option>
												<option label="ND" value="ND">ND</option>
												<option label="OH" value="OH">OH</option>
												<option label="OK" value="OK">OK</option>
												<option label="OR" value="OR">OR</option>
												<option label="PA" value="PA">PA</option>
												<option label="PR" value="PR">PR</option>
												<option label="RI" value="RI">RI</option>
												<option label="SC" value="SC">SC</option>
												<option label="SD" value="SD">SD</option>
												<option label="TN" value="TN">TN</option>
												<option label="TX" value="TX">TX</option>
												<option label="UT" value="UT">UT</option>
												<option label="VT" value="VT">VT</option>
												<option label="VI" value="VI">VI</option>
												<option label="VA" value="VA">VA</option>
												<option label="WA" value="WA">WA</option>
												<option label="WV" value="WV">WV</option>
												<option label="WI" value="WI">WI</option>
												<option label="WY" value="WY">WY</option>
												<option label="CU" value="CU">CU</option>
												<option label="EC" value="EC">EC</option>
												<option label="GU" value="GU">GU</option>
												<option label="GR" value="GR">GR</option>
												<option label="HA" value="HA">HA</option>
												<option label="MQ" value="MQ">MQ</option>
												<option label="NG" value="NG">NG</option>
												<option label="PN" value="PN">PN</option>
												<option label="RP" value="RP">RP</option>
												<option label="TR" value="TR">TR</option>
												<option label="SM" value="SM">SM</option>
												<option label="NA" value="NA">NA</option>
												<option label="JA" value="JA">JA</option>
												<option label="EX" value="EX">EX</option>
												<option label="US" value="US">US</option>
												<option label="CD" value="CD">CD</option>
												<option label="GL" value="GL">GL</option>
												<option label="MX" value="MX">MX</option>
												<option label="FK" value="FK">FK</option>
												<option label="KW" value="KW">KW</option>
												<option label="LB" value="LB">LB</option>
												<option label="MK" value="MK">MK</option>
												<option label="MR" value="MR">MR</option>
												<option label="PC" value="PC">PC</option>
												<option label="YT" value="YT">YT</option>
										</select>
									</div>
								</details>
								<div class="clear"></div>

								<div class="span-3 row-end" style="margin-top: 2%">
									<input id="SearchForm" name="SearchFormButton" type="submit"
										value="Search" method="execute"
										style="display: inline-block; margin: 0 5px 0 5px"
										class="button-accent" /> 
									<input id="Reset" name="Reset"
										type="submit" value="Reset" method="reset"
										style="display: inline-block; margin: 0 5px 0 5px;"
										class="button-accent" />
								</div>
							</form>

						</div>
						<!-- End of the Body -->
						<div class="clear"></div>

						<div class="versionF"
							style="float: right; margin-right: 10px; padding: 0">
							<span class="left">Host-Pathogen Database Version 1 |</span> <span
								class="right">&copy; 2014-2015 <a
								href="http://www.agr.gc.ca/">Agriculture &amp; AgriFood Canada</a></span>
						</div>
					</div>
				</div>
			</div>
			<div id="wb-foot">
				<div id="wb-foot-in">
				</div>
			</div>
		</div>


</body>
</html>