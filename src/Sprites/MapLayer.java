package Sprites;

import zad1.Camera;
import zad1.SpritesHandler;

import java.awt.*;
import java.io.*;
import java.util.*;

public class MapLayer {

    // ----- properties ------------------------------------------------------------------------------------------------

    // farmMap properties
    static final int tileSize = 16;
    static final int mapWidthTiles = 48;
    static final int mapHeightTiles = 36;

    // tile farmMap
    Entity[][] tiles;


    // ----- constructor -----------------------------------------------------------------------------------------------
    private MapLayer() {
        tiles = new Entity[mapHeightTiles][mapWidthTiles];
    }


    // ----- static factories ------------------------------------------------------------------------------------------

    // water layer
    public static MapLayer createWaterLayer(SpritesHandler spritesHandler) {
        int[][] idFromFile = readFileToIntInt("src/zad1/Graphics/MapLayers/water.txt");
        MapLayer waterLayer =  new MapLayer();

        for (int i = 0; i < mapHeightTiles; i++) {
            for (int j = 0; j < mapWidthTiles; j++) {
                if (idFromFile[i][j] == 1) { // water tile
                    waterLayer.tiles[i][j] = new AnimatedEntity(j * tileSize, i * tileSize, new Animation(spritesHandler.assets.get("water"), 4, 1, 0, 4, 20));
                }
            }
        }

        return waterLayer;
    }

