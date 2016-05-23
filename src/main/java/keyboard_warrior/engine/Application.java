package keyboard_warrior.engine;

import javax.swing.*;

public class Application
{
    private static KBWEngine engine;
    private static JFrame frame;
    private static Canvas canvas;

    public Application(KBWEngine engine, JFrame frame, Canvas canvas)
    {
        this.engine = engine;
        this.frame = frame;
        this.canvas = canvas;
    }

    public static KBWEngine getEngine()
    {
        return engine;
    }

    public static JFrame getFrame()
    {
        return frame;
    }

    public static Canvas getCanvas()
    {
        return canvas;
    }
}
