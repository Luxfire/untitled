package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by user on 09.04.2017.
 */
public class FrameSearch {
    private JFrame frameSearch;
    private JButton buttonSearch;
    private JTextField textField1;
    private JTextField textField2;
    private TableModel searchTableModel;
    private JRadioButton group;
    private JRadioButton typeWork;
    private JRadioButton sumWorks;

    public TableModel getSearchTableModel() {
        return searchTableModel;
    }

    public JTextField getTextField1() {
        return textField1;
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

    public JTextField getTextField2() {
        return textField2;
    }

    public JButton getButtonSearch() {
        return buttonSearch;
    }

    public JFrame getFrameSearch() {
        return frameSearch;
    }

    FrameSearch(int maxNumberOfSemestr){
        frameSearch = new JFrame("Найти");
        frameSearch.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
       JPanel panel = new JPanel();
        panel.setLayout(null);
        searchTableModel = new TableModel(190,panel,maxNumberOfSemestr);
        JLabel labelLastName = new JLabel();
        labelLastName.setSize(100,30);
        labelLastName.setText("Фамилия:");
        labelLastName.setLocation(40,0);
        textField1 = new JTextField();
        textField1.setSize(200,30);
        textField1.setLocation(100,0);
        panel.add(textField1);
        panel.add(labelLastName);

        JLabel paramForDel = new JLabel();
        paramForDel.setSize(200,30);
        paramForDel.setText("Параметр для поиска:");
        paramForDel.setLocation(40,30);
        panel.add(paramForDel);

        group = new JRadioButton("Группа");
        typeWork = new JRadioButton("Вид работы");
        sumWorks = new JRadioButton("Кол-во работ");
        ButtonGroup rGroup = new ButtonGroup();
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

        buttonSearch = new JButton("Найти");
        buttonSearch.setSize(200,30);
        buttonSearch.setLocation(40,150);
        panel.add(buttonSearch);

        frameSearch.setContentPane(panel);
        frameSearch.setExtendedState(Frame.MAXIMIZED_BOTH);
        frameSearch.setLocationRelativeTo(null);

    }

}
