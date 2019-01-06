package Interface;
import java.awt.*;
import javax.swing.*;
 
@SuppressWarnings("serial")
public class RoundButton extends JButton { //Custom version of the classic JButton shaped into a circle
 
  public RoundButton(String label) {
    super(label);
 
   setBackground(Color.lightGray);
    setFocusable(false); //Prevent a click from selecting the text
 

    Dimension size = getPreferredSize();
    size.width = size.height = Math.max(size.width, size.height);
    setPreferredSize(size);
    setContentAreaFilled(false);//Stop java from coloring the button
  }
 
  protected void paintComponent(Graphics g) {
    if (getModel().isArmed()) {//On-click color change
      g.setColor(Color.orange);
    } else {
      g.setColor(getBackground());
    }
    g.fillOval(0, 0, getSize().width - 1, getSize().height - 1);
    super.paintComponent(g);
  }
 
  protected void paintBorder(Graphics g) {//Main color
    g.setColor(Color.darkGray);
  //  g.drawOval(0, 0, getSize().width - 1, getSize().height - 1);
  
  }
}