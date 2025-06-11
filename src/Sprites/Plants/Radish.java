package Sprites.Plants;

import zad1.Sprites.Plant;
import zad1.SpritesHandler;

public class Radish extends Plant {

    public Radish(int positionX, int positionY, SpritesHandler spritesHandler) {
        super(positionX, positionY, 4, 400);

        this.bufferedImages[0] = spritesHandler.assets.get("empty");
        this.bufferedImages[1] = spritesHandler.assets.get("radish1");
        this.bufferedImages[2] = spritesHandler.assets.get("radish2");
        this.bufferedImages[3] = spritesHandler.assets.get("radish3");
        this.bufferedImages[4] = spritesHandler.assets.get("radish4");

    }
}