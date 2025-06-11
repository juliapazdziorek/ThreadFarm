public class Camera {

    // ----- properties ------------------------------------------------------------------------------------------------

    // finals -> farmMap information
    public final int scale = 3;
    public final int tileSize = 16;
    public final int scaledTileSize = scale * tileSize;
    public final int mapWidthTiles = 48;
    public final int mapHeightTiles = 36;

    public final int mapWidthPixels = mapWidthTiles * tileSize * scale;
    public final int mapHeightPixels = mapHeightTiles  * tileSize * scale;

    public final int viewWidthTiles;
    public final int viewHeightTiles;

    public final int cameraSpeed = 8;


    // camera state
    public int cameraX;
    public int cameraY;


    // ----- constructor -----------------------------------------------------------------------------------------------
    public Camera(int viewWidthTiles, int viewHeightTiles) {

        // camera view size
        this.viewWidthTiles = viewWidthTiles;
        this.viewHeightTiles = viewHeightTiles;

        // initial coords
        this.cameraX = - 500;
        this.cameraY = - 450;

    }


    // ----- moving ----------------------------------------------------------------------------------------------------
    public void move(int x, int y) { // wtf in linear algebra

        if (cameraX + x < 0 && (-cameraX) + viewWidthTiles * tileSize * scale - x < mapWidthPixels) {
            cameraX += x;
        }

        if (cameraY + y < 0 && (-cameraY) + viewHeightTiles * tileSize * scale - y < mapHeightPixels) {
            cameraY += y;
        }
    }
}