package keyboard_warrior.game;

import keyboard_warrior.util.TextReader;
import keyboard_warrior.world.Story;
import keyboard_warrior.world.StoryNode;
import keyboard_warrior.world.StoryTransition;

import java.util.Scanner;

/**
 * The game.
 */
public class Game {

	public Game() {
        Story story = createMockStory();
        StoryNode currentStoryNode = story.getStartNode();

        welcomeMessage();
        printLine();

		Scanner in = new Scanner(System.in);
		String input;

		do {
            print(currentStoryNode.description);

			printLine();
			String separator = TextReader.readTextFile("/separator_1.txt");
			print(separator);

			input = in.next();

            if (input.equalsIgnoreCase("repeat")) {
                printLine();
            }else if (input.equalsIgnoreCase("next")) {
				printLine();
				currentStoryNode = getNextNode(currentStoryNode);
			}else if(!input.equalsIgnoreCase("quit")){
				printLine();
				printLine("What?");
			}
		}while(!input.equalsIgnoreCase("quit"));
	}

	public void welcomeMessage() {
		String welcomeText = TextReader.readTextFile("/welcome_screen.txt");
		print(welcomeText);
        printLine();
		printLine("Welcome to Keyboard Warrior, type 'repeat' or 'next'");
		printLine();
	}

    private void printLine()
    {
        System.out.println();
    }

	private void printLine(String message)
	{
		System.out.println(message);
	}

	private void print(String message)
	{
		System.out.print(message);
	}

    //STORY TESTING
    private Story createMockStory()
    {
        Story story = new Story();

        StoryNode node1 = new StoryNode();
        node1.description = "You are on Tinmeadow Crescent, smoking your last joint";

        StoryNode node2 = new StoryNode();
        node2.description = "Leo Dennis has confronted you wielding an 8th";

        StoryTransition transition1to2 = new StoryTransition(node1, node2);
        node1.addTransition(transition1to2);

        StoryTransition transition2to1 = new StoryTransition(node2, node1);
        node2.addTransition(transition2to1);

        story.setStartNode(node1);

        return story;
    }

    //TODO: Just for testing, assumes there is at least 1 transition
    private StoryNode getNextNode(StoryNode currentStoryNode)
    {
        return currentStoryNode.transitions.get(0).nodeTo;
    }
}

