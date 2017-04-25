import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by user on 09.04.2017.
 */
public class FrameSearch {
    JFrame frameSearch;
    JLabel labelFio;
    JLabel labelGroup;
    JLabel labelWork;
    JLabel labelSem;
    JPanel panel;
    JLabel labelLastName;
    JTextField textField1;
    JLabel paramForDel;
    JRadioButton group;
    JRadioButton typeWork;
    JRadioButton sumWorks;
    ButtonGroup rGroup;
    JTextField textField2;
    JButton buttonSearch;

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
}
