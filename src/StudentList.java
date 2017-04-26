
import java.util.*;

public class StudentList {
     List<Student> studentList;
     int currentPage;
     int studentOnPage;
     public StudentList()
    {
     currentPage=1;
     studentOnPage=3;
     studentList = new ArrayList<Student>();
    }

    public Student get(int i)
    {
        return studentList.get(i);
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


}
