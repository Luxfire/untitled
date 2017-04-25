import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by user on 11.04.2017.
 */
public class Controller {
    SimpleWindow simpleWindow;
    StudentList studentList;
    JLabel studentLastName[] = new JLabel[5];
    JLabel studentGroup[] = new JLabel[5];
    JLabel studentSem[][] = new JLabel[5][10];

    Controller() {
        studentList = new StudentList();
        simpleWindow = new SimpleWindow();
          createSimpleWindow();
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
                        int counter = 0;
                        simpleWindow.frameSearch.frameSearch.repaint();
                        for (int index = 0; index < studentList.studentList.size(); index++) {

                            if (simpleWindow.frameSearch.group.isSelected()) {
                                if (studentList.studentList.get(index).lastName.equals(simpleWindow.frameSearch.textField1.getText()) &&
                                        studentList.studentList.get(index).group == Integer.parseInt(simpleWindow.frameSearch.textField2.getText())) {
                                    updateSearchResult(counter, index, simpleWindow.frameSearch.frameSearch);
                                    counter++;
                                }
                            }
                            if (simpleWindow.frameSearch.typeWork.isSelected()) {
                                if (studentList.studentList.get(index).lastName.equals(simpleWindow.frameSearch.textField1.getText())) {
                                    for (int numberOfSem = 0; numberOfSem < 10; numberOfSem++)
                                        if (studentList.studentList.get(index).semNumber[numberOfSem].equals(simpleWindow.frameSearch.textField2.getText())) {

                                            updateSearchResult(counter, index, simpleWindow.frameSearch.frameSearch);
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
                                        updateSearchResult(counter, index, simpleWindow.frameSearch.frameSearch);
                                        counter++;
                                    }
                                }
                            }
                        }
                        if (counter > 0) simpleWindow.frameSearch.frameSearch.setVisible(true);
                        JOptionPane.showMessageDialog(null, "Найдено записей " + counter);
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
                        cleanSimpleWindow();
                        updateSimpleWindow();
                        simpleWindow.getFrame().repaint();
                    }
                });
            }

    void updateSearchResult(int counter, int index, JFrame frameSearch) {
        String[] s = studentList.get(index).semNumber;
        JLabel studentLastNameSearch = new JLabel();
        studentLastNameSearch.setBorder(BorderFactory.createEtchedBorder());
        studentLastNameSearch.setSize(200, 30);
        studentLastNameSearch.setLocation(0, counter * 30 + 220);
        studentLastNameSearch.setText(studentList.get(index).lastName + " " + studentList.get(index).firstName.substring(0, 1) + "." + studentList.get(index).surName.substring(0, 1) + ".");
        frameSearch.add(studentLastNameSearch);


        JLabel studentGroupSearch = new JLabel();
        studentGroupSearch.setBorder(BorderFactory.createEtchedBorder());
        studentGroupSearch.setSize(100, 30);
        studentGroupSearch.setLocation(200, counter * 30 + 220);
        studentGroupSearch.setText(Integer.toString(studentList.get(index).group));
        frameSearch.add(studentGroupSearch);

        for (int k = 1; k < 11; k++) {
            int x = 170;
            JLabel studentSemSearch = new JLabel();
            studentSemSearch.setBorder(BorderFactory.createEtchedBorder());
            studentSemSearch.setSize(130, 30);
            studentSemSearch.setLocation(x + k * 130, counter * 30 + 220);
            studentSemSearch.setText(s[k - 1]);
            frameSearch.add(studentSemSearch);
        }

    }

   void updateSimpleWindow()
   {

    for(int indexStudent=0;indexStudent<studentList.studentList.size();indexStudent++)
   {    String[] s = studentList.get(indexStudent).semNumber;
       studentLastName[indexStudent].setText(studentList.get(indexStudent).lastName + " " + studentList.get(indexStudent).firstName.substring(0, 1) + "." + studentList.get(indexStudent).surName.substring(0, 1) + ".");
       simpleWindow.getFrame().add(studentLastName[indexStudent]);
       studentGroup[indexStudent].setText(Integer.toString(studentList.get(indexStudent).group));
       simpleWindow.getFrame().add(studentGroup[indexStudent]);
       for (int k = 1; k < 11; k++){
           studentSem[indexStudent][k-1].setText(s[k - 1]);
       simpleWindow.getFrame().add(studentSem[indexStudent][k-1]);}
   }

   }

    void cleanSimpleWindow()
    {
        for(int indexStudent=0;indexStudent<5;indexStudent++){
         //   studentLastName[indexStudent].setText("");
         simpleWindow.getFrame().remove(studentLastName[indexStudent]);
            simpleWindow.getFrame().remove(studentGroup[indexStudent]);
           // studentGroup[indexStudent].setText("");
            for (int k = 1; k < 11; k++)
                simpleWindow.getFrame().remove(studentSem[indexStudent][k-1]);
              //  studentSem[indexStudent][k-1].setText("");
        }
    }

    void createSimpleWindow() {
        for (int indexStudent = 0; indexStudent < 5; indexStudent++) {
            studentLastName[indexStudent]= new JLabel();
            studentLastName[indexStudent].setBorder(BorderFactory.createEtchedBorder());
            studentLastName[indexStudent].setSize(200, 30);
            studentLastName[indexStudent].setLocation(0, indexStudent * 30 + 30);

            studentGroup[indexStudent] = new JLabel();
            studentGroup[indexStudent].setBorder(BorderFactory.createEtchedBorder());
            studentGroup[indexStudent].setSize(100, 30);
            studentGroup[indexStudent].setLocation(200, indexStudent * 30 + 30);

            for (int k = 1; k < 11; k++) {
                int x = 170;
                studentSem[indexStudent][k-1]= new JLabel();
                studentSem[indexStudent][k-1].setBorder(BorderFactory.createEtchedBorder());
                studentSem[indexStudent][k-1].setSize(130, 30);
                studentSem[indexStudent][k-1].setLocation(x + k * 130, indexStudent * 30 + 30);
            }
        }

    }

}