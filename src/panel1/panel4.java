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
        Box box4 = Box.createVerticalBox();
        box4.add(cButton1);
        box4.add(cButton2);
        box4.add(cButton3);
        add(box4);
        butto4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i = 0;
                String s = text4.getText();
                String b1= cButton1.getText();
                String b2= cButton2.getText();
                String b3= cButton3.getText();
                while(i<3) {
                    if (s.equals(b1))
                        if(!cButton1.isSelected())cButton1.setSelected(true);
                             else cButton1.setSelected(false);
                    if (s.equals(b2))
                        if(!cButton2.isSelected())cButton2.setSelected(true);
                             else cButton2.setSelected(false);
                    if (s.equals(b3))
                        if(!cButton3.isSelected())cButton3.setSelected(true);
                             else cButton3.setSelected(false);
                    i++;
                }
                if(!s.equals(b1) && !s.equals(b2) && !s.equals(b3)) JOptionPane.showMessageDialog(null, "Элемента "+ s +" нет");
            }

        });
    }

}
