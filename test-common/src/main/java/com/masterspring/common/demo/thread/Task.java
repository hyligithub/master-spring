package com.masterspring.common.demo.thread;

public abstract class Task {
	public enum State {
		NEW, RUNNING, FINISHED
	}

	private State state = State.NEW;

	public void setState(State state) {
		this.state = state;
	}

	public State getState() {
		return state;
	}

	public abstract void deal();
}
