package csc440.csc.eastern;

import java.util.LinkedList;
import java.util.Queue;

public class ReadyList {
	
	private Queue<Process> list;

	public ReadyList(){
		list = new LinkedList<Process>();
	}

	public ReadyList(Queue<Process> list) {
		this.list = list;
	}

	public Queue<Process> getList() {
		return list;
	}

	public void setList(Queue<Process> list) {
		this.list = list;
	}
	
	
	
}
