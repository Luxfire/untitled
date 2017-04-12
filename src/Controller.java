import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by user on 11.04.2017.
 */
public class Controller {
    SimpleWindow simpleWindow;
    StudentList studentList;

    Controller()
    {
    studentList = new StudentList();
        simpleWindow= new SimpleWindow();
        simpleWindow.buttonAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                FrameAdd frameAdd = new FrameAdd(studentList,simpleWindow);
                frameAdd.buttonAdd.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String[] planWorks = new String[10];
                        planWorks[0] = frameAdd.textWork1.getText();
                        planWorks[1] = frameAdd.textWork2.getText();
                        planWorks[2] = frameAdd.textWork3.getText();
                        planWorks[3] = frameAdd.textWork4.getText();
                        planWorks[4] = frameAdd.textWork5.getText();
                        planWorks[5] = frameAdd.textWork6.getText();
                        planWorks[6] = frameAdd.textWork7.getText();
                        planWorks[7] = frameAdd.textWork8.getText();
                        planWorks[8] = frameAdd.textWork9.getText();
                        planWorks[9] = frameAdd.textWork10.getText();
                        if(!frameAdd.textFirstName.getText().isEmpty()&& !frameAdd.textLastName.getText().isEmpty()&&!frameAdd.textSurName.getText().isEmpty()&&!frameAdd.textGroup.getText().isEmpty()) {
                            Student student = new Student(frameAdd.textLastName.getText(),frameAdd. textFirstName.getText(), frameAdd.textSurName.getText(),
                                    Integer.parseInt(frameAdd.textGroup.getText()), planWorks);
                            studentList.add(student);
                            simpleWindow.getFrame().repaint();
                            frameAdd.frameAdd.dispose();
                        }
                        else JOptionPane.showMessageDialog(null, "Важные поля не заполнены!!!");

                        update();
                    }
                });
            }
        });

        simpleWindow.buttonSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrameSearch frameSearch = new FrameSearch();

                frameSearch.buttonSearch.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                    FrameSearchResult frameSearchResult = new FrameSearchResult();
                    int counter = 0;
                        for (int index =0; index<studentList.studentList.size();index++) {
                        if(frameSearch.group.isSelected())
                        {
                            if (studentList.studentList.get(index).lastName.equals(frameSearch.textField1.getText())&&
                          studentList.studentList.get(index).group==Integer.parseInt(frameSearch.textField2.getText()))
                            {
                                updateSearchResult(counter,index,frameSearchResult);
                                counter++;
                            }
                        }
                        if(frameSearch.typeWork.isSelected())
                            {
                                if(studentList.studentList.get(index).lastName.equals(frameSearch.textField1.getText())) {
                                    for (int numberOfSem = 0; numberOfSem < 10; numberOfSem++)
                                        if (studentList.studentList.get(index).semNumber[numberOfSem].equals(frameSearch.textField2.getText())) {

                                            updateSearchResult(counter,index,frameSearchResult);
                                            counter++;
                                            break;
                                        }
                                }
                            }

                            if(frameSearch.sumWorks.isSelected())
                            {int sumsWork=0;

                               if(studentList.studentList.get(index).lastName.equals(frameSearch.textField1.getText()))
                                {
                                    for (int numberOfSem = 0; numberOfSem < 10; numberOfSem++)
                                        if (!studentList.studentList.get(index).semNumber[numberOfSem].isEmpty()) {
                                           sumsWork++;
                                        }
                                        if(sumsWork == Integer.parseInt(frameSearch.textField2.getText()))
                                        {
                                            updateSearchResult(counter,index,frameSearchResult);
                                            counter++;
                                        }
                                }
                            }
                        }
                        if(counter >0) frameSearchResult.frame.setVisible(true);
                        JOptionPane.showMessageDialog(null, "Найдено записей "+counter);
                    }
                });
            }
        });



        simpleWindow.buttonDel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrameDel frameDel = new FrameDel();
                frameDel.buttonDel.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int counter = 0;
                        for (int index =0; index<studentList.studentList.size();index++) {
                            if(frameDel.group.isSelected())
                            {
                                if (studentList.studentList.get(index).lastName.equals(frameDel.textField1.getText())&&
                                        studentList.studentList.get(index).group==Integer.parseInt(frameDel.textField2.getText()))
                                {
                                    studentList.studentList.remove(index);
                                    update();
                                    counter++;
                                }
                            }
                            if(frameDel.typeWork.isSelected())
                            {
                                if(studentList.studentList.get(index).lastName.equals(frameDel.textField1.getText())) {
                                    for (int numberOfSem = 0; numberOfSem < 10; numberOfSem++)
                                        if (studentList.studentList.get(index).semNumber[numberOfSem].equals(frameDel.textField2.getText())) {

                                            studentList.studentList.remove(index);
                                            update();
                                            counter++;
                                            break;
                                        }
                                }
                            }

                            if(frameDel.sumWorks.isSelected())
                            {int sumsWork=0;

                                if(studentList.studentList.get(index).lastName.equals(frameDel.textField1.getText()))
                                {
                                    for (int numberOfSem = 0; numberOfSem < 10; numberOfSem++)
                                        if (!studentList.studentList.get(index).semNumber[numberOfSem].isEmpty()) {
                                            sumsWork++;
                                        }
                                    if(sumsWork == Integer.parseInt(frameDel.textField2.getText()))
                                    {
                                        studentList.studentList.remove(index);
                                        update();
                                        counter++;
                                    }
                                }
                            }
                        }
                        JOptionPane.showMessageDialog(null, "Удалено записей "+counter);
                    }
                });
            }
        });
    }
    void updateSearchResult(int counter, int index,FrameSearchResult frame)
    {
            String[] s = studentList.get(index).semNumber;
            JLabel studentLastName = new JLabel();
            studentLastName.setBorder(BorderFactory.createEtchedBorder());
            studentLastName.setSize(100, 30);
            studentLastName.setLocation(0, counter*30+30);
            studentLastName.setText(studentList.get(index).lastName+" "+studentList.get(index).firstName.substring(0,1)+"."+studentList.get(index).surName.substring(0,1)+".");
            frame.frame.add(studentLastName);


            JLabel studentGroup = new JLabel();
            studentGroup.setBorder(BorderFactory.createEtchedBorder());
            studentGroup.setSize(100, 30);
            studentGroup.setLocation(100,counter*30+30 );
            studentGroup.setText(Integer.toString(studentList.get(index).group));
            frame.frame.add(studentGroup);

            for(int k=1; k<11;k++)
            {    int x=100;
                JLabel studentSem = new JLabel();
                studentSem.setBorder(BorderFactory.createEtchedBorder());
                studentSem.setSize(100, 30);
                studentSem.setLocation(x+k*100,counter*30+30);
                studentSem.setText(s[k-1]);
                frame.frame.add(studentSem);
            }


    }

     void update()
    {  simpleWindow.panel.repaint();
        for(int i =0; i<studentList.studentList.size();i++) {
            String[] s = studentList.get(i).semNumber;
            JLabel studentLastName = new JLabel();
            studentLastName.setBorder(BorderFactory.createEtchedBorder());
            studentLastName.setSize(100, 30);
            studentLastName.setLocation(0, i*30+30);
            studentLastName.setText(studentList.get(i).lastName+" "+studentList.get(i).firstName.substring(0,1)+"."+studentList.get(i).surName.substring(0,1)+".");
            simpleWindow.getFrame().add(studentLastName);

            JLabel studentGroup = new JLabel();
            studentGroup.setBorder(BorderFactory.createEtchedBorder());
            studentGroup.setSize(100, 30);
            studentGroup.setLocation(100,i*30+30 );
            studentGroup.setText(Integer.toString(studentList.get(i).group));
            simpleWindow.getFrame().add(studentGroup);

            for(int k=1; k<11;k++)
            {    int x=100;
                JLabel studentSem = new JLabel();
                studentSem.setBorder(BorderFactory.createEtchedBorder());
                studentSem.setSize(100, 30);
                studentSem.setLocation(x+k*100,i*30+30 );
                studentSem.setText(s[k-1]);
                simpleWindow.getFrame().add(studentSem);
            }
        }
    }
}
