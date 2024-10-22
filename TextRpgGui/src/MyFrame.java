import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame{

    MyFrame(){
        this.setVisible(true);
        this.setSize(800,600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(Color.BLACK);
        this.setLayout(null);
    }
    MyFrame(String title){
        this.setVisible(true);
        this.setSize(800,600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(Color.BLACK);
        this.setTitle(title);
        this.setLayout(null);
    }
}


