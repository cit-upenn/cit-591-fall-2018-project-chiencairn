import com.teamdev.jxmaps.*;
import com.teamdev.jxmaps.swing.MapView;

import javax.swing.*;
import java.awt.*;

/**
 * Maps class to pull up a view of a Map based on set coordinates
 * @author michellechien
 *
 */

public class Maps extends MapView {
	
	private static final long serialVersionUID = 1L;

	public Maps(MapViewOptions options, double lat, double lng) {
		super(options);
        setOnMapReadyHandler(new MapReadyHandler() {
            @Override
            public void onMapReady(MapStatus status) {
                // Check if the map is loaded correctly
                if (status == MapStatus.MAP_STATUS_OK) {
                    // Getting the associated map object
                    final Map map = getMap();
                    
                    map.setZoom(10.0);
                    
                    //Pull up MapView with Marker if coordinates are set valid
                    if (lat != 0 && lng != 0) {
            			map.setCenter(new LatLng(lat, lng));
            			Marker marker = new Marker(map);
                        marker.setPosition(map.getCenter());
            		} else {// if coordinates aren't valid, center map around generic philly location
            			map.setCenter(new LatLng(39.952583, -75.165222));
            		}
                    
                }
            }
        });
	}
	
	// testers
	public static void main(String[] args) {
        MapViewOptions options = new MapViewOptions();
        options.importPlaces();
        options.setApiKey(GoogleAPIKey.key);
        
        Maps mapView = new Maps(options, 0, 0);
        mapView.setBounds(0, 0, 700, 500);
        
        
        JFrame frame = new JFrame("Test Location");

        JPanel panelMap = new JPanel();
        panelMap.setLayout(null);
        
		panelMap.add(mapView, BorderLayout.CENTER);

		//add panel to the frame
		frame.add(panelMap);
		frame.setVisible(true);	
        
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //frame.add(mapView, BorderLayout.CENTER);
        frame.setSize(700, 500);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

}
 