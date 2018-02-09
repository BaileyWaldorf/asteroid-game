package asteroidgame;

import blobzx.BlobGUI;
import blobzx.SandBox;
import blobzx.SandBoxMode;
import java.awt.Dimension;
import java.util.Random;

/*
 * University of Central Florida
 * COP3330 - Spring 2016
 * Author: Bailey Waldorf
 */

public class AsteroidGame implements BlobGUI{
    private SandBox sandbox = new SandBox();
        public AsteroidGame() {
            sandbox.setFrameRate(15);
            sandbox.setSandBoxMode(SandBoxMode.FLOW);
            sandbox.init(this);
        }
    
    @Override
    public void generate() {
        Dimension dimension = sandbox.getPanelBounds();
        int xCen = dimension.width / 2;
        int yCen = dimension.height / 2;
        double rotation = 0;
        int xVelocity = 0;
        int yVelocity = 0;
        
        sandbox.addBlob(new Rocket(xCen, yCen, sandbox));
        Random random = new Random();
        
        double[] rotate = {-0.1, 0.1};
        int[] velocity = {-1, -2, -3, 3, 2, 1};
        
        for(int i=0; i<20;i++) {
            rotation = rotate[random.nextInt(2)];
            xVelocity = velocity[random.nextInt(velocity.length)];
            yVelocity = velocity[random.nextInt(velocity.length)];
            
            sandbox.addBlob(new Asteroid(xVelocity, yVelocity, rotation));
        }
    }
    
    public static void main(String[] args) {
        new AsteroidGame();
    }
}