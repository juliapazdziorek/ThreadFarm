package Sprites.Plants;

import zad1.Sprites.Plant;
import zad1.SpritesHandler;

public class Hyacinth extends Plant {

    public Hyacinth(int positionX, int positionY, SpritesHandler spritesHandler) {
        super(positionX, positionY, 2, 650);

        this.bufferedImages[0] = spritesHandler.assets.get("empty");
        this.bufferedImages[1] = spritesHandler.assets.get("hyacinth1");
        this.bufferedImages[2] = spritesHandler.assets.get("hyacinth2");

    }
}