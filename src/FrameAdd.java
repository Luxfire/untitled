import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

class FrameAdd{
     SimpleWindow simpleWindow;
    JFrame frameAdd;
    JPanel panel;
    JButton buttonAdd;
    JLabel labelLastName;
    JLabel labelFirstName;
    JTextField textLastName;
    JTextField textFirstName;
    JLabel labelSurName;
    JTextField textSurName;
    JLabel labelGroup;
    JTextField textGroup;
    JLabel labelWork;
    JTextField textWork1;
    JTextField textWork2;
    JTextField textWork3;
    JTextField textWork4;
    JTextField textWork5;
    JTextField textWork6;
    JTextField textWork7;
    JTextField textWork8;
    JTextField textWork9;
    JTextField textWork10;

    FrameAdd(StudentList studentList, SimpleWindow simpleWindow){
    this.simpleWindow = simpleWindow;
        frameAdd = new JFrame("Добавление");
        frameAdd.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        panel = new JPanel();
        panel.setLayout(null);

        labelLastName = new JLabel("Фамилия:");
        labelLastName.setLocation(0,0);
        labelLastName.setSize(200,30);
        textLastName = new JTextField();
        textLastName.setText("aaa");
        textLastName.setSize(200,30);
        textLastName.setLocation(0,30);
        panel.add(labelLastName);
        panel.add(textLastName);

        labelFirstName = new JLabel("Имя:");
        labelFirstName.setLocation(210,0);
        labelFirstName.setSize(200,30);
        textFirstName = new JTextField();
        textFirstName.setText("sss");
        textFirstName.setSize(200,30);
        textFirstName.setLocation(210,30);
        panel.add(labelFirstName);
        panel.add(textFirstName);

        labelSurName = new JLabel("Отчество:");
        labelSurName.setLocation(420,0);
        labelSurName.setSize(200,30);
        textSurName = new JTextField();
        textSurName.setText("fff");
        textSurName.setSize(200,30);
        textSurName.setLocation(420,30);
        panel.add(labelSurName);
        panel.add(textSurName);

        labelGroup = new JLabel("Группа:");
        labelGroup.setLocation(0,60);
        labelGroup.setSize(200,30);
       textGroup = new JTextField();
       textGroup.setText("12");
        textGroup.setSize(200,30);
        textGroup.setLocation(0,90);
        panel.add(labelGroup);
        panel.add(textGroup);

        for(int i =0; i<10;i++)
        {
          labelWork = new JLabel();
         labelWork.setSize(200,30);
         labelWork.setText("Работа на семестр "+(i+1)+":");
         labelWork.setLocation(0,i*30+120);
         panel.add(labelWork);
        }

        textWork1 = new JTextField();
        textWork1.setSize(200,30);
        textWork1.setLocation(210,120);
        panel.add(textWork1);

        textWork2 = new JTextField();
        textWork2.setSize(200,30);
        textWork2.setLocation(210,150);
        panel.add(textWork2);

        textWork3 = new JTextField();
        textWork3.setSize(200,30);
        textWork3.setLocation(210,180);
        panel.add(textWork3);

        textWork4 = new JTextField();
        textWork4.setSize(200,30);
        textWork4.setLocation(210,210);
        panel.add(textWork4);

        textWork5 = new JTextField();
        textWork5.setSize(200,30);
        textWork5.setLocation(210,240);
        panel.add(textWork5);

        textWork6 = new JTextField();
        textWork6.setSize(200,30);
        textWork6.setLocation(210,270);
        panel.add(textWork6);

        textWork7 = new JTextField();
        textWork7.setSize(200,30);
        textWork7.setLocation(210,300);
        panel.add(textWork7);

        textWork8 = new JTextField();
        textWork8.setSize(200,30);
        textWork8.setLocation(210,330);
        panel.add(textWork8);

        textWork9 = new JTextField();
        textWork9.setSize(200,30);
        textWork9.setLocation(210,360);
        panel.add(textWork9);

        textWork10 = new JTextField();
        textWork10.setSize(200,30);
        textWork10.setLocation(210,390);
        panel.add(textWork10);

         buttonAdd = new JButton("Добавить");
        buttonAdd.setSize(200,30);
        buttonAdd.setLocation(210,420);
        panel.add(buttonAdd);

        frameAdd.add(panel);
        frameAdd.setSize(635, 490);
        frameAdd.setVisible(true);
        frameAdd.setLocationRelativeTo(null);




    }

}