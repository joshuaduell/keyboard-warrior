package keyboard_warrior.suggestion;
import com.google.gson.Gson;
import keyboard_warrior.util.TextReader;

import java.util.Scanner;

public class GameTest
{
    private Scanner in;
    private boolean playing = true;
    private Node currentNode;

    public GameTest()
    {
        in = new Scanner(System.in);
        //createNodes();
        currentNode = loadNode();
        System.out.println(currentNode.transitions.size());
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

            input = in.nextLine();

            if(input.equals("exit"))
            {
                System.out.println("Goodbye");
                playing = false;
            }
            else if(currentNode.checkWord(input))
            {
                currentNode = currentNode.findNode(input); //Changes the node to the node associated with the input
            }
            else
            {
                System.out.println("What?");
            }


        }
    }

    public void saveNode()
    {
        Gson serialiser = new Gson();

        String json = serialiser.toJson(currentNode);

        System.out.print(json);
    }

    public Node loadNode()
    {
        String json = TextReader.readTextFile("/json");

        Gson deserialiser = new Gson();

        return deserialiser.fromJson(json, Node.class);
    }

    public void createNodes()
    {
        Node node1 = new Node("You are standing on Tinmeadow Crescent smoking a joint. Leo Dennis approaches and offers to sell you a ten.");
        Node node2 = new Node("You catch him with a swift hook, knocking him out. You take the ten from him.");
        Node node3 = new Node("Your kick is too slow, he grabs your leg and throws you to the ground. He mutters, bumbaclart and walks away. You have lost 10hp.");

        node1.addTransition("Attempt to punch him", node2);
        node1.addTransition("Kick", node3);

        currentNode = node1;
    }

}
