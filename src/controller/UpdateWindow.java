package controller;

import model.StudentList;
import view.TableModel;

import javax.swing.*;
import java.util.List;

/**
 * Created by user on 09.05.2017.
 */
public class UpdateWindow {
   private StudentList studentList;
   private TableModel tableModel;
   private JFrame frame;

    public UpdateWindow(JFrame frame,TableModel tableModel, StudentList studentList)
    {
        this.frame=frame;
        this.tableModel=tableModel;
        this.studentList=studentList;
    }

    public void updateSimpleWindow() {
        int currentIndexLabel = 0;
        tableModel.cleanTableModel(frame,studentList.getMaxNumberOfSemestre());
        tableModel.getPageFromPages().setText("Страница: "+tableModel.getCurrentPage()+"/"+tableModel.getNumberMaxPage(studentList.getStudentList().size()));
        for(int indexStudent=tableModel.getCurrentPage()*tableModel.getStudentOnPage()-tableModel.getStudentOnPage();
            indexStudent<tableModel.getCurrentPage()*tableModel.getStudentOnPage() && indexStudent< studentList.getStudentList().size();
            indexStudent++)
        {
            List<String> s = studentList.getStudentList().get(indexStudent).getSemNumber();
            tableModel.getStudentLastName()[currentIndexLabel].setText(studentList.getStudentList().get(indexStudent).getLastName() + " "
                    + studentList.getStudentList().get(indexStudent).getFirstName().substring(0, 1) + "."
                    + studentList.getStudentList().get(indexStudent).getSurName().substring(0, 1) + ".");
            frame.add(tableModel.getStudentLastName()[currentIndexLabel]);
            tableModel.getStudentGroup()[currentIndexLabel].setText(Integer.toString(studentList.getStudentList().get(indexStudent).getGroup()));
            frame.add(tableModel.getStudentGroup()[currentIndexLabel]);
            for (int indexSem = 0; indexSem < studentList.getMaxNumberOfSemestre(); indexSem++){
                tableModel.getStudentSem()[currentIndexLabel][indexSem].setText(s.get(indexSem));
               frame.add(tableModel.getStudentSem()[currentIndexLabel][indexSem]);}
            currentIndexLabel++;
        }
        frame.repaint();
    }
}
