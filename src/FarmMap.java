import zad1.Sprites.*;
import zad1.Sprites.Plants.HarvestType;
import zad1.Sprites.Plants.PatchType;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

public class FarmMap {

    // ----- properties ------------------------------------------------------------------------------------------------

    // sprite essentials
    SpritesHandler spritesHandler;
    ArrayList<MapLayer> bottomMapLayers;
    ArrayList<MapLayer> topMapLayers;
    HashMap<String, Patch> patches;
    ArrayList<Entity> otherEntities;


    // ----- constructor -----------------------------------------------------------------------------------------------

    public FarmMap(SpritesHandler spritesHandler) {
        this.spritesHandler = spritesHandler;

        // map
        bottomMapLayers = new ArrayList<>();
        topMapLayers = new ArrayList<>();
        createMapLayers();

        // patches
        patches = new HashMap<>();
        createPatches();

        // other entities
        otherEntities = new ArrayList<>();
        createOtherEntities();

    }

    // ----- creating literally everything -----------------------------------------------------------------------------

    private void createMapLayers() {
        bottomMapLayers.add(MapLayer.createWaterLayer(spritesHandler));
        bottomMapLayers.add(MapLayer.createSoilLayer(spritesHandler));
        bottomMapLayers.add(MapLayer.createGrassLayer(spritesHandler));
        bottomMapLayers.add(MapLayer.createDarkGrassLayer(spritesHandler));
        bottomMapLayers.add(MapLayer.createFloorGroundDecorFencesLayer(spritesHandler));
        bottomMapLayers.add(MapLayer.createBridgesLayer(spritesHandler));
        topMapLayers.add(MapLayer.createNatureLayer(spritesHandler));
        topMapLayers.add(MapLayer.createFarmStructuresLayer(spritesHandler));
        topMapLayers.add(MapLayer.createHouseLayer(spritesHandler));
        topMapLayers.add(MapLayer.createHouseRoofLayer(spritesHandler));
    }


