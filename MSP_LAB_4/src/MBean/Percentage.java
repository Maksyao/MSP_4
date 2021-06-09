package MBean;

import hitting.Shot;

import java.util.ArrayList;

public class Percentage implements PercentageMBean{
    private float HitPercentage = 0;
    private ArrayList<Shot> his;

    public Percentage(ArrayList<Shot> his){
        this.his = his;
    }

    @Override
    public void updatePer() {
        int tempIN = 0;
        int tempALL = his.size();
        for (Shot shot: his){
            tempIN = shot.getHit()?tempIN+1:tempIN;
        }
        HitPercentage = tempIN*100f/tempALL;
    }

    @Override
    public float getHitPercentage() {
        return HitPercentage;
    }
}
