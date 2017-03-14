package csc440.csc.eastern;

import java.util.Calendar;

public class Environment {

	private RoundRobin rr;
	private ReadyList rl;
	
	private static int startTime;
	private static int endTime;
	
		
	public Environment(){
		rr = new RoundRobin();
		rl = new ReadyList();
	}
	
	public Environment(RoundRobin rr, ReadyList rl) {
		this.rr = rr;
		this.rl = rl;
	}


	public static void main(String[] args) {
		
		Environment env = new Environment();
				
		env.getRl().getList().add(new Process(70,0));
		env.getRl().getList().add(new Process(40,10));
		env.getRl().getList().add(new Process(25,15));
		env.getRl().getList().add(new Process(20,80));
		env.getRl().getList().add(new Process(45,90));
		
		env.startTimer();
		
		env.start();
		
		env.endTimer();
		
		env.print();

	}
	
	public void print(){
		System.out.println("It took: " + (endTime - startTime) + " MilliSeconds" );
	}
	
	public void start(){
		this.getRl().run();
	}
	
	public void startTimer(){
		startTime = Calendar.getInstance().get(Calendar.MILLISECOND);
	}
	
	public void endTimer(){
		endTime = Calendar.getInstance().get(Calendar.MILLISECOND);
	}

	public RoundRobin getRr() {
		return rr;
	}

	public void setRr(RoundRobin rr) {
		this.rr = rr;
	}

	public ReadyList getRl() {
		return rl;
	}

	public void setRl(ReadyList rl) {
		this.rl = rl;
	}

	public static int getStartTime() {
		return startTime;
	}

	public static void setStartTime(int startTime) {
		Environment.startTime = startTime;
	}

	public static int getEndTime() {
		return endTime;
	}

	public static void setEndTime(int endTime) {
		Environment.endTime = endTime;
	}
	
}
