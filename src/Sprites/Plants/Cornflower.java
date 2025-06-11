package Sprites.Plants;

import zad1.Sprites.Plant;
import zad1.SpritesHandler;

public class Cornflower extends Plant {

    public Cornflower(int positionX, int positionY, SpritesHandler spritesHandler) {
        super(positionX, positionY, 4, 450);

        this.bufferedImages[0] = spritesHandler.assets.get("empty");
        this.bufferedImages[1] = spritesHandler.assets.get("cornFlower1");
        this.bufferedImages[2] = spritesHandler.assets.get("cornFlower2");
        this.bufferedImages[3] = spritesHandler.assets.get("cornFlower3");
        this.bufferedImages[4] = spritesHandler.assets.get("cornFlower4");

    }

}