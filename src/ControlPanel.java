import zad1.Sprites.Patch;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ControlPanel extends JPanel {

    // ---- properties -------------------------------------------------------------------------------------------------

    // screen properties
    final int originalTileSize = 16;
    final int scale = 3;
    final int tileSize = originalTileSize * scale;
    final int maxScreenColumns = 16;
    final int maxScreenRows = 12;
    final int screenWidth = tileSize * maxScreenColumns;
    final int screenHeight = tileSize * maxScreenRows;

    TaskManager taskManager;
    ArrayList<ResourceCell> resourcesCells;


    // ----- constructor -----------------------------------------------------------------------------------------------

    public ControlPanel(SpritesHandler spritesHandler, TaskManager taskManager) {

        this.taskManager = taskManager;

        setPreferredSize(new Dimension(screenWidth / 2, screenHeight));
        setLayout(new BorderLayout());
        setBackground(spritesHandler.backgroundColor);
        setBorder(BorderFactory.createLineBorder(spritesHandler.borderColor, 3));

        // title
        JLabel titleLabel = new JLabel("Control Panel", SwingConstants.CENTER);
        titleLabel.setFont(spritesHandler.dayDreamFont);
        titleLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        titleLabel.setForeground(spritesHandler.borderColor);
        add(titleLabel, BorderLayout.NORTH);

        // resources grid
        JPanel resourcesGrid = new JPanel(new GridLayout(8, 3, 10, 10));
        resourcesGrid.setBorder(BorderFactory.createLineBorder(spritesHandler.borderColor, 3));
        resourcesGrid.setBackground(spritesHandler.backgroundColor);
        resourcesGrid.setFocusable(false);

        // jScrollPane
        JScrollPane jScrollPane = new JScrollPane(resourcesGrid);
        add(jScrollPane, BorderLayout.CENTER);
        jScrollPane.setFocusable(false);

        resourcesCells = new ArrayList<>();

        // creating grid cells
        resourcesCells.add(new ResourceCell(spritesHandler, this, "carrot")); // ouch
        resourcesCells.add(new ResourceCell(spritesHandler, this, "cauliflower"));
        resourcesCells.add(new ResourceCell(spritesHandler, this, "tomato"));
        resourcesCells.add(new ResourceCell(spritesHandler, this, "eggplant"));
        resourcesCells.add(new ResourceCell(spritesHandler, this, "lettuce"));
        resourcesCells.add(new ResourceCell(spritesHandler, this, "wheat"));
        resourcesCells.add(new ResourceCell(spritesHandler, this, "pumpkin"));
        resourcesCells.add(new ResourceCell(spritesHandler, this, "radish"));
        resourcesCells.add(new ResourceCell(spritesHandler, this, "cucumber"));
        resourcesCells.add(new ResourceCell(spritesHandler, this, "dandelion"));
        resourcesCells.add(new ResourceCell(spritesHandler, this, "violet"));
        resourcesCells.add(new ResourceCell(spritesHandler, this, "peony"));
        resourcesCells.add(new ResourceCell(spritesHandler, this, "cornflower"));
        resourcesCells.add(new ResourceCell(spritesHandler, this, "daisy"));
        resourcesCells.add(new ResourceCell(spritesHandler, this, "hyacinth"));
        resourcesCells.add(new ResourceCell(spritesHandler, this, "toadstool"));
        resourcesCells.add(new ResourceCell(spritesHandler, this, "mushroom"));
        resourcesCells.add(new ResourceCell(spritesHandler, this, "raspberry"));
        resourcesCells.add(new ResourceCell(spritesHandler, this, "plum"));
        resourcesCells.add(new ResourceCell(spritesHandler, this, "blueberry"));
        resourcesCells.add(new ResourceCell(spritesHandler, this, "apple"));
        resourcesCells.add(new ResourceCell(spritesHandler, this, "orange"));
        resourcesCells.add(new ResourceCell(spritesHandler, this, "pear"));
        resourcesCells.add(new ResourceCell(spritesHandler, this, "peach"));

        for(ResourceCell resourceCell : resourcesCells) {
            resourcesGrid.add(resourceCell);
        }

    }


    // ----- updating --------------------------------------------------------------------------------------------------

    public void update() {

        // checking if plant is ready to harvest
        for (ResourceCell resourceCell : resourcesCells) {
            if (!resourceCell.readyToHarvest) {
                for (Patch patch : taskManager.patchesToHarvest) {
                    if(resourceCell.plantType == patch.currentPlantType) {
                        resourceCell.setReadyToHarvest();
                    }
                }
            }
        }

    }


    // ----- handling events -------------------------------------------------------------------------------------------
    void handleGather(String resource, ResourceCell resourceCell) {
        resourceCell.abortButton.setEnabled(true);
        resourceCell.gatherButton.setEnabled(false);

        taskManager.gather(resource, resourceCell);
    }

    void handleAbort(String resource, ResourceCell resourceCell) {
        resourceCell.abortButton.setEnabled(false);

        taskManager.abort(resource, resourceCell);
    }

}