package com.masterspring.common.demo.comparable;

import java.util.Arrays;

public class NameSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Name[] aa = new Name[] {
				new Name("John", "Lennon", "3556465464644343"),
				new Name("Karl", "Marx", "3556465461111111"),
				new Name("Groucho", "Marx", "3805236412578"),
				new Name("Oscar", "Grouch", "8854321622238") };
		Arrays.sort(aa);

		for (Name a : aa) {
			System.out.println(a.toString());
		}
	}

}
