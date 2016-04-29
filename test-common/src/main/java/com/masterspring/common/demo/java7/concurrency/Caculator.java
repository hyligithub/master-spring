package com.masterspring.common.demo.java7.concurrency;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.Thread.State;

public class Caculator implements Runnable {

	private int number;

	public Caculator(int number) {
		this.number = number;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread threads[] = new Thread[10];
		State status[] = new State[10];
		for (int i = 0; i < 10; i++) {
			threads[i] = new Thread(new Caculator(i));
			if (i % 2 == 0) {
				threads[i].setPriority(Thread.MAX_PRIORITY);
			} else
				threads[i].setPriority(Thread.MIN_PRIORITY);
			threads[i].setName("Thread" + i);
		}
////		try (FileWriter file = new FileWriter("d:\\log.txt");
////				PrintWriter pw = new PrintWriter(file);) {
////			for (int i = 0; i < 10; i++) {
////				pw.println("Main : Status of Thread " + i + " : "
////						+ threads[i].getState());
////				status[i] = threads[i].getState();
////			}
////			for (int i = 0; i < 10; i++) {
////				threads[i].start();
////			}
////			boolean finish = false;
////			while (!finish) {
////				for (int i = 0; i < 10; i++) {
////					if (threads[i].getState() != status[i]) {
////						writeThreadInfo(pw, threads[i], status[i]);
////						status[i] = threads[i].getState();
////					}
////				}
////				finish = true;
////				for (int i = 0; i < 10; i++) {
////					finish = finish
////							&& (threads[i].getState() == State.TERMINATED);
////				}
////			}
//
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

	}

	private static void writeThreadInfo(PrintWriter pw, Thread thread,
			State state) {
		pw.printf("Main : Id %d - %s\n", thread.getId(), thread.getName());

		pw.printf("Main : Priority: %d\n", thread.getPriority());

		pw.printf("Main : Old State: %s\n", state);

		pw.printf("Main : New State: %s\n", thread.getState());

		pw.printf("Main : ************************************\n");

	}

	public void run() {
		// TODO Auto-generated method stub
		for (int i = 1; i <= 10; i++) {
			System.out.printf("%s: %d * %d = %d\n", Thread.currentThread()
					.getName(), number, i, i * number);
		}
	}
}
