package com.masterspring.common.demo.juc.copyonwrite;

public class Student {
    private int id;
    private String name;

    public String toString() {
        return "Student：" + id + "--" + name;
    }

    public Student(int id, String name) {
        this.id = id;
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

//    public int hashCode() {
//        return this.id;
//    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Student) {
            Student s = (Student) o;
            if ((this.id == s.id) && (this.getName().equals(s.getName()))) {
                return true;
            }
        }
        return false;
    }
}