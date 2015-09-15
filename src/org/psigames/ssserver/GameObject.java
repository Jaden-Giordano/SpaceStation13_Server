package org.psigames.ssserver;

import java.io.Serializable;

/**
 * Created by Jaden on 9/12/2015.
 */
public class GameObject implements Serializable {

    private static final long serialVersionUID = -9683548490582453L;

    public float x, y, z, sx, sy;

    public GameObject() {
        this.x = 0;
        this.y = 0;
        this.z = 0;
        this.sx = 1;
        this.sy = 1;
    }

    public GameObject(float x, float y, float z, float sx, float sy) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.sx = sx;
        this.sy = sy;
    }

}
