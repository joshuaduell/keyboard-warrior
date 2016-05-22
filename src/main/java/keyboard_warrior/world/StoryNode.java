package keyboard_warrior.world;

import java.util.ArrayList;

/**
 * The current point in the story.
 */

public class StoryNode {

    private int id;
    private String name;
    private String description;
    private ArrayList<StoryTransition> transitions;
    //enemies
    //items
    //end of game

    public StoryNode()
    {
        transitions = new ArrayList<>();
    }

    public StoryNode(String name, String description)
    {
        this.name = name;
        this.description = description;
        transitions = new ArrayList<>();
    }

    public int getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public String getDescription()
    {
        return description;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public void addTransition(StoryTransition transition)
    {
        transitions.add(transition);
    }

    public void removeTransition(StoryTransition transition)
    {
        transitions.remove(transition);
    }

    public void removeTransition(int index)
    {
        if(index > 0 && index < transitions.size())
        {
            transitions.remove(index);
        }
    }

    public boolean checkKeyWord(String keyWord)
    {
        for(StoryTransition storyTransition : transitions)
        {
            if(storyTransition.getKeyWord().equalsIgnoreCase(keyWord))
            {
                return true;
            }
        }

        return false;
    }

    public StoryTransition getTransition(String keyWord)
    {
        for(StoryTransition storyTransition : transitions)
        {
            if(storyTransition.getKeyWord().equalsIgnoreCase(keyWord))
            {
                return storyTransition;
            }
        }
        return null;
    }
}
