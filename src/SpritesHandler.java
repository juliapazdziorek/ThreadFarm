import zad1.Sprites.Coordinates;
import zad1.Sprites.FarmCat;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class SpritesHandler {

    // ----- properties ------------------------------------------------------------------------------------------------

    // finals
    final int tileSize = 16;

    // sprites preparation
    public HashMap<String, BufferedImage> assets;

    // farmMap
    FarmMap farmMap;

    // farmCats
    HashMap<String, FarmCat> farmCats;

    // panels properties
    public Color borderColor;
    public Color backgroundColor;
    public Color labelColor;
    public Font dayDreamFont;
    public Font minecraftiaFont;


    // ----- constructor -----------------------------------------------------------------------------------------------
    public SpritesHandler() {

        // sprites preparation
        prepareAssets();

        // farmMap
        farmMap = new FarmMap(this);

        // farmCats
        farmCats = new HashMap<>();
        initializeCatList();

        // panels properties
        initializePanelProperties();
    }

    // ----- creating sprites ------------------------------------------------------------------------------------------
    private void prepareAssets() {

        // map
        assets = new HashMap<>();

        // water sheet
        try {
            BufferedImage water = ImageIO.read(new File("src/zad1/Graphics/Tiles/water.png"));
            assets.put("water", water);

        } catch (IOException exception) {
            throw new RuntimeException("Problem with creating BufferImage from file: src/zad1/Graphics/Tiles/water.png \n" + exception.getMessage());
        }

        // soil
        try {
            BufferedImage soil = ImageIO.read(new File("src/zad1/Graphics/Tiles/soil.png"));
            assets.put("plainSoil", soil.getSubimage(tileSize, tileSize, tileSize, tileSize));
            assets.put("darkSand", soil.getSubimage(2 * tileSize, 5 * tileSize, tileSize, tileSize));
            assets.put("threeDarkStones", soil.getSubimage(3 * tileSize, 5 * tileSize, tileSize, tileSize));
            assets.put("twoDarkStones", soil.getSubimage(4 * tileSize, 5 * tileSize, tileSize, tileSize));
            assets.put("whiteSand", soil.getSubimage(2 * tileSize, 6 * tileSize, tileSize, tileSize));
            assets.put("threeWhiteStones", soil.getSubimage(3 * tileSize, 6 * tileSize, tileSize, tileSize));
            assets.put("twoWhiteStones", soil.getSubimage(4 * tileSize, 6 * tileSize, tileSize, tileSize));

        } catch (IOException exception) {
            throw new RuntimeException("Problem with creating BufferImage from file: src/zad1/Graphics/Tiles/soil.png \n" + exception.getMessage());
        }

        // grassWater
        try {
            BufferedImage grassWater = ImageIO.read(new File("src/zad1/Graphics/Tiles/grassWater.png"));
            assets.put("upGrass", grassWater.getSubimage(tileSize, 0, tileSize, tileSize));
            assets.put("leftUpCornerWaterGrass", grassWater.getSubimage(0, 0, tileSize, tileSize));
            assets.put("leftBottomCornerWaterGrass", grassWater.getSubimage(0, 2 * tileSize, tileSize, tileSize));
            assets.put("rightUpCornerWaterGrass", grassWater.getSubimage(2 * tileSize, 0, tileSize, tileSize));
            assets.put("rightBottomCornerWaterGrass", grassWater.getSubimage(2 * tileSize, 2 * tileSize, tileSize, tileSize));
            assets.put("leftWaterGrass", grassWater.getSubimage(0, tileSize, tileSize, tileSize));
            assets.put("rightWaterGrass", grassWater.getSubimage(2 * tileSize, tileSize, tileSize, tileSize));
            assets.put("bottomWaterGrass", grassWater.getSubimage(tileSize, 2 * tileSize, tileSize, tileSize));
            assets.put("leftUpInnerWaterGrass", grassWater.getSubimage(6 * tileSize, 2 * tileSize, tileSize, tileSize));
            assets.put("leftBottomInnerWaterGrass", grassWater.getSubimage(6 * tileSize, tileSize, tileSize, tileSize));
            assets.put("rightUpInnerWaterGrass", grassWater.getSubimage(5 * tileSize, 2 * tileSize, tileSize, tileSize));
            assets.put("rightBottomInnerWaterGrass", grassWater.getSubimage(5 * tileSize, tileSize, tileSize, tileSize));
            assets.put("grassTile", grassWater.getSubimage(tileSize, tileSize, tileSize, tileSize));
            assets.put("weirdWaterGrass1", grassWater.getSubimage(5 * tileSize, 4 * tileSize, tileSize, tileSize));
            assets.put("weirdWaterGrass2", grassWater.getSubimage(2 * tileSize, 3 * tileSize, tileSize, tileSize));
            assets.put("weirdWaterGrass3", grassWater.getSubimage(3 * tileSize, 3 * tileSize, tileSize, tileSize));
            assets.put("weirdWaterGrass4", grassWater.getSubimage(5 * tileSize, 3 * tileSize, tileSize, tileSize));
            assets.put("weirdWaterGrass5", grassWater.getSubimage(9 * tileSize, 3 * tileSize, tileSize, tileSize));
            assets.put("weirdWaterGrass6", grassWater.getSubimage(0, 3 * tileSize, tileSize, tileSize));
            assets.put("weirdWaterGrass7", grassWater.getSubimage(3 * tileSize, 2 * tileSize, tileSize, tileSize));
            assets.put("bigGrassGreen", grassWater.getSubimage(0, 5 * tileSize, tileSize, tileSize));
            assets.put("smallerGrassGreen", grassWater.getSubimage(tileSize, 5 * tileSize, tileSize, tileSize));
            assets.put("smallGrassGreen", grassWater.getSubimage(2 * tileSize, 5 * tileSize, tileSize, tileSize));
            assets.put("twoDarkRocksGrass", grassWater.getSubimage(3 * tileSize, 5 * tileSize, tileSize, tileSize));
            assets.put("threeDarkRocksGrass", grassWater.getSubimage(4 * tileSize, 5 * tileSize, tileSize, tileSize));
            assets.put("threeFlowersGrass", grassWater.getSubimage(5 * tileSize, 5 * tileSize, tileSize, tileSize));
            assets.put("bigGrassLight", grassWater.getSubimage(0, 6 * tileSize, tileSize, tileSize));
            assets.put("smallerGrassLight", grassWater.getSubimage(2 * tileSize, 6 * tileSize, tileSize, tileSize));
            assets.put("smallGrassLight", grassWater.getSubimage(tileSize, 6 * tileSize, tileSize, tileSize));
            assets.put("twoLightRocksGrass", grassWater.getSubimage(3 * tileSize, 6 * tileSize, tileSize, tileSize));
            assets.put("threeLightRocksGrass", grassWater.getSubimage(4 * tileSize, 6 * tileSize, tileSize, tileSize));
            assets.put("twoFlowersGrass", grassWater.getSubimage(5 * tileSize, 6 * tileSize, tileSize, tileSize));

        } catch (IOException exception) {
            throw new RuntimeException("Problem with creating BufferImage from file: src/zad1/Graphics/Tiles/grassWater.png \n" + exception.getMessage());
        }

        // grass
        try {
            BufferedImage grass = ImageIO.read(new File("src/zad1/Graphics/Tiles/grass.png"));
            assets.put("grassLayerBottom", grass.getSubimage(tileSize, 2 * tileSize, tileSize, tileSize));
            assets.put("grassLayerLeft", grass.getSubimage(0, tileSize, tileSize, tileSize));
            assets.put("grassLayerRight", grass.getSubimage(2 * tileSize, tileSize, tileSize, tileSize));
            assets.put("grassLayerUpLeftCorner", grass.getSubimage(0, 0, tileSize, tileSize));
            assets.put("grassLayerBottomLeftCorner", grass.getSubimage(0, 2 * tileSize, tileSize, tileSize));
            assets.put("grassLayerUpRightCorner", grass.getSubimage(2 * tileSize, 0, tileSize, tileSize));
            assets.put("grassLayerBottomRightCorner", grass.getSubimage(2 * tileSize, 2 * tileSize, tileSize, tileSize));
            assets.put("grassLayerUpLeftInner", grass.getSubimage(6 * tileSize, 2 * tileSize, tileSize, tileSize));
            assets.put("grassLayerBottomLeftInner", grass.getSubimage(6 * tileSize, tileSize, tileSize, tileSize));
            assets.put("grassLayerUpRightInner", grass.getSubimage(5 * tileSize, 2 * tileSize, tileSize, tileSize));
            assets.put("grassLayerBottomRightInner", grass.getSubimage(5 * tileSize, tileSize, tileSize, tileSize));
            assets.put("weirdGrassLayer1", grass.getSubimage(3 * tileSize, 3 * tileSize, tileSize, tileSize));
            assets.put("weirdGrassLayer2", grass.getSubimage(4 * tileSize, tileSize, tileSize, tileSize));
            assets.put("weirdGrassLayer3", grass.getSubimage(3 * tileSize, 2 * tileSize, tileSize, tileSize));
            assets.put("weirdGrassLayer4", grass.getSubimage(7 * tileSize, 0, tileSize, tileSize));
            assets.put("weirdGrassLayer5", grass.getSubimage(0, 3 * tileSize, tileSize, tileSize));
            assets.put("weirdGrassLayer6", grass.getSubimage(2 * tileSize, 3 * tileSize, tileSize, tileSize));

        } catch (IOException exception) {
            throw new RuntimeException("Problem with creating BufferImage from file: src/zad1/Graphics/Tiles/grass.png \n" + exception.getMessage());
        }

        // darkGrass
        try {
            BufferedImage grass = ImageIO.read(new File("src/zad1/Graphics/Tiles/darkGrass.png"));
            assets.put("darkGrassTile", grass.getSubimage(tileSize, tileSize, tileSize, tileSize));
            assets.put("darkGrassUp", grass.getSubimage(tileSize, 0, tileSize, tileSize));
            assets.put("darkGrassLeft", grass.getSubimage(0, tileSize, tileSize, tileSize));
            assets.put("darkGrassBottom", grass.getSubimage(tileSize, 2 * tileSize, tileSize, tileSize));
            assets.put("darkGrassRight", grass.getSubimage(2 * tileSize, tileSize, tileSize, tileSize));
            assets.put("darkGrassLeftUpCorner", grass.getSubimage(0, 0, tileSize, tileSize));
            assets.put("darkGrassLeftBottomCorner", grass.getSubimage(0, 2 * tileSize, tileSize, tileSize));
            assets.put("darkGrassRightUpCorner", grass.getSubimage(2 * tileSize, 0, tileSize, tileSize));
            assets.put("darkGrassRightBottomCorner", grass.getSubimage(2 * tileSize, 2 * tileSize, tileSize, tileSize));
            assets.put("darkGrassUpLeftInner", grass.getSubimage(6 * tileSize, 2 * tileSize, tileSize, tileSize));
            assets.put("darkGrassBottomLeftInner", grass.getSubimage(6 * tileSize, tileSize, tileSize, tileSize));
            assets.put("darkGrassUpRightInner", grass.getSubimage(5 * tileSize, 2 * tileSize, tileSize, tileSize));
            assets.put("darkGrassBottomRightInner", grass.getSubimage(5 * tileSize, tileSize, tileSize, tileSize));
            assets.put("weirdDarkGrass1", grass.getSubimage(5 * tileSize, 0, tileSize, tileSize));
            assets.put("weirdDarkGrass2", grass.getSubimage(2 * tileSize, 3 * tileSize, tileSize, tileSize));
            assets.put("weirdDarkGrass3", grass.getSubimage(0, 3 * tileSize, tileSize, tileSize));
            assets.put("weirdDarkGrass4", grass.getSubimage(6 * tileSize, 0, tileSize, tileSize));
            assets.put("weirdDarkGrass5", grass.getSubimage(9 * tileSize, 0, tileSize, tileSize));
            assets.put("weirdDarkGrass6", grass.getSubimage(7 * tileSize, tileSize, tileSize, tileSize));
            assets.put("weirdDarkGrass7", grass.getSubimage(4 * tileSize, 3 * tileSize, tileSize, tileSize));
            assets.put("weirdDarkGrass8", grass.getSubimage(7 * tileSize, 0, tileSize, tileSize));
            assets.put("weirdDarkGrass9", grass.getSubimage(4 * tileSize, 2 * tileSize, tileSize, tileSize));
            assets.put("weirdDarkGrass10", grass.getSubimage(3 * tileSize, 2 * tileSize, tileSize, tileSize));
            assets.put("weirdDarkGrass11", grass.getSubimage(3 * tileSize, 3 * tileSize, tileSize, tileSize));
            assets.put("weirdDarkGrass12", grass.getSubimage(3 * tileSize, 0, tileSize, tileSize));
            assets.put("weirdDarkGrass13", grass.getSubimage(10 * tileSize, 3 * tileSize, tileSize, tileSize));
            assets.put("weirdDarkGrass14", grass.getSubimage(tileSize, 3 * tileSize, tileSize, tileSize));
            assets.put("weirdDarkGrass15", grass.getSubimage(9 * tileSize, 2 * tileSize, tileSize, tileSize));
            assets.put("weirdDarkGrass16", grass.getSubimage(9 * tileSize, tileSize, tileSize, tileSize));
            assets.put("weirdDarkGrass17", grass.getSubimage(4 * tileSize, 0, tileSize, tileSize));
            assets.put("weirdDarkGrass18", grass.getSubimage(10 * tileSize, 2 * tileSize, tileSize, tileSize));
            assets.put("weirdDarkGrass19", grass.getSubimage(9 * tileSize, 3 * tileSize, tileSize, tileSize));
            assets.put("weirdDarkGrass20", grass.getSubimage(7 * tileSize, 2 * tileSize, tileSize, tileSize));
            assets.put("weirdDarkGrass21", grass.getSubimage(3 * tileSize, tileSize, tileSize, tileSize));
            assets.put("threeDarkStonesDarkGrass", grass.getSubimage(4 * tileSize, 5 * tileSize, tileSize, tileSize));
            assets.put("bigGrassDarkGrass", grass.getSubimage(0, 5 * tileSize, tileSize, tileSize));
            assets.put("threeGrassDarkGrass", grass.getSubimage(2 * tileSize, 5 * tileSize, tileSize, tileSize));
            assets.put("twoDarkStonesDarkGrass", grass.getSubimage(3 * tileSize, 5 * tileSize, tileSize, tileSize));

        } catch (IOException exception) {
            throw new RuntimeException("Problem with creating BufferImage from file: src/zad1/Graphics/Tiles/darkGrass.png \n" + exception.getMessage());
        }

        // waterObjects
        try {
            BufferedImage waterObjects = ImageIO.read(new File("src/zad1/Graphics/Tiles/waterObjects.png"));
            assets.put("waterStone1", waterObjects.getSubimage( 0, 0, tileSize, tileSize));
            assets.put("waterStone2", waterObjects.getSubimage( tileSize, 0, tileSize, tileSize));
            assets.put("waterStone3", waterObjects.getSubimage( 2 * tileSize, 0, tileSize, tileSize));
            assets.put("waterStone4", waterObjects.getSubimage( 3 * tileSize, 0, tileSize, tileSize));
            assets.put("bigWaterStone1", waterObjects.getSubimage( 4 * tileSize, 0, tileSize, tileSize));
            assets.put("bigWaterStone2", waterObjects.getSubimage( 5 * tileSize, 0, tileSize, tileSize));
            assets.put("threeWaterSticks", waterObjects.getSubimage( 6 * tileSize, 0, tileSize, tileSize));
            assets.put("fourWaterSticks", waterObjects.getSubimage( 7 * tileSize, 0, tileSize, tileSize));
            assets.put("waterLily1", waterObjects.getSubimage( 8 * tileSize, 0, tileSize, tileSize));
            assets.put("waterLily2", waterObjects.getSubimage( 9 * tileSize, 0, tileSize, tileSize));
            assets.put("waterLily3", waterObjects.getSubimage( 10 * tileSize, 0, tileSize, tileSize));
            assets.put("waterLily4", waterObjects.getSubimage( 11 * tileSize, 0, tileSize, tileSize));

        } catch (IOException exception) {
            throw new RuntimeException("Problem with creating BufferImage from file: src/zad1/Graphics/Tiles/waterObjects.png \n" + exception.getMessage());
        }

        // mushroomsFlowersStones
        try {
            BufferedImage mushroomsFlowersStones = ImageIO.read(new File("src/zad1/Graphics/Tiles/mushroomsFlowersStones.png"));
            assets.put("stone1", mushroomsFlowersStones.getSubimage( 0, tileSize, tileSize, tileSize));
            assets.put("stone2", mushroomsFlowersStones.getSubimage( tileSize, tileSize, tileSize, tileSize));
            assets.put("stone3", mushroomsFlowersStones.getSubimage( 2 * tileSize, tileSize, tileSize, tileSize));
            assets.put("stone4", mushroomsFlowersStones.getSubimage( 3 * tileSize, tileSize, tileSize, tileSize));
            assets.put("stone5", mushroomsFlowersStones.getSubimage( 4 * tileSize, tileSize, tileSize, tileSize));
            assets.put("stone6", mushroomsFlowersStones.getSubimage( 5 * tileSize, tileSize, tileSize, tileSize));
            assets.put("grassDecor1", mushroomsFlowersStones.getSubimage(0, 2 * tileSize, tileSize, tileSize));
            assets.put("grassDecor2", mushroomsFlowersStones.getSubimage(tileSize, 2 * tileSize, tileSize, tileSize));
            assets.put("grassDecor3", mushroomsFlowersStones.getSubimage( 2 * tileSize, 2 * tileSize, tileSize, tileSize));
            assets.put("grassDecor4", mushroomsFlowersStones.getSubimage( 3 * tileSize, 2 * tileSize, tileSize, tileSize));
            assets.put("toadstool1", mushroomsFlowersStones.getSubimage( 0, 0, tileSize, tileSize));
            assets.put("toadstool2", mushroomsFlowersStones.getSubimage( tileSize, 0, tileSize, tileSize));
            assets.put("mushroom1", mushroomsFlowersStones.getSubimage( 3 * tileSize, 0, tileSize, tileSize));
            assets.put("mushroom2", mushroomsFlowersStones.getSubimage( 4 * tileSize, 0, tileSize, tileSize));
            assets.put("mushroom3", mushroomsFlowersStones.getSubimage( 5 * tileSize, 0, tileSize, tileSize));
            assets.put("dandelion1", mushroomsFlowersStones.getSubimage( 0, 3 * tileSize, tileSize, tileSize));
            assets.put("dandelion2", mushroomsFlowersStones.getSubimage( tileSize, 3 * tileSize, tileSize, tileSize));
            assets.put("dandelion3", mushroomsFlowersStones.getSubimage( 2 * tileSize, 3 * tileSize, tileSize, tileSize));
            assets.put("violet1", mushroomsFlowersStones.getSubimage( 0, 4 * tileSize, tileSize, tileSize));
            assets.put("violet2", mushroomsFlowersStones.getSubimage( tileSize, 4 * tileSize, tileSize, tileSize));
            assets.put("violet3", mushroomsFlowersStones.getSubimage( 2 * tileSize, 4 * tileSize, tileSize, tileSize));
            assets.put("peony1", mushroomsFlowersStones.getSubimage( 4 * tileSize, 3 * tileSize, tileSize, tileSize));
            assets.put("peony2", mushroomsFlowersStones.getSubimage( 5 * tileSize, 3 * tileSize, tileSize, tileSize));
            assets.put("peony3", mushroomsFlowersStones.getSubimage( 6 * tileSize, 3 * tileSize, tileSize, tileSize));
            assets.put("peony4", mushroomsFlowersStones.getSubimage( 7 * tileSize, 3 * tileSize, tileSize, tileSize));
            assets.put("cornFlower1", mushroomsFlowersStones.getSubimage( 4 * tileSize, 4 * tileSize, tileSize, tileSize));
            assets.put("cornFlower2", mushroomsFlowersStones.getSubimage( 5 * tileSize, 4 * tileSize, tileSize, tileSize));
            assets.put("cornFlower3", mushroomsFlowersStones.getSubimage( 6 * tileSize, 4 * tileSize, tileSize, tileSize));
            assets.put("cornFlower4", mushroomsFlowersStones.getSubimage( 7 * tileSize, 4 * tileSize, tileSize, tileSize));
            assets.put("daisy1", mushroomsFlowersStones.getSubimage( 9 * tileSize, 3 * tileSize, tileSize, tileSize));
            assets.put("daisy2", mushroomsFlowersStones.getSubimage( 10 * tileSize, 3 * tileSize, tileSize, tileSize));
            assets.put("daisy3", mushroomsFlowersStones.getSubimage( 11 * tileSize, 3 * tileSize, tileSize, tileSize));
            assets.put("hyacinth1", mushroomsFlowersStones.getSubimage( 10 * tileSize, 4 * tileSize, tileSize, tileSize));
            assets.put("hyacinth2", mushroomsFlowersStones.getSubimage( 11 * tileSize, 4 * tileSize, tileSize, tileSize));

        } catch (IOException exception) {
            throw new RuntimeException("Problem with creating BufferImage from file: src/zad1/Graphics/Tiles/mushroomsFlowersStones.png \n" + exception.getMessage());
        }

        // picnicBlanket
        try {
            BufferedImage picnicBlanket = ImageIO.read(new File("src/zad1/Graphics/Tiles/picnicBlanket.png"));
            assets.put("picnicBlanket1", picnicBlanket.getSubimage( 0, 0, tileSize, tileSize));
            assets.put("picnicBlanket2", picnicBlanket.getSubimage( tileSize, 0, tileSize, tileSize));
            assets.put("picnicBlanket3", picnicBlanket.getSubimage( 2 * tileSize, 0, tileSize, tileSize));
            assets.put("picnicBlanket4", picnicBlanket.getSubimage( 0, tileSize, tileSize, tileSize));
            assets.put("picnicBlanket5", picnicBlanket.getSubimage( tileSize, tileSize, tileSize, tileSize));
            assets.put("picnicBlanket6", picnicBlanket.getSubimage( 2 * tileSize, tileSize, tileSize, tileSize));
            assets.put("picnicBlanket7", picnicBlanket.getSubimage( 0, 2 * tileSize, tileSize, tileSize));
            assets.put("picnicBlanket8", picnicBlanket.getSubimage( tileSize, 2 * tileSize, tileSize, tileSize));
            assets.put("picnicBlanket9", picnicBlanket.getSubimage( 2 * tileSize, 2 * tileSize, tileSize, tileSize));

        } catch (IOException exception) {
            throw new RuntimeException("Problem with creating BufferImage from file: src/zad1/Graphics/Tiles/picnicBlanket.png \n" + exception.getMessage());
        }

        // barnStructures
        try {
            BufferedImage barnStructures = ImageIO.read(new File("src/zad1/Graphics/Tiles/barnStructures.png"));
            assets.put("hay1", barnStructures.getSubimage( 0, 3 * tileSize, tileSize, tileSize));
            assets.put("hay2", barnStructures.getSubimage( tileSize, 3 * tileSize, tileSize, tileSize));
            assets.put("smallHayBale", barnStructures.getSubimage( 0, tileSize, tileSize, tileSize));
            assets.put("bigHayBale1", barnStructures.getSubimage( 0, 2 * tileSize, tileSize, tileSize));
            assets.put("bigHayBale2", barnStructures.getSubimage( tileSize, 2 * tileSize, tileSize, tileSize));
            assets.put("box", barnStructures.getSubimage( 0, 0, tileSize, tileSize));
            assets.put("twoBoxes1", barnStructures.getSubimage( tileSize, 0, tileSize, tileSize));
            assets.put("twoBoxes2", barnStructures.getSubimage( 2 * tileSize, 0, tileSize, tileSize));
            assets.put("twoBoxes3", barnStructures.getSubimage( tileSize, tileSize, tileSize, tileSize));
            assets.put("twoBoxes4", barnStructures.getSubimage( 2 * tileSize, tileSize, tileSize, tileSize));

        } catch (IOException exception) {
            throw new RuntimeException("Problem with creating BufferImage from file: src/zad1/Graphics/Tiles/barnStructures.png \n" + exception.getMessage());
        }

        // fences
        try {
            BufferedImage fences = ImageIO.read(new File("src/zad1/Graphics/Tiles/fences.png"));
            assets.put("fenceDown", fences.getSubimage( 0, 0, tileSize, tileSize));
            assets.put("fenceVertical", fences.getSubimage( 0, tileSize, tileSize, tileSize));
            assets.put("fenceUp", fences.getSubimage( 0, 2 * tileSize, tileSize, tileSize));
            assets.put("fenceAlone", fences.getSubimage( 0, 3 * tileSize, tileSize, tileSize));
            assets.put("fenceLeft", fences.getSubimage( tileSize, 3 * tileSize, tileSize, tileSize));
            assets.put("fenceHorizontal", fences.getSubimage( 2 * tileSize, 3 * tileSize, tileSize, tileSize));
            assets.put("fenceRight", fences.getSubimage( 3 * tileSize, 3 * tileSize, tileSize, tileSize));
            assets.put("fenceWeird", fences.getSubimage( 3 * tileSize, 2 * tileSize, tileSize, tileSize));

        } catch (IOException exception) {
            throw new RuntimeException("Problem with creating BufferImage from file: src/zad1/Graphics/Tiles/fences.png \n" + exception.getMessage());
        }

        // gates
        try {
            BufferedImage gates = ImageIO.read(new File("src/zad1/Graphics/Tiles/gates.png"));
            assets.put("gate1", gates.getSubimage( 17 * tileSize, 0, tileSize, tileSize));
            assets.put("gate2", gates.getSubimage( 10 * tileSize, 0, tileSize, tileSize));
            assets.put("gate3", gates.getSubimage( 13 * tileSize, 0, tileSize, tileSize));
            assets.put("gate4", gates.getSubimage( 18 * tileSize, 0, tileSize, tileSize));
            assets.put("gateLeft", gates.getSubimage( 0, 0, tileSize, tileSize));
            assets.put("gateRight", gates.getSubimage( 3 * tileSize, 0, tileSize, tileSize));

        } catch (IOException exception) {
            throw new RuntimeException("Problem with creating BufferImage from file: src/zad1/Graphics/Tiles/gates.png \n" + exception.getMessage());
        }

        // woodenHouse
        try {
            BufferedImage woodenHouse = ImageIO.read(new File("src/zad1/Graphics/Tiles/woodenHouse.png"));
            assets.put("floor", woodenHouse.getSubimage( tileSize, tileSize, tileSize, tileSize));
            assets.put("leftHouse", woodenHouse.getSubimage( 3 * tileSize, tileSize, tileSize, tileSize));
            assets.put("windowHouse", woodenHouse.getSubimage( 3 * tileSize, 2 * tileSize, tileSize, tileSize));
            assets.put("wallHouse", woodenHouse.getSubimage( tileSize, 2 * tileSize, tileSize, tileSize));
            assets.put("rightHouse", woodenHouse.getSubimage( 4 * tileSize, tileSize, tileSize, tileSize));

        } catch (IOException exception) {
            throw new RuntimeException("Problem with creating BufferImage from file: src/zad1/Graphics/Tiles/woodenHouse.png \n" + exception.getMessage());
        }

        // door
        try {
            BufferedImage door = ImageIO.read(new File("src/zad1/Graphics/Tiles/door.png"));
            assets.put("door", door.getSubimage( tileSize, 0, tileSize, tileSize));

        } catch (IOException exception) {
            throw new RuntimeException("Problem with creating BufferImage from file: src/zad1/Graphics/Tiles/door.png \n" + exception.getMessage());
        }

        // paths
        try {
            BufferedImage paths = ImageIO.read(new File("src/zad1/Graphics/Tiles/paths.png"));
            assets.put("pathUp", paths.getSubimage( 0, 0, tileSize, tileSize));
            assets.put("pathVertical", paths.getSubimage( 0, tileSize, tileSize, tileSize));
            assets.put("pathBottom", paths.getSubimage( 0, 2 * tileSize, tileSize, tileSize));
            assets.put("pathLeft", paths.getSubimage( tileSize, 3 * tileSize, tileSize, tileSize));
            assets.put("pathHorizontal", paths.getSubimage( 2 * tileSize, 3 * tileSize, tileSize, tileSize));
            assets.put("pathRight", paths.getSubimage( 3 * tileSize, 3 * tileSize, tileSize, tileSize));
            assets.put("pathArc1", paths.getSubimage( tileSize, 2 * tileSize, tileSize, tileSize));
            assets.put("pathArc2", paths.getSubimage( 2 * tileSize, 2 *tileSize, tileSize, tileSize));
            assets.put("pathArc3", paths.getSubimage( tileSize, tileSize, tileSize, tileSize));

        } catch (IOException exception) {
            throw new RuntimeException("Problem with creating BufferImage from file: src/zad1/Graphics/Tiles/paths.png \n" + exception.getMessage());
        }

        // treesBushes
        try {
            BufferedImage treesBushes = ImageIO.read(new File("src/zad1/Graphics/Tiles/treesBushes.png"));
            assets.put("bigTree1", treesBushes.getSubimage( 9 * tileSize, 3 * tileSize, tileSize, tileSize));
            assets.put("bigTree2", treesBushes.getSubimage( 10 * tileSize, 3 * tileSize, tileSize, tileSize));
            assets.put("bigTree3", treesBushes.getSubimage( 11 * tileSize, 3 * tileSize, tileSize, tileSize));
            assets.put("bigTree4", treesBushes.getSubimage( 9 * tileSize, 4 * tileSize, tileSize, tileSize));
            assets.put("bigTree5", treesBushes.getSubimage( 10 * tileSize, 4 * tileSize, tileSize, tileSize));
            assets.put("bigTree6", treesBushes.getSubimage( 11 * tileSize, 4 * tileSize, tileSize, tileSize));
            assets.put("bigTree7", treesBushes.getSubimage( 9 * tileSize, 5 * tileSize, tileSize, tileSize));
            assets.put("bigTree8", treesBushes.getSubimage( 10 * tileSize, 5 * tileSize, tileSize, tileSize));
            assets.put("bigTree9", treesBushes.getSubimage( 11 * tileSize, 5 * tileSize, tileSize, tileSize));
            assets.put("tree1", treesBushes.getSubimage( tileSize, 0, tileSize, tileSize));
            assets.put("tree2", treesBushes.getSubimage( 2 * tileSize, 0, tileSize, tileSize));
            assets.put("tree3", treesBushes.getSubimage( tileSize, tileSize, tileSize, tileSize));
            assets.put("tree4", treesBushes.getSubimage( 2 * tileSize, tileSize, tileSize, tileSize));
            assets.put("smallTree1", treesBushes.getSubimage( 0, 0, tileSize, tileSize));
            assets.put("smallTree2", treesBushes.getSubimage( 0, tileSize, tileSize, tileSize));
            assets.put("bush", treesBushes.getSubimage( tileSize, 3 * tileSize, tileSize, tileSize));
            assets.put("raspberryBush", treesBushes.getSubimage( 2 * tileSize, 3 * tileSize, tileSize, tileSize));
            assets.put("plumBush", treesBushes.getSubimage( 3 * tileSize, 3 * tileSize, tileSize, tileSize));
            assets.put("blueberryBush", treesBushes.getSubimage( 4 * tileSize, 3 * tileSize, tileSize, tileSize));

        } catch (IOException exception) {
            throw new RuntimeException("Problem with creating BufferImage from file: src/zad1/Graphics/Tiles/treesBushes.png \n" + exception.getMessage());
        }

        // waterTray
        try {
            BufferedImage waterTray = ImageIO.read(new File("src/zad1/Graphics/Tiles/waterTray.png"));
            assets.put("waterTray1", waterTray.getSubimage( 0, 0, tileSize, tileSize));
            assets.put("waterTray2", waterTray.getSubimage( tileSize, 0, tileSize, tileSize));

        } catch (IOException exception) {
            throw new RuntimeException("Problem with creating BufferImage from file: src/zad1/Graphics/Tiles/waterTray.png \n" + exception.getMessage());
        }

        // waterWell
        try {
            BufferedImage waterWell = ImageIO.read(new File("src/zad1/Graphics/Tiles/waterWell.png"));
            assets.put("waterWell1", waterWell.getSubimage( 0, 0, tileSize, tileSize));
            assets.put("waterWell2", waterWell.getSubimage( tileSize, 0, tileSize, tileSize));
            assets.put("waterWell3", waterWell.getSubimage( 0, tileSize, tileSize, tileSize));
            assets.put("waterWell4", waterWell.getSubimage( tileSize, tileSize, tileSize, tileSize));

        } catch (IOException exception) {
            throw new RuntimeException("Problem with creating BufferImage from file: src/zad1/Graphics/Tiles/waterWell.png \n" + exception.getMessage());
        }

        // workStation
        try {
            BufferedImage workStation = ImageIO.read(new File("src/zad1/Graphics/Tiles/workStation.png"));
            assets.put("workStation1", workStation.getSubimage( 0, 0, tileSize, tileSize));
            assets.put("workStation2", workStation.getSubimage( tileSize, 0, tileSize, tileSize));
            assets.put("workStation3", workStation.getSubimage( 0, tileSize, tileSize, tileSize));
            assets.put("workStation4", workStation.getSubimage( tileSize, tileSize, tileSize, tileSize));

        } catch (IOException exception) {
            throw new RuntimeException("Problem with creating BufferImage from file: src/zad1/Graphics/Tiles/workStation.png \n" + exception.getMessage());
        }

        // coop
        try {
            BufferedImage coop = ImageIO.read(new File("src/zad1/Graphics/Tiles/coop.png"));
            assets.put("coop1", coop.getSubimage( 0, 5 * tileSize, tileSize, tileSize));
            assets.put("coop2", coop.getSubimage( tileSize, 5 * tileSize, tileSize, tileSize));
            assets.put("coop3", coop.getSubimage( 2 * tileSize, 5 * tileSize, tileSize, tileSize));
            assets.put("coop4", coop.getSubimage( 0, 6 * tileSize, tileSize, tileSize));
            assets.put("coop5", coop.getSubimage( tileSize, 6 * tileSize, tileSize, tileSize));
            assets.put("coop6", coop.getSubimage( 2 * tileSize, 6 * tileSize, tileSize, tileSize));
            assets.put("coop7", coop.getSubimage( 0, 7 * tileSize, tileSize, tileSize));
            assets.put("coop8", coop.getSubimage( tileSize, 7 * tileSize, tileSize, tileSize));
            assets.put("coop9", coop.getSubimage( 2 * tileSize, 7 * tileSize, tileSize, tileSize));

        } catch (IOException exception) {
            throw new RuntimeException("Problem with creating BufferImage from file: src/zad1/Graphics/Tiles/coop.png \n" + exception.getMessage());
        }

        // roof
        try {
            BufferedImage roof = ImageIO.read(new File("src/zad1/Graphics/Tiles/houseRoof.png"));
            assets.put("backLeftRoof", roof.getSubimage( 0, 0, tileSize, tileSize));
            assets.put("backRoof", roof.getSubimage( tileSize, 0, tileSize, tileSize));
            assets.put("backRightRoof", roof.getSubimage( 2 * tileSize, 0, tileSize, tileSize));
            assets.put("reversedLeftRoof", roof.getSubimage( 0, tileSize, tileSize, tileSize));
            assets.put("reversedRoof", roof.getSubimage( tileSize, tileSize, tileSize, tileSize));
            assets.put("reversedRightRoof", roof.getSubimage( 2 * tileSize, tileSize, tileSize, tileSize));
            assets.put("centerLeftRoof", roof.getSubimage( 0, 2 * tileSize, tileSize, tileSize));
            assets.put("centerRoof", roof.getSubimage( tileSize, 2 * tileSize, tileSize, tileSize));
            assets.put("centerRightRoof", roof.getSubimage( 2 * tileSize, 2 * tileSize, tileSize, tileSize));
            assets.put("chimneyRoof", roof.getSubimage( 5 * tileSize, 0, tileSize, tileSize));
            assets.put("leftRoof", roof.getSubimage( 0, 3 * tileSize, tileSize, tileSize));
            assets.put("roof", roof.getSubimage( tileSize, 3 * tileSize, tileSize, tileSize));
            assets.put("rightRoof", roof.getSubimage( 2 * tileSize, 3 * tileSize, tileSize, tileSize));
            assets.put("frontLeftRoof", roof.getSubimage( 0, 4 * tileSize, tileSize, tileSize));
            assets.put("frontRoof", roof.getSubimage( tileSize, 4 * tileSize, tileSize, tileSize));
            assets.put("frontRightRoof", roof.getSubimage( 2 * tileSize, 4 * tileSize, tileSize, tileSize));

        } catch (IOException exception) {
            throw new RuntimeException("Problem with creating BufferImage from file: src/zad1/Graphics/Tiles/houseRoof.png \n" + exception.getMessage());
        }

        // bridges
        try {
            BufferedImage bridges = ImageIO.read(new File("src/zad1/Graphics/Tiles/bridges.png"));
            assets.put("leftBridge", bridges.getSubimage( 0, 0, tileSize, tileSize));
            assets.put("bridge", bridges.getSubimage( 0, 2 * tileSize, tileSize, tileSize));
            assets.put("rightBridge", bridges.getSubimage( tileSize, 0, tileSize, tileSize));
            assets.put("waterLeftBridge", bridges.getSubimage( 0, tileSize, tileSize, tileSize));

        } catch (IOException exception) {
            throw new RuntimeException("Problem with creating BufferImage from file: src/zad1/Graphics/Tiles/bridges.png \n" + exception.getMessage());
        }

        // farm cat sheet
        try {
            BufferedImage farmCat = ImageIO.read(new File("src/zad1/Graphics/Tiles/farmCat.png"));
            assets.put("farmCat", farmCat);

        } catch (IOException exception) {
            throw new RuntimeException("Problem with creating BufferImage from file: src/zad1/Graphics/Tiles/farmCat.png \n" + exception.getMessage());
        }

        // crops
        try {
            BufferedImage crops = ImageIO.read(new File("src/zad1/Graphics/Tiles/crops.png"));
            assets.put("empty", crops.getSubimage( 0, 0, tileSize, tileSize));
            assets.put("carrot1", crops.getSubimage( 0, 2 * tileSize, tileSize, tileSize));
            assets.put("carrot2", crops.getSubimage( tileSize, 2 * tileSize, tileSize, tileSize));
            assets.put("carrot3", crops.getSubimage( 2 * tileSize, 2 * tileSize, tileSize, tileSize));
            assets.put("carrot4", crops.getSubimage( 3 * tileSize, 2 * tileSize, tileSize, tileSize));
            assets.put("cauliflower1", crops.getSubimage( 0, 3 * tileSize, tileSize, tileSize));
            assets.put("cauliflower2", crops.getSubimage( tileSize, 3 * tileSize, tileSize, tileSize));
            assets.put("cauliflower3", crops.getSubimage( 2 * tileSize, 3 * tileSize, tileSize, tileSize));
            assets.put("cauliflower4", crops.getSubimage( 3 * tileSize, 3 * tileSize, tileSize, tileSize));
            assets.put("tomato1", crops.getSubimage( 0, 4 * tileSize, tileSize, tileSize));
            assets.put("tomato2", crops.getSubimage( tileSize, 4 * tileSize, tileSize, tileSize));
            assets.put("tomato3", crops.getSubimage( 2 * tileSize, 4 * tileSize, tileSize, tileSize));
            assets.put("tomato4", crops.getSubimage( 3 * tileSize, 4 * tileSize, tileSize, tileSize));
            assets.put("eggplant1", crops.getSubimage( 0, 5 * tileSize, tileSize, tileSize));
            assets.put("eggplant2", crops.getSubimage( tileSize, 5 * tileSize, tileSize, tileSize));
            assets.put("eggplant3", crops.getSubimage( 2 * tileSize, 5 * tileSize, tileSize, tileSize));
            assets.put("eggplant4", crops.getSubimage( 3 * tileSize, 5 * tileSize, tileSize, tileSize));
            assets.put("lettuce1", crops.getSubimage( 0, 7 * tileSize, tileSize, tileSize));
            assets.put("lettuce2", crops.getSubimage( tileSize, 7 * tileSize, tileSize, tileSize));
            assets.put("lettuce3", crops.getSubimage( 2 * tileSize, 7 * tileSize, tileSize, tileSize));
            assets.put("lettuce4", crops.getSubimage( 3 * tileSize, 7 * tileSize, tileSize, tileSize));
            assets.put("wheat1", crops.getSubimage( 0, 8 * tileSize, tileSize, tileSize));
            assets.put("wheat2", crops.getSubimage( tileSize, 8 * tileSize, tileSize, tileSize));
            assets.put("wheat3", crops.getSubimage( 2 * tileSize, 8 * tileSize, tileSize, tileSize));
            assets.put("wheat4", crops.getSubimage( 3 * tileSize, 8 * tileSize, tileSize, tileSize));
            assets.put("pumpkin1", crops.getSubimage( 0, 9 * tileSize, tileSize, tileSize));
            assets.put("pumpkin2", crops.getSubimage( tileSize, 9 * tileSize, tileSize, tileSize));
            assets.put("pumpkin3", crops.getSubimage( 2 * tileSize, 9 * tileSize, tileSize, tileSize));
            assets.put("pumpkin4", crops.getSubimage( 3 * tileSize, 9 * tileSize, tileSize, tileSize));
            assets.put("radish1", crops.getSubimage( 0, 10 * tileSize, tileSize, tileSize));
            assets.put("radish2", crops.getSubimage( tileSize, 10 * tileSize, tileSize, tileSize));
            assets.put("radish3", crops.getSubimage( 2 * tileSize, 10 * tileSize, tileSize, tileSize));
            assets.put("radish4", crops.getSubimage( 3 * tileSize, 10 * tileSize, tileSize, tileSize));
            assets.put("cucumber1", crops.getSubimage( 0, 14 * tileSize, tileSize, tileSize));
            assets.put("cucumber2", crops.getSubimage( tileSize, 14 * tileSize, tileSize, tileSize));
            assets.put("cucumber3", crops.getSubimage( 2 * tileSize, 14 * tileSize, tileSize, tileSize));
            assets.put("cucumber4", crops.getSubimage( 3 * tileSize, 14 * tileSize, tileSize, tileSize));

        } catch (IOException exception) {
            throw new RuntimeException("Problem with creating BufferImage from file: src/zad1/Graphics/Tiles/crops.png \n" + exception.getMessage());
        }

        // apple
        try {
            BufferedImage apple = ImageIO.read(new File("src/zad1/Graphics/Tiles/apple.png"));
            assets.put("apple1", apple.getSubimage( 0, 3 * tileSize, 3 * tileSize, 3 * tileSize));
            assets.put("apple3", apple.getSubimage( 3 * tileSize, 3 * tileSize, 3 * tileSize, 3 * tileSize));
            assets.put("apple2", apple.getSubimage( 6 * tileSize, 3 * tileSize, 3 * tileSize, 3 * tileSize));

        } catch (IOException exception) {
            throw new RuntimeException("Problem with creating BufferImage from file: src/zad1/Graphics/Tiles/apple.png \n" + exception.getMessage());
        }

        // orange
        try {
            BufferedImage orange = ImageIO.read(new File("src/zad1/Graphics/Tiles/orange.png"));
            assets.put("orange1", orange.getSubimage( 0, 3 * tileSize, 3 * tileSize, 3 * tileSize));
            assets.put("orange3", orange.getSubimage( 3 * tileSize, 3 * tileSize, 3 * tileSize, 3 * tileSize));
            assets.put("orange2", orange.getSubimage( 6 * tileSize, 3 * tileSize, 3 * tileSize, 3 * tileSize));

        } catch (IOException exception) {
            throw new RuntimeException("Problem with creating BufferImage from file: src/zad1/Graphics/Tiles/orange.png \n" + exception.getMessage());
        }

        // peach
        try {
            BufferedImage peach = ImageIO.read(new File("src/zad1/Graphics/Tiles/peach.png"));
            assets.put("peach1", peach.getSubimage( 0, 3 * tileSize, 3 * tileSize, 3 * tileSize));
            assets.put("peach3", peach.getSubimage( 3 * tileSize, 3 * tileSize, 3 * tileSize, 3 * tileSize));
            assets.put("peach2", peach.getSubimage( 6 * tileSize, 3 * tileSize, 3 * tileSize, 3 * tileSize));

        } catch (IOException exception) {
            throw new RuntimeException("Problem with creating BufferImage from file: src/zad1/Graphics/Tiles/peach.png \n" + exception.getMessage());
        }

        // pear
        try {
            BufferedImage pear = ImageIO.read(new File("src/zad1/Graphics/Tiles/pear.png"));
            assets.put("pear1", pear.getSubimage( 0, 3 * tileSize, 3 * tileSize, 3 * tileSize));
            assets.put("pear3", pear.getSubimage( 3 * tileSize, 3 * tileSize, 3 * tileSize, 3 * tileSize));
            assets.put("pear2", pear.getSubimage( 6 * tileSize, 3 * tileSize, 3 * tileSize, 3 * tileSize));

        } catch (IOException exception) {
            throw new RuntimeException("Problem with creating BufferImage from file: src/zad1/Graphics/Tiles/pear.png \n" + exception.getMessage());
        }

        // picnic basket
        try {
            BufferedImage picnicBasket = ImageIO.read(new File("src/zad1/Graphics/Tiles/picnicBasket.png"));
            assets.put("picnicBasket", picnicBasket);

        } catch (IOException exception) {
            throw new RuntimeException("Problem with creating BufferImage from file: src/zad1/Graphics/Tiles/picnicBasket.png \n" + exception.getMessage());
        }

        // chicken
        try {
            BufferedImage chicken = ImageIO.read(new File("src/zad1/Graphics/Tiles/chicken.png"));
            assets.put("chicken", chicken);

        } catch (IOException exception) {
            throw new RuntimeException("Problem with creating BufferImage from file: src/zad1/Graphics/Tiles/chicken.png \n" + exception.getMessage());
        }

        // cow
        try {
            BufferedImage cow = ImageIO.read(new File("src/zad1/Graphics/Tiles/cow.png"));
            assets.put("cow", cow);

        } catch (IOException exception) {
            throw new RuntimeException("Problem with creating BufferImage from file: src/zad1/Graphics/Tiles/cow.png \n" + exception.getMessage());
        }

    }

    // ----- initialize cats -------------------------------------------------------------------------------------------

    private void initializeCatList() { // miau miau miau -> ≽^•⩊•^≼
        farmCats.put("crop1", new FarmCat(new Coordinates(17, 14), this));
        farmCats.put("crop2", new FarmCat(new Coordinates(17, 14), this));
        farmCats.put("crop3", new FarmCat(new Coordinates(17, 14), this));
        farmCats.put("crop4", new FarmCat(new Coordinates(17, 14), this));
        farmCats.put("crop5", new FarmCat(new Coordinates(17, 14), this));
        farmCats.put("flower1", new FarmCat(new Coordinates(17, 14), this));
        farmCats.put("flower2", new FarmCat(new Coordinates(17, 14), this));
        farmCats.put("flower3", new FarmCat(new Coordinates(17, 14), this));
        farmCats.put("mushroom", new FarmCat(new Coordinates(17, 14), this));
        farmCats.put("bush1", new FarmCat(new Coordinates(17, 14), this));
        farmCats.put("bush2", new FarmCat(new Coordinates(17, 14), this));
        farmCats.put("tree1", new FarmCat(new Coordinates(17, 14), this));
        farmCats.put("tree2", new FarmCat(new Coordinates(17, 14), this));
        farmCats.put("tree3", new FarmCat(new Coordinates(17, 14), this));

    }


    // ----- initialize panel properties -------------------------------------------------------------------------------

    private void initializePanelProperties() {

        // colors
        borderColor = Color.decode("#f3e5c2");
        backgroundColor = Color.decode("#e8cfa6");
        labelColor = Color.decode("#b68962");

        // fonts
        try {
            dayDreamFont = Font.createFont(Font.TRUETYPE_FONT, new File("src/zad1/Graphics/Fonts/Daydream.ttf"));
            dayDreamFont = dayDreamFont.deriveFont(22f);

            minecraftiaFont = Font.createFont(Font.TRUETYPE_FONT, new File("src/zad1/Graphics/Fonts/Minecraftia.ttf"));
            minecraftiaFont = minecraftiaFont.deriveFont(12f);

        } catch (FontFormatException | IOException exception) {
            throw new RuntimeException("Problem with loading fonts: " + exception);
        }
    }


    // ----- updating --------------------------------------------------------------------------------------------------
    public void updateAll() {

        // map
        farmMap.update();

        // farmCats
        for(FarmCat farmCat : farmCats.values()) {
            farmCat.update();
        }

    }

    // ----- rendering -------------------------------------------------------------------------------------------------
    public void renderAll(Graphics2D graphics2D, Camera camera) {

        // rendering bottom of the map
        farmMap.renderBottom(graphics2D, camera);

        // rendering cats
        for(FarmCat farmCat : farmCats.values()) {
            farmCat.render(graphics2D, camera);
        }

        /// rendering top of the map
        farmMap.renderTop(graphics2D, camera);


    }
}