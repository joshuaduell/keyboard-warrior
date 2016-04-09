package keyboard_warrior.game;

import keyboard_warrior.inventory.Item;
import keyboard_warrior.io.TextReader;
import keyboard_warrior.world.Location;
import keyboard_warrior.world.Map;

import java.util.Scanner;

/**
 * The game.
 */
public class Game {

	public Game() {
		Scanner in = new Scanner(System.in);
		Map map = new Map();
		Item[] inventory = new Item[5];
		String input;

		welcomeMessage();
		start();
		//set start location
		map.setLocation(9,0);

		do {
			//always start with a blank line
			System.out.println();
			input = in.next();

			if(input.equalsIgnoreCase("north")
					|| input.equalsIgnoreCase("south")
					|| input.equalsIgnoreCase("east")
					|| input.equalsIgnoreCase("west")) {

				map.move(input);
			}else if (input.equalsIgnoreCase("help")) {
				help();
			}else if (input.equalsIgnoreCase("look")) {
				look(map.getCurrentLocation());
			}else if (input.equalsIgnoreCase("bag")) {
				bag(inventory);
			}else if(!input.equalsIgnoreCase("quit")){
				System.out.println("What?");
			}
		}while(!input.equalsIgnoreCase("quit"));
	}

	public void welcomeMessage() {
//		System.out.println("Welcome to Keyboard Warrior");
//		System.out.println();
//		help();
//		System.out.println();

		String welcomeText = TextReader.readTextFile("res/welcome_screen.txt");
		System.out.println(welcomeText);
	}

	public void help() {
		System.out.println("HELP");
		System.out.println("Type one of the following commands to interact with the world");
		System.out.println("'north', 'south', 'east' or 'west' to move");
		System.out.println("'look' to describe the surroundings.");
		System.out.println("'bag' to see your inventory.");
		System.out.println("'quit' to exit the game.");
		System.out.println("'help' to see this message again.");
	}

	public void start() {
		System.out.println("You pull yourself out of the river... the jungle air is so thick with moisture it barely feels like you left it. ");
		System.out.println();
	}

	public void look(Location currentLocation) {
		System.out.println(currentLocation.getDescription());
	}

	public void bag(Item[] container) {
		System.out.println("You look in your bag.");
		System.out.println();

		for (int i = 0; i < container.length; i++)
		{
			System.out.println("[" + i + "]" + ": " + container[i]);
		}
	}
}

