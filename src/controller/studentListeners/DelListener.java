package controller.studentListeners;

import controller.FindStrategy;
import model.StudentList;
import view.MainWindow;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * Created by user on 09.05.2017.
 */
public class DelListener implements ActionListener {
    private FindStrategy findStrategy;
    private StudentList studentList;
    private StudentList studentSearchList;
    private MainWindow mainWindow;

    public DelListener(StudentList studentList, StudentList studentSearchList, MainWindow mainWindow)
    {
        findStrategy = new FindStrategy(mainWindow.getFrameDel().getFrameSearchDel()) ;
        this.studentList = studentList;
        this.studentSearchList = studentSearchList;
        this.mainWindow = mainWindow;

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
        updateSimpleWindow();
        mainWindow.getFrame().repaint();

    }
    void updateSimpleWindow() {
        int currentIndexLabel = 0;
        mainWindow.getTableModel().cleanTableModel(mainWindow.getFrame(),studentList.getMaxNumberOfSemestre());
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
