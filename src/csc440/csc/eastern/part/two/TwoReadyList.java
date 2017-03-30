package csc440.csc.eastern.part.two;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

import csc440.csc.eastern.Process;

public class TwoReadyList {
	private Queue<Process> list;
	private Queue<Process> readyList;
	private TwoRoundRobin trr;

	int quantum;

	int currentTime;

	public TwoReadyList() {
		list = new LinkedList<Process>();
		trr = new TwoRoundRobin();
		readyList = new LinkedList<Process>();
		currentTime = 0;
	}

	public TwoReadyList(int quantum) {
		list = new LinkedList<Process>();
		trr = new TwoRoundRobin();
		readyList = new LinkedList<Process>();
		currentTime = 0;
		this.quantum = quantum;
	}

	public TwoReadyList(Queue<Process> list) {
		this.list = list;
		currentTime = 0;
	}

	public void someoneArrived() {
		for (Process p : list) {
			if (p.getArrivalTime() == currentTime) {
				System.out.println("adding " + p.getId() + " to the queue");
				for(Process inQueue : readyList){
					if(inQueue.getId().equals(p.getId())){
						return;
					}
				}
				readyList.add(p);

				return;
			}
		}
	}

	public void run() {

		int total = 0;
		int turnaround = 0;

		System.out.println("Start time: " + currentTime);

		while (true) {
			System.out.println("current time: " + currentTime);
			someoneArrived();

			if (!readyList.isEmpty()) {
				Process p = readyList.poll();
				
//				System.out.println("----------all current processes-------");
//				for(Process m : readyList){
//					System.out.println(m.toString());
//				}
//				System.out.println("----------all current processes-------");
				

				if (p.getServiceTime() == p.getRemaindingServTime()) {
					p.setStartTime(currentTime);
					total++;
				}
				for (int i = 0; i < quantum; i++) {

					if (p.getRemaindingServTime() != 0) {
						System.out.println("servicing: " + p.getId());
						p.setRemaindingServTime(p.getRemaindingServTime() - 1);
						currentTime++;
						someoneArrived();
					} else {

						// System.out.println("Process " + p.getId() + "
						// ended");
						p.setEndTime(currentTime);
						System.out.println(p.toString());
						turnaround += p.getTurnaroundTime();
						i = 5000;
					}

				}
				
				System.out.println("p.getRemaindingServTime(): "+p.getRemaindingServTime());

				if (p.getRemaindingServTime() > 0) {
					System.out.println("adding " + p.getId() + " back to the queue");
					readyList.add(p);

				}else{
					p.setEndTime(currentTime);
					System.out.println(p.toString());
				}
//				Process dead = readyList.poll();
//				System.out.println("removing process: " + dead.getid);
				
				if (p.getId().equals("P5")) {
					if (p.getRemaindingServTime() == 0) {
						System.out.println("End time: " + currentTime);

						System.out.println("The total average turnaround time is: " + turnaround / total);
						return;
					}
				}

			} else {
				System.out.println("idling for one second");
				currentTime++;
				someoneArrived();

			}

		}

	}

	public Queue<Process> getList() {
		return list;
	}

	public void setList(Queue<Process> list) {
		this.list = list;
	}

	public int generateServiceTime() {

		return new Random().nextInt(4) + 2;

	}

	public int arrivalTimeGeneration() {
		return new Random().nextInt(5) + 4;
	}

	public void setupList() {

		int prevValue = 0;
		for (Process p : list) {
			if (p.getId().equals("P0")) {
				p.setArrivalTime(0);
				p.setServiceTime(generateServiceTime());
				p.setRemaindingServTime(p.getServiceTime());
			} else {
				int temp = arrivalTimeGeneration() + prevValue;
				p.setArrivalTime(temp);
				prevValue = temp;
				p.setServiceTime(generateServiceTime());
				p.setRemaindingServTime(p.getServiceTime());
			}
		}

		for (Process p : list) {
			System.out.println("id: " + p.getId() + " ,arrival time: " + p.getArrivalTime() + " ,service time: "
					+ p.getServiceTime() + " getRemainder: " + p.getRemaindingServTime());

		}

		run();

	}

}
