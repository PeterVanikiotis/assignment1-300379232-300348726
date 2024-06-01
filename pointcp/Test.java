import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        final int numInstances = 1000000;
        Random random = new Random();

        // Variables to store the time for each method
        long durationGetX = 0;
        long durationGetY = 0;
        long durationGetRho = 0;
        long durationGetTheta = 0;
        long durationConvertToCartesian = 0;
        long durationConvertToPolar = 0;

        // Design 1 Performance
        long startTime, endTime;
        
        for (int i = 0; i < numInstances; i++) {
            double coord1 = random.nextDouble();
            double coord2 = random.nextDouble();
            
            PointCP point = new PointCP(random.nextBoolean() ? 'C' : 'P', coord1, coord2);

            startTime = System.nanoTime();
            point.getX();
            endTime = System.nanoTime();
            durationGetX += (endTime - startTime);

            startTime = System.nanoTime();
            point.getY();
            endTime = System.nanoTime();
            durationGetY += (endTime - startTime);

            startTime = System.nanoTime();
            point.getRho();
            endTime = System.nanoTime();
            durationGetRho += (endTime - startTime);

            startTime = System.nanoTime();
            point.getTheta();
            endTime = System.nanoTime();
            durationGetTheta += (endTime - startTime);

            startTime = System.nanoTime();
            point.convertStorageToCartesian();
            endTime = System.nanoTime();
            durationConvertToCartesian += (endTime - startTime);

            startTime = System.nanoTime();
            point.convertStorageToPolar();
            endTime = System.nanoTime();
            durationConvertToPolar += (endTime - startTime);
        }

        System.out.println("Design 1 Performance (average time per method call in ns):");
        System.out.println("getX: " + durationGetX / numInstances);
        System.out.println("getY: " + durationGetY / numInstances);
        System.out.println("getRho: " + durationGetRho / numInstances);
        System.out.println("getTheta: " + durationGetTheta / numInstances);
        System.out.println("convertToCartesian: " + durationConvertToCartesian / numInstances);
        System.out.println("convertToPolar: " + durationConvertToPolar / numInstances);

        // Design 5 Performance (subclass for Polar)
        durationGetX = durationGetY = durationGetRho = durationGetTheta = durationConvertToCartesian = durationConvertToPolar = 0;

        for (int i = 0; i < numInstances; i++) {
            double rho = random.nextDouble();
            double theta = random.nextDouble();

            PointCP5 polarpoint = new PointCP2(rho, theta);

            startTime = System.nanoTime();
            polarpoint.getX();
            endTime = System.nanoTime();
            durationGetX += (endTime - startTime);

            startTime = System.nanoTime();
            polarpoint.getY();
            endTime = System.nanoTime();
            durationGetY += (endTime - startTime);

            startTime = System.nanoTime();
            polarpoint.getRho();
            endTime = System.nanoTime();
            durationGetRho += (endTime - startTime);

            startTime = System.nanoTime();
            polarpoint.getTheta();
            endTime = System.nanoTime();
            durationGetTheta += (endTime - startTime);

            startTime = System.nanoTime();
            polarpoint.convertStorageToCartesian();
            endTime = System.nanoTime();
            durationConvertToCartesian += (endTime - startTime);

            startTime = System.nanoTime();
            polarpoint.convertStorageToPolar();
            endTime = System.nanoTime();
            durationConvertToPolar += (endTime - startTime);
        }

        System.out.println("\nDesign 5 Performance (Polar subclass, average time per method call in ns):");
        System.out.println("getX: " + durationGetX / numInstances);
        System.out.println("getY: " + durationGetY / numInstances);
        System.out.println("getRho: " + durationGetRho / numInstances);
        System.out.println("getTheta: " + durationGetTheta / numInstances);
        System.out.println("convertToCartesian: " + durationConvertToCartesian / numInstances);
        System.out.println("convertToPolar: " + durationConvertToPolar / numInstances);

        // Design 5 Performance (subclass for Cartesian)
        durationGetX = durationGetY = durationGetRho = durationGetTheta = durationConvertToCartesian = durationConvertToPolar = 0;

        for (int i = 0; i < numInstances; i++) {
            double x1 = random.nextDouble();
            double y1 = random.nextDouble();

            PointCP5 cartesianpoint = new PointCP3(x1, y1);

            startTime = System.nanoTime();
            cartesianpoint.getX();
            endTime = System.nanoTime();
            durationGetX += (endTime - startTime);

            startTime = System.nanoTime();
            cartesianpoint.getY();
            endTime = System.nanoTime();
            durationGetY += (endTime - startTime);

            startTime = System.nanoTime();
            cartesianpoint.getRho();
            endTime = System.nanoTime();
            durationGetRho += (endTime - startTime);

            startTime = System.nanoTime();
            cartesianpoint.getTheta();
            endTime = System.nanoTime();
            durationGetTheta += (endTime - startTime);

            startTime = System.nanoTime();
            cartesianpoint.convertStorageToCartesian();
            endTime = System.nanoTime();
            durationConvertToCartesian += (endTime - startTime);

            startTime = System.nanoTime();
            cartesianpoint.convertStorageToPolar();
            endTime = System.nanoTime();
            durationConvertToPolar += (endTime - startTime);
        }

        System.out.println("\nDesign 5 Performance (Cartesian subclass, average time per method call in ns):");
        System.out.println("getX: " + durationGetX / numInstances);
        System.out.println("getY: " + durationGetY / numInstances);
        System.out.println("getRho: " + durationGetRho / numInstances);
        System.out.println("getTheta: " + durationGetTheta / numInstances);
        System.out.println("convertToCartesian: " + durationConvertToCartesian / numInstances);
        System.out.println("convertToPolar: " + durationConvertToPolar / numInstances);
    }
}
