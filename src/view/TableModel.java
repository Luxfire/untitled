package view;

import javax.swing.*;

/**
 * Created by user on 07.05.2017.
 */
public class TableModel {

    private JLabel studentLastName[];
    private JLabel studentGroup[];
    private JLabel studentSem[][];
    private JButton buttonPrevPage;
    private JButton buttonFirstPage;
    private JButton buttonNextPage;
    private JButton buttonLastPage;
    private JLabel pageFromPages;
    private JTextField textNumStudentOnPage;
    private JButton changeNumStudentOnPage;
    private int currentPage;
    private int studentOnPage;
    private int maxStudentOnPage;

    public JLabel[] getStudentLastName() {
        return studentLastName;
    }

    public JLabel[] getStudentGroup() {
        return studentGroup;
    }

    public JLabel[][] getStudentSem() {
        return studentSem;
    }

    public JButton getButtonPrevPage() {
        return buttonPrevPage;
    }

    public JButton getButtonFirstPage() {
        return buttonFirstPage;
    }

    public JButton getButtonNextPage() {
        return buttonNextPage;
    }

    public JButton getButtonLastPage() {
        return buttonLastPage;
    }

    public JLabel getPageFromPages() {
        return pageFromPages;
    }

    public JTextField getTextNumStudentOnPage() {
        return textNumStudentOnPage;
    }

    public JButton getChangeNumStudentOnPage() {
        return changeNumStudentOnPage;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public void setStudentOnPage(int studentOnPage) {
        this.studentOnPage = studentOnPage;
    }

    public int getMaxStudentOnPage() {
        return maxStudentOnPage;
    }

    public int getStudentOnPage() {
        return studentOnPage;
    }


    TableModel(int yLocation, JPanel panel,int maxNumberOfSemestr)
    { currentPage = 1;
      studentOnPage = 5;
      maxStudentOnPage = 10;

       JLabel labelFio = new JLabel("Фио");
        labelFio.setSize(200, 30);
        labelFio.setLocation(0, yLocation+0);
        labelFio.setBorder(BorderFactory.createEtchedBorder());
        panel.add(labelFio);


        JLabel labelGroup = new JLabel("Группа");
        labelGroup.setSize(100, 30);
        labelGroup.setBorder(BorderFactory.createEtchedBorder());
        labelGroup.setLocation(200, yLocation+0);
        panel.add(labelGroup);

        JLabel labelWork = new JLabel("Общественные работы");
        labelWork.setSize(1300, 15);
        labelWork.setBorder(BorderFactory.createEtchedBorder());
        labelWork.setLocation(300, yLocation+0);
        panel.add(labelWork);

        createlabel(panel,yLocation,maxNumberOfSemestr);

        buttonFirstPage = new JButton("<<");
        buttonFirstPage.setSize(50,30);
        buttonFirstPage.setLocation(0,yLocation+330);
        panel.add(buttonFirstPage);

        buttonPrevPage = new JButton("<");
        buttonPrevPage.setSize(50,30);
        buttonPrevPage.setLocation(50,yLocation+330);
        panel.add(buttonPrevPage);

        buttonNextPage = new JButton(">");
        buttonNextPage.setSize(50,30);
        buttonNextPage.setLocation(100,yLocation+330);
        panel.add(buttonNextPage);
        buttonLastPage = new JButton(">>");
        buttonLastPage.setSize(50,30);
        buttonLastPage.setLocation(150,yLocation+330);
        panel.add(buttonLastPage);

        pageFromPages = new JLabel();
        pageFromPages.setSize(100,30);
        pageFromPages.setLocation(200,yLocation+330);
        pageFromPages.setText("Cтраница: "+1+"/"+1);
        panel.add(pageFromPages);

        JLabel labelNumStudentOnPage = new JLabel();
        labelNumStudentOnPage.setText("Количество студентов на странице:");
        labelNumStudentOnPage.setLocation(0,yLocation+360);
        labelNumStudentOnPage.setSize(210,30);
        panel.add(labelNumStudentOnPage);

        textNumStudentOnPage = new JTextField("5");
        textNumStudentOnPage.setSize(30,30);
        textNumStudentOnPage.setLocation(210,yLocation+360);
        panel.add(textNumStudentOnPage);

        changeNumStudentOnPage = new JButton("Изменить");
        changeNumStudentOnPage.setSize(100,30);
        changeNumStudentOnPage.setLocation(240,yLocation+360);
        panel.add(changeNumStudentOnPage);

        createTableModel(yLocation,maxNumberOfSemestr);

    }

    void createlabel(JPanel panel, int yLocation,int maxNumberOfSemestr) {
        int x = 300;
        for (int numOfLabel = 1; numOfLabel < maxNumberOfSemestr+1; numOfLabel++) {
           JLabel labelSem = new JLabel(numOfLabel + " семестр");
            labelSem.setSize(130, 15);
            labelSem.setBorder(BorderFactory.createEtchedBorder());
            labelSem.setLocation(x, yLocation+15);
            panel.add(labelSem);
            x += 130;
        }
    }

    void createTableModel(int yLocation,int maxNumberOfSemestr) {
        studentLastName = new JLabel[maxStudentOnPage];
        studentGroup = new JLabel[maxStudentOnPage];
        studentSem = new JLabel[maxStudentOnPage][maxNumberOfSemestr];
        for (int indexStudent = 0; indexStudent < maxStudentOnPage; indexStudent++) {
            studentLastName[indexStudent] = new JLabel();
            studentLastName[indexStudent].setBorder(BorderFactory.createEtchedBorder());
            studentLastName[indexStudent].setSize(200, 30);
            studentLastName[indexStudent].setLocation(0, yLocation+(indexStudent * 30 + 30));

            studentGroup[indexStudent] = new JLabel();
            studentGroup[indexStudent].setBorder(BorderFactory.createEtchedBorder());
            studentGroup[indexStudent].setSize(100, 30);
            studentGroup[indexStudent].setLocation(200, yLocation+(indexStudent * 30 + 30));

            for (int indexSem = 1; indexSem <= maxNumberOfSemestr; indexSem++) {
                int x = 170;
                studentSem[indexStudent][indexSem - 1] = new JLabel();
                studentSem[indexStudent][indexSem - 1].setBorder(BorderFactory.createEtchedBorder());
                studentSem[indexStudent][indexSem - 1].setSize(130, 30);
                studentSem[indexStudent][indexSem - 1].setLocation(x + indexSem * 130, yLocation+(indexStudent * 30 + 30));
            }
        }
    }

    public void cleanTableModel(JFrame frame,int maxNumberOfSemestr) {
        for(int indexStudent=0;indexStudent<maxStudentOnPage;indexStudent++){
            frame.remove(studentLastName[indexStudent]);
            frame.remove(studentGroup[indexStudent]);
            for (int indexSem = 1; indexSem <= maxNumberOfSemestr; indexSem++)
                frame.remove(studentSem[indexStudent][indexSem-1]);
        }
    }
    public void prevPage()
    {
        if(currentPage>1) currentPage--;
    }

    public void firstPage()
    {
        if (currentPage > 1) currentPage = 1;
    }

    public void lastPage(int counter)
    {
        currentPage = getNumberMaxPage(counter);
    }

    public void nextPage(int counter)
    {
        boolean hasNextPage = counter> studentOnPage*(currentPage-1)+studentOnPage;
        if(hasNextPage) currentPage++;
    }

    public int getNumberMaxPage(int counter)
    {
        return ((counter - 1)/ studentOnPage) + 1;
    }


}
