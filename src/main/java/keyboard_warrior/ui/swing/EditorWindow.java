package keyboard_warrior.ui.swing;

import keyboard_warrior.editor.Editor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by joshua on 19/05/2016.
 */
public class EditorWindow extends JPanel implements ActionListener
{
    private JFrame editorFrame;
    private JButton openButton, saveButton;
    private JFileChooser fileChooser = new JFileChooser();
    private Dimension res = new Dimension(1080, 720);

    public EditorWindow()
    {
        setPreferredSize(res);
        editorFrame = new JFrame("Editor");
        editorFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        editorFrame.add(this);
        JLabel editorLabel = new JLabel("Editor");
        editorLabel.setPreferredSize(new Dimension(res));
        add(editorLabel, BorderLayout.CENTER);
        editorFrame.pack();
        editorFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {

    }
}
