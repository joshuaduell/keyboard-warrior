package keyboard_warrior.world;

import java.util.ArrayList;

public class Story {

    private ArrayList<StoryNode> nodes;
    private StoryNode startNode;

    public Story(){

        nodes = new ArrayList<>();
    }

    public StoryNode getStartNode()
    {
        return startNode;
    }

    public void setStartNode(StoryNode node)
    {
        startNode = node;
    }

    public StoryNode getNode(int index)
    {
        return nodes.get(index);
    }

    public void addNode(StoryNode node)
    {
        nodes.add(node);
    }

    public void addNode(StoryNode node, int index)
    {
        nodes.add(index, node);
    }
}
