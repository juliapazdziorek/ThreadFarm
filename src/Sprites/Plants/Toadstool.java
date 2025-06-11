package Sprites.Plants;

import zad1.Sprites.Plant;
import zad1.SpritesHandler;

public class Toadstool extends Plant {

    public Toadstool(int positionX, int positionY, SpritesHandler spritesHandler) {
        super(positionX, positionY, 2, 100);

        this.bufferedImages[0] = spritesHandler.assets.get("empty");
        this.bufferedImages[1] = spritesHandler.assets.get("toadstool1");
        this.bufferedImages[2] = spritesHandler.assets.get("toadstool2");

    }

}