package phone.inventory;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet({"/Lister"})
public class Lister
  extends HttpServlet
{
  private static final long serialVersionUID = 1L;
  
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
  {
    Database db = new Database();
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter printWriter = response.getWriter();
 
    String choice = request.getParameter("choice");
    if(choice == null)
    	choice="drop";
    String dropSearch = request.getParameter("drop_search");
    String isAdmin = request.getParameter("admin");
    
    if(dropSearch!=null || choice.equals("search") ){
    	
    	String searchTerm = request.getParameter("search_term");	
    	List<Phone> phoneList = new ArrayList<Phone>();
    	List<String> searchResults = new ArrayList<String>();
    	Phone phone = new Phone();
    	try {
    		searchResults = db.searchDatabase(searchTerm);
    		for(int i=0;i<searchResults.size();i++){
    			phone=db.createPhoneByMac(searchResults.get(i));
    			phoneList.add(phone);		
    		}
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	
          int phoneCountForContainer = phoneList.size();      		
          if (phoneCountForContainer <= 3) 
            phoneCountForContainer = 4;
          
          int containerHeight = phoneCountForContainer * 142 + 150;
          
          printWriter.println(
            " <!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\"> "+
            " <html xmlns=\"http://www.w3.org/1999/xhtml\"> <head> <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />"+
            " <title>Phone Inventory</title> <link href=\"lister_style.css\" rel=\"stylesheet\" type=\"text/css\" /> </head>"+
            " <body> <div id=\"container\" style=\"height:"+containerHeight+"px; \">" +
            " <div id=\"header\">"+
            " <div id=\"logo\"><img src=\"images/icterra.png\" alt=\"image not found\" width=\"193\" height=\"60\" /></div>"+
            " </div>" +
            " <div id=\"clear-header\"></div>"+
            " <p style=\"margin-bottom:10px;\">"+
            " <font size=\"4\"><strong>NOTE: If a phone is red framed it means that it is reserved by someone. Please be assured that the phone is free before changing anything on it!</strong>"+
            " </font>"+
            " </p>"+
            " <hr/>"+
            "  ");

          if (phoneList.size() == 0) {
            printWriter.println("There are no phones that match with your search");
          }
          for (int i = 0; i < phoneList.size(); i++)
          {
        	  printWriter.println(getListHtml(phoneList.get(i),i,dropSearch,isAdmin));
          }
          printWriter.println(
          	     " <script src=\"http://code.jquery.com/jquery-1.10.2.min.js\"></script> "+
          	    	      
          	    	     " <script type=\"text/javascript\"> "+
          	    	     " function ping(formRow){"+
          	    	     " var form = formRow "+
                         "  form.click(function () { "+
          	    	     "  $.ajax({ "+
          	    	     " type: form.attr('method'), "+
          	    	     " url: 'Ping', "+
          	    	     " data: form.serialize(), "+
          	    	     " success: function (data) { "+
          	    	     " var result=data; "+
          	    	     " $('#ping0').html(result); "+
          	    	     " } "+
          	    	     " }); "+
          	    	     " return false; "+
          	    	     "  )}; };"+
          	    	     " </script> "+
                         " <script LANGUAGE=\"JavaScript\">   "+
                         " function confirmReserve(check,reserver)   "+
                         " {   "+
                         " if(check==1){   "+
                         " var agree=confirm(\"This phone is already reserved by \\\"\"+reserver+\"\\\". Please be sure that he or she is not using this phone right now. "+
                         " Nonetheless you can still reserve this phone. Clik Ok to Reserve or Cancel to abort.\");  "+
                         " if (agree)   "+
                         " return true ;   "+
                         " else   "+
                         " return false ;   "+
                         " }   "+
                         " else "+
                         " return true;"+
                         " }   "+
                         " </script>   "+
                         "</div></body></html>");	
    }
   
    if ((choice.equals("multiple")) || (choice.equals("low")) || (choice.equals("high"))) {
      try
      {
        List<Phone> phoneList = new ArrayList<Phone>();
        List<String> selectedModels = new ArrayList<String>();
        if (choice.equals("multiple"))
        {
          if (request.getParameter("openstage15") != null) {
            selectedModels.add(request.getParameter("openstage15"));
          }
          if (request.getParameter("openstage20") != null) {
            selectedModels.add(request.getParameter("openstage20"));
          }
          if (request.getParameter("openstage40") != null) {
            selectedModels.add(request.getParameter("openstage40"));
          }
          if (request.getParameter("openstage60") != null) {
            selectedModels.add(request.getParameter("openstage60"));
          }
          if (request.getParameter("openstage80") != null) {
            selectedModels.add(request.getParameter("openstage80"));
          }
          if (request.getParameter("we2-t26-1") != null) {
            selectedModels.add(request.getParameter("we2-t26-1"));
          }
          if (request.getParameter("we2-t28") != null) {
            selectedModels.add(request.getParameter("we2-t28"));
          }
          if (request.getParameter("we2-t40") != null) {
            selectedModels.add(request.getParameter("we2-t40"));
          }
        }
        if (choice.equals("low"))
        {
          selectedModels.add("openstage15");
          selectedModels.add("openstage20");
          selectedModels.add("openstage40");
        }
        if (choice.equals("high"))
        {
          selectedModels.add("openstage60");
          selectedModels.add("openstage80");
        }
        
        String showWorking = request.getParameter("show_working");
        String showFree = request.getParameter("show_free");
        
        for (int i = 0; i < selectedModels.size(); i++) {
          phoneList.addAll(db.listByModelName(selectedModels.get(i)));
        }
        
        int phoneCountForContainer = phoneList.size() + 1;
        
        if(showWorking != null || showFree != null){
        	for(int i=0;i<phoneList.size();i++){
        		if((phoneList.get(i).status != 1 && showWorking != null)
        				|| (phoneList.get(i).reserved != 0 && showFree != null) )
        			phoneCountForContainer--;
        		}
        	}		
        		
        if (phoneCountForContainer <= 3) 
          phoneCountForContainer = 4;
        
        int containerHeight = phoneCountForContainer * 155 + 150;
        
        printWriter.println(
                " <!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\"> "+
                " <html xmlns=\"http://www.w3.org/1999/xhtml\"> <head> <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />"+
                " <title>Phone Inventory</title> <link href=\"lister_style.css\" rel=\"stylesheet\" type=\"text/css\" /> </head>"+
                " <body> <div id=\"container\" style=\"height:"+containerHeight+"px; \">" +
                " <div id=\"header\">"+
                " <div id=\"logo\"><img src=\"images/icterra.png\" alt=\"image not found\" width=\"193\" height=\"60\" /></div>"+
                " </div>" +
                " <div id=\"clear-header\"></div>"+
                " <div style=\" padding:5px; width:700px; height:45px; border:2px solid #E00; margin-bottom:20px;\""+
                " <p>"+
                " <font size=\"4\"><strong>NOTE: If a phone is red framed it means that it is reserved by someone. Please be assured that the phone is free before changing anything on it!</strong>"+
                " </font>"+
                " </p>"+
                "</div>"+
                " <hr/>"+
                "  ");
        if (phoneList.size() == 0) {
          printWriter.println("NO PHONES SELECTED");
        }
        for (int i = 0; i < phoneList.size(); i++)
        {
          if ((showWorking != null) && (showFree != null)) {
        	  if( phoneList.get(i).status > 0 && phoneList.get(i).reserved == 0 )
            printWriter.println(getListHtml(phoneList.get(i),i,null,isAdmin));
          }
          
          if(showWorking != null && showFree == null){
        	  if( phoneList.get(i).status > 0)
                  printWriter.println(getListHtml(phoneList.get(i),i,null,isAdmin));
          }
          if(showWorking == null && showFree != null){
        	  if(phoneList.get(i).reserved == 0 )
                  printWriter.println(getListHtml(phoneList.get(i),i,null,isAdmin));
          }
          if (showWorking == null && showFree == null) {
            printWriter.println(getListHtml(phoneList.get(i),i,null,isAdmin));
          }
        }
        printWriter.println(
        		
        	     " <script src=\"http://code.jquery.com/jquery-1.10.2.min.js\"></script> "+
        	    	      
        	    	     " <script type=\"text/javascript\"> "+
        	    	     " function ping(formRow){"+
        	    	     " var form = formRow "+
                         "  form.click(function () {                   "+
        	    	     "  $.ajax({ "+
        	    	     " type: form.attr('method'), "+
        	    	     " url: 'Ping', "+
        	    	     " data: form.serialize(), "+
        	    	     " success: function (data) { "+
        	    	     " var result=data; "+
        	    	     " $('#ping0').html(result); "+
        	    	     " } "+
        	    	     " }); "+

        	    	     " return false; "+
        	    	     "  )}; };"+
        	    	     " </script> "+
        	    	     
                       " <script LANGUAGE=\"JavaScript\">   "+
                       " function confirmReserve(check,reserver)   "+
                       " {   "+
                       " if(check==1){   "+
                       " var agree=confirm(\"This phone is already reserved by \\\"\"+reserver+\"\\\". Please be sure that he or she is not using this phone right now. "+
                       " Nonetheless you can still reserve this phone. Clik Ok to Reserve or Cancel to abort.\");  "+
                       " if (agree)   "+
                       " return true ;   "+
                       " else   "+
                       " return false ;   "+
                       " }   "+
                       " else "+
                       " return true;"+
                       " }   "+
                       " </script>   "+
        	    	     
        	    	     
          
          "</div></body></html>");
      }
      catch (SQLException e)
      {
        e.printStackTrace();
      }
    }
  }
  private String getListHtml(Phone phone, int rowNumber, String dropSearch, String isAdmin){
    phone.clearNulls();
    String dropdown1;
    String dropdown1Value;
    String dropdown2;
    String dropdown2Value;
    
    String isReservedBorder="";
    String isReservedText="";
    
    if(phone.reserved == 1){
    	isReservedBorder="style=\"border:2px solid #F00;\"";
        isReservedText="style=\"color:#F00;\"";
    }
    
    if (phone.status > 0){
    	dropdown1 = "Working";
    	dropdown1Value = "1";
    	dropdown2 = "Not Working";
    	dropdown2Value = "0";
    }
    else{
    	dropdown1 = "Not Working";
    	dropdown1Value = "0";
    	dropdown2 = "Working";
    	dropdown2Value = "1";
    }
    
    String htmlList = 
    
      " <div id=\"table_container\" "+isReservedBorder+"> "+
      " <p style=\"float:left; margin-left:10px; margin-right:10px;  margin-top:50px;  \">"+(rowNumber+1)+".</p> "+
      " <div id=\"phone_image\" > <a href=\"PhoneInventory\"> "+
      "<img src=\"images/" + 
      phone.model.toLowerCase() + ".png\" width=\"72\" height=\"49\"  border=\"0\" alt=\"image not found\" style=\"padding-bottom:0.5em; \" /></a> " + 
      phone.model + "</div>" + 
      " <table id=\"info_table\" border=\"1\">" +  
      "  <tr>" + 
      "    <th>Ip Address</th>" + 
      "    <th>Mac Address</th>" + 
      "    <th>Software</th>" + 
      "    <th>Status</th>" + 
      "    <th>Note</th>" + 
      "    <th>Reserver</th>" + 
      "    <th>-</th>" + 
      "    <th>-</th>" + 
      "    <th>-</th>" + 
      "  </tr>" + 
      "  <tr>" + 
      "  <form action=\"PhoneUpdate\" method=\"post\">" +
      "  <td>" + 
      "  <input id=\"info_box\" type=\"text\" name=\"ipAddress\" value=\"" + 
      phone.ip + 
      "\">" + 
      "  </td>" + 
      "  <td>" + 
      "  <input id=\"info_box\" readonly type=\"text\" name=\"mac\" value=\"" + 
      phone.mac + 
      "\">" + 
      "  </td>" + 
      "  <td>" +  
      "  <input id=\"info_box\" type=\"text\" name=\"software\" value=\"" + 
      phone.software + 
      "\">" + 
      "  </td>" + 
      "  <td>" + 
      "   <select name=\"status\">" + 
      "   <option value=\"" + dropdown1Value + "\">" + dropdown1 + "</option>" + 
      "   <option value=\"" + dropdown2Value + "\">" + dropdown2 + "</option>" + 
      "    </select>" + 
      "  </td>" + 
      "  <td>" + 
      "  <input id=\"info_box\" type=\"text\" name=\"note\" value=\"" + 
      phone.note + 
      "\">" + 
      "  </td>" + 
      "  <td>" + 
      "  <input id=\"info_box\" type=\"text\" "+isReservedText+" name=\"reserver\" value=\"" + 
      phone.reserver + 
      "\">" + 
      "  </td>" + 
      "  <td>" + 
      "   <button type=\"submit\"class=\"button\" name=\"update_phone\" value=\"" + phone.mac + "\"><strong>Update</strong></button>" +   
      "  </td>" + 
      "<td>" + 
      "<button type=\"submit\" class=\"button\" name=\"reserve\" OnClick=\"return confirmReserve("+phone.reserved+",'"+phone.reserver+"');\" value=\"true\"><strong>Reserve</strong></button>" + 
      "</td>" +
      " </form>" + 
      "  <td>" ;
     if(dropSearch == null && isAdmin == null){
    	 htmlList = htmlList + 
      "   <form id=\"row"+rowNumber+"\" name=\""+rowNumber+"\" action=\"Ping\" method=\"post\">  "+
      "<button class=\"button\" id=\""+rowNumber+"\"  onclick=\"ping(document.getElementById(\"row"+rowNumber+"\"))\" >   <strong>Ping</strong></button>" + 
      " <input type=\"hidden\" name=\"ipaddress\" value=\""+phone.ip+"\" />"+
      "   </form>  "+
      " <div id=\"ping"+rowNumber+"\">"+
      "  </div>"+
      "  </td>"+
      "  </tr>"+ 
      "  </table>"+ 
      "  <div id=\"clear-content\"></div>" + 
      "  </div>"+
      "  <hr style=\"color:#c00;background-color:silver ;height:4px; border: 1px solid #CCC; border-radius:15px;\" />";	 
     } else if(dropSearch != null){
    	 htmlList = htmlList + 	 
    	"  <form action=\"PhoneDropper\" method=\"post\">  "+
        "  <button type=\"submit\" class=\"button\" name=\"drop\" value=\"mac\"><strong>Drop</strong></button> "+
    	"  <input type=\"hidden\" name=\"mac\" value=\""+phone.mac+"\" />"+
        "  </form>  "+		 
         " </td>" +
         " </tr>" +       
         " </table>" +    	      
         " <div id=\"clear-content\"></div>" + 	      
         " </div>"+
         "  <hr style=\"color:#c00;background-color:silver ;height:4px; border: 1px solid #CCC; border-radius:15px;\" />"; 
     }else if(isAdmin != null){
    	 
    	 htmlList = htmlList + 
    			 
    	 "  <form action=\"AdminMenu\" method=\"post\">  "+
         "  <button type=\"submit\" class=\"button\" name=\"choice\" value=\"PhoneDeleted\"><strong>Delete</strong></button> "+
    	 "  <input type=\"hidden\" name=\"mac\" value=\""+phone.mac+"\" />"+
         "  </form>  "+
         "  </td>" +
         "  </tr>" +
         "  </table>" +
         "  <div id=\"clear-content\"></div>" +
         "  </div>"+
         "  <hr style=\"color:#c00;background-color:silver ;height:4px; border: 1px solid #CCC; border-radius:15px;\" />";
    	 }
    return htmlList;
  }
}
