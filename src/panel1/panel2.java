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
public class panel2 extends JPanel {
    public panel2(){
        JButton butto1 = new JButton("Кнопка2");
        add(butto1);
        JButton butto2 = new JButton("Кнопка2.1");
        add(butto2);
        JTextField text2 = new JTextField(10);
        add(text2);

        butto1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                butto2.setText(text2.getText());
            }
        });

        butto2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s = butto1.getText();
                butto1.setText(butto2.getText());
                butto2.setText(s);
            }
        });
    }

}
