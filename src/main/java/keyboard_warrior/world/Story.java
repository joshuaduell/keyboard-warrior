package keyboard_warrior.world;

import java.util.ArrayList;

public class Story {

    public ArrayList<StoryNode> nodes;
    public StoryNode firstNode;

    public Story(){

        nodes = new ArrayList<StoryNode>();

        firstNode = new StoryNode();

        firstNode.description = "You are on Tinmeadow Crescent";

        StoryNode secondNode = new StoryNode();

        secondNode.description = "Leo Dennis has confronted you";

        StoryTransition transition1to2 = new StoryTransition(firstNode, secondNode);

        firstNode.addTransition(transition1to2);

    }

}
