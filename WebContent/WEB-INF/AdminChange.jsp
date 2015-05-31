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

<div id="login_box_container">

<form action="AdminMenu" method="post">
<input type="hidden" name="changed" value="${changed}"/>
<input type="hidden" name="user" value="${user}"/>
<div class="login_box" >
<p>${message1}</p>
<input class="admin_textbox" type="Password" autocomplete="off" style="background-position: 5px -55px;" placeholder=" ${placeholder1}" name="oldPassword" />
</div>
<div class="login_box" style="margin-top:40px; margin-bottom:55px;">
<p>${message2}</p>
<input class="admin_textbox" type="${inputType}" autocomplete="off" style="background-position: 5px -7px;" placeholder=" ${placeholder2}" name="newValue" />
</div>
 
<div class="button_position">
<button type="submit" class="button" name="choice" value="AdminChanged">Save Changes</button>
</div>
</form>

</div> 
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