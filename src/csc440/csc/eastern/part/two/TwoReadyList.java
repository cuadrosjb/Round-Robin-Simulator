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
	String stopAtProcess;

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
		stopAtProcess = "P5";
	}

	public TwoReadyList(int quantum, String stopAtProcess) {
		list = new LinkedList<Process>();
		trr = new TwoRoundRobin();
		readyList = new LinkedList<Process>();
		currentTime = 0;
		this.quantum = quantum;
		this.stopAtProcess = stopAtProcess;
	}

	public TwoReadyList(Queue<Process> list) {
		this.list = list;
		currentTime = 0;
	}

	/**
	 * Check if the process has arrived
	 */
	public void someoneArrived() {
		for (Process p : list) {
			if (p.getArrivalTime() == currentTime) {
				for (Process inQueue : readyList) {
					if (inQueue.getId().equals(p.getId())) {
						return;
					}
				}
				readyList.add(p);
			}
		}
	}

	/**
	 * Function which helps keeping track for all the variables
	 * Add current time, class the function someoneArrived(), and 
	 * subtracts the turn around to the service time
	 * 
	 */
	public void run() {

		int total = 0;
		int turnaround = 0;

		System.out.println("Start time: " + currentTime);

		while (true) {
			someoneArrived();

			if (!readyList.isEmpty()) {
				Process p = readyList.poll();

				if (p.getServiceTime() == p.getRemaindingServTime()) {
					p.setStartTime(currentTime);
					total++;
				}
				for (int i = 0; i < quantum; i++) {

					if (p.getRemaindingServTime() != 0) {
						p.setRemaindingServTime(p.getRemaindingServTime() - 1);
						currentTime++;
						someoneArrived();
					} else {
						p.setEndTime(currentTime);
						if (p.getId().equals("P0") || p.getId().equals("P1") || p.getId().equals("P2")
								|| p.getId().equals("P3") || p.getId().equals("P4") || p.getId().equals("P5")
								|| p.getId().equals("P6") || p.getId().equals("P7") || p.getId().equals("P8")
								|| p.getId().equals("P9") || p.getId().equals("P790") || p.getId().equals("P791")
								|| p.getId().equals("P792") || p.getId().equals("P793") || p.getId().equals("P794")
								|| p.getId().equals("P795") || p.getId().equals("P796") || p.getId().equals("P797")
								|| p.getId().equals("P798") || p.getId().equals("P799"))
							System.out.println(p.toString());
						turnaround += p.getTurnaroundTime();
						i = 5000;
					}

				}

				if (p.getRemaindingServTime() > 0) {
					readyList.add(p);

				} else {
					p.setEndTime(currentTime);
					turnaround += p.getTurnaroundTime();

					if (p.getId().equals("P0") || p.getId().equals("P1") || p.getId().equals("P2")
							|| p.getId().equals("P3") || p.getId().equals("P4") || p.getId().equals("P5")
							|| p.getId().equals("P6") || p.getId().equals("P7") || p.getId().equals("P8")
							|| p.getId().equals("P9") || p.getId().equals("P790") || p.getId().equals("P791")
							|| p.getId().equals("P792") || p.getId().equals("P793") || p.getId().equals("P794")
							|| p.getId().equals("P795") || p.getId().equals("P796") || p.getId().equals("P797")
							|| p.getId().equals("P798") || p.getId().equals("P799"))
						System.out.println(p.toString());
				}
				if (p.getId().equals(stopAtProcess)) {
					if (p.getRemaindingServTime() == 0) {
						System.out.println("End time: " + currentTime);
						total = 800;
						System.out.println("The total average turnaround time is: " + ((double) turnaround / total));
						return;
					}
				}

			} else {
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

	// Sets the random generate list of processes and assigns the random arrival
	// and random service time
	// once finished we call the run functions to simulate the round robin
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

		run();

	}

	public Queue<Process> getReadyList() {
		return readyList;
	}

	public void setReadyList(Queue<Process> readyList) {
		this.readyList = readyList;
	}

	public TwoRoundRobin getTrr() {
		return trr;
	}

	public void setTrr(TwoRoundRobin trr) {
		this.trr = trr;
	}

	public int getQuantum() {
		return quantum;
	}

	public void setQuantum(int quantum) {
		this.quantum = quantum;
	}

	public int getCurrentTime() {
		return currentTime;
	}

	public void setCurrentTime(int currentTime) {
		this.currentTime = currentTime;
	}

}
