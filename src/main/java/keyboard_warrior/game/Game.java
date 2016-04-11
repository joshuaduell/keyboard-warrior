package keyboard_warrior.game;

import keyboard_warrior.inventory.Item;
import keyboard_warrior.util.TextReader;
import keyboard_warrior.world.Story;

import java.util.Scanner;

/**
 * The game.
 */
public class Game {

	public Game() {
        Story testStory = new Story();

        welcomeMessage();

		Scanner in = new Scanner(System.in);
		String input;

		put(testStory.firstNode.description);
		putLine();

		do {
			//always start with a blank line and a separator
			putLine();
			String separator = TextReader.readTextFile("/separator_1.txt");
			put(separator);

			input = in.next();

			if (input.equalsIgnoreCase("next")) {
				putLine();
				put(testStory.firstNode.transitions.get(0).nodeTo.description);
			}else if(!input.equalsIgnoreCase("quit")){
				putLine();
				putLine("What?");
			}
		}while(!input.equalsIgnoreCase("quit"));
	}

	public void welcomeMessage() {
		String welcomeText = TextReader.readTextFile("/welcome_screen.txt");
		put(welcomeText);
        putLine();
		putLine("Welcome to Keyboard Warrior");
		putLine();
	}

    public void putLine()
    {
        System.out.println();
    }

	public void putLine(String message)
	{
		System.out.println(message);
	}

	public void put(String message)
	{
		System.out.print(message);
	}
}

