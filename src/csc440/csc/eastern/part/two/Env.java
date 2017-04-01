package csc440.csc.eastern.part.two;

import csc440.csc.eastern.Process;

/**
 * @author Jeffrey Cuadros
 * 
 * Env class is an entry point to start the TwoReadyList
 *
 */
public class Env {

	private TwoReadyList rl;
	String stopAtProcess = "P5";

	/**
	 * Env empty constructor
	 */
	public Env() {
		rl = new TwoReadyList(1);
	}

	/**
	 * Env constructor that sets the quantum
	 * 
	 * @param quantum Size of the quantum
	 */
	public Env(int quantum, String stopAtProcess) {
		rl = new TwoReadyList(quantum, stopAtProcess);
	}
	public Env(int quantum) {
		rl = new TwoReadyList(quantum);
	}

	/**
	 * Env constructor that sets the rl object
	 * 
	 * @param rl passes a ready list to the Env class
	 */
	public Env(TwoReadyList rl) {
		this.rl = rl;
	}

	/*
	 * 
	 * Initial class which helps sets up the process for the ready list class
	 * 
	 */

	public static void main(String[] args) {

		 System.out.println("TEST CASE 1|| Quantum 1");
		
		 Env env = new Env(1);
		
		 env.getRl().getList().add(new Process("P1", 75, 0));
		 env.getRl().getList().add(new Process("P2", 40, 10));
		 env.getRl().getList().add(new Process("P3", 25, 15));
		 env.getRl().getList().add(new Process("P4", 20, 80));
		 env.getRl().getList().add(new Process("P5", 45, 90));
		
		 env.getRl().run();
		 System.out.println("---------------------------------------------");
		 System.out.println("TEST CASE 1|| Quantum 3");
		
		 env = new Env(3);
		
		 env.getRl().getList().add(new Process("P1", 70, 0));
		 env.getRl().getList().add(new Process("P2", 40, 10));
		 env.getRl().getList().add(new Process("P3", 25, 15));
		 env.getRl().getList().add(new Process("P4", 20, 80));
		 env.getRl().getList().add(new Process("P5", 45, 90));
		
		 env.getRl().run();
		 System.out.println("---------------------------------------------");
		
		 System.out.println("TEST CASE 3|| Quantum 1");
		
		 env = new Env(1);
		
		 env.getRl().getList().add(new Process("P1", 75, 0));
		 env.getRl().getList().add(new Process("P2", 40, 10));
		 env.getRl().getList().add(new Process("P3", 25, 10));
		 env.getRl().getList().add(new Process("P4", 30, 55));
		 env.getRl().getList().add(new Process("P5", 45, 95));
		
		 env.getRl().run();
		 System.out.println("---------------------------------------------");
		 System.out.println("TEST CASE 3|| Quantum 2");
		
		 env = new Env(2);
		
		 env.getRl().getList().add(new Process("P1", 75, 0));
		 env.getRl().getList().add(new Process("P2", 40, 10));
		 env.getRl().getList().add(new Process("P3", 25, 10));
		 env.getRl().getList().add(new Process("P4", 30, 55));
		 env.getRl().getList().add(new Process("P5", 45, 95));
		
		 env.getRl().run();
		 System.out.println("---------------------------------------------");

		System.out.println("TEST CASE 2|| Quantum 1");

		env = new Env(1, "P799");
		for (int i = 0; i < 1000; i++) {
			env.getRl().getList().add(new Process("P" + i));

		}

		env.getRl().setupList();

		System.out.println("---------------------------------------------");

		System.out.println("TEST CASE 2|| Quantum 3");

		env = new Env(3, "P799");
		for (int i = 0; i < 1000; i++) {
			env.getRl().getList().add(new Process("P" + i));

		}

		env.getRl().setupList();

		System.out.println("---------------------------------------------");

	}


	public TwoReadyList getRl() {
		return rl;
	}

	public void setRl(TwoReadyList rl) {
		this.rl = rl;
	}

}
