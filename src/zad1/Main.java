/**
 *
 *  @author Piwowarski Łukasz S18226
 *
 */

package zad1;
import javax.swing.JFrame;

public class Main {
  public static void main(String ... args) {
  
	  // utworzenie instancji okna głównego aplikacji
	  CelsiusFahrenheitJList mainFrame = new CelsiusFahrenheitJList();
	  
	  mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);      
      mainFrame.pack();
      mainFrame.setLocationByPlatform(true);
	  mainFrame.setVisible(true);
	  

	  
  }
}