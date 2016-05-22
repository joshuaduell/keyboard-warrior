package keyboard_warrior.game;

import keyboard_warrior.io.FileManager;
import keyboard_warrior.inventory.Item;
import keyboard_warrior.util.TextReader;
import keyboard_warrior.world.Story;
import keyboard_warrior.world.StoryNode;
import keyboard_warrior.world.StoryTransition;
import java.io.IOException;
import java.util.Scanner;

/**
 * The game.
 */

public class Game
{
    private Player player;
    private Story activeStory;
    private StoryNode currentStoryNode;

	public Game()
    {
        player = new Player();
        activeStory = createMockStory();

        try {
            FileManager.saveStory(activeStory, "test_story.txt");
        } catch (IOException e) {
            print("failed to save story");
            e.printStackTrace();
            System.exit(1);
        }

        try {
            activeStory = FileManager.loadStory("test_story.txt");
        } catch (IOException e) {
            print("failed to load story");
            e.printStackTrace();
            System.exit(1);
        }
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
            else if(input.equalsIgnoreCase("status"))
            {
                printLine("Health: " + player.getHealth());
            }
            else if(currentStoryNode.checkKeyWord(input))
            {
                StoryTransition t = currentStoryNode.getTransition(input);

                if(!t.requiresItems())
                {
                    makeTransition(t);
                }
                else
                {
                    if(t.haveRequiredItems(player.getInventory().getItems()))
                    {
                        makeTransition(t);
                    }
                    else
                    {
                        printLine("You seem to be missing something");
                    }
                }
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
        Item testItem = new Item();
        Item testItem2 = new Item();
        player.getInventory().addItem(testItem);

        StoryNode node1 = new StoryNode();
        node1.setDescription("You start walking along the dimly lit corridor, you can see a small satchel on the ground just ahead");
        node1.setId(1);

        StoryNode node2 = new StoryNode();
        node2.setDescription("As you open the satchel it spews out a noxious gas. You fall to the ground struggling for breath as the poison seeps into your lungs. You journey is over...");
        node2.setId(2);

        StoryNode node3 = new StoryNode();
        node3.setDescription("Wary of the satchels contents you continue walking straight ahead");
        node3.setId(3);

        StoryTransition transition1to2 = new StoryTransition("kick", node2.getId());
        transition1to2.addRequiredItem(testItem);
        transition1to2.addItem(testItem2);
        node1.addTransition(transition1to2);

        StoryTransition transition1to3 = new StoryTransition("punch", node3.getId());
        transition1to3.addRequiredItem(testItem2);
        node2.addTransition(transition1to3);

        story.addNode(node1);
        story.addNode(node2);
        story.addNode(node3);

        story.setStartNodeId(node1.getId());

        return story;
    }

    public void makeTransition(StoryTransition t)
    {
        player.getInventory().getItems().addAll(t.getItems());
        currentStoryNode = activeStory.getNode(t.getNextNodeId());
        printLine(currentStoryNode.getDescription());
    }

}

