import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.teamdev.jxmaps.MapViewOptions;

public class CommunityRatingGUI {
	
	public static void main(String[] args) {
		
		/**
		 * Frame set up
		 */
		//Create frame to hold all content
		JFrame frame = new JFrame();
		//set the size to slightly smaller than screen
		frame.setSize(900,700);
		//set title the present at top of window (program title)
		frame.setTitle("My Community Rating");
		frame.getContentPane().setLayout(new BorderLayout());
		//terminate at window closure 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		/**
		 * Panel set up
		 */
		//create panel1 to store address field
		JPanel panelAddress = new JPanel();
		panelAddress.setLayout(new FlowLayout());
		//create panel2 to store score information
		JPanel panelScore = new JPanel();
		panelScore.setLayout(new BoxLayout(panelScore, BoxLayout.PAGE_AXIS));
		//create panelMap to hold map info
        JPanel panelMap = new JPanel();
        panelMap.setLayout(null);
        panelMap.setBounds(0, 0, 700, 650);
		
        /**
         * Panel2 set up
         */
		//create label on panel
		JLabel label = new JLabel("Enter your address here: ");
		JLabel overallLabel = new JLabel("			Overall Rating");
		JLabel schoolLabel = new JLabel("			School Rating");
		JLabel parkingLabel = new JLabel("			Parking Rating");
		JLabel litterLabel = new JLabel("			Litter Rating");
		JLabel crimeLabel = new JLabel("			Crime Rating");
		
		/**
		 * Panel1 set up
		 */
		JTextField textField = new JTextField(10);
		
		/**
		 * panelMap set up
		 */
		//create MapViewOptions with API key to create MapView 
        MapViewOptions options = new MapViewOptions();
        options.importPlaces();
        options.setApiKey(GoogleAPIKey.key);
        
        //create MapView
        Maps mapView = new Maps(options, 0, 0);
        mapView.setBounds(0, 0, 700, 650);
		panelMap.add(mapView, BorderLayout.CENTER);
      		
		/**
		 * ButtonListener
		 */
		//add a button
		JButton button = new JButton("Rate my address!");
		ButtonClickListener add = new ButtonClickListener(label, textField, overallLabel, schoolLabel, parkingLabel, litterLabel, crimeLabel, panelMap);
		button.addActionListener(add);
		
		//add the label and button components to the panel1		
		panelAddress.add(label);
		panelAddress.add(textField);
		panelAddress.add(button);
		
		//create label on panel2
		JLabel label2 = new JLabel("	Community Rating");
		label2.setFont(new Font("Arial", Font.BOLD, 20));
		
		//add the labels to the panel		
		panelScore.add(label2);
		panelScore.add(overallLabel);
		panelScore.add(schoolLabel);
		panelScore.add(parkingLabel);
		panelScore.add(litterLabel);
		panelScore.add(crimeLabel);

		//add panel to the frame
		frame.add(panelAddress, BorderLayout.PAGE_START);
		frame.add(panelScore, BorderLayout.LINE_START);
		frame.add(panelMap, BorderLayout.CENTER);
		frame.setVisible(true);	
		
		
	}

}
