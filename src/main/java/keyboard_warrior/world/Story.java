package keyboard_warrior.world;

import java.util.ArrayList;

public class Story {

    private ArrayList<StoryNode> nodes;
    private int startNodeId;

    public Story(){

        nodes = new ArrayList<>();
    }

    public StoryNode getNode(int nodeId)
    {
        for(StoryNode node : nodes)
        {
            if(node.getId() == nodeId)
            {
                return node;
            }
        }
        return null;
    }

    public StoryNode getStartNode()
    {
        return getNode(startNodeId);
    }

    public void setStartNodeId(int nodeId)
    {
        startNodeId = nodeId;
    }

//    public StoryNode getNode(int index)
//    {
//        return nodes.get(index);
//    }

    public void addNode(StoryNode node)
    {
        if(!(nodes.contains(node)))
        {
            nodes.add(node);
        }
    }

    public void addNode(StoryNode node, int index)
    {
        nodes.add(index, node);
    }
}
