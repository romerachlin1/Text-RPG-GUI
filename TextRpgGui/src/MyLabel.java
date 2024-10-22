import javax.swing.*;
import java.awt.*;

public class MyLabel extends JLabel {
    Font normalFont = new Font("Times New Roman", Font.PLAIN,25);

     MyLabel(String text){
         this.setBackground(Color.BLACK);
       this.setText(text);
       this.setForeground(Color.white);
       this.setFont(normalFont);
//       this.setVerticalAlignment(JLabel.CENTER);
//       this.setHorizontalAlignment(JLabel.CENTER);
   }

   MyLabel(String text, int x, int y, int width, int height){
       this.setBackground(Color.BLACK);
       this.setText(text);
       this.setForeground(Color.white);
       this.setFont(normalFont);
       this.setBounds(x, y, width, height);
   }
}
