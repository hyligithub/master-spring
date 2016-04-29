package com.masterspring.common.demo.java7.concurrency;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class InterruptedExceptionTest implements Runnable {

	private String initPath;
	private String fileName;

	public InterruptedExceptionTest(String initPath, String fileName) {
		this.initPath = initPath;
		this.fileName = fileName;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InterruptedExceptionTest aa = new InterruptedExceptionTest("d:/logs",
				"log.txt");
		Thread thread = new Thread(aa);
		thread.start();
		try {
			TimeUnit.SECONDS.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		thread.interrupt();
	}

	public void run() {
		// TODO Auto-generated method stub
		File file = new File(initPath);
		if (file.isDirectory()) {
			try {
				directoryProcess(file);
			} catch (InterruptedException e) {
				System.out.printf("%s: The search has been interrupted", Thread
						.currentThread().getName());
			}
		}
	}

	private void directoryProcess(File file) throws InterruptedException {
		File[] list = file.listFiles();
		if (list != null) {
			for (int i = 0; i < list.length; i++) {
				if (list[i].isDirectory()) {
					directoryProcess(list[i]);
				} else {
					fileProcess(list[i]);
				}
			}
		}
		if (Thread.interrupted()) {
			throw new InterruptedException();
		}
	}

	private void fileProcess(File file) throws InterruptedException {
		if (file.getName().equals(fileName)) {
			System.out.printf("%s : %s\n", Thread.currentThread().getName(),
					file.getAbsolutePath());

		}
		if (Thread.interrupted()) {
			throw new InterruptedException();
		}
	}

}
