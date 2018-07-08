package zad1;

import java.awt.BorderLayout;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class CelsiusFahrenheitJList extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private	JPanel						topPanel;
	private	JList<String>				listbox;
	
	
	public CelsiusFahrenheitJList() {	
		setTitle("Celsius to Fahrenheit JList");
		
		topPanel = new JPanel();
		topPanel.setLayout( new BorderLayout() );
		getContentPane().add( topPanel );
						
		listbox = new JList<String>();
		listbox.setModel(CreateListModel(-70, 60));
		
		topPanel.add(new JScrollPane(listbox));
		
	}


	private DefaultListModel<String> CreateListModel(double minTemp, double maxTemp) {
		
		DefaultListModel<String> 	listModel;
		
		listModel = new DefaultListModel<String>();
		
		for(int a=(int) minTemp; a<=maxTemp; a++) {
			listModel.addElement(a+" stopni C = "+String.format("%1$,.2f", CelsiusToFahrenheitConverter.convertCelsiusToFahrenheit(a))+" stopni F");	
		}

		return listModel;
	}
	
	
}
