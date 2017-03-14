package csc440.csc.eastern;

public class RoundRobin {

	private Process current;

	private int quantum;

	private int contextSwitch;

	public RoundRobin() {
		current = null;
		quantum = 0;
		contextSwitch = 0;

	}

	public RoundRobin(Process current, int quantum) {

		this.current = current;
		this.quantum = quantum;
	}

	public RoundRobin(Process current, int quantum, int contextSwitch) {
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
