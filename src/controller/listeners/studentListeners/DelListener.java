package controller.listeners.studentListeners;

import controller.FindStrategy;
import controller.UpdateWindow;
import model.StudentList;
import view.MainWindow;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by user on 09.05.2017.
 */
public class DelListener implements ActionListener {
    private FindStrategy findStrategy;
    private StudentList studentList;
    private MainWindow mainWindow;
    private UpdateWindow updateMainWindow;


    public DelListener(StudentList studentList, MainWindow mainWindow,UpdateWindow updateMainWindow)
    {
        findStrategy = new FindStrategy(mainWindow.getFrameDel().getFrameSearchDel()) ;
        this.studentList = studentList;
        this.mainWindow = mainWindow;
        this.updateMainWindow = updateMainWindow;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int counterStudent =0;
        int strategy = findStrategy.findStrategy();

        for (int index = 0; index < studentList.getStudentList().size(); index++)
        {

            if (strategy==1)
            {
                if (studentList.getStudentList().get(index).getLastName().equals(mainWindow.getFrameDel().getFrameSearchDel().getTextFieldFio1().getText()) &&
                        studentList.getStudentList().get(index).getGroup() == Integer.parseInt(mainWindow.getFrameDel().getFrameSearchDel().getTextField1().getText())) {
                    studentList.getStudentList().remove(index);
                    index--;
                    counterStudent++;
                }
            }

            if (strategy==2) {
                if (studentList.getStudentList().get(index).getLastName().equals(mainWindow.getFrameDel().getFrameSearchDel().getTextFieldFio1().getText()))
                {
                    for (int numberOfSem = 0; numberOfSem < studentList.getMaxNumberOfSemestre(); numberOfSem++){
                        if (studentList.getStudentList().get(index).getSemNumber().get(numberOfSem).equals(mainWindow.getFrameDel().getFrameSearchDel().getTextField2().getText())){
                            studentList.getStudentList().remove(index);
                            counterStudent++;
                            index--;
                            break;
                        }
                    }
                }
            }

            if (strategy==3) {
                int sumsWork = 0;

                if (studentList.getStudentList().get(index).getLastName().equals(mainWindow.getFrameDel().getFrameSearchDel().getTextFieldFio1().getText())) {

                    for (int numberOfSem = 0; numberOfSem <studentList.getMaxNumberOfSemestre(); numberOfSem++)
                        if (!studentList.getStudentList().get(index).getSemNumber().get(numberOfSem).equals(" "))
                            sumsWork++;
                    if (sumsWork == Integer.parseInt(mainWindow.getFrameDel().getFrameSearchDel().getTextField3().getText())) {
                        studentList.getStudentList().remove(index);
                        counterStudent++;
                        index--;
                    }
                }
            }

        }

        if(strategy==4) JOptionPane.showMessageDialog(null, "Введено больше двух параметров");
        if(strategy==5) JOptionPane.showMessageDialog(null, "Введено меньше двух параметров");
        if(strategy==6) JOptionPane.showMessageDialog(null, "Фамилия не введена");
        if(counterStudent == 0)
            JOptionPane.showMessageDialog(null, "Записей не найдено");

        if (counterStudent>0) JOptionPane.showMessageDialog(null, "Записей удалено "+counterStudent);
       updateMainWindow.updateSimpleWindow();

    }
}
