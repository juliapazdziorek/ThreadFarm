import javax.swing.*;
import java.awt.*;

public class FarmPanel extends JPanel {

    // ----- properties ------------------------------------------------------------------------------------------------

    // essentials
    Camera camera;
    SpritesHandler spritesHandler;

    // finals screen set up
    final int originalTileSize = 16;
    final int scale = 3;
    final int tileSize = originalTileSize * scale;
    final int maxScreenColumns = 16;
    final int maxScreenRows = 12;
    final int screenWidth = tileSize * maxScreenColumns;
    final int screenHeight = tileSize * maxScreenRows;


    // ----- constructor -----------------------------------------------------------------------------------------------

    public FarmPanel(Camera camera, SpritesHandler spritesHandler) {
        this.camera = camera;
        this.spritesHandler = spritesHandler;
        setPreferredSize(new Dimension(screenWidth, screenHeight));
        setBackground(Color.decode("#9bd4c3"));
        setDoubleBuffered(true); // better rendering performance
        setFocusable(true);
    }


    // ----- updating --------------------------------------------------------------------------------------------------
    public void update() {
        spritesHandler.updateAll();
    }


    // ----- rendering -------------------------------------------------------------------------------------------------
    @Override
    protected void paintComponent(Graphics graphics) {
        Graphics2D graphics2D = (Graphics2D) graphics;
        spritesHandler.renderAll(graphics2D, camera);
        graphics2D.dispose();
    }

}