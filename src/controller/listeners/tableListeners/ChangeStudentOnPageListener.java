package controller.listeners.tableListeners;

import controller.UpdateWindow;
import model.StudentList;
import view.TableModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by user on 09.05.2017.
 */
public class ChangeStudentOnPageListener implements ActionListener {
    private TableModel tableModel;
    private JFrame frame;
    private StudentList studentList;
    private UpdateWindow updateMainWindow;
    public ChangeStudentOnPageListener(JFrame frame, TableModel tableModel, StudentList studentList,UpdateWindow updateMainWindow)
    {
        this.updateMainWindow=updateMainWindow;
        this.frame = frame;
        this.tableModel = tableModel;
        this.studentList = studentList;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(Integer.parseInt(tableModel.getTextNumStudentOnPage().getText())<tableModel.getMaxStudentOnPage()){
            tableModel.setStudentOnPage(Integer.parseInt(tableModel.getTextNumStudentOnPage().getText()));
            tableModel.cleanTableModel(frame,studentList.getMaxNumberOfSemestre());
            updateMainWindow.updateSimpleWindow();
        }
    }
}