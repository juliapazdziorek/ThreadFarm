import zad1.Sprites.Plants.PlantType;

import javax.swing.*;
import java.awt.*;

public class ResourceCell extends JPanel {

    // ----- properties --------------------------------------------------------------------------------------------

    String resource;
    public int count;
    boolean readyToHarvest;
    PlantType plantType;

    JButton gatherButton;
    JButton abortButton;
    public JLabel resourceLabel;


    // ----- constructor -------------------------------------------------------------------------------------------

    ResourceCell(SpritesHandler spritesHandler, ControlPanel controlPanel, String resource) {

        this.resource = resource;
        count = 0;
        readyToHarvest = false;
        plantType = PlantType.valueOf(resource.toUpperCase());

        setLayout(new BorderLayout());
        setBackground(spritesHandler.backgroundColor);

        // label
        resourceLabel = new JLabel(resource + " x" + count, SwingConstants.CENTER);
        resourceLabel.setFont(spritesHandler.minecraftiaFont);
        resourceLabel.setForeground(spritesHandler.labelColor);
        add(resourceLabel, BorderLayout.CENTER);

        // buttons
        JPanel buttonPanel = new JPanel(new BorderLayout());
        buttonPanel.setBackground(spritesHandler.backgroundColor);

        gatherButton = new JButton("gather");
        gatherButton.addActionListener(event -> controlPanel.handleGather(resource, this)); // loads of GUI
        gatherButton.setFont(spritesHandler.minecraftiaFont);
        gatherButton.setBackground(spritesHandler.borderColor);
        gatherButton.setForeground(spritesHandler.labelColor);
        gatherButton.setEnabled(false);
        gatherButton.setFocusable(false);

        abortButton = new JButton("abort");
        abortButton.addActionListener(event -> controlPanel.handleAbort(resource, this));
        abortButton.setFont(spritesHandler.minecraftiaFont);
        abortButton.setBackground(spritesHandler.borderColor);
        abortButton.setForeground(spritesHandler.labelColor);
        abortButton.setEnabled(false);
        abortButton.setFocusable(false);

        buttonPanel.add(gatherButton, BorderLayout.NORTH);
        buttonPanel.add(abortButton, BorderLayout.SOUTH);
        add(buttonPanel, BorderLayout.SOUTH);

    }

    public void setReadyToHarvest() {
        gatherButton.setEnabled(true);
        readyToHarvest = true;
    }

}