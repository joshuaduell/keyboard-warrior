package keyboard_warrior.engine;

public abstract class Scene
{
    protected KBWEngine engine;

    public Scene()
    {

    }

    public void Load(KBWEngine engine)
    {
        this.engine = engine;
        onLoad();
    }

    protected void onLoad() {};
}
