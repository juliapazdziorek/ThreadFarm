package Sprites.Plants;

import zad1.Sprites.Plant;
import zad1.SpritesHandler;

public class Eggplant extends Plant {

    public Eggplant(int positionX, int positionY, SpritesHandler spritesHandler) {
        super(positionX, positionY, 4, 400);

        this.bufferedImages[0] = spritesHandler.assets.get("empty");
        this.bufferedImages[1] = spritesHandler.assets.get("eggplant1");
        this.bufferedImages[2] = spritesHandler.assets.get("eggplant2");
        this.bufferedImages[3] = spritesHandler.assets.get("eggplant3");
        this.bufferedImages[4] = spritesHandler.assets.get("eggplant4");

    }
}