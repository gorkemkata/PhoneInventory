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
<button type="button" onclick="selectAll()">Select All</button>
<div style="height:auto; width:378px; border: 1px solid #000">
<% 
@SuppressWarnings("unchecked")
List<String> list = (List<String>) request.getAttribute("list");
%>
<textarea id="ipList" autofocus="autofocus" rows="<%=(list.size() ) * 2%>" cols="50">
 Total: <%=list.size()%>
 -----------------------------<% 
for (int i=0;i<list.size();i++)
{	
%>
 Free Ip Address: <%=list.get(i)%>
 -----------------------------<%}%>
</textarea>
</div>
<script>
function selectAll(){
	document.getElementById("ipList").select();
	
}
</script>
</div>
</body>
</html>