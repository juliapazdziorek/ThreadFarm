package Sprites.Plants;

import zad1.Sprites.Plant;
import zad1.SpritesHandler;

public class Lettuce extends Plant {

    public Lettuce(int positionX, int positionY, SpritesHandler spritesHandler) {
        super(positionX, positionY, 4, 1000);

        this.bufferedImages[0] = spritesHandler.assets.get("empty");
        this.bufferedImages[1] = spritesHandler.assets.get("lettuce1");
        this.bufferedImages[2] = spritesHandler.assets.get("lettuce2");
        this.bufferedImages[3] = spritesHandler.assets.get("lettuce3");
        this.bufferedImages[4] = spritesHandler.assets.get("lettuce4");

    }
}