package com.masterspring.common.demo.innerclass;

import java.util.Date;

public class Goods2 {

	private void internalTracking(boolean b) {
		
		ThreadLocal<Date> ss = new ThreadLocal<Date>();
		if (b) {
			class TrackingSlip {
				private String label;

				private TrackingSlip(String l) {
					this.label = l;
				}

				public String getLip() {
					return label;
				}
			}
			TrackingSlip ts = new TrackingSlip("bbbb");
			String ll = ts.getLip();
			System.out.println(ll);
		}
	}

	private void track() {
		internalTracking(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Goods2 g = new Goods2();
		g.track();
	}

}
