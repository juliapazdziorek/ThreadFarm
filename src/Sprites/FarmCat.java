package Sprites;

import zad1.Camera;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

/*public class FarmCat extends AnimatedEntity {

    // ----- properties ------------------------------------------------------------------------------------------------
    private enum FarmCatState { FACING, WALKING, FARMING, WATERING }
    private enum FarmCatFacing { DOWN, UP, RIGHT, LEFT }

    private int lastPositionX;
    private int lastPositionY;

    private FarmCatState farmCatState;
    private FarmCatFacing farmCatFacing;
    private final int speed = 3;


    // ----- constructor -----------------------------------------------------------------------------------------------
    public FarmCat(Coordinates coordinates, Animation animation) {
        super(coordinates.x * 16, coordinates.y * 16, animation);
    }


    // ----- moving ----------------------------------------------------------------------------------------------------
    public void moveUp() {
        /*farmCatState = FarmCatState.WALKING;
        farmCatFacing = FarmCatFacing.UP;

        //lastPositionY = positionY;
        positionY -= speed;


    }

    public void moveDown() {

    }

    public void moveLeft() {

    }

    public void moveRight() {

    }


    // ----- update ----------------------------------------------------------------------------------------------------
    @Override
    public void update() {

        /*if (lastPositionX == positionX && lastPositionY == positionY &&
                farmCatState != FarmCatState.FARMING && farmCatState != FarmCatState.WATERING) {
            farmCatState = FarmCatState.FACING;
        }

        currentAnimation.update();
    }

    // ----- rendering -------------------------------------------------------------------------------------------------
    @Override
    public void render(Graphics2D graphics2D, Camera camera) {
        graphics2D.drawImage(currentAnimation.getCurrentFrame(), camera.cameraX + positionX * camera.scale, camera.cameraY + positionY * camera.scale, camera.scaledTileSize * 3, camera.scaledTileSize * 3, null);
    }

}*/


import zad1.Camera;
import zad1.SpritesHandler;

import java.awt.*;
import java.util.concurrent.Future;

public class FarmCat extends AnimatedEntity {

    // ----- properties ------------------------------------------------------------------------------------------------

    // enums
    private enum FarmCatState {FACING, WALKING, FARMING, WATERING}

    private enum FarmCatFacing {DOWN, UP, RIGHT, LEFT}

    // cat state
    private FarmCatState farmCatState;
    private FarmCatFacing farmCatFacing;
    private final int speed = 1;
    private boolean moving;

    // animations
    HashMap<String, Animation> animations;


    // ----- constructor -----------------------------------------------------------------------------------------------

    public FarmCat(Coordinates coordinates, SpritesHandler spritesHandler) {
        super(coordinates.x * 16, coordinates.y * 16);

        // animations (this feels wrong)
        animations = new HashMap<>();
        animations.put("farmCatFacingDown", new Animation(spritesHandler.assets.get("farmCat"), 8, 24, 0, 8, 6));
        animations.put("farmCatFacingUp", new Animation(spritesHandler.assets.get("farmCat"), 8, 24, 1, 8, 6));
        animations.put("farmCatFacingRight", new Animation(spritesHandler.assets.get("farmCat"), 8, 24, 2, 8, 6));
        animations.put("farmCatFacingLeft", new Animation(spritesHandler.assets.get("farmCat"), 8, 24, 3, 8, 6));
        animations.put("farmCatWalkingDown", new Animation(spritesHandler.assets.get("farmCat"), 8, 24, 4, 8, 6));
        animations.put("farmCatWalkingUp", new Animation(spritesHandler.assets.get("farmCat"), 8, 24, 5, 8, 6));
        animations.put("farmCatWalkingRight", new Animation(spritesHandler.assets.get("farmCat"), 8, 24, 6, 8, 6));
        animations.put("farmCatWalkingLeft", new Animation(spritesHandler.assets.get("farmCat"), 8, 24, 7, 8, 6));
        animations.put("farmCatFarmingDown", new Animation(spritesHandler.assets.get("farmCat"), 8, 24, 12, 8, 6));
        animations.put("farmCatFarmingUp", new Animation(spritesHandler.assets.get("farmCat"), 8, 24, 13, 8, 6));
        animations.put("farmCatFarmingRight", new Animation(spritesHandler.assets.get("farmCat"), 8, 24, 14, 8, 6));
        animations.put("farmCatFarmingLeft", new Animation(spritesHandler.assets.get("farmCat"), 8, 24, 15, 8, 6));
        animations.put("farmCatWateringDown", new Animation(spritesHandler.assets.get("farmCat"), 8, 24, 20, 8, 6));
        animations.put("farmCatWateringUp", new Animation(spritesHandler.assets.get("farmCat"), 8, 24, 21, 8, 6));
        animations.put("farmCatWateringRight", new Animation(spritesHandler.assets.get("farmCat"), 8, 24, 22, 8, 6));
        animations.put("farmCatWateringLeft", new Animation(spritesHandler.assets.get("farmCat"), 8, 24, 23, 8, 6));

        // initialize other properties
        this.farmCatState = FarmCatState.FACING;
        this.farmCatFacing = FarmCatFacing.DOWN;
        currentAnimation = animations.get("farmCatFacingDown");
        moving = false;

    }


