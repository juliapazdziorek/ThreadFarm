package Sprites;

import zad1.Camera;

import java.awt.*;
import java.util.HashMap;

public class AnimatedEntity extends Entity {

    // ----- properties ------------------------------------------------------------------------------------------------

    Animation currentAnimation;

    // ----- constructor -----------------------------------------------------------------------------------------------

    public AnimatedEntity(int positionX, int positionY) {
        super(positionX, positionY);
    }

    public AnimatedEntity(int positionX, int positionY, Animation animation) {
        super(positionX, positionY);
        currentAnimation = animation;
    }


    // ----- updating --------------------------------------------------------------------------------------------------

    @Override
    public void update() {
        currentAnimation.update();
    }

    // ----- rendering -------------------------------------------------------------------------------------------------

    @Override
    public void render(Graphics2D graphics2D, Camera camera) { // im not commenting that, it works and im not saying anything more
        graphics2D.drawImage(currentAnimation.getCurrentFrame(), camera.cameraX + positionX * camera.scale, camera.cameraY + positionY * camera.scale, camera.scaledTileSize, camera.scaledTileSize, null);
    }

}