import javax.swing.*;

/**
 * Created by user on 12.04.2017.
 */
public class FrameSearchResult {
JFrame frame;
JPanel panel;
    JLabel labelFio;
    JLabel labelGroup;
    JLabel labelWork;
    JLabel labelSem;
FrameSearchResult()
{
   frame = new JFrame();
   panel = new JPanel();
    panel.setLayout(null);
    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    labelFio = new JLabel("Фио");
    labelFio.setSize(100, 30);
    labelFio.setLocation(0, 0);
    labelFio.setBorder(BorderFactory.createEtchedBorder());
    panel.add(labelFio);

    labelGroup = new JLabel("Группа");
    labelGroup.setSize(100, 30);
    labelGroup.setBorder(BorderFactory.createEtchedBorder());
    labelGroup.setLocation(100, 0);
    panel.add(labelGroup);

    labelWork = new JLabel("Общественные работы");
    labelWork.setSize(1000, 15);
    labelWork.setBorder(BorderFactory.createEtchedBorder());
    labelWork.setLocation(200, 0);
    panel.add(labelWork);

    createlabel(panel);


    frame.setContentPane(panel);
    frame.setSize(1220, 500);
    frame.setLocationRelativeTo(null);
}
    void createlabel(JPanel panel) {
        int x = 200;
        for (int i = 1; i < 11; i++) {
            labelSem = new JLabel(i + " семестр");
            labelSem.setSize(100, 15);
            labelSem.setBorder(BorderFactory.createEtchedBorder());
            labelSem.setLocation(x, 15);
            panel.add(labelSem);
            x += 100;
        }
    }
}
