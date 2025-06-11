import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TaskListPanel extends JPanel {

    // ----- properties ------------------------------------------------------------------------------------------------

    // screen properties
    final int tileSize = 16;
    final int scale = 3;
    final int maxScreenColumns = 16;
    final int maxScreenRows = 12;
    final int screenWidth = tileSize * maxScreenColumns * scale;
    final int screenHeight = tileSize * maxScreenRows * scale;

    //essentials
    DefaultListModel<String[]> listModel;
    HashMap<TaskWrapper, String[]> activeListElements;


    // ----- constructor -----------------------------------------------------------------------------------------------

    public TaskListPanel(SpritesHandler spritesHandler) {

        // list elements
        activeListElements = new HashMap<>();

        setPreferredSize(new Dimension(screenWidth + screenWidth / 2, screenHeight / 3));
        setLayout(new BorderLayout());
        setBackground(spritesHandler.backgroundColor);
        setBorder(BorderFactory.createLineBorder(spritesHandler.borderColor, 3));

        // headers
        JPanel headerPanel = getHeaderPanel(spritesHandler);

        // jList
        listModel = new DefaultListModel<>();
        JList<String[]> jList = getjList(spritesHandler);

        JPanel taskListPanel = new JPanel(new BorderLayout());
        taskListPanel.add(headerPanel, BorderLayout.NORTH);
        taskListPanel.add(new JScrollPane(jList), BorderLayout.CENTER);
        add(taskListPanel);
        setVisible(true);
    }


    // ----- creating components ---------------------------------------------------------------------------------------

    // header panel
    private static JPanel getHeaderPanel(SpritesHandler spritesHandler) {
        JPanel headerPanel = new JPanel(new GridLayout(1, 3));
        headerPanel.setBackground(spritesHandler.backgroundColor);

        JLabel headerTask =  new JLabel("task", SwingConstants.CENTER);
        headerTask.setFont(spritesHandler.minecraftiaFont);
        headerTask.setForeground(spritesHandler.labelColor);
        headerPanel.add(headerTask);

        JLabel headerState = new JLabel("state", SwingConstants.CENTER);
        headerState.setFont(spritesHandler.minecraftiaFont);
        headerState.setForeground(spritesHandler.labelColor);
        headerPanel.add(headerState);

        JLabel headerResult = new JLabel("result", SwingConstants.CENTER);
        headerResult.setFont(spritesHandler.minecraftiaFont);
        headerResult.setForeground(spritesHandler.labelColor);
        headerPanel.add(headerResult);
        return headerPanel;
    }

    // jList
    private JList<String[]> getjList(SpritesHandler spritesHandler) {
        JList<String[]>jList = new JList<>(listModel);

        jList.setCellRenderer((renderedList, value, index, isSelected, cellHasFocus) -> { // GUI magic

            JPanel panel = new JPanel(new GridLayout(1, 3));
            JLabel col1 = new JLabel(value[0]);
            JLabel col2 = new JLabel(value[1]);
            JLabel col3 = new JLabel(value[2]);

            panel.add(col1);
            panel.add(col2);
            panel.add(col3);

            panel.setBackground(spritesHandler.backgroundColor);

            col1.setFont(spritesHandler.minecraftiaFont);
            col2.setFont(spritesHandler.minecraftiaFont);
            col3.setFont(spritesHandler.minecraftiaFont);

            if (isSelected) {
                col1.setForeground(spritesHandler.borderColor);
                col2.setForeground(spritesHandler.borderColor);
                col3.setForeground(spritesHandler.borderColor);
            } else {
                col1.setForeground(spritesHandler.labelColor);
                col2.setForeground(spritesHandler.labelColor);
                col3.setForeground(spritesHandler.labelColor);
            }
            panel.setOpaque(true);
            return panel;
        });

        jList.setBackground(spritesHandler.backgroundColor);
        jList.setFocusable(false);
        return jList;
    }


    // ----- adding tasks ----------------------------------------------------------------------------------------------

    public void add(TaskWrapper taskWrapper) {
        String[] element = new String[3]; // used array just because internet told me to do so, tho it kinda hurts
        // guessing that it's good for efficiency, maybe changing that

        // getting values
        element[0] = taskWrapper.getName();
        element[1] = taskWrapper.getState();
        element[2] = taskWrapper.getResult();

        // adding values
        activeListElements.put(taskWrapper, element);
        listModel.addElement(element);

    }


    // ----- updating --------------------------------------------------------------------------------------------------

    public void update() {
        ArrayList<TaskWrapper> keysToRemove = new ArrayList<>();

        for (Map.Entry<TaskWrapper, String[]> entry : activeListElements.entrySet()) {
            TaskWrapper taskWrapper = entry.getKey();
            String[] element = entry.getValue();

            // get current values
            String currentState = taskWrapper.getState();
            String currentResult = taskWrapper.getResult();

            // check for updates
            boolean updated = false;
            if (!element[1].equals(currentState)) {
                element[1] = currentState;
                updated = true;
            }
            if (!element[2].equals(currentResult)) {
                element[2] = currentResult;
                updated = true;
            }

            // update values
            if (updated) {
                int index = listModel.indexOf(element);
                if (index != -1) {
                    listModel.set(index, element);
                }
                keysToRemove.add(taskWrapper);
            }
        }

        // remove keys after iteration
        for (TaskWrapper key : keysToRemove) {
            activeListElements.remove(key);
        }
    }

}