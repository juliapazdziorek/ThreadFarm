package Sprites.Plants;

import zad1.Sprites.Plant;
import zad1.SpritesHandler;

public class Blueberry extends Plant {

    public Blueberry(int positionX, int positionY, SpritesHandler spritesHandler) {
        super(positionX, positionY, 1, 300);

        this.bufferedImages[0] = spritesHandler.assets.get("bush");
        this.bufferedImages[1] = spritesHandler.assets.get("blueberryBush");

    }

}