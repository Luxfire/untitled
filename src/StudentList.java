import java.util.*;

public class StudentList {
     List<Student> studentList;
     StudentList()
    {
     studentList = new ArrayList<Student>();
    }

 Student get(int i)
 {
  return studentList.get(i);
 }

 void add(Student student)
 {
  studentList.add(student);
 }
}