    // ----- doing action puf puf puf ----------------------------------------------------------------------------------

    public void moveUp() {
        farmCatState = FarmCatState.WALKING;
        farmCatFacing = FarmCatFacing.UP;

        moving = true;
        positionY -= speed;
    }

    public void moveDown() {
        farmCatState = FarmCatState.WALKING;
        farmCatFacing = FarmCatFacing.DOWN;

        moving = true;
        positionY += speed;
    }

    public void moveLeft() {
        farmCatState = FarmCatState.WALKING;
        farmCatFacing = FarmCatFacing.LEFT;

        moving = true;
        positionX -= speed;
    }

    public void moveRight() {
        farmCatState = FarmCatState.WALKING;
        farmCatFacing = FarmCatFacing.RIGHT;

        moving = true;
        positionX += speed;
    }

    public boolean farm() {
        farmCatState = FarmCatState.FARMING;
        return currentAnimation.currentFrame + 1 == currentAnimation.framesOfAnimation;
    }

    public boolean water() {
        farmCatState = FarmCatState.WATERING;
        return currentAnimation.currentFrame + 1 == currentAnimation.framesOfAnimation;
    }


    // ----- resetting animations --------------------------------------------------------------------------------------

    public void resetAnimations() {
        animations.get("farmCatFarmingDown").currentFrame = 0;
        animations.get("farmCatFarmingUp").currentFrame = 0;
        animations.get("farmCatFarmingRight").currentFrame = 0;
        animations.get("farmCatFarmingLeft").currentFrame = 0;
        animations.get("farmCatWateringDown").currentFrame = 0;
        animations.get("farmCatWateringUp").currentFrame = 0;
        animations.get("farmCatWateringRight").currentFrame = 0;
        animations.get("farmCatWateringLeft").currentFrame = 0;
    }


    // ----- update ----------------------------------------------------------------------------------------------------

    @Override
    public void update() {

        // setting up correct animations
        if (!moving) {
            if (farmCatState != FarmCatState.FARMING && farmCatState != FarmCatState.WATERING) {
                farmCatState = FarmCatState.FACING;
                switch (farmCatFacing) {
                    case UP: {
                        currentAnimation = animations.get("farmCatFacingUp");
                        break;
                    }
                    case DOWN: {
                        currentAnimation = animations.get("farmCatFacingDown");
                        break;
                    }
                    case LEFT: {
                        currentAnimation = animations.get("farmCatFacingLeft");
                        break;
                    }
                    case RIGHT: {
                        currentAnimation = animations.get("farmCatFacingRight");
                        break;
                    }
                }
            }

            if (farmCatState == FarmCatState.FARMING) {
                switch (farmCatFacing) {
                    case UP: {
                        currentAnimation = animations.get("farmCatFarmingUp");
                        break;
                    }
                    case DOWN: {
                        currentAnimation = animations.get("farmCatFarmingDown");
                        break;
                    }
                    case LEFT: {
                        currentAnimation = animations.get("farmCatFarmingLeft");
                        break;
                    }
                    case RIGHT: {
                        currentAnimation = animations.get("farmCatFarmingRight");
                        break;
                    }
                }
            }

            if (farmCatState == FarmCatState.WATERING) {
                switch (farmCatFacing) {
                    case UP: {
                        currentAnimation = animations.get("farmCatWateringUp");
                        break;
                    }
                    case DOWN: {
                        currentAnimation = animations.get("farmCatWateringDown");
                        break;
                    }
                    case LEFT: {
                        currentAnimation = animations.get("farmCatWateringLeft");
                        break;
                    }
                    case RIGHT: {
                        currentAnimation = animations.get("farmCatWateringRight");
                        break;
                    }
                }
            }

        } else {

            switch (farmCatFacing) {
                case UP: {
                    currentAnimation = animations.get("farmCatWalkingUp");
                    break;
                }
                case DOWN: {
                    currentAnimation = animations.get("farmCatWalkingDown");
                    break;
                }
                case LEFT: {
                    currentAnimation = animations.get("farmCatWalkingLeft");
                    break;
                }
                case RIGHT: {
                    currentAnimation = animations.get("farmCatWalkingRight");
                    break;
                }
            }

        }

        moving = false;
        currentAnimation.update();
    }


    // ----- rendering -------------------------------------------------------------------------------------------------

    @Override
    public void render(Graphics2D graphics2D, Camera camera) { // DEFINITELY NOT COMMENTING ON THAT
        graphics2D.drawImage(currentAnimation.getCurrentFrame(), camera.cameraX + positionX * camera.scale, camera.cameraY + positionY * camera.scale, camera.scaledTileSize * camera.scale, camera.scaledTileSize * camera.scale, null);
    }

}