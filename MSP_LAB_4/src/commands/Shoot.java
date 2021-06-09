package commands;

import MBean.Percentage;
import MBean.PointChecker;
import hitting.Hit;
import hitting.Shot;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Shoot {
    private Shot sh;
    public void shoot(History history, PointChecker pc, Percentage percentage){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the coordinates and radius of the shot through the space without other characters X Y R");
        System.out.println("**************************************");
        System.out.println("*** Your X must be in range [-3;3] ***");
        System.out.println("**************************************");
        System.out.println("*** Your Y must be in range [-5;5] ***");
        System.out.println("**************************************");
        System.out.println("*** Your R must be in range [1;4] ***");
        System.out.println("**************************************");
        float x = 0;
        float y = 0;
        float r = 0;
        String [] coords;
        String coordinates;
        while (true)
        {
            try {
                coordinates = in.nextLine();
                coords = coordinates.split(" ", 3);
                if (Float.parseFloat(coords[2])<0){
                    coords[2] = "a";
                }
                x = Float.parseFloat(coords[0]);
                y = Float.parseFloat(coords[1]);
                r = Float.parseFloat(coords[2]);
                if(pc.CheckCoords(x,y,r)) {
                    break;
                }else{
                    System.out.println("Your coordinates or R is not in the permissible area. Please try again.");
                }
            }
            catch (Exception e)
            {
                System.out.println("Something went wrong. Possible causes of failure:");
                System.out.println("1) Your numbers are deceiving you (maybe they are not numbers at all)");
                System.out.println("2)Your numbers are deceiving you again (maybe they are too large)");
                System.out.println("3) The radius is deceiving you (it may be negative)");
                System.out.println("Try again: ");
            }
        }
        sh = new Shot(x,y,r);
        Hit.hit_a_target(sh);
        history.add(sh);
        pc.update();
        percentage.updatePer();
    }
    public boolean checkShoot(String... args){
        float x;
        float y;
        float r;
        try {
                x = Float.parseFloat(args[0]);
                y = Float.parseFloat(args[1]);
                r = Float.parseFloat(args[2]);
            }
            catch (Exception e)
            {
                return false;
            }
        sh = new Shot(x,y,r);
        Hit.hit_a_target(sh);
        return sh.getHit();
    }
}
