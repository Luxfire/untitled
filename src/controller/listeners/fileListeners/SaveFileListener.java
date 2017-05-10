package controller.listeners.fileListeners;

import controller.FileWorker;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by user on 09.05.2017.
 */
public class SaveFileListener implements ActionListener {
      FileWorker fileWorker;
    public SaveFileListener(FileWorker fileWorker)
    {
        this.fileWorker=fileWorker;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        fileWorker.saveFile.saveFile();

    }
}
