package Sprites.Plants;

import zad1.Sprites.Plant;
import zad1.SpritesHandler;

public class Mushroom extends Plant {

    public Mushroom(int positionX, int positionY, SpritesHandler spritesHandler) {
        super(positionX, positionY, 3, 100);

        this.bufferedImages[0] = spritesHandler.assets.get("empty");
        this.bufferedImages[1] = spritesHandler.assets.get("mushroom1");
        this.bufferedImages[2] = spritesHandler.assets.get("mushroom2");
        this.bufferedImages[3] = spritesHandler.assets.get("mushroom3");

    }

}