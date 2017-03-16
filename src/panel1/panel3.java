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
public class panel3 extends JPanel {
    public panel3(){
        JButton butto3 = new JButton("Выбрать");
        add(butto3);
        JTextField text3 = new JTextField(10);
        add(text3);
        JRadioButton rButton1 = new JRadioButton("1");
        JRadioButton rButton2 = new JRadioButton("2");
        JRadioButton rButton3 = new JRadioButton("3");
        ButtonGroup gr = new ButtonGroup();
        gr.add(rButton1);
        gr.add(rButton2);
        gr.add(rButton3);
        add(rButton1);
        add(rButton2);
        add(rButton3);
        butto3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(text3.getText().equals(rButton1.getText()))
                    rButton1.setSelected(true);
                else
                if(text3.getText().equals(rButton2.getText()))
                    rButton2.setSelected(true);
                else
                if(text3.getText().equals(rButton3.getText()))
                    rButton3.setSelected(true);
                else JOptionPane.showMessageDialog(null, "Такого элемента нет!!!");
            };

        });
    }

}
