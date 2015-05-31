package phone.inventory;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AdminMenu")
public class AdminMenu extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String choice = request.getParameter("choice");
		request.setAttribute("user", request.getParameter("user"));
		
		if(choice.equals("PhoneAdd")){
		Database db = new Database();
		List<String> list;
		try {
			list = db.getModelList();
			request.setAttribute("data", list);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		}
		else
		if(choice.equals("PhoneAdded")){
			Database db = new Database();
			String model = request.getParameter("model");
			String mac = request.getParameter("mac");
			String ipAddress = request.getParameter("ip");
			String software = request.getParameter("software");
			String note = request.getParameter("note");
			String reserver = request.getParameter("reserver");
			String status = request.getParameter("status");
			Phone phone = new Phone(model,mac,ipAddress,software,reserver,note,Integer.parseInt(status),0);
			String message = "Phone is saved to database";
			try {
				if(!db.checkMac(mac))
				db.addPhone(model, mac, ipAddress, software, status, note, "0", reserver);
				else{
					message = "THIS PHONE ALREADY EXISTS";
				}
				request.setAttribute("message",message);
				request.setAttribute("phone", phone);
				request.setAttribute("imageUri", "images/"+phone.model.toLowerCase()+".png");
			} catch (SQLException e) {
				e.printStackTrace();
			}			
		}
		else
		if(choice.equals("PhoneDeleted")){
			String mac = request.getParameter("mac");
			Database db = new Database();
			Phone phone = new Phone();
			String message = "This phone is successfully deleted from database!";
			try {
				phone = db.createPhoneByMac(mac);
				db.deletePhone(mac);
				request.setAttribute("phone", phone);
				request.setAttribute("message", message);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		 }
		else
		if(choice.equals("IpListCross")){
			Database db = new Database();
			List<String> crossedIpList = new ArrayList<String>();
			List<String> tempList = new ArrayList<String>();
			String ipAddress;
			for(int i=1;i<255;i++){
				try {
					ipAddress="192.168.2."+i;
					tempList = db.getCrossingIpList(ipAddress);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				if(tempList != null)
					crossedIpList.addAll(tempList);
			}
			if(crossedIpList != null){
				request.setAttribute("list", crossedIpList);
				request.setAttribute("message", "Showing crossing Ip Adresses:");
			}
		}
		else
	    if(choice.equals("IpListFree")){
			Database db = new Database();
			List<String> freeIpList = new ArrayList<String>();
			String ipAddress;
			for(int i=10;i<100;i++){
				try {
					ipAddress="192.168.2."+i;
					if(!db.checkIp(ipAddress))
						freeIpList.add(ipAddress);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			request.setAttribute("list", freeIpList);
			request.setAttribute("message", "Showing free Ip Adresses between 192.168.2.10 and 192.168.2.99");
	    }
		else
		if(choice.equals("AdminChange")){
			String change = request.getParameter("change");
			String userName = request.getParameter("user");
			request.setAttribute("user", userName);
			if(change.equals("user")){
				request.setAttribute("message1", "Enter your password:");
				request.setAttribute("message2", "Enter new Admin user name:");
				request.setAttribute("inputType", "text");
				request.setAttribute("placeholder1", "Old Password");
				request.setAttribute("placeholder2", "New Admin User Name");
				request.setAttribute("changed", "user");
				}
			if(change.equals("password")){
				request.setAttribute("message1", "Enter your old password:");
				request.setAttribute("message2", "Enter new Admin password");
				request.setAttribute("inputType", "password");
				request.setAttribute("placeholder1", "Old Password");
				request.setAttribute("placeholder2", "New Password");
				request.setAttribute("changed", "password");
			    }			
		}
		else
		if(choice.equals("AdminChanged")){
			String userName = request.getParameter("user");
			String changed = request.getParameter("changed");
			String oldPassword = request.getParameter("oldPassword");
			String newValue = request.getParameter("newValue");
			String message = "Entered Wrong Password!";
			Database db = new Database();
			
			try {
				if(db.checkLogin(userName, oldPassword)){
					if(changed.equals("password")){
						message = "Password Changed";
						db.setNewPassword(userName, oldPassword, newValue);
					}else
					if(changed.equals("user")){
						request.setAttribute("user", newValue);
						message = "Admin User Name Changed";
						db.setNewUserName(userName, newValue, oldPassword);
					}
				}
				request.setAttribute("message", message);
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
			
			
		}
		
		
		request.getRequestDispatcher("/WEB-INF/"+choice+".jsp").forward(request, response);
	}

}
