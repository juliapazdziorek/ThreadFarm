package Sprites.Plants;

import zad1.Sprites.Plant;
import zad1.SpritesHandler;

public class Peony extends Plant {

    public Peony(int positionX, int positionY, SpritesHandler spritesHandler) {
        super(positionX, positionY, 4, 200);

        this.bufferedImages[0] = spritesHandler.assets.get("empty");
        this.bufferedImages[1] = spritesHandler.assets.get("peony1");
        this.bufferedImages[2] = spritesHandler.assets.get("peony2");
        this.bufferedImages[3] = spritesHandler.assets.get("peony3");
        this.bufferedImages[4] = spritesHandler.assets.get("peony4");

    }

}