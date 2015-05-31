<%@page language="java" import="java.util.*" %>
<!DOCTYPE HTML>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Phone Inventory Admin</title>
<link href="admin_menu.css" rel="stylesheet" type="text/css" />

<script>

function verifyMAC(MACvalue) {
	errorString = "";
	theName = "MAC Address";
	teststr= MACvalue; 
	regex=/^([0-9a-f]{2}([:-]|$)){6}$|([0-9a-f]{4}([.]|$)){3}$/i; 

	if (regex.test(teststr)){ 
		return true;
	} else { 
	   errorString = errorString + theName + ': '+MACvalue+' is not a valid MAC address.';
	   alert (errorString);
	   return false;
   } 
} 

function verifyIP(IPvalue) {
	errorString = "";
	theName = "IP address";
	
	var ipPattern = /^(\d{1,3})\.(\d{1,3})\.(\d{1,3})\.(\d{1,3})$/;
	var ipArray = IPvalue.match(ipPattern);
	
	if (IPvalue == "0.0.0.0") {
		errorString = errorString + theName + ': '+IPvalue+' is a special IP address and cannot be used here.';
	} else if (IPvalue == "255.255.255.255") {
		errorString = errorString + theName + ': '+IPvalue+' is a special IP address and cannot be used here.';
	}
	if (ipArray == null) {
		errorString = errorString + theName + ': '+IPvalue+' is not a valid IP address.';
	} else {
		for (var i = 0; i < 4; i++) {
			thisSegment = ipArray[i];
			if (thisSegment > 255) {
				errorString = errorString + theName + ': '+IPvalue+' is not a valid IP address.';
				i = 4;
			}
			if ((i == 0) && (thisSegment > 255)) {
				errorString = errorString + theName + ': '+IPvalue+' is a special IP address and cannot be used here.';
				i = 4;
		  	} 
		}
	} 
	extensionLength = 3;
	if (errorString == "") {
		return true;
	} else {
		alert (errorString);
		return false;
	}
} 
	
function checkValidation(MACvalue, IPvalue, modelName) {
	if (!verifyIP(IPvalue)) {
		return false;
	}
	if (!verifyMAC(MACvalue)){
		return false;
	}
	if (!checkModel(modelName)){
		return false;
	}

	return true;
}


 function checkModel(modelName){
	 if(modelName == ""){
		alert("Please Select a Model!");
	    return false;
	 }
	 
	 if(modelName == "Openstage15" || modelName == "Openstage20" || modelName == "Openstage40" || modelName == "Openstage60"
		 || modelName == "Openstage80" || modelName == "we2-T26-1" || modelName == "we2-T28" || modelName == "we2-T40")
		return true;
	
	 else{
		var selected = confirm("You are adding a model that didn't exist in database before. Are you sure that you didn't enter the model name wrong?"+
				 "Click OK if you want to add a new model to database.");
		 if(selected)
			 return true;
		 else return false;
	 }	 	 
}


</script>


</head>
 <body>
 
 <div id="container">


  <div id="header">
  <div id="logo"><img src="images/icterra.png" width="247" height="90" alt="image not found" /></div>      
  </div>
  <div class="clear"></div>
  <p  style="margin-left:10px; margin-top:55px;"><font size="4">
  Fill the needed information then click on Add button to save the phone to database. Columns that are marked with (*) are mandatory to fill.
  </font>
  </p>
    <p style="margin-left:10px; margin-top:15px;"><font size="3">
 <strong>Note:</strong> You can add a new phone model by entering it's name to drop down menu.
  </font>
  </p>
  <div class="table_container">  
  <form action="AdminMenu" method="post">
  <table class="info" border="1">  
  
  <tr>    
  <th>Model</th> 
  
  <th>Ip Address*</th>  

  <th>Mac Address*</th>   

  <th>Software</th>    
  
  <th>Status</th>    
  
  <th>Note</th>   

  <th>Reserver</th> 
  
  <th>Add</th> 
  </tr>

  <tr>	

  <td>	
 
  <input class="info_box " id="model" list="phone_models" name="model" autocomplete="off" placeholder="Select a Model"/>
  <datalist id="phone_models" >
<% 
@SuppressWarnings("unchecked")
List<String> data= (List<String>) request.getAttribute("data");
for (int i=0;i<data.size();i++)
{
%>
<option  value="<%=data.get(i)%>" ></option>
<%}%>
  </datalist>
  
  </td>	

  
  <td>	
  <input class="info_box" type="text" name="ip" id="ip"/>
  </td>	
  
  <td>	
  <input class="info_box" type="text" name="mac" id="mac"/>
  </td>	
  
  <td><input class="info_box" type="text" name="software"/>
  </td>
  
  <td>	
   <select name="status">
   <option value="1">Working</option>
   <option value="2">Not Working</option>
   </select>
  </td>	

  
  <td>
  <input class="info_box" type="text" name="note"/>
  </td>

  <td>
  <input class="info_box" type="text" name="reserver"/>
  </td>  
  
    <td>
  <button type="submit" class="button" name="choice" value="PhoneAdded" onClick="return checkValidation(mac.value,ip.value,model.value);">
  
  <strong>Add</strong></button>
  </td>  
  

  </tr> 
 
  </table>  
  </form>
  </div>
  
   <hr/>
   <div class="button_position" style="margin-left:450px;">
   <form action="AdminMenu" method="post">
   <button type="submit" class="button" name="choice" value="AdminMenu"><strong>Return to Admin Menu</strong></button>
   </form>
   </div>

</div>
</body>
</html>