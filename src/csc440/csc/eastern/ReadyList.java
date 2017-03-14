package csc440.csc.eastern;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.TimeUnit;

public class ReadyList {

	private Queue<Process> list;
	
	int currentTime;

	public ReadyList() {
		list = new LinkedList<Process>();
		currentTime = 0;
	}

	public ReadyList(Queue<Process> list) {
		this.list = list;
		currentTime = 0;
	}

	public void run() {
		try {
			while (!list.isEmpty()) {
				
				if(list.peek().getArrivalTime() <= currentTime){
				
					Process p = list.peek();
					list.remove();
					if (p.getRemaindingServTime() > 4) {
						currentTime+=5;
						TimeUnit.MILLISECONDS.sleep(5);
						p = new RoundRobin(p, 5).execute();
						list.add(p);
					} else {
						currentTime+=p.getRemaindingServTime();
						TimeUnit.MILLISECONDS.sleep(p.getRemaindingServTime());
						p = new RoundRobin(p, 5).execute();
					}
				}else{
					Process p = list.peek();
					list.remove();
					list.add(p);
				}
			}
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		}
	}

	public Queue<Process> getList() {
		return list;
	}

	public void setList(Queue<Process> list) {
		this.list = list;
	}

}
