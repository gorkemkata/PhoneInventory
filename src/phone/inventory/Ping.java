package phone.inventory;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Ping")
public class Ping extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		String ipAddress = request.getParameter("ipaddress");
		PrintWriter printWriter = response.getWriter();
		
		try{		
		  InetAddress pingAddress = InetAddress.getByName(ipAddress);		    
		    if(pingAddress.isReachable(3000))
		    printWriter.println("<br/>"+ipAddress+" is Reachable<br/>");
		    else
		    	printWriter.println("<br/>"+ipAddress+" is not Reachable<br/>");	    	
			}catch(Exception e){
				e.printStackTrace();
			}

	}

}
