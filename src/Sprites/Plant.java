package Sprites;

import zad1.Camera;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public abstract class Plant extends Entity {

    // ----- properties ------------------------------------------------------------------------------------------------

    public boolean grown;
    private final int tickSpeed;
    protected int numberOfStates;
    protected int currentState;
    private int tickCounter;
    protected BufferedImage[] bufferedImages;

    Random random;
    int randomTick;


    // ----- constructor -----------------------------------------------------------------------------------------------

    public Plant(int positionX, int positionY, int numberOfStates, int tickSpeed) {
        super(positionX, positionY);
        grown = false;
        this.tickSpeed = tickSpeed;
        this.numberOfStates = numberOfStates;
        currentState = 0;
        tickCounter = 0;

        bufferedImages = new BufferedImage[numberOfStates + 1];
        random = new Random();
    }


    // ----- updating --------------------------------------------------------------------------------------------------

    @Override
    public void update() {
        if (currentState == numberOfStates) {
            grown = true;
        } else {
            randomTick = tickSpeed * random.nextInt(10);
            tickCounter += randomTick;

            if (tickCounter >= 1000000) {
                currentState ++;
                tickCounter = 0;
            }
        }
    }


    // ----- rendering -------------------------------------------------------------------------------------------------

    @Override
    public void render(Graphics2D graphics2D, Camera camera) {
        graphics2D.drawImage(bufferedImages[currentState], camera.cameraX + positionX * camera.scale, camera.cameraY + positionY * camera.scale, camera.scaledTileSize, camera.scaledTileSize, null);
    }

}