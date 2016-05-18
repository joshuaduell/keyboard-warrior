package keyboard_warrior.world;

import keyboard_warrior.inventory.Item;

import java.util.ArrayList;

public class StoryTransition {

    private String keyWord;
    private int nextNodeId;
    private ArrayList<Item> items;
    private ArrayList<Item> requiredItems;


    public StoryTransition()
    {

    }

    public StoryTransition(String keyWord, int nextNodeId)
    {
        this.keyWord = keyWord;
        this.nextNodeId = nextNodeId;
    }

    public String getKeyWord()
    {
        return keyWord;
    }

    public int getNextNodeId()
    {
        return nextNodeId;
    }

    public void setKeyWordId(String keyWord)
    {
        this.keyWord = keyWord;
    }

    public void setNextNodeId(int nextNode)
    {
        this.nextNodeId = nextNode;
    }

    public void addItem(Item item)
    {
        items.add(item);
    }

    public void addRequiredItem(Item requiredItem)
    {
        requiredItems.add(requiredItem);
    }

    public boolean requiresItems()
    {
        if(requiredItems == null)
        {
            return false;
        }

        return true;
    }
}
