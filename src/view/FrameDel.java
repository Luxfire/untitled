package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by user on 09.04.2017.
 */
public class FrameDel {
    private JFrame frameDel;
    private JPanel panel;
    private FrameSearchDel frameSearchDel;

    public JFrame getFrameDel() {
        return frameDel;
    }

    public JPanel getPanel() {
        return panel;
    }

    public FrameSearchDel getFrameSearchDel() {
        return frameSearchDel;
    }

    FrameDel(){
        frameDel = new JFrame("Удаление");
        frameDel.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        panel = new JPanel();
        frameSearchDel = new FrameSearchDel("Удалить",panel);

        frameDel.setContentPane(panel);
        frameDel.setSize(400,190);
        frameDel.setLocationRelativeTo(null);

}
}
