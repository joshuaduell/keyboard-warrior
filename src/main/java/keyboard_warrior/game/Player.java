package keyboard_warrior.game;

import keyboard_warrior.inventory.Item;

import java.util.ArrayList;

public class Player
{
    private ArrayList<Item> inventory;

    public Player()
    {
        inventory = new ArrayList<>();
    }

    public void addItem(Item item)
    {
        inventory.add(item);
    }

    public void removeItem(Item item)
    {
        inventory.remove(item);
    }

    public ArrayList getInventory()
    {
        return inventory;
    }
}
