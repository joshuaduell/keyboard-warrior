package keyboard_warrior.engine.game.scenes;

import keyboard_warrior.engine.Scene;

public class MasterScene extends Scene
{
    @Override
    protected void onLoad()
    {
        System.out.println("Hello World! I am the master scene.");
        System.out.println("Now go to the menu scene.");

        engine.loadScene(new MenuScene());
    }
}
