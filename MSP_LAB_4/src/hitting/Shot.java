package hitting;

public class Shot {
    private float x,y,r;
    private boolean hit = false;
    public Shot( float x ,float y, float r){
        this.x = x;
        this.y = y;
        this.r = r;
    }

    public Shot(){

    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getR() {
        return r;
    }

    public boolean getHit(){
        return hit;
    }

    public void setHit(boolean hit) {
        this.hit = hit;
    }

    public void show(){
        System.out.print("Shot in an area with coordinates: "+ x + " " + y + "\n" +"Radius: " + r + "\n" + "Hit: ");
        String s = hit?"YES":"NO";
        System.out.print(s + "\n" + "-----------------------" + "\n");
    }
}
