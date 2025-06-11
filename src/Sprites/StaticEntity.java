package Sprites;

import zad1.Camera;

import java.awt.*;
import java.awt.image.BufferedImage;

public class StaticEntity extends Entity {

    // ----- properties ------------------------------------------------------------------------------------------------
    protected BufferedImage bufferedImage;


    // ----- constructor -----------------------------------------------------------------------------------------------
    public StaticEntity(int positionX, int positionY, BufferedImage bufferedImage) {
        super(positionX, positionY);
        this.bufferedImage = bufferedImage;
    }


    // ----- updating --------------------------------------------------------------------------------------------------
    @Override
    public void update() {}


    // ----- rendering --------------------------------------------------------------------------------------------------
    @Override
    public void render(Graphics2D graphics2D, Camera camera) { // im not commenting that, it works and im not saying anything more
        graphics2D.drawImage(bufferedImage, camera.cameraX + positionX * camera.scale, camera.cameraY + positionY * camera.scale, camera.scaledTileSize, camera.scaledTileSize, null);
    }

}