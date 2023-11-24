package io.github.skippertokozak.lab04.gui.window;

import io.github.skippertokozak.lab04.gui.menu.PanelMenu;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class Window extends JFrame {
    private JPanel contentPane;
    public Window() {
        super("Test");
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        setMinimumSize(new Dimension(400,400));
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        PanelMenu panelMenu = new PanelMenu();
        panelMenu.setVisible(true);
        pack();
        setContentPane(panelMenu);
    }

}
