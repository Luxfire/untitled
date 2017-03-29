package panel1;

import com.sun.org.apache.xml.internal.utils.StringToIntTable;

import javax.swing.*;

/**
 * Created by user on 29.03.2017.
 */
public class Doptasks {
    int i;
    int n;
    String s;
    public void update(JTabbedPane pane){
    for(n=0;n<5;n++) {
        s = "_________вариант_" + ++n + "_____________";
        pane.setTitleAt(--n, s.substring(i, i + 9));
    }
        i++;
        if(i==18) i=0;
    }
}
