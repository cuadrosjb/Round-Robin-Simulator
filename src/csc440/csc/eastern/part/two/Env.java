package csc440.csc.eastern.part.two;

import csc440.csc.eastern.Process;

public class Env {

	private TwoRoundRobin rr;
	private TwoReadyList rl;

	public Env() {
		rr = new TwoRoundRobin();
		rl = new TwoReadyList(3);
	}

	public Env(TwoRoundRobin rr, TwoReadyList rl) {
		this.rr = rr;
		this.rl = rl;
	}

	public static void main(String[] args) {

		
		
		
		
		Env env = new Env();
		
		
		env.getRl().getList().add(new Process("P1",70,0));
		env.getRl().getList().add(new Process("P2",40,10));
		env.getRl().getList().add(new Process("P3",25,15));
		env.getRl().getList().add(new Process("P4",20,80));
		env.getRl().getList().add(new Process("P5",45,90));

		env.getRl().run();

//		for (int i = 0; i < 1000; i++) {
//			env.getRl().getList().add(new Process("P" + i));
//
//		}
//
//		env.getRl().setupList();

	}

	public void start() {
		this.getRl().run();
	}

	public TwoRoundRobin getRr() {
		return rr;
	}

	public void setRr(TwoRoundRobin rr) {
		this.rr = rr;
	}

	public TwoReadyList getRl() {
		return rl;
	}

	public void setRl(TwoReadyList rl) {
		this.rl = rl;
	}

}
