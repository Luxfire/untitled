package view.listeners;

import view.FrameSearch;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by user on 08.05.2017.
 */
public class FrameSearchListener implements ActionListener {
    private FrameSearch frameSearch;

    public FrameSearchListener(FrameSearch frameSearch)
    {
        this.frameSearch =frameSearch;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       /* frameSearch.getTextField1().setText("");
        frameSearch.getTextField1().setText("");*/
        frameSearch.getFrameSearch().setVisible(true);
    }
}
