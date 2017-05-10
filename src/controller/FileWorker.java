package controller;
import model.*;

public class FileWorker {

     final String LAST_NAME = "last_name";
     final String FIRST_NAME = "first_name";
     final String SUR_NAME = "sur_name";
     final String GROUP = "group";
     final String SOCIAL_WORK = "social_work";
     final String STUDENT = "student";
     final String STUDENTS = "students";
     final String EXTENSION = "xml";
     StudentList model;
     public OpenFile openFile;
     public SaveFile saveFile;

    public FileWorker(StudentList model)
    {
        this.model = model;
        FileWorker that = this;
        openFile = new OpenFile(that);
        saveFile = new SaveFile(that);

    }

}