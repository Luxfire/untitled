package view;

import javax.swing.*;

public class FrameAddStudent{

    private JPanel panel;
    private JButton buttonAdd;
    private JLabel labelLastName;
    private JLabel labelFirstName;
    private JTextField textLastName;
    private JTextField textFirstName;
    private JLabel labelSurName;
    private JTextField textSurName;
    private JLabel labelGroup;
    private JTextField textGroup;
    private JLabel labelWork;
    private JTextField textWork1;
    private JTextField textWork2;
    private JTextField textWork3;
    private JTextField textWork4;
    private JTextField textWork5;
    private JTextField textWork6;
    private JTextField textWork7;
    private JTextField textWork8;
    private JTextField textWork9;
    private JTextField textWork10;
    private JFrame frameAdd;

    public JTextField getTextLastName() {
        return textLastName;
    }

    public JTextField getTextFirstName() {
        return textFirstName;
    }

    public JTextField getTextSurName() {
        return textSurName;
    }

    public JTextField getTextGroup() {
        return textGroup;
    }

    public JButton getButtonAdd() {
        return buttonAdd;
    }

    public JTextField getTextWork1() {
        return textWork1;
    }

    public JTextField getTextWork2() {
        return textWork2;
    }

    public JTextField getTextWork3() {
        return textWork3;
    }

    public JTextField getTextWork4() {
        return textWork4;
    }

    public JTextField getTextWork5() {
        return textWork5;
    }

    public JTextField getTextWork6() {
        return textWork6;
    }

    public JTextField getTextWork7() {
        return textWork7;
    }

    public JTextField getTextWork8() {
        return textWork8;
    }

    public JTextField getTextWork9() {
        return textWork9;
    }

    public JTextField getTextWork10() {
        return textWork10;
    }

    public JFrame getFrameAdd() {
        return frameAdd;
    }

    FrameAddStudent(){

        frameAdd = new JFrame("Добавление");
        frameAdd.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        panel = new JPanel();
        panel.setLayout(null);

        labelLastName = new JLabel("Фамилия:");
        labelLastName.setLocation(0,0);
        labelLastName.setSize(200,30);
        textLastName = new JTextField();
        textLastName.setSize(200,30);
        textLastName.setLocation(0,30);
        panel.add(labelLastName);
        panel.add(textLastName);

        labelFirstName = new JLabel("Имя:");
        labelFirstName.setLocation(210,0);
        labelFirstName.setSize(200,30);
        textFirstName = new JTextField();
        textFirstName.setSize(200,30);
        textFirstName.setLocation(210,30);
        panel.add(labelFirstName);
        panel.add(textFirstName);

        labelSurName = new JLabel("Отчество:");
        labelSurName.setLocation(420,0);
        labelSurName.setSize(200,30);
        textSurName = new JTextField();
        textSurName.setSize(200,30);
        textSurName.setLocation(420,30);
        panel.add(labelSurName);
        panel.add(textSurName);

        labelGroup = new JLabel("Группа:");
        labelGroup.setLocation(0,60);
        labelGroup.setSize(200,30);
        textGroup = new JTextField();
        textGroup.setSize(200,30);
        textGroup.setLocation(0,90);
        panel.add(labelGroup);
        panel.add(textGroup);

        for(int semWork =0; semWork<10;semWork++)
        {
            labelWork = new JLabel();
            labelWork.setSize(200,30);
            labelWork.setText("Работа на семестр "+(semWork+1)+":");
            labelWork.setLocation(0,semWork*30+120);
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
        frameAdd.setLocationRelativeTo(null);
    }

}
