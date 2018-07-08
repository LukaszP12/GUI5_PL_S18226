/**
 *
*  @author Piwowarski Łukasz S18226
 *
 */

package zad2;
import javax.swing.JFrame;

public class Main {
  public static void main(String ... args) {
  
	  
	  JListDemo mainFrame = new JListDemo();
  
	  mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);      
      mainFrame.pack();
      mainFrame.setLocationByPlatform(true);
      mainFrame.setVisible(true);
	  
  }
} 