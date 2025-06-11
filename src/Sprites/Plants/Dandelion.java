package Sprites.Plants;

import zad1.Sprites.Plant;
import zad1.SpritesHandler;

public class Dandelion extends Plant {

    public Dandelion(int positionX, int positionY, SpritesHandler spritesHandler) {
        super(positionX, positionY, 3, 300);

        this.bufferedImages[0] = spritesHandler.assets.get("empty");
        this.bufferedImages[1] = spritesHandler.assets.get("dandelion1");
        this.bufferedImages[2] = spritesHandler.assets.get("dandelion2");
        this.bufferedImages[3] = spritesHandler.assets.get("dandelion3");

    }

}