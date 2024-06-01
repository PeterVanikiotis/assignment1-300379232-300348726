8// This file contains material supporting section 2.9 of the textbook:
// "Object Oriented Software Engineering" and is issued under the open-source
// license found at http://www.site.uottawa.ca/school/research/lloseng/

import java.io.*;

import java.util.Random;

import java.util.Scanner;



/**

 * This class prompts the user for a set of coordinates, and then 

 * converts them from polar to cartesian or vice-versa.

 *

 * @author Fran&ccedil;ois B&eacute;langer

 * @author Dr Timothy C. Lethbridge

 * @author Paul Holden

 * @version July 2000

 */

public class PointCPTest{
  //Class methods *****************************************************
  /**
   * This method is responsible for the creation of the PointCP
   * object.  This can be done in two ways; the first, by using the
   * command line and running the program using <code> java 
   * PointCPTest &lt;coordtype (c/p)&gt; &lt;X/RHO&gt; &lt;Y/THETA&gt;
   * </code> and the second by getting the program to prompt the user.
   * If the user does not enter a valid sequence at the command line,
   * the program will prompte him or her.
   *
   * @param args[0] The coordinate type.  P for polar and C for
   *                cartesian.
   * @param args[1] The value of X or RHO.
   * @param args[2] The value of Y or THETA.
   */

