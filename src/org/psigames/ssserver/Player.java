package org.psigames.ssserver;

/**
 * Created by Jaden on 9/12/2015.
 */
public class Player extends GameObject {

    public Player() {
        super();
    }

    public void move(float nx, float ny, float nz) {
        this.x = nx;
        this.y = ny;
        this.z = nz;
    }

}
