import com.teamdev.jxmaps.*;
import com.teamdev.jxmaps.swing.MapView;

import javax.swing.*;
import java.awt.*;

public class Maps extends MapView {
	
	public Maps(MapViewOptions options, LatLng address) {
		super(options);
		// Setting of a ready handler to MapView object. onMapReady will be called when map initialization is done and
        // the map object is ready to use. Current implementation of onMapReady customizes the map object.
        setOnMapReadyHandler(new MapReadyHandler() {
            @Override
            public void onMapReady(MapStatus status) {
                // Check if the map is loaded correctly
                if (status == MapStatus.MAP_STATUS_OK) {
                    // Getting the associated map object
                    final Map map = getMap();
                    
                    map.setZoom(10.0);
                    map.setCenter(address);
                    
                    Marker marker = new Marker(map);
                    marker.setPosition(map.getCenter());
                    final InfoWindow infoWindow = new InfoWindow(map);
                    infoWindow.setContent("Location");
                    infoWindow.open(map, marker);
                }
            }
        });
	}
	
	public static LatLng getCoordinates(String address) {
		MapView mapView = new MapView();
		Map map = mapView.getMap();
		GeocoderRequest request = new GeocoderRequest();
		request.setAddress(address);
		mapView.getServices().getGeocoder().geocode(request, new GeocoderCallback(map) {
			@Override
			public void onComplete(GeocoderResult[] results, GeocoderStatus status) {
				if ((status == GeocoderStatus.OK) && (results.length > 0)) {
					GeocoderResult result = results[0];
					map.setCenter(result.getGeometry().getLocation());
					}
			}});
		return map.getCenter();
	}
	
	
	public static void main(String[] args) {
        MapViewOptions options = new MapViewOptions();

        options.importPlaces();
        options.setApiKey("AIzaSyB3QPLCnP2AMCvlwl8XMr4qJtpN1_-gbYs");
        LatLng address = getCoordinates("2606 South St, Philadelphia, PA");
        Maps mapView = new Maps(options, address);
        
        
        JFrame frame = new JFrame("Test Location");

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.add(mapView, BorderLayout.CENTER);
        frame.setSize(700, 500);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

}
 