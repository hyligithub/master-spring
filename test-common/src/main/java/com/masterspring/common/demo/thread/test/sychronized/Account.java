/**
 * 
 */
package com.masterspring.common.demo.thread.test.sychronized;

/**
 * @author lihy
 *
 */
public class Account {
	
	private int blance;
	public Account(int blance){
		this.setBlance(blance);
	}
	public int getBlance() {
		return blance;
	}
	public void setBlance(int blance) {
		this.blance = blance;
	}
}
