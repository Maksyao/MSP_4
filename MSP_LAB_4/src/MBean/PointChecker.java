package MBean;

import commands.CoordinatesChecker;
import commands.Shoot;
import hitting.Shot;

import javax.management.Notification;
import javax.management.NotificationBroadcasterSupport;
import java.util.ArrayList;

public class PointChecker extends NotificationBroadcasterSupport implements PointCheckerMBean{
    private int AmountOfPointsInArea = 0;
    private int AmountOfPoints = 0;
    private long sequenceNumber = 0;
    private ArrayList<Shot> his;

    public PointChecker(ArrayList<Shot> his){
        this.his = his;
    }

    @Override
    public void update() {
        AmountOfPoints = his.size();
        AmountOfPointsInArea = 0;
        for (Shot shot: his){
            AmountOfPointsInArea = shot.getHit()?AmountOfPointsInArea+1:AmountOfPointsInArea;
        }
    }

    @Override
    public boolean CheckCoords(float x, float y, float r) {
        if (!CoordinatesChecker.checkX(x)) {
            Notification notification = new Notification(
                    "PointsOutOfArea", this, sequenceNumber++, System.currentTimeMillis(),"This X = " + x +" is not in the permissible area"
            );
            this.sendNotification(notification);
            return false;
        }
        if (!CoordinatesChecker.checkY(y)) {
            Notification notification = new Notification(
                    "PointsOutOfArea", this, sequenceNumber++, System.currentTimeMillis(),"This Y = " + y +" is not in the permissible area"
            );
            this.sendNotification(notification);
            return false;
        }
        if (!CoordinatesChecker.checkR(r)) {
            Notification notification = new Notification(
                    "PointsOutOfArea", this, sequenceNumber++, System.currentTimeMillis(),"This R = " + r +" is not in the permissible area"
            );
            this.sendNotification(notification);
            return false;
        }
        return true;
    }

    @Override
    public int getAmountOfPoints() {
        return AmountOfPoints;
    }

    @Override
    public int getAmountOfPointsInArea() {
        return AmountOfPointsInArea;
    }

}
