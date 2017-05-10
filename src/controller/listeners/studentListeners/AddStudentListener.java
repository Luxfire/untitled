package controller.listeners.studentListeners;
import controller.UpdateWindow;
import model.StudentList;
import view.*;
import model.Student;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 08.05.2017.
 */
public class AddStudentListener implements ActionListener{
    private MainWindow mainWindow;
    private StudentList studentList;
    private UpdateWindow updateMainWindow;

    public AddStudentListener(MainWindow mainWindow, StudentList studentList,UpdateWindow updateMainWindow)
    {   this.updateMainWindow=updateMainWindow;
        this.mainWindow=mainWindow;
        this.studentList=studentList;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        List<String> planWorks = new ArrayList<>();
        for(int index = 0; index<studentList.getMaxNumberOfSemestre();index++){
            if(!mainWindow.getFrameAddStudent().getTextWork()[index].getText().equals(""))
                planWorks.add(mainWindow.getFrameAddStudent().getTextWork()[index].getText());
            else planWorks.add(" ");
        }

        if (!mainWindow.getFrameAddStudent().getTextFirstName().getText().isEmpty()
                && !mainWindow.getFrameAddStudent().getTextLastName().getText().isEmpty()
                && !mainWindow.getFrameAddStudent().getTextSurName().getText().isEmpty()
                && !mainWindow.getFrameAddStudent().getTextGroup().getText().isEmpty())
        {
            Student student = new Student(mainWindow.getFrameAddStudent().getTextLastName().getText(),
                    mainWindow.getFrameAddStudent().getTextFirstName().getText(),
                    mainWindow.getFrameAddStudent().getTextSurName().getText(),
                    Integer.parseInt(mainWindow.getFrameAddStudent().getTextGroup().getText()), planWorks);

            studentList.add(student);
            mainWindow.getFrameAddStudent().getFrameAdd().setVisible(false);
        } else JOptionPane.showMessageDialog(null, "Важные поля не заполнены!!!");
        updateMainWindow.updateSimpleWindow();
    }

}
