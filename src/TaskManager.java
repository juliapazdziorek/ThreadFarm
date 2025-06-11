import zad1.Sprites.FarmCat;
import zad1.Sprites.Patch;
import zad1.Sprites.Plants.HarvestType;
import zad1.Sprites.Plants.PlantType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


public class TaskManager { // SPAGHETTI CLASS

    // ----- properties ------------------------------------------------------------------------------------------------

    final int tileSize = 16;

    // essentials
    SpritesHandler spritesHandler;
    TaskListPanel taskListPanel;

    // collections for managing patches & tasks
    final ArrayList<Patch> patchesToHarvest;
    final HashMap<PlantType, Patch> patchesInHarvest;
    final HashMap<HarvestType, Future<String>> activeTasks;

    // executor service
    private final ExecutorService executorService = Executors.newFixedThreadPool(5);


    // ----- constructor -----------------------------------------------------------------------------------------------

    public TaskManager(SpritesHandler spritesHandler, TaskListPanel taskListPanel) {

        // initialize everything
        this.spritesHandler = spritesHandler;
        this.taskListPanel = taskListPanel;
        patchesToHarvest = new ArrayList<>();
        patchesInHarvest = new HashMap<>();
        activeTasks = new HashMap<>();
    }


    // ----- updating --------------------------------------------------------------------------------------------------
    public void update() {

        // searching for patches ready to harvest
        for (Patch patch : spritesHandler.farmMap.patches.values()) {
            if (patch.readyToHarvest && !patchesToHarvest.contains(patch)) {
                patchesToHarvest.add(patch);
            }
        }

        // removing finished tasks from activeTasks
        ArrayList<HarvestType> tasksToRemove = new ArrayList<>();
        for (Map.Entry<HarvestType, Future<String>> entry : activeTasks.entrySet()) {
            Future<String> task = entry.getValue();
            if (task.isDone()) {
                tasksToRemove.add(entry.getKey());
            }
        }

        for (HarvestType plantType : tasksToRemove) {
            activeTasks.remove(plantType);
        }

    }


    // ----- handling gather -------------------------------------------------------------------------------------------

