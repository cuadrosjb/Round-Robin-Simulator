package csc440.csc.eastern.part.two;

import csc440.csc.eastern.Process;

public class TwoRoundRobin {
	private Process current;

	private int quantum;

	private int contextSwitch;

	public TwoRoundRobin() {
		current = null;
		quantum = 0;
		contextSwitch = 0;

	}
	
	public TwoRoundRobin(int quantum) {
		
		this.quantum = quantum;
		

	}

	public TwoRoundRobin(Process current, int quantum) {

		this.current = current;
		this.quantum = quantum;
	}

	public TwoRoundRobin(Process current, int quantum, int contextSwitch) {
		this.contextSwitch = contextSwitch;
		this.current = current;
		this.quantum = quantum;
	}
	
	
	public Process execute(){
		current.setRemaindingServTime(current.getRemaindingServTime()-quantum);
		return current;
	}

	public Process getCurrent() {
		return current;
	}

	public void setCurrent(Process current) {
		this.current = current;
	}

	public int getQuantum() {
		return quantum;
	}

	public void setQuantum(int quantum) {
		this.quantum = quantum;
	}

	public int getContextSwitch() {
		return contextSwitch;
	}

	public void setContextSwitch(int contextSwitch) {
		this.contextSwitch = contextSwitch;
	}
	
}
