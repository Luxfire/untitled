package panel1;
import javax.swing.*;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;


/**
 * Created by user on 12.03.2017.
 */
public class panel4 extends JPanel {
    public panel4(){
        JButton butto4 = new JButton("Выбрать");
       add(butto4);
        JTextField text4 = new JTextField(20);
        add(text4);
        JCheckBox cButton1 = new JCheckBox("1");
        JCheckBox cButton2 = new JCheckBox("2");
        JCheckBox cButton3 = new JCheckBox("3");
        add(cButton1);
        add(cButton2);
        add(cButton3);
        butto4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i = 0;
                String s = text4.getText();
                String b1= cButton1.getText();
                String b2= cButton2.getText();
                String b3= cButton3.getText();
                String[] s1 = s.split(",");
                while(i<s1.length) {
                    if (s1[i].equals(b1)) cButton1.setSelected(true);
                    if (s1[i].equals(b2)) cButton2.setSelected(true);
                    if (s1[i].equals(b3)) cButton3.setSelected(true);

                    if(!s1[i].equals(b1) && !s1[i].equals(b2) && !s1[i].equals(b3)) JOptionPane.showMessageDialog(null, "Элемента "+ s1[i] +" нет");
                    i++;
                }
            }

        });
    }

}
