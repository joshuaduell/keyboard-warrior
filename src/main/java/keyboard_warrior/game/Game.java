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

    private Story activeStory;

	public Game() {
        activeStory = createMockStory();
        StoryNode currentStoryNode = null;
        boolean running = true;
        currentStoryNode = activeStory.getStartNode();
        if(currentStoryNode == null)
        {
            print("Start node is null");
            System.exit(1);
        }
        welcomeMessage();
        printLine();

		Scanner in = new Scanner(System.in);
		String input;

        printLine(currentStoryNode.getDescription());

        while(running)
        {
            input = in.next();

            if(input.equalsIgnoreCase("exit"))
            {
                printLine("Goodbye");
                return;
            }
            else if(currentStoryNode.checkKeyWord(input))
            {
                currentStoryNode = activeStory.getNode(currentStoryNode.getTransition(input).getNextNode());
                printLine(currentStoryNode.getDescription());
            }
            else
            {
                printLine("What?");
            }
        }
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
        node1.setDescription("You are on Tinmeadow Crescent, smoking your last joint");
        node1.setId(1);

        StoryNode node2 = new StoryNode();
        node2.setDescription("Leo Dennis has confronted you wielding an 8th");
        node2.setId(2);

        StoryTransition transition1to2 = new StoryTransition("kick", node2.getId());
        node1.addTransition(transition1to2);

        StoryTransition transition2to1 = new StoryTransition("punch", node1.getId());
        node2.addTransition(transition2to1);

        story.addNode(node1);
        story.addNode(node2);

        story.setStartNodeId(node1.getId());

        return story;
    }

}

