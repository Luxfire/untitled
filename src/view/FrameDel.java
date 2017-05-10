package view;

import javax.swing.*;

/**
 * Created by user on 09.04.2017.
 */
public class FrameDel {
    private JFrame frameDel;
    private FrameSearchDel frameSearchDel;

    public JFrame getFrameDel() {
        return frameDel;
    }

    public FrameSearchDel getFrameSearchDel() {
        return frameSearchDel;
    }

    FrameDel(){
        frameDel = new JFrame("Удаление");
        frameDel.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JPanel panel = new JPanel();
        frameSearchDel = new FrameSearchDel("Удалить",panel);

        frameDel.setContentPane(panel);
        frameDel.setSize(400,190);
        frameDel.setLocationRelativeTo(null);

}
}
