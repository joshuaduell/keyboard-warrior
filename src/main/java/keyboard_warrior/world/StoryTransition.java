package keyboard_warrior.world;

public class StoryTransition {

    public StoryNode nodeTo;
    public StoryNode nodeFrom;

    public StoryTransition(StoryNode nodeFrom, StoryNode nodeTo) {

        this.nodeTo = nodeTo;
        this.nodeFrom = nodeFrom;

    }
}
