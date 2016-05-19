package keyboard_warrior.editor;

import keyboard_warrior.inventory.Item;
import keyboard_warrior.ui.swing.EditorWindow;
import keyboard_warrior.world.Story;
import keyboard_warrior.world.StoryNode;
import keyboard_warrior.world.StoryTransition;

/**
 * Created by bayle on 17/05/2016.
 */
public class Editor
{
    public Editor()
    {
        new EditorWindow();
    }

    public void createStory(String name)
    {
        Story story = new Story(name);
    }

    public void createStoryNode(String name, String description)
    {
        StoryNode node = new StoryNode(name, description);
    }

    public void createStoryTransition(String keyword, int nextNodeId)
    {
        StoryTransition transition = new StoryTransition(keyword, nextNodeId);
    }

    public void createItem(String name, String description)
    {
        Item item = new Item(name, description);
    }


}
