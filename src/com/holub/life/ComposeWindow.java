package com.holub.life;

import com.holub.io.Files;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ComposeWindow extends Window {
    String[] operators = {"AND", "OR", "XOR"};
    JLabel lblFileAName, lblFileBName;
    JTextField txtFileAName, txtFileBName;
    JButton btnCompose, btnLoadFileA, btnLoadFileB;
    JComboBox operCombo;
    FileInputStream[] fileInput = new FileInputStream[2];

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
        txtFileAName.setPreferredSize(new Dimension(120,30));
        txtFileAName.setEditable(false);
        btnLoadFileA = new JButton("load");
        btnLoadFileA.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                doLoad(0);
            }
        });
//        btnLoadFileA.setPreferredSize(new Dimension(120,60));

        fileA.add(lblFileAName);
        fileA.add(txtFileA);
        txtFileA.add(txtFileAName);
        fileA.add(btnLoadFileA);
        filePn.add(fileA);

        // file operator 패널
        JPanel fileOperator = new JPanel(new GridLayout(1, 1));
        operCombo = new JComboBox(operators);

        fileOperator.add(operCombo,BorderLayout.CENTER);
        filePn.add(fileOperator,BorderLayout.CENTER);

        // fileB 패널
        JPanel fileB = new JPanel(new FlowLayout());
        JPanel txtFileB = new JPanel(new FlowLayout(FlowLayout.LEFT));
        lblFileBName = new JLabel("파일 이름 :");
        txtFileBName = new JTextField("", 20);
        txtFileBName.setPreferredSize(new Dimension(120,30));
        txtFileBName.setEditable(false);
        btnLoadFileB = new JButton("load");
        btnLoadFileB.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                doLoad(1);
            }
        });
//        btnLoadFileB.setPreferredSize(new Dimension(120,60));

        fileB.add(lblFileBName);
        fileB.add(txtFileB);
        txtFileB.add(txtFileBName);
        fileB.add(btnLoadFileB);
        filePn.add(fileB);

        // Compose 버튼 패널
        btnCompose = new JButton("compose");
        btnCompose.setPreferredSize(new Dimension(120,45));
        btnCompose.setEnabled(false);
        btnCompose.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                doCompose();
            }
        });

        JPanel bottomPn = new JPanel();
        bottomPn.add(btnCompose);
        this.add(bottomPn);

        this.setPreferredSize(new Dimension(300,300));
    }

    private void doLoad(int fileIndex) {
        try {
            // file load
            File userSelectedFile = Files.userSelected(".", ".life", "Life File", "Load");
            FileInputStream in = new FileInputStream(userSelectedFile);

            // print file name
            fileInput[fileIndex] = in;
            if (fileIndex == 0)
                txtFileAName.setText(userSelectedFile.getName());
            else
                txtFileBName.setText(userSelectedFile.getName());

            // compose button 활성화
            for (int i = 0; i < fileInput.length; i++) {
                if (fileInput[i] == null)
                    return;
            }
            btnCompose.setEnabled(true);
        } catch (IOException theException) {
            JOptionPane.showMessageDialog(null, "Read Failed!",
                    "The Game of Life", JOptionPane.ERROR_MESSAGE);
        }
        repaint();
    }

    private void doCompose()
    {
        Universe.instance().doOper(this.fileInput);
    }
//    private void doCompose()
//    {	try
//    {
//        Universe.instance().doOper(this.fileInput);
//
////        in.close();
//    }
//    catch( IOException theException )
//    {	JOptionPane.showMessageDialog( null, "Read Failed!",
//            "The Game of Life", JOptionPane.ERROR_MESSAGE);
//    }
//        repaint();
//    }
}
