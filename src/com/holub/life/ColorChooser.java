package com.holub.life;

import javax.swing.*;
import java.awt.*;

public class ColorChooser {
    public static Color userColorSelected() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JColorChooser chooser = new JColorChooser();
        chooser.setPreviewPanel(new JPanel());

        Container content = frame.getContentPane();
        content.add(chooser, BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);

        return chooser.getColor();
    }

    static class Test {
        public static void main(String[] args) {
            Color color = ColorChooser.userColorSelected();
            System.out.println("Selected " + color);
        }
    }
}
