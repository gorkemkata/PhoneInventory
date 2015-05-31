<!DOCTYPE HTML>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Phone Inventory</title>
<link href="main_style.css" rel="stylesheet" type="text/css" />
</head>

<body>
<div id="container">


  <div id="header">
  
  <div id="logo"><img src="images/icterra.png" width="247" height="90" alt="image not found"/></div>
  
  <div id="search_menu">
  
        <div id="search_element">
        
         <form action="Lister" method="get">  
        <input type="text" class="textbox" style="width:170px; float:left" name="search_term" />
        
        <div style="float:left; height:33px; width:69px; margin-top:-3px; margin-left:-3px;">
         <button type="submit" class="button" style="padding: 4px 9px; border-radius:3px;" name="choice" value="search">Search</button>
       </div>
       
       </form>
       </div>
  </div>
    
   <div id="admin_login">
   
   <div style="height:20px; width:90px; margin-left:55px; margin-top:15px;" >
   <a href="AdminLogin?login=t">
   <b >Admin Login</b>
     </a>
   </div>
   
   <div style="height:48px; width:48px; margin-left:107px; margin-top:-22px;" >
    <a href="AdminLogin?login=t">
   <img style="border:0;" src="images/admin.png"  width="42" height="42" alt="image not found"/>
     </a>
   </div>
 
   </div>
    
    
  </div>
  
 <div class="clear"></div>
 <hr/>
 <h2 style="margin-left:15px;">Drop a Phone</h2>
 
 <div id="drop_menu">
 
     
     
    
       <div>
       <form action="PhoneDropper" method="post">  
        <b style="font-size:22;"><font size="4">Drop a Phone by IP </font>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; : &nbsp; &nbsp;</b>
        <input type="text" class="textbox" name="drop_ip" value="192.168.2." style="width:220px;" /> &nbsp; &nbsp; 
         <button type="submit" class="button" name="drop" value="ip">Drop</button>
       </form>
       <br/>
       <form action="PhoneDropper" method="post">  
       

       <b><font size="4">Drop a Phone by Mac</font>&nbsp; &nbsp; &nbsp; &nbsp;: &nbsp; &nbsp; </b> 
        
        <input type="text" class="textbox" id="mac1" name="mac1" value="00" maxlength="2" style="width:20px;" /> : 
        <input type="text" class="textbox" id="mac2" name="mac2" value="1A" maxlength="2" style="width:20px;" /> : 
        <input type="text" class="textbox" id="mac3" name="mac3" value="E8" maxlength="2" style="width:20px;" /> : 
        <input type="text" class="textbox" id="mac4" name="mac4" value=""   maxlength="2" style="width:30px;" /> : 
        <input type="text" class="textbox" id="mac5" name="mac5" value=""   maxlength="2" style="width:30px;" /> : 
        <input type="text" class="textbox" id="mac6" name="mac6" value=""   maxlength="2" style="width:30px;" /> &nbsp; &nbsp; 
        <button type="submit" class="button" style="font-size:24;" name="drop" value="mac">Drop</button>
      
       </form>
        <br/>
       <form action="Lister" method="get">  

        <b><font size="4">Drop by Reserver Name</font> &nbsp; : &nbsp; &nbsp;</b>
        <input type="text" class="textbox" name="search_term" value="" style="width:220px;" /> &nbsp; &nbsp;
        <button type="submit" class="button" name="drop_search" value="drop_by_name">Drop</button>
    
       </form>   
       </div>    
 
 </div>
 <div class="clear"></div>


<hr/>
<h2 style="margin-left:15px;">Reserve a Phone</h2>



<form id="phonelister" action="Lister" method="get" >
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

<script type="text/javascript" src="http://code.jquery.com/jquery-1.7.1.js"></script>

<script>
	$(function(){
		$('#mac1,#mac2,#mac3,#mac4,#mac5').keyup(function(e){
			if($(this).val().length==$(this).attr('maxlength'))
				$(this).next(':input').focus();
		});
	});
	</script>

</div>
</body>
</html>
