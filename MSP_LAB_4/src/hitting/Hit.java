package hitting;

public class Hit {
    public static void hit_a_target(Shot shot){
        float x = shot.getX();
        float y = shot.getY();
        float r = shot.getR();
        if (x > 0 && y > 0){
            // hit in circle
            if (x*x + y*y <= r*r){
                System.out.println("Good shot!");
                shot.setHit(true);
            }else{
                System.out.println("Miss ;(");
                shot.setHit(false);
            }
        }else if(x > 0 && y < 0){
            //hit in triangle
            if (y >= x - r){
                System.out.println("Good shot!");
                shot.setHit(true);
            }else{
                System.out.println("Miss ;(");
                shot.setHit(false);
            }
        }else if(x < 0 && y > 0){
            System.out.println("Miss ;(");
            shot.setHit(false);
        }else if(x < 0 && y < 0){
            //hit in rectangle
            if((x >= -r)&&(y >= -r/2)){
                System.out.println("Good shot!");
                shot.setHit(true);
            }else{
                System.out.println("Miss ;(");
                shot.setHit(false);
            }

        }else if(x == 0){
            // y can be from -r to r
            if (y <= r && y >= -r){
                System.out.println("Good shot!");
                shot.setHit(true);
            }else{
                System.out.println("Miss ;(");
                shot.setHit(false);
            }
        }else if (y == 0){
            // x can be from -r to r
            if (x <= r && x >= -r){
                System.out.println("Good shot!");
                shot.setHit(true);
            }else{
                System.out.println("Miss ;(");
                shot.setHit(false);
            }
        }
    }
}
