package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by user on 09.04.2017.
 */
public class FrameSearch {
    private JLabel studentLastName[];
    private JLabel studentGroup[];
    private JLabel studentSem[][];
    private JFrame frameSearch;
    private JLabel labelFio;
    private JLabel labelGroup;
    private JLabel labelWork;
    private JLabel labelSem;
    private JPanel panel;
    private JLabel labelLastName;
    private JTextField textField1;
    private JLabel paramForDel;
    private JRadioButton group;
    private JRadioButton typeWork;
    private JRadioButton sumWorks;
    private ButtonGroup rGroup;
    private JTextField textField2;
    private JButton buttonSearch;

    public JLabel[] getStudentLastName() {
        return studentLastName;
    }

    public JLabel[] getStudentGroup() {
        return studentGroup;
    }

    public JLabel[][] getStudentSem() {
        return studentSem;
    }

    public JLabel getLabelFio() {
        return labelFio;
    }

    public JLabel getLabelGroup() {
        return labelGroup;
    }

    public JLabel getLabelWork() {
        return labelWork;
    }

    public JLabel getLabelSem() {
        return labelSem;
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

    public JButton getButtonSearch() {
        return buttonSearch;
    }

    public JFrame getFrameSearch() {
        return frameSearch;
    }

    FrameSearch(){
        frameSearch = new JFrame("Найти");
        frameSearch.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
        paramForDel.setText("Параметр для поиска:");
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

        buttonSearch = new JButton("Найти");
        buttonSearch.setSize(200,30);
        buttonSearch.setLocation(40,150);
        panel.add(buttonSearch);

        labelFio = new JLabel("Фио");
        labelFio.setSize(200, 30);
        labelFio.setLocation(0, 190);
        labelFio.setBorder(BorderFactory.createEtchedBorder());
        panel.add(labelFio);
         createlabel(panel);

        labelGroup = new JLabel("Группа");
        labelGroup.setSize(100, 30);
        labelGroup.setBorder(BorderFactory.createEtchedBorder());
        labelGroup.setLocation(200, 190);
        panel.add(labelGroup);

        labelWork = new JLabel("Общественные работы");
        labelWork.setSize(1300, 15);
        labelWork.setBorder(BorderFactory.createEtchedBorder());
        labelWork.setLocation(300, 190);
        panel.add(labelWork);



        frameSearch.setContentPane(panel);
        frameSearch.setExtendedState(Frame.MAXIMIZED_BOTH);
        frameSearch.setLocationRelativeTo(null);

    }

    void createlabel(JPanel panel) {
        int x = 300;
        for (int i = 1; i < 11; i++) {
            labelSem = new JLabel(i + " семестр");
            labelSem.setSize(130, 15);
            labelSem.setBorder(BorderFactory.createEtchedBorder());
            labelSem.setLocation(x, 205);
            panel.add(labelSem);
            x += 130;
        }
    }

    public void inicializedSearchLabel(int size) {
        studentLastName = new JLabel[size];
        studentGroup = new JLabel[size];
        studentSem = new JLabel[size][10];
    }

    public void createSearchResult(int counter) {

        studentLastName[counter] = new JLabel();
            studentLastName[counter].setBorder(BorderFactory.createEtchedBorder());
            studentLastName[counter].setSize(200, 30);
            studentLastName[counter].setLocation(0, counter * 30 + 220);

            studentGroup[counter] = new JLabel();
            studentGroup[counter].setBorder(BorderFactory.createEtchedBorder());
            studentGroup[counter].setSize(100, 30);
            studentGroup[counter].setLocation(200, counter * 30 + 220);

            for (int k = 1; k < 11; k++) {
                int x = 170;
                studentSem[counter][k - 1] = new JLabel();
                studentSem[counter][k - 1].setBorder(BorderFactory.createEtchedBorder());
                studentSem[counter][k - 1].setSize(130, 30);
                studentSem[counter][k - 1].setLocation(x + k * 130, counter * 30 + 220);
            }


    }

    public void cleanSearchWindow(int counter) {
        for(int indexStudent=0;indexStudent<counter;indexStudent++){

            frameSearch.remove(studentLastName[indexStudent]);
            frameSearch.remove(studentGroup[indexStudent]);
            for (int k = 1; k < 11; k++)
                frameSearch.remove(studentSem[indexStudent][k-1]);

        }
    }
}
