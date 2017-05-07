package view;

import javax.swing.*;

public class FrameAddStudent{

    private JButton buttonAdd;
    private JTextField textLastName;
    private JTextField textFirstName;
    private JTextField textSurName;
    private JTextField textGroup;
    private JTextField textWork[];
    private JFrame frameAdd;

    public JTextField[] getTextWork() {
        return textWork;
    }

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

    public JFrame getFrameAdd() {
        return frameAdd;
    }

    FrameAddStudent(int maxNumberOfSemestr){

        frameAdd = new JFrame("Добавление");
        frameAdd.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
       JPanel panel = new JPanel();
        panel.setLayout(null);

       JLabel labelLastName = new JLabel("Фамилия:");
        labelLastName.setLocation(0,0);
        labelLastName.setSize(200,30);
        textLastName = new JTextField();
        textLastName.setSize(200,30);
        textLastName.setLocation(0,30);
        panel.add(labelLastName);
        panel.add(textLastName);

       JLabel labelFirstName = new JLabel("Имя:");
        labelFirstName.setLocation(210,0);
        labelFirstName.setSize(200,30);
        textFirstName = new JTextField();
        textFirstName.setSize(200,30);
        textFirstName.setLocation(210,30);
        panel.add(labelFirstName);
        panel.add(textFirstName);

       JLabel labelSurName = new JLabel("Отчество:");
        labelSurName.setLocation(420,0);
        labelSurName.setSize(200,30);
        textSurName = new JTextField();
        textSurName.setSize(200,30);
        textSurName.setLocation(420,30);
        panel.add(labelSurName);
        panel.add(textSurName);

       JLabel labelGroup = new JLabel("Группа:");
        labelGroup.setLocation(0,60);
        labelGroup.setSize(200,30);
        textGroup = new JTextField();
        textGroup.setSize(200,30);
        textGroup.setLocation(0,90);
        panel.add(labelGroup);
        panel.add(textGroup);

        for(int semWork =0; semWork<maxNumberOfSemestr;semWork++)
        {
            JLabel labelWork = new JLabel();
            labelWork.setSize(200,30);
            labelWork.setText("Работа на семестр "+(semWork+1)+":");
            labelWork.setLocation(0,semWork*30+120);
            panel.add(labelWork);
        }

        textWork = new JTextField[maxNumberOfSemestr];
        for(int indexWork = 0,yLocation = 120,yChange=30; indexWork<maxNumberOfSemestr; indexWork++,yLocation+=yChange) {
            textWork[indexWork]= new JTextField();
            textWork[indexWork].setSize(200, 30);
            textWork[indexWork].setLocation(210, yLocation);
            panel.add(textWork[indexWork]);
        }

        buttonAdd = new JButton("Добавить");
        buttonAdd.setSize(200,30);
        buttonAdd.setLocation(210,420);
        panel.add(buttonAdd);

        frameAdd.add(panel);
        frameAdd.setSize(635, 490);
        frameAdd.setLocationRelativeTo(null);
    }

}
