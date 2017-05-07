package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by user on 09.04.2017.
 */
public class FrameDel {
    private JFrame frameDel;
    private JPanel panel;
    private JLabel labelLastName;
    private JTextField textField1;
    private JLabel paramForDel;
    private JRadioButton group;
    private JRadioButton typeWork;
    private JRadioButton sumWorks;
    private ButtonGroup rGroup;
    private JTextField textField2;
    private JButton buttonDel;

    public JFrame getFrameDel() {
        return frameDel;
    }

    public JPanel getPanel() {
        return panel;
    }

    public JLabel getLabelLastName() {
        return labelLastName;
    }

    public JTextField getTextField1() {
        return textField1;
    }

    public JLabel getParamForDel() {
        return paramForDel;
    }

    public JRadioButton getGroup() {
        return group;
    }

    public JRadioButton getTypeWork() {
        return typeWork;
    }

    public JRadioButton getSumWorks() {
        return sumWorks;
    }

    public ButtonGroup getrGroup() {
        return rGroup;
    }

    public JTextField getTextField2() {
        return textField2;
    }

    public JButton getButtonDel() {
        return buttonDel;
    }

    FrameDel(){
        frameDel = new JFrame("Удаление");
        frameDel.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        panel = new JPanel();
        panel.setLayout(null);

        labelLastName = new JLabel();
        labelLastName.setSize(100,30);
        labelLastName.setText("Фамилия:");
        labelLastName.setLocation(40,0);
        textField1 = new JTextField();
        textField1.setSize(200,30);
        textField1.setLocation(100,0);
        panel.add(textField1);
        panel.add(labelLastName);

        paramForDel = new JLabel();
        paramForDel.setSize(200,30);
        paramForDel.setText("Параметр для удаления:");
        paramForDel.setLocation(40,30);
        panel.add(paramForDel);

        group = new JRadioButton("Группа");
        typeWork = new JRadioButton("Вид работы");
        sumWorks = new JRadioButton("Кол-во работ");
        rGroup = new ButtonGroup();
        group.setSize(150,30);
        group.setLocation(40,60);
        typeWork.setSize(100,30);
        typeWork.setLocation(40,90);
        sumWorks.setSize(150,30);
        sumWorks.setLocation(40,120);
        rGroup.add(group);
        rGroup.add(sumWorks);
        rGroup.add(typeWork);


        textField2 = new JTextField();
        textField2.setSize(200,30);
        textField2.setLocation(150,90);
        panel.add(textField2);
        panel.add(group);
        panel.add(typeWork);
        panel.add(sumWorks);

        buttonDel = new JButton("Удалить");
        buttonDel.setSize(200,30);
        buttonDel.setLocation(40,150);
        panel.add(buttonDel);

        frameDel.add(panel);
        frameDel.setSize(400, 250);
        frameDel.setLocationRelativeTo(null);

}
}
