package csc440.csc.eastern;

import java.util.Random;

public class Env {

	private RoundRobin rr;
	private ReadyList rl;
	

	
		
	public Env(){
		rr = new RoundRobin();
		rl = new ReadyList();
	}
	
	public Env(RoundRobin rr, ReadyList rl) {
		this.rr = rr;
		this.rl = rl;
	}


	public static void main(String[] args) {
		
		Env env = new Env();
				
		for (int i = 0; i < 800; i++) {
			env.getRl().getList().add(new Process("P"+i));

		}
			
		
		
		env.getRl().setupList();
		

	}
	
	public void start(){
		this.getRl().run();
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
	
}
