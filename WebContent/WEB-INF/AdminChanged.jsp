<!DOCTYPE HTML>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Phone Inventory Admin</title>
<link href="admin_login.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div id="container">


  <div id="header">
  <div id="logo"><img src="images/icterra.png" width="247" height="90" alt="image not found" /></div>      
  </div>
  <div class="clear"></div>
  
   <hr/>
  <p>${message}</p>
   <hr/>
   <div class="button_position">
   <form action="AdminMenu" method="post">
   <input type="hidden" name="user" value="${user}"/>
   <button type="submit" class="button" name="choice" value="AdminMenu">Return To Admin Menu</button>
   </form>
   </div>
</div>
</body>
</html>