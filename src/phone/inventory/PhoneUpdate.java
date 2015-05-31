package phone.inventory;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/PhoneUpdate")
public class PhoneUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String updatePhone = request.getParameter("update_phone");	
		String reservePhone = request.getParameter("reserve");
		String mac = request.getParameter("mac");
		String ipAddress = request.getParameter("ipAddress");
		String note = request.getParameter("note");
		String software = request.getParameter("software");
		String reserver = request.getParameter("reserver");
		String status = request.getParameter("status");
		
		Phone oldPhone = new Phone();
		Phone newPhone = new Phone();
		
		newPhone.ip=ipAddress;
		newPhone.mac=mac;
		newPhone.note=note;
		newPhone.software=software;
		newPhone.reserver=reserver;
		newPhone.status=Integer.parseInt(status);
		
		String dropdown1New;
		String dropdown1ValueNew;
		String dropdown2New;
		String dropdown2ValueNew;
		
	    if(newPhone.status>0){
	    	dropdown1New="Working";
	    	dropdown1ValueNew="1";
	    	dropdown2New="Not Working";
	    	dropdown2ValueNew="0";
	    }
	    else{
	    	dropdown1New="Not Working";
	    	dropdown1ValueNew="0";
	    	dropdown2New="Working";
	    	dropdown2ValueNew="1";
	    }
		
		Database db = new Database();
		try {
			oldPhone.ip=db.getIpByMac(mac);
			oldPhone.mac=mac;
			oldPhone.note=db.getNoteByMac(mac);
			oldPhone.software=db.getSoftwareByMac(mac);
			oldPhone.reserver=db.getReserverByMac(mac);
			oldPhone.status=db.getStatusByMac(mac);
			oldPhone.model=db.getModelByMac(mac);
			
	
			db.updateIpByMac(mac, ipAddress);
			db.updateNoteByMac(mac, note);
			db.updateReserverByMac(mac, reserver);
			db.updateSoftwareByMac(mac, software);
			db.updateStatusByMac(mac, status);
			if(reservePhone != null)
				db.setReservedByMac(mac, "1", reserver);
			newPhone.reserved=db.getReservedByMac(mac);		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		String dropdown1Old;
		String dropdown1ValueOld;
		String dropdown2Old;
		String dropdown2ValueOld;
	    if(oldPhone.status>0){
	    	dropdown1Old="Working";
	    	dropdown1ValueOld="1";
	    	dropdown2Old="Not Working";
	    	dropdown2ValueOld="0";
	    }
	    else{
	    	dropdown1Old="Not Working";
	    	dropdown1ValueOld="0";
	    	dropdown2Old="Working";
	    	dropdown2ValueOld="1";
	    }
	    String message = "";
		if(oldPhone.reserver.equals(newPhone.reserver))
			message = "Please consider entering your name to the \"Reserver\" cell! ";
	
		request.setAttribute("oldPhone", oldPhone);
		request.setAttribute("newPhone", newPhone);
		request.setAttribute("message", message);
		
		request.setAttribute("dp1n", dropdown1New);
		request.setAttribute("dp1ValueNew", dropdown1ValueNew);
		request.setAttribute("dp2n", dropdown2New);
		request.setAttribute("dp2ValueNew", dropdown2ValueNew);
		
		request.setAttribute("dp1o", dropdown1Old);
		request.setAttribute("dp1ValueOld", dropdown1ValueOld);
		request.setAttribute("dp2o", dropdown2Old);
		request.setAttribute("dp2ValueOld", dropdown2ValueOld);
		
    	request.setAttribute("imageUri", "images/"+oldPhone.model.toLowerCase()+".png");
		response.setCharacterEncoding("UTF-8");
		if(reservePhone != null)
		request.getRequestDispatcher("/WEB-INF/PhoneReserver.jsp").forward(request, response);
		if(updatePhone != null)
		request.getRequestDispatcher("/WEB-INF/PhoneUpdater.jsp").forward(request, response);

	}
}
