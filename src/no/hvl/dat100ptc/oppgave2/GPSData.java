package no.hvl.dat100ptc.oppgave2;


import no.hvl.dat100ptc.TODO;
import no.hvl.dat100ptc.oppgave1.GPSPoint;

public class GPSData {

	private GPSPoint[] gpspoints;
	protected int antall = 0;

	public GPSData(int antall) {

		// TODO - START
		this.antall = 0;
		this.gpspoints = new GPSPoint[antall];
		
		//throw new UnsupportedOperationException(TODO.construtor("GPSData"));

		// TODO - SLUTT
	}

	public GPSPoint[] getGPSPoints() {
		return this.gpspoints;
	}
	
	protected boolean insertGPS(GPSPoint gpspoint) {

		boolean inserted = false;

		// TODO - START
		if(antall<gpspoints.length) {
			gpspoints[antall] = gpspoint;
			antall++;
			inserted = true;
			
		}
		return inserted;
		//throw new UnsupportedOperationException(TODO.method());

		// TODO - SLUTT
	}

	public boolean insert(String time, String latitude, String longitude, String elevation) {

		GPSPoint gpspoint;

		// TODO - START
		
		int t;
		int hr,min,sec;
		double lat,lon,ele;
		hr = Integer.parseInt(time.substring(11,13));
		min = Integer.parseInt(time.substring(14,16));
		sec = Integer.parseInt(time.substring(17,19));
		t = (hr*60*60) + (min*60) + sec;
		lat = Double.parseDouble(latitude.substring(0,3));
		lon = Double.parseDouble(longitude.substring(0,3));
		ele = Double.parseDouble(elevation.substring(0,3));
		
		
		GPSPoint po = new GPSPoint(t,lat,lon,ele);
		boolean sa = insertGPS(po);
		return sa;
		
		
		//throw new UnsupportedOperationException(TODO.method());

		// TODO - SLUTT
		
	}

	public void print() {

		System.out.println("====== Konvertert GPS Data - START ======");

		// TODO - START
		for(GPSPoint a :  gpspoints) {
			System.out.print(a.toString());
			
		}

		//throw new UnsupportedOperationException(TODO.method());

		// TODO - SLUTT
		
		 System.out.println("====== Konvertert GPS Data - SLUTT ======");

	}
}
