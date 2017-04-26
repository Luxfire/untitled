import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class SimpleWindow {
   private JFrame frame;
    JLabel studentLastName[];
    JLabel studentGroup[];
    JLabel studentSem[][];
    JPanel panel;
    public FrameAdd frameAdd;
    FrameDel frameDel;
    FrameSearch frameSearch;
    JButton buttonAdd;
    JLabel labelFio;
    JLabel labelGroup;
    JLabel labelWork;
    JLabel labelSem;
    JButton buttonDel;
    JButton buttonSearch;
    JButton buttonPrevPage;
    JButton buttonFirstPage;
    JButton buttonNextPage;
    JButton buttonLastPage;
    JLabel pageFromPages;
    JTextField textNumStudentOnPage;
    JLabel labelNumStudentOnPage;
    JButton changeNumStudentOnPage;

    JFrame getFrame(){return frame;}
    public SimpleWindow() {

        frame = new JFrame("Пробное окно");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel = new JPanel();
        panel.setLayout(null);

        labelFio = new JLabel("Фио");
        labelFio.setSize(200, 30);
        labelFio.setLocation(0, 0);
        labelFio.setBorder(BorderFactory.createEtchedBorder());
        panel.add(labelFio);


        labelGroup = new JLabel("Группа");
        labelGroup.setSize(100, 30);
        labelGroup.setBorder(BorderFactory.createEtchedBorder());
        labelGroup.setLocation(200, 0);
        panel.add(labelGroup);

        labelWork = new JLabel("Общественные работы");
        labelWork.setSize(1300, 15);
        labelWork.setBorder(BorderFactory.createEtchedBorder());
        labelWork.setLocation(300, 0);
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

        pageFromPages = new JLabel();
        pageFromPages.setSize(100,30);
        pageFromPages.setLocation(0,270);
        pageFromPages.setText("Cтраница: "+1+"/"+1);
        panel.add(pageFromPages);

          labelNumStudentOnPage = new JLabel();
          labelNumStudentOnPage.setText("Количество студентов на странице");
          labelNumStudentOnPage.setLocation(0,240);
          labelNumStudentOnPage.setSize(210,30);
          panel.add(labelNumStudentOnPage);

        textNumStudentOnPage = new JTextField("3");
        textNumStudentOnPage.setSize(30,30);
        textNumStudentOnPage.setLocation(210,240);
        panel.add(textNumStudentOnPage);

        changeNumStudentOnPage = new JButton("Изменить");
        changeNumStudentOnPage.setSize(100,30);
        changeNumStudentOnPage.setLocation(240,240);
        panel.add(changeNumStudentOnPage);

        frameAdd = new FrameAdd();
        frameDel = new FrameDel();
        frameSearch = new FrameSearch();
        frame.setContentPane(panel);
        frame.setExtendedState(Frame.MAXIMIZED_BOTH);
        frame.setVisible(true);
        createSimpleWindow();


      buttonAdd.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
            frameAdd.frameAdd.setVisible(true);
            frameAdd.textWork1.setText("");
            frameAdd.textWork2.setText("");
            frameAdd.textWork3.setText("");
            frameAdd.textWork4.setText("");
            frameAdd.textWork5.setText("");
            frameAdd.textWork6.setText("");
            frameAdd.textWork7.setText("");
            frameAdd.textWork8.setText("");
            frameAdd.textWork9.setText("");
            frameAdd.textWork10.setText("");
          }
      });
      buttonDel.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
              frameDel.frameDel.setVisible(true);
          }
      });
      buttonSearch.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
              frameSearch.frameSearch.setVisible(true);
          }
      });
    }

    void createlabel(JPanel panel) {
        int x = 300;
        for (int i = 1; i < 11; i++) {
            labelSem = new JLabel(i + " семестр");
            labelSem.setSize(130, 15);
            labelSem.setBorder(BorderFactory.createEtchedBorder());
            labelSem.setLocation(x, 15);
            panel.add(labelSem);
            x += 130;
        }
    }

    void createSimpleWindow() {
       studentLastName = new JLabel[5];
       studentGroup = new JLabel[5];
       studentSem = new JLabel[5][10];
       for (int indexStudent = 0; indexStudent < 5; indexStudent++) {
           studentLastName[indexStudent] = new JLabel();
           studentLastName[indexStudent].setBorder(BorderFactory.createEtchedBorder());
           studentLastName[indexStudent].setSize(200, 30);
           studentLastName[indexStudent].setLocation(0, indexStudent * 30 + 30);

           studentGroup[indexStudent] = new JLabel();
           studentGroup[indexStudent].setBorder(BorderFactory.createEtchedBorder());
           studentGroup[indexStudent].setSize(100, 30);
           studentGroup[indexStudent].setLocation(200, indexStudent * 30 + 30);

           for (int k = 1; k < 11; k++) {
               int x = 170;
               studentSem[indexStudent][k - 1] = new JLabel();
               studentSem[indexStudent][k - 1].setBorder(BorderFactory.createEtchedBorder());
               studentSem[indexStudent][k - 1].setSize(130, 30);
               studentSem[indexStudent][k - 1].setLocation(x + k * 130, indexStudent * 30 + 30);
           }
       }
   }

    void cleanSimpleWindow() {
           for(int indexStudent=0;indexStudent<5;indexStudent++){
              frame.remove(studentLastName[indexStudent]);
               frame.remove(studentGroup[indexStudent]);
               for (int k = 1; k < 11; k++)
                  frame.remove(studentSem[indexStudent][k-1]);
           }
       }

   }


