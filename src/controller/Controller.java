package controller;
import model.*;
import view.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;

/**
 * Created by user on 11.04.2017.
 */
public class Controller {
    MainWindow mainWindow;
    StudentList studentList;
    FileWorker fileWorker;
    StudentList studentSearchList;

    public Controller() {
        studentSearchList = new StudentList();
        studentList = new StudentList();
        mainWindow = new MainWindow(studentList.getMaxNumberOfSemestre());
        fileWorker = new FileWorker(studentList);

               mainWindow.getFrameAddStudent().getButtonAdd().addActionListener(new ActionListener() {
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
             });
               mainWindow.getFrameSearch().getButtonSearch().addActionListener(new ActionListener() {
            int counterStudent =0;
            @Override
            public void actionPerformed(ActionEvent e) {
                mainWindow.getFrameSearch().getSearchTableModel().cleanTableModel(mainWindow.getFrameSearch().getFrameSearch(),studentList.getMaxNumberOfSemestre());
                counterStudent=0;
                studentSearchList.getStudentList().clear();
                mainWindow.getFrameSearch().getSearchTableModel().setCurrentPage(1);
                for (int index = 0; index < studentList.getStudentList().size(); index++) {

                    if (mainWindow.getFrameSearch().getGroup().isSelected()) {
                        if (studentList.getStudentList().get(index).getLastName().equals(mainWindow.getFrameSearch().getTextField1().getText()) &&
                                studentList.getStudentList().get(index).getGroup() == Integer.parseInt(mainWindow.getFrameSearch().getTextField2().getText())) {
                            studentSearchList.add(studentList.getStudentList().get(index));
                            counterStudent++;
                        }
                    }
                    if (mainWindow.getFrameSearch().getTypeWork().isSelected()) {

                        if (studentList.getStudentList().get(index).getLastName().equals(mainWindow.getFrameSearch().getTextField1().getText()))
                        {
                            for (int numberOfSem = 0; numberOfSem < studentList.getMaxNumberOfSemestre(); numberOfSem++){
                                if (studentList.getStudentList().get(index).getSemNumber().get(numberOfSem).equals(mainWindow.getFrameSearch().getTextField2().getText())){
                                    studentSearchList.add(studentList.getStudentList().get(index));
                                    counterStudent++;
                                    break;
                                }
                            }
                        }
                    }

                    if (mainWindow.getFrameSearch().getSumWorks().isSelected()) {
                        int sumsWork = 0;

                        if (studentList.getStudentList().get(index).getLastName().equals(mainWindow.getFrameSearch().getTextField1().getText())) {

                            for (int numberOfSem = 0; numberOfSem <studentList.getMaxNumberOfSemestre(); numberOfSem++)
                                if (!studentList.getStudentList().get(index).getSemNumber().get(numberOfSem).equals(" "))
                                    sumsWork++;
                            if (sumsWork == Integer.parseInt(mainWindow.getFrameSearch().getTextField2().getText())) {
                                studentSearchList.add(studentList.getStudentList().get(index));
                                counterStudent++;
                            }
                        }
                    }
                }
                if(counterStudent == 0)
                    JOptionPane.showMessageDialog(null, "Записей не найдено");
                updateSearchResult();
                mainWindow.getFrameSearch().getFrameSearch().repaint();


            }
        });
               mainWindow.getFrameDel().getButtonDel().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int counterStudent = 0;
                for (int index = 0; index < studentList.getStudentList().size(); index++) {
                    if (mainWindow.getFrameDel().getGroup().isSelected()) {

                        if (studentList.getStudentList().get(index).getLastName().equals(mainWindow.getFrameDel().getTextField1().getText()) &&
                                studentList.getStudentList().get(index).getGroup() == Integer.parseInt(mainWindow.getFrameDel().getTextField2().getText())) {
                            studentList.getStudentList().remove(index);
                            counterStudent++;
                            index--;
                            if(index<0) index=0;
                        }
                    }

                    if (mainWindow.getFrameDel().getTypeWork().isSelected()) {
                        if (studentList.getStudentList().get(index).getLastName().equals(mainWindow.getFrameDel().getTextField1().getText())) {
                            for (int numberOfSem = 0; numberOfSem < studentList.getMaxNumberOfSemestre(); numberOfSem++)
                                if (studentList.getStudentList().get(index).getSemNumber().get(numberOfSem).equals(mainWindow.getFrameDel().getTextField2().getText())) {

                                    studentList.getStudentList().remove(index);
                                    counterStudent++;
                                    index--;
                                    if(index<0) index=0;
                                }
                        }
                    }

                    if (mainWindow.getFrameDel().getSumWorks().isSelected()) {
                        int sumsWork = 0;

                        if (studentList.getStudentList().get(index).getLastName().equals(mainWindow.getFrameDel().getTextField1().getText())) {
                            for (int numberOfSem = 0; numberOfSem < studentList.getMaxNumberOfSemestre(); numberOfSem++)
                                if (!studentList.getStudentList().get(index).getSemNumber().get(numberOfSem).isEmpty()) {
                                    sumsWork++;
                                }
                            if (sumsWork == Integer.parseInt(mainWindow.getFrameDel().getTextField2().getText())) {
                                studentList.getStudentList().remove(index);
                                counterStudent++;
                                index--;
                                if(index<0) index=0;
                            }
                        }
                    }
                }
                JOptionPane.showMessageDialog(null, "Удалено записей " + counterStudent);
                mainWindow.getTableModel().cleanTableModel(mainWindow.getFrame(),studentList.getMaxNumberOfSemestre());
                updateSimpleWindow();
                mainWindow.getFrame().repaint();
                mainWindow.getTableModel().setCurrentPage(1);
                mainWindow.getFrameDel().getFrameDel().setVisible(false);
            }
        });

               mainWindow.getTableModel().getButtonNextPage().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainWindow.getTableModel().nextPage(studentList.getStudentList().size());
                mainWindow.getTableModel().cleanTableModel(mainWindow.getFrame(),studentList.getMaxNumberOfSemestre());
                updateSimpleWindow();
                mainWindow.getFrame().repaint();
            }
        });
               mainWindow.getTableModel().getButtonPrevPage().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainWindow.getTableModel().prevPage();
                mainWindow.getTableModel().cleanTableModel(mainWindow.getFrame(),studentList.getMaxNumberOfSemestre());
                updateSimpleWindow();
                mainWindow.getFrame().repaint();
            }
        });
               mainWindow.getTableModel().getButtonLastPage().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainWindow.getTableModel().lastPage(studentList.getStudentList().size());
                mainWindow.getTableModel().cleanTableModel(mainWindow.getFrame(),studentList.getMaxNumberOfSemestre());
                updateSimpleWindow();
                mainWindow.getFrame().repaint();
            }
        });
               mainWindow.getTableModel().getButtonFirstPage().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainWindow.getTableModel().firstPage();
                mainWindow.getTableModel().cleanTableModel(mainWindow.getFrame(),studentList.getMaxNumberOfSemestre());
                updateSimpleWindow();
                mainWindow.getFrame().repaint();
            }
        });
               mainWindow.getTableModel().getChangeNumStudentOnPage().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(Integer.parseInt(mainWindow.getTableModel().getTextNumStudentOnPage().getText())<mainWindow.getTableModel().getMaxStudentOnPage()+1){
                    mainWindow.getTableModel().setStudentOnPage(Integer.parseInt(mainWindow.getTableModel().getTextNumStudentOnPage().getText()));
                    mainWindow.getTableModel().cleanTableModel(mainWindow.getFrame(),studentList.getMaxNumberOfSemestre());
                    updateSimpleWindow();
                    mainWindow.getFrame().repaint();}
            }
        });

               mainWindow.getFrameSearch().getSearchTableModel().getChangeNumStudentOnPage().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(Integer.parseInt(mainWindow.getFrameSearch().getSearchTableModel().getTextNumStudentOnPage().getText())<mainWindow.getFrameSearch().getSearchTableModel().getMaxStudentOnPage()){
                    mainWindow.getFrameSearch().getSearchTableModel().setStudentOnPage(Integer.parseInt(mainWindow.getFrameSearch().getSearchTableModel().getTextNumStudentOnPage().getText()));
                    mainWindow.getFrameSearch().getSearchTableModel().cleanTableModel(mainWindow.getFrameSearch().getFrameSearch(),studentList.getMaxNumberOfSemestre());
                    updateSearchResult();
                    mainWindow.getFrameSearch().getFrameSearch().repaint();}
            }
        });
               mainWindow.getFrameSearch().getSearchTableModel().getButtonNextPage().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainWindow.getFrameSearch().getSearchTableModel().nextPage(studentSearchList.getStudentList().size());
                mainWindow.getFrameSearch().getSearchTableModel().cleanTableModel(mainWindow.getFrameSearch().getFrameSearch(),studentList.getMaxNumberOfSemestre());
                updateSearchResult();
                mainWindow.getFrameSearch().getFrameSearch().repaint();
            }
        });
               mainWindow.getFrameSearch().getSearchTableModel().getButtonPrevPage().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainWindow.getFrameSearch().getSearchTableModel().prevPage();
                mainWindow.getFrameSearch().getSearchTableModel().cleanTableModel(mainWindow.getFrameSearch().getFrameSearch(),studentList.getMaxNumberOfSemestre());
                updateSearchResult();
                mainWindow.getFrameSearch().getFrameSearch().repaint();
            }
        });
               mainWindow.getFrameSearch().getSearchTableModel().getButtonLastPage().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainWindow.getFrameSearch().getSearchTableModel().lastPage(studentSearchList.getStudentList().size());
                mainWindow.getFrameSearch().getSearchTableModel().cleanTableModel(mainWindow.getFrameSearch().getFrameSearch(),studentList.getMaxNumberOfSemestre());
                updateSearchResult();
                mainWindow.getFrameSearch().getFrameSearch().repaint();
            }
        });
               mainWindow.getFrameSearch().getSearchTableModel().getButtonFirstPage().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainWindow.getFrameSearch().getSearchTableModel().firstPage();
                mainWindow.getFrameSearch().getSearchTableModel().cleanTableModel(mainWindow.getFrameSearch().getFrameSearch(),studentList.getMaxNumberOfSemestre());
                updateSearchResult();
                mainWindow.getFrameSearch().getFrameSearch().repaint();
            }
        });

               mainWindow.saveFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fileWorker.saveFile();
            }
        });
               mainWindow.openFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fileWorker.openFile();
                mainWindow.getTableModel().cleanTableModel(mainWindow.getFrame(),studentList.getMaxNumberOfSemestre());
                updateSimpleWindow();
                mainWindow.getFrame().repaint();
            }
        });
            }

    void updateSearchResult() {
      int currentIndexLabel = 0;
      mainWindow.getFrameSearch().getSearchTableModel().getPageFromPages().setText("Страница: "+mainWindow.getFrameSearch().getSearchTableModel().getCurrentPage()+"/"+mainWindow.getFrameSearch().getSearchTableModel().getNumberMaxPage(studentSearchList.getStudentList().size()));
      for(int indexStudent=mainWindow.getFrameSearch().getSearchTableModel().getCurrentPage()*mainWindow.getFrameSearch().getSearchTableModel().getStudentOnPage()-mainWindow.getFrameSearch().getSearchTableModel().getStudentOnPage();
          indexStudent<mainWindow.getFrameSearch().getSearchTableModel().getCurrentPage()*mainWindow.getFrameSearch().getSearchTableModel().getStudentOnPage() && indexStudent< studentSearchList.getStudentList().size();
          indexStudent++)
      {
          List<String> s = studentSearchList.getStudentList().get(indexStudent).getSemNumber();
          mainWindow.getFrameSearch().getSearchTableModel().getStudentLastName()[currentIndexLabel].setText(studentSearchList.getStudentList().get(indexStudent).getLastName() + " "
                  + studentSearchList.getStudentList().get(indexStudent).getFirstName().substring(0, 1) + "."
                  + studentSearchList.getStudentList().get(indexStudent).getSurName().substring(0, 1) + ".");
          mainWindow.getFrameSearch().getFrameSearch().add(mainWindow.getFrameSearch().getSearchTableModel().getStudentLastName()[currentIndexLabel]);
          mainWindow.getFrameSearch().getSearchTableModel().getStudentGroup()[currentIndexLabel].setText(Integer.toString(studentSearchList.getStudentList().get(indexStudent).getGroup()));
          mainWindow.getFrameSearch().getFrameSearch().add(mainWindow.getFrameSearch().getSearchTableModel().getStudentGroup()[currentIndexLabel]);
          for (int indexSem = 0; indexSem < studentList.getMaxNumberOfSemestre(); indexSem++){
              mainWindow.getFrameSearch().getSearchTableModel().getStudentSem()[currentIndexLabel][indexSem].setText(s.get(indexSem));
              mainWindow.getFrameSearch().getFrameSearch().add(mainWindow.getFrameSearch().getSearchTableModel().getStudentSem()[currentIndexLabel][indexSem]);}
          currentIndexLabel++;
      }

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