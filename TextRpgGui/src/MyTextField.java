import javax.swing.*;
import java.awt.*;

public class MyTextField extends JTextField {
    Font normalFont = new Font("Times New Roman", Font.PLAIN,30);

    MyTextField(){
        this.setBackground(Color.BLACK);
        this.setForeground(Color.white);
        this.setFont(normalFont);
    }
}
