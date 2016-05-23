package keyboard_warrior.engine.game;

import keyboard_warrior.engine.KBWEngine;
import keyboard_warrior.engine.Scene;
import keyboard_warrior.engine.game.scenes.MasterScene;

public class StoryGame
{
    public static void main(String[] args)
    {
        new KBWEngine(new MasterScene());
    }
}
