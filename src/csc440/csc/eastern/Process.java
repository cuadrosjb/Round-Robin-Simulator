package csc440.csc.eastern;

public class Process {
	
	private String id;
	private int serviceTime;
	private int arrivalTime;
	
	private int remaindingServTime;
	
	private int startTime;
	private int endTime;
	private int turnaroundTime;
	
	private int initialWaitTime;
	private int totalWaitTime;
	
	
	public Process(){
		remaindingServTime = serviceTime;
	}
	
	public Process(int serviceTime, int  arrivalTime){
		this.serviceTime = serviceTime;
		this.remaindingServTime = serviceTime;
		this.arrivalTime = arrivalTime;
	}
	
	public Process(String id, int serviceTime, int  arrivalTime){
		this.id = id;
		this.serviceTime = serviceTime;
		this.remaindingServTime = serviceTime;
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

	public int getRemaindingServTime() {
		return remaindingServTime;
	}

	public void setRemaindingServTime(int remaindingServTime) {
		this.remaindingServTime = remaindingServTime;
	}
	
	

	public int getStartTime() {
		return startTime;
	}

	public void setStartTime(int startTime) {
		this.startTime = startTime;
	}

	public int getTurnaroundTime() {
		return turnaroundTime;
	}

	public void setTurnaroundTime(int turnaroundTime) {
		this.turnaroundTime = turnaroundTime;
	}

	public int getEndTime() {
		return endTime;
	}

	public void setEndTime(int endTime) {
		this.endTime = endTime;
		
		turnaroundTime = this.endTime - this.arrivalTime;
		
		initialWaitTime = startTime - arrivalTime;
		
		totalWaitTime = this.endTime - serviceTime - initialWaitTime;
		
		
	}
	
	
	

	public int getInitialWaitTime() {
		return initialWaitTime;
	}

	public void setInitialWaitTime(int initialWaitTime) {
		this.initialWaitTime = initialWaitTime;
	}

	public int getTotalWaitTime() {
		return totalWaitTime;
	}

	public void setTotalWaitTime(int totalWaitTime) {
		this.totalWaitTime = totalWaitTime;
	}

	@Override
	public String toString() {
		return "Process \r\tId:" + id + "\r\tServiceTime:" + serviceTime + "\r\tArrival Time:" + arrivalTime
				+ "\r\tStart Time:" + startTime + "\r\tEnd Time:" + endTime
				+ "\r\tTurn Around Time:" + turnaroundTime + "\r\tInitial Wait Time:" + initialWaitTime + "\r\tTotal Wait Time:"
				+ totalWaitTime;
	}


	

	
	
}
