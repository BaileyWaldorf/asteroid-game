package asteroidgame;

import blobzx.*;
import java.util.Random;
import java.awt.Point;

/*
 * University of Central Florida
 * COP3330 - Spring 2016
 * Author: Bailey Waldorf
 */

// creates a class that extends from polyblob
public class Asteroid extends PolyBlob {
    //defines random
    private static final Random random = new Random();
    public Asteroid( int idx, int jdx, double rot) {
        
        // Construct a polyblob for flow mode with
        // the input velocity and rotation values
        super(-100, -100, rot);
        setDelta(idx, jdx);
        
        // defines how many sides each asteroid will have from 5-9
        int sides =random.nextInt(5) + 5;
        double regionSize = (2 * Math.PI) / sides;
        Point[] coor = new Point[sides];
        int[] xCoor = new int[sides];
        int[] yCoor = new int[sides];
        
        for (int i=0; i<sides; i++) {
           int dist = random.nextInt(11)+5;
           double angle = (i * regionSize) + (Math.random() * regionSize);
           coor[i] = BlobUtils.rotatePoint(dist,angle);
           xCoor[i] = coor[i].x;
           yCoor[i] = coor[i].y; 
        }
        this.setPolygon(xCoor, yCoor);
        
       /* for (i = 0; i < 20; i++) {
            int speed = random.nextInt(7) - 3;
            if(speed != 0) {
                Ast[i].speed = speed;
                continue;
            }
            
            else {
                i--;

            }
        }
*/
    }
}