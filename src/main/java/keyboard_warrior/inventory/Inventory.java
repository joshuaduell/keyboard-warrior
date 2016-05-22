package keyboard_warrior.inventory;

import java.util.ArrayList;

/**
 * Stores items that the player has collected.
 */

public class Inventory
{
    private ArrayList<Item> items;
    private ArrayList<Consumable> consumables;
    private ArrayList<Weapon> weapons;

    public Inventory()
    {
        items = new ArrayList<>();
        consumables = new ArrayList<>();
        weapons = new ArrayList<>();
    }

    public ArrayList<Item> getItems()
    {
        return items;
    }

    public ArrayList<Consumable> getConsumables()
    {
        return consumables;
    }

    public ArrayList<Weapon> getWeapons()
    {
        return weapons;
    }

    public void addItem(Item item)
    {
        items.add(item);
    }

    public void removeItem(Item item)
    {
        items.remove(item);
    }

    public void addConsumable(Consumable consumable)
    {

    }
}
