<%@page language="java" import="java.util.*" %>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="phone_update_style.css" rel="stylesheet" type="text/css" />
<title>Phone Inventory Admin</title>
</head>
<body>
<div id="container" style="height:auto;">

<div id="header">
<div id="logo"><img src="images/icterra.png" width="247" height="90" alt="image not found" /></div> 
</div>     
<div id="clear-header"></div>
<hr/>
<br/>
<h3 style="text-align:left;">${message}</h3>
<hr/>
<% 
@SuppressWarnings("unchecked")
List<String> list = (List<String>) request.getAttribute("list");
for (int i=0;i<list.size();i+=2)
{
	
	
%>
<p> Crossing IP Address: <%=list.get(i)%> </p>   
<p> MAC Addresses: <%=list.get(i+1)%>  </p> 
<hr/>
<%}%>

</div>
</body>
</html>