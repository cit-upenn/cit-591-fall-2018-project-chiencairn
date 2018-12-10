import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

//import org.json.JSONException;

import com.teamdev.jxmaps.MapViewOptions;

public class ButtonClickListener implements ActionListener {

	JLabel label;
	JLabel overallLabel;
	JLabel schoolLabel; 
	JLabel parkingLabel;
	JLabel litterLabel;
	JLabel crimeLabel;
	JTextField textField;
	public String address;
	private LitterParser lit;
	private CrimeParser crim;
	private int schoolRating;
	private int parkingRating;
	private int litterRating;
	private int crimeRating;
	private int overallRating;
	JPanel panelMap;
	
	//create a constructor to change components in frame
	ButtonClickListener(JLabel label, JTextField textField, JLabel overallLabel, JLabel schoolLabel, JLabel parkingLabel, JLabel litterLabel, JLabel crimeLabel, JPanel panelMap) {
		this.label=label;
		this.overallLabel = overallLabel;
		this.schoolLabel = schoolLabel;
		this.parkingLabel = parkingLabel;
		this.litterLabel = litterLabel;
		this.crimeLabel = crimeLabel;
		this.textField=textField;
		this.overallLabel = overallLabel;
		this.litterLabel = litterLabel;
		this.panelMap = panelMap;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		//now change the text on the label
		label.setText("Computing Rating");
		address = textField.getText();
		GeocodeAPI geocoder = new GeocodeAPI();
		String jsonResponse;
		double lng = 0;
		double lat = 0;
		try {
			jsonResponse = geocoder.makeAPICall(address);
			GeocodeLocation location = geocoder.parseGeoCodeJSON(jsonResponse);
			lng = location.getLng();
			lat = location.getLat();
			
			//reset map panel
			MapViewOptions options = new MapViewOptions();
	        options.importPlaces();
	        options.setApiKey("AIzaSyB3QPLCnP2AMCvlwl8XMr4qJtpN1_-gbYs");
	        Maps mapView = new Maps(options, lat, lng);
	        mapView.setBounds(0, 0, 700, 500);
	        panelMap.removeAll();
	        panelMap.repaint();
	        panelMap.revalidate();
	        panelMap.setLayout(null);
			panelMap.add(mapView, BorderLayout.CENTER);

	      	
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			lit = new LitterParser("litter_index_survey.csv");
			crim = new CrimeParser("Crime_incidents.csv");
			
			ArrayList<Litter> litter = lit.getLitter();
			ArrayList<Crime> crimes = crim.getCrimes();

			/**
			 * Sample Positions
			 * Fairmount: 39.963296, -75.172907 crimeRating: 81 litterRating: 87
			 * UPenn: 39.953164, -75.194880 crimeRating: 78 litterRating: 92
			 * Kensington: 39.988791, -75.147774 crimeRating: 25 litterRating: 15
			 * Port Richmond: 40.007622, -75.161062 crimeRating: 43 litterRating: 70
			 * Rawnhurst: 40.058409, -75.057235 crimeRating: 96 litterRating: 92
			 */
			DataAnalyzer da = new DataAnalyzer(crimes, litter, lat, lng);
			litterRating = da.getLitterRating();
			crimeRating = da.getCrimeRating();
			//System.out.println(da.getLitterRating());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		litterLabel.setText("			Litter Rating 				= "+litterRating);
		crimeLabel.setText("			Crime Rating 			= "+crimeRating);
		
		PermitBlockReader pbReader = new PermitBlockReader("residential_parking_permit_blocks.csv");
		ArrayList<PermitBlocks> blocks = new ArrayList<PermitBlocks>();
		try {
			blocks = pbReader.readPermitBlockFile();
			//System.out.println(blocks.size());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		SchoolReader sReader = new SchoolReader("schools.csv", "2012_2013_SPR_20140428.csv");
		ArrayList<School> schools = new ArrayList<School>();
		try {
			schools = sReader.readSchoolFile();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		SchoolsAnalyzer schoolAnalysis = new SchoolsAnalyzer(schools, lat, lng);
		PermitBlocksAnalyzer blockAnalysis = new PermitBlocksAnalyzer(blocks, lat, lng);
		
		schoolRating = (int)schoolAnalysis.getSchoolScore();
		parkingRating = (int)blockAnalysis.getParkingScore();
		schoolLabel.setText("			School Rating 		= "+schoolRating);
		parkingLabel.setText("			Parking Rating 	= "+parkingRating);
		
		overallRating = (schoolRating+parkingRating+litterRating+crimeRating)/4;
		overallLabel.setText("			Overall Rating 		= "+overallRating);
	}	
	
}