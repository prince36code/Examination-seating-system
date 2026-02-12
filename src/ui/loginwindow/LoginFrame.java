package src.ui.loginwindow;

import java.awt.*;
import javax.swing.*;
public class LoginFrame  extends JFrame{
    
     public LoginFrame(){
        setTitle("EXAM HALL ALLOCATION");
        setSize(520,530);
        setLayout(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        
        getContentPane().setBackground(new Color(190, 210, 255));
        setLayout(new GridBagLayout());

        add(new LoginPanel());
     }
}
