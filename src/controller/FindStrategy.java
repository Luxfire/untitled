package controller;

import view.FrameSearchDel;

/**
 * Created by user on 09.05.2017.
 */
public class FindStrategy {
    private FrameSearchDel frameSearchDel;

   public FindStrategy(FrameSearchDel frameSearchDel)
    {
        this.frameSearchDel =frameSearchDel;
    }

    public Integer findStrategy()
    {      int counter=0;
        if(!frameSearchDel.getTextFieldFio1().getText().equals("")) counter++;
        if(!frameSearchDel.getTextField1().getText().equals("")) counter++;
        if(!frameSearchDel.getTextField2().getText().equals("")) counter++;
        if(!frameSearchDel.getTextField3().getText().equals("")) counter++;
         if (counter<2) return 5;
         if (counter>2) return 4;

            if (!frameSearchDel.getTextFieldFio1().getText().equals("")) {
            if (!frameSearchDel.getTextField1().getText().equals("")) return 1;
            if (!frameSearchDel.getTextField2().getText().equals("")) return 2;
            if (!frameSearchDel.getTextField3().getText().equals("")) return 3;
        }
        return 6;
    }
}
