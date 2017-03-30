package csc440.csc.eastern;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

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
	
	public void runG() {

		int total = 0;
		int turnaround = 0;

		System.out.println("Start time: " + currentTime);
		while (!list.isEmpty()) {

			if (list.peek().getArrivalTime() <= currentTime) {

				Process p = list.peek();
				list.remove();
//				System.out.println("Process: " + p.getId() + " current time: " + currentTime);
				if (p.getRemaindingServTime() > 1) {

					if (p.getServiceTime() == p.getRemaindingServTime()) {
						p.setStartTime(currentTime);
					}

					currentTime += 1;
					p = new RoundRobin(p, 1).execute();
					if (p.getRemaindingServTime() == 0) {
						p.setEndTime(currentTime);
						System.out.println(p.toString());
						total++;
						turnaround += p.getTurnaroundTime();
					} else {
						list.add(p);
					}

				} else {
					currentTime += p.getRemaindingServTime();
					p = new RoundRobin(p, 1).execute();
					p.setEndTime(currentTime);
					System.out.println(p.toString());
					total++;
					turnaround += p.getTurnaroundTime();

				}
			} else {
				Process p = list.peek();
				list.remove();
				list.add(p);
				currentTime++;
			}
		}
		System.out.println("End time: " + currentTime);

		System.out.println("The total average turnaround time is: " + turnaround / total);
	}
	

	public void run() {

		int total = 0;
		int turnaround = 0;

		System.out.println("Start time: " + currentTime);
		while (!list.isEmpty()) {

			if (list.peek().getArrivalTime() <= currentTime) {

				Process p = list.peek();
				list.remove();
//				System.out.println("Process: " + p.getId() + " current time: " + currentTime);
				if (p.getRemaindingServTime() > 4) {

					if (p.getServiceTime() == p.getRemaindingServTime()) {
						p.setStartTime(currentTime);
					}

					currentTime += 5;
					p = new RoundRobin(p, 5).execute();
					if (p.getRemaindingServTime() == 0) {
						p.setEndTime(currentTime);
						System.out.println(p.toString());
						total++;
						turnaround += p.getTurnaroundTime();
					} else {
						list.add(p);
					}

				} else {
					currentTime += p.getRemaindingServTime();
					p = new RoundRobin(p, 5).execute();
					p.setEndTime(currentTime);
					System.out.println(p.toString());
					total++;
					turnaround += p.getTurnaroundTime();

				}
			} else {
				Process p = list.peek();
				list.remove();
				list.add(p);
			}
		}
		System.out.println("End time: " + currentTime);

		System.out.println("The total average turnaround time is: " + turnaround / total);
	}

	public Queue<Process> getList() {
		return list;
	}

	public void setList(Queue<Process> list) {
		this.list = list;
	}

	public int generateServiceTime() {

		return new Random().nextInt(4)+2;

	}
	
	public int arrivalTimeGeneration(){
		return new Random().nextInt(5)+4;
	}
	
	public void setupList(){
		
		int prevValue= 0;
		for(Process p : list){
//			System.out.println(p.getId() + " current time: " + currentTime);
			if(p.getId().equals("P0")){
				p.setArrivalTime(0);
				p.setServiceTime(generateServiceTime());
			}else{
				int temp = arrivalTimeGeneration() + prevValue;
				p.setArrivalTime(temp);
				prevValue = temp;
				p.setServiceTime(generateServiceTime());
			}
		}
		
		currentTime =0 ;
		
		for(Process p : list){
			System.out.println("id: " + p.getId() + " ,arrival time: " + p.getArrivalTime() + " ,service time: " + p.getServiceTime());
			
		}
		
		runG();
		
	}

}
