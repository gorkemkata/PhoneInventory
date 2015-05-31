<!DOCTYPE HTML>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Phone Inventory</title>
<link href="phone_update_style.css" rel="stylesheet" type="text/css" />
</head>

<body>
<div id="container" style="height:450px;">


 <div id="header">
 <div id="logo"><img src="images/icterra.png" width="247" height="90" alt="image not found" /></div> 
 </div>     
 <div id="clear-header"></div>
 <hr/>
 <br/>
  <h3 style="text-align:center;">${message}</h3>
             
  <div class="table_container">  

   <div class="phone_image" > <a href="PhoneInventory">
    <img src="${imageUri}" width="72" height="49" border="0" style="padding-bottom:0.5em;" alt="image not found" /></a> ${phone.model}
    </div> 
       <form action="PhoneUpdate" method="post">
  <table class="info" border="1">  
  
  <tr>    
  <th>Ip Address</th>  

  <th>Mac Address</th>   

  <th>Software</th>    
  
  <th>Status</th>    
  
  <th>Note</th>   

  <th>Reserver</th> 
  </tr>
  
  <tr>	

 

   
  <td>	
  <input class="info_box" type="text" name="ipAddress" value="${phone.ip}"/>
  </td>	
  
  <td>	
  <input class="info_box" type="text" name="mac" value="${phone.mac}"/>	
  </td>	
  
  <td>
  <input class="info_box" type="text" name="software" value="${phone.software}"/>
  </td>
  
  <td>	
   <select name="status">
   <option>${phone.status}</option>
   </select>
  </td>	
  
  
  <td>
  <input class="info_box" type="text" name="note" value="${phone.note}" />
  </td>

  <td>
  <input class="info_box" type="text" name="reserver" value="${phone.reserver}" />
  </td>  
 
  </tr> 
 
 
 
  </table>  
    
 </form>
  <div id="clear-content"></div>
  </div>
</div>
</body>
</html>
