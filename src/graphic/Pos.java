package graphic;

import java.io.Serializable;

public class Pos implements Serializable {
    public Pos(){}
    public Pos(int x, int y){
        this.x = x;
        this.y = y;
    }
    private int x;
    private int y;


    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }
}
