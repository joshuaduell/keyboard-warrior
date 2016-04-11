package keyboard_warrior.world;


import java.util.ArrayList;

public class StoryNode {

    public ArrayList<StoryTransition> transitions;
    public String description;

    //TODO Change description to filename and load description from files

    public StoryNode() {

        transitions = new ArrayList<StoryTransition>();

    }

    public void addTransition(StoryTransition transition){

        transitions.add(transition);

    }
}
