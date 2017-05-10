package controller.listeners.fileListeners;

import controller.FileWorker;
import controller.UpdateWindow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by user on 09.05.2017.
 */
public class OpenFileListener implements ActionListener {
     UpdateWindow updateMainWindow;
     FileWorker fileWorker;
    public OpenFileListener(UpdateWindow updateMainWindow, FileWorker fileWorker)
    {
        this.fileWorker = fileWorker;
        this.updateMainWindow = updateMainWindow;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        fileWorker.openFile.openFile();
        updateMainWindow.updateSimpleWindow();
    }
}
