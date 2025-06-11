package Sprites;

import zad1.Camera;

import java.awt.*;

public class Cow extends AnimatedEntity {

    // ----- constructor -----------------------------------------------------------------------------------------------
    public Cow(int positionX, int positionY, Animation animation) {
        super(positionX, positionY, animation);
    }

    // ----- rendering -------------------------------------------------------------------------------------------------
    @Override
    public void render(Graphics2D graphics2D, Camera camera) { // DEFINITELY NOT COMMENTING ON THAT
        graphics2D.drawImage(currentAnimation.getCurrentFrame(), camera.cameraX + positionX * camera.scale, camera.cameraY + positionY * camera.scale, camera.scaledTileSize * 2, camera.scaledTileSize * 2, null);
    }
}