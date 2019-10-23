package no.hvl.dat100ptc.oppgave2;


import no.hvl.dat100ptc.TODO;
import no.hvl.dat100ptc.oppgave1.GPSPoint;



public class GPSDataConverter {

	// konverter tidsinformasjon i gps data punkt til antall sekunder fra midnatt
	// dvs. ignorer information om dato og omregn tidspunkt til sekunder
	// Eksempel - tidsinformasjon (som String): 2017-08-13T08:52:26.000Z
    // skal omregnes til sekunder (som int): 8 * 60 * 60 + 52 * 60 + 26 
	
	private static int TIME_STARTINDEX = 11; // startindex for tidspunkt i timestr

	public static int toSeconds(String timestr) {
		
		int secs;
		int hr, min, sec;
		
		// TODO
		// OPPGAVE - START
		hr = Integer.parseInt(timestr.substring(11,13)); //ant timer ligg fra index 11 til 13
		min = Integer.parseInt(timestr.substring(14,16)); //ant min ligg fra index 14 til 16
		sec = Integer.parseInt(timestr.substring(17,19)); //ant sec ligg fra index 17 til 19
		
		secs = sec + (min*60) + (hr*3600); //sekund + ant min * 60 + ant tima * 3600 = sekund
		return secs;
		//throw new UnsupportedOperationException(TODO.method());

		// OPPGAVE - SLUTT
		
	}

	public static GPSPoint convert(String timeStr, String latitudeStr, String longitudeStr, String elevationStr) {

		GPSPoint gpspoint;

		// TODO - START ;
		
		
		int time;
		double latitude, longitude, elevation;
		
		//gpspoint = Double.parseDouble(gpspoint);
		
		//longitude = Double.parseDouble(longitudeStr);
		//latitude = Double.parseDouble(latitudeStr);
		//elevation = Double.parseDouble(elevationStr);
		//time = Integer.parseInt(timeStr);
		
		
		latitude = Double.parseDouble(latitudeStr);
		longitude = Double.parseDouble(longitudeStr);
		elevation = Double.parseDouble(elevationStr);
		time = toSeconds(timeStr);
		GPSPoint p = new GPSPoint(time,latitude,longitude,elevation);
		
		
		
		/*funker ikkje:
		 latitude = Double.parseDouble(latitudeStr.substring(25,34));
		longitude = Double.parseDouble(longitudeStr.substring(35,43));
		elevation = Double.parseDouble(elevationStr.substring(36,40));
		elevationStr =  elevationStr.substring(36-40);
		time = toSeconds(timeStr);
		latitude = gpspoint.getLatitude();
		longitude = gpspoint.getLongitude();
		elevation = gpspoint.getElevation();
		*/
		
		
		return p;
		
		
		//throw new UnsupportedOperationException(TODO.method());

		// OPPGAVE - SLUTT ;
	    
	}
	
}
