package Sprites.Plants;

import zad1.Camera;
import zad1.Sprites.Plant;
import zad1.SpritesHandler;

import java.awt.*;

public class Pear extends Plant {

    public Pear(int positionX, int positionY, SpritesHandler spritesHandler) {
        super(positionX, positionY, 3, 500);

        this.bufferedImages[0] = spritesHandler.assets.get("empty");
        this.bufferedImages[1] = spritesHandler.assets.get("pear1");
        this.bufferedImages[2] = spritesHandler.assets.get("pear2");
        this.bufferedImages[3] = spritesHandler.assets.get("pear3");

    }

    // ----- rendering -------------------------------------------------------------------------------------------------

    @Override
    public void render(Graphics2D graphics2D, Camera camera) {
        graphics2D.drawImage(bufferedImages[currentState], camera.cameraX + positionX * camera.scale, camera.cameraY + positionY * camera.scale, camera.scaledTileSize * camera.scale, camera.scaledTileSize * camera.scale, null);
    }

}
