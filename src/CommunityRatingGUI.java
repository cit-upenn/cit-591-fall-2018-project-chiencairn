import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import com.teamdev.jxmaps.LatLng;
import com.teamdev.jxmaps.MapViewOptions;

public class CommunityRatingGUI {
	
	public static void main(String[] args) {
		
		//Add frame
		JFrame frame = new JFrame();
		//set the size to slightly smaller than screen
		frame.setSize(1000,700);
		//set title the present at top of window (program title)
		frame.setTitle("My Community Rating");
		//terminate at window closure 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//create panel to eventually place on frame
		JPanel panel1 = new JPanel();
		panel1.setLayout(new FlowLayout());
		
		//create label on panel
		JLabel label = new JLabel("Enter your address here: ");
		JLabel overallLabel = new JLabel("			Overall Rating");
		JLabel schoolLabel = new JLabel("			School Rating");
		JLabel parkingLabel = new JLabel("			Parking Rating");
		JLabel litterLabel = new JLabel("			Litter Rating");
		JLabel crimeLabel = new JLabel("			Crime Rating");
		
		JTextField textField = new JTextField(10);
		
		
		//add a button
		JButton button = new JButton("Rate my address!");
		ButtonClickListener add = new ButtonClickListener(label, textField, overallLabel, schoolLabel, parkingLabel, litterLabel, crimeLabel);
		button.addActionListener(add);
		
		//add the label and button components to the panel		
		panel1.add(label);
		panel1.add(textField);
		panel1.add(button); 
		frame.add(panel1, "North");
		
		//create panel to eventually place on frame
		JPanel panel2 = new JPanel();
		panel2.setLayout(new BoxLayout(panel2, BoxLayout.PAGE_AXIS));
		
		//create label on panel2
		JLabel label2 = new JLabel("	Community Rating");
		label2.setFont(new Font("Arial", Font.BOLD, 20));
		
		//add the labels to the panel		
		panel2.add(label2);
		panel2.add(overallLabel);
		panel2.add(schoolLabel);
		panel2.add(parkingLabel);
		panel2.add(litterLabel);
		panel2.add(crimeLabel);

		//add panel to the frame

		frame.add(panel2, "Center");
		frame.setVisible(true);	
		
		//create panel to eventually place on frame
		JPanel panelMap = new JPanel();

		//add panel to the frame
		frame.add(panelMap, "East");
		frame.setVisible(true);	

	}

}
