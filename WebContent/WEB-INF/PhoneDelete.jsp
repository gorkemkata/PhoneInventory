<!DOCTYPE HTML>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Phone Inventory</title>
<link href="admin_menu.css" rel="stylesheet" type="text/css" />
</head>

<body>
<div id="container" style="height:850px;">


 <div id="header">
 <div id="logo"><img src="images/icterra.png" width="247" height="90" alt="image not found" /></div> 
 </div>     
 <div id="clear-header"></div>
 <hr/>
  <p  style="margin-left:10px; margin-top:55px;"><font size="4">
  List phones to select from or directly search a specific phone.
  </font>
  </p>   
    <div id="search_menu">
  
        <div id="search_element">
        
         <form action="Lister" method="get">  
        <input type="text" class="textbox" style="width:170px; float:left" name="search_term" />
        <input type="hidden" name="admin" value="true"/>
        <div style="float:left; height:33px; width:69px; margin-top:-3px; margin-left:-3px;">
         <button type="submit" class="button" style="padding: 4px 9px; border-radius:3px;" name="choice" value="search">Search</button>
       </div>
       
       </form>
       </div>
  </div>
   
<form id="phonelister" action="Lister" method="get" >
<input type="hidden" name="admin" value="true"/>
<div id="checkbox_container">

<div id="checkbox_lo" class="checkbox">

<input type="checkbox" name="openstage15" id="openstage15" value="openstage15" class="main-checkbox" />  
<label for="openstage15" class="big">OpenStage 15</label>  
<br/> 
<br/>
<input type="checkbox" name="openstage20" id="openstage20" value="openstage20" class="main-checkbox" />  
<label for="openstage20" class="big">OpenStage 20</label>  
<br/>
<br/>
<input type="checkbox" name="openstage40" id="openstage40" value="openstage40" class="main-checkbox" />  
<label for="openstage40" class="big">OpenStage 40</label>
</div>



<div id="checkbox_hi">
<input type="checkbox" name="openstage60" id="openstage60" value="openstage60" class="main-checkbox" />  
<label for="openstage60" class="big">OpenStage 60</label>
<br/>
<br/>
<input type="checkbox" name="openstage80" id="openstage80" value="openstage80" class="main-checkbox" />  
<label for="openstage80" class="big">OpenStage 80</label>
</div>




<div id="checkbox_we">
<input type="checkbox" name="we2-t26-1" id="WE2-T26-1" value="we2-t26-1" class="main-checkbox" />  
<label for="WE2-T26-1" class="big">WE2-T26-1</label>
<br/> 
<br/>
<input type="checkbox" name="we2-t28" id="WE2-T28" value="we2-t28" class="main-checkbox" />  
<label for="WE2-T28" class="big">WE2-T28</label>
<br/> 
<br/>
<input type="checkbox" name="we2-t40" id="WE2-T40" value="we2-t40" class="main-checkbox" />  
<label for="WE2-T40" class="big">WE2-T40</label>
</div>

</div>
<div class="clear"></div>

<div id="list_button"> 

<button type="submit" class="button" name="choice" value="low">List LO Phones</button>



<button type="submit" class="button" name="choice" value="multiple">List Selected Phones</button>



<button type="submit" class="button" name="choice" value="high">List HI Phones</button>

<div style="height: 20px; width: 1000px; margin-top:10px; margin-left:20px;">

 <input type="checkbox"  name="checkall" id="select_all" class="main-checkbox-small"  onclick="SetAllCheckBoxes('phonelister','checkbox_container',this.checked);" />
 <label for="select_all" class="small">Select All &nbsp; &nbsp; &nbsp; </label> 

<input type="checkbox" checked="checked" name="show_working" id="show_working" value="true" class="main-checkbox-small" style="margin-left:12px;" />  
<label for="show_working" class="small">Only Show Working Phones &nbsp; &nbsp;  </label>

<input type="checkbox" checked="checked" name="show_free" id="show_free" value="true" class="main-checkbox-small" style="margin-left:12px;" />  
<label for="show_free" class="small">Only Show Free Phones</label>
</div> 

</div> 
<div class="clear"></div>
</form>

   <hr/>
   <div class="button_position" style="margin-left:450px;">
   <form action="AdminMenu" method="post">
   <button type="submit" class="button" name="choice" value="AdminMenu"><strong>Return to Admin Menu</strong></button>
   </form>
   </div>

 <script>
  
    function SetAllCheckBoxes(FormName, AreaID, CheckValue)
   {
      if(!document.forms[FormName])
          return;
      var objCheckBoxes = document.getElementById(AreaID).getElementsByTagName('input');
      if(!objCheckBoxes)
          return;
      var countCheckBoxes = objCheckBoxes.length;
      if(!countCheckBoxes)
          objCheckBoxes.checked = CheckValue;
      else
          for(var i = 0; i < countCheckBoxes; i++)
            objCheckBoxes[i].checked = CheckValue;
}


</script>
  

</div>
</body>
</html>
