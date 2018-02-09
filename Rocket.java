package asteroidgame;

import blobzx.*;
import java.awt.Point;
import java.awt.event.KeyEvent;

/*
 * University of Central Florida
 * COP3330 - Spring 2016
 * Author: Bailey Waldorf
 */

public class Rocket extends PolyBlob implements BlobAction, BlobProximity {
        
    private double angle = 0.0;
    // angle of each button click
    private final double delta = 0.15;
    // speed of rocket
    private final double speed = 5.0;
    
    private final SandBox sandbox;
    // custom shape of rocket
    private final int[] origX = {10, -10, -5, -10};
    private final int[] origY = {0, -10, 0, 10};
    private final int[] newX = {10, -10, -5, -10};
    private final int[] newY = {0, -10, 0, 10};
    
    // declares the original location and changed locations
    private int xLoc, yLoc;
    private Point temp;
    
    public Rocket (int xCoord, int yCoord, SandBox sandbox) {
        super(0, 0, 0);
        xLoc = xCoord;
        yLoc = yCoord;
        this.sandbox = sandbox;
        setLoc(xLoc, yLoc);
        setPolygon(newX, newY);
    }
    
    private void launch(SandBox sandbox) {
        int misX = xLoc + (int) (Math.cos(angle) * (15));
        int misY = yLoc + (int) (Math.sin(angle) * (15));
        sandbox.addBlob( new Missile (misX, misY, angle));
    }
    
    @Override
    public void keyAction (KeyEvent e) {
        switch (e.getKeyCode()) {
            case 32:
                launch(sandbox);
                BlobUtils.playSound();
                break;
            case 37:
                angle += -1 * delta;
                if(angle < 0)
                    angle += 2 * Math.PI;
                for(int i=0;i<origX.length;i++) {
                    temp = BlobUtils.rotatePoint(origX[i], origY[i], angle);
                    newX[i] = temp.x;
                    newY[i] = temp.y;
                }   break;
            case 38:
                xLoc += (int) Math.round(speed * Math.cos(angle));
                yLoc += (int) Math.round(speed * Math.sin(angle));
                setLoc(xLoc, yLoc);
                break;
            case 39:
                angle += 1 * delta;
                if(angle > 2 * Math.PI)
                    angle -= 2 * Math.PI;
                for(int i=0;i<origX.length;i++) {
                    temp = BlobUtils.rotatePoint(origX[i], origY[i], angle);
                    newX[i] = temp.x;
                    newY[i] = temp.y;
                }   break;
            default:
                break;
        }
    }
}