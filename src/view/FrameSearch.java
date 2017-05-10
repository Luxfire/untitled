package view;

import javax.swing.*;
import java.awt.*;

/**
 * Created by user on 08.05.2017.
 */
public class FrameSearch {
    private JFrame frameSearch;
    private JPanel panel;
    private FrameSearchDel frameSearchDel;
    private TableModel tableSearchModel;

    public JPanel getPanel() {
        return panel;
    }

    public TableModel getTableSearchModel() {
        return tableSearchModel;
    }

    public FrameSearchDel getFrameSearchDel() {
        return frameSearchDel;
    }

    public JFrame getFrameSearch() {
        return frameSearch;
    }

    public FrameSearch(int maxNumberOfSem)
    {
        frameSearch = new JFrame("Поиск");
        frameSearch.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        panel = new JPanel();
        frameSearchDel = new FrameSearchDel("Найти",panel);

        tableSearchModel =new TableModel(160,getPanel(),maxNumberOfSem);

        frameSearch.setContentPane(panel);
        frameSearch.setExtendedState(Frame.MAXIMIZED_BOTH);
        frameSearch.setLocationRelativeTo(null);

    }
}
