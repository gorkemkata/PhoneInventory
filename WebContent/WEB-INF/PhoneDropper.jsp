<!DOCTYPE HTML>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Phone Inventory</title>
<link href="dropper_style.css" rel="stylesheet" type="text/css" />
</head>

<body>
<div id="container">


  <div id="header">
    <div id="logo"><img src="images/icterra.png" width="247" height="90" alt="image not found" /></div> 
    
        
       <div id="search_menu">
  
        <div id="search_element">
        
         <form action="Lister"  method="post">  
        <input type="text" class="textbox" style="width:170px; float:left" name="search_term"/>
        
        <div style="float:left; height:33px; width:69px; margin-top:-3px; margin-left:-3px;">
         <button type="submit" class="button" style="padding: 4px 9px; border-radius:3px;" name="choice" value="search">Search</button>
       </div>
       
       </form>
       </div>
       </div>
    
    
          </div>
  
  <div id="clear-header"></div>
  

  <div class="phone_container">  
  <div class="phone_image" > <a href="PhoneInventory"> <img src="${imageUri}" width="72" height="49" border="0" style="padding-bottom:0.5em;" alt="image not found"  /></a> ${phone.model}</div> 
  
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
  <input class="info_box" type="text" name="Ip Address" value="${phone.ip}" />
  </td>	
  
  <td>	
  <input class="info_box" type="text" name="Mac Address" value="${phone.mac}" /> 
  </td>	
  
  <td>
  <input class="info_box" type="text" name="Software" value="${phone.software}" />
  </td>

  <td>
  <input class="info_box" type="text" name="Status" value="${phone.status}" />	
  </td>	
  
  <td>
  <input class="info_box" type="text" name="Note" value="${phone.note}" />
  </td>

  <td><input class="info_box" type="text" name="Reserver" value="${phone.reserver}" />
  </td>  
  </tr> 
  </table>             

  <div id="clear-content"></div>
  </div>
  
    <hr/>
   <div class="button_position">
   <form action="PhoneInventory">
   <button type="submit" class="button">Return To Main Page </button>
   </form>
   </div>
 




</div>
</body>
</html>
