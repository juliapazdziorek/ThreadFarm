package Sprites;

import java.awt.image.BufferedImage;

public class Animation {

    // ----- properties ------------------------------------------------------------------------------------------------

    // image
    private final BufferedImage asset;
    BufferedImage[] frames;
    private final int numberOfFramesInTexture;
    private final int numberOfRowsInTexture;
    private final int rowOfAnimation;
    public final int framesOfAnimation;

    // animation
     final int frameDelay;
     public int currentFrame;
     int frameCounter;


    // ----- constructor -----------------------------------------------------------------------------------------------

    public Animation(BufferedImage asset, int numberOfFramesInTexture, int numberOfRowsInTexture,
                     int rowOfAnimation, int framesOfAnimation, int frameDelay) {
        // frames
        this.asset = asset;
        this.numberOfFramesInTexture = numberOfFramesInTexture;
        this.numberOfRowsInTexture = numberOfRowsInTexture;
        this.rowOfAnimation = rowOfAnimation;
        this.framesOfAnimation = framesOfAnimation;
        this.frameDelay = frameDelay;

        // initialize animation properties
        countFrames();
        currentFrame = 0;
        frameCounter = 0;
    }


    // ----- counting frames  ------------------------------------------------------------------------------------------

    private void countFrames() {
        int frameWidth = asset.getWidth() / numberOfFramesInTexture;
        int frameHeight = asset.getHeight() / numberOfRowsInTexture;
        frames = new BufferedImage[framesOfAnimation];

        for (int i = 0; i < framesOfAnimation; i++) {
            frames[i] = asset.getSubimage(i * frameWidth, rowOfAnimation * frameHeight, frameWidth, frameHeight);
        }
    }


    // ----- updating --------------------------------------------------------------------------------------------------

    public void update() {
        frameCounter++;
        if (frameCounter >= frameDelay) {
            currentFrame = (currentFrame + 1) % frames.length;
            frameCounter = 0;
        }
    }


    // ----- rendering -------------------------------------------------------------------------------------------------

    public BufferedImage getCurrentFrame() {
        return frames[currentFrame];
    }

}