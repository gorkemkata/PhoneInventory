package phone.inventory;

public class Phone {
	
	public String mac;
	public String ip;
	public String model;
	public String note;
	public String reserver;
	public String software;
	
	public int reserved;
	public int status;
	
	public Phone(String model, String mac, String ip, String software, String reserver, String note, int status, int reserved){
		this.mac=mac;
		this.ip=ip;
		this.model=model;
		this.note=note;
		this.reserver=reserver;
		this.software=software;
		this.status=status;
		this.reserved=reserved;
		
	}
	
	public Phone(){}
	
	public String getMac() {
		return mac;
	}

	public void setMac(String mac) {
		this.mac = mac;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getReserver() {
		return reserver;
	}

	public void setReserver(String reserver) {
		this.reserver = reserver;
	}

	public String getSoftware() {
		return software;
	}

	public void setSoftware(String software) {
		this.software = software;
	}

	public int getReserved() {
		return reserved;
	}

	public void setReserved(int reserved) {
		this.reserved = reserved;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}


	public void notInDatabase(){
	    mac="??:??:??:??:??:??";
	    ip="xxx.xxx.xxx.xxx";
		model="Phone Not found";
		note="---";
	    reserver="---";
		software="---";	
	}
	
	public void clearNulls(){
		if(mac==null)
			mac="00:00:00:00:00:00";
		if(ip==null)
			ip="???.???.???.???";
		if(model==null)
			model="Was not stated";
		if(note==null)
			note="---";
		if(reserved==0)
			reserver="The phone is vacant";
		if(reserved==1 && reserver.equals("The phone is vacant"))
			reserver="The phone is reserved";
		if(reserver == null)
			reserver="Some User";
		if(software==null)
			software="Was not stated";
		if(reserved != 1)
			reserved=0;
		if(status != 1 && status !=0)
			status=-1;
		
	}
	

}
