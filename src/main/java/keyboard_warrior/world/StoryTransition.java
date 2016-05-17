package keyboard_warrior.world;

public class StoryTransition {

    private String keyWord;
    private int nextNodeId;

    public StoryTransition()
    {

    }

    public StoryTransition(String keyWord, int nextNodeId)
    {
        this.keyWord = keyWord;
        this.nextNodeId = nextNodeId;
    }

    public String getKeyWord()
    {
        return keyWord;
    }

    public int getNextNode()
    {
        return nextNodeId;
    }

    public void setKeyWordId(String keyWord)
    {
        this.keyWord = keyWord;
    }

    public void setNextNodeId(int nextNode)
    {
        this.nextNodeId = nextNode;
    }
}
