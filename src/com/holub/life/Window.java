package com.holub.life;

import javax.swing.*;

public class Window extends JPanel {
    public Window(String title) {

        JFrame frame=new JFrame(title);
        frame.getContentPane().add(this);//JFrame+JPanel(화면디자인)
        frame.setBounds(200,300,430,450);//x,y,w,h
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//X버튼 클릭시 종료

//        super(title);
//        this.setSize(500, 500);
//        this.setLocationRelativeTo(null);
//        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
//        this.setVisible(true);
    }
}
