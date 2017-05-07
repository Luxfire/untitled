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

    public Controller() {
        studentList = new StudentList();
        mainWindow = new MainWindow();
        fileWorker = new FileWorker(studentList);

               mainWindow.getFrameAddStudent().getButtonAdd().addActionListener(new ActionListener() {
                 @Override
                 public void actionPerformed(ActionEvent e) {
                   List<String> planWorks = new ArrayList<>();
                     planWorks.add(mainWindow.getFrameAddStudent().getTextWork1().getText());
                     planWorks.add(mainWindow.getFrameAddStudent().getTextWork2().getText());
                     planWorks.add(mainWindow.getFrameAddStudent().getTextWork3().getText());
                     planWorks.add(mainWindow.getFrameAddStudent().getTextWork4().getText());
                     planWorks.add(mainWindow.getFrameAddStudent().getTextWork5().getText());
                     planWorks.add(mainWindow.getFrameAddStudent().getTextWork6().getText());
                     planWorks.add(mainWindow.getFrameAddStudent().getTextWork7().getText());
                     planWorks.add(mainWindow.getFrameAddStudent().getTextWork8().getText());
                     planWorks.add(mainWindow.getFrameAddStudent().getTextWork9().getText());
                     planWorks.add(mainWindow.getFrameAddStudent().getTextWork10().getText());

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
                        mainWindow.getFrameSearch().cleanSearchWindow(counterStudent);
                        counterStudent=0;
                        mainWindow.getFrameSearch().inicializedSearchLabel(studentList.getStudentList().size());

                        for (int index = 0; index < studentList.getStudentList().size(); index++) {

                            if (mainWindow.getFrameSearch().getGroup().isSelected()) {
                                if (studentList.getStudentList().get(index).getLastName().equals(mainWindow.getFrameSearch().getTextField1().getText()) &&
                                        studentList.getStudentList().get(index).getGroup() == Integer.parseInt(mainWindow.getFrameSearch().getTextField2().getText())) {
                                     mainWindow.getFrameSearch().createSearchResult(counterStudent);
                                    updateSearchResult(counterStudent, index, mainWindow.getFrameSearch());
                                    counterStudent++;
                                }
                            }
                            if (mainWindow.getFrameSearch().getTypeWork().isSelected()) {
                                if (studentList.getStudentList().get(index).getLastName().equals(mainWindow.getFrameSearch().getTextField1().getText())) {
                                    for (int numberOfSem = 0; numberOfSem < 10; numberOfSem++)
                                        if (studentList.getStudentList().get(index).getSemNumber().get(numberOfSem).equals(mainWindow.getFrameSearch().getTextField2().getText())) {
                                            mainWindow.getFrameSearch().createSearchResult(counterStudent);
                                            updateSearchResult(counterStudent, index, mainWindow.getFrameSearch());
                                            counterStudent++;
                                        }
                                }
                            }

                            if (mainWindow.getFrameSearch().getSumWorks().isSelected()) {
                                int sumsWork = 0;

                                if (studentList.getStudentList().get(index).getLastName().equals(mainWindow.getFrameSearch().getTextField1().getText())) {
                                    for (int numberOfSem = 0; numberOfSem < 10; numberOfSem++)
                                        if (!studentList.getStudentList().get(index).getSemNumber().get(numberOfSem).isEmpty()) {
                                            sumsWork++;
                                        }
                                    if (sumsWork == Integer.parseInt(mainWindow.getFrameSearch().getTextField2().getText())) {
                                        mainWindow.getFrameSearch().createSearchResult(counterStudent);
                                        updateSearchResult(counterStudent, index, mainWindow.getFrameSearch());
                                        counterStudent++;
                                    }
                                }
                            }
                        }
                        if(counterStudent == 0)
                        JOptionPane.showMessageDialog(null, "Записей не найдено");

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
                                }
                            }

                            if (mainWindow.getFrameDel().getTypeWork().isSelected()) {
                                if (studentList.getStudentList().get(index).getLastName().equals(mainWindow.getFrameDel().getTextField1().getText())) {
                                    for (int numberOfSem = 0; numberOfSem < 10; numberOfSem++)
                                        if (studentList.getStudentList().get(index).getSemNumber().get(numberOfSem).equals(mainWindow.getFrameDel().getTextField2().getText())) {

                                            studentList.getStudentList().remove(index);
                                            counterStudent++;
                                            index--;
                                        }
                                }
                            }

                            if (mainWindow.getFrameDel().getSumWorks().isSelected()) {
                                int sumsWork = 0;

                                if (studentList.getStudentList().get(index).getLastName().equals(mainWindow.getFrameDel().getTextField1().getText())) {
                                    for (int numberOfSem = 0; numberOfSem < 10; numberOfSem++)
                                        if (!studentList.getStudentList().get(index).getSemNumber().get(numberOfSem).isEmpty()) {
                                            sumsWork++;
                                        }
                                    if (sumsWork == Integer.parseInt(mainWindow.getFrameDel().getTextField2().getText())) {
                                        studentList.getStudentList().remove(index);
                                        counterStudent++;
                                        index--;
                                    }
                                }
                            }
                        }
                        JOptionPane.showMessageDialog(null, "Удалено записей " + counterStudent);
                        mainWindow.cleanSimpleWindow();
                        updateSimpleWindow();
                        mainWindow.getFrame().repaint();
                        studentList.setCurrentPage(1);
                        mainWindow.getFrameDel().getFrameDel().setVisible(false);
                    }
                });
               mainWindow.getChangeNumStudentOnPage().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(Integer.parseInt(mainWindow.getTextNumStudentOnPage().getText())<6){
                studentList.setStudentOnPage(Integer.parseInt(mainWindow.getTextNumStudentOnPage().getText()));
                mainWindow.cleanSimpleWindow();
                updateSimpleWindow();
                mainWindow.getFrame().repaint();}
            }
        });
               mainWindow.getButtonNextPage().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        studentList.nextPage();
                        mainWindow.cleanSimpleWindow();
                        updateSimpleWindow();
                        mainWindow.getFrame().repaint();
                    }
                });
               mainWindow.getButtonPrevPage().addActionListener(new ActionListener() {
                   @Override
                   public void actionPerformed(ActionEvent e) {
                       studentList.prevPage();
                       mainWindow.cleanSimpleWindow();
                       updateSimpleWindow();
                       mainWindow.getFrame().repaint();
                   }
               });
               mainWindow.getButtonLastPage().addActionListener(new ActionListener() {
                   @Override
                   public void actionPerformed(ActionEvent e) {
                       studentList.lastPage();
                       mainWindow.cleanSimpleWindow();
                       updateSimpleWindow();
                       mainWindow.getFrame().repaint();
                   }
               });
               mainWindow.getButtonFirstPage().addActionListener(new ActionListener() {
                   @Override
                   public void actionPerformed(ActionEvent e) {
                       studentList.firstPage();
                       mainWindow.cleanSimpleWindow();
                       updateSimpleWindow();
                       mainWindow.getFrame().repaint();
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
                       mainWindow.cleanSimpleWindow();
                       updateSimpleWindow();
                       mainWindow.getFrame().repaint();
                   }
               });
            }


  void updateSearchResult(int counter, int index, FrameSearch frameSearch) {
      List<String> s = studentList.getStudentList().get(index).getSemNumber();

      frameSearch.getStudentLastName()[counter].setText(studentList.getStudentList().get(index).getLastName() + " "
              + studentList.getStudentList().get(index).getFirstName().substring(0, 1) + "."
              + studentList.getStudentList().get(index).getSurName().substring(0, 1) + ".");
      frameSearch.getPanel().add(frameSearch.getStudentLastName()[counter]);

      frameSearch.getStudentGroup()[counter].setText(Integer.toString(studentList.getStudentList().get(index).getGroup()));
      frameSearch.getPanel().add(frameSearch.getStudentGroup()[counter]);
      for (int k = 1; k < 11; k++) {
          frameSearch.getStudentSem()[counter][k-1].setText(s.get(k - 1));
          frameSearch.getPanel().add(frameSearch.getStudentSem()[counter][k-1]);

      }



  }
    void updateSimpleWindow() {
       int currentIndexLabel = 0;
       mainWindow.getPageFromPages().setText("Страница: "+studentList.getCurrentPage()+"/"+studentList.getNumberMaxPage());
    for(int indexStudent=studentList.getCurrentPage()*studentList.getStudentOnPage()-studentList.getStudentOnPage();
        indexStudent<studentList.getCurrentPage()*studentList.getStudentOnPage() && indexStudent< studentList.getStudentList().size();
        indexStudent++)
   {
       List<String> s = studentList.getStudentList().get(indexStudent).getSemNumber();
       mainWindow.getStudentLastName()[currentIndexLabel].setText(studentList.getStudentList().get(indexStudent).getLastName() + " "
               + studentList.getStudentList().get(indexStudent).getFirstName().substring(0, 1) + "."
               + studentList.getStudentList().get(indexStudent).getSurName().substring(0, 1) + ".");
       mainWindow.getFrame().add(mainWindow.getStudentLastName()[currentIndexLabel]);
       mainWindow.getStudentGroup()[currentIndexLabel].setText(Integer.toString(studentList.getStudentList().get(indexStudent).getGroup()));
       mainWindow.getFrame().add(mainWindow.getStudentGroup()[currentIndexLabel]);
       for (int k = 1; k < 11; k++){
          mainWindow.getStudentSem()[currentIndexLabel][k-1].setText(s.get(k - 1));
           mainWindow.getFrame().add(mainWindow.getStudentSem()[currentIndexLabel][k-1]);}
       currentIndexLabel++;
   }

   }

}