package model;

import model.Student;

import java.util.*;

public class StudentList {
     private List<Student> studentList;
     private int currentPage;
     private int studentOnPage;
     public StudentList()
    {
     currentPage=1;
     studentOnPage=3;
     studentList = new ArrayList<Student>();
    }

    public void nextPage()
    {
        boolean hasNextPage = studentList.size()> studentOnPage*(currentPage-1)+studentOnPage;
        if(hasNextPage) currentPage++;
    }

    public void prevPage()
    {
        if(currentPage>1) currentPage--;
    }

    public void firstPage()
    {
        if (currentPage > 1) currentPage = 1;
    }

    public void lastPage()
    {
        if (currentPage != getNumberMaxPage())
            currentPage = getNumberMaxPage();
    }

    public int getNumberMaxPage()
     {
        return ((studentList.size() - 1)/ studentOnPage) + 1;
     }

    public void add(Student student)
 {
  studentList.add(student);
 }

    public List<Student> getStudentList() {
        return studentList;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public void setStudentOnPage(int studentOnPage) {
        this.studentOnPage = studentOnPage;
    }

    public int getStudentOnPage() {
        return studentOnPage;
    }
}
