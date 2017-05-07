package model;

import model.Student;

import java.util.*;

public class StudentList {
     private List<Student> studentList;
       private int maxNumberOfSemestre;

     public StudentList()
    {
     studentList = new ArrayList<Student>();
     maxNumberOfSemestre =10;
    }

    public void add(Student student)
 {
  studentList.add(student);
 }

    public List<Student> getStudentList() {
        return studentList;
    }

    public int getMaxNumberOfSemestre() {
        return maxNumberOfSemestre;
    }
}
