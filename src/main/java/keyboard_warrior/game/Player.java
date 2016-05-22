package keyboard_warrior.game;

import keyboard_warrior.inventory.Inventory;

/**
 * Player attributes such as hit points.
 */

public class Player
{
    private int health;
    private Inventory inventory;

    public Player()
    {
        health = 100;
        inventory = new Inventory();
    }

    public int getHealth()
    {
        return health;
    }

    public void setHealth(int health)
    {
        this.health = health;
    }

    public void increaseHealth(int healthIncrease)
    {
        health += healthIncrease;
    }

    public void decreaseHealth(int healthDecrease)
    {
        health -= healthDecrease;
    }

    public Inventory getInventory()
    {
        return inventory;
    }
}
