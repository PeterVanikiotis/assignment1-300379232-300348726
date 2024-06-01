public class PointCP2 extends PointCP5{

  //Instance variables ************************************************
  /**
   * Contains the current value of RHO 
   */

  private double Rho;

  /**
   * Contains the current value of THETA 
   */

  private double Theta;

  //Constructors ******************************************************
  /**
   * Constructs a coordinate object, with a type identifier.
   */

  public PointCP2(double Rho, double Theta){
    this.Rho = Rho;
    this.Theta = Theta;
  }
  
  //Instance methods **************************************************

	public double getX(){
		return (Math.cos(Math.toRadians(Theta)) * Rho);
    }

	public double getY(){
		return (Math.sin(Math.toRadians(Theta)) * Rho);
    }

    public double getRho(){
		return Rho;
    }

  public double getTheta(){
		return Theta;
    }

  /**
   * Converts Cartesian coordinates to Polar coordinates.
   */

  public void convertStorageToPolar(){
	  return;
  }
  
  /**
   * Converts Polar coordinates to Cartesian coordinates.
   */

  public void convertStorageToCartesian(){	
	PointCP2 p = new PointCP2(Rho, Theta);
	double coordinate1 = p.getX();
	double coordinate2 = p.getY();
  }	

  /**
   * Rotates the specified point by the specified number of degrees.
   * Not required until E2.30
   *
   * @param point The point to rotate
   * @param rotation The number of degrees to rotate the point.
   * @return The rotated image of the original point.
   */

  public PointCP2 rotatePoint(double rotation){

    double radRotation = Math.toRadians(rotation);
    double X = getX();
    double Y = getY();

	double resultX = Math.cos(radRotation) * X - (Math.sin(radRotation) * Y);
	double resultY = Math.sin(radRotation) * X + (Math.cos(radRotation) * Y);

	double polarX = Math.sqrt(Math.pow(resultX, 2) + Math.pow(resultY, 2));
	double polarY = Math.toDegrees(Math.atan2(resultY, resultX));
	
    return new PointCP2(polarX, polarY);
  }

  /**
   * Returns information about the coordinates.
   *
   * @return A String containing information about the coordinates.
   */
  public String toString(){
    return "Stored as Polar [" + getRho() + "," + getTheta() + "]" + "\n";
  }
}