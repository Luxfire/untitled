package controller.listeners.studentListeners;

import controller.FindStrategy;
import controller.UpdateWindow;
import model.StudentList;
import view.MainWindow;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by user on 09.05.2017.
 */
public class DelListener implements ActionListener {
    private FindStrategy findStrategy;
    private StudentList studentList;
    private MainWindow mainWindow;
    private UpdateWindow updateMainWindow;



    public DelListener(StudentList studentList, MainWindow mainWindow,UpdateWindow updateMainWindow)
    {    StudentList studentSearchList= new StudentList();
        findStrategy = new FindStrategy(mainWindow,studentList,studentSearchList) ;
        this.studentList = studentList;
        this.mainWindow = mainWindow;
        this.updateMainWindow = updateMainWindow;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        findStrategy.findStrategy(2);
       updateMainWindow.updateSimpleWindow();
       mainWindow.getFrameDel().getFrameDel().setVisible(false);

    }
}
