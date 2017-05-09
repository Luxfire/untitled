package controller.studentListeners;
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
   public AddStudentListener(MainWindow mainWindow, StudentList studentList)
    {
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
        updateSimpleWindow();
        mainWindow.getFrame().repaint();

    }
    void updateSimpleWindow() {
        int currentIndexLabel = 0;
        mainWindow.getTableModel().getPageFromPages().setText("Страница: "+mainWindow.getTableModel().getCurrentPage()+"/"+mainWindow.getTableModel().getNumberMaxPage(studentList.getStudentList().size()));
        for(int indexStudent=mainWindow.getTableModel().getCurrentPage()*mainWindow.getTableModel().getStudentOnPage()-mainWindow.getTableModel().getStudentOnPage();
            indexStudent<mainWindow.getTableModel().getCurrentPage()*mainWindow.getTableModel().getStudentOnPage() && indexStudent< studentList.getStudentList().size();
            indexStudent++)
        {
            List<String> s = studentList.getStudentList().get(indexStudent).getSemNumber();
            mainWindow.getTableModel().getStudentLastName()[currentIndexLabel].setText(studentList.getStudentList().get(indexStudent).getLastName() + " "
                    + studentList.getStudentList().get(indexStudent).getFirstName().substring(0, 1) + "."
                    + studentList.getStudentList().get(indexStudent).getSurName().substring(0, 1) + ".");
            mainWindow.getFrame().add(mainWindow.getTableModel().getStudentLastName()[currentIndexLabel]);
            mainWindow.getTableModel().getStudentGroup()[currentIndexLabel].setText(Integer.toString(studentList.getStudentList().get(indexStudent).getGroup()));
            mainWindow.getFrame().add(mainWindow.getTableModel().getStudentGroup()[currentIndexLabel]);
            for (int indexSem = 0; indexSem < studentList.getMaxNumberOfSemestre(); indexSem++){
                mainWindow.getTableModel().getStudentSem()[currentIndexLabel][indexSem].setText(s.get(indexSem));
                mainWindow.getFrame().add(mainWindow.getTableModel().getStudentSem()[currentIndexLabel][indexSem]);}
            currentIndexLabel++;
        }

    }
}
