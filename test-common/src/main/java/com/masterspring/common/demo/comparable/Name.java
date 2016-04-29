/**
 * 
 */
package com.masterspring.common.demo.comparable;

/**
 * @author lihy
 * 
 */
public class Name implements Comparable<Name> {

	public String firstName;
	public String lastName;
	public String id;

	public Name(String f, String l, String id) {
		this.firstName = f;
		this.lastName = l;
		this.id = id;
	}

	public int compareTo(Name o) {
		// TODO Auto-generated method stub
		int a = lastName.compareTo(o.lastName);
		return (Integer) (a != 0 ? a : firstName.compareTo(o.firstName));
	}
	
	public boolean equals(Object o){
		
		if(o instanceof Name){
			Name r =(Name)o;
			if(r.id.equals(this.id)){
				return true;
			}
		}
		return false;
		
	}
	public int hashCode(){
		return Integer.valueOf(id)*firstName.hashCode();
	}

	public String toString() {
		return firstName + "--" + lastName;
	}
}
