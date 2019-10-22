package no.hvl.dat100ptc.oppgave3;

import static java.lang.Math.*;

import no.hvl.dat100ptc.TODO;
import no.hvl.dat100ptc.oppgave1.GPSPoint;

public class GPSUtils {

	public static double findMax(double[] da) {

		double max; 
		
		max = da[0];
		
		for (double d : da) {
			if (d > max) {
				max = d;
			}
		}
		
		return max;
	}

	public static double findMin(double[] da) {

		double min;

		// TODO - START
		min = da[0];
		for(double e : da) {
			if(e < min) {
				min = e;
			}
			
		}
		return min;

		//throw new UnsupportedOperationException(TODO.method());

		// TODO - SLUT

	}

	public static double[] getLatitudes(GPSPoint[] gpspoints) {

		// TODO - START
		double[] lat = new double[gpspoints.length];
		for(int i = 0; i < gpspoints.length; i++) {
			lat[i] = gpspoints[i].getLatitude(); 
		}
		return lat;
		//throw new UnsupportedOperationException(TODO.method());
		
		// TODO - SLUTT
	}

	public static double[] getLongitudes(GPSPoint[] gpspoints) {

		// TODO - START
		double[] lon = new double[gpspoints.length];
		for (int i = 0; i < gpspoints.length; i++) {
			lon[i] = gpspoints[i].getLongitude();
		}
		return lon;

		//throw new UnsupportedOperationException(TODO.method());
		
		// TODO - SLUTT

	}

	private static int R = 6371000; // jordens radius

	public static double distance(GPSPoint gpspoint1, GPSPoint gpspoint2) {

		double d;
		double latitude1, longitude1, latitude2, longitude2;

		// TODO - START
		
		latitude1 = gpspoint1.getLatitude();
		double r1 = toRadians(latitude1);
		latitude2 = gpspoint2.getLatitude();
		double r2 = toRadians(latitude2);
		
		longitude1 = (gpspoint1.getLongitude());
		longitude2 = (gpspoint2.getLongitude());
		double r3 = toRadians(longitude1);
		double r4 = toRadians(longitude2);
	
		double d1 = r2-r1;
		double d2 = r4-r3;
		
		
		double a = (pow(sin(d1/2),2)) + (cos(r1) * cos(r2) * (pow(sin(d2/2),2)));
		double c = 2*(atan2(sqrt(a),sqrt(1-a)));
		
		d = R * c;
		//System.out.println(d);
		return d;

		//throw new UnsupportedOperationException(TODO.method());

		// TODO - SLUTT

	}

	public static double speed(GPSPoint gpspoint1, GPSPoint gpspoint2) {

		int secs;
		double speed;
		

		// TODO - START
		double d = (distance(gpspoint1,gpspoint2)*3.6);
		int tid1 = gpspoint1.getTime();
		int tid2 = gpspoint2.getTime();
		secs = tid2-tid1;
		speed = d / secs;
		return speed;
		
		
		//throw new UnsupportedOperationException(TODO.method());

		// TODO - SLUTT

	}

	public static String formatTime(int secs) {

		String timestr;
		String TIMESEP = ":";

		// TODO - START
		int h = secs / 3600;
		int m = (secs % 3600) / 60;
		int s = secs % 60;
	
		timestr = String.format("  %02d:%02d:%02d",h,m,s);
		
		return timestr;

		//throw new UnsupportedOperationException(TODO.method());
		
		// TODO - SLUTT

	}
	private static int TEXTWIDTH = 10;

	public static String formatDouble(double d) {

		String str;

		// TODO - START
		str = String.format("%10.2f",d);
		str = str.replace(',', '.');
		return str;

		//throw new UnsupportedOperationException(TODO.method());

		// TODO - SLUTT
		
	}
}
