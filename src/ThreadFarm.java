import javax.swing.*;
import java.awt.*;

public class ThreadFarm extends JFrame {

    // ----- properties ------------------------------------------------------------------------------------------------

    // app properties
    final int fps = 60;

    // farm essentials
    Camera camera;
    SpritesHandler spritesHandler;
    ActionHandler actionHandler;
    TaskListPanel taskListPanel;
    TaskManager taskManager;
    ControlPanel controlPanel;
    FarmPanel farmPanel;
    FarmLoop farmLoop;


    // ----- constructor -----------------------------------------------------------------------------------------------
    public ThreadFarm() {
        SwingUtilities.invokeLater(this::launchFarm);
    }


    // ----- launching farm --------------------------------------------------------------------------------------------
    private void launchFarm() {

        // window set up
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("ThreadFarm");
        setResizable(true);
        setLocationRelativeTo(null);

        // create camera
        camera = new Camera(16, 12);

        // create sprites
        spritesHandler = new SpritesHandler();

        // action handler
        actionHandler = new ActionHandler(camera);

        // create taskListPanel
        taskListPanel = new TaskListPanel(spritesHandler);
        add(taskListPanel, BorderLayout.SOUTH);

        // create taskManager
        taskManager = new TaskManager(spritesHandler, taskListPanel);

        // control panel
        controlPanel = new ControlPanel(spritesHandler, taskManager);
        add(controlPanel, BorderLayout.WEST);

        // create farmPanel
        farmPanel = new FarmPanel(camera, spritesHandler);
        farmPanel.addKeyListener(actionHandler);
        farmPanel.requestFocusInWindow();
        add(farmPanel, BorderLayout.CENTER);

        // another window set up
        pack();
        setVisible(true);

        // farm lo ^(o_o)^ op
        farmLoop = new FarmLoop(camera, actionHandler, farmPanel, controlPanel, taskListPanel, taskManager, fps);
        farmLoop.start();

    }
}