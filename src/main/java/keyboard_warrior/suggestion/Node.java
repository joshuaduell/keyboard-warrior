package keyboard_warrior.suggestion;

import java.util.HashMap;

/**
 * Created by joshua on 12/05/2016.
 */
public class Node
{
    private String description;
    public HashMap<String, Node> transitions; //Stores choices as keys and the nodes they lead to as values

    public Node(String description)
    {
        this.description = description;
        transitions = new HashMap<>();
    }

    public void addTransition(String choice, Node node)
    {
        transitions.put(choice, node);
    }

    public String getDescription()
    {
        return description;
    }

    public void getChoices()
    {
        System.out.println(transitions.keySet()); //Returns all keys as a set, not sure what a set is but it prints...
    }

    public boolean checkWord(String word)
    {
        for(String key : transitions.keySet())
        {
            if(key.equalsIgnoreCase(word))
            {
                return true;
            }
        }

        return false;
    }

    public Node findNode(String word)
    {
        for(String key : transitions.keySet())
        {
            if (key.equalsIgnoreCase(word))
            {
                return transitions.get(key);
            }
        }

        return null;
    }
}
