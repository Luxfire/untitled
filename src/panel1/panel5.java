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
public class panel5 extends JPanel {
    public panel5() {
        JButton butto5 = new JButton("Добавить");
        add(butto5);
        JButton butto51 = new JButton("Из столбца 1 в 2");
        add(butto51);
        JButton butto52 = new JButton("Из столбца 2 в 1");
        add(butto52);
        JTextField text5 = new JTextField(20);
        add(text5);
        String column[] = {"", ""};
        String[][] row = new String[5][5];
        JTable table = new JTable(row, column);
        add(table);

        butto5.addActionListener(new ActionListener() {
            int i = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                if(i<5) {
                    String s = text5.getText();
                    table.setValueAt(s, i++, 0);
                }
            }
        });

        butto51.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            if(table.getSelectedColumn()==0&&table.getValueAt(table.getSelectedRow(), table.getSelectedColumn())!=null) {
                table.setValueAt(table.getValueAt(table.getSelectedRow(), table.getSelectedColumn()), table.getSelectedRow(), table.getSelectedColumn() + 1);
                table.setValueAt(null, table.getSelectedRow(), table.getSelectedColumn());
            }
            }
        });

        butto52.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            if(table.getSelectedColumn()==1&&table.getValueAt(table.getSelectedRow(), table.getSelectedColumn())!=null){
                    table.setValueAt(table.getValueAt(table.getSelectedRow(), table.getSelectedColumn()), table.getSelectedRow(), table.getSelectedColumn() - 1);
                    table.setValueAt(null, table.getSelectedRow(), table.getSelectedColumn());
                }
            }
        });
    }

}