    public void gather(String resource, ResourceCell resourceCell) {

        // extracting plant type
        PlantType plantType = PlantType.valueOf(resource.toUpperCase());

        Patch patchToHarvest;
        synchronized (patchesToHarvest) {

            // setting patch variables
            patchToHarvest = patchesToHarvest.stream()
                    .filter(patch -> patch.currentPlantType == plantType)
                    .findFirst()
                    .orElse(null);

            // that looks ugly as f, tho IntelliJ was screaming at me what I was using tryCatch
            if (patchToHarvest != null) { // why?
                patchToHarvest.beingHarvested = true;
                patchToHarvest.readyToHarvest = false;
                patchesToHarvest.remove(patchToHarvest);
                patchesInHarvest.put(plantType, patchToHarvest);
            } else {
                return;
            }

        }

        // pls close that file, please, im not commenting on that
        switch (patchToHarvest.harvestType) {

            // ----- CROP1 ---------------------------------------------------------------------------------------------
            case CROP1: {

                Callable<String> callable = () -> {

                    // getting a farmCat
                    FarmCat farmCat = spritesHandler.farmCats.get("crop1");

                     boolean firstPathDone = false;
                     boolean secondPathDone = false;
                     boolean wateringDone = false;
                     boolean thirdPathDone = false;
                     boolean fourthPathDone = false;
                     boolean farmingDone = false;
                     boolean fifthPathDone = false;
                     boolean finished = false;

                    // gathering
                    while (!finished) {
                        if (!firstPathDone) {
                            if (farmCat.positionY < 23 * tileSize) {
                                farmCat.moveDown();
                            } else {
                                firstPathDone = true;
                            }

                        } else if (!secondPathDone) {
                            if (farmCat.positionX > 12 * tileSize) {
                                farmCat.moveLeft();
                            } else {
                                secondPathDone = true;
                            }

                        } else if (!wateringDone) {
                            wateringDone = farmCat.water();

                        } else if (!thirdPathDone) {
                            if (farmCat.positionY < 24 * tileSize) {
                                farmCat.moveDown();
                            } else {
                                thirdPathDone = true;
                            }

                        } else if (!fourthPathDone) {
                            if (farmCat.positionX > 9 * tileSize) {
                                farmCat.moveLeft();
                            } else {
                                fourthPathDone = true;
                            }

                        } else if (!farmingDone) {
                            farmingDone = farmCat.farm();

                        } else if (!fifthPathDone) {
                            if (farmCat.positionX < 17 * tileSize) {
                                farmCat.moveRight();

                                // harvesting patch
                                spritesHandler.farmMap.patches.get("crop1").harvest();

                            } else {
                                fifthPathDone = true;
                            }

                        } else {
                            if (farmCat.positionY > 14 * tileSize) {
                                farmCat.moveUp();
                            } else {
                                finished = true;

                                // setting up patch
                                spritesHandler.farmMap.patches.get("crop1").beingHarvested = false;
                                spritesHandler.farmMap.patches.get("crop1").fillWithPlants();

                                // setting up cat animations
                                farmCat.resetAnimations();

                                // setting up resource cell
                                resourceCell.readyToHarvest = false;
                                resourceCell.abortButton.setEnabled(false);
                                resourceCell.count += 6;
                                resourceCell.resourceLabel.setText(resource + " x" + resourceCell.count);

                            }
                        }
                        Thread.sleep(1000 / 60);
                    }

                    return "6 crops gathered"; //nice
                };

                // managing more stuff
                Future<String> future = executorService.submit(callable);
                activeTasks.put(HarvestType.CROP1, future);
                taskListPanel.add(new TaskWrapper(future, plantType));

                break;
            }


            // ----- CROP2 ---------------------------------------------------------------------------------------------
            case CROP2: {

                Callable<String> callable = () -> {

                    // getting a farmCat
                    FarmCat farmCat = spritesHandler.farmCats.get("crop2");

                    // controls
                    boolean firstPathDone = false;
                    boolean secondPathDone = false;
                    boolean thirdPathDone = false;
                    boolean fourthPathDone = false;
                    boolean fifthPathDone = false;
                    boolean wateringDone = false;
                    boolean farmingDone = false;
                    boolean sixthPathDone = false;
                    boolean seventhPathDone = false;
                    boolean eightPathDone = false;
                    boolean finished = false;

                    // gathering
                    while (!finished) {
                        if (!firstPathDone) {
                            if (farmCat.positionY < 25 * tileSize) {
                                farmCat.moveDown();
                            } else {
                                firstPathDone = true;
                            }

                        } else if (!secondPathDone) {
                            if (farmCat.positionX > 16 * tileSize) {
                                farmCat.moveLeft();
                            } else {
                                secondPathDone = true;
                            }

                        } else if (!thirdPathDone) {
                            if (farmCat.positionY < 27 * tileSize) {
                                farmCat.moveDown();
                            } else {
                                thirdPathDone = true;
                            }

                        } else if (!fourthPathDone) {
                            if (farmCat.positionX > 9 * tileSize) {
                                farmCat.moveLeft();
                            } else {
                                fourthPathDone = true;
                            }

                        } else if (!wateringDone) {
                            wateringDone = farmCat.water();

                        } else if (!fifthPathDone) {
                            if (farmCat.positionX < 12 * tileSize) {
                                farmCat.moveRight();
                            } else {
                                fifthPathDone = true;
                            }

                        } else if (!farmingDone) {
                            farmingDone = farmCat.farm();

                        } else if (!sixthPathDone) {
                            if (farmCat.positionX < 15 * tileSize) {
                                farmCat.moveRight();

                                // harvesting patch
                                spritesHandler.farmMap.patches.get("crop2").harvest();

                            } else {
                                sixthPathDone = true;
                            }

                        } else if (!seventhPathDone) {
                            if (farmCat.positionY > 25 * tileSize) {
                                farmCat.moveUp();
                            } else {
                                seventhPathDone = true;
                            }

                        } else if (!eightPathDone) {
                            if (farmCat.positionX < 17 * tileSize) {
                                farmCat.moveRight();
                            } else {
                                eightPathDone = true;
                            }

                        } else {
                            if (farmCat.positionY > 14 * tileSize) {
                                farmCat.moveUp();
                            } else {
                                finished = true;

                                // setting up patch
                                spritesHandler.farmMap.patches.get("crop2").beingHarvested = false;
                                spritesHandler.farmMap.patches.get("crop2").fillWithPlants();

                                // setting up cat animations
                                farmCat.resetAnimations();

                                // setting up resource cell
                                resourceCell.readyToHarvest = false;
                                resourceCell.abortButton.setEnabled(false);
                                resourceCell.count += 7;
                                resourceCell.resourceLabel.setText(resource + " x" + resourceCell.count);

                            }
                        }

                        Thread.sleep(1000 / 60);
                    }

                    return "7 crops gathered";
                };

                // managing more stuff
                Future<String> future = executorService.submit(callable);
                activeTasks.put(HarvestType.CROP2, future);
                taskListPanel.add(new TaskWrapper(future, plantType));

                break;
            }


            // ----- CROP3 ---------------------------------------------------------------------------------------------
            case CROP3: {

                Callable<String > callable = () -> {

                    // getting a farmCat
                    FarmCat farmCat = spritesHandler.farmCats.get("crop3");

                    // controls
                    boolean firstPathDone = false;
                    boolean secondPathDone = false;
                    boolean thirdPathDone = false;
                    boolean fourthPathDone = false;
                    boolean fifthPathDone = false;
                    boolean wateringDone = false;
                    boolean finished = false;

                    // gathering
                    while (!finished) {
                        if (!firstPathDone) {
                            if (farmCat.positionY < 21 * tileSize) {
                                farmCat.moveDown();
                            } else {
                                firstPathDone = true;
                            }

                        } else if (!secondPathDone) {
                            if (farmCat.positionX < 23 * tileSize) {
                                farmCat.moveRight();
                            } else {
                                secondPathDone = true;
                            }

                        } else if (!thirdPathDone) {
                            if (farmCat.positionY < 23 * tileSize) {
                                farmCat.moveDown();
                            } else {
                                thirdPathDone = true;
                            }

                        } else if (!fourthPathDone) {
                            if (farmCat.positionX < 26 * tileSize) {
                                farmCat.moveRight();
                            } else {
                                fourthPathDone = true;
                            }

                        } else if (!wateringDone) {
                            wateringDone = farmCat.water();

                        } else if (!fifthPathDone) {
                            if (farmCat.positionX > 17 * tileSize) {
                                farmCat.moveLeft();

                                // harvesting patch
                                spritesHandler.farmMap.patches.get("crop3").harvest();

                            } else {
                                fifthPathDone = true;
                            }

                        } else {
                            if (farmCat.positionY > 14 * tileSize) {
                                farmCat.moveUp();
                            } else {
                                finished = true;

                                // setting up patch
                                spritesHandler.farmMap.patches.get("crop3").beingHarvested = false;
                                spritesHandler.farmMap.patches.get("crop3").fillWithPlants();

                                // setting up cat animations
                                farmCat.resetAnimations();

                                // setting up resource cell
                                resourceCell.readyToHarvest = false;
                                resourceCell.abortButton.setEnabled(false);
                                resourceCell.count += 5;
                                resourceCell.resourceLabel.setText(resource + " x" + resourceCell.count);

                            }
                        }
                        Thread.sleep(1000 / 60);
                    }

                    return "5 crops gathered";
                };

                // managing more stuff
                Future<String> future = executorService.submit(callable);
                activeTasks.put(HarvestType.CROP3, future);
                taskListPanel.add(new TaskWrapper(future, plantType));

                break;
            }


            // ----- CROP4 ---------------------------------------------------------------------------------------------
            case CROP4: {

                Callable<String > callable = () -> {

                    // getting a farmCat
                    FarmCat farmCat = spritesHandler.farmCats.get("crop4");

                    // controls
                    boolean firstPathDone = false;
                    boolean secondPathDone = false;
                    boolean thirdPathDone = false;
                    boolean fourthPathDone = false;
                    boolean fifthPathDone = false;
                    boolean wateringDone = false;
                    boolean sixthPathDone = false;
                    boolean farmingDone = false;
                    boolean seventhPathDone = false;
                    boolean eightPathDone = false;
                    boolean ninthPathDone = false;
                    boolean finished = false;

                    // gathering
                    while (!finished) {
                        if (!firstPathDone) {
                            if (farmCat.positionY < 22 * tileSize) {
                                farmCat.moveDown();
                            } else {
                                firstPathDone = true;
                            }

                        } else if (!secondPathDone) {
                            if (farmCat.positionX < 23 * tileSize) {
                                farmCat.moveRight();
                            } else {
                                secondPathDone = true;
                            }

                        } else if (!thirdPathDone) {
                            if (farmCat.positionY < 25 * tileSize) {
                                farmCat.moveDown();
                            } else {
                                thirdPathDone = true;
                            }

                        } else if (!fourthPathDone) {
                            if (farmCat.positionX < 25 * tileSize) {
                                farmCat.moveRight();
                            } else {
                                fourthPathDone = true;
                            }

                        } else if (!fifthPathDone) {
                            if (farmCat.positionY < 26 * tileSize) {
                                farmCat.moveDown();
                            } else {
                                fifthPathDone = true;
                            }

                        } else if (!wateringDone) {
                            wateringDone = farmCat.water();

                        } else if (!sixthPathDone) {
                            if (farmCat.positionX < 26 * tileSize) {
                                farmCat.moveRight();

                            } else {
                                sixthPathDone = true;
                            }

                        } else if (!farmingDone) {
                            farmingDone = farmCat.farm();

                        } else if (!seventhPathDone) {
                            if (farmCat.positionX > 20 * tileSize) {
                                farmCat.moveLeft();

                                // harvesting patch
                                spritesHandler.farmMap.patches.get("crop4").harvest();

                            } else {
                                seventhPathDone = true;
                            }

                        } else if (!eightPathDone) {
                            if (farmCat.positionY > 25 * tileSize) {
                                farmCat.moveUp();

                            } else {
                                eightPathDone = true;
                            }
                        } else if (!ninthPathDone) {
                            if (farmCat.positionX > 17 * tileSize) {
                                farmCat.moveLeft();

                            } else {
                                ninthPathDone = true;
                            }

                        } else {
                            if (farmCat.positionY > 14 * tileSize) {
                                farmCat.moveUp();
                            } else {
                                finished = true;

                                // setting up patch
                                spritesHandler.farmMap.patches.get("crop4").beingHarvested = false;
                                spritesHandler.farmMap.patches.get("crop4").fillWithPlants();

                                // setting up cat animations
                                farmCat.resetAnimations();

                                // setting up resource cell
                                resourceCell.readyToHarvest = false;
                                resourceCell.abortButton.setEnabled(false);
                                resourceCell.count += 5;
                                resourceCell.resourceLabel.setText(resource + " x" + resourceCell.count);

                            }
                        }
                        Thread.sleep(1000 / 60);
                    }

                    return "5 crops gathered";
                };

                // managing more stuff
                Future<String> future = executorService.submit(callable);
                activeTasks.put(HarvestType.CROP4, future);
                taskListPanel.add(new TaskWrapper(future, plantType));

                break;
            }


            // ----- CROP5 ---------------------------------------------------------------------------------------------
            case CROP5: {

                Callable<String > callable = () -> {

                    // getting a farmCat
                    FarmCat farmCat = spritesHandler.farmCats.get("crop5");

                    // controls
                    boolean firstPathDone = false;
                    boolean secondPathDone = false;
                    boolean thirdPathDone = false;
                    boolean fourthPathDone = false;
                    boolean fifthPathDone = false;
                    boolean sixthPathDone = false;
                    boolean farmingDone = false;
                    boolean seventhPathDone = false;
                    boolean eightPathDone = false;
                    boolean ninthPathDone = false;
                    boolean tenthPathDone = false;
                    boolean eleventhPathDone = false;
                    boolean finished = false;

                    // gathering
                    while (!finished) {
                        if (!firstPathDone) {
                            if (farmCat.positionY < 16 * tileSize) {
                                farmCat.moveDown();
                            } else {
                                firstPathDone = true;
                            }

                        } else if (!secondPathDone) {
                                if (farmCat.positionX < 20 * tileSize) {
                                    farmCat.moveRight();
                                } else {
                                    secondPathDone = true;
                                }

                        } else if (!thirdPathDone) {
                            if (farmCat.positionY > 12 * tileSize) {
                                farmCat.moveUp();
                            } else {
                                thirdPathDone = true;
                            }

                        } else if (!fourthPathDone) {
                            if (farmCat.positionX < 35 * tileSize) {
                                farmCat.moveRight();
                            } else {
                                fourthPathDone = true;
                            }

                        } else if (!fifthPathDone) {
                        if (farmCat.positionY > 9 * tileSize) {
                            farmCat.moveUp();
                        } else {
                            fifthPathDone = true;
                        }

                        } else if (!sixthPathDone) {
                            if (farmCat.positionX < 37 * tileSize) {
                                farmCat.moveRight();
                            } else {
                                sixthPathDone = true;
                            }

                        } else if (!farmingDone) {
                            farmingDone = farmCat.farm();

                        } else if (!seventhPathDone) {
                            if (farmCat.positionX > 35 * tileSize) {
                                farmCat.moveLeft();

                                // harvesting patch
                                spritesHandler.farmMap.patches.get("crop5").harvest();

                            } else {
                                seventhPathDone = true;
                            }

                        } else if (!eightPathDone) {
                            if (farmCat.positionY < 12 * tileSize) {
                                farmCat.moveDown();
                            } else {
                                eightPathDone = true;
                            }

                        } else if (!ninthPathDone) {
                            if (farmCat.positionX > 20 * tileSize) {
                                farmCat.moveLeft();
                            } else {
                                ninthPathDone = true;
                            }

                        } else if (!tenthPathDone) {
                            if (farmCat.positionY < 16 * tileSize) {
                                farmCat.moveDown();
                            } else {
                                tenthPathDone = true;
                            }

                        } else if (!eleventhPathDone) {
                            if (farmCat.positionX > 17 * tileSize) {
                                farmCat.moveLeft();
                            } else {
                                eleventhPathDone = true;
                            }

                        } else {
                            if (farmCat.positionY > 14 * tileSize) {
                                farmCat.moveUp();
                            } else {
                                finished = true;

                                // setting up patch
                                spritesHandler.farmMap.patches.get("crop5").beingHarvested = false;
                                spritesHandler.farmMap.patches.get("crop5").fillWithPlants();

                                // setting up cat animations
                                farmCat.resetAnimations();

                                // setting up resource cell
                                resourceCell.readyToHarvest = false;
                                resourceCell.abortButton.setEnabled(false);
                                resourceCell.count += 4;
                                resourceCell.resourceLabel.setText(resource + " x" + resourceCell.count);

                            }
                        }
                        Thread.sleep(1000 / 60);
                    }

                    return "4 crops gathered";
                };

                // managing more stuff
                Future<String> future = executorService.submit(callable);
                activeTasks.put(HarvestType.CROP5, future);
                taskListPanel.add(new TaskWrapper(future, plantType));

                break;
            }


            // ----- FLOWER1 -------------------------------------------------------------------------------------------
            case FLOWER1: {

                Callable<String > callable = () -> {

                    // getting a farmCat
                    FarmCat farmCat = spritesHandler.farmCats.get("flower1");

                    // controls
                    boolean firstPathDone = false;
                    boolean secondPathDone = false;
                    boolean thirdPathDone = false;
                    boolean wateringDone = false;
                    boolean fourthPathDone = false;
                    boolean fifthPathDone = false;
                    boolean sixthPathDone = false;
                    boolean farmingDone = false;
                    boolean finished = false;

                    // gathering
                    while (!finished) {
                        if (!firstPathDone) {
                            if (farmCat.positionY < 19 * tileSize) {
                                farmCat.moveDown();
                            } else {
                                firstPathDone = true;
                            }

                        } else if (!secondPathDone) {
                            if (farmCat.positionX > 12 * tileSize) {
                                farmCat.moveLeft();
                            } else {
                                secondPathDone = true;
                            }

                        } else if (!thirdPathDone) {
                            if (farmCat.positionY > 18 * tileSize) {
                                farmCat.moveUp();
                            } else {
                                thirdPathDone = true;
                            }

                        } else if (!wateringDone) {
                            wateringDone = farmCat.water();

                        } else if (!fourthPathDone) {
                            if (farmCat.positionY > 15 * tileSize) {
                                farmCat.moveUp();
                            } else {
                                fourthPathDone = true;
                            }

                        } else if (!farmingDone) {
                            farmingDone = farmCat.farm();

                        } else if (!fifthPathDone) {
                            if (farmCat.positionY < 19 * tileSize) {
                                farmCat.moveDown();

                                // harvesting patch
                                spritesHandler.farmMap.patches.get("flower1").harvest();

                            } else {
                                fifthPathDone = true;
                            }

                        } else if (!sixthPathDone) {
                            if (farmCat.positionX < 17 * tileSize) {
                                farmCat.moveRight();
                            } else {
                                sixthPathDone = true;
                            }

                        } else if (!finished) {
                            if (farmCat.positionY > 14 * tileSize) {
                                farmCat.moveUp();
                            } else {
                                finished = true;

                                // setting up patch
                                spritesHandler.farmMap.patches.get("flower1").beingHarvested = false;
                                spritesHandler.farmMap.patches.get("flower1").fillWithPlants();

                                // setting up cat animations
                                farmCat.resetAnimations();

                                // setting up resource cell
                                resourceCell.readyToHarvest = false;
                                resourceCell.abortButton.setEnabled(false);
                                resourceCell.count += 6;
                                resourceCell.resourceLabel.setText(resource + " x" + resourceCell.count);

                            }
                        }
                        Thread.sleep(1000 / 60);
                    }

                    return "6 flowers gathered";
                };

                // managing more stuff
                Future<String> future = executorService.submit(callable);
                activeTasks.put(HarvestType.FLOWER1, future);
                taskListPanel.add(new TaskWrapper(future, plantType));

                break;
            }


            // ----- FLOWER2 -------------------------------------------------------------------------------------------
            case FLOWER2: {

                Callable<String > callable = () -> {

                    // getting a farmCat
                    FarmCat farmCat = spritesHandler.farmCats.get("flower2");

                    // controls
                    boolean firstPathDone = false;
                    boolean secondPathDone = false;
                    boolean thirdPathDone = false;
                    boolean fourthPathDone = false;
                    boolean fifthPathDone = false;
                    boolean sixthPathDone = false;
                    boolean seventhPathDone = false;
                    boolean wateringDone = false;
                    boolean eightPathDone = false;
                    boolean ninthPathDone = false;
                    boolean farmingDone = false;
                    boolean tenthPathDone = false;
                    boolean eleventhPathDone = false;
                    boolean twelfthPathDone = false;
                    boolean thirteenthPathDone = false;
                    boolean fourteenthPathDone = false;
                    boolean fifteenthPathDone = false;
                    boolean finished = false;

                    // gathering
                    while (!finished) {
                        if (!firstPathDone) {
                            if (farmCat.positionY < 21 * tileSize) {
                                farmCat.moveDown();
                            } else {
                                firstPathDone = true;
                            }

                        } else if (!secondPathDone) {
                            if (farmCat.positionX < 29 * tileSize) {
                                farmCat.moveRight();
                            } else {
                                secondPathDone = true;
                            }

                        } else if (!thirdPathDone) {
                            if (farmCat.positionY < 24 * tileSize) {
                                farmCat.moveDown();
                            } else {
                                thirdPathDone = true;
                            }

                        } else if (!fourthPathDone) {
                            if (farmCat.positionX < 37 * tileSize) {
                                farmCat.moveRight();
                            } else {
                                fourthPathDone = true;
                            }

                        } else if (!fifthPathDone) {
                            if (farmCat.positionY > 22 * tileSize) {
                                farmCat.moveUp();
                            } else {
                                fifthPathDone = true;
                            }

                        } else if (!sixthPathDone) {
                            if (farmCat.positionX < 39 * tileSize) {
                                farmCat.moveRight();
                            } else {
                                sixthPathDone = true;
                            }

                        } else if (!seventhPathDone) {
                            if (farmCat.positionY > 15 * tileSize) {
                                farmCat.moveUp();
                            } else {
                                seventhPathDone = true;
                            }

                        } else if (!wateringDone) {
                            wateringDone = farmCat.water();

                        } else if (!eightPathDone) {
                            if (farmCat.positionY < 18 * tileSize) {
                                farmCat.moveDown();
                            } else {
                                eightPathDone = true;
                            }

                        } else if (!ninthPathDone) {
                            if (farmCat.positionX > 38 * tileSize) {
                                farmCat.moveLeft();
                            } else {
                                ninthPathDone = true;
                            }

                        } else if (!farmingDone) {
                            farmingDone = farmCat.farm();

                        } else if (!tenthPathDone) {
                            if (farmCat.positionY < 22 * tileSize) {
                                farmCat.moveDown();

                                // harvesting patch
                                spritesHandler.farmMap.patches.get("flower2").harvest();

                            } else {
                                tenthPathDone = true;
                            }

                        } else if (!eleventhPathDone) {
                            if (farmCat.positionX > 37 * tileSize) {
                                farmCat.moveLeft();
                            } else {
                                eleventhPathDone = true;
                            }

                        } else if (!twelfthPathDone) {
                            if (farmCat.positionY < 24 * tileSize) {
                                farmCat.moveDown();
                            } else {
                                twelfthPathDone = true;
                            }

                        } else if (!thirteenthPathDone) {
                            if (farmCat.positionX > 29 * tileSize) {
                                farmCat.moveLeft();
                            } else {
                                thirteenthPathDone = true;
                            }

                        } else if (!fourteenthPathDone) {
                            if (farmCat.positionY > 21 * tileSize) {
                                farmCat.moveUp();
                            } else {
                                fourteenthPathDone = true;
                            }

                        } else if (!fifteenthPathDone) {
                            if (farmCat.positionX > 17 * tileSize) {
                                farmCat.moveLeft();
                            } else {
                                fifteenthPathDone = true;
                            }

                        } else {
                            if (farmCat.positionY > 14 * tileSize) {
                                farmCat.moveUp();
                            } else {
                                finished = true;

                                // setting up patch
                                spritesHandler.farmMap.patches.get("flower2").beingHarvested = false;
                                spritesHandler.farmMap.patches.get("flower2").fillWithPlants();

                                // setting up cat animations
                                farmCat.resetAnimations();

                                // setting up resource cell
                                resourceCell.readyToHarvest = false;
                                resourceCell.abortButton.setEnabled(false);
                                resourceCell.count += 7;
                                resourceCell.resourceLabel.setText(resource + " x" + resourceCell.count);

                            }
                        }
                        Thread.sleep(1000 / 60);
                    }

                    return "7 flowers gathered";
                };

                // managing more stuff
                Future<String> future = executorService.submit(callable);
                activeTasks.put(HarvestType.FLOWER2, future);
                taskListPanel.add(new TaskWrapper(future, plantType));

                break;
            }


            // ----- FLOWER3 -------------------------------------------------------------------------------------------
            case FLOWER3: {

                Callable<String > callable = () -> {

                    // getting a farmCat
                    FarmCat farmCat = spritesHandler.farmCats.get("flower3");

                    // controls
                    boolean firstPathDone = false;
                    boolean secondPathDone = false;
                    boolean thirdPathDone = false;
                    boolean fourthPathDone = false;
                    boolean fifthPathDone = false;
                    boolean sixthPathDone = false;
                    boolean wateringDone = false;
                    boolean seventhPathDone = false;
                    boolean eightPathDone = false;
                    boolean ninthPathDone = false;
                    boolean finished = false;

                    // gathering
                    while (!finished) {
                        if (!firstPathDone) {
                            if (farmCat.positionY < 16 * tileSize) {
                                farmCat.moveDown();
                            } else {
                                firstPathDone = true;
                            }

                        } else if (!secondPathDone) {
                            if (farmCat.positionX < 20 * tileSize) {
                                farmCat.moveRight();
                            } else {
                                secondPathDone = true;
                            }

                        } else if (!thirdPathDone) {
                            if (farmCat.positionY > 12 * tileSize) {
                                farmCat.moveUp();
                            } else {
                                thirdPathDone = true;
                            }

                        } else if (!fourthPathDone) {
                            if (farmCat.positionX < 32 * tileSize) {
                                farmCat.moveRight();
                            } else {
                                fourthPathDone = true;
                            }

                        } else if (!fifthPathDone) {
                            if (farmCat.positionY > 6 * tileSize) {
                                farmCat.moveUp();
                            } else {
                                fifthPathDone = true;
                            }

                        } else if (!wateringDone) {
                            wateringDone = farmCat.water();

                        } else if (!sixthPathDone) {
                            if (farmCat.positionY < 12 * tileSize) {
                                farmCat.moveDown();

                                // harvesting patch
                                spritesHandler.farmMap.patches.get("flower3").harvest();

                            } else {
                                sixthPathDone = true;
                            }

                        } else if (!seventhPathDone) {
                            if (farmCat.positionX > 20 * tileSize) {
                                farmCat.moveLeft();
                            } else {
                                seventhPathDone = true;
                            }

                        } else if (!eightPathDone) {
                            if (farmCat.positionY < 16 * tileSize) {
                                farmCat.moveDown();
                            } else {
                                eightPathDone = true;
                            }

                        } else if (!ninthPathDone) {
                            if (farmCat.positionX > 17 * tileSize) {
                                farmCat.moveLeft();
                            } else {
                                ninthPathDone = true;
                            }

                        } else {
                            if (farmCat.positionY > 14 * tileSize) {
                                farmCat.moveUp();
                            } else {
                                finished = true;

                                // setting up patch
                                spritesHandler.farmMap.patches.get("flower3").beingHarvested = false;
                                spritesHandler.farmMap.patches.get("flower3").fillWithPlants();

                                // setting up cat animations
                                farmCat.resetAnimations();

                                // setting up resource cell
                                resourceCell.readyToHarvest = false;
                                resourceCell.abortButton.setEnabled(false);
                                resourceCell.count += 6;
                                resourceCell.resourceLabel.setText(resource + " x" + resourceCell.count);
;

                            }
                        }
                        Thread.sleep(1000 / 60);
                    }

                    return "6 flowers gathered";
                };

                // managing more stuff
                Future<String> future = executorService.submit(callable);
                activeTasks.put(HarvestType.FLOWER3, future);
                taskListPanel.add(new TaskWrapper(future, plantType));

                break;
            }


            // ----- MUSHROOM ------------------------------------------------------------------------------------------
            case MUSHROOM: {

                Callable<String > callable = () -> {

                    // getting a farmCat
                    FarmCat farmCat = spritesHandler.farmCats.get("mushroom");

                    // controls
                    boolean firstPathDone = false;
                    boolean secondPathDone = false;
                    boolean firstFarmingDone = false;
                    boolean thirdPathDone = false;
                    boolean fourthPathDone = false;
                    boolean fifthPathDone = false;
                    boolean sixthPathDone = false;
                    boolean seventhPathDone = false;
                    boolean eightPathDone = false;
                    boolean ninthPathDone = false;
                    boolean tenthPathDone = false;
                    boolean eleventhPathDone = false;
                    boolean secondFarmingDone = false;
                    boolean twelfthPathDone = false;
                    boolean thirteenthPathDone = false;
                    boolean fourteenthPathDone = false;
                    boolean fifteenthPathDone = false;
                    boolean sixteenthPathDone = false;
                    boolean seventeenthPathDone = false;
                    boolean eighteenthPathDone = false;
                    boolean finished = false;

                    // gathering
                    while (!finished) {
                        if (!firstPathDone) {
                            if (farmCat.positionY < 20 * tileSize) {
                                farmCat.moveDown();
                            } else {
                                firstPathDone = true;
                            }

                        } else if (!secondPathDone) {
                            if (farmCat.positionX < 24 * tileSize) {
                                farmCat.moveRight();
                            } else {
                                secondPathDone = true;
                            }

                        } else if (!firstFarmingDone) {
                            firstFarmingDone = farmCat.farm();

                        } else if (!thirdPathDone) {
                            if (farmCat.positionX < 28 * tileSize) {
                                farmCat.moveRight();
                            } else {
                                thirdPathDone = true;
                            }

                        } else if (!fourthPathDone) {
                            if (farmCat.positionY < 24 * tileSize) {
                                farmCat.moveDown();
                            } else {
                                fourthPathDone = true;
                            }

                        } else if (!fifthPathDone) {
                            if (farmCat.positionX < 37 * tileSize) {
                                farmCat.moveRight();
                            } else {
                                fifthPathDone = true;
                            }

                        } else if (!sixthPathDone) {
                            if (farmCat.positionY > 23 * tileSize) {
                                farmCat.moveUp();
                            } else {
                                sixthPathDone = true;
                            }

                        } else if (!seventhPathDone) {
                            if (farmCat.positionX < 41 * tileSize) {
                                farmCat.moveRight();
                            } else {
                                seventhPathDone = true;
                            }

                        } else if (!eightPathDone) {
                            if (farmCat.positionY > 14 * tileSize) {
                                farmCat.moveUp();
                            } else {
                                eightPathDone = true;
                            }

                        } else if (!ninthPathDone) {
                            if (farmCat.positionX > 35 * tileSize) {
                                farmCat.moveLeft();
                            } else {
                                ninthPathDone = true;
                            }

                        } else if (!tenthPathDone) {
                            if (farmCat.positionY > 8 * tileSize) {
                                farmCat.moveUp();
                            } else {
                                tenthPathDone = true;
                            }

                        } else if (!eleventhPathDone) {
                            if (farmCat.positionX > 32 * tileSize) {
                                farmCat.moveLeft();
                            } else {
                                eleventhPathDone = true;
                            }

                        } else if (!twelfthPathDone) {
                            if (farmCat.positionY > 4 * tileSize) {
                                farmCat.moveUp();
                            } else {
                                twelfthPathDone = true;
                            }

                        } else if (!secondFarmingDone) {
                            secondFarmingDone = farmCat.farm();

                        } else if (!thirteenthPathDone) {
                            if (farmCat.positionY < 12 * tileSize) {
                                farmCat.moveDown();
                            } else {
                                thirteenthPathDone = true;
                            }

                        } else if (!fourteenthPathDone) {
                            if (farmCat.positionX > 21 * tileSize) {
                                farmCat.moveLeft();
                            } else {
                                fourteenthPathDone = true;
                            }

                        } else if (!fifteenthPathDone) {
                            if (farmCat.positionY > 11 * tileSize) {
                                farmCat.moveUp();
                            } else {
                                fifteenthPathDone = true;
                            }

                        } else if (!sixteenthPathDone) {
                            if (farmCat.positionX > 11 * tileSize) {
                                farmCat.moveLeft();
                            } else {
                                sixteenthPathDone = true;
                            }

                        } else if (!seventeenthPathDone) {
                            if (farmCat.positionY < 19 * tileSize) {
                                farmCat.moveDown();

                                // harvesting patch
                                spritesHandler.farmMap.patches.get("mushroom").harvest();

                            } else {
                                seventeenthPathDone = true;
                            }

                        } else if (!eighteenthPathDone) {
                            if (farmCat.positionX < 17 * tileSize) {
                                farmCat.moveRight();
                            } else {
                                eighteenthPathDone = true;
                            }

                        } else if (!finished) {
                            if (farmCat.positionY > 14 * tileSize) {
                                farmCat.moveUp();
                            } else {
                                finished = true;

                                // setting up patch
                                spritesHandler.farmMap.patches.get("mushroom").beingHarvested = false;
                                spritesHandler.farmMap.patches.get("mushroom").fillWithPlants();

                                // setting up cat animations
                                farmCat.resetAnimations();

                                // setting up resource cell
                                resourceCell.readyToHarvest = false;
                                resourceCell.abortButton.setEnabled(false);
                                resourceCell.count += 10;
                                resourceCell.resourceLabel.setText(resource + " x" + resourceCell.count);


                            }
                        }
                        Thread.sleep(1000 / 60);
                    }

                    return "10 mushrooms gathered";
                };

                // managing more stuff
                Future<String> future = executorService.submit(callable);
                activeTasks.put(HarvestType.MUSHROOM, future);
                taskListPanel.add(new TaskWrapper(future, plantType));

                break;
            }


            // ----- BUSH1 ---------------------------------------------------------------------------------------------
            case BUSH1: {

                Callable<String > callable = () -> {

                    // getting a farmCat
                    FarmCat farmCat = spritesHandler.farmCats.get("bush1");

                    // controls
                     boolean firstPathDone = false;
                     boolean secondPathDone = false;
                     boolean thirdPathDone = false;
                     boolean fourthPathDone = false;
                     boolean fifthPathDone = false;
                     boolean sixthPathDone = false;
                     boolean firstWateringDone = false;
                     boolean secondWateringDone = false;
                     boolean finished = false;

                    // gathering
                    while (!finished) {
                        if (!firstPathDone) {
                            if (farmCat.positionY < 16 * tileSize) {
                                farmCat.moveDown();
                            } else {
                                firstPathDone = true;
                            }

                        } else if (!secondPathDone) {
                            if (farmCat.positionX < 20 * tileSize) {
                                farmCat.moveRight();
                            } else {
                                secondPathDone = true;
                            }

                        } else if (!firstWateringDone) {
                            firstWateringDone = farmCat.water();

                        } else if (!thirdPathDone) {
                            if (farmCat.positionX < 22 * tileSize) {
                                farmCat.moveRight();
                            } else {
                                thirdPathDone = true;
                            }

                        } else if (!fourthPathDone) {
                            if (farmCat.positionY > 15 * tileSize) {
                                farmCat.moveUp();
                            } else {
                                fourthPathDone = true;
                            }

                        } else if (!secondWateringDone) {
                            secondWateringDone = farmCat.water();

                        } else if (!fifthPathDone) {
                            if (farmCat.positionY < 16 * tileSize) {
                                farmCat.moveDown();

                                // harvesting patch
                                spritesHandler.farmMap.patches.get("bush1").harvest();

                            } else {
                                fifthPathDone = true;
                            }

                        } else if (!sixthPathDone) {
                            if (farmCat.positionX > 17 * tileSize) {
                                farmCat.moveLeft();
                            } else {
                                sixthPathDone = true;
                            }

                        } else {
                            if (farmCat.positionY > 14 * tileSize) {
                                farmCat.moveUp();
                            } else {
                                finished = true;

                                // setting up patch
                                spritesHandler.farmMap.patches.get("bush1").beingHarvested = false;
                                spritesHandler.farmMap.patches.get("bush1").fillWithPlants();

                                // setting up cat animations
                                farmCat.resetAnimations();

                                // setting up resource cell
                                resourceCell.readyToHarvest = false;
                                resourceCell.abortButton.setEnabled(false);
                                resourceCell.count += 12;
                                resourceCell.resourceLabel.setText(resource + " x" + resourceCell.count);


                            }
                        }

                        Thread.sleep(1000 / 60);
                    }

                    return "12 fruits gathered";
                };

                // managing more stuff
                Future<String> future = executorService.submit(callable);
                activeTasks.put(HarvestType.BUSH1, future);
                taskListPanel.add(new TaskWrapper(future, plantType));

                break;
            }


            // ----- BUSH2 ---------------------------------------------------------------------------------------------
            case BUSH2: {

                Callable<String > callable = () -> {

                    // getting a farmCat
                    FarmCat farmCat = spritesHandler.farmCats.get("bush2");

                    // controls
                    boolean firstPathDone = false;
                    boolean secondPathDone = false;
                    boolean thirdPathDone = false;
                    boolean fourthPathDone = false;
                    boolean fifthPathDone = false;
                    boolean sixthPathDone = false;
                    boolean wateringDone = false;
                    boolean seventhPathDone = false;
                    boolean eightPathDone = false;
                    boolean ninthPathDone = false;
                    boolean finished = false;

                    // gathering
                    while (!finished) {
                        if (!firstPathDone) {
                            if (farmCat.positionY < 16 * tileSize) {
                                farmCat.moveDown();
                            } else {
                                firstPathDone = true;
                            }

                        } else if (!secondPathDone) {
                            if (farmCat.positionX < 20 * tileSize) {
                                farmCat.moveRight();
                            } else {
                                secondPathDone = true;
                            }

                        } else if (!thirdPathDone) {
                            if (farmCat.positionY > 12 * tileSize) {
                                farmCat.moveUp();
                            } else {
                                thirdPathDone = true;
                            }

                        } else if (!fourthPathDone) {
                            if (farmCat.positionX < 30 * tileSize) {
                                farmCat.moveRight();
                            } else {
                                fourthPathDone = true;
                            }

                        } else if (!fifthPathDone) {
                            if (farmCat.positionY > 6 * tileSize) {
                                farmCat.moveUp();
                            } else {
                                fifthPathDone = true;
                            }

                        } else if (!wateringDone) {
                            wateringDone = farmCat.water();

                        } else if (!sixthPathDone) {
                            if (farmCat.positionY < 12 * tileSize) {
                                farmCat.moveDown();

                                // harvesting patch
                                spritesHandler.farmMap.patches.get("bush2").harvest();

                            } else {
                                sixthPathDone = true;
                            }

                        } else if (!seventhPathDone) {
                            if (farmCat.positionX > 20 * tileSize) {
                                farmCat.moveLeft();
                            } else {
                                seventhPathDone = true;
                            }

                        } else if (!eightPathDone) {
                            if (farmCat.positionY < 16 * tileSize) {
                                farmCat.moveDown();
                            } else {
                                eightPathDone = true;
                            }

                        } else if (!ninthPathDone) {
                            if (farmCat.positionX > 17 * tileSize) {
                                farmCat.moveLeft();
                            } else {
                                ninthPathDone = true;
                            }

                        } else {
                            if (farmCat.positionY > 14 * tileSize) {
                                farmCat.moveUp();
                            } else {
                                finished = true;

                                // setting up patch
                                spritesHandler.farmMap.patches.get("bush2").beingHarvested = false;
                                spritesHandler.farmMap.patches.get("bush2").fillWithPlants();

                                // setting up cat animations
                                farmCat.resetAnimations();

                                // setting up resource cell
                                resourceCell.readyToHarvest = false;
                                resourceCell.abortButton.setEnabled(false);
                                resourceCell.count += 9;
                                resourceCell.resourceLabel.setText(resource + " x" + resourceCell.count);

                            }
                        }

                        Thread.sleep(1000 / 60);
                    }

                    return "9 fruits gathered";
                };

                // managing more stuff
                Future<String> future = executorService.submit(callable);
                activeTasks.put(HarvestType.BUSH2, future);
                taskListPanel.add(new TaskWrapper(future, plantType));

                break;
            }


            // ----- TREE1 ---------------------------------------------------------------------------------------------
            case TREE1: {

                Callable<String > callable = () -> {

                    // getting a farmCat
                    FarmCat farmCat = spritesHandler.farmCats.get("tree1");

                    // controls
                    boolean firstPathDone = false;
                    boolean secondPathDone = false;
                    boolean thirdPathDone = false;
                    boolean fourthPathDone = false;
                    boolean wateringDone = false;
                    boolean finished = false;

                    // gathering
                    while (!finished) {
                        if (!firstPathDone) {
                            if (farmCat.positionY < 25 * tileSize) {
                                farmCat.moveDown();
                            } else {
                                firstPathDone = true;
                            }

                        } else if (!secondPathDone) {
                            if (farmCat.positionX < 19 * tileSize) {
                                farmCat.moveRight();
                            } else {
                                secondPathDone = true;
                            }

                        } else if (!thirdPathDone) {
                            if (farmCat.positionY > 24 * tileSize) {
                                farmCat.moveUp();
                            } else {
                                thirdPathDone = true;
                            }

                        } else if (!wateringDone) {
                            wateringDone = farmCat.water();

                        } else if (!fourthPathDone) {
                            if (farmCat.positionX > 17 * tileSize) {
                                farmCat.moveLeft();

                                // harvesting patch
                                spritesHandler.farmMap.patches.get("tree1").harvest();

                            } else {
                                fourthPathDone = true;
                            }

                        } else {
                            if (farmCat.positionY > 14 * tileSize) {
                                farmCat.moveUp();
                            } else {
                                finished = true;

                                // setting up patch
                                spritesHandler.farmMap.patches.get("tree1").beingHarvested = false;
                                spritesHandler.farmMap.patches.get("tree1").fillWithPlants();

                                // setting up cat animations
                                farmCat.resetAnimations();

                                // setting up resource cell
                                resourceCell.readyToHarvest = false;
                                resourceCell.abortButton.setEnabled(false);
                                resourceCell.count += 9;
                                resourceCell.resourceLabel.setText(resource + " x" + resourceCell.count);

                            }
                        }

                        Thread.sleep(1000 / 60);
                    }

                    return "9 fruits gathered";
                };

                // managing more stuff
                Future<String> future = executorService.submit(callable);
                activeTasks.put(HarvestType.TREE1, future);
                taskListPanel.add(new TaskWrapper(future, plantType));

                break;
            }


            // ----- TREE2 ---------------------------------------------------------------------------------------------
            case TREE2: {

                Callable<String > callable = () -> {

                    // getting a farmCat
                    FarmCat farmCat = spritesHandler.farmCats.get("tree2");

                    // controls
                    boolean firstPathDone = false;
                    boolean secondPathDone = false;
                    boolean thirdPathDone = false;
                    boolean fourthPathDone = false;
                    boolean wateringDone = false;
                    boolean fifthPathDone = false;
                    boolean sixthPathDone = false;
                    boolean seventhPathDone = false;
                    boolean finished = false;

                    // gathering
                    while (!finished) {
                        if (!firstPathDone) {
                            if (farmCat.positionY < 19 * tileSize) {
                                farmCat.moveDown();
                            } else {
                                firstPathDone = true;
                            }

                        } else if (!secondPathDone) {
                            if (farmCat.positionX > 11 * tileSize) {
                                farmCat.moveLeft();

                            } else {
                                secondPathDone = true;
                            }

                        } else if (!thirdPathDone) {
                            if (farmCat.positionY > 10 * tileSize) {
                                farmCat.moveUp();
                            } else {
                                thirdPathDone = true;
                            }

                        } else if (!fourthPathDone) {
                            if (farmCat.positionX < 14 * tileSize) {
                                farmCat.moveRight();
                            } else {
                                fourthPathDone = true;
                            }

                        } else if (!wateringDone) {
                            wateringDone = farmCat.water();

                        } else if (!fifthPathDone) {
                            if (farmCat.positionX > 11 * tileSize) {
                                farmCat.moveLeft();

                                // harvesting patch
                                spritesHandler.farmMap.patches.get("tree2").harvest();

                            } else {
                                fifthPathDone = true;
                            }

                        } else if (!sixthPathDone) {
                            if (farmCat.positionY < 19 * tileSize) {
                                farmCat.moveDown();
                            } else {
                                sixthPathDone = true;
                            }

                        } else if (!seventhPathDone) {
                            if (farmCat.positionX < 17 * tileSize) {
                                farmCat.moveRight();
                            } else {
                                seventhPathDone = true;
                            }

                        } else {
                            if (farmCat.positionY > 14 * tileSize) {
                                farmCat.moveUp();
                            } else {
                                finished = true;

                                // setting up patch
                                spritesHandler.farmMap.patches.get("tree2").beingHarvested = false;
                                spritesHandler.farmMap.patches.get("tree2").fillWithPlants();

                                // setting up cat animations
                                farmCat.resetAnimations();

                                // setting up resource cell
                                resourceCell.readyToHarvest = false;
                                resourceCell.abortButton.setEnabled(false);
                                resourceCell.count += 9;
                                resourceCell.resourceLabel.setText(resource + " x" + resourceCell.count);

                            }
                        }

                        Thread.sleep(1000 / 60);
                    }

                    return "9 fruits gathered";
                };

                // managing more stuff
                Future<String> future = executorService.submit(callable);
                activeTasks.put(HarvestType.TREE2, future);
                taskListPanel.add(new TaskWrapper(future, plantType));

                break;
            }


            // ----- TREE3 ---------------------------------------------------------------------------------------------
            case TREE3: {

                Callable<String > callable = () -> {

                    // getting a farmCat
                    FarmCat farmCat = spritesHandler.farmCats.get("tree3");

                    // controls
                    boolean firstPathDone = false;
                    boolean secondPathDone = false;
                    boolean thirdPathDone = false;
                    boolean fourthPathDone = false;
                    boolean wateringDone = false;
                    boolean fifthPathDone = false;
                    boolean sixthPathDone = false;
                    boolean seventhPathDone = false;
                    boolean eightPathDone = false;
                    boolean ninthPathDone = false;
                    boolean finished = false;

                    // gathering
                    while (!finished) {
                        if (!firstPathDone) {
                            if (farmCat.positionY < 21 * tileSize) {
                                farmCat.moveDown();
                            } else {
                                firstPathDone = true;
                            }

                        } else if (!secondPathDone) {
                            if (farmCat.positionX < 29 * tileSize) {
                                farmCat.moveRight();

                            } else {
                                secondPathDone = true;
                            }

                        } else if (!thirdPathDone) {
                            if (farmCat.positionY < 24 * tileSize) {
                                farmCat.moveDown();
                            } else {
                                thirdPathDone = true;
                            }

                        } else if (!fourthPathDone) {
                            if (farmCat.positionX < 39 * tileSize) {
                                farmCat.moveRight();
                            } else {
                                fourthPathDone = true;
                            }

                        } else if (!fifthPathDone) {
                            if (farmCat.positionY < 27 * tileSize) {
                                farmCat.moveDown();
                            } else {
                                fifthPathDone = true;
                            }

                        } else if (!wateringDone) {
                            wateringDone = farmCat.water();

                        } else if (!sixthPathDone) {
                            if (farmCat.positionY > 24 * tileSize) {
                                farmCat.moveUp();
                            } else {
                                sixthPathDone = true;
                            }

                        } else if (!seventhPathDone) {
                            if (farmCat.positionX > 29 * tileSize) {
                                farmCat.moveLeft();

                                // harvesting patch
                                spritesHandler.farmMap.patches.get("tree3").harvest();

                            } else {
                                seventhPathDone = true;
                            }

                        } else if (!eightPathDone) {
                            if (farmCat.positionY > 21 * tileSize) {
                                farmCat.moveUp();
                            } else {
                                eightPathDone = true;
                            }

                        } else if (!ninthPathDone) {
                            if (farmCat.positionX > 17 * tileSize) {
                                farmCat.moveLeft();
                            } else {
                                ninthPathDone = true;
                            }

                        } else {
                            if (farmCat.positionY > 14 * tileSize) {
                                farmCat.moveUp();
                            } else {
                                finished = true;

                                // setting up patch
                                spritesHandler.farmMap.patches.get("tree3").beingHarvested = false;
                                spritesHandler.farmMap.patches.get("tree3").fillWithPlants();

                                // setting up cat animations
                                farmCat.resetAnimations();

                                // setting up resource cell
                                resourceCell.readyToHarvest = false;
                                resourceCell.abortButton.setEnabled(false);
                                resourceCell.count += 9;
                                resourceCell.resourceLabel.setText(resource + " x" + resourceCell.count);

                            }
                        }

                        Thread.sleep(1000 / 60);
                    }

                    return "9 fruits gathered";
                };

                // managing more stuff
                Future<String> future = executorService.submit(callable);
                activeTasks.put(HarvestType.TREE3, future);
                taskListPanel.add(new TaskWrapper(future, plantType));

                break;
            }

        }
    }


    // ----- handling abort -> spaghetti (no idea what going on) -------------------------------------------------------

    public void abort(String resource, ResourceCell resourceCell) {

        // extracting plant type
        PlantType plantType = PlantType.valueOf(resource.toUpperCase());

        // canceling task in future
        Patch patch = patchesInHarvest.get(plantType);
        if (patch == null) {
            return;
        }

        Future<String> future = activeTasks.get(patch.harvestType);
        if (future != null) {
            future.cancel(true);
            activeTasks.remove(patch.harvestType);
        }

        patchesToHarvest.remove(patch);
        patchesInHarvest.remove(plantType);

        patch.beingHarvested = false;
        patch.readyToHarvest = false;

        if (patch.isEmpty()) {

            patch.fillWithPlants();

        }

        // setting up resource cell
        resourceCell.readyToHarvest = false;

        // setting up cat
        FarmCat farmCat = spritesHandler.farmCats.get(patch.harvestType.toString().toLowerCase());
        if (farmCat != null) {
            farmCat.resetAnimations();
            farmCat.positionX = 17 * tileSize;
            farmCat.positionY = 14 * tileSize;
        }

    }
}