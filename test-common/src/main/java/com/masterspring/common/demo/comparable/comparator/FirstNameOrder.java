/**
 * 
 */
package com.masterspring.common.demo.comparable.comparator;


import com.masterspring.common.demo.comparable.Name;

import java.util.Comparator;

/**
 * @author lihy
 *
 */
public class FirstNameOrder implements Comparator<Name> {

	public int compare(Name o1, Name o2) {
		// TODO Auto-generated method stub
		int firstTmp = o1.firstName.compareTo(o2.firstName);
		return (firstTmp!=0?firstTmp:o1.lastName.compareTo(o2.lastName));
	}

}
