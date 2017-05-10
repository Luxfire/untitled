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
        frameSearch.getFrameSearchDel().getTextFieldFio1().setText("");
        frameSearch.getFrameSearchDel().getTextField1().setText("");
        frameSearch.getFrameSearchDel().getTextField2().setText("");
        frameSearch.getFrameSearchDel().getTextField3().setText("");
        frameSearch.getFrameSearch().setVisible(true);
    }
}
