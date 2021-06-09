package MBean;

import hitting.Shot;
import java.util.ArrayList;

public interface PointCheckerMBean {
    int getAmountOfPoints();
    int getAmountOfPointsInArea();
    void update();
    boolean CheckCoords(float x, float y, float r);
}
