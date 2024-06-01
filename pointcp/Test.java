package Test;

import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class Test{
	public static void main(String[] args) {
		final int numInstances = 1000000;
	    Random random = new Random();

	    // Design 1 Performance

	    long startTime = System.nanoTime();

	    for (int i = 0; i < numInstances; i++) {

	        double coord1 = random.nextDouble();
	        double coord2 = random.nextDouble();

	        PointCP point1 = new PointCP(random.nextBoolean() ? 'C' : 'P',coord1, coord2);
	        point1.getX();
	        point1.getY();
	        point1.getRho();
	        point1.getTheta();
			point1.convertStorageToCartesian();
			point1.convertStorageToPolar();
	    }
		
	    long endTime = System.nanoTime();
	    long durationDesign1 = (endTime - startTime) / 10000; // computing average milliseconds

		// Design 5 Performance (subclass for Polar)

	    startTime = System.nanoTime();

	    for (int i = 0; i < numInstances; i++) {
	        double rho = random.nextDouble();
	        double theta = random.nextDouble();

	        PointCP5 polarPoint1 = new PointCP2(rho, theta);
	        polarPoint1.getX();
	        polarPoint1.getY();
	        polarPoint1.getRho();
	        polarPoint1.getTheta();
			polarPoint1.convertStorageToCartesian();
			polarPoint1.convertStorageToPolar();
	    }

	    endTime = System.nanoTime();
	    long durationDesign5Polar = (endTime - startTime) / 10000; // computing average milliseconds

		// Design 5 Performance (subclass for Cartesian)

	    startTime = System.nanoTime();

	    for (int i = 0; i < numInstances; i++) {
	        double x1 = random.nextDouble();
	        double y1 = random.nextDouble();

	        PointCP5 cartesianPoint1 = new PointCP3(x1, y1);
	        cartesianPoint1.getX();
	        cartesianPoint1.getY();
	        cartesianPoint1.getRho();
	        cartesianPoint1.getTheta();
			cartesianPoint1.convertStorageToCartesian();
			cartesianPoint1.convertStorageToPolar();
	    }

	    endTime = System.nanoTime();
		long durationDesign5Cartesian = (endTime - startTime) / 10000; // computing average milliseconds

	    // Output results
	    System.out.println("Performance (ms):");
	    System.out.println("Design 1: " + durationDesign1);
	    System.out.println("Design 5 (Cartesian): " + durationDesign5Cartesian);
	    System.out.println("Design 5 (Polar): " + durationDesign5Polar);
	}
}
