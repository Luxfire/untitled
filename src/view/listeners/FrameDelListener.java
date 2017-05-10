package view.listeners;

import view.FrameDel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by user on 08.05.2017.
 */
public class FrameDelListener implements ActionListener {
    private FrameDel frameDel;

    public FrameDelListener(FrameDel frameDel)
    {
        this.frameDel = frameDel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        frameDel.getFrameSearchDel().getTextFieldFio1().setText("");
        frameDel.getFrameSearchDel().getTextField1().setText("");
        frameDel.getFrameSearchDel().getTextField2().setText("");
        frameDel.getFrameSearchDel().getTextField3().setText("");
        frameDel.getFrameDel().setVisible(true);
    }
}
