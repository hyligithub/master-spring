package com.masterspring.common.demo.innerclass;

public class Goods {

	private int valueRate = 2;
	private class Content implements Contents {
		private int i = 10*valueRate;

		public int value() {
			// TODO Auto-generated method stub
			return i;
		}

	}

	protected class GDestination implements Destination {
		private String label;

		private GDestination(String label) {
			this.label = label;
		}

		public String readLabel() {
			// TODO Auto-generated method stub
			return label;
		}
	}
	
	public Contents cont(){
		return new Content();
	}
	
	public Destination dest(String label){
		return new GDestination(label);
	}
}