    // soil layer
    public static MapLayer createSoilLayer(SpritesHandler spritesHandler) {
        int[][] idFromFile = readFileToIntInt("src/zad1/Graphics/MapLayers/soil.txt");
        MapLayer soilLayer =  new MapLayer();

        for (int i = 0; i < mapHeightTiles; i++) {
            for (int j = 0; j < mapWidthTiles; j++) {
                switch (idFromFile[i][j]) {
                    case 1: { soilLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("plainSoil")); break; }
                    case 2: { soilLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("threeWhiteStones")); break; }
                    case 3: { soilLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("darkSand")); break; }
                    case 4: { soilLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("threeDarkStones")); break; }
                    case 5: { soilLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("whiteSand")); break; }
                    case 6: { soilLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("twoWhiteStones")); break; }
                    case 7: { soilLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("twoDarkStones")); break; }
                }
            }
        }
        return soilLayer;
    }

    public static MapLayer createGrassLayer(SpritesHandler spritesHandler) {
        int[][] idFromFile = readFileToIntInt("src/zad1/Graphics/MapLayers/grass.txt");
        MapLayer grassLayer = new MapLayer();

        for (int i = 0; i < mapHeightTiles; i++) {
            for (int j = 0; j < mapWidthTiles; j++) {
                switch (idFromFile[i][j]) {
                    case 1: { grassLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("upGrass")); break; }
                    case 2: { grassLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("leftUpCornerWaterGrass")); break; }
                    case 3: { grassLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("leftBottomCornerWaterGrass")); break; }
                    case 4: { grassLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("rightUpCornerWaterGrass")); break; }
                    case 5: { grassLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("rightBottomCornerWaterGrass")); break; }
                    case 6: { grassLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("leftWaterGrass")); break; }
                    case 7: { grassLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("rightWaterGrass")); break; }
                    case 8: { grassLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("bottomWaterGrass")); break; }
                    case 9: { grassLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("leftUpInnerWaterGrass")); break; }
                    case 10: { grassLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("leftBottomInnerWaterGrass")); break; }
                    case 11: { grassLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("rightUpInnerWaterGrass")); break; }
                    case 12: { grassLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("rightBottomInnerWaterGrass")); break; }
                    case 13: { grassLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("grassTile")); break; }
                    case 14: { grassLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("weirdWaterGrass1")); break; }
                    case 15: { grassLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("weirdWaterGrass2")); break; }
                    case 16: { grassLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("weirdWaterGrass3")); break; }
                    case 17: { grassLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("weirdWaterGrass4")); break; }
                    case 18: { grassLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("weirdWaterGrass5")); break; }
                    case 19: { grassLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("weirdWaterGrass6")); break; }
                    case 20: { grassLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("weirdWaterGrass7")); break; }
                    case 21: { grassLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("bigGrassGreen")); break; }
                    case 22: { grassLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("smallerGrassGreen")); break; }
                    case 23: { grassLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("smallGrassGreen")); break; }
                    case 24: { grassLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("twoDarkRocksGrass")); break; }
                    case 25: { grassLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("threeDarkRocksGrass")); break; }
                    case 26: { grassLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("threeFlowersGrass")); break; }
                    case 27: { grassLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("bigGrassLight")); break; }
                    case 28: { grassLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("smallerGrassLight")); break; }
                    case 29: { grassLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("smallGrassLight")); break; }
                    case 30: { grassLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("twoLightRocksGrass")); break; }
                    case 31: { grassLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("threeLightRocksGrass")); break; }
                    case 32: { grassLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("twoFlowersGrass")); break; }
                    case 33: { grassLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("grassLayerBottom")); break; }
                    case 34: { grassLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("grassLayerLeft")); break; }
                    case 35: { grassLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("grassLayerRight")); break; }
                    case 36: { grassLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("grassLayerUpLeftCorner")); break; }
                    case 37: { grassLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("grassLayerBottomLeftCorner")); break; }
                    case 38: { grassLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("grassLayerUpRightCorner")); break; }
                    case 39: { grassLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("grassLayerBottomRightCorner")); break; }
                    case 40: { grassLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("grassLayerUpLeftInner")); break; }
                    case 41: { grassLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("grassLayerBottomLeftInner")); break; }
                    case 42: { grassLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("grassLayerUpRightInner")); break; }
                    case 43: { grassLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("grassLayerBottomRightInner")); break; }
                    case 44: { grassLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("weirdGrassLayer1")); break; }
                    case 45: { grassLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("weirdGrassLayer2")); break; }
                    case 46: { grassLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("weirdGrassLayer3")); break; }
                    case 47: { grassLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("weirdGrassLayer4")); break; }
                    case 48: { grassLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("weirdGrassLayer5")); break; }
                    case 49: { grassLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("weirdGrassLayer6")); break; }
                }
            }
        }
        return grassLayer;
    }

    public static MapLayer createDarkGrassLayer(SpritesHandler spritesHandler) {
        int[][] idFromFile = readFileToIntInt("src/zad1/Graphics/MapLayers/darkGrass.txt");
        MapLayer darkGrassLayer = new MapLayer();

        for (int i = 0; i < mapHeightTiles; i++) {
            for (int j = 0; j < mapWidthTiles; j++) {
                switch (idFromFile[i][j]) {
                    case 1: { darkGrassLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("darkGrassTile")); break; }
                    case 2: { darkGrassLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("darkGrassUp")); break; }
                    case 3: { darkGrassLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("darkGrassLeft")); break; }
                    case 4: { darkGrassLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("darkGrassBottom")); break; }
                    case 5: { darkGrassLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("darkGrassRight")); break; }
                    case 6: { darkGrassLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("darkGrassLeftUpCorner")); break; }
                    case 7: { darkGrassLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("darkGrassLeftBottomCorner")); break; }
                    case 8: { darkGrassLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("darkGrassRightUpCorner")); break; }
                    case 9: { darkGrassLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("darkGrassRightBottomCorner")); break; }
                    case 10: { darkGrassLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("darkGrassUpLeftInner")); break; }
                    case 11: { darkGrassLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("darkGrassBottomLeftInner")); break; }
                    case 12: { darkGrassLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("darkGrassUpRightInner")); break; }
                    case 13: { darkGrassLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("darkGrassBottomRightInner")); break; }
                    case 14: { darkGrassLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("weirdDarkGrass1")); break; }
                    case 15: { darkGrassLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("weirdDarkGrass2")); break; }
                    case 16: { darkGrassLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("weirdDarkGrass3")); break; }
                    case 17: { darkGrassLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("weirdDarkGrass4")); break; }
                    case 18: { darkGrassLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("weirdDarkGrass5")); break; }
                    case 19: { darkGrassLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("weirdDarkGrass6")); break; }
                    case 20: { darkGrassLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("weirdDarkGrass7")); break; }
                    case 21: { darkGrassLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("weirdDarkGrass8")); break; }
                    case 22: { darkGrassLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("weirdDarkGrass9")); break; }
                    case 23: { darkGrassLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("weirdDarkGrass10")); break; }
                    case 24: { darkGrassLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("weirdDarkGrass11")); break; }
                    case 25: { darkGrassLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("weirdDarkGrass12")); break; }
                    case 26: { darkGrassLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("weirdDarkGrass13")); break; }
                    case 27: { darkGrassLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("weirdDarkGrass14")); break; }
                    case 28: { darkGrassLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("weirdDarkGrass15")); break; }
                    case 29: { darkGrassLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("weirdDarkGrass16")); break; }
                    case 30: { darkGrassLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("weirdDarkGrass17")); break; }
                    case 31: { darkGrassLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("weirdDarkGrass18")); break; }
                    case 32: { darkGrassLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("weirdDarkGrass19")); break; }
                    case 33: { darkGrassLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("weirdDarkGrass20")); break; }
                    case 34: { darkGrassLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("weirdDarkGrass21")); break; }
                    case 35: { darkGrassLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("threeDarkStonesDarkGrass")); break; }
                    case 36: { darkGrassLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("bigGrassDarkGrass")); break; }
                    case 37: { darkGrassLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("threeGrassDarkGrass")); break; }
                    case 38: { darkGrassLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("twoDarkStonesDarkGrass")); break; }
                }
            }
        }

        return darkGrassLayer;
    }

    public static MapLayer createFloorGroundDecorFencesLayer(SpritesHandler spritesHandler) {
        int[][] idFromFile = readFileToIntInt("src/zad1/Graphics/MapLayers/floorGroundDecorFences.txt");
        MapLayer floorGroundDecorFencesLayer = new MapLayer();

        for (int i = 0; i < mapHeightTiles; i++) {
            for (int j = 0; j < mapWidthTiles; j++) {
                switch (idFromFile[i][j]) {

                    // water objects
                    case 1: { floorGroundDecorFencesLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("waterStone1")); break; }
                    case 2: { floorGroundDecorFencesLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("waterStone2")); break; }
                    case 3: { floorGroundDecorFencesLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("waterStone3")); break; }
                    case 4: { floorGroundDecorFencesLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("waterStone4")); break; }
                    case 5: { floorGroundDecorFencesLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("bigWaterStone1")); break; }
                    case 6: { floorGroundDecorFencesLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("bigWaterStone2")); break; }
                    case 7: { floorGroundDecorFencesLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("threeWaterSticks")); break; }
                    case 8: { floorGroundDecorFencesLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("fourWaterSticks")); break; }
                    case 9: { floorGroundDecorFencesLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("waterLily1")); break; }
                    case 10: { floorGroundDecorFencesLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("waterLily2")); break; }
                    case 11: { floorGroundDecorFencesLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("waterLily3")); break; }
                    case 12: { floorGroundDecorFencesLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("waterLily4")); break; }

                    // ground decor
                    case 13: { floorGroundDecorFencesLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("stone1")); break; }
                    case 14: { floorGroundDecorFencesLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("stone2")); break; }
                    case 15: { floorGroundDecorFencesLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("stone3")); break; }
                    case 16: { floorGroundDecorFencesLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("stone4")); break; }
                    case 17: { floorGroundDecorFencesLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("stone5")); break; }
                    case 18: { floorGroundDecorFencesLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("stone6")); break; }
                    case 19: { floorGroundDecorFencesLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("grassDecor1")); break; }
                    case 20: { floorGroundDecorFencesLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("grassDecor2")); break; }
                    case 21: { floorGroundDecorFencesLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("grassDecor3")); break; }
                    case 22: { floorGroundDecorFencesLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("grassDecor4")); break; }

                    // picnic blanket
                    case 23: { floorGroundDecorFencesLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("picnicBlanket1")); break; }
                    case 24: { floorGroundDecorFencesLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("picnicBlanket2")); break; }
                    case 25: { floorGroundDecorFencesLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("picnicBlanket3")); break; }
                    case 26: { floorGroundDecorFencesLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("picnicBlanket4")); break; }
                    case 27: { floorGroundDecorFencesLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("picnicBlanket5")); break; }
                    case 28: { floorGroundDecorFencesLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("picnicBlanket6")); break; }
                    case 29: { floorGroundDecorFencesLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("picnicBlanket7")); break; }
                    case 30: { floorGroundDecorFencesLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("picnicBlanket8")); break; }
                    case 31: { floorGroundDecorFencesLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("picnicBlanket9")); break; }

                    // hay
                    case 32: { floorGroundDecorFencesLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("hay1")); break; }
                    case 33: { floorGroundDecorFencesLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("hay2")); break; }

                    //fences + gates
                    case 34: { floorGroundDecorFencesLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("fenceDown")); break; }
                    case 35: { floorGroundDecorFencesLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("fenceVertical")); break; }
                    case 36: { floorGroundDecorFencesLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("fenceUp")); break; }
                    case 37: { floorGroundDecorFencesLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("fenceAlone")); break; }
                    case 38: { floorGroundDecorFencesLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("fenceLeft")); break; }
                    case 39: { floorGroundDecorFencesLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("fenceHorizontal")); break; }
                    case 40: { floorGroundDecorFencesLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("fenceRight")); break; }
                    case 41: { floorGroundDecorFencesLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("fenceWeird")); break; }
                    case 42: { floorGroundDecorFencesLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("gate1")); break; }
                    case 43: { floorGroundDecorFencesLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("gate2")); break; }
                    case 44: { floorGroundDecorFencesLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("gate3")); break; }
                    case 45: { floorGroundDecorFencesLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("gate4")); break; }
                    case 46: { floorGroundDecorFencesLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("gateLeft")); break; }
                    case 47: { floorGroundDecorFencesLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("gateRight")); break; }

                    // floor
                    case 48: { floorGroundDecorFencesLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("floor")); break; }

                    // paths
                    case 49: { floorGroundDecorFencesLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("pathUp")); break; }
                    case 50: { floorGroundDecorFencesLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("pathVertical")); break; }
                    case 51: { floorGroundDecorFencesLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("pathBottom")); break; }
                    case 52: { floorGroundDecorFencesLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("pathLeft")); break; }
                    case 53: { floorGroundDecorFencesLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("pathHorizontal")); break; }
                    case 54: { floorGroundDecorFencesLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("pathRight")); break; }
                    case 55: { floorGroundDecorFencesLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("pathArc1")); break; }
                    case 56: { floorGroundDecorFencesLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("pathArc2")); break; }
                    case 58: { floorGroundDecorFencesLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("pathArc3")); break; }

                }
            }
        }
        return floorGroundDecorFencesLayer;
    }

    public static MapLayer createNatureLayer(SpritesHandler spritesHandler) {
        int[][] idFromFile = readFileToIntInt("src/zad1/Graphics/MapLayers/nature.txt");
        MapLayer natureLayer = new MapLayer();

        for (int i = 0; i < mapHeightTiles; i++) {
            for (int j = 0; j < mapWidthTiles; j++) {
                switch (idFromFile[i][j]) {
                    case 1: { natureLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("bigTree1")); break; }
                    case 2: { natureLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("bigTree2")); break; }
                    case 3: { natureLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("bigTree3")); break; }
                    case 4: { natureLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("bigTree4")); break; }
                    case 5: { natureLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("bigTree5")); break; }
                    case 6: { natureLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("bigTree6")); break; }
                    case 7: { natureLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("bigTree7")); break; }
                    case 8: { natureLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("bigTree8")); break; }
                    case 9: { natureLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("bigTree9")); break; }
                    case 10: { natureLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("tree1")); break; }
                    case 11: { natureLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("tree2")); break; }
                    case 12: { natureLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("tree3")); break; }
                    case 13: { natureLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("tree4")); break; }
                    case 14: { natureLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("smallTree1")); break; }
                    case 15: { natureLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("smallTree2")); break; }
                    case 16: { natureLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("bush")); break; }

                }
            }
        }

        return natureLayer;
    }

    public static MapLayer createFarmStructuresLayer(SpritesHandler spritesHandler) {
        int[][] idFromFile = readFileToIntInt("src/zad1/Graphics/MapLayers/farmStructures.txt");
        MapLayer farmStructuresLayer = new MapLayer();

        for (int i = 0; i < mapHeightTiles; i++) {
            for (int j = 0; j < mapWidthTiles; j++) {
                switch (idFromFile[i][j]) {
                    case 1: { farmStructuresLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("smallHayBale")); break; }
                    case 2: { farmStructuresLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("bigHayBale1")); break; }
                    case 4: { farmStructuresLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("bigHayBale2")); break; }
                    case 5: { farmStructuresLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("box")); break; }
                    case 6: { farmStructuresLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("twoBoxes1")); break; }
                    case 7: { farmStructuresLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("twoBoxes2")); break; }
                    case 8: { farmStructuresLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("twoBoxes3")); break; }
                    case 9: { farmStructuresLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("twoBoxes4")); break; }
                    case 10: { farmStructuresLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("waterTray1")); break; }
                    case 11: { farmStructuresLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("waterTray2")); break; }
                    case 13: { farmStructuresLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("waterWell1")); break; }
                    case 14: { farmStructuresLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("waterWell2")); break; }
                    case 15: { farmStructuresLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("waterWell3")); break; }
                    case 16: { farmStructuresLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("waterWell4")); break; }
                    case 17: { farmStructuresLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("workStation1")); break; }
                    case 18: { farmStructuresLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("workStation2")); break; }
                    case 19: { farmStructuresLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("workStation3")); break; }
                    case 20: { farmStructuresLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("workStation4")); break; }
                    case 21: { farmStructuresLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("coop1")); break; }
                    case 22: { farmStructuresLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("coop2")); break; }
                    case 23: { farmStructuresLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("coop3")); break; }
                    case 24: { farmStructuresLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("coop4")); break; }
                    case 25: { farmStructuresLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("coop5")); break; }
                    case 26: { farmStructuresLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("coop6")); break; }
                    case 27: { farmStructuresLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("coop7")); break; }
                    case 28: { farmStructuresLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("coop8")); break; }
                    case 29: { farmStructuresLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("coop9")); break; }

                }
            }
        }

        return farmStructuresLayer;
    }

    public static MapLayer createHouseLayer(SpritesHandler spritesHandler) {
        int[][] idFromFile = readFileToIntInt("src/zad1/Graphics/MapLayers/house.txt");
        MapLayer houseLayer = new MapLayer();

        for (int i = 0; i < mapHeightTiles; i++) {
            for (int j = 0; j < mapWidthTiles; j++) {
                switch (idFromFile[i][j]) {
                    case 1: { houseLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("leftHouse")); break; }
                    case 2: { houseLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("windowHouse")); break; }
                    case 3: { houseLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("wallHouse")); break; }
                    case 4: { houseLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("rightHouse")); break; }
                    case 5: { houseLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("door")); break; }

                }
            }
        }

        return houseLayer;
    }

    public static MapLayer createHouseRoofLayer(SpritesHandler spritesHandler) {
        int[][] idFromFile = readFileToIntInt("src/zad1/Graphics/MapLayers/houseRoof.txt");
        MapLayer houseRoofLayer = new MapLayer();

        for (int i = 0; i < mapHeightTiles; i++) {
            for (int j = 0; j < mapWidthTiles; j++) {
                switch (idFromFile[i][j]) {
                    case 1: { houseRoofLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("backLeftRoof")); break; }
                    case 2: { houseRoofLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("backRoof")); break; }
                    case 3: { houseRoofLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("backRightRoof")); break; }
                    case 4: { houseRoofLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("reversedLeftRoof")); break; }
                    case 5: { houseRoofLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("reversedRoof")); break; }
                    case 6: { houseRoofLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("reversedRightRoof")); break; }
                    case 7: { houseRoofLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("centerLeftRoof")); break; }
                    case 8: { houseRoofLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("centerRoof")); break; }
                    case 9: { houseRoofLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("centerRightRoof")); break; }
                    case 10: { houseRoofLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("chimneyRoof")); break; }
                    case 11: { houseRoofLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("leftRoof")); break; }
                    case 12: { houseRoofLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("roof")); break; }
                    case 13: { houseRoofLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("rightRoof")); break; }
                    case 14: { houseRoofLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("frontLeftRoof")); break; }
                    case 15: { houseRoofLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("frontRoof")); break; }
                    case 16: { houseRoofLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("frontRightRoof")); break; }

                }
            }
        }

        return houseRoofLayer;
    }

    public static MapLayer createBridgesLayer(SpritesHandler spritesHandler) {
        int[][] idFromFile = readFileToIntInt("src/zad1/Graphics/MapLayers/bridges.txt");
        MapLayer bridgesLayer = new MapLayer();

        for (int i = 0; i < mapHeightTiles; i++) {
            for (int j = 0; j < mapWidthTiles; j++) {
                switch (idFromFile[i][j]) {
                    case 1: { bridgesLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("leftBridge")); break; }
                    case 2: { bridgesLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("bridge")); break; }
                    case 3: { bridgesLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("rightBridge")); break; }
                    case 4: { bridgesLayer.tiles[i][j] = new StaticEntity(j * tileSize, i * tileSize, spritesHandler.assets.get("waterLeftBridge")); break; }

                }
            }
        }

        return bridgesLayer;
    }


    // ----- file reading ----------------------------------------------------------------------------------------------

    private static int[][] readFileToIntInt(String filePath) {
        ArrayList<int[]> rows = new ArrayList<>();
        String line;
        String[] tokens;

        try {
            Scanner scanner = new Scanner(new File(filePath));
            while (scanner.hasNextLine()) {
                line = scanner.nextLine();
                tokens = line.split("\\s+");
                int[] row = new int[mapWidthTiles];
                for (int i = 0; i < tokens.length; i++) {
                    row[i] = Integer.parseInt(tokens[i]);
                }
                rows.add(row);
            }
        } catch (FileNotFoundException exception) {
            throw new RuntimeException("Problem with reading tiles ids form file: " + filePath + "\n" + exception.getMessage());
        }

        return rows.toArray(new int[rows.size()][]);
    }


    // ----- updating --------------------------------------------------------------------------------------------------

    public void update() {
        for (int i = 0; i < mapHeightTiles; i++) {
            for (int j = 0; j < mapWidthTiles; j++) {
                if (tiles[i][j] != null ) {
                    tiles[i][j].update();
                }
            }
        }
    }


    // ----- rendering -------------------------------------------------------------------------------------------------

    public void render(Graphics2D graphics2D, Camera camera) {
        for (int i = 0; i < mapHeightTiles; i++) {
            for (int j = 0; j < mapWidthTiles; j++) {

                if (tiles[i][j] != null) {
                    tiles[i][j].render(graphics2D, camera);
                }
            }
        }
    }

}

// its actually half way shorter than the one in c++