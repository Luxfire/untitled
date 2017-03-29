import panel1.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main
{
    public static void main(String[] args){
        JFrame frame = new JFrame("Frame");
        frame.setSize(600,200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        Timer time;
        Doptasks doptask = new Doptasks();
           JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP, JTabbedPane.SCROLL_TAB_LAYOUT);
        panel1 var1 = new panel1();
        panel2 var2 = new panel2();
        panel3 var3 = new panel3();
        panel4 var4 = new panel4();
        panel5 var5 = new panel5();
        tabbedPane.add(var1);
        tabbedPane.add(var2);
        tabbedPane.add(var3);
        tabbedPane.add(var4);
        tabbedPane.add(var5);

        frame.add(tabbedPane);

        ActionListener time1 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                doptask.update(tabbedPane);
            }
        };
        time = new Timer(500, time1);
        time.start();

        frame.setVisible(true);

    }
}

