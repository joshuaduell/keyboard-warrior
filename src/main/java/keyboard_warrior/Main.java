package keyboard_warrior;

import keyboard_warrior.editor.Editor;
import keyboard_warrior.game.Game;

/**
 * The main entry point for the game/editor.
 */
public class Main {

    public static void main (String[] args)
    {
        if (args.length == 0)
        {
            usageMessage();
            System.exit(0);
        }

        if (args[0].equalsIgnoreCase("g"))
        {
            new Game();
        }
        else if (args[0].equalsIgnoreCase("e"))
        {
            new Editor();
        }
        else
        {
            usageMessage();
            System.exit(0);
        }
    }

    public static void usageMessage()
    {
        System.out.println("Bad usage, use one of the following arguments \n\n g - Launch Game \n e - Launch Editor");
    }
}
