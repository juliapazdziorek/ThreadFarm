package Sprites;

import zad1.Camera;

import java.awt.*;

public abstract class Entity {

    // ----- properties ------------------------------------------------------------------------------------------------
    public int positionX;
    public int positionY;


    // ----- constructor -----------------------------------------------------------------------------------------------
    public Entity(int positionX, int positionY) {
        this.positionX = positionX;
        this.positionY = positionY;
    }


    // ----- abstract updating -----------------------------------------------------------------------------------------
    public abstract void update();


    // ----- abstract rendering ----------------------------------------------------------------------------------------
    public abstract void render(Graphics2D graphics2D, Camera camera);

}