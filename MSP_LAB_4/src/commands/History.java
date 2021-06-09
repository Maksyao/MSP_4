package commands;

import hitting.Shot;

import java.util.ArrayList;

public class History {
    private ArrayList<Shot> history;
    public History(ArrayList<Shot> history){
        this.history = history;
    }
    public void add(Shot shot){
        history.add(shot);
    }

    public void show(){
        for (int i = 0; i < history.size(); i++) {
            history.get(i).show();
        }
    }
}
