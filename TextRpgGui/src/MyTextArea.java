import javax.swing.*;
import java.awt.*;

public class MyTextArea extends JTextArea {
    Font normalFont = new Font("Times New Roman", Font.PLAIN,30);

    MyTextArea(String text, int x, int y, int width, int height){
        this.setBounds(x,y,width,height);
        this.setBackground(Color.BLACK);
        this.setForeground(Color.white);
        this.setFont(normalFont);
        this.setText(text);
        this.setLineWrap(true);
        this.setHighlighter(null);
        this.setEditable(false);

    }

}
