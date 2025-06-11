package Sprites.Plants;

import zad1.Sprites.Plant;
import zad1.SpritesHandler;

public class Violet extends Plant {

    public Violet(int positionX, int positionY, SpritesHandler spritesHandler) {
        super(positionX, positionY, 3, 800);

        this.bufferedImages[0] = spritesHandler.assets.get("empty");
        this.bufferedImages[1] = spritesHandler.assets.get("violet1");
        this.bufferedImages[2] = spritesHandler.assets.get("violet2");
        this.bufferedImages[3] = spritesHandler.assets.get("violet3");

    }

}