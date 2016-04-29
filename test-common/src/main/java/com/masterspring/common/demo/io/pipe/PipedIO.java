package com.masterspring.common.demo.io.pipe;

public class PipedIO {

	public static void main(String[] args) throws Exception {
		Sender sender = new Sender();
		Receiver receiver = new Receiver(sender);
		sender.start();
		receiver.start();
	}
}