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
public class SearchListener implements ActionListener {
    FindStrategy findStrategy;
    StudentList studentList;
    StudentList studentSearchList;
    MainWindow mainWindow;
    int maxNumberOfSemestr;
    public SearchListener( StudentList studentList, StudentList studentSearchList, MainWindow mainWindow,int maxNumberOfSemestr)
    {
        findStrategy = new FindStrategy(mainWindow.getFrameSearch().getFrameSearchDel()) ;
        this.studentList = studentList;
        this.studentSearchList = studentSearchList;
        this.mainWindow = mainWindow;
         this.maxNumberOfSemestr = maxNumberOfSemestr;
    }

        int counterStudent =0;
        @Override
        public void actionPerformed(ActionEvent e) {
            int strategy = findStrategy.findStrategy();
        studentSearchList.getStudentList().clear();
        mainWindow.getFrameSearch().getTableSearchModel().cleanTableModel(mainWindow.getFrameSearch().getFrameSearch(),maxNumberOfSemestr);
        mainWindow.getFrameSearch().getTableSearchModel().setCurrentPage(1);
        for (int index = 0; index < studentList.getStudentList().size(); index++) {

            if (strategy==1)
            {
                if (studentList.getStudentList().get(index).getLastName().equals(mainWindow.getFrameSearch().getFrameSearchDel().getTextFieldFio1().getText()) &&
                    studentList.getStudentList().get(index).getGroup() == Integer.parseInt(mainWindow.getFrameSearch().getFrameSearchDel().getTextField1().getText())) {
                studentSearchList.add(studentList.getStudentList().get(index));
                counterStudent++;
                }
            }

            if (strategy==2) {
                        if (studentList.getStudentList().get(index).getLastName().equals(mainWindow.getFrameSearch().getFrameSearchDel().getTextFieldFio1().getText()))
                        {
                            for (int numberOfSem = 0; numberOfSem < studentList.getMaxNumberOfSemestre(); numberOfSem++){
                                if (studentList.getStudentList().get(index).getSemNumber().get(numberOfSem).equals(mainWindow.getFrameSearch().getFrameSearchDel().getTextField2().getText())){
                                    studentSearchList.add(studentList.getStudentList().get(index));
                                    counterStudent++;
                                    break;
                                }
                            }
                        }
                    }

                    if (strategy==3) {
                        int sumsWork = 0;

                        if (studentList.getStudentList().get(index).getLastName().equals(mainWindow.getFrameSearch().getFrameSearchDel().getTextFieldFio1().getText())) {

                            for (int numberOfSem = 0; numberOfSem <studentList.getMaxNumberOfSemestre(); numberOfSem++)
                                if (!studentList.getStudentList().get(index).getSemNumber().get(numberOfSem).equals(" "))
                                    sumsWork++;
                            if (sumsWork == Integer.parseInt(mainWindow.getFrameSearch().getFrameSearchDel().getTextField3().getText())) {
                                studentSearchList.add(studentList.getStudentList().get(index));
                                counterStudent++;
                            }
                        }
                    }

                }
            if(strategy==4) JOptionPane.showMessageDialog(null, "Введено больше двух параметров");
            if(strategy==5) JOptionPane.showMessageDialog(null, "Введено меньше двух параметров");
            if(strategy==6) JOptionPane.showMessageDialog(null, "Фамилия не введена");
        if(counterStudent == 0)
            JOptionPane.showMessageDialog(null, "Записей не найдено");
        updateSearchResult();
        mainWindow.getFrameSearch().getFrameSearch().repaint();
    }

    void updateSearchResult() {
        int currentIndexLabel = 0;
        mainWindow.getFrameSearch().getTableSearchModel().getPageFromPages().setText("Страница: "+mainWindow.getFrameSearch().getTableSearchModel().getCurrentPage()+"/"+mainWindow.getFrameSearch().getTableSearchModel().getNumberMaxPage(studentSearchList.getStudentList().size()));
        for(int indexStudent=mainWindow.getFrameSearch().getTableSearchModel().getCurrentPage()*mainWindow.getFrameSearch().getTableSearchModel().getStudentOnPage()-mainWindow.getFrameSearch().getTableSearchModel().getStudentOnPage();
            indexStudent<mainWindow.getFrameSearch().getTableSearchModel().getCurrentPage()*mainWindow.getFrameSearch().getTableSearchModel().getStudentOnPage() && indexStudent< studentSearchList.getStudentList().size();
            indexStudent++)
        {
            List<String> s = studentSearchList.getStudentList().get(indexStudent).getSemNumber();
            mainWindow.getFrameSearch().getTableSearchModel().getStudentLastName()[currentIndexLabel].setText(studentSearchList.getStudentList().get(indexStudent).getLastName() + " "
                    + studentSearchList.getStudentList().get(indexStudent).getFirstName().substring(0, 1) + "."
                    + studentSearchList.getStudentList().get(indexStudent).getSurName().substring(0, 1) + ".");
            mainWindow.getFrameSearch().getFrameSearch().add(mainWindow.getFrameSearch().getTableSearchModel().getStudentLastName()[currentIndexLabel]);
            mainWindow.getFrameSearch().getTableSearchModel().getStudentGroup()[currentIndexLabel].setText(Integer.toString(studentSearchList.getStudentList().get(indexStudent).getGroup()));
            mainWindow.getFrameSearch().getFrameSearch().add(mainWindow.getFrameSearch().getTableSearchModel().getStudentGroup()[currentIndexLabel]);
            for (int indexSem = 0; indexSem < studentList.getMaxNumberOfSemestre(); indexSem++){
                mainWindow.getFrameSearch().getTableSearchModel().getStudentSem()[currentIndexLabel][indexSem].setText(s.get(indexSem));
                mainWindow.getFrameSearch().getFrameSearch().add(mainWindow.getFrameSearch().getTableSearchModel().getStudentSem()[currentIndexLabel][indexSem]);}
            currentIndexLabel++;
        }

    }
    }

