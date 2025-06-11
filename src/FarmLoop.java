import javax.swing.*;

public class FarmLoop {

    // ----- properties ------------------------------------------------------------------------------------------------
    private final Timer timer;

    // ----- constructor -----------------------------------------------------------------------------------------------
    public FarmLoop(Camera camera, ActionHandler actionHandler, FarmPanel farmPanel, ControlPanel controlPanel, TaskListPanel taskListPanel, TaskManager taskManager, int fps) { //TODO o co tu chodzi nauczyć się przed oddwaniem tego syfu
        timer = new Timer(1000 / fps, e -> {
            // timer is a class used for handling events in GUI at specified intervals.
            // It is commonly used in Swing applications to perform actions at regular intervals on the Event Dispatch Thread (EDT).
            // method used in lambda: actionPerformed, invoked every time the Timer fires an event at the specified interval
            // java javing hard

            // updating stuff
            actionHandler.moveCamera(camera);

            taskManager.update();

            controlPanel.update();
            controlPanel.repaint();

            taskListPanel.update();
            taskListPanel.repaint();

            farmPanel.update();
            farmPanel.repaint(); // (𖦹 _ 𖦹)

        });
    }

    // ----- LETSGOOO --------------------------------------------------------------------------------------------------
    public void start() {
        timer.start();
    }

}