package csc440.csc.eastern;

public class Environment {

	private RoundRobin rr;
	private ReadyList rl;
	
	
	public Environment(){
		
	}
	
	public Environment(RoundRobin rr, ReadyList rl) {
		this.rr = rr;
		this.rl = rl;
	}


	public static void main(String[] args) {
		
//		Process p1 = new Process(70,0);
//		Process p2 = new Process(40,10);
//		Process p3 = new Process(25,15);
//		Process p4 = new Process(20,80);
//		Process p5 = new Process(45,90);
		
		Environment env = new Environment();
		
		env.getRl().getList().add(new Process(70,0));
		env.getRl().getList().add(new Process(40,10));
		env.getRl().getList().add(new Process(25,15));
		env.getRl().getList().add(new Process(20,80));
		env.getRl().getList().add(new Process(45,90));
		
		
		

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
