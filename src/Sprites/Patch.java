package Sprites;

import zad1.Camera;
import zad1.Sprites.Plants.*;
import zad1.SpritesHandler;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class Patch extends ArrayList<Plant> {

    // ----- properties ------------------------------------------------------------------------------------------------

    final int tileSize = 16;
    SpritesHandler spritesHandler;

    // enums
    public final HarvestType harvestType;
    public PlantType currentPlantType;
    final PatchType patchType;

    // statics
    private static ArrayList<Integer> currentCrops;
    private static ArrayList<Integer> currentFlowers;
    private static ArrayList<Integer> currentMushrooms;
    private static ArrayList<Integer> currentBushes;
    private static ArrayList<Integer> currentTrees;

    public boolean readyToHarvest;
    public boolean beingHarvested;
    private int currentPlantId;
    final ArrayList<Coordinates> plantsCoordinates;


    // ----- constructor -----------------------------------------------------------------------------------------------

    public Patch(ArrayList<Coordinates> plantsCoordinates, PatchType patchType, HarvestType harvestType, SpritesHandler spritesHandler) {
        readyToHarvest = false;
        beingHarvested = false;

        this.spritesHandler = spritesHandler;
        this.plantsCoordinates = plantsCoordinates;
        this.patchType = patchType;
        this.harvestType = harvestType;

        if (currentCrops == null) {
            currentCrops = new ArrayList<>();
        }

        if (currentFlowers == null) {
            currentFlowers = new ArrayList<>();
        }

        if (currentMushrooms == null) {
            currentMushrooms = new ArrayList<>();
        }

        if (currentBushes == null) {
            currentBushes = new ArrayList<>();
        }

        if (currentTrees == null) {
            currentTrees = new ArrayList<>();
        }

    }


    // ----- fillers ---------------------------------------------------------------------------------------------------

    public void fillWithPlants() {
        readyToHarvest = false;

        switch (patchType) {
            case CROP: {
                fillWithCrops();
                break;
            }
            case FLOWER: {
                fillWithFlower();
                break;
            }
            case MUSHROOM: {
                fillWithMushrooms();
                break;
            }
            case BUSH: {
                fillWithBushes();
                break;
            }
            case TREE: {
                fillWithTrees();
                break;
            }

        }
    }


    // filling with correct type of plants

    private void fillWithCrops() {
        Random random = new Random();
        do {
            currentPlantId = random.nextInt(9);
        } while (currentCrops.contains(currentPlantId));
        currentCrops.add(currentPlantId);

        for (Coordinates coordinates : plantsCoordinates) {
            createCrop(coordinates);
        }
    }

    private void fillWithFlower() {
        Random random = new Random();
        do {
            currentPlantId = random.nextInt(6);
        } while (currentFlowers.contains(currentPlantId));
        currentFlowers.add(currentPlantId);

        for (Coordinates coordinates : plantsCoordinates) {
            createFlower(coordinates);
        }
    }

    private void fillWithMushrooms() {
        Random random = new Random();
        do {
            currentPlantId = random.nextInt(2);
        } while (currentMushrooms.contains(currentPlantId));
        currentMushrooms.add(currentPlantId);

        for (Coordinates coordinates : plantsCoordinates) {
            createMushroom(coordinates);
        }
    }

    private void fillWithBushes() {
        Random random = new Random();
        do {
            currentPlantId = random.nextInt(3);
        } while (currentBushes.contains(currentPlantId));
        currentBushes.add(currentPlantId);

        for (Coordinates coordinates : plantsCoordinates) {
            createBush(coordinates);
        }
    }

    private void fillWithTrees() {
        Random random = new Random();
        do {
            currentPlantId = random.nextInt(4);
        } while (currentTrees.contains(currentPlantId));
        currentTrees.add(currentPlantId);

        for (Coordinates coordinates : plantsCoordinates) {
            createTree(coordinates);
        }
    }


    // creating random plants

    private void createCrop(Coordinates coordinates) {
        switch (currentPlantId) {
            case 0: {
                add(new Carrot(coordinates.x * tileSize, coordinates.y * tileSize, spritesHandler));
                currentPlantType = PlantType.CARROT;
                break;
            }

            case 1: {
                add(new Cauliflower(coordinates.x * tileSize, coordinates.y * tileSize, spritesHandler));
                currentPlantType = PlantType.CAULIFLOWER;
                break;
            }

            case 2: {
                add(new Tomato(coordinates.x * tileSize, coordinates.y * tileSize, spritesHandler));
                currentPlantType = PlantType.TOMATO;
                break;
            }

            case 3: {
                add(new Eggplant(coordinates.x * tileSize, coordinates.y * tileSize, spritesHandler));
                currentPlantType = PlantType.EGGPLANT;
                break;
            }

            case 4: {
                add(new Lettuce(coordinates.x * tileSize, coordinates.y * tileSize, spritesHandler));
                currentPlantType = PlantType.LETTUCE;
                break;
            }

            case 5: {
                add(new Wheat(coordinates.x * tileSize, coordinates.y * tileSize, spritesHandler));
                currentPlantType = PlantType.WHEAT;
                break;
            }

            case 6: {
                add(new Pumpkin(coordinates.x * tileSize, coordinates.y * tileSize, spritesHandler));
                currentPlantType = PlantType.PUMPKIN;
                break;
            }

            case 7: {
                add(new Radish(coordinates.x * tileSize, coordinates.y * tileSize, spritesHandler));
                currentPlantType = PlantType.RADISH;
                break;
            }

            case 8: {
                add(new Cucumber(coordinates.x * tileSize, coordinates.y * tileSize, spritesHandler));
                currentPlantType = PlantType.CUCUMBER;
                break;
            }
        }
    }

    private void createFlower(Coordinates coordinates) {
        switch (currentPlantId) {
            case 0: {
                add(new Dandelion(coordinates.x * tileSize, coordinates.y * tileSize, spritesHandler));
                currentPlantType = PlantType.DANDELION;
                break;
            }

            case 1: {
                add(new Violet(coordinates.x * tileSize, coordinates.y * tileSize, spritesHandler));
                currentPlantType = PlantType.VIOLET;
                break;
            }

            case 2: {
                add(new Peony(coordinates.x * tileSize, coordinates.y * tileSize, spritesHandler));
                currentPlantType = PlantType.PEONY;
                break;
            }

            case 3: {
                add(new Cornflower(coordinates.x * tileSize, coordinates.y * tileSize, spritesHandler));
                currentPlantType = PlantType.CORNFLOWER;
                break;
            }

            case 4: {
                add(new Daisy(coordinates.x * tileSize, coordinates.y * tileSize, spritesHandler));
                currentPlantType = PlantType.DAISY;
                break;
            }

            case 5: {
                add(new Hyacinth(coordinates.x * tileSize, coordinates.y * tileSize, spritesHandler));
                currentPlantType = PlantType.HYACINTH;
                break;
            }
        }
    }

    private void createMushroom(Coordinates coordinates) {
        switch (currentPlantId) {
            case 0: {
                add(new Toadstool(coordinates.x * tileSize, coordinates.y * tileSize, spritesHandler));
                currentPlantType = PlantType.TOADSTOOL;
                break;
            }

            case 1: {
                add(new Mushroom(coordinates.x * tileSize, coordinates.y * tileSize, spritesHandler));
                currentPlantType = PlantType.MUSHROOM;
                break;
            }
        }
    }

    private void createBush(Coordinates coordinates) {
        switch (currentPlantId) {
            case 0: {
                add(new Raspberry(coordinates.x * tileSize, coordinates.y * tileSize, spritesHandler));
                currentPlantType = PlantType.RASPBERRY;
                break;
            }

            case 1: {
                add(new Plum(coordinates.x * tileSize, coordinates.y * tileSize, spritesHandler));
                currentPlantType = PlantType.PLUM;
                break;
            }

            case 2: {
                add(new Blueberry(coordinates.x * tileSize, coordinates.y * tileSize, spritesHandler));
                currentPlantType = PlantType.BLUEBERRY;
                break;
            }
        }
    }

    private void createTree(Coordinates coordinates) {
        switch (currentPlantId) {
            case 0: {
                add(new Apple(coordinates.x * tileSize, coordinates.y * tileSize, spritesHandler));
                currentPlantType = PlantType.APPLE;
                break;
            }

            case 1: {
                add(new Orange(coordinates.x * tileSize, coordinates.y * tileSize, spritesHandler));
                currentPlantType = PlantType.ORANGE;
                break;
            }

            case 2: {
                add(new Peach(coordinates.x * tileSize, coordinates.y * tileSize, spritesHandler));
                currentPlantType = PlantType.PEACH;
                break;
            }

            case 3: {
                add(new Pear(coordinates.x * tileSize, coordinates.y * tileSize, spritesHandler));
                currentPlantType = PlantType.PEAR;
                break;
            }
        }
    }


    // ----- updating --------------------------------------------------------------------------------------------------
    public void update() {

        // checking plants state
        if (!beingHarvested) {

            // updating plants
            for (Plant plant : this) {
                plant.update();
            }

            boolean readyToHarvestHelper = true;
            for (Plant plant : this) {
                if (!plant.grown) {
                    readyToHarvestHelper = false;
                    break;
                }
            }
            readyToHarvest = readyToHarvestHelper;
        }

    }

    // harvesting
    public void harvest() {

        switch (patchType) {
            case CROP: {
                currentCrops.remove((Object) currentPlantId);
                break;
            }
            case FLOWER: {
                currentFlowers.remove((Object) currentPlantId);
                break;
            }
            case MUSHROOM: {
                currentMushrooms.remove((Object) currentPlantId);
                break;
            }
            case BUSH: {
                currentBushes.remove((Object) currentPlantId);
                break;
            }
            case TREE: {
                currentTrees.remove((Object) currentPlantId);
                break;
            }
        }

        clear();
    }


    // ----- rendering -------------------------------------------------------------------------------------------------
    public void render(Graphics2D graphics2D, Camera camera) {
        for (Plant plant : this) {
            plant.render(graphics2D, camera);
        }
    }

}