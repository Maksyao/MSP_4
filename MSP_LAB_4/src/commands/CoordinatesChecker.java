package commands;

public class CoordinatesChecker {
    public static boolean checkX(float x){
        if ((x<=3.0)&&(x>=-3.0)){
            return true;
        }else return false;
    };
    public static boolean checkY(float y){
        if ((y<=5.0)&&(y>=-5.0)){
            return true;
        }else return false;
    };
    public static boolean checkR(float r){
        if ((r<=4.0)&&(r>=1.0)){
            return true;
        }else return false;
    };
}
