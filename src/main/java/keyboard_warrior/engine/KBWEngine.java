package keyboard_warrior.engine;

import javax.swing.*;

public class KBWEngine
{
    private JFrame frame;
    private Canvas canvas;
    private Scene scene;
    private Renderer renderer;

    public KBWEngine(Scene scene)
    {
        frame = new JFrame("KBW");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(600, 600);

        canvas = new Canvas(this);
        new Application(this, frame, canvas);

        loadScene(scene);

        renderer = new Renderer(this);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public void loadScene(Scene scene)
    {
        this.scene = scene;
        scene.Load(this);
    }

    public JFrame getFrame()
    {
        return frame;
    }

    public Canvas getCanvas()
    {
        return canvas;
    }

    public Scene getScene()
    {
        return scene;
    }

    public Renderer getRenderer()
    {
        return renderer;
    }
}
