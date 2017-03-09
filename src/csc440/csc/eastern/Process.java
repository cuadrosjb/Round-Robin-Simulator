package csc440.csc.eastern;

public class Process {
	
	private String id;
	private int serviceTime;
	private int arrivalTime;
	
	public Process(){
		
	}
	
	public Process(int serviceTime, int  arrivalTime){
		this.serviceTime = serviceTime;
		this.arrivalTime = arrivalTime;
	}
	
	public Process(String id, int serviceTime, int  arrivalTime){
		this.id = id;
		this.serviceTime = serviceTime;
		this.arrivalTime = arrivalTime;
	}
	
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getServiceTime() {
		return serviceTime;
	}

	public void setServiceTime(int serviceTime) {
		this.serviceTime = serviceTime;
	}

	public int getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(int arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	

}