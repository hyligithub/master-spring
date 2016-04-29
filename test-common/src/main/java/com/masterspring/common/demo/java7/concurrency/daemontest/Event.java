package com.masterspring.common.demo.java7.concurrency.daemontest;

import java.io.Serializable;
import java.util.Date;

public class Event implements Serializable{
	
	private Date addDate;
	private String event;
	public Date getAddDate() {
		return addDate;
	}
	public void setAddDate(Date addDate) {
		this.addDate = addDate;
	}
	public String getEvent() {
		return event;
	}
	public void setEvent(String event) {
		this.event = event;
	}
	

}
