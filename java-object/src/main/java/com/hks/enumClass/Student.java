package com.hks.enumClass;

/**
 * 在 assignGrade() 中是没有进行错误检测的代码，也没有考虑边界情况，请注意这是如何做到
 */
public class Student {

    private String firstName;

    private String lastName;

    private Grade grade;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    public Student(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFullName(){
        return new StringBuffer(firstName)
                .append(" ")
                .append(lastName)
                .toString();
    }

}
