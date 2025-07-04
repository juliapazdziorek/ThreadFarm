package Sprites.Plants;

import zad1.Sprites.Plant;
import zad1.SpritesHandler;

public class Cucumber extends Plant {

    public Cucumber(int positionX, int positionY, SpritesHandler spritesHandler) {
        super(positionX, positionY, 4, 600);

        this.bufferedImages[0] = spritesHandler.assets.get("empty");
        this.bufferedImages[1] = spritesHandler.assets.get("cucumber1");
        this.bufferedImages[2] = spritesHandler.assets.get("cucumber2");
        this.bufferedImages[3] = spritesHandler.assets.get("cucumber3");
        this.bufferedImages[4] = spritesHandler.assets.get("cucumber4");

    }

}