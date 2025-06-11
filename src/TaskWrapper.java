import zad1.Sprites.Plants.PlantType;

import java.util.HashMap;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class TaskWrapper {

    // ----- properties ------------------------------------------------------------------------------------------------

    // statics
    static int counterEverything = 0;
    static HashMap<String, Integer> counter = new HashMap<>();

    String lowerCasePlant;
    PlantType plantType;
    Future<String> future;

    // ----- constructor -----------------------------------------------------------------------------------------------

    public TaskWrapper(Future<String> future, PlantType plantType) {

        if (counter.isEmpty()) { // I did not
            counter.put("carrot", 0);
            counter.put("cauliflower", 0);
            counter.put("tomato", 0);
            counter.put("eggplant", 0);
            counter.put("lettuce", 0);
            counter.put("wheat", 0);
            counter.put("pumpkin", 0);
            counter.put("radish", 0);
            counter.put("cucumber", 0);
            counter.put("dandelion", 0);
            counter.put("violet", 0);
            counter.put("peony", 0);
            counter.put("cornflower", 0);
            counter.put("daisy", 0);
            counter.put("hyacinth", 0);
            counter.put("toadstool", 0);
            counter.put("mushroom", 0);
            counter.put("raspberry", 0);
            counter.put("plum", 0);
            counter.put("blueberry", 0);
            counter.put("apple", 0);
            counter.put("orange", 0);
            counter.put("pear", 0);
            counter.put("peach", 0);
        }

        counterEverything++;
        lowerCasePlant = plantType.toString().toLowerCase();
        counter.put(lowerCasePlant, counter.get(lowerCasePlant) + 1);
        this.plantType = plantType;
        this.future = future;

    }


    // ----- getting task name, state and result -----------------------------------------------------------------------

    public String getName() {
        return "task " + counterEverything  + ": gathering " +  lowerCasePlant + "s " + counter.get(lowerCasePlant);
    }

    public String getState() {
        if (future.isCancelled()) {
            return "aborted";
        } else if (future.isDone()) {
            return "finished";
        } else {
            return "processing";
        }
    }

    public String getResult() {
        if (future.isDone()) {
            try {
                return future.get();
            } catch (InterruptedException | ExecutionException | CancellationException exception) {
                return "no result";
            }
        } else {
            return "result not ready yet";
        }
    }

}