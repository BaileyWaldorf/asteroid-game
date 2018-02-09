package asteroidgame;

import blobzx.*;

/*
 * University of Central Florida
 * COP3330 - Spring 2016
 * Author: Bailey Waldorf
 */

public class Missile extends Blob implements BlobProximity {

    public Missile( int x, int y, double angle) {
        super(x,y);
        final double speed = 5;
        final int diameter = 5;
        int Xvert = (int) Math.round(speed * Math.cos(angle));
        int Yvert = (int) Math.round(speed * Math.sin(angle));

        this.setSize(diameter);
        this.setDelta(Xvert, Yvert);
    }
}