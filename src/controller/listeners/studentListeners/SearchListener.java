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
public class SearchListener implements ActionListener {
    private FindStrategy findStrategy;
    private StudentList studentList;
    private StudentList studentSearchList;
    private MainWindow mainWindow;
    private UpdateWindow updateSearchWindow;
    private int maxNumberOfSemestr;
    public SearchListener( StudentList studentList, StudentList studentSearchList, MainWindow mainWindow,int maxNumberOfSemestr, UpdateWindow updateSearchWindow)
    {
        findStrategy = new FindStrategy(mainWindow,studentList,studentSearchList) ;
        this.updateSearchWindow = updateSearchWindow;
        this.studentList = studentList;
        this.studentSearchList = studentSearchList;
        this.mainWindow = mainWindow;
         this.maxNumberOfSemestr = maxNumberOfSemestr;
    }
        @Override
        public void actionPerformed(ActionEvent e) {
            studentSearchList.getStudentList().clear();
            mainWindow.getFrameSearch().getTableSearchModel().cleanTableModel(mainWindow.getFrameSearch().getFrameSearch(),maxNumberOfSemestr);
          findStrategy.findStrategy(1);
        mainWindow.getFrameSearch().getTableSearchModel().setCurrentPage(1);
        updateSearchWindow.updateSimpleWindow();
    }


    }


