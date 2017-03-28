package csc440.csc.eastern;

public class Environment {

	private RoundRobin rr;
	private ReadyList rl;
	

	
		
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
				
		env.getRl().getList().add(new Process("P1",70,0));
		env.getRl().getList().add(new Process("P2",40,10));
		env.getRl().getList().add(new Process("P3",25,15));
		env.getRl().getList().add(new Process("P4",20,80));
		env.getRl().getList().add(new Process("P5",45,90));
		
		env.start();
		

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
