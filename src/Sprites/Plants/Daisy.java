package Sprites.Plants;

import zad1.Sprites.Plant;
import zad1.SpritesHandler;

public class Daisy extends Plant {

    public Daisy(int positionX, int positionY, SpritesHandler spritesHandler) {
        super(positionX, positionY, 3, 1200);

        this.bufferedImages[0] = spritesHandler.assets.get("empty");
        this.bufferedImages[1] = spritesHandler.assets.get("daisy1");
        this.bufferedImages[2] = spritesHandler.assets.get("daisy2");
        this.bufferedImages[3] = spritesHandler.assets.get("daisy3");

    }

}