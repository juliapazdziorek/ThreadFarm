package Sprites.Plants;

import zad1.Sprites.Plant;
import zad1.SpritesHandler;

public class Tomato extends Plant {

    public Tomato(int positionX, int positionY, SpritesHandler spritesHandler) {
        super(positionX, positionY, 4, 800);

        this.bufferedImages[0] = spritesHandler.assets.get("empty");
        this.bufferedImages[1] = spritesHandler.assets.get("tomato1");
        this.bufferedImages[2] = spritesHandler.assets.get("tomato2");
        this.bufferedImages[3] = spritesHandler.assets.get("tomato3");
        this.bufferedImages[4] = spritesHandler.assets.get("tomato4");

    }

}