    private void createPatches() {

        // crop patch 1
        ArrayList<Coordinates> coordinatesInCropPatch1 = new ArrayList<>();
        coordinatesInCropPatch1.add(new Coordinates(9, 25));
        coordinatesInCropPatch1.add(new Coordinates(10, 26));
        coordinatesInCropPatch1.add(new Coordinates(12, 24));
        coordinatesInCropPatch1.add(new Coordinates(12, 25));
        coordinatesInCropPatch1.add(new Coordinates(13, 26));
        coordinatesInCropPatch1.add(new Coordinates(14, 25));
        patches.put("crop1", new Patch(coordinatesInCropPatch1, PatchType.CROP, HarvestType.CROP1, spritesHandler));

        // crop patch 2
        ArrayList<Coordinates> coordinatesInCropPatch2 = new ArrayList<>();
        coordinatesInCropPatch2.add(new Coordinates(8, 30));
        coordinatesInCropPatch2.add(new Coordinates(8, 29));
        coordinatesInCropPatch2.add(new Coordinates(9, 28));
        coordinatesInCropPatch2.add(new Coordinates(11, 29));
        coordinatesInCropPatch2.add(new Coordinates(12, 28));
        coordinatesInCropPatch2.add(new Coordinates(13, 27));
        coordinatesInCropPatch2.add(new Coordinates(14, 28));
        patches.put("crop2", new Patch(coordinatesInCropPatch2, PatchType.CROP, HarvestType.CROP2, spritesHandler));

        // crop patch 3
        ArrayList<Coordinates> coordinatesInCropPatch3 = new ArrayList<>();
        coordinatesInCropPatch3.add(new Coordinates(25, 25));
        coordinatesInCropPatch3.add(new Coordinates(26, 24));
        coordinatesInCropPatch3.add(new Coordinates(27, 25));
        coordinatesInCropPatch3.add(new Coordinates(28, 24));
        coordinatesInCropPatch3.add(new Coordinates(29, 26));
        patches.put("crop3", new Patch(coordinatesInCropPatch3, PatchType.CROP, HarvestType.CROP3, spritesHandler));

        // crop patch 4
        ArrayList<Coordinates> coordinatesInCropPatch4 = new ArrayList<>();
        coordinatesInCropPatch4.add(new Coordinates(23, 26));
        coordinatesInCropPatch4.add(new Coordinates(25, 27));
        coordinatesInCropPatch4.add(new Coordinates(26, 28));
        coordinatesInCropPatch4.add(new Coordinates(28, 27));
        coordinatesInCropPatch4.add(new Coordinates(28, 29));
        patches.put("crop4", new Patch(coordinatesInCropPatch4, PatchType.CROP, HarvestType.CROP4, spritesHandler));

        // crop patch 5
        ArrayList<Coordinates> coordinatesInCropPatch5 = new ArrayList<>();
        coordinatesInCropPatch5.add(new Coordinates(39, 10));
        coordinatesInCropPatch5.add(new Coordinates(40, 9));
        coordinatesInCropPatch5.add(new Coordinates(42, 9));
        coordinatesInCropPatch5.add(new Coordinates(42, 12));
        patches.put("crop5", new Patch(coordinatesInCropPatch5, PatchType.CROP, HarvestType.CROP5, spritesHandler));


        // flower patch 1
        ArrayList<Coordinates> coordinatesInFlowerPatch1 = new ArrayList<>();
        coordinatesInFlowerPatch1.add(new Coordinates(17, 21));
        coordinatesInFlowerPatch1.add(new Coordinates(15, 18));
        coordinatesInFlowerPatch1.add(new Coordinates(14, 19));
        coordinatesInFlowerPatch1.add(new Coordinates(13, 18));
        coordinatesInFlowerPatch1.add(new Coordinates(12, 21));
        coordinatesInFlowerPatch1.add(new Coordinates(13, 15));
        patches.put("flower1", new Patch(coordinatesInFlowerPatch1, PatchType.FLOWER, HarvestType.FLOWER1, spritesHandler));

        // flower patch 2
        ArrayList<Coordinates> coordinatesInFlowerPatch2 = new ArrayList<>();
        coordinatesInFlowerPatch2.add(new Coordinates(39, 21));
        coordinatesInFlowerPatch2.add(new Coordinates(41, 19));
        coordinatesInFlowerPatch2.add(new Coordinates(38, 19));
        coordinatesInFlowerPatch2.add(new Coordinates(39, 17));
        coordinatesInFlowerPatch2.add(new Coordinates(37, 16));
        coordinatesInFlowerPatch2.add(new Coordinates(40, 15));
        coordinatesInFlowerPatch2.add(new Coordinates(42, 16));
        patches.put("flower2", new Patch(coordinatesInFlowerPatch2, PatchType.FLOWER, HarvestType.FLOWER2, spritesHandler));

        // flower patch 3
        ArrayList<Coordinates> coordinatesInFlowerPatch3 = new ArrayList<>();
        coordinatesInFlowerPatch3.add(new Coordinates(31, 11));
        coordinatesInFlowerPatch3.add(new Coordinates(30, 10));
        coordinatesInFlowerPatch3.add(new Coordinates(34, 10));
        coordinatesInFlowerPatch3.add(new Coordinates(32, 8));
        coordinatesInFlowerPatch3.add(new Coordinates(33, 6));
        coordinatesInFlowerPatch3.add(new Coordinates(31, 4));
        patches.put("flower3", new Patch(coordinatesInFlowerPatch3, PatchType.FLOWER, HarvestType.FLOWER3, spritesHandler));

        // mushroom patch
        ArrayList<Coordinates> coordinatesInMushroomPatch = new ArrayList<>();
        coordinatesInMushroomPatch.add(new Coordinates(26, 21));
        coordinatesInMushroomPatch.add(new Coordinates(28, 20));
        coordinatesInMushroomPatch.add(new Coordinates(30, 21));
        coordinatesInMushroomPatch.add(new Coordinates(43, 24));
        coordinatesInMushroomPatch.add(new Coordinates(42, 22));
        coordinatesInMushroomPatch.add(new Coordinates(42, 22));
        coordinatesInMushroomPatch.add(new Coordinates(33, 4));
        coordinatesInMushroomPatch.add(new Coordinates(31, 2));
        coordinatesInMushroomPatch.add(new Coordinates(18, 11));
        coordinatesInMushroomPatch.add(new Coordinates(16, 6));
        coordinatesInMushroomPatch.add(new Coordinates(14, 5));
        patches.put("mushroom", new Patch(coordinatesInMushroomPatch, PatchType.MUSHROOM, HarvestType.MUSHROOM, spritesHandler));

        // bush patch 1
        ArrayList<Coordinates> coordinatesInBushPatch1 = new ArrayList<>();
        coordinatesInBushPatch1.add(new Coordinates(20, 18));
        coordinatesInBushPatch1.add(new Coordinates(22, 17));
        coordinatesInBushPatch1.add(new Coordinates(23, 15));
        coordinatesInBushPatch1.add(new Coordinates(24, 18));
        patches.put("bush1", new Patch(coordinatesInBushPatch1, PatchType.BUSH, HarvestType.BUSH1, spritesHandler));

        // bush patch 2
        ArrayList<Coordinates> coordinatesInBushPatch2 = new ArrayList<>();
        coordinatesInBushPatch2.add(new Coordinates(29, 8));
        coordinatesInBushPatch2.add(new Coordinates(31, 6));
        coordinatesInBushPatch2.add(new Coordinates(28, 4));
        patches.put("bush2", new Patch(coordinatesInBushPatch2, PatchType.BUSH, HarvestType.BUSH2, spritesHandler));

        // tree patch 1
        ArrayList<Coordinates> coordinatesInTreePatch1 = new ArrayList<>();
        coordinatesInTreePatch1.add(new Coordinates(18, 25));
        coordinatesInTreePatch1.add(new Coordinates(19, 23));
        coordinatesInTreePatch1.add(new Coordinates(19, 26));
        patches.put("tree1", new Patch(coordinatesInTreePatch1, PatchType.TREE, HarvestType.TREE1, spritesHandler));

        // tree patch 2
        ArrayList<Coordinates> coordinatesInTreePatch2 = new ArrayList<>();
        coordinatesInTreePatch2.add(new Coordinates(16, 9));
        coordinatesInTreePatch2.add(new Coordinates(17, 7));
        coordinatesInTreePatch2.add(new Coordinates(14, 3));
        patches.put("tree2", new Patch(coordinatesInTreePatch2, PatchType.TREE, HarvestType.TREE2, spritesHandler));

        // tree patch 3
        ArrayList<Coordinates> coordinatesInTreePatch3 = new ArrayList<>();
        coordinatesInTreePatch3.add(new Coordinates(38, 27));
        coordinatesInTreePatch3.add(new Coordinates(42, 27));
        coordinatesInTreePatch3.add(new Coordinates(40, 24));
        patches.put("tree3", new Patch(coordinatesInTreePatch3, PatchType.TREE, HarvestType.TREE3, spritesHandler));


        // filling all patched with plants
        for (Patch patch : patches.values()) {
            patch.fillWithPlants();
        }

    }

