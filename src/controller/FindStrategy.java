package controller;

import model.StudentList;
import view.FrameSearchDel;
import view.MainWindow;

import javax.swing.*;

/**
 * Created by user on 09.05.2017.
 */
public class FindStrategy {
    private FrameSearchDel frameSearchDel;
    private MainWindow mainWindow;
    private StudentList studentList;
    private StudentList studentSearchList;

   public FindStrategy(MainWindow mainWindow, StudentList studentList, StudentList studentSearchList)
    {
        this.mainWindow =mainWindow;
        this.studentList = studentList;
        this.studentSearchList =studentSearchList;
    }

    public void findStrategy(int numberFrame)
    {      int counter=0;
            int strategy = 0;
            if(numberFrame ==1)frameSearchDel=mainWindow.getFrameSearch().getFrameSearchDel();
            else frameSearchDel=mainWindow.getFrameDel().getFrameSearchDel();

        if(!frameSearchDel.getTextFieldFio1().getText().equals("")) counter++;
        if(!frameSearchDel.getTextField1().getText().equals("")) counter++;
        if(!frameSearchDel.getTextField2().getText().equals("")) counter++;
        if(!frameSearchDel.getTextField3().getText().equals("")) counter++;

            if (!frameSearchDel.getTextFieldFio1().getText().equals(""))
            {
            if (!frameSearchDel.getTextField1().getText().equals("")) strategy= 1;
            if (!frameSearchDel.getTextField2().getText().equals("")) strategy= 2;
            if (!frameSearchDel.getTextField3().getText().equals("")) strategy= 3;
            }
            else strategy =6;
        if (counter<2) strategy = 5;
        if (counter>2) strategy = 4;
        
            compliteStrategy(strategy,numberFrame);
    }

    public void compliteStrategy(int strategy,int numberFrame)
    {   int counterStudent=0;
        for (int index = 0; index < studentList.getStudentList().size(); index++)
        {

            if (strategy==1)
            {
                if (studentList.getStudentList().get(index).getLastName().equals(frameSearchDel.getTextFieldFio1().getText()) &&
                        studentList.getStudentList().get(index).getGroup() == Integer.parseInt(frameSearchDel.getTextField1().getText())) {
                    if(numberFrame == 1) search(index);
                    else {del(index);
                    index--;}
                    counterStudent++;
                }
            }

            if (strategy==2) {
                if (studentList.getStudentList().get(index).getLastName().equals(frameSearchDel.getTextFieldFio1().getText()))
                {
                    for (int numberOfSem = 0; numberOfSem < studentList.getMaxNumberOfSemestre(); numberOfSem++){
                        if (studentList.getStudentList().get(index).getSemNumber().get(numberOfSem).equals(frameSearchDel.getTextField2().getText())){
                            if(numberFrame == 1) search(index);
                            else{ del(index);
                            index--;}
                                counterStudent++;
                            break;
                        }
                    }
                }
            }

            if (strategy==3) {
                int sumsWork = 0;

                if (studentList.getStudentList().get(index).getLastName().equals(frameSearchDel.getTextFieldFio1().getText())) {

                    for (int numberOfSem = 0; numberOfSem <studentList.getMaxNumberOfSemestre(); numberOfSem++)
                        if (!studentList.getStudentList().get(index).getSemNumber().get(numberOfSem).equals(" "))
                            sumsWork++;
                    if (sumsWork == Integer.parseInt(frameSearchDel.getTextField3().getText())) {
                        if(numberFrame == 1) search(index);
                        else {del(index);
                        index--;}
                            counterStudent++;
                    }
                }
            }

        }
      if(numberFrame ==1){
        if(strategy==4) JOptionPane.showMessageDialog(null, "Введено больше двух параметров");
        if(strategy==5) JOptionPane.showMessageDialog(null, "Введено меньше двух параметров");
        if(strategy==6) JOptionPane.showMessageDialog(null, "Фамилия не введена");
        if(counterStudent == 0)
            JOptionPane.showMessageDialog(null, "Записей не найдено");}
        if(numberFrame==2)
                   JOptionPane.showMessageDialog(null, "Записей удалено "+counterStudent);



    }

    void del(int index)
    {
        studentList.getStudentList().remove(index);
    }
    void search(int index)
    {
        studentSearchList.add(studentList.getStudentList().get(index));
    }
}
