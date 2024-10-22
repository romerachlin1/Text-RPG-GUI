import javax.swing.*;
import java.awt.*;

public class MyButton extends JButton {
    Font normalFont = new Font("Times New Roman", Font.PLAIN,25);

    MyButton(String text){
        this.setText(text);
        this.setBackground(Color.BLACK);
        this.setForeground(Color.white);
        this.setFont(normalFont);
        this.setFocusPainted(false);
//        this.setVerticalAlignment(JButton.CENTER);
//        this.setHorizontalAlignment(JButton.CENTER);
    }

    MyButton(String text, int x, int y, int width, int height){
        this.setBackground(Color.BLACK);
        this.setText(text);
        this.setForeground(Color.white);
        this.setFont(normalFont);
        this.setBounds(x,y, width, height);
        this.setFocusPainted(false);

    }
}
