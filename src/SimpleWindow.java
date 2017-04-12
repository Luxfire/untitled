import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class SimpleWindow {
  // private StudentList studentList;
   private JFrame frame;
    JPanel panel;
  StudentList studentList;
    JButton buttonAdd;
    JLabel labelFio;
    JLabel labelGroup;
    JLabel labelWork;
    JButton buttonDel;
    JButton buttonSearch;
    JButton buttonPrevPage;
    JButton buttonFirstPage;
    JButton buttonNextPage;
    JButton buttonLastPage;
    JLabel labelSem;
    public JFrame getFrame() {
        return frame;
    }

    SimpleWindow(/*StudentList studentList*/) {

        this.studentList= new StudentList();
        frame = new JFrame("Пробное окно");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel = new JPanel();
        panel.setLayout(null);
        labelFio = new JLabel("Фио");
        labelFio.setSize(100, 30);
        labelFio.setLocation(0, 0);
        labelFio.setBorder(BorderFactory.createEtchedBorder());
        panel.add(labelFio);

        labelGroup = new JLabel("Группа");
        labelGroup.setSize(100, 30);
        labelGroup.setBorder(BorderFactory.createEtchedBorder());
        labelGroup.setLocation(100, 0);
        panel.add(labelGroup);

        labelWork = new JLabel("Общественные работы");
        labelWork.setSize(1000, 15);
        labelWork.setBorder(BorderFactory.createEtchedBorder());
        labelWork.setLocation(200, 0);
        panel.add(labelWork);

        createlabel(panel);

        buttonAdd = new JButton("Добавить");
        buttonAdd.setSize(100,30);
        buttonAdd.setLocation(0,180);
        panel.add(buttonAdd);

        buttonDel = new JButton("Удалить");
        buttonDel.setSize(100,30);
        buttonDel.setLocation(100,180);
        panel.add(buttonDel);

        buttonSearch = new JButton("Найти");
        buttonSearch.setSize(100,30);
        buttonSearch.setLocation(200,180);
        panel.add(buttonSearch);

        buttonFirstPage = new JButton("<<");
        buttonFirstPage.setSize(50,30);
        buttonFirstPage.setLocation(0,210);
        panel.add(buttonFirstPage);

        buttonPrevPage = new JButton("<");
        buttonPrevPage.setSize(50,30);
        buttonPrevPage.setLocation(50,210);
        panel.add(buttonPrevPage);

        buttonNextPage = new JButton(">");
        buttonNextPage.setSize(50,30);
        buttonNextPage.setLocation(100,210);
        panel.add(buttonNextPage);

        buttonLastPage = new JButton(">>");
        buttonLastPage.setSize(50,30);
        buttonLastPage.setLocation(150,210);
        panel.add(buttonLastPage);

        frame.setContentPane(panel);
        frame.setSize(1220, 280);
        frame.setLocationRelativeTo(null);

        frame.setVisible(true);

    }

    void createlabel(JPanel panel) {
        int x = 200;
        for (int i = 1; i < 11; i++) {
            labelSem = new JLabel(i + " семестр");
            labelSem.setSize(100, 15);
            labelSem.setBorder(BorderFactory.createEtchedBorder());
            labelSem.setLocation(x, 15);
            panel.add(labelSem);
            x += 100;
        }
    }

}
