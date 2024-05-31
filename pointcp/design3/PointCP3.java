public class PointCP3 extends PointCP5 {
  //Instance variables ************************************************
  
  /**
   * Contains the current value of X or RHO depending on the type
   * of coordinates.
   */
  private double x;
  
  /**
   * Contains the current value of Y or THETA value depending on the
   * type of coordinates.
   */
  private double y;
	
  
  //Constructors ******************************************************

  /**
   * Constructs a coordinate object, with a type identifier.
   */
  public PointCP3(double x, double y){
    this.xOrRho = x;
    this.yOrTheta = y;
  }
	
  
  //Instance methods **************************************************
 
 
  public double getX(){
	return x;
  }
  
  public double getY(){
	return y;
  }
  
  public double getRho(){
      return (Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2)));
  }
  
  public double getTheta(){
      return Math.toDegrees(Math.atan2(y, x));
  }
  
	
  /**
   * Converts Cartesian coordinates to Polar coordinates.
   */
  public void convertStorageToPolar(){
    PointCP3 p = new PointCP3(x,y);
	double coordinate1 = p.getRho();
	double coordinate2 = p.getTheta();
  }
	
  /**
   * Converts Polar coordinates to Cartesian coordinates.
   */
  public void convertStorageToCartesian(){
    return;
  }

  /**
   * Rotates the specified point by the specified number of degrees.
   * Not required until E2.30
   *
   * @param point The point to rotate
   * @param rotation The number of degrees to rotate the point.
   * @return The rotated image of the original point.
   */
  public PointCP3 rotatePoint(double rotation){
    double radRotation = Math.toRadians(rotation);
    double X = getX();
    double Y = getY();
        
    return new PointCP3('C',
      (Math.cos(radRotation) * X) - (Math.sin(radRotation) * Y),
      (Math.sin(radRotation) * X) + (Math.cos(radRotation) * Y));
  }

  /**
   * Returns information about the coordinates.
   *
   * @return A String containing information about the coordinates.
   */
  public String toString(){
    return "Stored as Cartesian  (" + getX() + "," + getY() + ")"
  }
}
