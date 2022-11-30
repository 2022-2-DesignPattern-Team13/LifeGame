package com.holub.life;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class ComposeWindow extends Window {
    String[] operators = {"AND", "OR", "XOR", "NOT"};
    JLabel lblFileAName, lblFileBName;
    JTextField txtFileAName, txtFileBName;
    JButton btnCompose, btnLoadFileA, btnLoadFileB;
    JComboBox operCombo;

    public ComposeWindow() {
        super("compose window");
        design();
    }

    public void design() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JPanel filePn = new JPanel(new FlowLayout());
        this.add(filePn);

        // fileA 패널
        JPanel fileA = new JPanel(new FlowLayout());;
        JPanel txtFileA = new JPanel(new FlowLayout(FlowLayout.LEFT));
        lblFileAName = new JLabel("파일 이름 :");
        txtFileAName = new JTextField("", 20);
        txtFileAName.setPreferredSize(new Dimension(120,60));
        txtFileAName.setEditable(false);
        btnLoadFileA = new JButton("load");
//        btnLoadFileA.setPreferredSize(new Dimension(120,60));

        fileA.add(lblFileAName);
        fileA.add(txtFileA);
        txtFileA.add(txtFileAName);
        fileA.add(btnLoadFileA);
        filePn.add(fileA);

        // file operator 패널
        JPanel fileOperator = new JPanel(new GridLayout(1, 1));;;
        operCombo = new JComboBox(operators);

        fileOperator.add(operCombo,BorderLayout.CENTER);
        filePn.add(fileOperator,BorderLayout.CENTER);

        // fileB 패널
        JPanel fileB = new JPanel(new FlowLayout());
        JPanel txtFileB = new JPanel(new FlowLayout(FlowLayout.LEFT));
        lblFileBName = new JLabel("파일 이름 :");
        txtFileBName = new JTextField("", 20);
        txtFileBName.setPreferredSize(new Dimension(120,60));
        txtFileBName.setEditable(false);
        btnLoadFileB = new JButton("load");
//        btnLoadFileB.setPreferredSize(new Dimension(120,60));

        fileB.add(lblFileBName);
        fileB.add(txtFileB);
        txtFileB.add(txtFileBName);
        fileB.add(btnLoadFileB);
        filePn.add(fileB);

        // Compose 버튼 패널
        btnCompose = new JButton("compose");
        btnCompose.setPreferredSize(new Dimension(120,60));
        btnCompose.setEnabled(false);

        JPanel bottomPn = new JPanel();
        bottomPn.add(btnCompose);
        this.add(bottomPn);

        this.setPreferredSize(new Dimension(300,300));
    }
}
