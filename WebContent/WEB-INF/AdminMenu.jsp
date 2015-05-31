<!DOCTYPE HTML>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Phone Inventory Admin</title>
<link href="admin_menu.css" rel="stylesheet" type="text/css" />
</head>
 <body>
 <div id="container" style="width:800px; height:450px">


  <div id="header" style="width:800px;">
  <div id="logo"><img src="images/icterra.png" width="247" height="90" alt="image not found" /></div>      
  </div>
  <div class="clear"></div>
<h2 style="text-align:center;">Admin Menu</h2>
<hr/>
<div class="menu_contaniner">
<p> Add a new <strong>PHONE</strong> or delete &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; an existing one. </p>
<hr/>
<form action="AdminMenu" method="post">
<div class="button_position">
<button type="submit" class="button" name="choice" value="PhoneAdd" >Add a new <strong>Phone</strong></button>
</div>

<div class="button_position">
<button type="submit" class="button" name="choice" value="PhoneDelete" >Delete an existing <strong>Phone</strong></button>
</div>
</form>
</div>

<div class="menu_contaniner">
<p style="text-align:center;"> Show free or crossing <strong>IP Adresses</strong></p>
<hr/>
<form action="AdminMenu" method="post">
<div class="button_position">
<button type="submit" class="button" name="choice" value="IpListFree" >Show <strong>free</strong> IP adresses</button>
</div>
</form>

<form action="AdminMenu" method="post">
<div class="button_position">
<button type="submit" class="button" name="choice" value="IpListCross" >Show <strong>crossing</strong> IP adresses</button>
</div>
</form>

</div>

<div class="menu_contaniner">
<p> Change <strong>ADMIN NAME</strong> or &nbsp; &nbsp; &nbsp;<strong>ADMIN PASSWORD</strong> </p>
<hr/>
<form action="AdminMenu" method="post">
<input type="hidden" name="choice" value="AdminChange"/>
<input type="hidden" name="user" value="${user}"/>
<div class="button_position">
<button type="submit" class="button" name="change" value="user" > Change &nbsp; &nbsp;<strong>Admin Name</strong></button>
</div>

<div class="button_position">
<button type="submit" class="button" name="change" value="password" > Change <strong>Admin Password</strong></button>
</div>
</form>
</div>




</div>
</body>
</html>