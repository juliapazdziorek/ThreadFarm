import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ActionHandler implements KeyListener {

    // ----- properties ------------------------------------------------------------------------------------------------

    // essentials
    Camera camera;

    // flags
    boolean upPressed;
    boolean downPressed;
    boolean leftPressed;
    boolean rightPressed;


    // ----- constructor -----------------------------------------------------------------------------------------------
    public ActionHandler(Camera camera) {
        this.camera = camera;
    }


    // ----- overrides -------------------------------------------------------------------------------------------------
    @Override
    public void keyTyped(KeyEvent keyEvent) {
        // no
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();

        switch (keyCode) {
            case KeyEvent.VK_UP:
            case KeyEvent.VK_W:
                upPressed = true;
                break;
            case KeyEvent.VK_DOWN:
            case KeyEvent.VK_S:
                downPressed = true;
                break;
            case KeyEvent.VK_LEFT:
            case KeyEvent.VK_A:
                leftPressed = true;
                break;
            case KeyEvent.VK_RIGHT:
            case KeyEvent.VK_D:
                rightPressed = true;
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        switch (keyCode) {
            case KeyEvent.VK_UP:
            case KeyEvent.VK_W:
                upPressed = false;
                break;
            case KeyEvent.VK_DOWN:
            case KeyEvent.VK_S:
                downPressed = false;
                break;
            case KeyEvent.VK_LEFT:
            case KeyEvent.VK_A:
                leftPressed = false;
                break;
            case KeyEvent.VK_RIGHT:
            case KeyEvent.VK_D:
                rightPressed = false;
                break;
        }
    }


    // ----- handling camera -------------------------------------------------------------------------------------------
    public void moveCamera(Camera camera) {

        // move camera
        if (upPressed) {
            camera.move(0, camera.cameraSpeed);
        }
        if (downPressed) {
            camera.move(0, -camera.cameraSpeed);
        }
        if (leftPressed) {
            camera.move(camera.cameraSpeed, 0);
        }
        if (rightPressed) {
            camera.move(-camera.cameraSpeed, 0);
        }
    }
}