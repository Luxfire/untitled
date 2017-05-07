package model;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;


public class Student {
    private String lastName;
    private String firstName;
    private String surName;
    private int group;
    private List<String> semNumber = new ArrayList<>();

    public Student(String lastName, String firstName, String surName, int group, List planWorks) {
    this.lastName=lastName;
    this.firstName= firstName;
    this.surName=surName;
    this.group=group;
    semNumber = planWorks;
    }


    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSurName() {
        return surName;
    }

    public int getGroup() {
        return group;
    }

    public List<String> getSemNumber() {
        return semNumber;
    }
}
