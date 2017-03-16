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
public class panel1 extends JPanel {
    public panel1(){
    JButton butto = new JButton("Добавить");
       add(butto);
    JComboBox box = new JComboBox();
        box.setPreferredSize( new Dimension(100, 20));
    JTextField text = new JTextField(10);
       add(text);
       add(box);

        butto.addActionListener(new ActionListener() {
            int i=0;
            String[] s1={"","","","","","","","","",""};
            @Override
            public void actionPerformed(ActionEvent e) {
                int n=0;
                String s = text.getText();
                for(int j=0; j <10; j++ )
                    if(s1[j].equals(s)) n=1;
                if (n==0) {
                    s1[i++]= s;
                    box.addItem(s);
                }
                else JOptionPane.showMessageDialog(null, "Такой элемет уже есть!!!");
            }
        });
    }

}
