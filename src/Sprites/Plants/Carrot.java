package Sprites.Plants;

import zad1.Sprites.Plant;
import zad1.SpritesHandler;


public class Carrot extends Plant {

    public Carrot(int positionX, int positionY, SpritesHandler spritesHandler) {
        super(positionX, positionY, 4, 800);

        this.bufferedImages[0] = spritesHandler.assets.get("empty");
        this.bufferedImages[1] = spritesHandler.assets.get("carrot1");
        this.bufferedImages[2] = spritesHandler.assets.get("carrot2");
        this.bufferedImages[3] = spritesHandler.assets.get("carrot3");
        this.bufferedImages[4] = spritesHandler.assets.get("carrot4");

    }
}