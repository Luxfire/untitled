package view;

import javax.swing.*;

/**
 * Created by user on 09.04.2017.
 */
public class FrameSearchDel {
    private JButton button1;
    private JTextField textFieldFio1;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;

    public JButton getButton1() {
        return button1;
    }

    public JTextField getTextFieldFio1() {
        return textFieldFio1;
    }


    public JTextField getTextField1() {
        return textField1;
    }

    public JTextField getTextField2() {
        return textField2;
    }

    public JTextField getTextField3() {
        return textField3;
    }


    FrameSearchDel(String frameName, JPanel panel1){

        panel1.setLayout(null);

        JLabel labelLastName1 = new JLabel();
        labelLastName1.setSize(100,30);
        labelLastName1.setText("Фамилия:");
        labelLastName1.setLocation(40,0);
        panel1.add(labelLastName1);

        JLabel group1 = new JLabel();
        group1.setSize(100,30);
        group1.setText("Группа:");
        group1.setLocation(40,30);
        panel1.add(group1);

        JLabel typeWork = new JLabel();
        typeWork.setSize(100,30);
        typeWork.setText("Вид работы:");
        typeWork.setLocation(40,60);
        panel1.add(typeWork);

        JLabel sumWork = new JLabel();
        sumWork.setSize(200,30);
        sumWork.setText("Количество работ:");
        sumWork.setLocation(40,90);
        panel1.add(sumWork);

        textFieldFio1 = new JTextField();
        textFieldFio1.setSize(200,30);
        textFieldFio1.setLocation(150,0);
        panel1.add(textFieldFio1);

        textField1 = new JTextField();
        textField1.setSize(200,30);
        textField1.setLocation(150,30);
        panel1.add(textField1);

        textField2 = new JTextField();
        textField2.setSize(200,30);
        textField2.setLocation(150,60);
        panel1.add(textField2);

        textField3 = new JTextField();
        textField3.setSize(200,30);
        textField3.setLocation(150,90);
        panel1.add(textField3);

        button1 = new JButton(frameName);
        button1.setSize(200,30);
        button1.setLocation(150,120);
        panel1.add(button1);

    }

}
