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
        items = new ArrayList<>();
        requiredItems = new ArrayList<>();
    }

    public StoryTransition(String keyWord, int nextNodeId)
    {
        this.keyWord = keyWord;
        this.nextNodeId = nextNodeId;
        items = new ArrayList<>();
        requiredItems = new ArrayList<>();
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
        if(requiredItems.size() == 0)
        {
            return false;
        }

        return true;
    }

    public ArrayList getRequiredItems()
    {
        return requiredItems;
    }

    public ArrayList getItems()
    {
        return items;
    }

    public boolean haveRequiredItems(ArrayList inventory)
    {
        for(Item item : requiredItems)
        {
            if(!inventory.contains(item))
            {
                return false;
            }
        }
        return true;
    }
}