  public static void main(String[] args)
  {
    PointCP point;
	
    System.out.println("Cartesian-Polar Coordinates Conversion Program");

    // Check if the user input coordinates from the command line
    // If he did, create the PointCP object from these arguments.
    // If he did not, prompt the user for them.

    try
    {
      point = new PointCP(args[0].toUpperCase().charAt(0), 
        Double.valueOf(args[1]).doubleValue(), 
        Double.valueOf(args[2]).doubleValue());
    }

    catch(Exception e)
    {
      // If we arrive here, it is because either there were no
      // command line arguments, or they were invalid

      if(args.length != 0)
        System.out.println("Invalid arguments on command line");

      try
      {
        point = getInput();
      }
      catch(IOException ex)
      {
        System.out.println("Error getting input. Ending program.");
        return;
      }
    }

    System.out.println("\nYou entered:\n" + point);
    point.convertStorageToCartesian();
    System.out.println("\nAfter asking to store as Cartesian:\n" + point);
    point.convertStorageToPolar();
    System.out.println("\nAfter asking to store as Polar:\n" + point);
	
	System.out.println("----------------------------------");
	System.out.println("Testing PointCP2");
	
	Scanner polarCoordinates = new Scanner(System.in);
	System.out.println("Enter Rho, then Theta: ");
	double Rho = polarCoordinates.nextDouble();
	double Theta = polarCoordinates.nextDouble();

	PointCP2 polarPoint = new PointCP2(Rho, Theta);
	System.out.println("\nYou entered:\n" + polarPoint);
	System.out.println("\nHere is the Coordinate in cartesian coordinates:\n" + "( " + polarPoint.getX() + "," + polarPoint.getY() + ")");
	System.out.println("\nHere is the Coordinate in polar coordinates:\n" + "( " + polarPoint.getRho() + "," + polarPoint.getTheta() + ")");

	Scanner otherPoint = new Scanner(System.in);
	System.out.println("\nEnter another polar coordinate: ");
	double otherRho = otherPoint.nextDouble();
	double otherTheta = otherPoint.nextDouble();
	PointCP2 otherPolarPoint = new PointCP2(otherRho, otherTheta);
	double distance = polarPoint.getDistance(otherPolarPoint);
	System.out.println("\nThe distance between your first point and your new point is: " + distance);	

	System.out.println("----------------------------------");
	System.out.println("Testing PointCP3");

	Scanner cartesianCoordinates = new Scanner(System.in);
	System.out.println("Enter x, then y: ");
	double x = cartesianCoordinates.nextDouble();
	double y = cartesianCoordinates.nextDouble();

	PointCP3 cartesianPoint = new PointCP3(x, y);
	System.out.println("\nYou entered:\n" + cartesianPoint);
	System.out.println("\nHere is the Coordinate in cartesian coordinates:\n" + "( " + cartesianPoint.getX() + "," + cartesianPoint.getY() + ")");
	System.out.println("\nHere is the Coordinate in polar coordinates:\n" + "( " + cartesianPoint.getRho() + "," + cartesianPoint.getTheta() + ")");

	Scanner otherPoint2 = new Scanner(System.in);
	System.out.println("\nEnter another cartesian coordinate: ");
	double otherX = otherPoint2.nextDouble();
	double otherY = otherPoint2.nextDouble();
	PointCP2 otherCartesianPoint = new PointCP2(otherX, otherY);
	double distance2 = cartesianPoint.getDistance(otherCartesianPoint);
	System.out.println("\nThe distance between your first point and your new point is: " + distance2);

	System.out.println("----------------------------------");
	System.out.println("Testing Polar Coordinate PointCP5");

	Scanner polarInstanceCoordinates = new Scanner(System.in);
	System.out.println("Enter Rho, then Theta: ");
	double instanceRho = polarInstanceCoordinates.nextDouble();
	double instanceTheta = polarInstanceCoordinates.nextDouble();

	PointCP5 polarInstancePoint = new PointCP2(instanceRho, instanceTheta);
	System.out.println("\nYou entered:\n" + polarInstancePoint);
	System.out.println("\nHere is the Coordinate in cartesian coordinates:\n" + "( " + polarInstancePoint.getX() + "," + polarInstancePoint.getY() + ")");
	System.out.println("\nHere is the Coordinate in polar coordinates:\n" + "( " + polarInstancePoint.getRho() + "," + polarInstancePoint.getTheta() + ")");	

	Scanner otherPoint3 = new Scanner(System.in);
	System.out.println("\nEnter another polar coordinate: ");
	double otherInstanceRho = otherPoint3.nextDouble();
	double otherInstanceTheta = otherPoint3.nextDouble();
	PointCP5 otherInstancePolarPoint = new PointCP2(otherInstanceRho, otherInstanceTheta);
	double distance3 = cartesianPoint.getDistance(otherInstancePolarPoint);
	System.out.println("\nThe distance between your first point and your new point is: " + distance3);	

	System.out.println("----------------------------------");
	System.out.println("Testing Cartesian Coordinate PointCP5");
	Scanner cartesianInstanceCoordinates = new Scanner(System.in);

	System.out.println("Enter x, then y: ");
	double instanceX = cartesianInstanceCoordinates.nextDouble();
	double instanceY = cartesianInstanceCoordinates.nextDouble();

	PointCP5 cartesianInstancePoint = new PointCP3(instanceX, instanceY);
	System.out.println("\nYou entered:\n" + cartesianInstancePoint);
	System.out.println("\nHere is the Coordinate in cartesian coordinates:\n" + "( " + cartesianInstancePoint.getX() + "," + cartesianInstancePoint.getY() + ")");
	System.out.println("\nHere is the Coordinate in polar coordinates:\n" + "( " + cartesianInstancePoint.getRho() + "," + cartesianInstancePoint.getTheta() + ")");

	Scanner otherPoint4 = new Scanner(System.in);
	System.out.println("\nEnter another cartesian coordinate: ");
	double otherInstanceX = otherPoint3.nextDouble();
	double otherInstanceY = otherPoint3.nextDouble();
	PointCP5 otherInstanceCartesianPoint = new PointCP2(otherInstanceX, otherInstanceY);
	double distance4 = cartesianPoint.getDistance(otherInstanceCartesianPoint);
	System.out.println("\nThe distance between your first point and your new point is: " + distance4);

	final int numInstances = 10000;
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

  /**
   * This method obtains input from the user and verifies that
   * it is valid.  When the input is valid, it returns a PointCP
   * object.
   *
   * @return A PointCP constructed using information obtained 
   *         from the user.
   * @throws IOException If there is an error getting input from
   *         the user.
   */
  private static PointCP getInput() throws IOException
  {
    byte[] buffer = new byte[1024];  //Buffer to hold byte input
    boolean isOK = false;  // Flag set if input correct
    String theInput = "";  // Input information
    
    //Information to be passed to the constructor
    char coordType = 'A'; // Temporary default, to be set to P or C
    double a = 0.0;
    double b = 0.0;

    // Allow the user to enter the three different arguments
    for (int i = 0; i < 3; i++)
    {
      while (!(isOK))
      {
        isOK = true;  //flag set to true assuming input will be valid
          
        // Prompt the user
        if (i == 0) // First argument - type of coordinates
        {
          System.out.print("Enter the type of Coordinates you "
            + "are inputting ((C)artesian / (P)olar): ");
        }
        else // Second and third arguments
        {
          System.out.print("Enter the value of " 
            + (coordType == 'C' 
              ? (i == 1 ? "X " : "Y ")
              : (i == 1 ? "Rho " : "Theta ")) 
            + "using a decimal point(.): ");
        }

        // Get the user's input      
       
        // Initialize the buffer before we read the input
        for(int k=0; k<1024; k++)
        	buffer[k] = '\u0020';        
             
        System.in.read(buffer);
        theInput = new String(buffer).trim();
        
        // Verify the user's input
        try
        {
          if (i == 0) // First argument -- type of coordinates
          {
            if (!((theInput.toUpperCase().charAt(0) == 'C') 
              || (theInput.toUpperCase().charAt(0) == 'P')))
            {
              //Invalid input, reset flag so user is prompted again
              isOK = false;
            }
            else
            {
              coordType = theInput.toUpperCase().charAt(0);
            }
          }
          else  // Second and third arguments
          {
            //Convert the input to double values
            if (i == 1)
              a = Double.valueOf(theInput).doubleValue();
            else
              b = Double.valueOf(theInput).doubleValue();
          }
        }
        catch(Exception e)
        {
        	System.out.println("Incorrect input");
        	isOK = false;  //Reset flag as so not to end while loop
        }
      }

      //Reset flag so while loop will prompt for other arguments
      isOK = false;
    }
    //Return a new PointCP object
    return (new PointCP(coordType, a, b));
  }
}
