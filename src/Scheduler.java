import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Scheduler {
	private ArrayList<Process> orderAL = new ArrayList<Process>();
	private Queue<Process> procQ = new LinkedList<>();
	private Queue<Process> fcfsQ = new LinkedList<>();
	
	public Scheduler(char a) {
		if(a == 'y' || a == 'Y') {
			setUpAuto();
		} else {
			setUpManual();
		}
	}
	
	/*
	 * our  program  should 
	 * input  information  for  10  processes  from  the  user  (or  set  the  values  in  the 
	 * program  code),  display  the  order  in  which  they  will  run,  along  with  each 
	 * process’  wait  time  and  turnaround  time  –  then,  compute  and  display  the 
	 * average wait time and average turnaround time.  
	 */
	
	/*
	 * Values generated using
	 * https://www.random.org/integer-sets/
	 */
	public void setUpAuto() {
		//Process(int pid, int burstTime, int arrivalTime, int priority)
		Process temp1 = new Process(287, 24, 18, 3);
		Process temp2 = new Process(367, 37, 24, 2);
		Process temp3 = new Process(400, 19, 10, 1);
		Process temp4 = new Process(689, 38, 26, 4);
		Process temp5 = new Process(515, 47, 11, 5);
		Process temp6 = new Process(164, 43, 6, 4);
		Process temp7 = new Process(465, 4, 16, 2);
		Process temp8 = new Process(201, 22, 14, 3);
		Process temp9 = new Process(129, 42, 27, 1);
		Process temp10 = new Process(885, 8, 15, 5);
		
		orderAL.add(temp1);
		orderAL.add(temp2);
		orderAL.add(temp3);
		orderAL.add(temp4);
		orderAL.add(temp5);
		orderAL.add(temp6);
		orderAL.add(temp7);
		orderAL.add(temp8);
		orderAL.add(temp9);
		orderAL.add(temp10);
	}
	
	public void setUpManual() {
		System.out.println("Hello, user. We will begin by inputting information for each process sequentially. Each value will be an integer");
		
		for(int i = 1; i < 11; i++) {
			Scanner in = new Scanner(System.in);
			int pid, burstTime, arrivalTime, priority;
			
			System.out.println("Process " + i + " pid: ");
			pid = in.nextInt();
			System.out.println("Process " + i + " burstTime: ");
			burstTime = in.nextInt();
			System.out.println("Process " + i + " arrivalTime: ");
			arrivalTime = in.nextInt();
			System.out.println("Process " + i + " priority: ");
			priority = in.nextInt();

			Process temp = new Process(pid, burstTime, arrivalTime, priority);
			orderAL.add(temp);
		}
		
		FCFS();
	}
	
	public void FCFS() {
		Queue<Process> processed = new LinkedList<>();
		int turnaround = 0;
		/*
		 * https://www.geeksforgeeks.org/gate-notes-operating-system-process-scheduling/
		 */
		
		//Orders the processes by arrival time
		while(!orderAL.isEmpty()) {
			Process low = null;
			
			for(Process a: orderAL) {
				if(low == null) {
					low = a;
					continue;
				}
				
				if(low.getArrivalTime() > a.getArrivalTime()) {
					low = a;
				}
			}
			
			orderAL.remove(low);
			fcfsQ.add(low);
		}
		
		
		
	}
	
	
}
