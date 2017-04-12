import javax.swing.*;


public class Student {
    String lastName;
    String firstName;
    String surName;
    int group;
    String[] semNumber = new String[10];

    Student(String lastName, String firstName, String surName, int group, String[] planWorks) {
    this.lastName=lastName;
    this.firstName= firstName;
    this.surName=surName;
    this.group=group;
    semNumber = planWorks;
    }

}
