package phone.inventory;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.apache.catalina.tribes.util.Arrays;

import phone.inventory.DatabaseConnector;

public class Database {
	
	private Connection connection;
	private Statement statement;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;
	private MessageDigest encrypter;
	public  int loopCount; 
	
	public Database(){
		try {
			connection = DatabaseConnector.getConnection();
			statement = connection.createStatement();
			encrypter = MessageDigest.getInstance("MD5");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}

   //  ******************************  QUERIES BY MAC ADDRESS  *********************************************************  //
   //start
   public String getModelByMac(String mac) throws SQLException {
	   String model=null;
	   resultSet = statement.executeQuery("SELECT model FROM phone_list WHERE mac='"+mac+"'");	
	   if (resultSet.next()){
		   model=resultSet.getString("model");
		   return model;
		   }
	   else return "this phone does not exist";
	   }
   public String getIpByMac(String mac) throws SQLException {
	   	String ip=null;
	   	resultSet = statement.executeQuery("SELECT ip FROM phone_list WHERE mac='"+mac+"'");	
	   	if (resultSet.next()){
	   		ip=resultSet.getString("ip");
	   	return ip;
	   	}
	   	else return "this phone does not exist";
	   }
   public String getNoteByMac(String mac) throws SQLException {
	   	String note=null;
	   	resultSet = statement.executeQuery("SELECT note FROM phone_list WHERE mac='"+mac+"'");	
	   	if (resultSet.next()){
	   		note=resultSet.getString("note");
	   	return note;
	   	}
	   	else return "this phone does not exist";
	   }
   public String getReserverByMac(String mac) throws SQLException {
	   	String reserver=null;
	   	resultSet = statement.executeQuery("SELECT reserver FROM phone_list WHERE mac='"+mac+"'");	
	   	if (resultSet.next()){
	   		reserver=resultSet.getString("reserver");
	   	return reserver;
	   	}
	   	else return "this phone does not exist";
	   }
   public String getSoftwareByMac(String mac) throws SQLException {
	   	String software=null;
	   	resultSet = statement.executeQuery("SELECT software FROM phone_list WHERE mac='"+mac+"'");	
	   	if (resultSet.next()){
	   		software=resultSet.getString("software");
	   	return software;
	   	}
	   	else return "this phone does not exist";	
	   }
   public int getStatusByMac(String mac) throws SQLException {
	   	int status=-1;
	   	resultSet = statement.executeQuery("SELECT status FROM phone_list WHERE mac='"+mac+"'");	
	   	if (resultSet.next()){
	   		status=resultSet.getInt("status");
	   	return status;
	   	}
	   	else return status;
	   	
	   }
   public int getReservedByMac(String mac) throws SQLException {
	  	int reserved=-1;
	  	resultSet = statement.executeQuery("SELECT reserved FROM phone_list WHERE mac='"+mac+"'");	
	  	if (resultSet.next())
	  		reserved=resultSet.getInt("reserved");
	  	return reserved;
	   }
   //end
   // *******************************  QUERIES BY IP ADDRESS   *********************************************************  //
   //start
   public String getMacByIp(String ipAddress) throws SQLException {
	   	String Mac=null;
	   	resultSet = statement.executeQuery("SELECT mac FROM phone_list WHERE ip='"+ipAddress+"'");	
	   	if (resultSet.next())
	   		Mac=resultSet.getString("mac");
	   	return Mac;
	  }	  
   public String getModelByIp(String ipAddress) throws SQLException {
	  	String Model=null;
	  	resultSet = statement.executeQuery("SELECT Model FROM phone_list WHERE ip='"+ipAddress+"'");	
	  	if (resultSet.next())
	  		Model=resultSet.getString("Model");
	  	return Model;
	  }			
   public String getNoteByIp(String ipAddress) throws SQLException {
	  	String note=null;
	  	resultSet = statement.executeQuery("SELECT note FROM phone_list WHERE ip='"+ipAddress+"'");	
	  	if (resultSet.next())
	  		note=resultSet.getString("note");
	  	return note;
	  }
   public String getReserverByIp(String ipAddress) throws SQLException {
	  	String reserver=null;
	  	resultSet = statement.executeQuery("SELECT reserver FROM phone_list WHERE ip='"+ipAddress+"'");	
	  	if (resultSet.next())
	  		reserver=resultSet.getString("reserver");
	  	return reserver;
	  }
   public String getSoftwareByIp(String ipAddress) throws SQLException {
	  	String software=null;
	  	resultSet = statement.executeQuery("SELECT software FROM phone_list WHERE ip='"+ipAddress+"'");	
	  	if (resultSet.next())
	  		software=resultSet.getString("software");
	  	return software;
	  }
   public int getStatusByIp(String ipAddress) throws SQLException {
	  	int status=-1;
	  	resultSet = statement.executeQuery("SELECT status FROM phone_list WHERE ip='"+ipAddress+"'");	
	  	if (resultSet.next())
	  		status=resultSet.getInt("status");
	  	return status;
	  }
   public int getReservedByIp(String ipAddress) throws SQLException {
	  	int reserved=-1;
	  	resultSet = statement.executeQuery("SELECT reserved FROM phone_list WHERE ip='"+ipAddress+"'");	
	  	if (resultSet.next())
	  		reserved=resultSet.getInt("reserved");
	  	return reserved;
	  }
   //end
   //  ******************************  RESERVER FUNCTIONS      *********************************************************  //
   //start
   public void setReservedByIp (String ipAddress,String reserved,String reserver) throws SQLException {
		statement.executeUpdate("update phone_list set reserver='"+reserver +"'   WHERE ip='" + ipAddress + "'");
		statement.executeUpdate("update phone_list set reserved='"+reserved +"'   WHERE ip='" + ipAddress + "'");
   }
   public void setReservedByMac(String mac,String reserved,String reserver) throws SQLException {
		statement.executeUpdate("update phone_list set reserver='"+reserver +"'   WHERE mac='" + mac + "'");
		statement.executeUpdate("update phone_list set reserved='"+reserved +"'   WHERE mac='" + mac + "'");
   }
   //end
   //  ******************************  UPDATE FUNCTIONS        *********************************************************  // 
   //start
   public void updateIpByMac(String mac,String ipAddress) throws SQLException {
		statement.executeUpdate("update phone_list set ip='"+ipAddress +"'  WHERE mac='" + mac + "'");
	} 
   public void updateStatusByMac(String mac,String status) throws SQLException {
		statement.executeUpdate("update phone_list set status='"+status +"'  WHERE mac='" + mac + "'");
	} 
   public void updateReserverByMac(String mac,String reserver) throws SQLException {
		statement.executeUpdate("update phone_list set reserver='"+reserver +"'  WHERE mac='" + mac + "'");
	} 
   public void updateNoteByMac(String mac,String note) throws SQLException {
		statement.executeUpdate("update phone_list set note='"+note +"'  WHERE mac='" + mac + "'");
	} 
   public void updateSoftwareByMac(String mac,String software) throws SQLException {
		statement.executeUpdate("update phone_list set software='"+software +"'  WHERE mac='" + mac + "'");
	}
   //end
   //  ******************************  ADD & DELETE FUNCTIONS  *********************************************************  // 
   //start
   public void deletePhone(String mac) throws SQLException {
		statement.executeUpdate("delete from phone_list where mac='"+mac+"'");
	} 
   public void addPhone(String model, String mac, String ipAddress, String software, String status, String note, String reserved, String reserver) throws SQLException {
		statement.executeUpdate("insert phone_list(model,mac,ip,software,status,note,reserved,reserver) "
				+ "values('"+model+"', '"+mac+"', '"+ipAddress+"',"
				+ " '"+software+"', '"+status+"', '"+note+"', '"+reserved+"','"+reserver+"') " );
	} 
   //end
   //  ******************************  GENERAL FUNCTIONS       *********************************************************  //
   //start
   public int checkIfReservedByMac(String mac) throws SQLException {
	   	int reserved=-1;
	   	resultSet = statement.executeQuery("SELECT status FROM phone_list WHERE mac='"+mac+"'");	
	   	if (resultSet.next()){
	   		reserved=resultSet.getInt("reserved");
	   	return reserved;
	   	}
	   	else return reserved;	   	
   } 
   public Boolean checkIp(String ipAddress) throws SQLException {
	    resultSet = statement.executeQuery("SELECT mac FROM phone_list WHERE ip='"+ipAddress+"'");
    	if (resultSet.next())
    		return true;
    	 return false;   
   }
   public List<String> getCrossingIpList(String ipAddress) throws SQLException {
	    resultSet = statement.executeQuery("SELECT * FROM phone_list WHERE ip='"+ipAddress+"'");
	    List<String> crossedIpList = new ArrayList<String>();
	    String tempMacs="";
	    int rowCount=0;
	    while(resultSet.next()){
	    	rowCount++;
	    	if(rowCount==1)
	    		tempMacs="&nbsp;"+resultSet.getString("mac");
	    	else
	    	tempMacs= tempMacs + "&nbsp; &nbsp; &nbsp;--&nbsp; &nbsp; &nbsp;"+resultSet.getString("mac");	
	    }
	    if(rowCount>1){
	    	crossedIpList.add(ipAddress);
	    	crossedIpList.add(tempMacs);
	    	return crossedIpList;
	    }
	    else return null;
	   
   }
   public Boolean checkMac(String mac) throws SQLException {
	   	
	    resultSet = statement.executeQuery("SELECT * FROM phone_list WHERE mac='"+mac+"'");	
   	if (resultSet.next())
   		return true;
   	 return false;
	   
   }  
   public List<String>  searchDatabase(String searchTerm) throws SQLException {
	   List<String> phoneList = new ArrayList<String>();
	   resultSet = statement.executeQuery("SELECT * FROM phone_list ORDER BY model ASC");
	   loopCount=0;
	   Boolean isFound;
		String mac;	
		while(resultSet.next()){
		   	 isFound = false;
		   	 loopCount++;
				if(!isFound && resultSet.getString("ip").toLowerCase().indexOf(searchTerm.toLowerCase()) != -1){
					isFound=true;
				    mac=resultSet.getString("mac");
				    phoneList.add(mac);
				}
				if(!isFound && resultSet.getString("mac").toLowerCase().indexOf(searchTerm.toLowerCase()) != -1){
					isFound=true;
				    mac=resultSet.getString("mac");
				    phoneList.add(mac);
				}
				if(!isFound && resultSet.getString("note").toLowerCase().indexOf(searchTerm.toLowerCase()) != -1){
					isFound=true;
				    mac=resultSet.getString("mac");
				    phoneList.add(mac);
				}
				if(!isFound && resultSet.getString("reserver").toLowerCase().indexOf(searchTerm.toLowerCase()) != -1){
					isFound=true;
				    mac=resultSet.getString("mac");
				    phoneList.add(mac);
				}
				if(!isFound && resultSet.getString("software").toLowerCase().indexOf(searchTerm.toLowerCase()) != -1){
					isFound=true;
				    mac=resultSet.getString("mac");
				    phoneList.add(mac);
				}
				if(!isFound && resultSet.getString("model").toLowerCase().indexOf(searchTerm.toLowerCase()) != -1){
					isFound=true;
				    mac=resultSet.getString("mac");
				    phoneList.add(mac);
				}
		}
		return phoneList;
   }
   public Phone createPhoneByMac(String mac) throws SQLException {
	   
	   Phone phone = new Phone();
	   
  		phone.model=this.getModelByMac(mac);
	   	
  		phone.mac=mac;
  		
  		phone.ip=this.getIpByMac(mac);
  		
  		phone.software=this.getSoftwareByMac(mac);
  		
  		phone.status=this.getStatusByMac(mac);
  	   	
  		phone.note=this.getNoteByMac(mac);
  	
  		phone.reserved=this.getReservedByMac(mac);

  		phone.reserver=this.getReserverByMac(mac);
	   
	   return phone;
   }
   public List<Phone> listByModelName(String modelName) throws SQLException {

	   List<Phone> phoneList = new ArrayList<Phone>();
	   
	   	resultSet = statement.executeQuery("SELECT * FROM phone_list WHERE model='"+modelName+"'");	
	   
	   	while(resultSet.next()){   		
	   		Phone phone = new Phone();
	   		phone = this.createPhoneByMac(resultSet.getString("mac"));	
	   		phoneList.add(phone);
	   		}
	   	
	   	    return phoneList;
   }
   public List<String> getModelList() throws SQLException {
	   List<String> modelList = new ArrayList<String>();
	   resultSet=statement.executeQuery("select * from model_list");
	   while(resultSet.next())
		   modelList.add(resultSet.getString("model"));
	   return modelList;
   }
   //end
   //  ******************************  ADMIN FUNCTIONS         *********************************************************  //
   //start
   public Boolean checkLogin(String userName, String password) throws SQLException, NoSuchAlgorithmException {
	   
	   resultSet = statement.executeQuery("SELECT password FROM admin WHERE user_name='"+userName+"'");
	   if(resultSet.next()){
		
			byte [] passwordAsByte = password.getBytes();
			byte [] encryptedPassword = encrypter.digest(passwordAsByte);
			 String passwordInDatabase = resultSet.getString("password");
			 
			   if(Arrays.toString(encryptedPassword).equals(passwordInDatabase) )
			   return true;	
			   else return false;
	   }else  return false;  
   }
   public Boolean createNewAdmin(String userName, String password) throws SQLException, NoSuchAlgorithmException{
	   resultSet = statement.executeQuery("SELECT user_name FROM admin WHERE user_name='"+userName+"'");
	   if(resultSet.next()){
	   return false;
	   } else{
		  
		   byte [] passwordAsByte = password.getBytes();
		   byte [] encryptedPassword = encrypter.digest(passwordAsByte);
		   preparedStatement=connection.prepareStatement("insert admin(user_name,password) values(?,?)");
		   preparedStatement.setString(1, userName);
		   preparedStatement.setString(2, Arrays.toString(encryptedPassword));
		   preparedStatement.executeUpdate();
		   return true;
				   
		   }
   }
   public Boolean setNewPassword(String userName, String oldPassword, String newPassword) throws SQLException, NoSuchAlgorithmException{
	   resultSet = statement.executeQuery("SELECT password FROM admin WHERE user_name='"+userName+"'");
	   if(resultSet.next()){
		
			byte [] oldPasswordAsByte = oldPassword.getBytes();
			byte [] oldEncryptedPassword = encrypter.digest(oldPasswordAsByte);
			 String passwordInDatabase = resultSet.getString("password");
			 
			   if(Arrays.toString(oldEncryptedPassword).equals(passwordInDatabase) ){
				   byte [] newPasswordAsByte = newPassword.getBytes();
				   byte [] newEncryptedPassword = encrypter.digest(newPasswordAsByte);
				   statement.executeUpdate("update admin set password='"+Arrays.toString(newEncryptedPassword)+"' "
				   		+ "where user_name='"+userName+"' ");
				   return true;   
			   }
			   else return false;
	   }else  return false;
   
   }
   public Boolean setNewUserName(String oldUserName,String newUserName, String password) throws SQLException, NoSuchAlgorithmException{
	   resultSet = statement.executeQuery("SELECT password FROM admin WHERE user_name='"+oldUserName+"'");
	   if(resultSet.next()){
		
			byte [] passwordAsByte = password.getBytes();
			byte [] encryptedPassword = encrypter.digest(passwordAsByte);
			 String passwordInDatabase = resultSet.getString("password");
			 
			   if(Arrays.toString(encryptedPassword).equals(passwordInDatabase) ){
				   statement.executeUpdate("update admin set user_name='"+newUserName+"' "
				   		+ "where user_name='"+oldUserName+"' ");
				   return true;   
			   }
			   else return false;
	   }else  return false;	      
   }
   public void addNewModel(String modelName) throws SQLException{
	   statement.executeUpdate("insert model_list (model) values('"+modelName+"')");
   }
   //end
}
