import panel1.*;
import javax.swing.*;

public class Main
{
    public static void main(String[] args){
        JFrame frame = new JFrame("Frame");
        frame.setSize(600,200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);


    JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP, JTabbedPane.SCROLL_TAB_LAYOUT);

        panel1 var1 = new panel1();
        tabbedPane.add("Вариант 1", var1);

        panel2 var2 = new panel2();
        tabbedPane.add("Вариант 2", var2);

        panel3 var3 = new panel3();
        tabbedPane.add("Вариант 3", var3);

        panel4 var4 = new panel4();
        tabbedPane.add("Вариант 4", var4);

        panel5 var5 = new panel5();
        tabbedPane.add("Вариант 5", var5);

        frame.add(tabbedPane);

        frame.setVisible(true);



    }
}

