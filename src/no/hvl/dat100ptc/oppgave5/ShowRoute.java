package no.hvl.dat100ptc.oppgave5;

import javax.swing.JOptionPane;

import easygraphics.EasyGraphics;
import no.hvl.dat100ptc.TODO;
import no.hvl.dat100ptc.oppgave1.GPSPoint;
import no.hvl.dat100ptc.oppgave3.GPSUtils;
import no.hvl.dat100ptc.oppgave4.GPSComputer;

public class ShowRoute extends EasyGraphics {

	private static int MARGIN = 50;
	private static int MAPXSIZE = 800;
	private static int MAPYSIZE = 800;

	private GPSPoint[] gpspoints;
	private GPSComputer gpscomputer;
	
	public ShowRoute() {

		String filename = JOptionPane.showInputDialog("GPS data filnavn: ");
		gpscomputer = new GPSComputer(filename);

		gpspoints = gpscomputer.getGPSPoints();

	}

	public static void main(String[] args) {
		launch(args);
	}

	public void run() {

		makeWindow("Route", MAPXSIZE + 2 * MARGIN, MAPYSIZE + 2 * MARGIN);

		showRouteMap(MARGIN + MAPYSIZE);

		playRoute(MARGIN + MAPYSIZE);
		
		showStatistics();
	}

	// antall x-pixels per lengdegrad
	public double xstep() {

		double maxlon = GPSUtils.findMax(GPSUtils.getLongitudes(gpspoints));
		double minlon = GPSUtils.findMin(GPSUtils.getLongitudes(gpspoints));

		double xstep = MAPXSIZE / (Math.abs(maxlon - minlon)); //bruker math.abs for å få til pluss fra minus, så mapsize delt på max longitude - min longitude.

		return xstep;
	}

	// antall y-pixels per breddegrad
	public double ystep() {
	
		double ystep;
		
		// TODO - START
		double maxl = GPSUtils.findMax(GPSUtils.getLatitudes(gpspoints));
		double minl = GPSUtils.findMin(GPSUtils.getLatitudes(gpspoints));
		ystep = MAPYSIZE / (Math.abs(maxl - minl)); //størrelsen på "map" y-størrelsen, delt på maks lat - min lat, math.abs for å få til pluss (fra minus).
		return ystep;
		
		//throw new UnsupportedOperationException(TODO.method());

		// TODO - SLUTT
		
	}

	public void showRouteMap(int ybase) {

		// TODO - START
		double xstep = xstep(); 
		double ystep = ystep();
		
		double maxlong = GPSUtils.findMax(GPSUtils.getLongitudes(gpspoints));
		double minlat = GPSUtils.findMin(GPSUtils.getLatitudes(gpspoints));
		double minlong = GPSUtils.findMin(GPSUtils.getLongitudes(gpspoints));
		
		setColor(0,255,0);
		
		System.out.println("xstep: " + xstep);
		System.out.println("ystep: " + ystep);
		System.out.println("maxlong: " + maxlong);
		System.out.println("minlat: " + minlat);
		
		
		/*for (int i = 0; i < gpspoints.length; i++) {
			int x;
			int y;
			x = (int) (gpspoints[i].getLongitude()/xstep); //finne longituden å dele på piksel per lengdegrad
			y = (int) (gpspoints[i].getLatitude()/ystep); //finne latituden å dele på piksel per breddegrad
			
			drawCircle(x,ybase-y,2); //må først finne x punkta, som er longituden, deretter finne latitude som er y, radius 2.
		}*/
		for(GPSPoint i : gpspoints) {
			int x1 = (int) ((i.getLongitude()-minlong)*xstep);
			int y1 = (int) ((i.getLatitude()-minlat)*ystep);
			fillCircle(x1,ybase-y1,6);
		//throw new UnsupportedOperationException(TODO.method());
		}
		// TODO - SLUTT
	}

	public void showStatistics() {

		int TEXTDISTANCE = 20;

		setColor(0,0,0);
		setFont("Courier",12);
		
		// TODO - START
		drawString(String.format("Total time     :  ", GPSUtils.formatTime(gpscomputer.totalTime())),20,40);
		drawString(String.format("Total distance :  %.2f", gpscomputer.totalDistance()/1000) + " km ",20,60);
		drawString(String.format("Total elevation:  %.2f", gpscomputer.totalElevation()) + " m ",20,80);
		drawString(String.format("Max speed      :  %.2f", gpscomputer.maxSpeed()) + " km/t ",20,100);
		drawString(String.format("Average speed  :  %.2f", gpscomputer.averageSpeed()) + " km/t ",20,120);
		drawString(String.format("Energy         :  %.2f", gpscomputer.totalKcal(80)) + " kcal ",20,140);
		
		//throw new UnsupportedOperationException(TODO.method());
		
		// TODO - SLUTT;
	}

	public void playRoute(int ybase) {

		// TODO - START
		double minlong = GPSUtils.findMin(GPSUtils.getLongitudes(gpspoints));
		double minlat = GPSUtils.findMin(GPSUtils.getLatitudes(gpspoints));
		
		setColor(0,0,255);
		
		double ystep = ystep();
		double xstep = xstep();
		
		
		
		int y =  MARGIN + (int) ((gpspoints[0].getLongitude()-minlong)*ystep);
		int x =  ybase + (int) ((gpspoints[0].getLatitude()-minlat)*xstep);
		int syklrut = fillCircle(x,y,6);
		
		/*for(int i = 0; i < gpspoints.length; i++) {
			x = MARGIN + (int) ((gpspoints[i].getLongitude()-minlong)*xstep);
			y = ybase + (int) ((gpspoints[i].getLatitude()-minlat)*ystep);
			setColor(0,0,255);
			syklrut = fillCircle(x,ybase-y,6);
			*/
		for(GPSPoint i : gpspoints) {
			int x1 = (int) ((i.getLongitude()-minlong)/xstep);
			int y1 = (int) ((i.getLatitude()-minlat)/ystep);
			fillCircle(x1,ybase-y1,6);
		}
		
		
		//throw new UnsupportedOperationException(TODO.method());
		
		// TODO - SLUTT
	}

}
