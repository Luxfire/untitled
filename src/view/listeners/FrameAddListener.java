package view.listeners;

import view.FrameAddStudent;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by user on 08.05.2017.
 */
public class FrameAddListener implements ActionListener {
    private JFrame frame;
    private FrameAddStudent frameAddStudent;

    public FrameAddListener(JFrame frame, FrameAddStudent frameAddStudent)
    {
        this.frame =frame;
        this.frameAddStudent = frameAddStudent;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        frame.repaint();
        frameAddStudent.getFrameAdd().setVisible(true);
        for(int indexWork=0; indexWork<10; indexWork++)
            frameAddStudent.getTextWork()[indexWork].setText("");
        frameAddStudent.getTextLastName().setText("");
        frameAddStudent.getTextSurName().setText("");
        frameAddStudent.getTextFirstName().setText("");
        frameAddStudent.getTextGroup().setText("");
    }
}

