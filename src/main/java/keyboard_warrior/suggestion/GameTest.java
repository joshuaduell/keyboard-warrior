package keyboard_warrior.suggestion;
import java.util.Scanner;

public class GameTest
{
    private Scanner in;
    private boolean playing = true;
    private Node currentNode;

    public GameTest()
    {
        in = new Scanner(System.in);
        createNodes();
        welcomeMessage();
        play();
    }

    public void welcomeMessage()
    {
        System.out.println("Welcome to the manor");
    }

    public void play()
    {
        String input;

        while(playing)
        {
            System.out.println(currentNode.getDescription());
            currentNode.getChoices();

            input = in.next();

            if(input.equals("exit"))
            {
                System.out.println("Goodbye");
                playing = false;
            }
            else
            {
                if(!(currentNode.checkWord(input))) //First checks to see if the word is stored as a key in the HashMap
                {
                    System.out.println("What?");
                }
                else
                {
                    currentNode = currentNode.findNode(input); //Changes the node to the node associated with the input
                }
            }

        }
    }

    public void createNodes()
    {
        Node node1 = new Node("You are standing on Tinmeadow Crescent smoking a joint. Leo Dennis approaches and offers to sell you a ten.");
        Node node2 = new Node("You catch him with a swift hook, knocking him out. You take the ten from him.");
        Node node3 = new Node("Your kick is too slow, he grabs your leg and throws you to the ground. He mutters, bumbaclart and walks away. You have lost 10hp.");

        node1.addTransition("Punch", node2);
        node1.addTransition("Kick", node3);

        currentNode = node1;
    }

}
