package keyboard_warrior.game;

import keyboard_warrior.inventory.Item;
import keyboard_warrior.util.TextReader;
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
		map.setLocation(9,0); //TODO: Shouldn't the map have a starting location?

		do {
			//always start with a blank line and a separator
			putLine();
			String separator = TextReader.readTextFile("/separator_1.txt");
			put(separator);

			input = in.next();

			//TODO: Since we may have many commands its probably worth handling them in a different class
			if(input.equalsIgnoreCase("north")
					|| input.equalsIgnoreCase("south")
					|| input.equalsIgnoreCase("east")
					|| input.equalsIgnoreCase("west")) {
				putLine();
				map.move(input);
			}else if (input.equalsIgnoreCase("help")) {
				putLine();
				help();
			}else if (input.equalsIgnoreCase("look")) {
				putLine();
				look(map.getCurrentLocation());
			}else if (input.equalsIgnoreCase("bag")) {
				putLine();
				bag(inventory);
			}else if(!input.equalsIgnoreCase("quit")){
				putLine();
				putLine("What?");
			}
		}while(!input.equalsIgnoreCase("quit"));
	}

	public void welcomeMessage() {
		String welcomeText = TextReader.readTextFile("/welcome_screen.txt");
		//TODO: Note to Duell:
		/*
			I had to change this to use print over println, we didn't see difference in the console but when I
			ran it with cmd the lines wouldn't wrap properly. I believe println strips any newline characters
			and adds one to the end.
		 */
		put(welcomeText);
		putLine("Welcome to Keyboard Warrior");
		putLine();
		help();
		putLine();
	}

	public void help() {
		putLine("HELP");
		putLine("Type one of the following commands to interact with the world");
		putLine("'north', 'south', 'east' or 'west' to move");
		putLine("'look' to describe the surroundings.");
		putLine("'bag' to see your inventory.");
		putLine("'quit' to exit the game.");
		putLine("'help' to see this message again.");
	}

	public void start() {
		putLine("You pull yourself out of the river... the jungle air is so thick with moisture it barely feels like you left it. ");
		putLine();
	}

	public void look(Location currentLocation) {
		System.out.println(currentLocation.getDescription());
	}

	public void bag(Item[] container) {
		putLine("You look in your bag.");
		putLine();

		for (int i = 0; i < container.length; i++)
		{
			putLine("[" + i + "]" + ": " + container[i]);
		}
	}

	public void putLine(String message)
	{
		System.out.println(message);
	}

	public void putLine()
	{
		System.out.println();
	}

	public void put(String message)
	{
		System.out.print(message);
	}
}