    private void createOtherEntities() {
        otherEntities.add(new StaticEntity(29 * spritesHandler.tileSize, 6 * spritesHandler.tileSize, spritesHandler.assets.get("picnicBasket")));

        Animation firstChickenAnimation = new Animation(spritesHandler.assets.get("chicken"), 8, 27, 3, 7, 8);
        otherEntities.add(new AnimatedEntity(36 * spritesHandler.tileSize, 5 * spritesHandler.tileSize, firstChickenAnimation));

        Animation secondChickenAnimation = new Animation(spritesHandler.assets.get("chicken"), 8, 27, 7, 5, 10);
        otherEntities.add(new AnimatedEntity(40 * spritesHandler.tileSize, 4 * spritesHandler.tileSize, secondChickenAnimation));

        Animation firstCowAnimation = new Animation(spritesHandler.assets.get("cow"), 8, 8, 4, 4, 12);
        otherEntities.add(new Cow(8 * spritesHandler.tileSize, 6 * spritesHandler.tileSize, firstCowAnimation));

        Animation secondCowAnimation = new Animation(spritesHandler.assets.get("cow"), 8, 8, 5, 7, 10);
        otherEntities.add(new Cow(14 * spritesHandler.tileSize, 7 * spritesHandler.tileSize, secondCowAnimation));

    }


    // ----- updating --------------------------------------------------------------------------------------------------

    public void update() {

        for (MapLayer mapLayer : bottomMapLayers) {
            mapLayer.update();
        }

        for (MapLayer mapLayer : topMapLayers) {
            mapLayer.update();
        }

        for (Patch patch : patches.values()) {
            patch.update();
        }

        for (Entity entity : otherEntities) {
            entity.update();
        }

    }


    // ----- rendering -------------------------------------------------------------------------------------------------

    // map divided to render nicely
    public void renderBottom(Graphics2D graphics2D, Camera camera) {

        for (MapLayer mapLayer : bottomMapLayers) {
            mapLayer.render(graphics2D, camera);
        }
    }

    public void renderTop(Graphics2D graphics2D, Camera camera) {

        for (MapLayer mapLayer : topMapLayers) {
            mapLayer.render(graphics2D, camera);
        }

        for (Patch patch : patches.values()) {
            patch.render(graphics2D, camera);
        }

        for (Entity entity : otherEntities) {
            entity.render(graphics2D, camera);
        }

    }
}