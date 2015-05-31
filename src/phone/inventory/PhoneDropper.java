package phone.inventory;

import java.io.IOException;

import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/PhoneDropper")
public class PhoneDropper extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String dropBy = request.getParameter("drop");
		Phone phone = new Phone();
		Database db = new Database();
		
		String ipAddress = request.getParameter("drop_ip");
		
		String mac1 = request.getParameter("mac1");
		String mac2 = request.getParameter("mac2");
		String mac3 = request.getParameter("mac3");
		String mac4 = request.getParameter("mac4");
		String mac5 = request.getParameter("mac5");
		String mac6 = request.getParameter("mac6");
       
		
		String mac;
		 if( request.getParameter("mac") != null)
			 mac=request.getParameter("mac");
		 else
			 mac = mac1 + ":" + mac2 +":" + mac3 +":" + mac4 +":" + mac5 +":" + mac6;
		 
		try {						
		if(dropBy.equals("mac")){
				phone.ip=db.getIpByMac(mac);
				phone.model=db.getModelByMac(mac);
				phone.note=db.getNoteByMac(mac);
				phone.status=db.getStatusByMac(mac);
				phone.reserver=db.getReserverByMac(mac);
				phone.reserved=db.getReservedByMac(mac);
				phone.mac=mac;
				phone.clearNulls();
		}	
		if(dropBy.equals("ip")){
				phone.mac=db.getMacByIp(ipAddress);
				phone.model=db.getModelByIp(ipAddress);
				phone.note=db.getNoteByIp(ipAddress);
				phone.status=db.getStatusByIp(ipAddress);
				phone.reserver=db.getReserverByIp(ipAddress);
				phone.reserved=db.getReservedByIp(ipAddress);
				phone.ip=ipAddress;
				phone.clearNulls();
		}	

			} catch (SQLException e) {
				e.printStackTrace();
			}		
		if(phone.ip.equals("this phone does not exist") || phone.mac.equals("this phone does not exist") ){
			phone.notInDatabase();
			request.setAttribute("phone", phone);
			request.setAttribute("imageUri", "images/"+phone.model.toLowerCase()+".png");
			
		}else{
		phone.reserved=0;
		try {
			db.setReservedByMac(phone.mac, "0", phone.reserver);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		phone.reserver="The phone is vacant";
		request.setAttribute("phone", phone);
		request.setAttribute("imageUri", "images/"+phone.model.toLowerCase()+".png");
		}
        request.getRequestDispatcher("/WEB-INF/PhoneDropper.jsp").forward(request, response);

	}
}
