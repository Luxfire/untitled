import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by user on 11.04.2017.
 */
public class Controller {
    SimpleWindow simpleWindow;
    StudentList studentList;

    Controller() {
        studentList = new StudentList();
        simpleWindow = new SimpleWindow();
               simpleWindow.frameAdd.buttonAdd.addActionListener(new ActionListener() {
                 @Override
                 public void actionPerformed(ActionEvent e) {
                     String[] planWorks = new String[10];
                     planWorks[0] = simpleWindow.frameAdd.textWork1.getText();
                     planWorks[1] = simpleWindow.frameAdd.textWork2.getText();
                     planWorks[2] = simpleWindow.frameAdd.textWork3.getText();
                     planWorks[3] = simpleWindow.frameAdd.textWork4.getText();
                     planWorks[4] = simpleWindow.frameAdd.textWork5.getText();
                     planWorks[5] = simpleWindow.frameAdd.textWork6.getText();
                     planWorks[6] = simpleWindow.frameAdd.textWork7.getText();
                     planWorks[7] = simpleWindow.frameAdd.textWork8.getText();
                     planWorks[8] = simpleWindow.frameAdd.textWork9.getText();
                     planWorks[9] = simpleWindow.frameAdd.textWork10.getText();
                     if (!simpleWindow.frameAdd.textFirstName.getText().isEmpty() && !simpleWindow.frameAdd.textLastName.getText().isEmpty() && !simpleWindow.frameAdd.textSurName.getText().isEmpty() && !simpleWindow.frameAdd.textGroup.getText().isEmpty()) {
                         Student student = new Student(simpleWindow.frameAdd.textLastName.getText(), simpleWindow.frameAdd.textFirstName.getText(), simpleWindow.frameAdd.textSurName.getText(),
                                 Integer.parseInt(simpleWindow.frameAdd.textGroup.getText()), planWorks);
                         studentList.add(student);

                     } else JOptionPane.showMessageDialog(null, "Важные поля не заполнены!!!");
                     updateSimpleWindow();
                     simpleWindow.getFrame().repaint();
                     simpleWindow.frameAdd.frameAdd.setVisible(false);


                 }
             });
               simpleWindow.frameSearch.buttonSearch.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {

                        simpleWindow.frameSearch.inicializedSearchLabel(studentList.studentList.size());
                       int counter =0;
                        simpleWindow.frameSearch.frameSearch.repaint();
                        for (int index = 0; index < studentList.studentList.size(); index++) {

                            if (simpleWindow.frameSearch.group.isSelected()) {
                                if (studentList.studentList.get(index).lastName.equals(simpleWindow.frameSearch.textField1.getText()) &&
                                        studentList.studentList.get(index).group == Integer.parseInt(simpleWindow.frameSearch.textField2.getText())) {
                                    simpleWindow.frameSearch.createSearchResult(counter);
                                    updateSearchResult(counter, index, simpleWindow.frameSearch);
                                    counter++;
                                }
                            }
                            if (simpleWindow.frameSearch.typeWork.isSelected()) {
                                if (studentList.studentList.get(index).lastName.equals(simpleWindow.frameSearch.textField1.getText())) {
                                    for (int numberOfSem = 0; numberOfSem < 10; numberOfSem++)
                                        if (studentList.studentList.get(index).semNumber[numberOfSem].equals(simpleWindow.frameSearch.textField2.getText())) {
                                            simpleWindow.frameSearch.createSearchResult(counter);
                                            updateSearchResult(counter, index, simpleWindow.frameSearch);
                                            counter++;
                                        }
                                }
                            }

                            if (simpleWindow.frameSearch.sumWorks.isSelected()) {
                                int sumsWork = 0;

                                if (studentList.studentList.get(index).lastName.equals(simpleWindow.frameSearch.textField1.getText())) {
                                    for (int numberOfSem = 0; numberOfSem < 10; numberOfSem++)
                                        if (!studentList.studentList.get(index).semNumber[numberOfSem].isEmpty()) {
                                            sumsWork++;
                                        }
                                    if (sumsWork == Integer.parseInt(simpleWindow.frameSearch.textField2.getText())) {
                                        simpleWindow.frameSearch.createSearchResult(counter);
                                        updateSearchResult(counter, index, simpleWindow.frameSearch);
                                        counter++;
                                    }
                                }
                            }
                        }
                        if(counter == 0)
                        JOptionPane.showMessageDialog(null, "Найдено записей не найдено");
                         simpleWindow.frameSearch.cleanSearchWindow(counter);

                    }
                });
               simpleWindow.frameDel.buttonDel.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int counter = 0;
                        for (int index = 0; index < studentList.studentList.size(); index++) {
                            if (simpleWindow.frameDel.group.isSelected()) {

                                if (studentList.studentList.get(index).lastName.equals(simpleWindow.frameDel.textField1.getText()) &&
                                        studentList.studentList.get(index).group == Integer.parseInt(simpleWindow.frameDel.textField2.getText())) {
                                    studentList.studentList.remove(index);
                                    counter++;
                                    index--;
                                }
                            }

                            if (simpleWindow.frameDel.typeWork.isSelected()) {
                                if (studentList.studentList.get(index).lastName.equals(simpleWindow.frameDel.textField1.getText())) {
                                    for (int numberOfSem = 0; numberOfSem < 10; numberOfSem++)
                                        if (studentList.studentList.get(index).semNumber[numberOfSem].equals(simpleWindow.frameDel.textField2.getText())) {

                                            studentList.studentList.remove(index);
                                            counter++;
                                            index--;
                                        }
                                }
                            }

                            if (simpleWindow.frameDel.sumWorks.isSelected()) {
                                int sumsWork = 0;

                                if (studentList.studentList.get(index).lastName.equals(simpleWindow.frameDel.textField1.getText())) {
                                    for (int numberOfSem = 0; numberOfSem < 10; numberOfSem++)
                                        if (!studentList.studentList.get(index).semNumber[numberOfSem].isEmpty()) {
                                            sumsWork++;
                                        }
                                    if (sumsWork == Integer.parseInt(simpleWindow.frameDel.textField2.getText())) {
                                        studentList.studentList.remove(index);
                                        counter++;
                                        index--;
                                    }
                                }
                            }
                        }
                        JOptionPane.showMessageDialog(null, "Удалено записей " + counter);
                        simpleWindow.cleanSimpleWindow();
                        updateSimpleWindow();
                        simpleWindow.getFrame().repaint();
                        studentList.currentPage = 1;
                    }
                });
               simpleWindow.changeNumStudentOnPage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                studentList.studentOnPage= Integer.parseInt(simpleWindow.textNumStudentOnPage.getText());
                simpleWindow.cleanSimpleWindow();
                updateSimpleWindow();
                simpleWindow.getFrame().repaint();
            }
        });
               simpleWindow.buttonNextPage.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        studentList.nextPage();
                        simpleWindow.cleanSimpleWindow();
                        updateSimpleWindow();
                        simpleWindow.getFrame().repaint();
                    }
                });
               simpleWindow.buttonPrevPage.addActionListener(new ActionListener() {
                   @Override
                   public void actionPerformed(ActionEvent e) {
                       studentList.prevPage();
                       simpleWindow.cleanSimpleWindow();
                       updateSimpleWindow();
                       simpleWindow.getFrame().repaint();
                   }
               });
               simpleWindow.buttonLastPage.addActionListener(new ActionListener() {
                   @Override
                   public void actionPerformed(ActionEvent e) {
                       studentList.lastPage();
                       simpleWindow.cleanSimpleWindow();
                       updateSimpleWindow();
                       simpleWindow.getFrame().repaint();
                   }
               });
               simpleWindow.buttonFirstPage.addActionListener(new ActionListener() {
                   @Override
                   public void actionPerformed(ActionEvent e) {
                       studentList.firstPage();
                       simpleWindow.cleanSimpleWindow();
                       updateSimpleWindow();
                       simpleWindow.getFrame().repaint();
                   }
               });
            }

    void updateSearchResult(int counter, int indexStudent, FrameSearch frameSearch) {
        String[] s = studentList.get(indexStudent).semNumber;
            frameSearch.studentLastName[counter].setText(studentList.get(indexStudent).lastName + " " + studentList.get(indexStudent).firstName.substring(0, 1) + "." + studentList.get(indexStudent).surName.substring(0, 1) + ".");
            frameSearch.frameSearch.add(frameSearch.studentLastName[counter]);
            frameSearch.studentGroup[counter].setText(Integer.toString(studentList.get(indexStudent).group));
            frameSearch.frameSearch.add(frameSearch.studentGroup[counter]);
            for (int k = 1; k < 11; k++){
                frameSearch.studentSem[counter][k-1].setText(s[k - 1]);
               frameSearch.frameSearch.add(frameSearch.studentSem[counter][k-1]);}
    }

   void updateSimpleWindow() {
       int currentIndexLabel = 0;
       simpleWindow.pageFromPages.setText("Страница: "+studentList.currentPage+"/"+studentList.getNumberMaxPage());
    for(int indexStudent=studentList.currentPage*studentList.studentOnPage-studentList.studentOnPage;
        indexStudent<studentList.currentPage*studentList.studentOnPage && indexStudent< studentList.studentList.size();
        indexStudent++)
   {
        String[] s = studentList.get(indexStudent).semNumber;
       simpleWindow.studentLastName[currentIndexLabel].setText(studentList.get(indexStudent).lastName + " " + studentList.get(indexStudent).firstName.substring(0, 1) + "." + studentList.get(indexStudent).surName.substring(0, 1) + ".");
       simpleWindow.getFrame().add(simpleWindow.studentLastName[currentIndexLabel]);
       simpleWindow.studentGroup[currentIndexLabel].setText(Integer.toString(studentList.get(indexStudent).group));
       simpleWindow.getFrame().add(simpleWindow.studentGroup[currentIndexLabel]);
       for (int k = 1; k < 11; k++){
           simpleWindow.studentSem[currentIndexLabel][k-1].setText(s[k - 1]);
       simpleWindow.getFrame().add(simpleWindow.studentSem[currentIndexLabel][k-1]);}
       currentIndexLabel++;
   }

   }

}