package com.masterspring.common.annotation;

/**
 * Created by lihuiyan on 2016/3/16.
 */
@DBTable(name = "member_test")
public class Member {
    @SQLString(value = 30, name = "firstName")
    private String firstName;
    @SQLString(value = 50, name = "lastName")
    private String lastName;
    @SQLInteger(name = "age")
    private Integer age;

    @SQLString(value = 30, constraints = @Constraints(isPrimayKey = true))
    private String handle;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getHandle() {
        return handle;
    }

    public void setHandle(String handle) {
        this.handle = handle;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
