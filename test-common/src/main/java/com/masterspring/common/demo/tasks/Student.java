package com.masterspring.common.demo.tasks;


public class Student {

	public Student(int id ,String name) {
		// TODO Auto-generated constructor stub
		this.id = id ;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private int id;
	private String name;

	public boolean equals(Object o) {
		if (o instanceof Student) {
			Student r = (Student) o;
			if (r.id == this.id) {
				return true;
			}
		}
		return false;
	}

	public int hashCode() {
		return this.id;
	}
}
